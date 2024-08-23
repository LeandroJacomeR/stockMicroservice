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
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestController {
    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Add a new category",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Category created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Category already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveCategory(@RequestBody AddCategoryRequest addCategoryRequest) {
        categoryHandler.saveCategory(addCategoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.CATEGORY_CREATED_MESSAGE));
    }

    @Operation(summary = "Get all the brands",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All categories returned",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class)))),
                    @ApiResponse(responseCode = "404", description = "No data found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "order", defaultValue = "asc") String order) {
        return ResponseEntity.ok(categoryHandler.getCategories(page, order));
    }

    @Operation(summary = "Get a category",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category returned",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = BrandResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Category not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryHandler.getCategory(id));
    }
}
