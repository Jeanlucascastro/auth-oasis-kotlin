package com.catalogo.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

@EqualsAndHashCode(callSuper = true)
@Table()
@Entity()
@Data
@AllArgsConstructor
@Where(clause = "deleted = false")
public class Company extends GenericEntity{

    @Column
    private String name;

    @Column
    private String description;
}
