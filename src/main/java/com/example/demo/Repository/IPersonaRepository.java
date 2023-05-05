
package com.example.demo.Repository;

import com.example.demo.Entity.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
    
  @Query("SELECT p FROM Persona p WHERE p.pais = :pais")
    public List<Persona> contarPersonaPorPais(@Param("pais")String pais);
     
}
