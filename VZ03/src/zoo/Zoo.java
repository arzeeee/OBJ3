/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import renderable.Renderable;
import airhabitat.AirHabitat;
import cell.Cell;
import entrance.Entrance;
import exit.Exit;
import landHabitat.LandHabitat;
import park.Park;
import restaurant.Restaurant;
import road.Road;
import waterHabitat.WaterHabitat;

/**
 * 
 * @author Rizky Faramita 13515055@std.stei.itb.ac.id
 * @version 1.1 (current version number of program)
 * @since 1.1 (the version of the package this class was first added to)
 */
public class Zoo {
    
    /**
     * height dari matriks
     */
    public final int nbaris;
    
    /**
     * width dari matriks
     */
    public final int nkolom;
    
    /**
     * matriks untuk menyimpan map Zoo dari file eksternal 
     */
    private Cell[][] input_matrix;
    
    /**
     * matriks untuk mencetak map Zoo setelah transformasi
     */
    private char[][] output_matrix;
    
    /**
     * ctor tanpa parameter
     */
    public Zoo(){
        this.nbaris = 1;
        this.nkolom = 1;
        input_matrix = new Cell[1][1];
        input_matrix[1][1] = new Cell();
        output_matrix = new char[1][1];
    }
    
    /**
     * ctor dengan dua parameter
     * @param nbrs Description masukan untuk nbaris
     * @param nkol Description masukan untuk nkolom
     */
    public Zoo(int nbrs, int nkol){
        this.nbaris = nbrs;
        this.nkolom = nkol;        
        input_matrix = new Cell[nkolom][nbaris];
        for (int i = 0;i<nkolom;i++) {
            for (int j = 0;j<nbaris;j++) {
                input_matrix[i][j] = new Cell();
            }
        }
        output_matrix = new char[nkolom][nbaris];       
    }
    
    /**
     * cctor
     * @param z objek zoo yang akan di-assign 
     */
    public Zoo(final Zoo z){
        this.nbaris = z.nbaris;
        this.nkolom = z.nkolom;
        input_matrix = new Cell[nkolom][nbaris];
        for (int i = 0; i < nbaris; i++) {
            System.arraycopy(z.input_matrix[i], 0, input_matrix[i], 0, nkolom);
        }
    }
    
    /**
     * getter
     * @param x absis
     * @param y ordinat
     * @return nilai ell
     */
    public int getElementZoo(int x, int y){
        return input_matrix[x][y].getNilaiCell();
    }
    
    /**
     * getter output_matrix
     * @param x absis
     * @param y ordinat
     * @return char pada indeks ke x,y
     */
    public char getOutputMatrix(int x, int y) {
        return output_matrix[x][y];
    }
    
    /**
     * mencetak map ke layar
     * @param nbrs Description masukan untuk baris
     * @param nkol Description masukan untuk kolom
     */
    public void printZoo(int nbrs, int nkol){
        LandHabitat land_habitat = new LandHabitat();
        WaterHabitat water_habitat = new WaterHabitat();
        AirHabitat air_habitat = new AirHabitat();
        Road road = new Road();
        Park park = new Park();
        Restaurant restaurant = new Restaurant();
        Entrance entrance = new Entrance();
        Exit exit = new Exit();
        for (int i = 0; i < nbrs; i++) {
            for (int j = 0; j < nkol; j++) {
                switch (getElementZoo(i,j)) {
                    case 1:
                        land_habitat.render();
                        break;
                    case 2:
                        air_habitat.render();
                        break;
                    case 3:
                        water_habitat.render();
                        break;
                    case -1:
                        road.render();
                        break;
                    case -2:
                        park.render();
                        break;
                    case -3:
                        restaurant.render();
                        break;
                    case -4:
                        entrance.render();
                        break;
                    case -5:
                        exit.render();
                        break;
                    default:
                        break;
                }
            }
        }
        for (int i = 0; i < nbrs; i++) {
            for (int j = 0; j < nkolom; j++) {
                System.out.print(output_matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("Legenda; ");
        System.out.println("+ = Land Habitat" + "  " + "# = Road");
        System.out.println("@ = Air Habitat" + "   " + "~ = Park");
        System.out.println("$ = Water Habitat" + " " + "& = Restaurant");
    }
    
    /**
     * setter elemen Zoo
     * @param x absis
     * @param y ordinat
     * @param k elemen zoo
     */
    public void setElementZoo(int x, int y, int k){
        LandHabitat land_habitat = new LandHabitat();
        WaterHabitat water_habitat = new WaterHabitat();
        AirHabitat air_habitat = new AirHabitat();
        Road road = new Road();
        Park park = new Park();
        Restaurant restaurant = new Restaurant();
        Entrance entrance = new Entrance();
        Exit exit = new Exit();

        switch (k) {
            case 1:
                input_matrix[x][y] = land_habitat;
                break;
            case 2:
                input_matrix[x][y] = water_habitat;
                break;
            case 3:
                input_matrix[x][y] = air_habitat;
                break;
            case -1:
                input_matrix[x][y] = road;
                break;
            case -2:
                input_matrix[x][y] = park;
                break;
            case -3:
                input_matrix[x][y] = restaurant;
                break;
            case -4:
                input_matrix[x][y] = entrance;
                break;
            case -5:
                input_matrix[x][y] = exit;
                break;
            default:
                break;
        }
    }
}
