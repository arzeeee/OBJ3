/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waterHabitat;
import habitat.Habitat;

/**
 *
 * @author Aya Aurora
 */
public class WaterHabitat extends Habitat {
    //Constructor tanpa parameter
    public WaterHabitat() {
        setNilaiCell(2);
    }
    
    //Copy Constructor 
    public WaterHabitat(WaterHabitat w) {
        setNilaiCell(w.getNilaiCell());
    }
    @Override
    public void render() {
        System.out.print("$");
    }
}
