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

    public ClientController(final ClientService clientService,
                            final ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @GetMapping
    public List<ClientDTO> getAllClients () {
        return clientService.getAllClients().stream()
                .map(clientMapper::apply)
                .toList();
    }

    @GetMapping("/{reference}/total")
    public TotalTarifResponseDTO getTotalTarif(@PathVariable("reference") final String reference)
            throws UnexpectedValueException, UnexpectedClientTypeException {
        double totalTarif =  clientService.getTotalTarif(reference);
        return new TotalTarifResponseDTO(reference, totalTarif);
    }
}
