package es.iesrafaelalberti.proyectospring;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.models.CoursePurchase;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProyectoSpringApplicationTests {
	@Autowired
	MockMvc mvc;

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	CoursePurchaseRepository coursePurchaseRepository;
	@Autowired
	ValuationRepository valuationRepository;
	/*
	@Test
	void contextLoads() {
		assert cellRepository.count() == 3;
		assert prisonerRepository.count() == 8;
	}

	 */
	/*
	*
	* COURSE
	*
	 */
	@Test
	void courseCreationTest() throws Exception {
		long coursesCount = courseRepository.count();
		String testCourse = "{\"title\": \"NewCourse\", \"author\": \"AuthorNewCourse\", \"price\": 1, \"hours\": 1, \"minutes\": 1, \"language\": \"language\", \"subtitle\": \"subtitle\", \"area\": \"area\", \"subarea\": \"subarea\", \"level\": \"level\", \"date\": \"date\"}";
		// method post on url /prisoners/
		mvc.perform(post("/courses/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(testCourse))
				.andExpect(status().isOk()) // test result
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title").value("NewCourse"))
				.andExpect(jsonPath("$.author").value("AuthorNewCourse"))
				.andExpect(jsonPath("$.price").value(1));
		// test number of prisoners is correct (+1)
		assert courseRepository.count() == coursesCount + 1;
	}
	@Test
	void coursesListTest() throws Exception {
		mvc.perform(get("/courses/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].title").value("FirstCourse"))
				.andExpect(jsonPath("$[0].author").value("Author"))
				.andExpect(jsonPath("$[0].hours").value(1));
	}
	@Test
	void courseDetailTest() throws Exception {
		mvc.perform(get("/courses/1/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title").value("FirstCourse"))
				.andExpect(jsonPath("$.author").value("Author"))
				.andExpect(jsonPath("$.hours").value(1));

	}
	@Test
	void courseUpdateTest() throws Exception {
		// get test prisoner (method get on url /prisoners/1/)
		// create test prisoner
		String testCourse = "{\"title\": \"NewTitle\", \"hours\": 2, \"minutes\": 2}";
		// modify attributes
		// method put on url /prisoners/1/
		mvc.perform(put("/courses/1/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(testCourse))
				.andExpect(status().isOk()) // test result
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.title").value("NewTitle"))
				.andExpect(jsonPath("$.hours").value(2))
				.andExpect(jsonPath("$.minutes").value(2));
		// test result
	}
	@Test
	void courseDeleteTest() throws Exception {
		long countCourses = courseRepository.count();
		mvc.perform(delete("/courses/1/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		assert courseRepository.count() == countCourses-1;
	}
	/*
	 *
	 * USERS
	 *
	 */
	@Test
	void userCreationTest() throws Exception {
		long usersCount = usersRepository.count();
		String testUser = "{\"name\": \"NewUser\", \"surname\": \"SurnameNewUser\", \"email\":  \"email@email.com\", \"password\":  \"password\"}";
		// method post on url /prisoners/
		mvc.perform(post("/users/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(testUser))
				.andExpect(status().isOk()) // test result
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("NewUser"))
				.andExpect(jsonPath("$.surname").value("SurnameNewUser"))
				.andExpect(jsonPath("$.email").value("email@email.com"));
		// test number of prisoners is correct (+1)
		assert usersRepository.count() == usersCount + 1;
	}
	@Test
	void usersListTest() throws Exception {
		mvc.perform(get("/users/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name").value("FirstUser"))
				.andExpect(jsonPath("$[0].surname").value("SurnameFirstUser"))
				.andExpect(jsonPath("$[0].email").value("emailfirstuser@email.com"));
	}
	@Test
	void userDetailTest() throws Exception {
		mvc.perform(get("/users/1/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("FirstUser"))
				.andExpect(jsonPath("$.surname").value("SurnameFirstUser"))
				.andExpect(jsonPath("$.email").value("emailfirstuser@email.com"));

	}
	@Test
	void userUpdateTest() throws Exception {
		// get test prisoner (method get on url /prisoners/1/)
		// create test prisoner
		String testUser = "{\"name\": \"NewName\", \"surname\": \"NewSurname\", \"email\":\"newemail@email.com\"}";
		// modify attributes
		// method put on url /prisoners/1/
		mvc.perform(put("/users/1/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(testUser))
				.andExpect(status().isOk()) // test result
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("NewName"))
				.andExpect(jsonPath("$.surname").value("NewSurname"))
				.andExpect(jsonPath("$.email").value("newemail@email.com"));
		// test result
	}
	@Test
	void userDeleteTest() throws Exception {
		long countUsers = usersRepository.count();
		mvc.perform(delete("/users/1/").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		assert usersRepository.count() == countUsers-1;
	}
	/*
	 *
	 * COURSE_PURCHASE
	 *
	 */
	@Test
	void coursePurchaseCreationTest() throws Exception {
		long coursePurchasesCount = coursePurchaseRepository.count();

		/*Optional<Course> course = courseRepository.findById(1L);
		Optional<Users> user = usersRepository.findById(1L);
		Map<String, Object> coursePurchase = new HashMap<>();
		coursePurchase.put("course", course);
		coursePurchase.put("user", user);

		ObjectMapper mapper = new ObjectMapper();
		String coursePurchaseJson = mapper.writeValueAsString(coursePurchase);
		*/
		String testCoursePurchase = "{\"course\":{\"id\":4,\"title\":\"Saxofón\",\"author\":\"Cezanne\",\"price\":34.28,\"hours\":2,\"minutes\":1,\"language\":\"Francés\",\"subtitle\":\"Español\",\"area\":\"Audio\",\"subarea\":\"Técnicas musicales\",\"level\":\"Advanced\",\"date\":\"Sat Aug 20 13:39:19 CEST 1994\"},\"user\":{\"id\":2,\"name\":\"Silvia\",\"surname\":\"Centeno\",\"email\":\"graciela.esquivel@yahoo.com\",\"password\":\"fmgh0phx\"}}";
		mvc.perform(post("/coursePurchase/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(testCoursePurchase))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.course.title").value("Saxofón"))
			.andExpect(jsonPath("$.user.name").value("Silvia"));
		// test number of prisoners is correct (+1)
		assert coursePurchaseRepository.count() == coursePurchasesCount + 1;
	}
	@Test
	void coursePurchasesListTest() throws Exception {
		mvc.perform(get("/coursePurchases/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].user.name").value("FirstUser"))
				.andExpect(jsonPath("$[0].course.title").value("FirstCourse"));
	}
	@Test
	void coursePurchaseDetailTest() throws Exception {
		mvc.perform(get("/coursePurchase/1/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.course.title").value("FirstCourse"))
				.andExpect(jsonPath("$.user.name").value("FirstUser"));

	}
	@Test
	void coursePurchaseUpdateTest() throws Exception {
		String testCoursePurchase = "{\"course\":{\"id\":4,\"title\":\"Saxofón\",\"author\":\"Cezanne\",\"price\":34.28,\"hours\":2,\"minutes\":1,\"language\":\"Francés\",\"subtitle\":\"Español\",\"area\":\"Audio\",\"subarea\":\"Técnicas musicales\",\"level\":\"Advanced\",\"date\":\"Sat Aug 20 13:39:19 CEST 1994\"},\"user\":{\"id\":2,\"name\":\"Silvia\",\"surname\":\"Centeno\",\"email\":\"graciela.esquivel@yahoo.com\",\"password\":\"fmgh0phx\"}}";
		mvc.perform(put("/coursePurchase/1/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(testCoursePurchase))
				.andExpect(status().isOk()) // test result
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.course.title").value("Saxofón"))
				.andExpect(jsonPath("$.user.name").value("Silvia"));
		// test result
	}
	@Test
	void coursePurchaseDeleteTest() throws Exception {
		long countCoursePurchases = coursePurchaseRepository.count();
		mvc.perform(delete("/coursePurchase/1/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		assert coursePurchaseRepository.count() == countCoursePurchases-1;
	}
}
