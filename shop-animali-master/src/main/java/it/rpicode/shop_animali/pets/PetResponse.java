package it.rpicode.shop_animali.pets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetResponse {
    private Long id;
    private String name;
    private String type;
}
