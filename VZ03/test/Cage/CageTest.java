/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cage;

import cage.Cage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rizky Faramita <13515055 @ std.stei.itb.ac.id>
 * @version 1.1 (current version number of program)
 * @since 1.1 (the version of the package this class was first added to)
 */
public class CageTest {
    
    public CageTest() {
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
     * Test of GetX method, of class Cage.
     */
    @Test
    public void testGetX() {
        System.out.println("GetX");
        //test case pada ctor tanpa parameter
        Cage instanceNoParam = new Cage();
        int expResultNoParam = 0;
        int resultNoParam = instanceNoParam.getX();
        assertEquals(expResultNoParam, resultNoParam);
        //test case pada ctor dengan parameter
        Cage instanceParam = new Cage(1,1,1,1);
        int expResultParam = 1;
        int resultParam = instanceParam.getX();
        assertEquals(expResultParam, resultParam);
        //testcase pada cctor
        Cage instanceCctor = new Cage(2,2,2,2);
        Cage itemCctor = new Cage(instanceCctor);
        int expResultCctor = itemCctor.getX();
        int resultCctor = instanceCctor.getX();
        assertEquals(expResultCctor, resultCctor);        
    }

    /**
     * Test of GetY method of class Cage.
     */
    @Test
    public void testGetY() {
        System.out.println("GetY");
        //test case pada ctor tanpa parameter
        Cage instanceNoParam = new Cage();
        int expResultNoParam = 0;
        int resultNoParam = instanceNoParam.getY();
        assertEquals(expResultNoParam, resultNoParam);
        //test case pada ctor dengan parameter
        Cage instanceParam = new Cage(1,1,1,1);
        int expResultParam = 1;
        int resultParam = instanceParam.getY();
        assertEquals(expResultParam, resultParam);
        //testcase pada cctor
        Cage instanceCctor = new Cage(2,2,2,2);
        Cage itemCctor = new Cage(instanceCctor);
        int expResultCctor = itemCctor.getY();
        int resultCctor = instanceCctor.getY();
        assertEquals(expResultCctor, resultCctor); 
    }

    /**
     * Test of GetAnimal method, of class Cage.
     */
    @Test
    public void testGetAnimal() {
        System.out.println("GetAnimal");
        //test case pada ctor tanpa parameter
        Cage instanceNoParam = new Cage();
        int expResultNoParam = 0;
        int resultNoParam = instanceNoParam.getAnimalId();
        assertEquals(expResultNoParam, resultNoParam);
        //test case pada ctor dengan parameter
        Cage instanceParam = new Cage(1,1,1,1);
        int expResultParam = 1;
        int resultParam = instanceParam.getAnimalId();
        assertEquals(expResultParam, resultParam);
        //testcase pada cctor
        Cage instanceCctor = new Cage(2,2,2,2);
        Cage itemCctor = new Cage(instanceCctor);
        int expResultCctor = instanceCctor.getAnimalId();
        int resultCctor = itemCctor.getAnimalId();
        assertEquals(expResultCctor, resultCctor); 
    }

    /**
     * Test of GetId method of class Cage.
     */
    @Test
    public void testGetId() {
        System.out.println("GetId");
        //test case pada ctor tanpa parameter
        Cage instanceNoParam = new Cage();
        int expResultNoParam = 0;
        int resultNoParam = instanceNoParam.getCageId();
        assertEquals(expResultNoParam, resultNoParam);
        //test case pada ctor dengan parameter
        Cage instanceParam = new Cage(1,1,1,1);
        int expResultParam = 1;
        int resultParam = instanceParam.getCageId();
        assertEquals(expResultParam, resultParam);
        //testcase pada cctor
        Cage instanceCctor = new Cage(2,2,2,2);
        Cage itemCctor = new Cage(instanceCctor);
        int expResultCctor = itemCctor.getCageId();
        int resultCctor = instanceCctor.getCageId();
        assertEquals(expResultCctor, resultCctor); 
    }

    /**
     * Test of SetCage method, of class Cage.
     */
    @Test
    public void testSetCage() {
        System.out.println("SetCage");
          
        int _x = 1;
        int _y = 1;
        int _id = 1;
        int _animal_id = 1;
        Cage instance = new Cage();
        instance.setCage(_x, _y, _id, _animal_id);
        //test case param x
        int expResultX = 1;
        int resultX = instance.getX();
        assertEquals(expResultX, resultX);
        //test case param y
        int expResultY = 1;
        int resultY = instance.getY();
        assertEquals(expResultY, resultY);
        //test case param id
        int expResultId = 1;
        int resultId = instance.getCageId();
        assertEquals(expResultId, resultId);
        //test case param animal_id diambil contoh Animal Kucing
        //test case param weight
        int expKucingWeight = 10;
        int resultKucingWeight = instance.animal.getWeight();
        assertEquals(expKucingWeight, resultKucingWeight);
        //test case param tipe
        int expKucingTipe = 2;
        int resultKucingTipe = instance.animal.getTipe();
        assertEquals(expKucingTipe, resultKucingTipe);
        //test case param tamed
        boolean expKucingTamed = true;
        boolean resultKucingTamed = instance.animal.getTamed();
        assertEquals(expKucingTamed, resultKucingTamed);
        //test case param location_x
        int expKucingLocX = 1;
        int resultKucingLocX = instance.animal.getX();
        assertEquals(expKucingLocX, resultKucingLocX);
        //test case param location_y
        int expKucingLocY = 1;
        int resultKucingLocY = instance.animal.getY();
        assertEquals(expKucingLocY, resultKucingLocY);
    }
    
}
