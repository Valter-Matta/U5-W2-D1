package it.rpicode.shop_animali.pets;

import it.rpicode.shop_animali.responses.CreationRespons;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping
    public List<Pet> findAll() {
        return petService.findAll();
    }

    @PostMapping
    public CreationRespons save(@RequestBody PetRequest pet) {
        return petService.save(pet);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        petService.deleteById(id);
    }


    @GetMapping("/{id}")
    public PetResponse findById(Long id) {
        return petService.findById(id);
    }

    @PutMapping("/{id}")
    public PetResponse updateById(@PathVariable Long id, @RequestBody PetRequest pet) {
        return petService.update(id, pet);
    }


}
