package org.example.strategy;

import org.example.entity.ShowSeat;

public interface PricingStrategy {
    public int apply(ShowSeat ss);
}
