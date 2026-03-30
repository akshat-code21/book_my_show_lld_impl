package org.example.service;

import org.example.entity.ShowSeat;
import org.example.strategy.PricingStrategy;

import java.util.List;

public class PricingCalculatorService {
    private List<PricingStrategy> strategies;

    public PricingCalculatorService(List<PricingStrategy> strategies) {
        this.strategies = strategies;
    }

    public List<PricingStrategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<PricingStrategy> strategies) {
        this.strategies = strategies;
    }

    public void addStrategy(PricingStrategy strategy){
        this.strategies.add(strategy);
    }

    public int calculatePrice(ShowSeat ss) {
        return strategies.stream()
                .mapToInt(s -> s.apply(ss))
                .sum();
    }
}
