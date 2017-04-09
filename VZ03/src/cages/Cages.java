/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cages;

import cage.Cage;


/**
 *
 * @author Rizky Faramita 13515055@std.stei.itb.ac.id
 */
public class Cages {
    /**
     * array of Cage dengan id yang sama
     */
    private Cage[] array_cage;
    
    /**
     * ukuran array of Cage
     */
    private int neff;
    
    /**
     * ctor tanpa parameter
     */
    public Cages() {
       neff = 0;
       array_cage = new Cage[neff]; 
    }
    
    /**
     * ctor dengan parameter
     * @param _neff masukan untuk ukuran array
     */
    public Cages(int _neff) {
        neff = _neff;
        array_cage = new Cage[neff];
    }
    
    /**
     * cctor
     * @param c c objek cages yang ingin di-assign 
     */
    public Cages(final Cages c) {
        neff = c.neff;
        array_cage = new Cage[neff];
    }
    
    /**
     * getter elemen array
     * @return mengembalikan sebuah array of cage dengan id yang sama
     */
    public Cage[] getArrayCage(){
        return array_cage;
    }
    
    /**
     * getter suatu Cage yang berada di indeks ke-i pada Cages 
     * @param i indeks array yang elemennya ingin diambil
     * @return Cage yang ingin diambil
     */
    public Cage getCage(int i) {
        return array_cage[i];
    }
    
    /**
     * meng-assign cage c ke array pada indeks i
     * @param c cage yang ingin dimasukkan
     * @param i indeks meletakkan cage
     * @return sebuah Cages yang telah memuat Cage c pada indeks ke-i
     */
    public Cages setArrayCage(Cage c, int i) {
        array_cage[i] = c;
        return this;
    }
    
    /**
     * getter ukuran array
     * @return neff (ukuran array)
     */
    public int getNeff(){
        return neff;
    }
    
    /**
     * meng-assign seluruh elemen array dengan suatu cage dengan id yang sama
     * @param _cage cage yang diassign ke dalam array of cage
     */
    public void setIdx(Cage _cage){
       for (int i = 0; i < neff; i ++){
           array_cage[i] = _cage;
       } 
    }
}
