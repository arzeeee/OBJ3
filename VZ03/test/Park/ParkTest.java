/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Park;

import park.Park;
import waterHabitat.WaterHabitat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aya Aurora
 */
public class ParkTest {
    
    public ParkTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCons() {
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Park Constructor");
        Park instance = new Park();
        int expResult = -2;
        int result = instance.getNilaiCell();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCopyCons() {
        System.out.println("Park CopyConstructor");
        Park instance = new Park();
        Park copy_instance = new Park(instance);
        int expResult = instance.getNilaiCell();
        int result = copy_instance.getNilaiCell();
        assertEquals(expResult, result);
    }
    
}
