package com.example.demo.servicios;

import com.example.demo.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long> {
    List<Domicilio> search(String filtro) throws Exception;
    Page<Domicilio> search(String filtro, Pageable pageable) throws Exception;
}
