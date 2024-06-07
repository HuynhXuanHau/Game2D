package object;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Gold extends SuperObject{
	public static final String resources = System.getProperty("user.dir") + "/src/main/resources/";

	public OBJ_Gold() {
		name="Gold";
		try {
			image = ImageIO.read(new File(resources + "res/objects/gold.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 collistion= true;
	}

	
}
