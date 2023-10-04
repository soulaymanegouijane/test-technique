package com.ekwateur.testtechnique.entities;

import com.ekwateur.testtechnique.exceptions.UnexpectedValueException;
import com.ekwateur.testtechnique.utils.EnergyType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ProfessionalClient entity.
 * used to persist professional client data, and it inherits from Client entity
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalClient extends Client implements Serializable {
    private String siretNumber;
    private String companyName;
    private double companyTurnover;

    /**
     * this method is used to get the gaz tarif for a professional client.
     * @return the gaz tarif
     * @throws UnexpectedValueException thrown when the turnover is not in the valid range
     */
    private float getGazTarif() throws UnexpectedValueException  {
        return switch (companyTurnover>100000?0:1){
            case 0 -> 0.111f;
            case 1 -> 0.113f;
            default -> throw new UnexpectedValueException("Unexpected value: " + companyTurnover + " is not in a valid range");
        };
    }
    /**
     * this method is used to get the electricity tarif for a professional client.
     * @return the electricity tarif
     * @throws UnexpectedValueException thrown when the turnover is not in the valid range
     */
    private float getElectricityTarif() throws UnexpectedValueException {
        return switch (companyTurnover>100000?0:1){
            case 0 -> 0.114f;
            case 1 -> 0.118f;
            default -> throw new UnexpectedValueException("Unexpected value: " + companyTurnover + " is not in a valid range");
        };
    }

    /**
     * this method is used to get the energy tarif for a professional client.
     * @param type the energy type
     * @return the energy tarif
     * @throws UnexpectedValueException thrown when the turnover is not in the valid range
     */
    @Override
    public float getEnergyTarif(EnergyType type) throws UnexpectedValueException {
        return switch (type){
            case ELECTRICITY -> getElectricityTarif();
            case GAZ -> getGazTarif();
        };
    }
}
