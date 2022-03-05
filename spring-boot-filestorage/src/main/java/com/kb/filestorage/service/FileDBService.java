package com.kb.filestorage.service;

import com.kb.filestorage.constant.DocumentStatus;
import com.kb.filestorage.dto.FileDBDTO;
import com.kb.filestorage.dto.FileDBMapper;
import com.kb.filestorage.entity.FileDB;
import com.kb.filestorage.repository.FileDBRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileDBService {
    @Autowired
    FileDBRepository fileDBRepository;
    @Autowired
    FileDBMapper fileDBMapper;

    public Optional<FileDBDTO> saveDocument(MultipartFile file, String userId) throws IOException {
        FileDB fileData = FileDB.builder()
                .fileName(getFileNameWithTimeStamp(file.getOriginalFilename()))
                .fileSize(file.getSize())
                .userId(userId)
                .content(file.getBytes())
                .documentStatus(DocumentStatus.UPLOADED)
                .build();
        FileDB document = fileDBRepository.save(fileData);
        return Optional.of(fileDBMapper.map(document));
    }

    private String getFileNameWithTimeStamp(String originalFilename) {
        final String baseName = FilenameUtils.getBaseName(originalFilename);
        final String extension = FilenameUtils.getExtension(originalFilename);
        long timeStamp = System.currentTimeMillis();
        return baseName + "_" + timeStamp + "." + extension;
    }
}
