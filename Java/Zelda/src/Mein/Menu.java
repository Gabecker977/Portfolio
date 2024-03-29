package Mein;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import World.World;

public class Menu {
	public String[] options = {"new game","load game","about","exit"};
	
	public int currentOptions = 0;
	public int MaxOptions = options.length - 1;
	
	public boolean up,down,enter;
	public static boolean pause = false;
	public static boolean saveExists = false;
	public static boolean saveGame = false;
	public void tick() {
		File file =  new File("save.txt");
		if(file.exists()) {
			saveExists = true;
		}else {
			saveExists = false;
		}
		if(up) {
			up = false;
			currentOptions--;
			if(currentOptions < 0) 
				currentOptions = MaxOptions;	
			}
			if(down) {
				down = false;
				currentOptions++;
				if(currentOptions > MaxOptions) 
					currentOptions = 0;
		}
		if(enter){
			//Sounds.music.loop();
			enter = false;
			if(options[currentOptions] == "new game" || options[currentOptions] == "Back") {
				Game.gameState = "Normal";
				pause = false;
				file = new File("save.txt");
				file.delete();
			}else if(options[currentOptions] == "load game") {
				file = new File("save.txt");
				if(file.exists()) {
					String saver = loadGame(10);
					applySave(saver);
				}
			}
			else if(options[currentOptions] == "exit") {
				System.exit(1);
			}
		} 
	}
	public static void applySave(String str) {
		String[] spl = str.split("/");
		for(int i = 0; i < spl.length; i++) {
			String[] spl2 = spl[i].split(":");
			switch(spl2[0]) 
			{
				case"level":
					World.restart("level"+spl2[1]+".png");
					Game.gameState = "Normal";
					break;
				case "life":
					Game.player.life = Integer.parseInt(spl2[1]);
					break;
			}	
		}
	}
	public String loadGame(int encode) {
		String line = "";
		File file = new File("save.txt");
		if(file.exists()) {
			try {
			String singleLine = null;
			BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
			try {
				while((singleLine = reader.readLine())!=null) {
					String[] trans = singleLine.split(":");
					char[] val = trans[1].toCharArray();
					trans[1] = "";
					for(int i = 0; i < val.length; i++) {
						val[i]-=encode;
						trans[1]+=val[i];
					}
					line+=trans[0];
					line+=":";
					line+=trans[1];
					line+="/";
				}
				}catch(IOException e) {}
			}catch(FileNotFoundException e) {}
			}
			return line;
	}
	
	public void saveGame(String[] val1, int[] val2, int encode) {
		BufferedWriter write = null;
		try {
		write = new BufferedWriter(new FileWriter("save.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < val1.length; i++) {
			String current = val1[i];
			current+=":";
			char[] value = Integer.toString(val2[i]).toCharArray();
			for(int n = 0; n < value.length; n++) {
				value[n]+=encode;
				current+=value[n];
			}
			try {
				write.write(current);
				if(i < val1.length -1)
					write.newLine();
			}catch(IOException e) {}
		} try {
			write.flush();
			write.close();
		}catch(IOException e) {}
	}
	public void rander(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0,0,Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.white);
		g.setFont(Mein.Game.newfont);
		g.drawString(">BECKER engine<", (Game.WIDTH*Game.SCALE)/3,(Game.HEIGHT*Game.SCALE)/12);
		//Opi�oes do menu
		
		
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 20));
		if(pause == false)
		g.drawString("New Game", (Game.WIDTH*Game.SCALE)/3 + 30,(Game.HEIGHT*Game.SCALE)/5);
		else
			g.drawString("Continue", (Game.WIDTH*Game.SCALE)/3 + 30,(Game.HEIGHT*Game.SCALE)/5);
		g.drawString("Load Game", (Game.WIDTH*Game.SCALE)/3 + 30,(Game.HEIGHT*Game.SCALE)/5 + 30);
		g.drawString("About", (Game.WIDTH*Game.SCALE)/3 + 30,(Game.HEIGHT*Game.SCALE)/5 + 60);
		g.drawString("Exit", (Game.WIDTH*Game.SCALE)/3 + 30,(Game.HEIGHT*Game.SCALE)/5 + 90);
		
		if(options[currentOptions] == "new game") {
			g.drawString(">",(Game.WIDTH*Game.SCALE)/3 + 14,(Game.HEIGHT*Game.SCALE)/5);
		}else if(options[currentOptions] == "load game") {
			g.drawString(">",(Game.WIDTH*Game.SCALE)/3 + 14,(Game.HEIGHT*Game.SCALE)/5 + 30);}
else if(options[currentOptions] == "about") {
	g.drawString(">",(Game.WIDTH*Game.SCALE)/3 + 14,(Game.HEIGHT*Game.SCALE)/5 + 60);}
	else if(options[currentOptions] == "exit") {
		g.drawString(">",(Game.WIDTH*Game.SCALE)/3 + 14,(Game.HEIGHT*Game.SCALE)/5 + 90);}
}
}

