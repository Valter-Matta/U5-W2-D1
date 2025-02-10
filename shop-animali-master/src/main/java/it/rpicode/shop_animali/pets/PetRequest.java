package it.rpicode.shop_animali.pets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetRequest {
    private String name;
    private String type;
    private Integer age;
    private String gender;
    private String description;
}
