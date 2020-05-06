package com.saladinjava.sfgpetclinic.services;

import com.saladinjava.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
