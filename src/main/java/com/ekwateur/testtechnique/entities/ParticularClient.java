package com.ekwateur.testtechnique.entities;

import com.ekwateur.testtechnique.exceptions.UnexpectedValueException;
import com.ekwateur.testtechnique.utils.Civility;
import com.ekwateur.testtechnique.utils.EnergyType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ParticularClient entity.
 * used to persist particular client data and it inherits from Client entity
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticularClient extends Client implements Serializable {
    @Enumerated
    private Civility civility;
    private String firstName;
    private String lastName;

    /**
     * this method is used to get the energy tarif for a particular client
     * @param type the energy type which can be electricity or gaz
     * @return the energy tarif
     */
    @Override
    public float getEnergyTarif(EnergyType type) {
        return switch (type){
            case ELECTRICITY -> 0.121f;
            case GAZ -> 0.115f;
        };
    }
}
