package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player testPlayer;

    @BeforeEach
    void runBefore() {
        testPlayer = new Player(Game.HEIGHT / 2);
    }

    @Test
    void testConstructor() {
        assertEquals(testPlayer.ypos, 400);
    }

    @Test
    void testMove() {
        testPlayer.moveDirection = 0;
        testPlayer.move(Game.HEIGHT);
        assertEquals(testPlayer.ypos, 400);
        testPlayer.moveDirection = 1;
        testPlayer.move(Game.HEIGHT);
        assertEquals(testPlayer.ypos, 400 + testPlayer.dy); // HEIGHT / 2 + dy
        testPlayer.moveDirection = -1;
        testPlayer.move(Game.HEIGHT);
        assertEquals(testPlayer.ypos, 400);
        testPlayer.move(Game.HEIGHT);
        assertEquals(testPlayer.ypos, 400 - testPlayer.dy);
    }

    @Test
    void testStayInBounds() {
        testPlayer.ypos = 0;
        testPlayer.stayInBounds(Game.HEIGHT);
        assertEquals(testPlayer.ypos, testPlayer.height / 2);
        testPlayer.ypos = 1234;
        testPlayer.stayInBounds(Game.HEIGHT);
        assertEquals(testPlayer.ypos, Game.HEIGHT - testPlayer.height / 2);
        testPlayer.ypos = 420;
        testPlayer.stayInBounds(Game.HEIGHT);
        assertEquals(testPlayer.ypos, 420);
    }

}
