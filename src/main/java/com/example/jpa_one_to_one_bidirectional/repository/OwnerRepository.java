package com.example.jpa_one_to_one_bidirectional.repository;

import com.example.jpa_one_to_one_bidirectional.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
