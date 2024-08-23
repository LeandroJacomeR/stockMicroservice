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

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandRestController {
    private final IBrandHandler brandHandler;

    @Operation(summary = "Add a new brand",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Brand created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Brand already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveBrand(@Valid @RequestBody AddBrandRequest addBrandRequest) {
        brandHandler.saveBrand(addBrandRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.BRAND_CREATED_MESSAGE));
    }

    @Operation(summary = "Get all the brands",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All brands returned",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = BrandResponse.class)))),
                    @ApiResponse(responseCode = "404", description = "No data found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("")
    public ResponseEntity<List<BrandResponse>> getAllBrands(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "order", defaultValue = "asc") String order) {
        return ResponseEntity.ok(brandHandler.getAllBrands(page, order));
    }

    @Operation(summary = "Get a brand",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Brand returned",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = BrandResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Brand not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getBrand(@PathVariable Long id) {
        return ResponseEntity.ok(brandHandler.getBrand(id));
    }
}
