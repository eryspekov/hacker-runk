package interview_preparation_kit.sorting.comparator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void main() {

        int n = 5;
        Player[] players = new Player[n];
        players[0] = new Player("amy", 100);
        players[1] = new Player("david", 100);
        players[2] = new Player("heraldo", 50);
        players[3] = new Player("aakansha", 75);
        players[4] = new Player("aleksa", 150);

        Arrays.sort(players, new Checker());

        Player[] ordered = new Player[n];
        ordered[0] = new Player("aleksa", 150);
        ordered[1] = new Player("amy", 100);
        ordered[2] = new Player("david", 100);
        ordered[3] = new Player("aakansha", 75);
        ordered[4] = new Player("heraldo", 50);
        assertArrayEquals(players, ordered);

    }
}