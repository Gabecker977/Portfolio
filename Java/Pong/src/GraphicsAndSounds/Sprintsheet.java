package GraphicsAndSounds;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Sprintsheet {
		private BufferedImage spritesheet;
		public Sprintsheet(String path) {
			try {
				spritesheet = ImageIO.read(getClass().getResource(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public BufferedImage getSprint(int x, int y, int width,int height) {
			return spritesheet.getSubimage(x, y, width, height);
	}
}
