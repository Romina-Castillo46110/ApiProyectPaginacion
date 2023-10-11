package com.example.demo.repositorios;

import com.example.demo.entities.Libro;
import com.example.demo.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long>{
    List<Libro> findByTituloContainingOrGeneroContaining(String titulo, String genero);
    Page<Libro> findByTituloContainingOrGeneroContaining(String titulo, String genero, Pageable pageable);

    boolean existsById(Long id);

    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE '%?1%' OR l.genero LIKE '%?1%'")
    List<Libro> search(String filtro);
    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE '%?1%' OR l.genero LIKE '%?1%'")
    Page<Libro> search(String filtro,Pageable pageable);
    @Query(
            value = "SELECT * FROM libro WHERE libro.titulo LIKE '%?1%' OR libro.genero LIKE '%?1%'",
            nativeQuery = true
    )
    List<Libro> searchNativo(String filtro);
    @Query(
            value = "SELECT * FROM libro WHERE libro.titulo LIKE '%?1%' OR libro.genero LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM libro",
            nativeQuery = true
    )
    Page<Libro> searchNativo(String filtro, Pageable pageable);
}
