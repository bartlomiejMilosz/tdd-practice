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
        positions.put(symbol, position);
    }

    public Position getPositions(String symbol) {
        return positions.get(symbol);
    }
}