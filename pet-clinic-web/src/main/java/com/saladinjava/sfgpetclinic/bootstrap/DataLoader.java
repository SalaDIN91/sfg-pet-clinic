package com.saladinjava.sfgpetclinic.bootstrap;

import com.saladinjava.sfgpetclinic.model.*;
import com.saladinjava.sfgpetclinic.services.OwnerService;
import com.saladinjava.sfgpetclinic.services.PetTypeService;
import com.saladinjava.sfgpetclinic.services.SpecialtyService;
import com.saladinjava.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, SpecialtyService specialtyService1) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService1;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType  cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radologies");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        System.out.println("Pet Types loaded");

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("GLEANNE");
        owner1.setAddress("Gogol 33");
        owner1.setCity("Karagandy");
        owner1.setTelephone("335511");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedDogPetType);
        fionasPet.setOwner(owner1);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Dog");
        owner1.getPets().add(fionasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mark");
        owner2.setLastName("Zuk");
        owner2.setAddress("Gogol 33");
        owner2.setCity("Karagandy");
        owner2.setTelephone("335511");

        Pet markPet = new Pet();
        markPet.setPetType(savedCatPetType);
        markPet.setOwner(owner2);
        markPet.setBirthDate(LocalDate.now());
        markPet.setName("Cat");
        owner2.getPets().add(markPet);

        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Monk");
        vet1.setLastName("Monkey");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setLastName("dog");
        vet2.setFirstName("Doctor");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);
        System.out.println("Vet loaded");
    }
}
