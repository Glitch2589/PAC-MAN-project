/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findpath;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author TripleB
 */
public class Game extends JPanel implements MouseListener
{

	private Map map;
	private Player player;
	private LinkedList<Node> path;

	int[][] m0 = { //
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, //
			{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 }, //
			{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 }, //
			{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1 }, //
			{ 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1 }, //
			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 }, //
			{ 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 }, //
			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 }, //
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 }, //
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	int[][] m1 = { //
			{ 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 0, 0, 0 }, //
			{ 0, 0, 0, 1, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0 } };

	public Game()
	{
		// Change this to whatever map you want, and feel free to add more.
		int[][] m = m0;
//		int[][] m = m1;

		setPreferredSize(new Dimension(m[0].length * 32, m.length * 32));
		addMouseListener(this);
		
		map = new Map(m);
		player = new Player(1, 1);
	}

	public void update()
	{
		player.update();
	}

	public void render(Graphics2D g)
	{
		map.drawMap(g, path);
		g.setColor(Color.GRAY);
		for (int x = 0; x < getWidth(); x += 32)
		{
			g.drawLine(x, 0, x, getHeight());
		}
		for (int y = 0; y < getHeight(); y += 32)
		{
			g.drawLine(0, y, getWidth(), y);
		}
		
		g.setColor(Color.RED);
		g.fillRect(player.getX() * 32 + player.getSx(), player.getY() * 32 + player.getSy(), 32, 32);
	}

	
	public void mouseClicked(MouseEvent e)
	{
	}

	
	public void mouseEntered(MouseEvent e)
	{
	}

	
	public void mouseExited(MouseEvent e)
	{
	}

	
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX() / 32;
		int my = e.getY() / 32;
		if (map.getNode(mx, my).isWalkable())
		{
			path = map.findPath(player.getX(), player.getY(), mx, my);
			player.followPath(path);
		}
		else
		{
			System.out.println("Can't walk to that node!");
		}
	}

	
	public void mouseReleased(MouseEvent e)
	{
	}
        
}
