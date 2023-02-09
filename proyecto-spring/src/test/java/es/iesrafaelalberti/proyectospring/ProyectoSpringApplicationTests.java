package es.iesrafaelalberti.proyectospring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import es.iesrafaelalberti.proyectospring.repositories.CellRepository;
import es.iesrafaelalberti.proyectospring.repositories.PrisonerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProyectoSpringApplicationTests {
	@Autowired
	MockMvc mvc;
	@Autowired
	PrisonerRepository prisonerRepository;
	@Autowired
	CellRepository cellRepository;

	@Test
	void contextLoads() {
		assert cellRepository.count() == 18;
		assert prisonerRepository.count() == 7;
	}


	@Test
	void mvcTest() throws Exception {
		mvc.perform(get("/prisoners/")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)

				);
	}
}
@SpringBootTest
class ProyectoSpringApplicationTests {

	@Test
	void contextLoads() {
	}

}
