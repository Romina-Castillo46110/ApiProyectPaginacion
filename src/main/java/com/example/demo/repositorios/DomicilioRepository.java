package com.example.demo.repositorios;

import com.example.demo.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {
    List<Domicilio> findByCalleContainingOrNumeroContaining(String calle, int numero);
    Page<Domicilio> findByCalleContainingOrNumeroContaining(String calle, int numero, Pageable pageable);

    boolean existsById(Long id);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.calle LIKE '%?1%' OR d.numero LIKE '%?1%'")
    List<Domicilio> search(String filtro);
    @Query(value = "SELECT d FROM Domicilio d WHERE d.calle LIKE '%?1%' OR d.numero LIKE '%?1%'")
    Page<Domicilio> search(String filtro,Pageable pageable);
    @Query(
            value = "SELECT * FROM domicilio WHERE domicilio.calle LIKE '%?1%' OR domicilio.numero LIKE '%?1%'",
            nativeQuery = true
    )
    List<Domicilio> searchNativo(String filtro);
    @Query(
            value = "SELECT * FROM domicilio WHERE domicilio.calle LIKE '%?1%' OR domicilio.numero LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM domicilio",
            nativeQuery = true
    )
    Page<Domicilio> searchNativo(String filtro, Pageable pageable);
}
