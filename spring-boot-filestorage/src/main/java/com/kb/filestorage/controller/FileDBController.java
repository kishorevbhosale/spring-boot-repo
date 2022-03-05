package com.kb.filestorage.controller;

import com.kb.filestorage.dto.FileDBDTO;
import com.kb.filestorage.service.FileDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class FileDBController {

    @Autowired
    private final FileDBService fileDBService;

    @PostMapping("/save/{userId}")
    public ResponseEntity<FileDBDTO> saveDocument(@RequestParam MultipartFile file,
                                                  @PathVariable String userId) throws IOException {
        Optional<FileDBDTO> documentDTO = fileDBService.saveDocument(file, userId);
        if (documentDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.of(documentDTO);
    }
}
