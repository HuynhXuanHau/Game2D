package object;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Random extends SuperObject{
	public static final String resources = System.getProperty("user.dir") + "/src/main/resources/";

	public OBJ_Random() {
	 name ="Random";
	 try {
		image = ImageIO.read(new File(resources +"res/objects/Random.png"));
	} catch (Exception e) {
		// TODO: handle exception
	}
	 collistion= true;
 }
}
