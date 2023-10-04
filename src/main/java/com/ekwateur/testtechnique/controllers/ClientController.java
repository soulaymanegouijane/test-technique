package com.ekwateur.testtechnique.controllers;

import com.ekwateur.testtechnique.dtos.ClientDTO;
import com.ekwateur.testtechnique.dtos.TotalTarifResponseDTO;
import com.ekwateur.testtechnique.exceptions.UnexpectedClientTypeException;
import com.ekwateur.testtechnique.exceptions.UnexpectedValueException;
import com.ekwateur.testtechnique.services.ClientService;
import com.ekwateur.testtechnique.utils.ClientMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClientController.
 * this controller is responsible for handelling the clients related requests
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    /**
     * clientService.
     * the service responsible for handelling the clients related requests
     */
    private final ClientService clientService;
    /**
     * clientMapper.
     * the mapper responsible for mapping the client entity to the clientDTO
     */
    private final ClientMapper clientMapper;

    /**
     * Client Controller constructor.
     * used to inject the dependencies
     * @param clientService the client service
     * @param clientMapper the client mapper
     */
    public ClientController(final ClientService clientService,
                            final ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    /**
     * getAllClients.
     * this method is responsible for getting all the clients from the database
     * @return a list of clients
     */
    @GetMapping
    public List<ClientDTO> getAllClients () {
        return clientService.getAllClients().stream()
                .map(clientMapper::apply)
                .toList();
    }

    /**
     * getTotalTarif.
     * this method is responsible for computing and returning the total tarif that a client will pay
     * @param reference the client reference
     * @return an object containing the client's reference and the total amount to be paid
     * @throws UnexpectedValueException if the client reference is not found
     * @throws UnexpectedClientTypeException if the client type is not supported
     */
    @GetMapping("/{reference}/total")
    public TotalTarifResponseDTO getTotalTarif(@PathVariable("reference") final String reference)
            throws UnexpectedValueException, UnexpectedClientTypeException {
        double totalTarif =  clientService.getTotalTarif(reference);
        return new TotalTarifResponseDTO(reference, totalTarif);
    }
}
