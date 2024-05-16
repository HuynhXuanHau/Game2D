package object;

import javax.imageio.ImageIO;

public class OBJ_Random extends SuperObject{
 public OBJ_Random() {
	 name ="Random";
	 try {
		image = ImageIO.read(getClass().getResourceAsStream("/res/objects/Random.png"));
	} catch (Exception e) {
		// TODO: handle exception
	}
	 collistion= true;
 }
}
