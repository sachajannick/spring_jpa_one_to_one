package com.example.jpa_one_to_one_bidirectional;

import com.example.jpa_one_to_one_bidirectional.model.Car;
import com.example.jpa_one_to_one_bidirectional.model.Owner;
import com.example.jpa_one_to_one_bidirectional.repository.CarRepository;
import com.example.jpa_one_to_one_bidirectional.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class JpaOneToOneBidirectionalApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaOneToOneBidirectionalApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(JpaOneToOneBidirectionalApplication.class, args);

		CarRepository carRepository = configurableApplicationContext
				.getBean(CarRepository.class);

		OwnerRepository ownerRepository = configurableApplicationContext
				.getBean(OwnerRepository.class);

		Car car = new Car("M2000");
		carRepository.save(car);

		Owner owner = new Owner("John Doe");
		owner.setCar(car);
		ownerRepository.save(owner);

		Optional<Car> optionalCar = carRepository.findById(1L);
		Optional<Owner> optionalOwner = ownerRepository.findById(2L);

		if(optionalCar.isPresent() && optionalOwner.isPresent()) {
			log.info(optionalCar.get() + " is owned by: " + optionalCar.get().getOwner());
			log.info(optionalOwner.get() + " has car: " + optionalOwner.get().getCar());
		}
	}
}
