package com.example.demo;

import com.example.demo.mapper.RatePlanMapper;
import com.example.demo.model.Rateplans;
import com.example.demo.model.Todo;
import com.example.demo.repository.RatePlansRepository;
import com.example.demo.service.RestClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	private Logger log = LoggerFactory.getLogger(DemoApplication.class);

/*	@Bean
	public CommandLineRunner process(RestClientService client, RatePlansRepository ratePlansRepository){
		return args -> {
			log.info("000000000000");
			List<Todo> todos = client.findAllRatePlans();
			log.info("111111111111111");
			assert todos != null;
			log.info("2222222222222");
			todos.forEach(toDo -> log.info("33333333333" + toDo.getDescription()));
			log.info("44444444444");
			log.info(todos.get(0).toString());
			List<Rateplans> ratePlans = RatePlanMapper.MAPPER.toDoToratePlans(todos);
			log.info("55555555555");
			log.info(ratePlans.toString());
			log.info("66666666666");
			ratePlansRepository.saveAll(ratePlans);
			log.info("77777777777");

		};
	}*/
}
