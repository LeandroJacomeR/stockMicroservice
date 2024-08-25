package com.bootcamp.pragma.stockmicroservice.adapters.driving.http.controller;

import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.dto.request.AddArticleRequest;
import com.bootcamp.pragma.stockmicroservice.adapters.driving.http.handler.impl.ArticleHandler;
import com.bootcamp.pragma.stockmicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

import static com.bootcamp.pragma.stockmicroservice.configuration.Constants.*;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestController {
    private final ArticleHandler articleHandler;

    @Operation(summary = ADD_NEW_ARTICLE,
            responses = {
                    @ApiResponse(responseCode = HTTP_CODE_CREATED, description = ARTICLE_CREATED,
                            content = @Content(mediaType = MEDIA_TYPE_JSON, schema = @Schema(ref = SCHEMA_COMPONENTS_MAP)))})
    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveArticle(@Valid @RequestBody AddArticleRequest addArticleRequest) {
        articleHandler.saveArticle(addArticleRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.ARTICLE_CREATED_MESSAGE));
    }
}
