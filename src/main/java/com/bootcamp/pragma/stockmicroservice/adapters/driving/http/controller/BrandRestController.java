package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.controller;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddBrandRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.IBrandHandler;
import com.bootcamp.pragma.stockmicroservice.configuration.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandRestController {
    private final IBrandHandler brandHandler;

    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveBrand(@Valid @RequestBody AddBrandRequest addBrandRequest) {
        brandHandler.saveBrand(addBrandRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.BRAND_CREATED_MESSAGE));
    }
}
