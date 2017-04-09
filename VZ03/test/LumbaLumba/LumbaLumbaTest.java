/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LumbaLumba;

import lumbaLumba.LumbaLumba;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mahdiar Naufal
 */
public class LumbaLumbaTest {
    
    public LumbaLumbaTest() {
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
     * Test of Eat method, of class LumbaLumba.
     */
    @Test
    public void testEat() {
        System.out.println("Eat");
        LumbaLumba instance = new LumbaLumba();
        instance.Eat();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Interact method, of class LumbaLumba.
     */
    @Test
    public void testInteract() {
        System.out.println("Interact");
        LumbaLumba instance = new LumbaLumba();
        instance.Interact();
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    /**
     * Testing Default parameter, of class LumbaLumba.
     */
    public void testDefault() {
        System.out.println("Test Default Parameter");
        LumbaLumba instance;
        instance = new LumbaLumba ();
        assertTrue(instance.getWeight() == 0);
        assertTrue(instance.getTipe() == 0);
        assertTrue(instance.getTamed() == false);
        assertTrue(instance.getX() == -1);
        assertTrue(instance.getY() == -1);
    }

    @Test
    /**
     * Testing parameter, of class LumbaLumba.
     */
    public void testParameter() {
        System.out.println("Test Parameter");
        LumbaLumba instance;
        instance = new LumbaLumba(100,1,true,10,5);
        assertTrue(instance.getWeight() == 100);
        assertTrue(instance.getTipe() == 1);
        assertTrue(instance.getTamed() == true);
        assertTrue(instance.getX() == 10);
        assertTrue(instance.getY() == 5);
    }
    
    @Test
    /**
     * Test copy constructor
     *
     */
    public void testCopyConstructor() {
        System.out.println("Test Copy constructor");
        LumbaLumba instance1,instance2;
        instance1 = new LumbaLumba(100,1,true,10,5);
        instance2 = new LumbaLumba(instance1);
        assertTrue(instance2.getWeight() == 100);
        assertTrue(instance2.getTipe() == 1);
        assertTrue(instance2.getTamed() == true);
        assertTrue(instance2.getX() == 10);
        assertTrue(instance2.getY() == 5);
    }
    
    @Test
    /**
     * Testing setter, of class LumbaLumba.
     */
    public void testSetter() {
        LumbaLumba instance;
        instance = new LumbaLumba();
        instance.setWeight(200);
        instance.setTipe(2);
        instance.setTamed(true);
        instance.setX(100);
        instance.setY(1000);
        assertTrue(instance.getWeight() == 200);
        assertTrue(instance.getTipe() == 2);
        assertTrue(instance.getTamed() == true);
        assertTrue(instance.getX() == 100);
        assertTrue(instance.getY() == 1000);
    }
    /**
     * Testing render.
     */
    @Test
    public void testRender() {
        LumbaLumba instance;
        instance = new LumbaLumba();
        instance.render();
        System.out.println();
    }
}
