package com.kb.filestorage.dto;

import com.kb.filestorage.entity.FileDB;
import org.springframework.stereotype.Component;

@Component
public class FileDBMapper {
    public FileDBDTO map(FileDB myDocument) {
        return FileDBDTO.builder()
                .id(myDocument.getId())
                .fileName(myDocument.getFileName())
                .fileSize(myDocument.getFileSize())
                .canDelete(myDocument.isMarkedForDeletion())
                .createdDate(myDocument.getCreatedDate())
                .build();
    }
}
