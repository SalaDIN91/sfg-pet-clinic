package com.saladinjava.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specilaties")
public class Specialty extends BaseEntity{

    @Column(name = "description")
    private String description;
}
