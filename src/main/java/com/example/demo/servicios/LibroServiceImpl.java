package com.example.demo.servicios;

import com.example.demo.entities.Libro;
import com.example.demo.repositorios.BaseRepository;
import com.example.demo.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService {
    @Autowired
    public LibroRepository libroRepository;
    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository, LibroRepository libroRepository) {
        super(baseRepository);
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> search(String filtro) throws Exception {
        try {
            //List<Libro> libros = LibroRepository.findByTituloContainingOrGeneroContaining(filtro, filtro);
            //List<Libro> libros = LibroRepository.search(filtro);
            List<Libro> libros = libroRepository.searchNativo(filtro);
            return libros;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Libro> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Libro> libros = LibroRepository.findByTituloContainingOrGeneroContaining(filtro, filtro, pageable);
            //Page<Libro> libros = LibroRepository.search(filtro, pageable);
            Page<Libro> libros = libroRepository.searchNativo(filtro, pageable);
            return libros;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
