package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio extends Base{
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private int numero;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "domicilio_id")
    private List<Localidad> localidades;
    public void agregarLocalidad (Localidad localidad){
        localidades.add(localidad);
    }
    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
    public void agregarAutor (Autor autor) {
        autores.add(autor);
    }

}

























