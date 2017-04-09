/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penyu;
import cheloniidae.Cheloniidae;
import java.util.Random;
/**
 *
 * @author Mahdiar Naufal
 */
public class Penyu extends Cheloniidae{
    //Constructor tanpa parameter
    public Penyu () {
        weight = 0;
        tipe = 0;
        tamed = false;
        location_x = -1;
        location_y = -1;
    }
    
    //Constructor dengan parameter
    public Penyu (int _weight, 
            int _tipe, 
            boolean _tamed,
            int _x,
            int _y) {
        weight = _weight;
        tipe = _tipe;
        tamed = _tamed;
        location_x = _x;
        location_y = _y;
    }
    
    //Copy Constructor
    public Penyu (Penyu s) {
        weight = s.weight;
        tipe = s.tipe;
        tamed  = s.tamed;
        location_x = s.location_x;
        location_y = s.location_y;
    }

    //Override method eat
    @Override
    public void Eat() {
        System.out.println("Porsi makanan penyu ini adalah " + weight*0.025 + " kg."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Interact() {
        Random rand;
        rand = new Random();
        
        int n = rand.nextInt(3);
        
        if (n == 0){
            System.out.println("Penyu : \"Zzzzzz......\"");
        } else if (n == 1) {
            System.out.println("Penyu : \"Nyawn!!!\"");
        } else if (n == 2) {
            System.out.println("Penyu : \"Nyam.. Nyam..\"");
        }
        
    }
  @Override
  public void render() {
    System.out.print("Y");
  }
}
