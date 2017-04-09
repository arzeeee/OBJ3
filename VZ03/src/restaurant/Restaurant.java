/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;
import facility.Facility;
/**
 *
 * @author Aya Aurora
 */
public class Restaurant extends Facility {
    //Constructor tanpa parameter
    public Restaurant() {
        setNilaiCell(-3);
    }
    
    //Copy Constructor 
    public Restaurant(Restaurant r) {
        setNilaiCell(r.getNilaiCell());
    } 
    @Override
    public void render() {
        System.out.print("&");
    }
}
