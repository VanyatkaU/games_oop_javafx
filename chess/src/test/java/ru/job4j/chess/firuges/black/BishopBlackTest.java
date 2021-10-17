package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell position = bishopBlack.position();
        assertThat(position, is(Cell.C8));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure copy = bishopBlack.copy(Cell.F5);
        assertThat(copy.position(), is(Cell.F5));
    }

    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expected, is(result));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void isDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.E1);
    }
}
