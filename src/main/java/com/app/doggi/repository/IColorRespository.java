package com.app.doggi.repository;

import com.app.doggi.model.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface representing a access data base layer color
 * @version 1.0
 */
@Repository
public interface IColorRespository extends CrudRepository<Color, Long> {
}
