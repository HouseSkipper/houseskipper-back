package fr.univ.lorraine.houseSkipper;

import fr.univ.lorraine.houseSkipper.model.Task;
import fr.univ.lorraine.houseSkipper.repositories.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HouseSkipperApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(HouseSkipperApplication.class, args);
	}

	@Bean
	ApplicationRunner init(TaskRepository taskRepository, RoomRepository roomRepository, HouseRepository houseRepository, UserRepository userRepository, SkillRepository skillRepository) {

		roomRepository.deleteAll();
		houseRepository.deleteAll();
		taskRepository.deleteAll();
		userRepository.deleteAll();
		skillRepository.deleteAll();


		return args -> {
			Stream.of(
					new Task("X1", "X1","X1", new Date(), "En Attente"),
					new Task("X2", "X2","X2", new Date(), "En Attente"),
					new Task("X3", "X3","X3", new Date(), "En Attente"),
					new Task("X4", "X4","X4", new Date(), "En Attente")
			).forEach(task -> {
				taskRepository.save(task);
			});
			// Query database
			taskRepository.findAll().forEach(System.out::println);
		};
	}

}
