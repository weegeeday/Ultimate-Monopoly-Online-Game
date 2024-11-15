package test;
import com.nullPointer.Domain.Controller.PlayerController;
import com.nullPointer.Domain.Model.GameEngine;
import com.nullPointer.Domain.Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerControllerTest {

    PlayerController pController;
    Player p1;
    Player p2;

    @BeforeEach
    public void setUp() throws Exception {
        pController = PlayerController.getInstance();
        p1 = new Player("Player 1");
        p2 = new Player("Player 2");
        p1.setMoney(3200);
        p2.setMoney(3200);
        pController.addPlayer(p1);
        pController.addPlayer(p2);
    }

    @Test
    public void nextPlayer() {
        GameEngine.getInstance().setCurrentPlayer(p1);
        assertEquals(p2,pController.nextPlayer());
    }

    @Test
    public void putInJail() {
        pController.putInJail();
        assertTrue(pController.getCurrentPlayer().isInJail());
    }

    @Test
    public void getOutFromJail() {
        pController.getOutFromJail();
        assertFalse(pController.getCurrentPlayer().isInJail());
    }

    @Test
    public void movePlayer() {
        int targetPosition = 7;
        pController.movePlayer(targetPosition);
        assertEquals(targetPosition, pController.getCurrentPlayer().getTargetPosition());
    }

    @Test
    public void repOkCorrect() {
        assertTrue(pController.repOk());
    }

    @Test
    public void repOkIncorrect() {
        pController.getPlayers().clear();
        assertFalse(pController.repOk());
    }

}
