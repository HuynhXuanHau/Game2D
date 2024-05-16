package object;

import javax.imageio.ImageIO;

public class OBJ_Money extends SuperObject{
	public OBJ_Money() {
		name = "Money";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/res/objects/money.png"));
		} catch (Exception e) {
			
		}
		collistion = true;
	}
}
