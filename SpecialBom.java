/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author TripleB
 */
public class SpecialBom {
    int timeExist=0;
    int x;
    int y;
    public SpecialBom(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void update(){
        timeExist++;
       }
    public void ve(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(y*35+5,x*35+5,25,25);
    }
}
