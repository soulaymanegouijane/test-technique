package com.ekwateur.testtechnique.repositories;

import com.ekwateur.testtechnique.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, String> {
    Client findByReference(String reference);
}
