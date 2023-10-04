package com.ekwateur.testtechnique.entities;

import com.ekwateur.testtechnique.utils.EnergyType;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

/**
 * EnergyConsumption entity.
 * used to persist energy consumption data
 */
@Entity
@Data
public class EnergyConsumption implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated
    private EnergyType energyType;

    private double consumption;
    /**
     * this is a relation between EnergyConsumption and Client entities
     * it is a many-to-one relation where many energy consumptions can be linked to one client
     */
    @ManyToOne
    @JoinColumn(name = "client_reference")
    private Client client;
}
