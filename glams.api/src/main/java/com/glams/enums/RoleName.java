package com.glams.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum RoleName {

    ADMIN("admin"),
    PROVIDER("provider"),
    CLIENT("client");

    private final String value;

    RoleName(String value) {
        this.value = value;
    }

    @JsonCreator
    public static RoleName fromValue(String value) {
        for (RoleName role : RoleName.values()) {
            if (role.value.equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid RoleName: " + value);
    }

    @Override
    public String toString() {
        return value;
    }

}
