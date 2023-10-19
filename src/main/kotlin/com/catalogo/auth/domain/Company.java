package com.catalogo.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@EqualsAndHashCode(callSuper = true)
@Table()
@Entity()
@Data
@AllArgsConstructor
@Where(clause = "deleted = false")
public class Company extends GenericEntity{

}
