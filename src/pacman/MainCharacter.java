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
public class MainCharacter {
    public static int GO_UP=1;
    public static int GO_DOWN=2;
    public static int GO_LEFT=3;
    public static int GO_RIGHT=4; 
    public static boolean die=false;
    static int Point=0;
    public int vector;
    public int x,y;
    public MainCharacter(){
        x=2;
        y=5;
        vector=0;
    }

    public void setVector(int vector) {
        this.vector = vector;
    }
    public void ve(Graphics g){
        if(vector==GO_UP){
            g.drawImage(ImageStore.up.getCurrentImage(), y*35, x*35, null);
        }
        if(vector==GO_DOWN){
            g.drawImage(ImageStore.down.getCurrentImage(), y*35, x*35, null);
        }
        if(vector==GO_LEFT){
            g.drawImage(ImageStore.left.getCurrentImage(), y*35, x*35, null);
        }
        if(vector==GO_RIGHT){
            g.drawImage(ImageStore.right.getCurrentImage(), y*35, x*35, null);
        }
        
    }
    public void update(){
        if(vector==1 && GameScreen.bg[x-1][y]!=1){
               for(MOnster m:GameScreen.mon ){
                   if(m.x==x-1&&m.y==y){
                       die=true;
                   }
               }
               if(GameScreen.bg[x-1][y]==2){
                   GameScreen.bg[x-1][y]=0;
                   Point+=10;
                   
               }
               if(GameScreen.bg[x-1][y]==3){
                   GameScreen.bg[x-1][y]=0;
                   Point+=20;
                   GameScreen.bomb.remove(0);
               }
               x-=1;
               
        }
        if(vector==2&& GameScreen.bg[x+1][y]!=1){
            for(MOnster m:GameScreen.mon ){
                   if(m.x==x+1&&m.y==y){
                       die=true;
                   }
               }
            if(GameScreen.bg[x+1][y]==2){
                   GameScreen.bg[x+1][y]=0;
                   Point+=10;
                   
               }
            if(GameScreen.bg[x+1][y]==3){
                   GameScreen.bg[x+1][y]=0;
                   Point+=20;
                   GameScreen.bomb.remove(0);
               }
             x+=1;
             
        }
        if(vector==3&& GameScreen.bg[x][y-1]!=1){
            for(MOnster m:GameScreen.mon ){
                   if(m.x==x&&m.y==y-1){
                       die=true;
                   }
               }
            if(GameScreen.bg[x][y-1]==2){
                   GameScreen.bg[x][y-1]=0;
                   Point+=10;
                   
               }
            if(GameScreen.bg[x][y-1]==3){
                   GameScreen.bg[x][y-1]=0;
                   Point+=20;
                   GameScreen.bomb.remove(0);
               }
            y-=1;
            
        }
        if(vector==4&& GameScreen.bg[x][y+1]!=1){
            for(MOnster m:GameScreen.mon ){
                   if(m.x==x&&m.y==y+1){
                       die=true;
                   }
               }
            if(GameScreen.bg[x][y+1]==2){
                   GameScreen.bg[x][y+1]=0;
                   Point+=10;
                   
               }
            if(GameScreen.bg[x][y+1]==3){
                   GameScreen.bg[x][y+1]=0;
                   Point+=20;
                   GameScreen.bomb.remove(0);
               }
            y+=1;
            
        }
        
        
        if(x>24) x=0;
        else if(x<0) x=24;    
        else if(y>20) y=0;
        else if(y<0) y=20;
        
        System.out.println(Point); 
    }
}
