package es.santander.ascender.ejerc008.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

     @Autowired
    private PersonaService personaService;

    // Create
    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        persona.setId(1l);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = 
        List.of(new Persona(1l,"Juan","Losada",40));
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        return new ResponseEntity<>(
            new Persona(id, "Juan", "losada", 40), HttpStatus.OK
            );
    }
    

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
  
            return new ResponseEntity<>(personaDetails, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
 
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    
}
