package it.rpicode.shop_animali.pets;


import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PetRunner implements CommandLineRunner {
    private final PetService petService;
    private final Faker faker;
    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 20; i++) {
            PetRequest pet = new PetRequest();
            pet.setName(faker.animal().name());
            pet.setType(faker.animal().name());
            pet.setAge(faker.number().numberBetween(1, 20));
            pet.setGender("m");

            petService.save(pet);
        }
    }
}
