package com.ekwateur.testtechnique.utils;

import com.ekwateur.testtechnique.dtos.ClientDTO;
import com.ekwateur.testtechnique.entities.Client;
import com.ekwateur.testtechnique.entities.ParticularClient;
import com.ekwateur.testtechnique.entities.ProfessionalClient;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientMapper implements Function<Client, ClientDTO> {

    @Override
    public ClientDTO apply(Client client) {
        return switch (client){
            case ParticularClient particularClient -> new ClientDTO(
                    particularClient.getReference(),
                    "Particular",
                    particularClient.getCivility() + ". " + particularClient.getFirstName() + " " + particularClient.getLastName(),
                    null
            );
            case ProfessionalClient professionalClient -> new ClientDTO(
                    professionalClient.getReference(),
                    "Professional",
                    professionalClient.getCompanyName(),
                    professionalClient.getSiretNumber()
            );
            default -> null;
        };
    }
}
