package object;

import javax.imageio.ImageIO;

public class OBJ_Item4 extends SuperObject {
	public OBJ_Item4() {
		name ="Item4";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/res/objects/Item4.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 collistion= true;
		 
	}

}
