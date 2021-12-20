package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

private @Autowired UsuarioRepository repository;
	
	@BeforeAll
	void start() {
		
		//Given
		repository.save(new Usuario(0L,"Matheus Boaz", "alan@email.com", "134652"));
		repository.save(new Usuario(0L,"Matheus Boaz", "matheus@email.com", "134652"));
		repository.save(new Usuario(0L,"Mariana Boaz", "mariana@email.com", "134652"));
		repository.save(new Usuario(0L,"Raphaella Boaz", "raphaella@email.com", "134652"));
		repository.save(new Usuario(0L,"Hercules Boaz", "hercules@email.com", "134652"));
		
	}
	
	@Test
	@DisplayName("Retorne um usuario!")
	void searchUserValidReturnObjectValid() {
		
		//When
		Optional<Usuario> usuario = repository.findByUsuario("alan@email.com");
		assertTrue(usuario.get().getUsuario().equals("alan@email.com"));
		
	}
	
	@Test
	@DisplayName("Search name Boaz!")
	void searchFromBoazReturnFiveUsers() {
		
		//When
		List<Usuario> list = repository.findAllByNomeContainingIgnoreCase("Boaz");
		
		//Then
		assertEquals(5, list.size());
	}
	
	@Test
	@DisplayName("Search name Hercules!")
	void searchFromHerculesReturnOneUser() {
		
		//When
		List<Usuario> list = repository.findAllByNomeContainingIgnoreCase("Hercules");
		
		//Then
		assertEquals(1, list.size());
	}
	
	
}
