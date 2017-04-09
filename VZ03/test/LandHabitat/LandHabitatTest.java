/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LandHabitat;

import landHabitat.LandHabitat;
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
public class LandHabitatTest {
    
    public LandHabitatTest() {
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
        System.out.println("LandHabitat Constructor");
        LandHabitat instance = new LandHabitat();
        int expResult = 1;
        int result = instance.getNilaiCell();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCopyCons() {
        System.out.println("LandHabitat CopyConstructor");
        LandHabitat instance = new LandHabitat();
        LandHabitat copy_instance = new LandHabitat(instance);
        int expResult = instance.getNilaiCell();
        int result = copy_instance.getNilaiCell();
        assertEquals(expResult, result);
    }
    
}
