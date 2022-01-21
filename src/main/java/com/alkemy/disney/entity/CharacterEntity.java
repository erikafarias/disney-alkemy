package com.alkemy.disney.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
@Getter
@Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;

    private String name;

    private int age;

    private Double weight;

    private String history;

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<MovieEntity> movies = new ArrayList<>();


//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(getClass()!= obj.getClass()) return false;
//        if(obj.hashCode()!= this.hashCode()) return false;
        final CharacterEntity OTHER = (CharacterEntity) obj;
        return OTHER.id == this.id;
    }
}
