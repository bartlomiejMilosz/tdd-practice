package io.github.bartlomiejmilosz.tdd.portfolio.finalimplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {
    private final Map<String, Position> positions;

    public Portfolio() {
        this.positions = new HashMap<>();
    }

    public Map<String, Position> getAllPositions() {
        return positions;
    }

    public void add(Position position) {
        String symbol = position.getStock().symbol();

        // If the position already exists, update it
        if (positions.containsKey(symbol)) {
            Position existingPosition = positions.get(symbol);
            int newQuantity = existingPosition.getQty() + position.getQty();
            double newAveragePx = (existingPosition.getQty() * existingPosition.getPx()
                    + position.getQty() * position.getPx()) / newQuantity;

            existingPosition.setQuantity(newQuantity);
            existingPosition.setAveragePx(newAveragePx);

        } else {
            positions.put(symbol, position);
        }
    }

    public Position getPositions(String symbol) {
        return positions.get(symbol);
    }
}