package com.ekwateur.testtechnique.entities;

import com.ekwateur.testtechnique.exceptions.UnexpectedValueException;
import com.ekwateur.testtechnique.utils.EnergyType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Client {
    @Id
    private String reference;

    @OneToMany(mappedBy = "client")
    private Set<EnergyConsumption> energyConsumptions;

    public abstract float getEnergyTarif(EnergyType type) throws UnexpectedValueException;

    public void addConsumption(EnergyConsumption energyConsumption) {
        this.energyConsumptions.stream()
                        .filter(ec -> ec.getEnergyType().equals(energyConsumption.getEnergyType()))
                        .findFirst()
                        .ifPresentOrElse(ec -> ec.setConsumption(ec.getConsumption() + energyConsumption.getConsumption()),
                                () -> this.energyConsumptions.add(energyConsumption));
    }
}
