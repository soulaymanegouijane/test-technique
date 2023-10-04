package com.ekwateur.testtechnique.dtos;

public record ClientDTO(
        String clientReference,
        String clientType,
        String clientName,
        String clientSiret
) {}
