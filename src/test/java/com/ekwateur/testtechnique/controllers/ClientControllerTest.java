package com.ekwateur.testtechnique.controllers;

import com.ekwateur.testtechnique.entities.ParticularClient;
import com.ekwateur.testtechnique.entities.ProfessionalClient;
import com.ekwateur.testtechnique.utils.Civility;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(ClientController.class)
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    MockMvc mockMvc;

    // setup
    @BeforeEach
    void setUp() {
    }
}
