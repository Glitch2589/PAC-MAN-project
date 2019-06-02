/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author TripleB
 */
public class ImageStore {
    
    public static BufferedImage sprite;
    public static Image upHead;
    public static Image downHead;
    public static Image leftHead;
    public static Image rightHead;
    public static Image Head;
    public static Animations up;
    public static Animations down;
    public static Animations left;
    public static Animations right;
    public static void loadImage(){
        try {
        sprite=ImageIO.read(new File("test/sprite1.png"));
        Head=sprite.getSubimage(0,0, 35, 35);
        downHead=sprite.getSubimage(36,0, 35, 35);
        leftHead=sprite.getSubimage(72,0, 35,35);
        rightHead=sprite.getSubimage(108, 0,35,35);
        upHead=sprite.getSubimage(143,0,35,35);
            
        } catch (Exception e) {
        }
    }
    public static void loadAllAnim(){
        up=new Animations();
        up.addImage(Head);
        up.addImage(upHead);
        
        down=new Animations();
        down.addImage(Head);
        down.addImage(downHead);
        
        left=new Animations();
        left.addImage(Head);
        left.addImage(leftHead);
        
        right=new Animations();
        right.addImage(Head);
        right.addImage(rightHead);
    }
    
}
