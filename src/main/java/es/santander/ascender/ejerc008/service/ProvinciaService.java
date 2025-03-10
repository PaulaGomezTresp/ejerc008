package es.santander.ascender.ejerc008.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.repository.PersonaRepository;
import es.santander.ascender.ejerc008.repository.ProvinciaRepository;
import es.santander.ascender.ejerc008.model.Provincia;


@Service
@Transactional
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    /*
     * Los métodos CRUD sobre provinciaRepository
     */

    public Provincia createProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    @Transactional(readOnly = true)
    public List<Provincia> getAllProvincias() {
        return provinciaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Provincia> getProvinciaById(Long id) {
        return provinciaRepository.findById(id);
    }

    public Provincia updateProvincia(Long id, Provincia provinciaDetails) {
        Optional<Provincia> provinciaOptional = provinciaRepository.findById(id);
        if (provinciaOptional.isPresent()) {
            Provincia provincia = provinciaOptional.get();
            provincia.setNombre(provinciaDetails.getNombre());
            provincia.setCodigo(provinciaDetails.getCodigo());
            provincia.setDescripcion(provinciaDetails.getDescripcion());
                        
            return provinciaRepository.save(provincia);
        }
        return null; // or throw an exception
    }

    public void deleteProvincia(Long id) {
    
        //personaRepository.findAll().forEach(p -> personaRepository.delete(p));
        personaRepository.limpiaProvincia(id);

        provinciaRepository.deleteById(id);
    }

}
