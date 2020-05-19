package com.saladinjava.sfgpetclinic.repositories;

import com.saladinjava.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository <Pet, Long> {
}
