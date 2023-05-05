/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Entity;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Guilty
 */
@Getter
@Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
   private String nombre;
    
    @NotNull
   private String apellido;
    
    @NotNull
   private Date fecha_nacimiento;
    
   @NotNull
   private String direccion;
         
   @NotNull
   private double telefono;
    
   @NotNull
   private String pais;
    
   
    
    
}
