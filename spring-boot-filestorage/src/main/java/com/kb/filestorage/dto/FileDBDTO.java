package com.kb.filestorage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import org.springframework.core.io.Resource;

import java.io.Serializable;
import java.time.Instant;

@Builder(toBuilder = true)
@Getter
@JsonDeserialize(builder = FileDBDTO.FileDBDTOBuilder.class)
public class FileDBDTO implements Serializable {
    private final Long id;
    private final String fileName;
    private final Long fileSize;
    private final Boolean canDelete;
    @JsonIgnore
    private final transient Resource content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant createdDate;

    @JsonPOJOBuilder(withPrefix = "")
    public static class FileDBDTOBuilder {
    }
}
