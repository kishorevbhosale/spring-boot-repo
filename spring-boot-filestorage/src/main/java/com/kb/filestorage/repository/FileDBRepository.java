package com.kb.filestorage.repository;

import com.kb.filestorage.entity.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDBRepository extends JpaRepository<FileDB, Long> {
}
