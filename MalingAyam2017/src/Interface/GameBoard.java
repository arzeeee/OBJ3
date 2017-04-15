/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Rizky Faramita
 */
public class GameBoard extends JPanel implements ActionListener {

    private Dimension d;
    private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);

    private Image ii;
    private final Color dotColor = new Color(192, 192, 0);
    private Color mazeColor;

    private boolean inGame = false;
    private boolean dying = false;

    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private final int THIEF_ANIM_DELAY = 2;
    private final int THIEF_ANIM_COUNT = 4;
    private final int MAX_POLICE = 12;
    private final int THIEF_SPEED = 6;

    private int thiefAnimCount = THIEF_ANIM_DELAY;
    private int thiefAnimDir = 1;
    private int thiefAnimPos = 0;
    private int N_POLICE = 1;
    private int thiefLeft, score;
    private int[] dx, dy;
    private int[] policeX, policeY, policeDX, policeDY, policeSpeed;

    private Image police;
    private Image thief;

    private int thiefX, thiefY, thiefDX, thiefDY;
    private int reqDX, reqDY, viewDX, viewDY;

    private final short levelData[] = {
        19, 26, 26, 26, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
        21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        21, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
        21, 0, 0, 0, 17, 16, 16, 24, 16, 16, 16, 16, 16, 16, 20,
        17, 18, 18, 18, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 20,
        17, 16, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 16, 24, 20,
        25, 16, 16, 16, 24, 24, 28, 0, 25, 24, 24, 16, 20, 0, 21,
        1, 17, 16, 20, 0, 0, 0, 0, 0, 0, 0, 17, 20, 0, 21,
        1, 17, 16, 16, 18, 18, 22, 0, 19, 18, 18, 16, 20, 0, 21,
        1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
        1, 17, 16, 16, 16, 16, 20, 0, 17, 16, 16, 16, 20, 0, 21,
        1, 17, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 20, 0, 21,
        1, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 21,
        1, 25, 24, 24, 24, 24, 24, 24, 24, 24, 16, 16, 16, 18, 20,
        9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 25, 24, 24, 24, 28
    };

    private final int validSpeeds[] = {1, 2, 3, 4, 6, 8};
    private final int maxSpeed = 6;

    private int currentSpeed = 3;
    private short[] screenData;
    private Timer timer;
    private MediaTracker thetracker;
    
    public GameBoard() {
        loadImages();
        initVariables();
        initGameBoard();
    }

    private void loadImages() {

        police = new ImageIcon("images/police.gif").getImage();
        thief = new ImageIcon("images/thief.gif").getImage();
    }
    
    private void initGameBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);
        setDoubleBuffered(true);
    }
    
    private void initVariables() {
        screenData = new short[N_BLOCKS * N_BLOCKS];
        mazeColor = new Color(5, 100, 5);
        d = new Dimension(400, 400);
        policeX = new int[MAX_POLICE];
        policeDX = new int[MAX_POLICE];
        policeY = new int[MAX_POLICE];
        policeDY = new int[MAX_POLICE];
        policeSpeed = new int[MAX_POLICE];
        dx = new int[4];
        dy = new int[4];
        timer = new Timer(40, this);
        timer.start();
    }
  
    @Override
    public void addNotify() {
        super.addNotify();

        initGame();
    }
    
    private void doAnim() {
        thiefAnimCount--;
        if (thiefAnimCount < 1) {
            thiefAnimCount = THIEF_ANIM_DELAY;
            thiefAnimPos = thiefAnimPos + thiefAnimDir;
            
            if (thiefAnimPos == (THIEF_ANIM_COUNT - 1) || thiefAnimPos == 0) {
                thiefAnimDir = -thiefAnimDir;
            }
        }
    }
    
    private void playGame(Graphics2D g2d) {
        if (dying) {
            death();
        } else {
            moveThief();
            drawThief(g2d,0,0);
            movePolice(g2d);
            checkMaze();
        }
    }
    
    private void showIntroScreen(Graphics2D g2d) {

        g2d.setColor(new Color(0, 32, 48));
        g2d.fillRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);
        g2d.setColor(Color.white);
        g2d.drawRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);

        String s = "Press S to START";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, (SCREEN_SIZE - metr.stringWidth(s)) / 2, SCREEN_SIZE / 2);
    }

    private void drawScore(Graphics2D g) {

        int i;
        String s;

        g.setFont(smallFont);
        g.setColor(new Color(96, 128, 255));
        s = "Score: " + score;
        g.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);

        for (i = 0; i < thiefLeft; i++) {
            g.drawImage(thief, i * 28 + 8, SCREEN_SIZE + 1, this);
        }
    }
    
    private void checkMaze() {

        short i = 0;
        boolean finished = true;

        while (i < N_BLOCKS * N_BLOCKS && finished) {

            if ((screenData[i] & 48) != 0) {
                finished = false;
            }

            i++;
        }

        if (finished) {

            score += 50;

            if (N_POLICE < MAX_POLICE) {
                N_POLICE++;
            }

            if (currentSpeed < maxSpeed) {
                currentSpeed++;
            }

            initLevel();
        }
    }
    
    private void death() {

        thiefLeft--;

        if (thiefLeft == 0) {
            inGame = false;
        }

        continueLevel();
    }
    
    private void movePolice(Graphics2D g2d) {

        short i;
        int pos;
        int count;

        for (i = 0; i < N_POLICE; i++) {
            if (policeX[i] % BLOCK_SIZE == 0 && policeY[i] % BLOCK_SIZE == 0) {
                pos = policeX[i] / BLOCK_SIZE + N_BLOCKS * (int) (policeY[i] / BLOCK_SIZE);

                count = 0;

                if ((screenData[pos] & 1) == 0 && policeDX[i] != 1) {
                    dx[count] = -1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 2) == 0 && policeDY[i] != 1) {
                    dx[count] = 0;
                    dy[count] = -1;
                    count++;
                }

                if ((screenData[pos] & 4) == 0 && policeDX[i] != -1) {
                    dx[count] = 1;
                    dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 8) == 0 && policeDY[i] != -1) {
                    dx[count] = 0;
                    dy[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((screenData[pos] & 15) == 15) {
                        policeDX[i] = 0;
                        policeDY[i] = 0;
                    } else {
                        policeDX[i] = -policeDX[i];
                        policeDY[i] = -policeDY[i];
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    policeDX[i] = dx[count];
                    policeDY[i] = dy[count];
                }

            }

            policeX[i] = policeX[i] + (policeDX[i] * policeSpeed[i]);
            policeY[i] = policeY[i] + (policeDY[i] * policeSpeed[i]);
            drawPolice(g2d, policeX[i] + 1, policeY[i] + 1);

            if (thiefX > (policeX[i] - 12) && thiefX < (policeX[i] + 12)
                    && thiefY > (policeY[i] - 12) && thiefY < (policeY[i] + 12)
                    && inGame) {

                dying = true;
            }
        }
    }
    
    private void drawPolice(Graphics2D g2d, int x, int y) {

        g2d.drawImage(police, x, y, this);
    }
    
    private void moveThief() {

        int pos;
        short ch;

        if (reqDX == -thiefDX && reqDY == -thiefDY) {
            thiefDX = reqDX;
            thiefDY = reqDY;
            viewDX = thiefDX;
            viewDY = thiefDY;
        }

        if (thiefX % BLOCK_SIZE == 0 && thiefY % BLOCK_SIZE == 0) {
            pos = thiefX / BLOCK_SIZE + N_BLOCKS * (int) (thiefY / BLOCK_SIZE);
            ch = screenData[pos];

            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
                score++;
            }

            if (reqDX != 0 || reqDY != 0) {
                if (!((reqDX == -1 && reqDY == 0 && (ch & 1) != 0)
                        || (reqDX == 1 && reqDY == 0 && (ch & 4) != 0)
                        || (reqDX == 0 && reqDY == -1 && (ch & 2) != 0)
                        || (reqDX == 0 && reqDY == 1 && (ch & 8) != 0))) {
                    thiefDX = reqDX;
                    thiefDY = reqDY;
                    viewDX = thiefDX;
                    viewDY = thiefDY;
                }
            }

            // Check for standstill
            if ((thiefDX == -1 && thiefDY == 0 && (ch & 1) != 0)
                    || (thiefDX == 1 && thiefDY == 0 && (ch & 4) != 0)
                    || (thiefDX == 0 && thiefDY == -1 && (ch & 2) != 0)
                    || (thiefDX == 0 && thiefDY == 1 && (ch & 8) != 0)) {
                thiefDX = 0;
                thiefDY = 0;
            }
        }
        thiefX = thiefX + THIEF_SPEED * thiefDX;
        thiefY = thiefY + THIEF_SPEED * thiefDY;
    }

    private void drawThief(Graphics2D g2d, int x, int y) {

        g2d.drawImage(thief, x, y, this);
    }
    
    private void drawMaze(Graphics2D g2d) {

        short i = 0;
        int x, y;

        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                g2d.setColor(mazeColor);
                g2d.setStroke(new BasicStroke(2));

                if ((screenData[i] & 1) != 0) { 
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 2) != 0) { 
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) { 
                    g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) { 
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 16) != 0) { 
                    g2d.setColor(dotColor);
                    g2d.fillRect(x + 11, y + 11, 2, 2);
                }

                i++;
            }
        }
    }

    private void initGame() {

        thiefLeft = 3;
        score = 0;
        initLevel();
        N_POLICE = 1;
        currentSpeed = 3;
    }

    private void initLevel() {

        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }

        continueLevel();
    }

    private void continueLevel() {

        short i;
        int dx = 1;
        int random;

        for (i = 0; i < N_POLICE; i++) {

            policeY[i] = 4 * BLOCK_SIZE;
            policeX[i] = 4 * BLOCK_SIZE;
            policeDY[i] = 0;
            policeDX[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));

            if (random > currentSpeed) {
                random = currentSpeed;
            }

            policeSpeed[i] = validSpeeds[random];
        }

        thiefX = 7 * BLOCK_SIZE;
        thiefY = 11 * BLOCK_SIZE;
        thiefDX = 0;
        thiefDY = 0;
        reqDX = 0;
        reqDY = 0;
        viewDX = -1;
        viewDY = 0;
        dying = false;
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (inGame) {
                if (key == KeyEvent.VK_LEFT) {
                    reqDX = -1;
                    reqDY = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    reqDX = 1;
                    reqDY = 0;
                } else if (key == KeyEvent.VK_UP) {
                    reqDX = 0;
                    reqDY = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    reqDX = 0;
                    reqDY = 1;
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    inGame = false;
                } else if (key == KeyEvent.VK_PAUSE) {
                    if (timer.isRunning()) {
                        timer.stop();
                    } else {
                        timer.start();
                    }
                }
            } else {
                if (key == 's' || key == 'S') {
                    inGame = true;
                    initGame();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == Event.LEFT || key == Event.RIGHT
                    || key == Event.UP || key == Event.DOWN) {
                reqDX = 0;
                reqDY = 0;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }  
}
