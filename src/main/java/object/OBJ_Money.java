package object;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Money extends SuperObject{
	public static final String resources = System.getProperty("user.dir") + "/src/main/resources/";

	public OBJ_Money() {
		name = "Money";
		try {
			image = ImageIO.read(new File(resources +"res/objects/money.png"));
		} catch (Exception e) {
			
		}
		collistion = true;
	}
}
