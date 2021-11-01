package com.cepheid.cloud.skel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cepheid.cloud.skel.controller.ItemController;
import com.cepheid.cloud.skel.model.Description;
import com.cepheid.cloud.skel.model.Item;
import com.cepheid.cloud.skel.repository.DescriptionRepository;
import com.cepheid.cloud.skel.repository.ItemRepository;

@SpringBootApplication(scanBasePackageClasses = { ItemController.class, SkelApplication.class })
@EnableJpaAuditing
@EnableJpaRepositories(basePackageClasses = { ItemRepository.class })
public class SkelApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false"); // fixing debug error
		SpringApplication.run(SkelApplication.class, args);
	}

	@Bean
	ApplicationRunner initItems(ItemRepository repository, DescriptionRepository descriptionRepository) {
		List<Description> descriptions=new ArrayList<Description>();
		Description description1 = new Description("series-1");
		descriptions.add(description1);
		
		//descriptionRepository.save(description1);

		return args -> {
			Stream.of("Lord of the rings").forEach(name -> {
				Item item = new Item();
				item.setName(name);
				item.setBarcode(21316);
				item.setDescriptions(descriptions);
				item.setState("undefined");// undefined, valid, invalid
				repository.save(item);
			});
			repository.findAll().forEach(System.out::println);
		};
	}

}
