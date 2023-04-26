package com.plane.dao;

import com.plane.entity.Plane;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PlaneRepository extends MongoRepository<Plane, Integer> {
    @Query("{'size':?0}")
    Optional<Plane> findBySize(String size);
}
