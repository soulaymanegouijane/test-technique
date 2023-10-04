package com.ekwateur.testtechnique.services;

import com.ekwateur.testtechnique.entities.Client;
import com.ekwateur.testtechnique.exceptions.UnexpectedClientTypeException;
import com.ekwateur.testtechnique.exceptions.UnexpectedValueException;

import java.util.List;

/**
 * this interface is used to define the methods related to business logic of Clients.
 */
public interface ClientService {
    List<Client> getAllClients();

    double getTotalTarif(final String reference) throws UnexpectedValueException, UnexpectedClientTypeException;
}
