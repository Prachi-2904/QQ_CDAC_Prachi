package com.app.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ContentResponseDto;
import com.app.services.ContentTranslateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/extractor")
@RequiredArgsConstructor
@Validated
public class ContentTranslateController {

	ContentTranslateService service;
	public ContentTranslateController(ContentTranslateService _service) {
		this.service = _service;
	}
	 @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ContentResponseDto> classify(@Valid @NotNull @RequestParam("file") final MultipartFile pdfFile) {
	        return ResponseEntity.ok().body(ContentResponseDto.builder().content(this.service.extractContent(pdfFile)).build());
	    }

}
