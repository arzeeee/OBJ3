/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrance;
import road.Road;
/**
 *
 * @author Aya Aurora
 */
public class Entrance extends Road {
    //Constructor tanpa parameter
    
    public Entrance() {
        setNilaiCell(-4);
    }
    
    //Copy Constructor
    public Entrance(Entrance e) {
        setNilaiCell(e.getNilaiCell());
    }
    
}
