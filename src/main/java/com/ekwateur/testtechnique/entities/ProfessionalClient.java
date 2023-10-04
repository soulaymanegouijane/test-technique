package com.ekwateur.testtechnique.entities;

import com.ekwateur.testtechnique.exceptions.UnexpectedValueException;
import com.ekwateur.testtechnique.utils.EnergyType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalClient extends Client implements Serializable {
    private String siretNumber;
    private String companyName;
    private double companyTurnover;

    private float getGazTarif() throws UnexpectedValueException  {
        return switch (companyTurnover>100000?0:1){
            case 0 -> 0.111f;
            case 1 -> 0.113f;
            default -> throw new UnexpectedValueException("Unexpected value: " + companyTurnover + " is not in a valid range");
        };
    }
    private float getElectricityTarif() throws UnexpectedValueException {
        return switch (companyTurnover>100000?0:1){
            case 0 -> 0.114f;
            case 1 -> 0.118f;
            default -> throw new UnexpectedValueException("Unexpected value: " + companyTurnover + " is not in a valid range");
        };
    }
    @Override
    public float getEnergyTarif(EnergyType type) throws UnexpectedValueException {
        return switch (type){
            case ELECTRICITY -> getElectricityTarif();
            case GAZ -> getGazTarif();
        };
    }
}
