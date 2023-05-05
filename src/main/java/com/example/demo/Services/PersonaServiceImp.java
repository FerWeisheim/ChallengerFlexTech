/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Services;

import com.example.demo.Entity.Persona;
import com.example.demo.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilty
 */
@Service
public class PersonaServiceImp {
    @Autowired
    IPersonaRepository iPersonaRepository;
    
    public List<Persona> findAllPersona(){
        List<Persona>  persona= iPersonaRepository.findAll();
        return persona;
    }
    
    public void savePersona(Persona persona ) {
        iPersonaRepository.save(persona);
    }
    
    public Persona editarPersona (Integer id, Persona persona) {
        Persona existingPersona = iPersonaRepository.findById(id).orElse(null);
        existingPersona.setApellido(persona.getApellido());
        existingPersona.setNombre(persona.getNombre());
        existingPersona.setDireccion(persona.getDireccion());
        existingPersona.setFecha_nacimiento(persona.getFecha_nacimiento());
        existingPersona.setPais(persona.getPais());
        existingPersona.setTelefono(persona.getTelefono());        
        return iPersonaRepository.save(existingPersona);
    }
    
    public void DeletePersona(Integer id){
        iPersonaRepository.deleteById(id);
    }
    
    public Persona findPersonaById(Integer id) {
     Persona findPersona = iPersonaRepository.findById(id).orElse(null);
      return findPersona;
    }
    
    // contar Personas por pais
    public int contarPersonaPorPais(String pais) {
         List<Persona> personas = iPersonaRepository.contarPersonaPorPais(pais);
        return personas.size();
    }
                
}
