import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class test {
    @Test
    public void testTrue(){
        assertTrue(main.luckyTicket(123321));
    }

    @Test
    public void testFalse(){
        assertFalse(main.luckyTicket(123456));
    }

    @Test
    public void testBreak1(){
        assertFalse(main.luckyTicket(21111));
    }

    @Test
    public void testBreak2(){
        assertFalse(main.luckyTicket(1111193));
    }
}
