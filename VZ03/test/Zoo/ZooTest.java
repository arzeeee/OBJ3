/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zoo;

import zoo.Zoo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rizky Faramita 13515055@std.stei.itb.ac.id
 * @version 1.1 (current version number of program)
 * @since 1.1 (the version of the package this class was first added to)
 */
public class ZooTest {
    
    public ZooTest() {
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
     * Test of getElementZoo method, of class Zoo.
     */
    @Test
    public void testGetElementZoo() {
        System.out.println("getElementZoo dites bersama setElementZoo");
    }

    /**
     * Test of printZoo method, of class Zoo.
     */
    @Test
    public void testPrintZoo() {
        System.out.println("printZoo");
        int nbrs = 2;
        int nkol = 2;
        Zoo instance = new Zoo(nbrs,nkol);
        instance.setElementZoo(0,0,1);
        instance.setElementZoo(0,1,2);
        instance.setElementZoo(1,0,3);
        instance.setElementZoo(1,1,-1);
        instance.printZoo(nbrs, nkol);
        //test case cek char terakhir
        int expFourthChar = -1;
        int resultFourthChar = instance.getElementZoo(1,1);
        assertEquals(expFourthChar, resultFourthChar);
    }

    /**
     * Test of setElementZoo method, of class Zoo.
     */
    @Test
    public void testSetElementZoo() {
        System.out.println("setElementZoo");
        //test case menggunakan animal kucing
        int x = 0;
        int y = 0;
        int k = 1;
        Zoo instance = new Zoo();
        instance.setElementZoo(x, y, k);
        int expAnimalId = k;
        //sekaligus mengecek method getElementZoo
        int resultAnimalId = instance.getElementZoo(0,0);
        assertEquals(expAnimalId, resultAnimalId);
    }  
}
