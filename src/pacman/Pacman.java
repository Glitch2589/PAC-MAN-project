/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author TripleB
 */
public class Pacman extends JFrame{

    /**
     * @param args the command line arguments
     */
    GameScreen scr;
    
    public Pacman(){
        scr=new GameScreen();
        this.setSize(900,910);
        this.setLocation(500,100);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(scr);
        this.addKeyListener(new Handler());
        this.setLayout(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Pacman m=new Pacman();
       
           }
    private class Handler implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_UP){
                
                scr.main.setVector(MainCharacter.GO_UP);
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                scr.main.setVector(MainCharacter.GO_DOWN);
            }
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
               scr.main.setVector(MainCharacter.GO_LEFT);
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
               scr.main.setVector(MainCharacter.GO_RIGHT);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
                 
        }
    
}
    
}
