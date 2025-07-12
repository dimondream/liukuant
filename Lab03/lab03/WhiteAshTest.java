package lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The WhiteAshTest class for the third Lab in CSC207, Fall 2022.
 * WhiteAshTest serves to test the WhiteAsh class
 */
class WhiteAshTest {
    
    @Test
    void grow() {
        WhiteAsh t = new WhiteAsh(30);
        t.grow(2.0);
        assertEquals(30.6,t.getDiameter());
    }

    @Test
    void carbonContent() {
        WhiteAsh t = new WhiteAsh(30);
        assertEquals(247.0,Math.round(t.carbonContent()));
    }

    @Test
    void equals() {
        WhiteAsh t = new WhiteAsh(30);
        WhiteAsh w = new WhiteAsh(40);
        WhiteAsh i = new WhiteAsh(30);
        assertEquals(t.equals(w),false);
        assertEquals(t.equals(i),true);
    }

    @Test
    void hashcode(){
        WhiteAsh t = new WhiteAsh(30);
        WhiteAsh w = new WhiteAsh(40);
        WhiteAsh i = new WhiteAsh(30);
        assertEquals(t.hashCode() == w.hashCode(),false);
        assertEquals(i.hashCode() == t.hashCode(),true);
        i.fellTree();
        assertEquals(i.hashCode() == t.hashCode(),false);

    }

    //Make sure to add your own tests, too!!

}