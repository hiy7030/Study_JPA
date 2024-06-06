package jpabook.jpashop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

@Entity
public class Album extends Item{
    private String artist;
    private String etc;
}
