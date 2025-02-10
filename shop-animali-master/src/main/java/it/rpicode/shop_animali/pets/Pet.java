package it.rpicode.shop_animali.pets;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pets")

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String type;
    private Integer age;
    private String gender;
    private String description;

}
