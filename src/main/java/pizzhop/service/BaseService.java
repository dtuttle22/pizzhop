package pizzhop.service;

import java.util.List;

public interface BaseService<T, I> {

	T save(T pizza);

	List<T> findAll();

	void deleteById(I id);

	T findById(I id);

}
