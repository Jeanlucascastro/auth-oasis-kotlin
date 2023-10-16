package com.catalogo.auth.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class GenericEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private boolean deleted;

    @Column()
    private boolean ativo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;


    public GenericEntity() {

    }

    public GenericEntity(Long id, boolean deleted, LocalDateTime dateCreate, LocalDateTime dateUpdate, Boolean ativo) {
        this.id = id;
        this.deleted = deleted;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.ativo = ativo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @PrePersist
    private void fillDate() {
        this.setDateCreate(LocalDateTime.now());
    }

    @PreUpdate
    private void updateDate() {
        this.setDateUpdate(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "GenericEntity{" +
                "id=" + id +
                ", deleted=" + deleted +
                ", ativo=" + ativo +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
