package animal;

import renderable.Renderable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahdiar Naufal.
 */
public abstract class Animal implements Renderable{
  //Atribut
  public int weight;
  public int tipe;
  public int location_x;
  public int location_y;
  public boolean tamed;
  //Abstract method
  public abstract void Eat();
  public abstract void Interact();   
 //setter
  public void setWeight(int x) {
    weight = x;
  }
  public void setTipe (int x) {
    tipe = x;
  }
  public void setTamed (boolean x) {
    tamed = x;
  }
  public void setX (int x) {
    location_x = x;
  }
  public void setY (int y) {
    location_y = y;
  }   
  //getter
  public int getWeight() {
    return weight;
  }
    
  public int getTipe() {
    return tipe;
  }
  public boolean getTamed () {
    return tamed;
  }
  public int getX () {
    return location_x;
  }
  public int getY () {
    return location_y;
  }
}
