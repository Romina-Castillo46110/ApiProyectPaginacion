package com.example.demo.servicios;

import com.example.demo.entities.Localidad;
import com.example.demo.repositorios.BaseRepository;
import com.example.demo.repositorios.LocalidadRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServeceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {
    @Autowired
    public LocalidadRespository localidadRespository;
    public LocalidadServeceImpl(BaseRepository<Localidad, Long> baseRepository, LocalidadRespository localidadRespository) {
        super(baseRepository);
        this.localidadRespository = localidadRespository;
    }

    @Override
    public List<Localidad> search(String filtro) throws Exception {
        try {
            //List<Localidad> localidades = LocalidadRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Localidad> localidades = LocalidadRepository.search(filtro);
            List<Localidad> localidades = localidadRespository.searchNativo(filtro);
            return localidades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Localidad> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Localidad> localidades = LocalidadRespository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //Page<Localidad> localidades = LocalidadRespository.search(filtro, pageable);
            Page<Localidad> localidades = localidadRespository.searchNativo(filtro, pageable);
            return localidades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}

