package com.study.srping;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class StudySpringApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StudySpringApplication.class);

		/**
		 * Boot Application 구동시 배너 설정
		 * banner.txt 파일을 클래스 패스에 넣어도 동작한다.
		 */
		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.print("이거다");
			}
		});
		app.run(args);

	}
}
