package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture() {
        // Given
        Voiture voiture = new Voiture();
        int expectedId = 1;
        String expectedMarque = "Renault";
        int expectedPrice = 20000;

        // When
        voiture.setId(expectedId);
        voiture.setString(expectedMarque);
        voiture.setPrice(expectedPrice);

        // Then
        assertEquals(expectedId, voiture.getId());
        assertEquals(expectedMarque, voiture.getString());
        assertEquals(expectedPrice, voiture.getPrice());

        // Test toString contains id
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