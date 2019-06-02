/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author TripleB
 */
public class MOnster {
    public static int EAT=1;
    public static int EATED=2;
    public static int DIE=3;
    public int status;
    int x;
    int y;
    public MOnster(int x,int y){
        this.x=x;
        this.y=y;
        status=EAT;
    }
    public void update(){
        switch(status){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        } 
    }
    public void ve(Graphics g){
       g.fillRect(y*35,x*35,34,34);
    }
}
