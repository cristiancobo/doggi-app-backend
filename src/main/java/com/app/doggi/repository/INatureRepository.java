package com.app.doggi.repository;

import com.app.doggi.model.Nature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface representing a access data base layer nature
 * @version 1.0
 */
@Repository
public interface INatureRepository extends CrudRepository<Nature, Long> {
}
