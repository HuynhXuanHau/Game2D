package object;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Item4 extends SuperObject {
	public static final String resources = System.getProperty("user.dir") + "/src/main/resources/";

	public OBJ_Item4() {
		name ="Item4";
		try {
			image = ImageIO.read(new File(resources +"res/objects/Item4.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 collistion= true;
		 
	}

}
