package com.kb.filestorage.entity;

import com.kb.filestorage.constant.DocumentStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;

@Builder
@Entity
@Table(name = "FILE_DB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    private Instant createdDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "content")
    @Lob
    private byte[] content;

    @Column(name = "document_status")
    @Enumerated(EnumType.STRING)
    private DocumentStatus documentStatus;

    @Column(name = "marked_for_deletion", nullable = false, columnDefinition = "number(1) default 0")
    private boolean markedForDeletion = false;
}
