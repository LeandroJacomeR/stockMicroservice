package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.controller;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddCategoryRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.BrandResponse;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.response.CategoryResponse;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.ICategoryHandler;
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
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestController {
    private final ICategoryHandler categoryHandler;

    @Operation(summary = ADD_NEW_CATEGORY,
            responses = {
                    @ApiResponse(responseCode = HTTP_CODE_CREATED, description = CATEGORY_CREATED,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(ref = SCHEMA_COMPONENTS_MAP))),
                    @ApiResponse(responseCode = HTTP_CODE_CONFLICT, description = CATEGORY_ALREADY_EXISTS,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(ref = SCHEMA_COMPONENTS_ERROR)))})
    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveCategory(@Valid @RequestBody AddCategoryRequest addCategoryRequest) {
        categoryHandler.saveCategory(addCategoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.CATEGORY_CREATED_MESSAGE));
    }

    @Operation(summary = CATEGORY_GET_ALL,
            responses = {
                    @ApiResponse(responseCode = HTTP_CODE_OK, description = CATEGORY_GET_ALL,
                            content = @Content(mediaType = MEDIA_TYPE_JSON,
                                    array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class)))),
                    @ApiResponse(responseCode = HTTP_NOT_FOUND, description = NO_DATA_FOUND,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(ref = SCHEMA_COMPONENTS_ERROR)))})
    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(
            @RequestParam(value = PARAM_VALUE_PAGE, defaultValue = PARAM_DEFAULT_VALUE_PAGE) int page,
            @RequestParam(value = PARAM_VALUE_ORDER, defaultValue = PARAM_DEFAULT_VALUE_ORDER) String order) {
        return ResponseEntity.ok(categoryHandler.getCategories(page, order));
    }

    @Operation(summary = CATEGORY_GET,
            responses = {
                    @ApiResponse(responseCode = HTTP_CODE_OK, description = CATEGORY_RETURNED,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(implementation = BrandResponse.class))),
                    @ApiResponse(responseCode = HTTP_NOT_FOUND, description = CATEGORY_NOT_FOUND,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(ref = SCHEMA_COMPONENTS_ERROR)))})
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryHandler.getCategory(id));
    }
}
