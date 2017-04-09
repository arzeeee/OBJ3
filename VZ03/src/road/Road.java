/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package road;
import facility.Facility;
/**
 *
 * @author Aya Aurora
 */
public class Road extends Facility{
    //Constructor tanpa parameter
    public Road () {
        setNilaiCell(-1);
    }
    
    //Copy Constructor
    public Road(Road r) {
        setNilaiCell(r.getNilaiCell());
    }
}
