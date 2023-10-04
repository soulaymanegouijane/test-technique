package com.ekwateur.testtechnique.dtos;

/**
 * ClientDTO.
 * this object is used to return the client information
 * @param clientReference the client reference
 * @param clientType the client type
 * @param clientName the client name
 * @param clientSiret the client siret if the client is a professional client
 */
public record ClientDTO(
        String clientReference,
        String clientType,
        String clientName,
        String clientSiret
) {}
