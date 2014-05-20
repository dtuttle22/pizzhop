package pizzhop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pizzhop.model.Ingredient;
import pizzhop.service.IngredientService;
import pizzhop.web.util.ResponseTemplate;

@RestController
@RequestMapping(value = "/ingredients")
public class IngredientController extends BaseController {

	private final IngredientService service;

	@Autowired
	public IngredientController(IngredientService ingredientService) {
		this.service = ingredientService;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseTemplate createIngredients(@RequestBody Ingredient ingredient) {
		return ResponseTemplate.successResponse(service.save(ingredient));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseTemplate getIngredients() {
		return ResponseTemplate.successResponse(service.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseTemplate> update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
		if (service.findById(id) == null) {
			ResponseTemplate response = ResponseTemplate.errorResponse("There is no resource with the given id:" + id);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

		ingredient.setId(id);
		ResponseTemplate response = ResponseTemplate.successResponse(service.save(ingredient));
		;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseTemplate delete(@PathVariable Long id) {
		service.deleteById(id);

		return ResponseTemplate.successResponse();
	}

}
