package com.saladinjava.sfgpetclinic.services.map;

import com.saladinjava.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String ownerAddress = "KRG";
    final String ownerLastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().address(ownerAddress).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Owner owner2 = Owner.builder().address(ownerAddress).build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(ownerAddress, savedOwner.getAddress());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().address(ownerAddress).build();
        owner.setLastName(ownerLastName);
        ownerMapService.save(owner);
        Owner smith = ownerMapService.findByLastName(ownerLastName);
        assertEquals(2, smith.getId());
    }

    //@Test
    /**
     * @// TODO: 28.05.2020 реализовать
     * */
    /*void findByAddress() {
        Set<Owner> ownerSet = ownerMapService.findByAddress(ownerAddress);
        assertEquals(1, ownerSet);
    }*/
}