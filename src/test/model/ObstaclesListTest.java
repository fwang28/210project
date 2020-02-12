package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObstaclesListTest {
    private ObstaclesList testObstaclesList;
    @BeforeEach
    void runBefore() {
        testObstaclesList = new ObstaclesList();
    }

    @Test
    void testConstructor() {
        assertEquals(ObstaclesList.obstacleList.size(), 0);
    }

    @Test
    void testAddObstacle() {
        testObstaclesList.addObstacle();
        assertEquals(ObstaclesList.obstacleList.size(), 1);
        assertEquals(ObstaclesList.obstacleList.get(0).posX, Game.WIDTH);
        testObstaclesList.addObstacle();
        assertEquals(ObstaclesList.obstacleList.size(), 2);
        assertEquals(ObstaclesList.obstacleList.get(1).posX, Game.WIDTH);
        testObstaclesList.addObstacle();
    }

    @Test
    void testCheckCollide() {
        Player testPlayer = new Player(400);
        testObstaclesList.addObstacle();
        ObstaclesList.obstacleList.get(0).posY = 400;
        ObstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2;
        assertTrue(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2 + Obstacle.width / 2 + 1;
        assertFalse(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2 + Obstacle.width / 2;
        assertFalse(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posX = Player.XPOS + testPlayer.width / 2 + Obstacle.width / 2 - 1;
        assertTrue(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posX = Player.XPOS - testPlayer.width / 2 - Obstacle.width / 2 - 1;
        assertFalse(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posX = Player.XPOS - testPlayer.width / 2 - Obstacle.width / 2;
        assertFalse(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posX = Player.XPOS - testPlayer.width / 2 - Obstacle.width / 2 + 1;
        assertTrue(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posY = testPlayer.ypos + testPlayer.height / 2 + Obstacle.height / 2 + 1;
        assertFalse(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posY = testPlayer.ypos + testPlayer.height / 2 + Obstacle.height / 2;
        assertFalse(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posY = testPlayer.ypos + testPlayer.height / 2 + Obstacle.height / 2 - 1;
        assertTrue(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posY = testPlayer.ypos - testPlayer.height / 2 - Obstacle.height / 2 - 1;
        assertFalse(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posY = testPlayer.ypos - testPlayer.height / 2 - Obstacle.height / 2;
        assertFalse(ObstaclesList.checkCollide(testPlayer));
        ObstaclesList.obstacleList.get(0).posY = testPlayer.ypos - testPlayer.height / 2 - Obstacle.height / 2 + 1;
        assertTrue(ObstaclesList.checkCollide(testPlayer));
    }

    @Test
    void testUpdate() {
        testObstaclesList.addObstacle();
        testObstaclesList.addObstacle();
        ObstaclesList.obstacleList.get(0).posY = 400;
        ObstaclesList.obstacleList.get(0).posX = 200;
        ObstaclesList.obstacleList.get(1).posY = 500;
        ObstaclesList.obstacleList.get(1).posX = 300;
        testObstaclesList.update();
        assertEquals(ObstaclesList.obstacleList.get(0).posY, 400);
        assertEquals(ObstaclesList.obstacleList.get(1).posY, 500);
        assertEquals(ObstaclesList.obstacleList.get(0).posX, 200 + Obstacle.dx);
        assertEquals(ObstaclesList.obstacleList.get(1).posX, 300 + Obstacle.dx);
    }
}