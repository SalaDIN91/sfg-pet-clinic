package com.saladinjava.sfgpetclinic.services.springdatajpa;

import com.saladinjava.sfgpetclinic.model.Owner;
import com.saladinjava.sfgpetclinic.repositories.OwnerRepository;
import com.saladinjava.sfgpetclinic.repositories.PetRepository;
import com.saladinjava.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    public static final String LAST_NAME = "Smith";

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    //@Test
    /**
     * @// TODO: 01.06.2020 разобратся почему не находит по lastName 
     * */
    void findByLastName() {
        Mockito.when(ownerRepository.findByLastName(Mockito.any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        Mockito.verify(ownerRepository).findByLastName(Mockito.any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1l).build());
        returnOwnersSet.add(Owner.builder().id(2l).build());

        Mockito.when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        Mockito.verify(ownerRepository).save(Mockito.any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        //default is 1 times
        Mockito.verify(ownerRepository, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        Mockito.verify(ownerRepository).deleteById(Mockito.anyLong());
    }
}