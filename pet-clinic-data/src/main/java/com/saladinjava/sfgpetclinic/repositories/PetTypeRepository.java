package com.saladinjava.sfgpetclinic.repositories;

import com.saladinjava.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository <PetType, Long> {
}
