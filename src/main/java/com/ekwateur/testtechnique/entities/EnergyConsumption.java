package com.ekwateur.testtechnique.entities;

import com.ekwateur.testtechnique.utils.EnergyType;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity
@Data
public class EnergyConsumption implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated
    private EnergyType energyType;

    private double consumption;

    @ManyToOne
    @JoinColumn(name = "client_reference")
    private Client client;
}
