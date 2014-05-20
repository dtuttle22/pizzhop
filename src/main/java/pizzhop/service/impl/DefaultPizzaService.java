package pizzhop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizzhop.model.Pizza;
import pizzhop.repository.PizzaRepository;
import pizzhop.service.PizzaService;

@Service
@Transactional(readOnly = true)
public class DefaultPizzaService implements PizzaService {

	private PizzaRepository repository;

	@Autowired
	public DefaultPizzaService(PizzaRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = false)
	public Pizza save(Pizza pizza) {
		return repository.save(pizza);
	}

	@Override
	public List<Pizza> findAll() {

		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		repository.delete(id);
	}

	@Override
	public Pizza findById(Long id) {
		return repository.findOne(id);
	}

}
