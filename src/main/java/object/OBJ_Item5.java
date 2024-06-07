package object;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Item5 extends SuperObject {
	public static final String resources = System.getProperty("user.dir") + "/src/main/resources/";

	public OBJ_Item5 () {
		name ="Item5";
		try {
			 image = ImageIO.read(new File(resources +"res/objects/Item5.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 collistion= true;
	}
}
