/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.Entity.Persona;
import com.example.demo.Services.PersonaServiceImp;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Guilty
 */
@RestController
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired PersonaServiceImp iPersonaService;
    
    @GetMapping("Persona/traer")
    public List<Persona> getAllPersona(){
        return iPersonaService.findAllPersona();
    }
    
    @PostMapping("Persona/crear")
    public void createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
    }
    
    @DeleteMapping("Persona/borrar/{id}")
    public void deletePersona(@PathVariable Integer id){
         iPersonaService.DeletePersona(id);
        
    }
    
    @PutMapping("Persona/editar/{id}")
    public Persona edit (@PathVariable int id,@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return persona;
}
    @GetMapping("Persona/traer/{id}")
    public Persona getPersonaById(@PathVariable Integer id)
    {
       return iPersonaService.findPersonaById(id);
    }
    
    @GetMapping("Persona/porPais/{pais}")
    public ResponseEntity<Integer> contarPersonaPorPais(@PathVariable ("pais") String pais) {
        int personaByPais = iPersonaService.contarPersonaPorPais(pais);
        return new ResponseEntity<>(personaByPais,HttpStatus.OK);
    }
}
