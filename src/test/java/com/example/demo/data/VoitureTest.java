package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture() {

        Voiture voiture = new Voiture();
        int expectedId = 1;
        String expectedMarque = "Renault";
        int expectedPrice = 20000;


        voiture.setId(expectedId);
        voiture.setString(expectedMarque);
        voiture.setPrice(expectedPrice);

        assertEquals(expectedId, voiture.getId());
        assertEquals(expectedMarque, voiture.getString());
        assertEquals(expectedPrice, voiture.getPrice());

        String toStringResult = voiture.toString();
        assertTrue(toStringResult.contains("id=" + expectedId));
    }

    @Test
    void testDefaultValues() {
        Voiture voiture = new Voiture();
        assertEquals(0, voiture.getId());
        assertNull(voiture.getString());
        assertEquals(0, voiture.getPrice());
    }
}