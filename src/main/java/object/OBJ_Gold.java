package object;

import javax.imageio.ImageIO;

public class OBJ_Gold extends SuperObject{
	public OBJ_Gold() {
		name="Gold";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/res/objects/gold.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 collistion= true;
	}

	
}
