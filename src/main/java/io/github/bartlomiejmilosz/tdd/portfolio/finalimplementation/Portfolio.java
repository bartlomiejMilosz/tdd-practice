package io.github.bartlomiejmilosz.tdd.portfolio.finalimplementation;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private final List<Position> positions;

    public Portfolio() {
        this.positions = new ArrayList<>();
    }

    public List<Position> getAllPositions() {
        return positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void add(Position position) {
        positions.add(position);
    }
}
