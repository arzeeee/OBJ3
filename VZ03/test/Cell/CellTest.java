/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cell;

import cell.Cell;
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
public class CellTest {
    
    public CellTest() {
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

    /**
     * Test of Constructor with Parameter method, of class Cell.
     */
    @Test
    public void testConsPramCell() {
        System.out.println("Cell Constructor dengan Parameter");
        Cell instance = new Cell(2);
        int expResult = 2;
        int result = instance.getNilaiCell();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of Copy Constructor method, of class Cell.
     */
    @Test
    public void testCopyConsCell() {
        System.out.println("Cell Copy Constructor");
        Cell instance = new Cell(3);
        Cell copy_instance = new Cell(instance);
        int expResult = instance.getNilaiCell();
        int result = copy_instance.getNilaiCell();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getNilaiCell and Cell Constructor method, of class Cell.
     */
    @Test
    public void testGetNilaiCell() {
        System.out.println("getNilaiCell");
        Cell instance = new Cell();
        int expResult = 0;
        int result = instance.getNilaiCell();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNilaiCell method, of class Cell.
     */
    @Test
    public void testSetNilaiCell() {
        System.out.println("setNilaiCell");
        int nilai_cell = 0;
        Cell instance = new Cell();
        instance.setNilaiCell(nilai_cell);
    }   
}
