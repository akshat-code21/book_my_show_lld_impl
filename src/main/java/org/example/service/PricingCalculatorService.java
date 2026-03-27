package org.example.service;

import org.example.entity.MovieTicket;
import org.example.strategy.PricingStrategy;

import java.util.List;

public class PricingCalculatorService {
    private MovieTicket mt;
    private List<PricingStrategy> strategies;

    public PricingCalculatorService(MovieTicket mt, List<PricingStrategy> strategies) {
        this.mt = mt;
        this.strategies = strategies;
    }

    public MovieTicket getMt() {
        return mt;
    }

    public void setMt(MovieTicket mt) {
        this.mt = mt;
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
}
