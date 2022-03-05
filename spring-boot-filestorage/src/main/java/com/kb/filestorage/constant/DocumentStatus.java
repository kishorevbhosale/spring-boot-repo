package com.kb.filestorage.constant;

public enum DocumentStatus {
    UPLOADED,
    SOFT_DELETED,
    ARCHIVED;

    @Override
    public String toString() {
        return this.name();
    }
}
