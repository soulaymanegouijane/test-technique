package com.ekwateur.testtechnique.dtos;

/**
 * TotalTarifResponseDTO.
 * this object is used to return the clients reference and the total amount to be paid
 * @param clientReference the client reference
 * @param totalTarif the total amount to be paid
 */
public record TotalTarifResponseDTO (
        String clientReference,
        double totalTarif
) {
}
