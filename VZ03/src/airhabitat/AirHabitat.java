/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airhabitat;
import habitat.Habitat;
/**
 *
 * @author Aya Aurora
 */
public class AirHabitat extends Habitat {
    //Constructor tanpa parameter
    public AirHabitat() {
        setNilaiCell(3);
    }
    
    //Copy Constructor 
    public AirHabitat(AirHabitat a) {
        setNilaiCell(a.getNilaiCell());
    }
    @Override
    public void render() {
        System.out.print("@");
    }
}
