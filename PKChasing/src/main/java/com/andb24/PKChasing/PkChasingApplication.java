package com.andb24.PKChasing;

import com.andb24.PKChasing.services.impl.PokemonServicesImpl;
import com.andb24.PKChasing.services.PokemonServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PkChasingApplication {

	public static void main(String[] args) {SpringApplication.run(PkChasingApplication.class, args);}
	@GetMapping("/")
	public String apiRoot()
	{
		return "API para cazar tus pokemones :D por: Andrés B.";
	}


}
