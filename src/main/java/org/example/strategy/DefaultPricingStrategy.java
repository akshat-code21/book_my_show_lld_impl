package org.example.strategy;

import org.example.entity.ShowSeat;
import org.example.enums.SeatType;

import java.util.HashMap;
import java.util.Map;

public class DefaultPricingStrategy implements PricingStrategy{
    private Map<SeatType,Integer> basePriceMap;

    public DefaultPricingStrategy(Map<SeatType, Integer> basePriceMap) {
        basePriceMap = new HashMap<>();
        basePriceMap.put(SeatType.BASIC, 150);
        basePriceMap.put(SeatType.GOLD, 300);
        basePriceMap.put(SeatType.DIAMOND, 500);
    }

    public Map<SeatType, Integer> getBasePriceMap() {
        return basePriceMap;
    }

    public void setBasePriceMap(Map<SeatType, Integer> basePriceMap) {
        this.basePriceMap = basePriceMap;
    }

    @Override
    public int apply(ShowSeat ss) {
        return basePriceMap.get(ss.getSeat().getSeatType());
    }
}
