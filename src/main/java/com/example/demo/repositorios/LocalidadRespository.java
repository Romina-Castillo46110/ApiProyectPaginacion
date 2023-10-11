package com.example.demo.repositorios;

import com.example.demo.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRespository extends BaseRepository<Localidad, Long> {
    List<Localidad> findByDenominacionContaining(String denominacion);
    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);
    boolean existsById(Long id);
    @Query(value = "SELECT o FROM Localidad o WHERE o.denominacion LIKE '%?1%'")
    List<Localidad> search(String filtro);
    @Query(value = "SELECT o FROM Localidad o WHERE o.denominacion LIKE '%?1%'")
    Page<Localidad> search(String filtro, Pageable pageable);
    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE '%?1%'",
            nativeQuery = true
    )
    List<Localidad> searchNativo(String filtro);
    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM localidad",
            nativeQuery = true
    )
    Page<Localidad> searchNativo(String filtro, Pageable pageable);
}
