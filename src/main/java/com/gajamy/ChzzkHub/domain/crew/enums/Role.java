package com.gajamy.ChzzkHub.domain.crew.enums;

public enum Role {
    READER("크루 리더"),
    MEMBER("크루 멤버");

    private String name;

    Role(String string) {
        this.name = string;
    }

    public String getName() {
        return name;
    }
}
