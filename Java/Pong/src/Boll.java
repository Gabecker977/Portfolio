import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import GraphicsAndSounds.Sounds;

public class Boll {
	public double dx,dy;
	public double speed = 1.6;
	public double x,y;
	public int width,height;
	private int r,b,a;
	
	public static int score1=0,score2=0;
	public Boll(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 20;
		this.height = 20;
		int angle = new Random().nextInt((175-30)+30);
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
		if(angle<20)
			angle+=20;
		else if(angle>160)
			angle+=60;
	}
	public void tick() {
		x+=dx*speed;
		y+=dy*speed;
		if(x+(dx*speed) + width > Game.WIDTH) {
			dx*=-1;
		}else if(x+(dx*speed) < 0) {
			dx*=-1;
		}
		if(y >= Game.HEIGHT) {
			score1++;
			new Game();
			return;}
		else if(y < 0) {
			score2++;
			new Game();
			return;
		}else if(width<=0) {
			//Game.boll = new Boll(100,Game.HEIGHT/2-10);
			score1++;
			score2++;
			new Game();
			return;
		}
		if(score1 >= 5||score2 >= 5)
			Game.Gamestate = "Score";
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),width,height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.width,Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)(Game.enemy.x),(int)(Game.enemy.y),Game.enemy.width,Game.enemy.height);
		if(bounds.intersects(boundsPlayer) || bounds.intersects(boundsEnemy)) {
			Sounds.shoot.play();
			dy*=-1;
			Random rand = new Random();
		speed+=0.4;
		width--;
		height--;
		r = rand.nextInt(255);
		b = rand.nextInt(255);
		a = rand.nextInt(255);
			if(bounds.intersects(boundsPlayer)){
				y--;
			}else if(bounds.intersects(boundsEnemy))
				y++;
		}
	}
	public void rander(Graphics g) {
		Random rand = new Random();
		//Graphics2D g2 =  (Graphics2D) g;
		g.setColor(new Color(r,a,b));
		//g.setColor(Color.BLUE);
		g.fillOval((int)x, (int)y, width, height);
	
}}

	

