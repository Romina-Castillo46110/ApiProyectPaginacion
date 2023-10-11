package com.example.demo.servicios;

import com.example.demo.entities.Autor;
import com.example.demo.entities.Persona;
import com.example.demo.repositorios.AutorRepository;
import com.example.demo.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor,Long> implements AutorService{
    @Autowired
    private AutorRepository autorRepository;
    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository, AutorRepository autorRepository) {
        super(baseRepository);
        this.autorRepository = autorRepository;
    }
    @Override
    public List<Autor> search(String filtro) throws Exception {
        try {
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Persona> personas = personaRepository.search(filtro);
            List<Autor> autores = autorRepository.searchNativo(filtro);
            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Autor> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Autor> autores = autorRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //Page<Autor> autores = autorRepository.search(filtro, pageable);
            Page<Autor> autores = autorRepository.searchNativo(filtro, pageable);
            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}






















