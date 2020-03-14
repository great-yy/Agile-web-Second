import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokersTest {

    Pokers poker = new Pokers();

    @BeforeEach
    void setUp() {
        System.out.println("开始测试");
    }

    @AfterEach
    void tearDown() {
        System.out.println("结束测试");
    }

    @org.junit.jupiter.api.Test
    void checkWinner() {
        assertEquals("White wins", poker.GetWinner("2H 3D 5S 9C KD", "2C 3H 4S 8C AH"));
        assertEquals("Black wins", poker.GetWinner("2H 4S 4C 2D 4H", "2S 8S AS QS 3S"));
        assertEquals("Black wins", poker.GetWinner("2H 3D 5S 9C KD", "2C 3H 4S 8C KH"));
        assertEquals("Tie", poker.GetWinner("2H 3D 5S 9C KD", "2D 3H 5C 9S KH"));
    }

    @org.junit.jupiter.api.Test
    void checkPokerType() {
        assertEquals(0, poker.JudgePokerType("2H 3D 5S 9C KD"));
        assertEquals(1, poker.JudgePokerType("2H 2D 5S 9C KD"));
        assertEquals(2, poker.JudgePokerType("2H 2D 5S 9C 5D"));
        assertEquals(3, poker.JudgePokerType("2H 2D 2S 9C KD"));
        assertEquals(4, poker.JudgePokerType("2H 3D 5S 6C 4D"));
        assertEquals(5, poker.JudgePokerType("2D 3D 5D 9D KD"));
        assertEquals(6, poker.JudgePokerType("2H 3D 2S 3C 3D"));
        assertEquals(7, poker.JudgePokerType("2H 2D 2S 2C KD"));
        assertEquals(8, poker.JudgePokerType("2D 3D 5D 4D 6D"));
    }

    @org.junit.jupiter.api.Test
    void IsFlush() {
        assertEquals(true, poker.IsFlush("2S 8S AS QS 3S"));
        assertEquals(false, poker.IsFlush("2S 8D AS QS 3S"));
    }

    @org.junit.jupiter.api.Test
    void IsStraight() {
        assertEquals(true, poker.IsStraight("9S 8S JS TS QS"));
        assertEquals(false, poker.IsStraight("2S 8D AS QS 3S"));
    }

    @org.junit.jupiter.api.Test
    void JudgeSameNum() {
        assertEquals(1, poker.JudgeSameNum("2H 3D 5S 9C KD"));
        assertEquals(2, poker.JudgeSameNum("2H 2D 5S 9C KD"));
        assertEquals(3, poker.JudgeSameNum("KS 2H KC 2D KD"));
    }

    @org.junit.jupiter.api.Test
    void JudgeDouNum() {
        assertEquals(0, poker.JudgeDouNum("2H 3D 5S 9C KD"));
        assertEquals(1, poker.JudgeDouNum("2H 2D 5S 9C KD"));
        assertEquals(2, poker.JudgeDouNum("2H 9D KS 2C KD"));
        assertEquals(1, poker.JudgeDouNum("2H KS KC KD 2D"));
    }

    @Test
    void compareBiggest0() {
        assertEquals("White wins", poker.GetWinner("2H 3D 5S 9C KD", "2C 3H 4S 8C AH"));
    }

    @Test
    void compareBiggest1() {
        assertEquals("White wins", poker.GetWinner("2H KD KS 9C 9D", "2C 8H 8S AC AH"));
        assertEquals("Black wins", poker.GetWinner("AH 5D 5S 9C AD", "AC 3H 4S 3C AH"));
        assertEquals("Black wins", poker.GetWinner("2H KD 3S 9C KD", "2C 4H 8S 8C AH"));
        assertEquals("White wins", poker.GetWinner("2H 5D 5S 9C JD", "2C 3H 4S AC AH"));
        assertEquals("Black wins", poker.GetWinner("AH 5D 5S 9C AD", "AC 5H 4S 5C AH"));
    }

    @Test
    void compareBiggest2() {
        assertEquals("Black wins", poker.GetWinner("2H KD KS 9C KD", "2C 8H 8S 8C AH"));
        assertEquals("White wins", poker.GetWinner("2H 5D 5S 9C 5D", "AC 3H 4S AC AH"));
    }

}