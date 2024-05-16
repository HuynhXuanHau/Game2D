package object;

import javax.imageio.ImageIO;

public class OBJ_Shit extends SuperObject{
	public OBJ_Shit() {
		name ="Shit";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/res/objects/shit.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 collistion= true;
	}

}
