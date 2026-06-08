package com.example.demo.service;

import com.example.demo.data.Voiture;
import java.util.ArrayList;
import java.util.List;

public class StatistiqueImpl implements Statistique {
    private final List<Voiture> voitures = new ArrayList<>();

    @Override
    public void ajouter(Voiture voiture) {
        voitures.add(voiture);
    }

    @Override
    public int prix() throws ArithmeticException {
        if (voitures.isEmpty()) {
            throw new ArithmeticException("No cars available");
        }

        int totalOriginal = voitures.stream().mapToInt(Voiture::getPrice).sum();
        int count = voitures.size();
        int groups = count / 5;
        double discountRate = groups * 0.05;
        if (discountRate > 1.0) {
            discountRate = 1.0;
        }

        double totalDiscounted = totalOriginal * (1 - discountRate);
        double discountAmount = totalOriginal - totalDiscounted;

        if (discountAmount > 20000) {
            totalDiscounted = totalOriginal - 20000;
        }

        return (int) Math.round(totalDiscounted);
    }
}