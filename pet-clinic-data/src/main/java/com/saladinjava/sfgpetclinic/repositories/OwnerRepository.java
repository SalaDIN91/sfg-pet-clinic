package com.saladinjava.sfgpetclinic.repositories;

import com.saladinjava.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
