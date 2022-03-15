package net.guides.springboot.crud.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity(name = "categories")
public class CategoryEntity {

    @Id
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String path;

}
