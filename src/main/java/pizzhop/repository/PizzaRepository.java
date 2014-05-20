package pizzhop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzhop.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
