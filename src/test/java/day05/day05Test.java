package day05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class day05Test {

    @Test
    public void shouldFindSeat() {
        BoardingPass bp = new BoardingPass();
        bp.setCode("FBFBBFFRLR");
        int expectedRow = 44;
        int expectedColumn = 5;
        day05.findSeat(bp);
        assertEquals(expectedRow, bp.getRow());
        assertEquals(expectedColumn, bp.getColumn());
    }

    @Test
    public void shouldCountId() {
        BoardingPass bp = new BoardingPass();
        bp.setRow(44);
        bp.setColumn(5);
        int expectedId = 357;
        day05.countId(bp);
        assertEquals(expectedId, bp.getId());
    }

}