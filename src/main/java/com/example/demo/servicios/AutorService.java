package com.example.demo.servicios;

import com.example.demo.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AutorService extends BaseService<Autor,Long>{
    List<Autor> search(String filtro) throws Exception;
    Page<Autor> search(String filtro, Pageable pageable) throws Exception;
}