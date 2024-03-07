package com.fastcampus.programming.fastDmaker.dto;

import com.fastcampus.programming.fastDmaker.entity.Developer;
import com.fastcampus.programming.fastDmaker.type.DeveloperLevel;
import com.fastcampus.programming.fastDmaker.type.DeveloperSkillType;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDto {
    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;
    private String memberId;

    public static DeveloperDto fromEntity(Developer developer) {
        return DeveloperDto.builder()
                .developerLevel(developer.getDeveloperLevel())
                .developerSkillType(developer.getDeveloperSkillType())
                .memberId(developer.getMemberId())
                .build();
    }
}
