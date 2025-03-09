package es.santander.ascender.ejerc008.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.model.Usuario;
import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.repository.UsuarioRepository;
import es.santander.ascender.ejerc008.repository.PersonaRepository;

@Service
public class UsuarioService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    /*
     * Los métodos CRUD sobre usuarioRepository
     */

    public Usuario createUsuario(Usuario usuario) {
        establecePersona(usuario);
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNombre(usuarioDetails.getNombre());
            usuario.setContraseña(usuarioDetails.getContraseña());
            
            return usuarioRepository.save(usuario);
        }
        return null; // or throw an exception
    }

    private void establecePersona(Usuario usuarioDetails) {
        establecePersona(usuarioDetails, usuarioDetails);
    }

    private void establecePersona(Usuario usuarioDetails, Usuario usuario) {
        Persona persona = null;
        if (usuarioDetails.getPersona()!= null && usuarioDetails.getPersona().getId() != null) {
            persona = personaRepository.findById(usuarioDetails.getPersona().getId()).orElse(null);
            
        } 
        usuario.setPersona(persona);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
