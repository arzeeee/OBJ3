/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrance;

import entrance.Entrance;
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
public class EntranceTest {
    
    public EntranceTest() {
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
        System.out.println("Entrance Constructor");
        Entrance instance = new Entrance();
        int expResult = -4;
        int result = instance.getNilaiCell();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCopyCons() {
        System.out.println("Entrance CopyConstructor");
        Entrance instance = new Entrance();
        Entrance copy_instance = new Entrance(instance);
        int expResult = instance.getNilaiCell();
        int result = copy_instance.getNilaiCell();
        assertEquals(expResult, result);
    }
    
}
