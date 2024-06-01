package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int[][] mapTileNum;
	//KeyHandler keyH ;
	
	
	public TileManager(GamePanel gp) {

		this.gp = gp;
	//	this.keyH = gp.keyH;
		
		tile = new Tile[1000];
		mapTileNum = new int[gp.maxHouseCol][gp.maxHouseRow];
		loadInitialMap();

	}
	public void loadInitialMap() {
		if (gp.keyH.map1) {
			getTileImage();
			loadMap("/res/map/mapp.txt");
		} else {
			getTileImage();
			loadMap("/res/map/text.txt"); // Assuming a second map files
		}
	}

	public void getTileImage() {
		setUp(0,"wood", false);
		setUp(1,"wood", false);
		setUp(2,"wood", false);
		setUp(3,"wood", false);
		setUp(4,"wood", false);
		setUp(5,"wood", false);
		setUp(6,"wood", false);
		setUp(7,"wood", false);
		setUp(8,"wood", false);
		setUp(9,"9", true);
		setUp(10,"10", true);
		setUp(11,"11", true);
		setUp(12,"12", true);
		setUp(13,"13", true);
		setUp(14,"14", true);
		setUp(15,"15", true);
		setUp(16,"16", true);
		setUp(17,"17", true);
		setUp(18,"18", true);
		setUp(19,"19", true);
		setUp(20,"20", false);
		setUp(21,"21", false);
		setUp(22,"22", true);
		setUp(23,"23", true);
		setUp(24,"24", true);
		setUp(25,"25", true);
		setUp(26,"26", true);
		setUp(27,"27", true);
		setUp(28,"28", true);
		setUp(29,"29", true);
		setUp(30,"30", true);
		setUp(31,"31", true);
		setUp(32,"32", true);
		setUp(33,"33", false);
		setUp(34,"34", true);
		setUp(35,"35", true);
		setUp(36,"36", true);
		setUp(37,"37", true);
		setUp(38,"38", true);
		setUp(39,"39", true);
		setUp(40,"40", true);
		setUp(41,"41", true);
		setUp(42,"42", true);
		setUp(43,"43", true);
		setUp(44,"44", true);
		setUp(45,"45", true);
		setUp(46,"46", true);
		setUp(47,"47", true);
		setUp(48,"48", true);
		setUp(49,"49", true);
		setUp(50,"50", true);
		setUp(51,"51", true);
		setUp(52,"52", true);
		setUp(53,"53", true);
		setUp(54,"54", true);
		setUp(55,"55", true);
		setUp(56,"56", true);
		setUp(57,"57", true);
		setUp(58,"58", true);
		setUp(59,"59", true);
		setUp(60,"60", true);
		setUp(61,"61", true);
		setUp(62,"62", true);
		setUp(63,"63", true);
		setUp(64,"64", true);
		setUp(65,"65", true);
		setUp(66,"66", true);
		setUp(67,"67", true);
		setUp(68,"68", true);
		setUp(69,"69", true);
		setUp(70,"70", true);
		setUp(71,"71", true);
		setUp(72,"72", true);
		setUp(73,"73", true);
		setUp(74,"74", false);
		setUp(75,"75", false);
		setUp(76,"76", false);
		setUp(77,"77", false);
		setUp(78,"78", false);
		setUp(79,"79", false);
		setUp(80,"80", false);
		setUp(81,"81", false);
		setUp(82,"82", false);
		setUp(83,"83", true);
		setUp(84,"84", true);
		setUp(85,"85", true);
		setUp(86,"86", true);
		setUp(87,"87", true);
		setUp(88,"88", true);
		setUp(89,"89", true);
		setUp(90,"90", false);
		setUp(91,"91", true);
		setUp(92,"92", false);
		setUp(93,"93", false);
		setUp(94,"94", false);
		setUp(95,"95", true);
		setUp(96,"96", true);
		setUp(97,"97", true);
		setUp(98,"98", true);
		setUp(99,"99", true);
		setUp(100,"100", true);
		setUp(101,"101", true);
		setUp(102,"102", true);
		setUp(103,"103", true);
		setUp(104,"104", true);
		setUp(105,"105", true);
		setUp(106,"106", true);
		setUp(107,"107", true);
		setUp(108,"108", true);
		setUp(109,"109", true);
		setUp(110,"110", true);
		setUp(111,"111", true);
		setUp(112,"112", true);
		setUp(113,"113", true);
		setUp(114,"114", true);
		setUp(115,"115", true);
		setUp(116,"116", true);
		setUp(117,"117", true);
		setUp(118,"118", true);
		setUp(119,"119", true);
		setUp(120,"120", true);
		setUp(121,"121", true);
		setUp(122,"122", true);
		setUp(123,"123", true);
		setUp(124,"124", true);
		setUp(125,"125", true);
		setUp(126,"126", false);
		setUp(127,"127", false);
		setUp(128,"128", true);
		setUp(129,"129", true);
		setUp(130,"130", true);
		setUp(131,"131", true);
		setUp(132,"132", true);
		setUp(133,"133", true);
		setUp(134,"134", true);
		setUp(135,"135", true);
		setUp(136,"136", true);
		setUp(137,"137", true);
		setUp(138,"138", true);
		setUp(139,"139", true);
		setUp(140,"140", true);
		setUp(141,"141", true);
		setUp(142,"142", true);
		setUp(143,"143", true);
		setUp(144,"144", false);
		setUp(145,"145", true);
		setUp(146,"146", true);
		setUp(147,"147", true);
		setUp(148,"148", false);
		setUp(149,"149", true);
		setUp(150,"150", false);
		setUp(151,"151", true);
		setUp(152,"152", true);
		setUp(153,"153", true);
		setUp(154,"154", true);
		setUp(155,"155", true);
		setUp(156,"156", true);
		setUp(157,"157", false);
		setUp(158,"158", false);
		setUp(159,"159", false);
		setUp(160,"160", true);
		setUp(161,"161", true);
		setUp(162,"162", true);
		setUp(163,"163", true);
		setUp(164,"164", true);
		setUp(165,"165", true);
		setUp(166,"166", true);
		setUp(167,"167", true);
		setUp(168,"168", true);
		setUp(169,"169", true);
		setUp(170,"170", true);
		setUp(171,"171", true);
		setUp(172,"172", true);
		setUp(173,"173", true);
		setUp(174,"174", true);
		setUp(175,"175", true);
		setUp(176,"176", true);
		setUp(177,"177", true);
		setUp(178,"178", true);
		setUp(179,"179", true);
		setUp(180,"180", true);
		setUp(181,"181", true);
		setUp(182,"182", false);
		setUp(183,"183", false);
		setUp(184,"184", false);
		setUp(185,"185", false);
		setUp(186,"186", true);
		setUp(187,"187", true);
		setUp(188,"188", true);
		for (int i =189 ; i<= 613 ;i++){
			switch (i) {
				case 579:
				case 358:
				case 578:
				case 435:
				case 390:
				case 430:
				case 431:
				case 432:
				case 434:
				case 372:
				case 373:
				case 374:
				case 196:
				case 203:
				case 194:
				case 195:
				case 197:
				case 255:
				case 277:
				case 275:
				case 276:
				case 206:
				case 219:
				case 204:
				case 254:
				case 205:
				case 213:
				case 357:
				case 495:
				case 515:
				case 535:
				case 549:
				case 564:
				case 575:
				case 190:
				case 193:
				case 516:
				case 536:
				case 576:
				case 375:
				case 391:
				case 577:
				case 526:
				case 528:
				case 527:
				case 530:
				case 531:
				case 532:
				case 533:
				case 524:
				case 525:
				case 544:
				case 545:
				case 359:
				case 360:
				case 370:
				case 365:
				case 366:
				case 371:
				case 385:
				case 400:
				case 425:
				case 445:
				case 467:
				case 383:
				case 398:
				case 411:
				case 423:
				case 443:
				case 464:
				case 436:
				case 437:
				case 438:
				case 439:
				case 440:
				case 441:
				case 367:
				case 369:
				case 447:
				case 446:
				case 448:
				case 449:
				case 468:
				case 485:
				case 504:
				case 529:
				case 506:
				case 507:
				case 426:
				case 422:
				case 333:
				case 242:
				case 243:
				case 244:
				case 345:
				case 346:
				case 354:
				case 355:
				case 356:
				case 497:
				case 498:
				case 499:
				case 500:
				case 517:
				case 518:
				case 520:
				case 537:
				case 538:
				case 539:
				case 540:
				case 570:
				case 571:
				case 572:
				case 318:
				case 340:
				case 341:
				case 342:
				case 343:
				case 344:
				case 296:
				case 293:
				case 292:
				case 291:
				case 290:
				case 289:
				case 288:
				case 287:
				case 286:
				case 285:
				case 284:
				case 283:
				case 339:
				case 522:
				case 314:
				case 322:
				case 332:
				case 256:
				case 257:
				case 258:
				case 259:
				case 260:
				case 280:
				case 281:
				case 298:
				case 299:

					setUp(i, i + "", true);
					break;
				default:
					setUp(i, i + "", false);
			}
		}
	}
	public void setUp(int index, String imageName, boolean collision) {
			UtilityTool uTool = new UtilityTool();
			try {
				tile[index]= new Tile();
				tile[index].image = ImageIO.read(getClass().getResourceAsStream( "/res/tiles/"+imageName+".png"));
				tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
				tile[index].collision = collision;
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader( new InputStreamReader(is));
			int col = 0;
			int row = 0;
			
			while (col< gp.maxHouseCol && row <gp.maxHouseRow){
				String line = br.readLine();
				
				while (col <gp.maxHouseCol) {
					String numbers[] = line.split("  ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				
				if (col == gp.maxHouseCol) {
					col = 0;
					row ++;
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public void draw(Graphics2D g2) {
		int houseCol = 0;
		int houseRow = 0;
		
		while (houseCol < gp.maxHouseCol && houseRow < gp.maxHouseRow) {
			 
			int tileNum = mapTileNum[houseCol][houseRow];
			int houseX = houseCol * gp.tileSize;
			int houseY = houseRow * gp.tileSize; 
			int screenX = houseX - gp.player.houseX + gp.player.screenX;
			int screenY = houseY - gp.player.houseY + gp.player.screenY;
			
			if (houseX + gp.tileSize > gp.player.houseX - gp.player.screenX &&
				houseX - gp.tileSize < gp.player.houseX + gp.player.screenX &&
				houseY + gp.tileSize > gp.player.houseY - gp.player.screenY &&
				houseY - gp.tileSize < gp.player.houseY + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
			houseCol ++;
			
			if (houseCol == gp.maxHouseCol) {
				houseCol = 0;
				houseRow ++;
			}
		}
	}
}
