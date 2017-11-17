package com.study.spring;

import com.study.spring.account.service.AccountService;
import com.study.spring.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.PrintStream;

@SpringBootApplication
@EnableScheduling
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

//	@Value("${myqueue}")
//	String queue;
//
//	@Bean
//	Queue queue(){
//		return new Queue(queue, false);
//	}
//
//	@Autowired
//	Producer producer;
//
//    @Bean
//	CommandLineRunner sender(Producer producer){
//    	return args -> {
//    		producer.sendTo(queue, "Hello !!!");
//		};
//	}

//	@Scheduled(fixedDelay = 10000L)
//	public void sendScheduleMessage(){
//		producer.sendTo(queue, "Message Delevery : " + new Date());
//	}

//	@Value("${redisTopic}")
//	String redisTopic;
//
//	@Bean
//	CommandLineRunner sender(RedisProducer producer){
//    	return args -> {
//    		producer.sendTo(redisTopic, "Hello !!!");
//		};
//	}

    // 이부분을 사용하려면 ResourceSecurityConfiguration 과 CustomUserDetailService 파일을 주석처리한다
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
