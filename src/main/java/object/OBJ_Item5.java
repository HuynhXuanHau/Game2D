package object;

import javax.imageio.ImageIO;

public class OBJ_Item5 extends SuperObject {
	public OBJ_Item5 () {
		name ="Item5";
		try {
			 image = ImageIO.read(getClass().getResourceAsStream("/res/objects/Item5.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 collistion= true;
	}
}
