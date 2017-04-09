/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cages;

import cages.Cages;
import cage.Cage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
public class CagesTest {
    
    public CagesTest() {
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
     * Test of GetArrayCage method of class Cages.
     */
    @Test
    public void testGetArrayCage() {
        System.out.println("getArrayCage");
        //test case pada ctor tanpa parameter
        Cages instanceNoParam = new Cages();
        Cage[] expArrayNoParam = new Cage[0];
        Cage[] resultArrayNoParam = instanceNoParam.getArrayCage();
        assertArrayEquals(expArrayNoParam, resultArrayNoParam);
        //test case pada ctor dengan parameter
        Cages instanceParam = new Cages(1);
        Cage[] expArrayParam = new Cage[1];
        Cage[] resultArrayParam = instanceParam.getArrayCage();
        assertArrayEquals(expArrayParam, resultArrayParam);
        //test case pada cctor
        Cages instanceCctor = new Cages(2);
        Cages itemCctor = new Cages(instanceCctor);
        Cage[] expArrayCctor = instanceCctor.getArrayCage();
        Cage[] resultArrayCctor = itemCctor.getArrayCage();
        assertArrayEquals(expArrayCctor, resultArrayCctor);  
    }

    /**
     * Test of getCage method of class Cages.
     */
    @Test
    public void testGetCage() {
        System.out.println("getCage");
        //test case dengan Cage tanpa parameter
        Cage itemNoParam = new Cage();
        Cages instanceNoParam = new Cages(2);
        instanceNoParam.setArrayCage(itemNoParam, 1);
        int expCageIdNoParam = itemNoParam.getCageId();
        int resultCageIdNoParam = instanceNoParam.getCage(1).getCageId();
        assertEquals(expCageIdNoParam, resultCageIdNoParam);
    }

    /**
     * Test of setArrayCages method of class Cages.
     */
    @Test
    public void testSetArrayCages() {
        System.out.println("setArrayCages");
        
        //test case pada i=1 dan ctor Cage tanpa parameter
        Cages instanceNoParam = new Cages(2);
        Cage itemNoParam = new Cage();
        instanceNoParam.setArrayCage(itemNoParam, 1);
        Cage expCageNoParam = itemNoParam;
        Cage resultCageNoParam = instanceNoParam.getCage(1);
        assertEquals(expCageNoParam, resultCageNoParam);
        
        //test case pada i=1 dan ctor dengan param x=1, y=1, id=1, 
        //animal_id=1
        Cages instanceParam = new Cages(2);
        Cage itemParam = new Cage(1,1,1,1);
        instanceParam.setArrayCage(itemParam, 1);
        //test case untuk animal_id 1
        int expAnimalId = 1;
        //test case mengambil elemen pertama
        int resultAnimalId = instanceParam.getCage(1).getAnimalId();
        assertEquals(expAnimalId, resultAnimalId);
        
        //test case pada cctor
        Cages sample = new Cages(3);
        Cages instanceCctor = new Cages(sample);
        Cage itemCctor = new Cage (2,2,2,2);
        instanceCctor.setArrayCage(itemCctor,2);
        //test case untuk cage_id 2
        int expCageId = 2;
        //test case diambil elemen ketiga
        int resultCageId = instanceCctor.getCage(2).getCageId();
        assertEquals(expCageId, resultCageId);
    }

    /**
     * Test of GetNeff method of class Cages.
     */
    @Test
    public void testGetNeff() {
        System.out.println("getNeff");
        //test case pada ctor tanpa parameter
        Cages instanceNoParam = new Cages();
        int expNeffNoParam = 0;
        int resultNeffNoParam = instanceNoParam.getNeff();
        assertEquals(expNeffNoParam, resultNeffNoParam);
        
        //test case pada ctor dengan parameter
        Cages instanceParam = new Cages(1);
        int expNeffParam = 1;
        int resultNeffParam = instanceParam.getNeff();
        assertEquals(expNeffParam, resultNeffParam);
        
        //test case pada cctor
        Cages instanceCctor = new Cages(2);
        Cages itemCctor = new Cages(instanceCctor);
        int expNeffCctor = instanceCctor.getNeff();
        int resultNeffCctor = itemCctor.getNeff();
        assertEquals(expNeffCctor, resultNeffCctor);
    }

    /**
     * Test of SetIdx method of class Cages.
     */
    @Test
    public void testSetIdx() {
        System.out.println("setIdx");
        
        //test case pada neff=1 dan ctor Cage tanpa parameter
        Cages instanceNoParam = new Cages(1);
        Cage itemNoParam = new Cage();
        instanceNoParam.setIdx(itemNoParam);
        Cage expCageNoParam = itemNoParam;
        Cage resultCageNoParam = instanceNoParam.getCage(0);
        assertEquals(expCageNoParam, resultCageNoParam);
        
        //test case pada neff=2 dan ctor dengan param x=1, y=1, id=1, 
        //animal_id=1
        Cages instanceParam = new Cages(2);
        Cage itemParam = new Cage(1,1,1,1);
        instanceParam.setIdx(itemParam);
        //test case untuk animal_id 1
        int expAnimalId = 1;
        //test case diambil elemen kedua
        int resultAnimalId = instanceParam.getCage(1).getAnimalId();
        assertEquals(expAnimalId, resultAnimalId);
        
        //test case pada cctor
        Cages sample = new Cages(3);
        Cages instanceCctor = new Cages(sample);
        Cage itemCctor = new Cage (2,2,2,2);
        instanceCctor.setIdx(itemCctor);
        //test case untuk cage_id 2
        int expCageId = 2;
        //test case diambil elemen ketiga
        int resultCageId = instanceCctor.getCage(2).getCageId();
        assertEquals(expCageId, resultCageId);
    }
}
