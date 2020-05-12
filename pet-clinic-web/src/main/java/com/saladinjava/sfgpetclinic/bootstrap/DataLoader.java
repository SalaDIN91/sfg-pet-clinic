package com.saladinjava.sfgpetclinic.bootstrap;

import com.saladinjava.sfgpetclinic.model.Owner;
import com.saladinjava.sfgpetclinic.model.PetType;
import com.saladinjava.sfgpetclinic.model.Vet;
import com.saladinjava.sfgpetclinic.services.OwnerService;
import com.saladinjava.sfgpetclinic.services.PetTypeService;
import com.saladinjava.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType  dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType  cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println("Pet Types loaded");

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("GLEANNE");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mark");
        owner2.setLastName("Zuk");

        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Monk");
        vet1.setLastName("Monkey");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setLastName("dog");
        vet2.setFirstName("Doctor");

        vetService.save(vet2);
        System.out.println("Vet loaded");
    }
}
