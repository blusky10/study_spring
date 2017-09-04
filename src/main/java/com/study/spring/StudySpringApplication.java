package com.study.spring;

import com.study.spring.account.repository.AccountRepository;
import com.study.spring.account.service.AccountService;
import com.study.spring.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.PrintStream;

@SpringBootApplication
public class StudySpringApplication {

    private static Logger logger = LoggerFactory.getLogger(StudySpringApplication.class);

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

	@Value("${server.port}")
    String serverPort;

	@Bean
    CommandLineRunner values(){
	    return args -> logger.info(" > Server Port : " + serverPort);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, AccountService accountService) throws Exception{

    	builder.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return new CustomUserDetails(accountService.get(username));
			}
		});
	}
}
