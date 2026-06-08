package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatistiqueImplTest {

    private StatistiqueImpl statistique;

    @BeforeEach
    void setUp() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void testAjouterAndPrixWithoutDiscount() {
        Voiture v1 = createVoiture(1, "Renault", 10000);
        Voiture v2 = createVoiture(2, "Peugeot", 15000);

        statistique.ajouter(v1);
        statistique.ajouter(v2);

        assertEquals(25000, statistique.prix());
    }

    @Test
    void testPrixWith5PercentDiscountFor5Cars() {
        for (int i = 0; i < 5; i++) {
            statistique.ajouter(createVoiture(i, "Car" + i, 10000));
        }
        assertEquals(47500, statistique.prix());
    }

    @Test
    void testPrixWith10PercentDiscountFor10Cars() {
        for (int i = 0; i < 10; i++) {
            statistique.ajouter(createVoiture(i, "Car" + i, 10000));
        }
        assertEquals(90000, statistique.prix());
    }

    @Test
    void testPrixWithDiscountCap() {
        for (int i = 0; i < 100; i++) {
            statistique.ajouter(createVoiture(i, "Car" + i, 1000));
        }
        assertEquals(80000, statistique.prix());
    }

    @Test
    void testPrixWithDiscountCapOnHigherPrices() {
        for (int i = 0; i < 10; i++) {
            statistique.ajouter(createVoiture(i, "Car" + i, 50000));
        }
        assertEquals(480000, statistique.prix());
    }

    @Test
    void testPrixThrowsExceptionWhenNoCars() {
        assertThrows(ArithmeticException.class, () -> statistique.prix());
    }

    @Test
    void testPrixRoundsCorrectly() {
        for (int i = 0; i < 5; i++) {
            statistique.ajouter(createVoiture(i, "Car" + i, 10001));
        }
        assertEquals(47505, statistique.prix());
    }

    private Voiture createVoiture(int id, String marque, int price) {
        Voiture v = new Voiture();
        v.setId(id);
        v.setString(marque);
        v.setPrice(price);
        return v;
    }
}