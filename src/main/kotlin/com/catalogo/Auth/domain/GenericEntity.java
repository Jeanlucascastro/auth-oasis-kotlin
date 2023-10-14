package com.catalogo.Auth.domain;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;


    public GenericEntity() {

    }

    public GenericEntity(Long id, boolean deleted, LocalDateTime dateCreate, LocalDateTime dateUpdate) {
        this.id = id;
        this.deleted = deleted;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
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
        return "EntidadeGenerica{" +
                "id=" + id +
                ", deleted=" + deleted +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                '}';
    }


}
