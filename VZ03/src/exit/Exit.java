/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exit;
import road.Road;
/**
 *
 * @author Aya Aurora
 */
public class Exit extends Road{
    //Constructor tanpa parameter
    public Exit() {
        setNilaiCell(-5);
    }
    
    //Copy Constructor
    public Exit(Exit e) {
        setNilaiCell(e.getNilaiCell());
    }
    
}
