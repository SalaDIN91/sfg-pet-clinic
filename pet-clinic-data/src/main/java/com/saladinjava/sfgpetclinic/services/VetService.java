package com.saladinjava.sfgpetclinic.services;

import com.saladinjava.sfgpetclinic.model.Vet;


public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName(String lastName);

}
