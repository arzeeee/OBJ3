/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park;
import facility.Facility;
/**
 *
 * @author Aya Aurora
 */
public class Park extends Facility {
    //Constructor tanpa parameter
    public Park() {
        setNilaiCell(-2);
    }
    
    //Copy Constructor
    public Park(Park p) {
        setNilaiCell(p.getNilaiCell());
    }
    @Override
    public void render() {
        System.out.print("~");
    }
}
