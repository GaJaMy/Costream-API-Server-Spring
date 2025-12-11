package com.gajamy.cotream.domain.collaboration.enums;

public enum CollaborationStatus {
    RECRUITING("모집 중"),   // 모집 중
    IN_PROGRESS("진행 중"),  // 진행 중
    ENDED("합방 종료"),        // 합방 종료
    CANCELED("취소 됨");      // 취소됨

    private String description;

    CollaborationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
