package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.controller;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddBrandRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.BrandResponse;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.IBrandHandler;
import com.bootcamp.pragma.stockmicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.bootcamp.pragma.stockmicroservice.configuration.Constants.*;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandRestController {
    private final IBrandHandler brandHandler;

    @Operation(summary = ADD_NEW_BRAND,
            responses = {
                    @ApiResponse(responseCode = HTTP_CODE_CREATED, description = BRAND_CREATED,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(ref = SCHEMA_COMPONENTS_MAP))),
                    @ApiResponse(responseCode = HTTP_CODE_CONFLICT, description = BRAND_ALREADY_EXISTS,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(ref = SCHEMA_COMPONENTS_ERROR)))})
    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveBrand(@Valid @RequestBody AddBrandRequest addBrandRequest) {
        brandHandler.saveBrand(addBrandRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.BRAND_CREATED_MESSAGE));
    }

    @Operation(summary = BRAND_GET_ALL,
            responses = {
                    @ApiResponse(responseCode = HTTP_CODE_OK, description = BRAND_ALL_RETURNED,
                            content = @Content(mediaType = MEDIA_TYPE_JSON,
                                    array = @ArraySchema(schema = @Schema(implementation = BrandResponse.class)))),
                    @ApiResponse(responseCode = HTTP_NOT_FOUND, description = NO_DATA_FOUND,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(ref = SCHEMA_COMPONENTS_ERROR)))})
    @GetMapping("")
    public ResponseEntity<List<BrandResponse>> getAllBrands(
            @RequestParam(value = PARAM_VALUE_PAGE, defaultValue = PARAM_DEFAULT_VALUE_PAGE) int page,
            @RequestParam(value = PARAM_VALUE_ORDER, defaultValue = PARAM_DEFAULT_VALUE_ORDER) String order) {
        return ResponseEntity.ok(brandHandler.getAllBrands(page, order));
    }

    @Operation(summary = BRAND_GET,
            responses = {
                    @ApiResponse(responseCode = HTTP_CODE_OK, description = BRAND_RETURNED,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(implementation = BrandResponse.class))),
                    @ApiResponse(responseCode = HTTP_NOT_FOUND, description = BRAND_NOT_FOUND,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(ref = SCHEMA_COMPONENTS_ERROR)))})
    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getBrand(@PathVariable Long id) {
        return ResponseEntity.ok(brandHandler.getBrand(id));
    }
}
