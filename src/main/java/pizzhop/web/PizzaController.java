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

import pizzhop.model.Pizza;
import pizzhop.service.PizzaService;
import pizzhop.web.util.ResponseTemplate;

@RestController
@RequestMapping(value = "/pizzas")
public class PizzaController extends BaseController {

	private PizzaService service;

	@Autowired
	public PizzaController(PizzaService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseTemplate getPizzas() {
		return ResponseTemplate.successResponse(service.findAll());

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseTemplate createPizza(@RequestBody Pizza pizza) {
		return ResponseTemplate.successResponse(service.save(pizza));
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseTemplate delete(@PathVariable Long id) {
		service.deleteById(id);

		return ResponseTemplate.successResponse();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ResponseTemplate> update(@PathVariable Long id, @RequestBody Pizza pizza) {
		if (service.findById(id) == null) {
			ResponseTemplate response = ResponseTemplate.errorResponse("There is no resource with the given id:" + id);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

		pizza.setId(id);
		ResponseTemplate response = ResponseTemplate.successResponse(service.save(pizza));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
