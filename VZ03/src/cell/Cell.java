/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cell;

import renderable.Renderable;
/**
 *
 * @author Aya Aurora
 */
public class Cell implements Renderable{

    
    /**
     * atribut id untuk cell
     */
    private int nilai_cell;
    
    /**
     * ctor tanpa parameter
     */
    public Cell() {
       nilai_cell = 0;
    }
    
    /**
     * ctor dengan satu parameter
     * @param _nilai_cell nilai dari cell
     */ 
    public Cell(int _nilai_cell) {
        nilai_cell = _nilai_cell;
    }
    
    /**
     * cctor
     * @param c cell yang ingin dicopy 
     */
    public Cell (Cell c) {
        nilai_cell  = c.nilai_cell;
    }
    
    /**
     * @return nilai_cell
     */
    public int getNilaiCell() {
        return nilai_cell;
    }

    /**
     * @param nilai_cell nilai_cell to set
     */
    public void setNilaiCell(int nilai_cell) {
        this.nilai_cell = nilai_cell;
    }
    
    public void render() {
        System.out.print(" ");
    }
}
