/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class GameScreen extends JPanel implements Runnable{
    Thread thread;
    MainCharacter main;
    static int bg[][]=new int [25][21];
    Random r=new Random();
    static ArrayList<SpecialBom> bomb=new ArrayList<>();
    static ArrayList<MOnster> mon=new ArrayList<>();
    Sound sound;
    
    public GameScreen(){
        this.setBounds(0, 0, 900, 910);
        
        thread=new Thread(this);
        
        ImageStore.loadImage();
        ImageStore.loadAllAnim();
        sound=new Sound(new File("test/song.wav"));
        MOnster m1=new MOnster(8,9);
        mon.add(m1);
        for(int i=0;i<21;i++){
            if(i!=10) bg[1][i]=2;
            else bg[1][i]=1;
        }
        for(int i=2;i<4;i++){
            for(int y=1;y<20;y++){
                if(y!=1&&y!=5&&y!=9&&y!=11&&y!=15&&y!=19){
                    bg[i][y]=1;
                }else bg[i][y]=2;
            }
        }
        for(int i=0;i<21;i++){
            if(i!=1&&i!=5&&i!=7&&i!=13&&i!=15&&i!=19){
                bg[5][i]=1;
            }else bg[5][i]=2;
        }
        
        for(int i=0;i<21;i++){
            if(i==6||i==10||i==14){
                bg[6][i]=1;
            }else bg[6][i]=2;
        }
        
        for(int i=0;i<21;i++){
            if(i!=15&&i!=5&&i!=9&&i!=11){
                bg[7][i]=1;
            }else bg[7][i]=2;
        }
        
        for(int i=0;i<21;i++){
            if(i==5||i==7||i==13||i==15){
                bg[15][i]=2;
            }else bg[15][i]=1;
        }
        for(int i=0;i<21;i++){
            if(i==5||i==7||i==13||i==15){
                bg[9][i]=2;
            }else bg[9][i]=1;
        }
        for(int i=0;i<21;i++){
            if(i==5||i==7||i==13||i==15){
                bg[13][i]=2;
            }else bg[13][i]=1;
        }
        for(int i=0;i<21;i++){
            if(i==5||i==7||i==8||i==9||i==10||i==11||i==12||i==13||i==15){
                bg[8][i]=2;
            }else bg[8][i]=1;
        }
        for(int i=0;i<21;i++){
            if(i==5||i==7||i==8||i==9||i==10||i==11||i==12||i==13||i==15){
                bg[14][i]=2;
            }else bg[14][i]=1;
        }
        for(int i=0;i<21;i++){
            if(i==5||i==7||i==9||i==10||i==11||i==13||i==15){
                bg[10][i]=2;
            }else bg[10][i]=1;
        }
        for(int i=0;i<21;i++){
            if(i==5||i==7||i==9||i==10||i==11||i==13||i==15){
                bg[12][i]=2;
            }else bg[12][i]=1;
        }
        for(int i=0;i<21;i++){
            if(i!=10) bg[16][i]=2;
            else bg[16][i]=1;
        }
        bg[11][8]=1;
        bg[11][12]=1;
        for(int y=1;y<20;y++){
                if(y!=1&&y!=5&&y!=9&&y!=11&&y!=15&&y!=19){
                    bg[17][y]=1;
                }else bg[17][y]=2;
            }
        bg[19][4]=1;
        bg[19][16]=1;
        
        for(int i=0;i<21;i++){
            if(i==1||i==5||i==9||i==11||i==15||i==19){
                 bg[18][i]=2;   
            }else bg[18][i]=1;
        }
        for(int i=0;i<21;i++){
            if(i!=3 && i!=5 && i!=7 && i!=13 && i!=15 && i!=17){
                bg[20][i]=1;
            }else bg[20][i]=2;
        }
        for(int i=0;i<21;i++){
            if(i==6||i==10||i==14){
                bg[21][i]=1;
            }else bg[21][i]=2;
        }
        for(int i=0;i<21;i++){
             if(i==1||i==9||i==11||i==19){
                 bg[22][i]=2;
             }else bg[22][i]=1;   
        }
        for(int i=0;i<21;i++){
            bg[23][i]=2;
        }
        for(int i=0;i<25;i++){
            bg[i][0]=1;
            bg[i][20]=1;
            
        }
        for(int i=0;i<21;i++){
            bg[0][i]=1;
            bg[24][i]=1;
        }
        
        //bg[11][0]=0;
        //bg[11][20]=0;
        main=new MainCharacter();
        
        thread.start();
    }

    @Override
    public void run() {
        long t=0;
        long t1=0;
        long t2=0;
        long t3=0;
        while(true){
           
           if(System.currentTimeMillis()-t2>50){
               ImageStore.down.update();
               ImageStore.up.update();
               ImageStore.left.update();
               ImageStore.right.update();
               t2=System.currentTimeMillis();
           }
           if(System.currentTimeMillis()-t3>152000){
               sound.play();
               t3=System.currentTimeMillis();
           }
           if(System.currentTimeMillis()-t>200){
               main.update();
               
               boolean delete=false;
               for(SpecialBom bo: bomb){
                   bo.update();
                   if(bo.timeExist>50){
                       
                       delete=true;
                       bg[bo.x][bo.y]=0;
                   }
                  
                   
               }
               if(delete) bomb.remove(0);
               
               t=System.currentTimeMillis();
           }
           
           if(System.currentTimeMillis()-t1>15000){
               while(true){
                   int x=r.nextInt(24);
                   int y=r.nextInt(20);
                   if(bg[x][y]==0){
                       bg[x][y]=3;
                       SpecialBom bom=new SpecialBom(x,y);
                       bomb.add(bom);
                       break;
                   }
               }
               t1=System.currentTimeMillis();
               
           }
           repaint();
        }
        
        
        
    }
    public void paint(Graphics g){
       
        g.setColor(Color.black);
        for(int i=0;i<25;i++){
            for(int y=0;y<21;y++){
                g.fillRect(y*35, i*35, 34, 34);
            }
        }
        
        for(int i=0;i<25;i++){
            for(int y=0;y<21;y++){
                if(bg[i][y]==1){
                    g.setColor(Color.blue);
                    g.fillRect(y*35, i*35, 34,34);
                }
                if(bg[i][y]==2){
                    g.setColor(Color.yellow);
                    g.fillOval(y*35+10,i*35+10,15,15);
                    
                }
                
            }
        }
        g.setColor(Color.red);
        main.ve(g);
        for(MOnster m: mon){
            m.ve(g);
        }
        for(SpecialBom b: bomb){
            b.ve(g);
    }
    }
    
    
    
    
}
