/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import player.Player;
import zoo.Zoo;
import cage.Cage;
import cages.Cages;

import java.io.*;
import java.util.*;

/**
 *
 * @author Aya Aurora
 */
public class Driver {
    /* FOREGROUND */
    public static final String RST = "\033[0m";
    public static final String KROAD = "\033[48;5;3m\033[38;5;0m";
    public static final String KI0 = "\033[38;5;0m";
    public static final String KI1 = "\033[38;5;1m";
    public static final String KI2 = "\033[38;5;2m";
    public static final String KI3 = "\033[38;5;3m";
    public static final String KI4 = "\033[38;5;4m";
    public static final String KI5 = "\033[38;5;5m";
    public static final String KI6 = "\033[38;5;6m";
    public static final String KI7 = "\033[38;5;7m";
    public static final String KI8 = "\033[38;5;8m";
    public static final String KI9 = "\033[38;5;9m";
    public static final String KI10 = "\033[38;5;10m";
    public static final String KI11 = "\033[38;5;11m";
    public static final String KI12 = "\033[38;5;12m";
    public static final String KI13 = "\033[38;5;13m";
    public static final String KI14 = "\033[38;5;14m";
    public static final String KI15 = "\033[38;5;15m";
    public static final String KI16 = "\033[38;5;16m";
    public static final String KI17 = "\033[38;5;17m";
    public static final String KI18 = "\033[38;5;18m";
    public static final String KI19 = "\033[38;5;19m";
    public static final String KI20 = "\033[38;5;20m";
    public static final String KI21 = "\033[38;5;21m";
    public static final String KI22 = "\033[38;5;22m";
    public static final String KI23 = "\033[38;5;23m";
    public static final String KI24 = "\033[38;5;24m";

    private Zoo zoo;
    private String[][] matrix_map = new String[20][20];
    private Player user;
    private Cage[][] kandang;

    /**
     * Driver
     * @throws FileNotFoundException.
     */
    public Driver() throws FileNotFoundException {
        user = new Player();
        zoo = new Zoo(20,20);
        int a;
        int i;
        int j;
        int animal_id = 0;
        int cage_id;
        int curr_cage_id = 0;
        int idx_str;
        
        //Membaca file eksternal mapZoo menjadi matrix_map
        String curr_line[] = new String [20];
        
        File file = new File ("./src/driver/mapZoo.txt");
        Scanner input_txt = new Scanner(file);
        
        i = 0;
        while (input_txt.hasNextLine()) {
            curr_line[i] = input_txt.nextLine();
            i++;
        }
        
        
        for (i = 0; i < zoo.nbaris; i++) {
            idx_str = 0;
            for (j = 0; j < zoo.nkolom; j++) {
                matrix_map[i][j] = curr_line[i].substring(idx_str, idx_str+3);
                idx_str += 3;
            }
        }
        
        //Implementasi translasi matrix_map ke zoo
        for (i = 0; i < zoo.nbaris; i++) {
            for (j = 0; j < zoo.nkolom; j++) {
                if ("#".equals(matrix_map[i][j].substring(0)) || "S".equals(matrix_map[i][j].substring(0)) || "J".equals(matrix_map[i][j].substring(0)) || "H".equals(matrix_map[i][j].substring(0)) || "B".equals(matrix_map[i][j].substring(0)) || "Z".equals(matrix_map[i][j].substring(0)) || "O".equals(matrix_map[i][j].substring(0)) || "U".equals(matrix_map[i][j].substring(0)) || "D".equals(matrix_map[i][j].substring(0)) ||"K".equals(matrix_map[i][j].substring(0))) {
                    zoo.setElementZoo(i,j,1);
                } else if ("@".equals(matrix_map[i][j].substring(0)) || "A".equals(matrix_map[i][j].substring(0)) || "N".equals(matrix_map[i][j].substring(0)) || "W".equals(matrix_map[i][j].substring(0)) || "C".equals(matrix_map[i][j].substring(0)) || "M".equals(matrix_map[i][j].substring(0))) {
                    zoo.setElementZoo(i,j,2);
                } else if ("$".equals(matrix_map[i][j].substring(0)) || "T".equals(matrix_map[i][j].substring(0)) || "R".equals(matrix_map[i][j].substring(0)) || "Y".equals(matrix_map[i][j].substring(0)) || "L".equals(matrix_map[i][j].substring(0)) || "E".equals(matrix_map[i][j].substring(0)) || "I".equals(matrix_map[i][j].substring(0)) || "G".equals(matrix_map[i][j].substring(0)))  {
                    zoo.setElementZoo(i,j,3);
                } else if ("-".equals(matrix_map[i][j].substring(0))) {
                    zoo.setElementZoo(i,j,-1);
                } else if ("P".equals(matrix_map[i][j].substring(0))) {
                    zoo.setElementZoo(i,j,-2);
                } else if ("&".equals(matrix_map[i][j].substring(0))) {
                    zoo.setElementZoo(i,j,-3);
                } else if (("-".equals(matrix_map[i][j].substring(0))) && (j == 19)) {
                    zoo.setElementZoo(i,j,-4);
                } else if (("-".equals(matrix_map[i][j].substring(0))) && (i == 0)) {
                    zoo.setElementZoo(i,j,-5);
             }
            }
        }
        
        //Alokasi Cage
        kandang = new Cage[zoo.nbaris][zoo.nkolom];
        for (i = 0;i<zoo.nbaris;i++) {
            for (j = 0;j<zoo.nkolom;j++){
                kandang[i][j] = new Cage(); 
            }
        }
        
        //Inisiasi Cage dari matrix_map
        for (i = 0;i<zoo.nbaris;i++) {
            for (j = 0; j < zoo.nkolom; j++){
                cage_id = (Integer.parseInt(matrix_map[i][j].substring(1,2)) * 10) + Integer.parseInt(matrix_map[i][j].substring(2,3));    
                //System.out.println(cage_id);
                if (curr_cage_id<cage_id) {
                    curr_cage_id = cage_id;
                }
                if (null != matrix_map[i][j].substring(0,1)) {
                    switch (matrix_map[i][j].substring(0,1)) {
                        case "K":
                            animal_id = 1;
                            break;
                        case "H":
                            animal_id = 2;
                            break;
                        case "S":
                            animal_id = 3;
                            break;
                        case "J":
                            animal_id = 4;
                            break;
                        case "O":
                            animal_id = 5;
                            break;
                        case "D":
                            animal_id = 6;
                            break;
                        case "B":
                            animal_id = 7;
                            break;
                        case "Z":
                            animal_id = 8;
                            break;
                        case "U":
                            animal_id = 9;
                            break;
                        case "E":
                            animal_id = 10;
                            break;
                        case "I":
                            animal_id = 11;
                            break;
                        case "L":
                            animal_id = 12;
                            break;
                        case "T":
                            animal_id = 13;
                            break;
                        case "G":
                            animal_id = 14;
                            break;
                        case "R":
                            animal_id = 15;
                            break;
                        case "M":
                            animal_id = 16;
                            break;
                        case "W":
                            animal_id = 17;
                            break;
                        case "N":
                            animal_id = 18;
                            break;
                        case "A":
                            animal_id = 19;
                            break;
                        case "C":
                            animal_id = 20;
                            break;
                        case "Y":
                            animal_id = 21;
                            break;
                        default:
                            animal_id = 0;
                            break;
                    }
                }
                /*System.out.println("test");
                System.out.println(animal_id);
                System.out.println(i);
                System.out.println(j);
                System.out.println(cage_id);*/
                kandang[i][j].setCage(i,j,cage_id,animal_id);
            }    
        }
        
        //Alokasi Array of Cages, ukuran 1 ~ curr_cage_id yang terakhir
        Cages kandang_kandang[] = new Cages[curr_cage_id + 1];
        for (i = 0;i<curr_cage_id + 1;i++) {
            kandang_kandang[i] = new Cages();
        }
        
        for (a = 1;a<=curr_cage_id;a++) {
            int amount = 0;
            for (i = 0;i<zoo.nbaris;i++) {
                for (j = 0; j < zoo.nkolom; j++){
                    if (kandang[i][j].getCageId() == a) {
                        amount++;
                    }
                }
            }
            //Cages dummy(amount);
            i = 0;
            j = 0;
            int found = 0;
            while ((i<zoo.nbaris) && (found == 0)) {
                while ((j<zoo.nkolom) && (found == 0)) {
                    if (kandang[i][j].getCageId() == a) {
                        kandang_kandang[a].setIdx(kandang[i][j]);
                        found = 1;
                    } else {
                        j++;
                    }
                }
                i++;
            }
            //kandang_kandang[a] = dummy;
        }
    }
    
    public void PrintMap(int user_x, int user_y) {
        int i;
        int j;
        int cell_id;
        char x;
        
        for (i = 0;i<zoo.nbaris;i++) {
            for (j = 0;j<zoo.nkolom;j++) {
                
                if ((i == user_x) && (j == user_y)) { 
                    x = '!';
                    
                } else {
                    x = matrix_map[i][j].charAt(0);
                }
                cell_id = (Integer.parseInt(matrix_map[i][j].substring(1,2)) * 10) + Integer.parseInt(matrix_map[i][j].substring(2,3));
                if ((cell_id==0) && ((x == '-') || (x == '!'))){
                    System.out.print(KROAD + x + " " + RST);
                } else if (cell_id==0){
                    System.out.print(KI0 + x + RST + " ");
                } else if (cell_id==1){
                    System.out.print(KI1 + x + RST + " ");
                } else if (cell_id==2){
                    System.out.print(KI2 + x + RST + " ");
                } else if (cell_id==3){
                    System.out.print(KI3 + x + RST + " ");
                } else if (cell_id==4){
                    System.out.print(KI4 + x + RST + " ");
                } else if (cell_id==5){
                    System.out.print(KI5 + x + RST + " ");
                } else if (cell_id==6){
                    System.out.print(KI6 + x + RST + " ");
                } else if (cell_id==7){
                    System.out.print(KI7 + x + RST + " ");
                } else if (cell_id==8){
                    System.out.print(KI8 + x + RST + " ");
                } else if (cell_id==9){
                    System.out.print(KI9 + x + RST + " ");
                } else if (cell_id==10){
                    System.out.print(KI10 + x + RST + " ");
                } else if (cell_id==11){
                    System.out.print(KI11 + x + RST + " ");
                } else if (cell_id==12){
                    System.out.print(KI12 + x + RST + " ");
                } else if (cell_id==13){
                    System.out.print(KI13 + x + RST + " ");
                } else if (cell_id==14){
                    System.out.print(KI14 + x + RST + " ");
                } else if (cell_id==15){
                    System.out.print(KI15 + x + RST + " ");
                } else if (cell_id==16){
                    System.out.print(KI16 + x + RST + " ");
                } else if (cell_id==17){
                    System.out.print(KI17 + x + RST + " ");
                } else if (cell_id==18){
                    System.out.print(KI18 + x + RST + " ");
                } else if (cell_id==19){
                    System.out.print(KI19 + x + RST + " ");
                } else if (cell_id==20){
                    System.out.print(KI20 + x + RST + " ");
                } else if (cell_id==21){
                    System.out.print(KI21 + x + RST + " ");
                } else if (cell_id==22){
                    System.out.print(KI22 + x + RST + " ");
                } else if (cell_id==23){
                    System.out.print(KI23 + x + RST + " ");
                } else if (cell_id==24){
                    System.out.print(KI24 + x + RST + " ");
                } 
            }
            System.out.println();
        }
    System.out.println();
    }
    
    public void PrintMap(int x1, int y1, int x2, int y2) {
        int i;
        int j;
        int cell_id;
        char x;
        
        if ((((x1<0||x1>zoo.nbaris)||(x2<0||x2>zoo.nbaris))
        ||((y1<0||y1>zoo.nkolom)||(x2<0||x2>zoo.nkolom)))
        ||((x1>x2)||(y1>y2))) {
        System.out.println("parameter invalid");
        } else {
            for (i = x1;i<x2;i++) {
                for (j = y1;j<y2;j++) {
                    x = matrix_map[i][j].charAt(0);
                    cell_id = (Integer.parseInt(matrix_map[i][j].substring(1,2)) * 10) + Integer.parseInt(matrix_map[i][j].substring(2,3));
                    if ((cell_id == 0) && (x == '-')){
                        System.out.print(KROAD + x + " " + RST);
                    } else if (cell_id==0){
                        System.out.print(KI0 + x + RST + " ");
                    } else if (cell_id==1){
                        System.out.print(KI1 + x + RST + " ");
                    } else if (cell_id==2){
                        System.out.print(KI2 + x + RST + " ");
                    } else if (cell_id==3){
                        System.out.print(KI3 + x + RST + " ");
                    } else if (cell_id==4){
                        System.out.print(KI4 + x + RST + " ");
                    } else if (cell_id==5){
                        System.out.print(KI5 + x + RST + " ");
                    } else if (cell_id==6){
                        System.out.print(KI6 + x + RST + " ");
                    } else if (cell_id==7){
                        System.out.print(KI7 + x + RST + " ");
                    } else if (cell_id==8){
                        System.out.print(KI8 + x + RST + " ");
                    } else if (cell_id==9){
                        System.out.print(KI9 + x + RST + " ");
                    } else if (cell_id==10){
                        System.out.print(KI10 + x + RST + " ");
                    } else if (cell_id==11){
                        System.out.print(KI11 + x + RST + " ");
                    } else if (cell_id==12){
                        System.out.print(KI12 + x + RST + " ");
                    } else if (cell_id==13){
                        System.out.print(KI13 + x + RST + " ");
                    } else if (cell_id==14){
                        System.out.print(KI14 + x + RST + " ");
                    } else if (cell_id==15){
                        System.out.print(KI15 + x + RST + " ");
                    } else if (cell_id==16){
                        System.out.print(KI16 + x + RST + " ");
                    } else if (cell_id==17){
                        System.out.print(KI17 + x + RST + " ");
                    } else if (cell_id==18){
                        System.out.print(KI18 + x + RST + " ");
                    } else if (cell_id==19){
                        System.out.print(KI19 + x + RST + " ");
                    } else if (cell_id==20){
                        System.out.print(KI20 + x + RST + " ");
                    } else if (cell_id==21){
                        System.out.print(KI21 + x + RST + " ");
                    } else if (cell_id==22){
                        System.out.print(KI22 + x + RST + " ");
                    } else if (cell_id==23){
                        System.out.print(KI23 + x + RST + " ");
                    } else if (cell_id==24){
                        System.out.print(KI24 + x + RST + " ");
                    } 
                }
                System.out.println();
            }
            System.out.println();    
        }
    }
    
    public void PrintLegend() {
        System.out.println("\033[48;5;3m\033[38;5;0m                    ~::Legenda::~                    \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0m#: Land Habitat     $: Water Habitat                 \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0m@: Air Habitat      -: Road (Can be Exit or Entrance)\033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mP: Park             &: Restaurant                    \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mK: Kucing           H: Harimau                       \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mS: Singa            J: Jerapah                       \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mO: Okapi            D: Panda                         \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mB: Beruang          Z: Zebra                         \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mU: Kuda             E: Ebosia                        \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mI: Lionfish         L: Lumba-Lumba                   \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mT: Hiu Putih        G: Gurita Biru                   \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mR: Gurita Merah     M: Merpati                       \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mW: Rajawali         N: Elang                         \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mA: Kelelawar        C: Cendrawasih                   \033[0m");
        System.out.println("\033[48;5;3m\033[38;5;0mY: Penyu                                             \033[0m");
    }
    
    public void PrintInterface() {
        System.out.println("Selamat Datang di Kebun Binatang");
        System.out.println("Berikut adalah kegiatan yang dapat kamu lakukan di Kebun Binatang");
        System.out.println("1. Menampilkan Peta Kebun Binatang");
        System.out.println("2. Melakukan Tour Kebun Binatang");
        System.out.println("3. Keluar dari Kebun Binatang");
        System.out.print("Masukan nomor pilihan kegiatan yang ingin kamu lakukan : ");
    }
    
    public void InputPilihan() {
        int pilihan;
        int i;
        int j = 0;
        int found = 0;
        int recent_x = user.getX();
        int recent_y = user.getY();
                       
        Scanner in = new Scanner(System.in);
        
        pilihan = in.nextInt();
        while ((pilihan != 3) && (pilihan >= 1) && (pilihan < 3)) {
            if (pilihan == 1) {
                int x1,y1,x2,y2;
                System.out.println("Masukkan koordinat titik kiri atas : ");
                x1 = in.nextInt();
                y1 = in.nextInt();
                System.out.println("Masukkan koordinat titik kanan bawah : ");
                x2 = in.nextInt();
                y2 = in.nextInt();
                PrintMap(x1,y1,x2,y2);
                PrintLegend();
            } else if (pilihan == 2) {
                user.setX(17);
                user.setY(19);
                PrintMap(user.getX(), user.getY());
                PrintLegend();
                System.out.println();
                PrintInterfaceTour();
                InputPilihanTour();
            }
            PrintInterface();
                    pilihan = in.nextInt();
        } 
    }
    
    public void PrintInterfaceTour() {
        System.out.println("Hal yang dapat Anda lakukan saat Tour adalah ");
        System.out.println("1. Berinteraksi dengan binatang");
        System.out.println("2. Mengetahui banyaknya makanan yang dikonsumsi binatang per hari");
        System.out.println("3. Melanjutkan Tour <<tekan Enter>>");
        System.out.println("4. Mengakhiri Tour <<tekan Space>>");
    }
    
    public void InputPilihanTour() {
	int neff1 = 34;
        int array_step_x1[] = {18,17,16,15,14,13,12,12,12,12,12,12,12,12,12,12,12,12,11,10,9,9,9,9,9,8,7,6,5,4,3,2,1,0};
        int array_step_y1[] = {17,17,17,17,17,17,17,16,15,14,13,12,11,10,9,8,7,6,6,6,6,5,4,3,2,2,2,2,2,2,2,2,2,2} ;
        int step = 0;
        int pilihan_tour;
        boolean end_of_tour = false;
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan pilihan kegiatan Anda : ");
        pilihan_tour = in.nextInt();
        System.out.println();
        
        
        while (pilihan_tour != 4) {
            if (pilihan_tour == 1) {
                Interaksi();
            } else if (pilihan_tour == 2) {
                Makanan();
            } else if (pilihan_tour == 3) {
                user.setX(array_step_y1[step]);
                user.setY(array_step_x1[step]);
                PrintMap(user.getX(), user.getY());
                PrintLegend();
                System.out.println();       
                if ((array_step_x1[step] == 0) && (step == neff1 - 1)) {
                    end_of_tour = true;
                }
                step++;	
            }

                if (end_of_tour == false) {
                    PrintInterfaceTour();
                    System.out.print("Masukkan pilihan kegiatan Anda : ");
                    pilihan_tour = in.nextInt();
                    System.out.println();
                } else {
                    System.out.println("Anda sudah sampai di jalan keluar Kebun Binatang");
                    pilihan_tour = 4;	
                }
        }
        System.out.println();
        
    }
  
    public void Interaksi() {
        int ux = user.getX();
        int uy = user.getY();
        int animal_left,animal_right,animal_up,animal_down;

        if ((ux-1) < 0) {
            animal_left = kandang[0][uy].getAnimalId();
        } else {
            animal_left = kandang[ux-1][uy].getAnimalId();
        }
        if ((ux+1) >= 20) {
            animal_right = kandang[19][uy].getAnimalId();
        } else {
            animal_right = kandang[ux+1][uy].getAnimalId();
        }
        if ((uy-1) < 0) {
            animal_up = kandang[ux][0].getAnimalId();
        } else {
            animal_up = kandang[ux][uy-1].getAnimalId();
        }
        if ((uy+1) >= 20) {
            animal_down = kandang[ux][19].getAnimalId();
        } else {
            animal_down = kandang[ux][uy+1].getAnimalId();
        }

        //cek lingkungan sekitar ada hewan apa saja
        
        if (animal_left != 0 && ((uy != 20) && (ux != 20))) {
            kandang[ux-1][uy].animal.Interact();
        }
        if (animal_right != 0&& ((uy != 20) && (ux != 20))) {
            kandang[ux+1][uy].animal.Interact();
        }
        if (animal_up != 0&& ((uy != 20) && (ux != 20))) {
            kandang[ux][uy-1].animal.Interact();
        }
        if (animal_down != 0&& ((uy != 20) && (ux != 20))) {
            kandang[ux][uy+1].animal.Interact();
        }
    }

    public void Makanan() {
        int ux = user.getX();
        int uy = user.getY();
        int animal_left,animal_right,animal_up,animal_down;

        if ((ux-1) < 0) {
            animal_left = kandang[0][uy].getAnimalId();
        } else {
            animal_left = kandang[ux-1][uy].getAnimalId();
        }
        if ((ux+1) >= 20) {
            animal_right = kandang[19][uy].getAnimalId();
        } else {
            animal_right = kandang[ux+1][uy].getAnimalId();
        }
        if ((uy-1) < 0) {
            animal_up = kandang[ux][0].getAnimalId();
        } else {
            animal_up = kandang[ux][uy-1].getAnimalId();
        }
        if ((uy+1) >= 20) {
            animal_down = kandang[ux][19].getAnimalId();
        } else {
            animal_down = kandang[ux][uy+1].getAnimalId();
        }

        //cek lingkungan sekitar ada hewan apa saja
        
        if (animal_left != 0) {
            kandang[ux-1][uy].animal.Eat();
        }
        if (animal_right != 0) {
            kandang[ux+1][uy].animal.Eat();
        }
        if (animal_up != 0) {
            kandang[ux][uy-1].animal.Eat();
        }
        if (animal_down != 0) {
            kandang[ux][uy+1].animal.Eat();
        }
    }   
}
