package com.example.project.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@ToString
public class UpdateProviderRequest {
    private final String name;
    private final Boolean isCompany;
    private final Boolean approved;

    public String getName() {
        return name;
    }

    public Boolean getCompany() {
        return isCompany;
    }

    public Boolean getApproved() {
        return approved;
    }

    @Override
    public String toString() {
        return "UpdateProviderRequest{" +
                "name='" + name + '\'' +
                ", isCompany=" + isCompany +
                ", approved=" + approved +
                '}';
    }
}


