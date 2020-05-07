package com.saladinjava.sfgpetclinic.bootstrap;

import com.saladinjava.sfgpetclinic.model.Owner;
import com.saladinjava.sfgpetclinic.model.Vet;
import com.saladinjava.sfgpetclinic.services.OwnerService;
import com.saladinjava.sfgpetclinic.services.VetService;
import com.saladinjava.sfgpetclinic.services.map.OwnerServiceMap;
import com.saladinjava.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Fiona");
        owner1.setLastName("GLEANNE");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mark");
        owner2.setLastName("Zuk");

        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Monk");
        vet1.setLastName("Monkey");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setLastName("dog");
        vet2.setFirstName("Doctor");

        vetService.save(vet2);
        System.out.println("Vet loaded");
    }
}
