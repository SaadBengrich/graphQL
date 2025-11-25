package com.example.banqueservice.repositories;

import com.example.banqueservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    @Query("select sum(c.solde) from Compte c")
    double sumSoldes();
}
