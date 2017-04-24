/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maling.ternak.pkg2017;

import java.io.*;

/**
 *
 * @author Aulia Ichsan Rifkyano
 */
public class StatsTest {
    protected static int HighScore;
    protected static int CurrentScore;
    protected static String Name;
    protected static FileWriter out;
    
    public static void main(String args[]) throws IOException {
        out = null;
        Name = "Nama saya ya begitulah";
        try {
            out = new FileWriter("output.txt");
            out.write(Name);
            out.write(Name);
      
        }finally {
            if (out != null) {
                out.close();
            }
        }
    }
    
    public void setName(String name){
        Name=name;
    };
    
    public void setHighScore(int highScore){
        HighScore = highScore;
    };
    
    public void setCurrentScore(int cScore){
        CurrentScore = cScore;
    };
    
    public String getName(){
        return Name;
    };
    
    public int getHighScore(){
        return HighScore;
    };
    
    public int getCurrentScore(){
        return CurrentScore;
    };
    
    public void WriteStats() throws IOException{
        
    
    
    };
    
}
    
    
    
    
    
