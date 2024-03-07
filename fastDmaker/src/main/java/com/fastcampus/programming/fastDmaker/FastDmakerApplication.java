package com.fastcampus.programming.fastDmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 추가로 애너테이션 정보 알아볼것!!
@SpringBootApplication
public class FastDmakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastDmakerApplication.class, args);
	}

}
