package com.app.doggi.repository;

import com.app.doggi.model.DogBreed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface representing a access data base layer
 * @version 1.0
 */
@Repository
public interface IDogBreedRepository extends CrudRepository<DogBreed, Long> {
}
