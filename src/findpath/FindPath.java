/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findpath;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author TripleB
 */
public class FindPath {

   public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final String NAME = "Game";

	private static BufferedImage image;
	private static Graphics2D g;
	private static boolean forceQuit;

	private static Game game;

	private static void init()
	{
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		g.setBackground(Color.BLACK);

		game = new Game();
	}

	private static void start()
	{
		run();
	}

	public static void stop()
	{
		forceQuit = true;
	}

	public static void run()
	{
		@SuppressWarnings("unused")
		int frames = 0;

		double unprocessedSeconds = 0;
		long lastTime = System.nanoTime();
		double secondsPerTick = 1.0 / 60.0;
		int tickCount = 0;

		while (!forceQuit)
		{
			long now = System.nanoTime();
			long passedTime = now - lastTime;
			lastTime = now;
			if (passedTime < 0)
				passedTime = 0;
			if (passedTime > 100000000)
				passedTime = 100000000;

			unprocessedSeconds += passedTime / 1000000000.0;

			boolean ticked = false;
			while (unprocessedSeconds > secondsPerTick)
			{
				game.update();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;

				tickCount++;
				if (tickCount % 60 == 0)
				{
					// System.out.println("FPS:" + frames);
					lastTime += 1000;
					frames = 0;
				}
			}

			if (ticked)
			{
				game.render(g);

				Graphics gg = game.getGraphics();
				gg.drawImage(image, 0, 0, null);
				gg.dispose();

				frames++;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args)
	{
		FindPath.init();

		JFrame frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(3);
		frame.setContentPane(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		FindPath.start();
	}
    
}
