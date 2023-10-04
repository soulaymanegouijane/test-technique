package com.ekwateur.testtechnique.services;

import com.ekwateur.testtechnique.entities.Client;
import com.ekwateur.testtechnique.entities.EnergyConsumption;
import com.ekwateur.testtechnique.entities.ParticularClient;
import com.ekwateur.testtechnique.entities.ProfessionalClient;
import com.ekwateur.testtechnique.exceptions.UnexpectedClientTypeException;
import com.ekwateur.testtechnique.exceptions.UnexpectedValueException;
import com.ekwateur.testtechnique.repositories.ClientRepo;
import com.ekwateur.testtechnique.utils.EnergyType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepository;

    public ClientServiceImpl(final ClientRepo clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public double getTotalTarif(final String reference) throws UnexpectedValueException, UnexpectedClientTypeException {
        Client client = clientRepository.findByReference(reference);
        return switch (client) {
            case ParticularClient particularClient -> {
                float electricityTarif = particularClient.getEnergyTarif(EnergyType.ELECTRICITY);
                float gazTarif = particularClient.getEnergyTarif(EnergyType.GAZ);
                double electricityConsumption = particularClient.getEnergyConsumptions().stream()
                        .filter(ec -> ec.getEnergyType().equals(EnergyType.ELECTRICITY))
                        .mapToDouble(EnergyConsumption::getConsumption)
                        .sum();
                double gazConsumption = particularClient.getEnergyConsumptions().stream()
                        .filter(ec -> ec.getEnergyType().equals(EnergyType.GAZ))
                        .mapToDouble(EnergyConsumption::getConsumption)
                        .sum();
                yield (electricityTarif * electricityConsumption + gazTarif * gazConsumption);
            }

            case ProfessionalClient professionalClient -> {
                float electricityTarif = professionalClient.getEnergyTarif(EnergyType.ELECTRICITY);
                float gazTarif = professionalClient.getEnergyTarif(EnergyType.GAZ);
                double electricityConsumption = professionalClient.getEnergyConsumptions().stream()
                        .filter(ec -> ec.getEnergyType().equals(EnergyType.ELECTRICITY))
                        .mapToDouble(EnergyConsumption::getConsumption)
                        .sum();
                double gazConsumption = professionalClient.getEnergyConsumptions().stream()
                        .filter(ec -> ec.getEnergyType().equals(EnergyType.GAZ))
                        .mapToDouble(EnergyConsumption::getConsumption)
                        .sum();
                yield (electricityTarif * electricityConsumption + gazTarif * gazConsumption);
            }
            default -> throw new UnexpectedClientTypeException("There was an error detecting the client type");
        };

    }
}
