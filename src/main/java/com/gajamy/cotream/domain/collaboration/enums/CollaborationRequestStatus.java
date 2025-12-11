package com.gajamy.cotream.domain.collaboration.enums;

public enum CollaborationRequestStatus {
    PENDING("대기 중"),
    ACCEPTED("수락"),
    REJECTED("거절");

    CollaborationRequestStatus(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }
}
