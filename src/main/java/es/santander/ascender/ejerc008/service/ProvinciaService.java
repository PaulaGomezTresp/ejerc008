package es.santander.ascender.ejerc008.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.repository.ProvinciaRepository;
import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.model.Provincia;

@Service
@Transactional
public class ProvinciaService {

     @Autowired
    private ProvinciaRepository provinciaRepository;

    // Create
    public Provincia createProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    // Read (all)
    @Transactional(readOnly = true)
    public List<Provincia> getAllProvincias() {
        return provinciaRepository.findAll();
    }

    // Read (by ID)
    @Transactional(readOnly = true)
    public Optional<Provincia> getProvinciaById(Long id) {
        return provinciaRepository.findById(id);
    }

    // Update
    public Provincia updateProvincia(Long id, Provincia provinciaDetails) {
        Optional<Provincia> provinciaOptional = provinciaRepository.findById(id);
        if (provinciaOptional.isPresent()) {
            Provincia provincia = provinciaOptional.get();
            provincia.setNombre(provinciaDetails.getNombre());
            List<Persona> personas = provincia.getPersona();

            personas.clear();
            personas.addAll(provinciaDetails.getPersona());
            personas.stream().forEach(d -> d.setProvincia(provincia));

            
            return provinciaRepository.save(provincia);
        }
        return null;
    }

}
