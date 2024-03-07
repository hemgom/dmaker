package com.fastcampus.programming.fastDmaker.entity;

import com.fastcampus.programming.fastDmaker.code.StatusCode;
import com.fastcampus.programming.fastDmaker.type.DeveloperLevel;
import com.fastcampus.programming.fastDmaker.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder // 아래 두 애너테이션은 @Builder의 짝꿍이라고 봄!
@NoArgsConstructor
@AllArgsConstructor
@Entity // entity로 쓰기 위해
@EntityListeners(AuditingEntityListener.class)
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long id;

    @Enumerated(EnumType.STRING)
    private DeveloperLevel developerLevel;

    @Enumerated(EnumType.STRING)
    private DeveloperSkillType developerSkillType;

    private Integer experienceYears;
    private String memberId;
    private String name;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private StatusCode statusCode;

    // 아래 두 애너테이션 알아볼것!
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
