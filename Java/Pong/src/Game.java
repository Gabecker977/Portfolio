import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


import javax.swing.JFrame;

import GraphicsAndSounds.Sounds;
import GraphicsAndSounds.Sprintsheet;

public class Game extends Canvas implements Runnable,KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 160;
	public static int HEIGHT = 120;
	public static int SCALE = 3;
	public static String Gamestate = "Normal";
	public static Sprintsheet spritesheet;
	
	public static Sounds sounds = new Sounds();
	
	public BufferedImage rebecca;
	
	public BufferedImage layer = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	public static Player player;
	public static Enemy enemy;
	public static Boll boll;
	
	public Game() {
		
		requestFocus();
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		this.addKeyListener(this);
		player = new Player(100, HEIGHT-10);
		enemy = new Enemy(100,0);
		boll = new Boll(100,HEIGHT/2-10);
		spritesheet = new Sprintsheet("/Rebecca.png");
		rebecca = Game.spritesheet.getSprint(0, 0, 80, 75);
	}
	public static void main(String[]args) {
		Game game = new Game();
		JFrame frame = new JFrame("PONG");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(game).start();
	}
public void tick() {
	if(Gamestate == "Normal") {
		player.tick();
		enemy.tick();
		boll.tick();
		}
	}
	public void rander() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = layer.getGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(rebecca,WIDTH/4,HEIGHT/4,null);
		player.rander(g);
		enemy.rander(g);
		boll.rander(g);
		
		g = bs.getDrawGraphics();
		
		g.drawImage(layer, 0, 0, WIDTH*SCALE,HEIGHT*SCALE,null);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Player 2: "+Boll.score1,0,15);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Player 1: "+Boll.score2,0,HEIGHT*SCALE-10);
	if(Gamestate == "Score") {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0,0,  WIDTH*SCALE,  HEIGHT*SCALE);
		if(Boll.score2 > Boll.score1) {
			g.setColor(new Color(255,255,255));
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Vencedor", WIDTH*SCALE/2-40, HEIGHT*SCALE/2);}
		else if(Boll.score2 < Boll.score1) {
			g.setColor(new Color(255,255,255));
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Perdedor", WIDTH*SCALE/2-40, HEIGHT*SCALE/2);}
		else{g.setColor(new Color(255,255,255));
			g.drawString("Empate", WIDTH*SCALE/2-40, HEIGHT*SCALE/2);}
	}
		bs.show();
	}

	public void run() {
		while(true) {
			tick();
			rander();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			
			enemy.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			enemy.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER && Gamestate == "Score") {
			Boll.score1=0;
			Boll.score2=0;
			Gamestate = "Normal";
			new Game();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			player.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			
			enemy.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			enemy.left = false;}
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
