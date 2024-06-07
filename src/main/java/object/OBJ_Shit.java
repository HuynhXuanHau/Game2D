package object;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Shit extends SuperObject{
	public static final String resources = System.getProperty("user.dir") + "/src/main/resources/";

	public OBJ_Shit() {
		name ="Shit";
		try {
			image = ImageIO.read(new File(resources +"res/objects/shit.png"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		 collistion= true;
	}

}
