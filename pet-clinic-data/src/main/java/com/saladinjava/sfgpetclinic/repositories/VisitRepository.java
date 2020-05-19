package com.saladinjava.sfgpetclinic.repositories;

import com.saladinjava.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
