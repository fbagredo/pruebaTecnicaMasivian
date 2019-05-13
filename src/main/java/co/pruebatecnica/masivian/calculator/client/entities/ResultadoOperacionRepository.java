package co.pruebatecnica.masivian.calculator.client.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoOperacionRepository extends CrudRepository<ResultadoOperacion, Integer> {}