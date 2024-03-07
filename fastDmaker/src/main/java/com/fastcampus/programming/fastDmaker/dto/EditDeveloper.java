package com.fastcampus.programming.fastDmaker.dto;

import com.fastcampus.programming.fastDmaker.entity.Developer;
import com.fastcampus.programming.fastDmaker.type.DeveloperLevel;
import com.fastcampus.programming.fastDmaker.type.DeveloperSkillType;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditDeveloper {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request {
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0)
        @Max(20)
        private  Integer experienceYears;

        @Min(18)
        private Integer age;
    }
}
