/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cage;

import animal.Animal;
import beruang.Beruang;
import bigBlueOct.BigBlueOct;
import cendrawasih.Cendrawasih;
import eastPacRedOct.EastPacRedOct;
import ebosia.Ebosia;
import elang.Elang;
import harimau.Harimau;
import hiuPutih.HiuPutih;
import jerapah.Jerapah;
import kelelawar.Kelelawar;
import kucing.Kucing;
import kuda.Kuda;
import lionfish.Lionfish;
import lumbaLumba.LumbaLumba;
import merpati.Merpati;
import okapi.Okapi;
import panda.Panda;
import penyu.Penyu;
import rajawali.Rajawali;
import singa.Singa;
import zebra.Zebra;

/**
 *
 * @author Rizky Faramita 13515055@std.stei.itb.ac.id
 */
public class Cage {
    /**
     * id dari tiap cage
     */
    private int cage_id;
    
    /**
     * absis pada map
     */
    private int x;
    
    /**
     * ordinat pada map
     */
    private int y;
    
    /**
     * id dari animal
     */
    private int animal_id;
    
    /**
     * atribut untuk membangkitkan animal tertentu, diganti melalui method SetCage
     */
    public Animal animal;
    
    /**
     * ctor tanpa parameter
     */
    public Cage(){
        cage_id = 0;
        x = 0;
        y = 0;
        animal_id = 0;
    }
    
    /**
     * ctor dengan dua parameter integer
     * @param _x masukan untuk absis 
     * @param _y masukan untuk ordinat
     * @param _cage_id masukan untuk id cage
     * @param _animal_id masukan untuk id animal
     */
    public Cage(int _x, int _y, int _cage_id, int _animal_id){
        cage_id = _cage_id;
        x = _x;
        y = _y;
        animal_id = _animal_id;
        switch (animal_id) {
            case 1:
                animal = new Kucing(10,2,true,x,y);
                break;
            case 2:
                animal = new Harimau(200,2,false,x,y);
                break;
            case 3:
                animal = new Singa(150,2,false,x,y);
                break;
            case 4:
                animal = new Jerapah(1200,1,true,x,y);
                break;
            case 5:
                animal = new Okapi(300,1,true,x,y);
                break;
            case 6:
                animal = new Panda(100,1,true,x,y);
                break;
            case 7:
                animal = new Beruang(150,2,false,x,y);
                break;
            case 8:
                animal = new Zebra(120,1,true,x,y);
                break;
            case 9:
                animal = new Kuda(120,1,true,x,y);
                break;
            case 10:
                animal = new Ebosia(120,2,true,x,y);
                break;
            case 11:
                animal = new Lionfish(5,2,true,x,y);
                break;
            case 12:
                animal = new LumbaLumba(50,2,true,x,y);
                break;
            case 13:
                animal = new HiuPutih(100,2,false,x,y);
                break;
            case 14:
                animal = new BigBlueOct(10,2,true,x,y);
                break;
            case 15:
                animal = new EastPacRedOct(10,2,true,x,y);
                break;
            case 16:
                animal = new Merpati(5,1,true,x,y);
                break;
            case 17:
                animal = new Rajawali(25,2,false,x,y);
                break;
            case 18:
                animal = new Elang(35,2,false,x,y);
                break;
            case 19:
                animal = new Kelelawar(10,2,false,x,y);
            case 20:
                animal = new Cendrawasih(5,1,true,x,y);
            case 21:
                animal = new Penyu(30,1,true,x,y);
            default:
                break;
        }
    }
    
    /**
     * cctor
     * @param c objek cage yang ingin di-assign 
     */
    public Cage(final Cage c) {
        cage_id = c.cage_id;
        x = c.x;
        y = c.y;
        animal_id = c.animal_id;
        switch (animal_id) {
            case 1:
                animal = new Kucing(10,2,true,x,y);
                break;
            case 2:
                animal = new Harimau(200,2,false,x,y);
                break;
            case 3:
                animal = new Singa(150,2,false,x,y);
                break;
            case 4:
                animal = new Jerapah(1200,1,true,x,y);
                break;
            case 5:
                animal = new Okapi(300,1,true,x,y);
                break;
            case 6:
                animal = new Panda(100,1,true,x,y);
                break;
            case 7:
                animal = new Beruang(150,2,false,x,y);
                break;
            case 8:
                animal = new Zebra(120,1,true,x,y);
                break;
            case 9:
                animal = new Kuda(120,1,true,x,y);
                break;
            case 10:
                animal = new Ebosia(120,2,true,x,y);
                break;
            case 11:
                animal = new Lionfish(5,2,true,x,y);
                break;
            case 12:
                animal = new LumbaLumba(50,2,true,x,y);
                break;
            case 13:
                animal = new HiuPutih(100,2,false,x,y);
                break;
            case 14:
                animal = new BigBlueOct(10,2,true,x,y);
                break;
            case 15:
                animal = new EastPacRedOct(10,2,true,x,y);
                break;
            case 16:
                animal = new Merpati(5,1,true,x,y);
                break;
            case 17:
                animal = new Rajawali(25,2,false,x,y);
                break;
            case 18:
                animal = new Elang(35,2,false,x,y);
                break;
            case 19:
                animal = new Kelelawar(10,2,false,x,y);
            case 20:
                animal = new Cendrawasih(5,1,true,x,y);
            case 21:
                animal = new Penyu(30,1,true,x,y);
            default:
                break;
        }
    }
    
    /**
     * getter absis
     * @return kordinat x
     */
    public int getX(){
        return x;
    }
    
    /**
     * getter ordinat
     * @return kordinat y
     */
    public int getY(){
        return y;
    }
    
    /**
     * getter jenis animal
     * @return id animal 
     */
    public int getAnimalId(){
        return animal_id;
    }
    
    /**
     * getter id cage
     * @return id cage
     */
    public int getCageId(){
        return cage_id;
    }
    
    /**
     * setter cage pada kordinat tertentu
     * @param _x absis
     * @param _y ordinat
     * @param _cage_id id dari cage
     * @param _animal_id id dari animal
     */
    public void setCage(int _x, int _y, int _cage_id, int _animal_id){
        x = _x;
        y = _y;
        cage_id = _cage_id;
        animal_id = _animal_id;
        switch (animal_id) {
            case 1:
                animal = new Kucing(10,2,true,x,y);
                break;
            case 2:
                animal = new Harimau(200,2,false,x,y);
                break;
            case 3:
                animal = new Singa(150,2,false,x,y);
                break;
            case 4:
                animal = new Jerapah(1200,1,true,x,y);
                break;
            case 5:
                animal = new Okapi(300,1,true,x,y);
                break;
            case 6:
                animal = new Panda(100,1,true,x,y);
                break;
            case 7:
                animal = new Beruang(150,2,false,x,y);
                break;
            case 8:
                animal = new Zebra(120,1,true,x,y);
                break;
            case 9:
                animal = new Kuda(120,1,true,x,y);
                break;
            case 10:
                animal = new Ebosia(120,2,true,x,y);
                break;
            case 11:
                animal = new Lionfish(5,2,true,x,y);
                break;
            case 12:
                animal = new LumbaLumba(50,2,true,x,y);
                break;
            case 13:
                animal = new HiuPutih(100,2,false,x,y);
                break;
            case 14:
                animal = new BigBlueOct(10,2,true,x,y);
                break;
            case 15:
                animal = new EastPacRedOct(10,2,true,x,y);
                break;
            case 16:
                animal = new Merpati(5,1,true,x,y);
                break;
            case 17:
                animal = new Rajawali(25,2,false,x,y);
                break;
            case 18:
                animal = new Elang(35,2,false,x,y);
                break;
            case 19:
                animal = new Kelelawar(10,2,false,x,y);
            case 20:
                animal = new Cendrawasih(5,1,true,x,y);
            case 21:
                animal = new Penyu(30,1,true,x,y);
            default:
                break;
        }
    }
}
