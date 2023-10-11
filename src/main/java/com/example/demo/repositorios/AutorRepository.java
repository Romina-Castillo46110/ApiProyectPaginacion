package com.example.demo.repositorios;

import com.example.demo.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {
    List<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    boolean existsById(Long id);

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE '%?1%' OR a.apellido LIKE '%?1%'")
    List<Autor> search(String filtro);
    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE '%?1%' OR a.apellido LIKE '%?1%'")
    Page<Autor> search(String filtro,Pageable pageable);
    @Query(
            value = "SELECT * FROM autor WHERE autor.nombre LIKE '%?1%' OR autor.apellido LIKE '%?1%'",
            nativeQuery = true
    )
    List<Autor> searchNativo(String filtro);
    @Query(
            value = "SELECT * FROM autor WHERE autor.nombre LIKE '%?1%' OR autor.apellido LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM autor",
            nativeQuery = true
    )
    Page<Autor> searchNativo(String filtro, Pageable pageable);
}
