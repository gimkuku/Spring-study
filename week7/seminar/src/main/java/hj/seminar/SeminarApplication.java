package hj.seminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class SeminarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeminarApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
