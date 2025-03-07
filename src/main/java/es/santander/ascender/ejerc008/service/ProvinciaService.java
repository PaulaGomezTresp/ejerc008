package es.santander.ascender.ejerc008.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.repository.ProvinciaRepository;
import es.santander.ascender.ejerc008.model.Provincia;

@Service
@Transactional
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Transactional(readOnly = true)
    public List<Provincia> getAllProvincias() {
        return provinciaRepository.findAll();
    }

}
