/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landHabitat;
import habitat.Habitat;
/**
 *
 * @author Aya Aurora
 */
public class LandHabitat extends Habitat {
    //Constructor tanpa parameter
    public LandHabitat () {
        setNilaiCell(1);
    }
    
    //Copy Constructor 
    public LandHabitat (LandHabitat l) {
        setNilaiCell(l.getNilaiCell());
    }
    
    @Override
    public void render() {
        System.out.print("+");
    }
}
