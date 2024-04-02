package com.app.services;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContentTranslateService {

	public String extractContent(@Valid @NotNull MultipartFile pdfFile) {
		
		 String text;

	        try (final PDDocument document = PDDocument.load(pdfFile.getInputStream())) {
	            final PDFTextStripper pdfStripper = new PDFTextStripper();
	            text = pdfStripper.getText(document);
	        } catch (final Exception ex) {
	           ex.printStackTrace();
	            text = "Error parsing PDF";
	        }

	        return text;
	}

}
