package pizzhop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizzhop.model.Ingredient;
import pizzhop.repository.IngredientRepository;
import pizzhop.service.IngredientService;

@Service
@Transactional(readOnly = true)
public class DefaultIngredientService implements IngredientService {

	@Autowired
	private IngredientRepository repository;

	@Override
	@Transactional(readOnly = false)
	public Ingredient save(Ingredient ingredient) {
		return repository.save(ingredient);

	}

	@Override
	public List<Ingredient> findAll() {

		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		repository.delete(id);
	}

	@Override
	public Ingredient findById(Long id) {
		return repository.findOne(id);
	}

}
