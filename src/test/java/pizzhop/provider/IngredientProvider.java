package pizzhop.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import pizzhop.model.Ingredient;

public final class IngredientProvider {

	public static List<Ingredient> ingredientList(int size, boolean id) {
		List<Ingredient> ingredients = new ArrayList<>(size);
		IntStream.range(0, size).forEach(index -> ingredients.add(newIngredient(id)));

		return ingredients;
	}

	public static Ingredient newIngredient(boolean id) {
		int nameLeght = RandomUtils.nextInt(1, 41);
		String name = RandomStringUtils.randomAlphanumeric(nameLeght);
		Ingredient ingredient = new Ingredient(name);

		if (id)
			ingredient.setId(RandomUtils.nextLong(1, 1000_000));

		return ingredient;
	}
}
