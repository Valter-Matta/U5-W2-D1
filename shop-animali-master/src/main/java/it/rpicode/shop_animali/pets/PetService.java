package it.rpicode.shop_animali.pets;

import it.rpicode.shop_animali.responses.CreationRespons;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public List<Pet> findAll() {
        return petRepository.findAll();
    }


    public CreationRespons save(PetRequest pet) {
        Pet petEntity = new Pet();
        /*
        petEntity.setName(pet.getName());
        petEntity.setType(pet.getType());
        petEntity.setAge(pet.getAge());
        petEntity.setGender(pet.getGender());
        petEntity.setDescription(pet.getDescription());*/
        // sostituiamo tutte le assegnazioni di valori utilizzando la classe BeanUtils
        // il primo parametro è la sorgente il secondo è la destinazione
        // in parole povere copyProperties copia i valori di pet in petEntity
        // in base alla corrispondenza dei nomi degli attributi
        // attenzione che la copia viene fatta solo sui valori primitivi
        // Integer Long String ecc , ma non su oggetti in relazione
        BeanUtils.copyProperties(pet, petEntity);
        petRepository.save(petEntity);

        CreationRespons response = new CreationRespons();
        BeanUtils.copyProperties(petEntity, response);

        return response;
    }


    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    public PetResponse findById(Long id) {
        if(!petRepository.existsById(id)) {
            throw new EntityNotFoundException("Pet not found");
        }

        Pet pet = petRepository.findById(id).get();
        PetResponse response = new PetResponse();
        BeanUtils.copyProperties(pet, response);

        return response;
    }

    public Pet findPetById(Long id) {
        if(!petRepository.existsById(id)) {
            throw new EntityNotFoundException("Pet not found");
        }

        return petRepository.findById(id).get();
    }

    public PetResponse update(Long id, PetRequest request) {
        Pet pet = findPetById(id);
        BeanUtils.copyProperties(request, pet);

        petRepository.save(pet);
        PetResponse response = new PetResponse();
        BeanUtils.copyProperties(pet, response);

        return response;

    }


}
