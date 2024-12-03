package com.andb24.PKChasing;

import com.andb24.PKChasing.controller.PokemonController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.andb24.PKChasing.dto.CenterDto;
import com.andb24.PKChasing.dto.PokemonDto;
import com.andb24.PKChasing.models.Center;
import com.andb24.PKChasing.models.Pokemon;
import com.andb24.PKChasing.services.PokemonServices;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




@SpringBootTest
@AutoConfigureMockMvc
class PkChasingApplicationTests {

	private static final String MOCK_POKEMON_NAME = "Pikachu";
	private static final String MOCK_CENTER_LOCATION = "Sample center 1";

	@Autowired
	private PokemonController controller;
	@Autowired
	private MockMvc mockMvc;
	@MockitoBean
	private PokemonServices pokemonServices;

	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("API para cazar tus pokemones por: Andrés B.")));
	}

	@Test
	void allPokemonsShouldRetornAListOfPokemons() throws Exception {
		List<PokemonDto> mockPokemonList = Arrays.asList(
				PokemonDto.builder().name("Pikachu")
						.type("rayo")
						.level(30)
						.isCaptured(true)
						.centerDto(
								CenterDto.builder()
										.name(null)
										.location("Sample center 1")
										.capturedPokemons(30)
										.level(70)
										.build()
						).build()
		);

		when(pokemonServices.findAll()).thenReturn(mockPokemonList);



		this.mockMvc.perform(get("/api/v1/pokemons/all"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value(MOCK_POKEMON_NAME))
				.andExpect(jsonPath("$[0].centerDto.location").value(MOCK_CENTER_LOCATION));
	}

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}



}
