/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package landanimal;

import animal.Animal;
/**
 *
 * @author Mahdiar Naufal.
 */

public class LandAnimal extends Animal {
  //Constructor tanpa parameter

  /**
   * Constructor Tanpa Parameter.
   */
    
  public LandAnimal() {
    weight = 0;
    tipe = 0;
    tamed = false;
    location_x = -1;
    location_y = -1;
  }
    
  //Constructor dengan parameter

  /**
   *
   * @param weightP.
   * @param tipeP.
   * @param tamedP.
   * @param locationxP.
   * @param locationyP.
   */
  public LandAnimal(int weightP, 
          int tipeP, 
          boolean tamedP,
          int locationxP,
          int locationyP) {
    weight = weightP;
    tipe = tipeP;
    tamed = tamedP;
    location_x = locationxP;
    location_y = locationyP;
  }
   

  /**
   * Copy Constructor
   * @param s.
   */
  public LandAnimal(LandAnimal s) {
    weight = s.weight;
    tipe = s.tipe;
    tamed  = s.tamed;
    location_x = s.location_x;
    location_y = s.location_y;
  }

  /**
   *Eat.
   */
  @Override
  public void Eat() {
    System.out.println("\"Nyam\""); 
  }

  /**
   *Interact.
   */
  @Override
  public void Interact() {
    System.out.println("\"Hewan : oi!\"");
  }
  
  @Override
  public void render() {
    System.out.print(" ");
  }
}
