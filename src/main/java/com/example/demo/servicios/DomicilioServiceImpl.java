package com.example.demo.servicios;
import com.example.demo.entities.Domicilio;
import com.example.demo.repositorios.BaseRepository;
import com.example.demo.repositorios.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    @Autowired
    public DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<Domicilio> search(String filtro) throws Exception {
        try {
            //List<Domicilio> domicilios = DomicilioRepository.findByCalleContainingOrNumeroContaining(filtro, filtro);
            //List<Domicilio> domicilios = DomicilioRepository.search(filtro);
            List<Domicilio> domicilios = domicilioRepository.searchNativo(filtro);
            return domicilios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Domicilio> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Domicilio> domicilios = DomicilioRepository.findByCalleContainingOrNumeroContaining(filtro, filtro, pageable);
            //Page<Domicilio> domicilios = DomicilioRepository.search(filtro, pageable);
            Page<Domicilio> domicilios = domicilioRepository.searchNativo(filtro, pageable);
            return domicilios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
