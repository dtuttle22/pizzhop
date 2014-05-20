package pizzhop.unittest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pizzhop.model.Ingredient;
import pizzhop.provider.IngredientProvider;
import pizzhop.service.IngredientService;
import pizzhop.web.IngredientController;

public class IngredientControllerTest {

	private IngredientService ingredientService = mock(IngredientService.class);
	private IngredientController ingredientController = new IngredientController(ingredientService);
	private MockMvc mockMvc;
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
	}

	// Creation
	@Test
	public void shouldReturnSuccessCreatingNewIngredient() throws Exception {
		Ingredient testIngredient = IngredientProvider.newIngredient(true);

		when(ingredientService.save(any(Ingredient.class))).thenReturn(testIngredient);

		ResultActions actions = this.mockMvc.perform(post("/ingredients").contentType(APPLICATION_JSON_UTF8).content(
				String.format("{\"name\":\"%s\"}", testIngredient.getName())));

		actions.andExpect(status().isCreated()).andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.id", is(testIngredient.getId().intValue())))
				.andExpect(jsonPath("$.name", is(testIngredient.getName())));
	}

	// Getting
	@Test()
	public void shouldReturnAllIngredients() throws Exception {
		List<Ingredient> ingredients = IngredientProvider.ingredientList(2, true);
		when(ingredientService.findAll()).thenReturn(ingredients);

		ResultActions actions = this.mockMvc.perform(get("/ingredients"));

		actions.andExpect(status().isOk()).andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(ingredients.get(0).getId().intValue())))
				.andExpect(jsonPath("$[0].name", is(ingredients.get(0).getName())))
				.andExpect(jsonPath("$[1].id", is(ingredients.get(1).getId().intValue())))
				.andExpect(jsonPath("$[1].name", is(ingredients.get(1).getName())));
	}
}
