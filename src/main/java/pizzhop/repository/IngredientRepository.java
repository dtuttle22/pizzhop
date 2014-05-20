package pizzhop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzhop.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
