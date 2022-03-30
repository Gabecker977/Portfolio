import java.awt.Color;
	import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {
	

		public boolean right,left;
		public double x,y;
		public int width,height;
		public Enemy(int x, int y) {
			this.x = x;
			this.y = y;
			this.width = 40;
			this.height = 10;
		}
		public void tick() {/*
			if(right) {
				x+=2;
				
			}
			else if(left) {
				x-=2;
			}
			if(x+width > Game.WIDTH) {
				x = Game.WIDTH - width;
			}
			else if(x < 0 ) {x = 0;}*/
			
			x+=(Game.boll.x - x)*0.1;
			
			if(x+width > Game.WIDTH) {
				x = Game.WIDTH - width;
			}
			else if(x < 0 ) {x = 0;}
			
		}
		public void rander(Graphics g) {
			g.setColor(Color.GREEN);
			g.fillRect((int)x, (int)y, width, height);
		}
	}


