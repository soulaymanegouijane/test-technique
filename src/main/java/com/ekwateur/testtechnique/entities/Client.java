package com.ekwateur.testtechnique.entities;

import com.ekwateur.testtechnique.exceptions.UnexpectedValueException;
import com.ekwateur.testtechnique.utils.EnergyType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * Client entity.
 * this Class is used as a super Class for the Client types (ParticularClient and ProfessionalClient)
 * it contains the common attributes and methods for the Client types
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Client {
    /**
     * the client reference which is used as an ID
     */
    @Id
    private String reference;
    /**
     * the client energy consumptions (electricity and gaz)
     */
    @OneToMany(mappedBy = "client")
    private Set<EnergyConsumption> energyConsumptions;

    /**
     * getEnergyTarif.
     * this method will be implemented by each client type to return the energy tarif
     * @param type the energy type
     * @return the energy tarif
     * @throws UnexpectedValueException thrown when the client turnover is not in a valid range
     */
    public abstract float getEnergyTarif(EnergyType type) throws UnexpectedValueException;

    public void addConsumption(EnergyConsumption energyConsumption) {
        this.energyConsumptions.stream()
                        .filter(ec -> ec.getEnergyType().equals(energyConsumption.getEnergyType()))
                        .findFirst()
                        .ifPresentOrElse(ec -> ec.setConsumption(ec.getConsumption() + energyConsumption.getConsumption()),
                                () -> this.energyConsumptions.add(energyConsumption));
    }
}
