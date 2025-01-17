package alura.desafio.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(
		@JsonProperty("name") String nome, 
		@JsonProperty("birth_year") int anoNasc, 
		@JsonProperty("death_year")int anoMort
		) {}
