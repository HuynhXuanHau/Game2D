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
			getTileImage2();
			loadMap02("/res/map/text.txt"); // Assuming a second map filess
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
		
	}
	public void getTileImage2() {
		setUpMap02(0,"wood", false);
		setUpMap02(1,"wood", false);
		setUpMap02(2,"wood", false);
		setUpMap02(3,"wood", false);
		setUpMap02(4,"wood", false);
		setUpMap02(5,"wood", false);
		setUpMap02(6,"wood", false);
		setUpMap02(7,"wood", false);
		setUpMap02(8,"wood", false);
		setUpMap02(9,"wood", true);
		setUpMap02(10,"10", true);
		setUpMap02(11,"11", true);
		setUpMap02(12,"12", true);
		setUpMap02(13,"13", true);
		setUpMap02(14,"14", true);
		setUpMap02(15,"15", true);
		setUpMap02(16,"16", true);
		setUpMap02(17,"17", true);
		setUpMap02(18,"18", true);
		setUpMap02(19,"19", true);
		setUpMap02(20,"20", true);
		setUpMap02(21,"21", true);
		setUpMap02(22,"22", true);
		setUpMap02(23,"23", true);
		setUpMap02(24,"24", true);
		setUpMap02(25,"25", true);
		setUpMap02(26,"26", true);
		setUpMap02(27,"27", true);
		setUpMap02(28,"28", true);
		setUpMap02(29,"29", true);
		setUpMap02(30,"30", true);
		setUpMap02(31,"31", true);
		setUpMap02(32,"32", true);
		setUpMap02(33,"33", true);
		setUpMap02(34,"34", true);
		setUpMap02(35,"35", true);
		setUpMap02(36,"36", true);
		setUpMap02(37,"37", true);
		setUpMap02(38,"38", true);
		setUpMap02(39,"39", true);
		setUpMap02(40,"40", true);
		setUpMap02(41,"41", true);
		setUpMap02(42,"42", true);
		setUpMap02(43,"43", true);
		setUpMap02(44,"44", true);
		setUpMap02(45,"45", true);
		setUpMap02(46,"46", true);
		setUpMap02(47,"47", true);
		setUpMap02(48,"48", true);
		setUpMap02(49,"49", true);
		setUpMap02(50,"50", true);
		setUpMap02(51,"51", true);
		setUpMap02(52,"52", true);
		setUpMap02(53,"53", true);
		setUpMap02(54,"54", true);
		setUpMap02(55,"55", true);
		setUpMap02(56,"56", true);
		setUpMap02(57,"57", true);
		setUpMap02(58,"58", true);
		setUpMap02(59,"59", true);
		setUpMap02(60,"60", true);
		setUpMap02(61,"61", true);
		setUpMap02(62,"62", true);
		setUpMap02(63,"63", true);
		setUpMap02(64,"64", true);
		setUpMap02(65,"65", true);
		setUpMap02(66,"66", true);
		setUpMap02(67,"67", true);
		setUpMap02(68,"68", true);
		setUpMap02(69,"69", true);
		setUpMap02(70,"70", true);
		setUpMap02(71,"71", true);
		setUpMap02(72,"72", true);
		setUpMap02(73,"73", true);
		setUpMap02(74,"74", true);
		setUpMap02(75,"75", true);
		setUpMap02(76,"76", true);
		setUpMap02(77,"77", true);
		setUpMap02(78,"78", true);
		setUpMap02(79,"79", true);
		setUpMap02(80,"80", true);
		setUpMap02(81,"81", true);
		setUpMap02(82,"82", true);
		setUpMap02(83,"83", true);
		setUpMap02(84,"84", true);
		setUpMap02(85,"85", true);
		setUpMap02(86,"86", true);
		setUpMap02(87,"87", true);
		setUpMap02(88,"88", true);
		setUpMap02(89,"89", true);
		setUpMap02(90,"90", true);
		setUpMap02(91,"91", true);
		setUpMap02(92,"92", true);
		setUpMap02(93,"93", true);
		setUpMap02(94,"94", true);
		setUpMap02(95,"95", true);
		setUpMap02(96,"96", true);
		setUpMap02(97,"97", true);
		setUpMap02(98,"98", true);
		setUpMap02(99,"99", true);
		setUpMap02(100,"100", true);
		setUpMap02(101,"101", true);
		setUpMap02(102,"102", true);
		setUpMap02(103,"103", true);
		setUpMap02(104,"104", true);
		setUpMap02(105,"105", true);
		setUpMap02(106,"106", true);
		setUpMap02(107,"107", true);
		setUpMap02(108,"108", true);
		setUpMap02(109,"109", true);
		setUpMap02(110,"110", true);
		setUpMap02(111,"111", true);
		setUpMap02(112,"112", true);
		setUpMap02(113,"113", true);
		setUpMap02(114,"114", true);
		setUpMap02(115,"115", true);
		setUpMap02(116,"116", true);
		setUpMap02(117,"117", true);
		setUpMap02(118,"118", true);
		setUpMap02(119,"119", true);
		setUpMap02(120,"120", true);
		setUpMap02(121,"121", true);
		setUpMap02(122,"122", true);
		setUpMap02(123,"123", true);
		setUpMap02(124,"124", true);
		setUpMap02(125,"125", true);
		setUpMap02(126,"126", true);
		setUpMap02(127,"127", true);
		setUpMap02(128,"128", true);
		setUpMap02(129,"129", true);
		setUpMap02(130,"130", true);
		setUpMap02(131,"131", true);
		setUpMap02(132,"132", true);
		setUpMap02(133,"133", true);
		setUpMap02(134,"134", true);
		setUpMap02(135,"135", true);
		setUpMap02(136,"136", true);
		setUpMap02(137,"137", true);
		setUpMap02(138,"138", true);
		setUpMap02(139,"139", true);
		setUpMap02(140,"140", true);
		setUpMap02(141,"141", true);
		setUpMap02(142,"142", true);
		setUpMap02(143,"143", true);
		setUpMap02(144,"144", true);
		setUpMap02(145,"145", true);
		setUpMap02(146,"146", true);
		setUpMap02(147,"147", true);
		setUpMap02(148,"148", true);
		setUpMap02(149,"149", true);
		setUpMap02(150,"150", true);
		setUpMap02(151,"151", true);
		setUpMap02(152,"152", true);
		setUpMap02(153,"153", true);
		setUpMap02(154,"154", true);
		setUpMap02(155,"155", true);
		setUpMap02(156,"156", true);
		setUpMap02(157,"157", true);
		setUpMap02(158,"158", true);
		setUpMap02(159,"159", true);
		setUpMap02(160,"160", true);
		setUpMap02(161,"161", true);
		setUpMap02(162,"162", true);
		setUpMap02(163,"163", true);
		setUpMap02(164,"164", true);
		setUpMap02(165,"165", true);
		setUpMap02(166,"166", true);
		setUpMap02(167,"167", true);
		setUpMap02(168,"168", true);
		setUpMap02(169,"169", true);
		setUpMap02(170,"170", true);
		setUpMap02(171,"171", true);
		setUpMap02(172,"172", true);
		setUpMap02(173,"173", true);
		setUpMap02(174,"174", true);
		setUpMap02(175,"175", true);
		setUpMap02(176,"176", true);
		setUpMap02(177,"177", true);
		setUpMap02(178,"178", true);
		setUpMap02(179,"179", true);
		setUpMap02(180,"180", true);
		setUpMap02(181,"181", true);
		setUpMap02(182,"182", true);
		setUpMap02(183,"183", true);
		setUpMap02(184,"184", true);
		setUpMap02(185,"185", true);
		setUpMap02(186,"186", true);
		setUpMap02(187,"187", true);
		setUpMap02(188,"188", true);
		setUpMap02(189,"189", true);
		setUpMap02(190,"190", true);
		setUpMap02(191,"191", true);
		setUpMap02(192,"192", true);
		setUpMap02(193,"193", true);
		setUpMap02(194,"194", true);
		setUpMap02(195,"195", true);
		setUpMap02(196,"196", true);
		setUpMap02(197,"197", true);
		setUpMap02(198,"198", true);
		setUpMap02(199,"199", true);
		setUpMap02(200,"200", true);
		setUpMap02(201,"201", true);
		setUpMap02(202,"202", true);
		setUpMap02(203,"203", true);
		setUpMap02(204,"204", true);
		setUpMap02(205,"205", true);
		setUpMap02(206,"206", true);
		setUpMap02(207,"207", true);
		setUpMap02(208,"208", true);
		setUpMap02(209,"209", true);
		setUpMap02(210,"210", true);
		setUpMap02(211,"211", true);
		setUpMap02(212,"212", true);
		setUpMap02(213,"213", true);
		setUpMap02(214,"214", true);
		setUpMap02(215,"215", true);
		setUpMap02(216,"216", true);
		setUpMap02(217,"217", true);
		setUpMap02(218,"218", true);
		setUpMap02(219,"219", true);
		setUpMap02(220,"220", true);
		setUpMap02(221,"221", true);
		setUpMap02(222,"222", true);
		setUpMap02(223,"223", true);
		setUpMap02(224,"224", true);
		setUpMap02(225,"225", true);
		setUpMap02(226,"226", true);
		setUpMap02(227,"227", true);
		setUpMap02(228,"228", true);
		setUpMap02(229,"229", true);
		setUpMap02(230,"230", true);
		setUpMap02(231,"231", true);
		setUpMap02(232,"232", true);
		setUpMap02(233,"233", true);
		setUpMap02(234,"234", true);
		setUpMap02(235,"235", true);
		setUpMap02(236,"236", true);
		setUpMap02(237,"237", true);
		setUpMap02(238,"238", true);
		setUpMap02(239,"239", true);
		setUpMap02(240,"240", true);
		setUpMap02(241,"241", true);
		setUpMap02(242,"242", true);
		setUpMap02(243,"243", true);
		setUpMap02(244,"244", true);
		setUpMap02(245,"245", true);
		setUpMap02(246,"246", true);
		setUpMap02(247,"247", true);
		setUpMap02(248,"248", true);
		setUpMap02(249,"249", true);
		setUpMap02(250,"250", true);
		setUpMap02(251,"251", true);
		setUpMap02(252,"252", true);
		setUpMap02(253,"253", true);
		setUpMap02(254,"254", true);
		setUpMap02(255,"255", true);
		setUpMap02(256,"256", true);
		setUpMap02(257,"257", true);
		setUpMap02(258,"258", true);
		setUpMap02(259,"259", true);
		setUpMap02(260,"260", true);
		setUpMap02(261,"261", true);
		setUpMap02(262,"262", true);
		setUpMap02(263,"263", true);
		setUpMap02(264,"264", true);
		setUpMap02(265,"265", true);
		setUpMap02(266,"266", true);
		setUpMap02(267,"267", true);
		setUpMap02(268,"268", true);
		setUpMap02(269,"269", true);
		setUpMap02(270,"270", true);
		setUpMap02(271,"271", true);
		setUpMap02(272,"272", true);
		setUpMap02(273,"273", true);
		setUpMap02(274,"274", true);
		setUpMap02(275,"275", true);
		setUpMap02(276,"276", true);
		setUpMap02(277,"277", true);
		setUpMap02(278,"278", true);
		setUpMap02(279,"279", true);
		setUpMap02(280,"280", true);
		setUpMap02(281,"281", true);
		setUpMap02(282,"282", true);
		setUpMap02(283,"283", true);
		setUpMap02(284,"284", true);
		setUpMap02(285,"285", true);
		setUpMap02(286,"286", true);
		setUpMap02(287,"287", true);
		setUpMap02(288,"288", true);
		setUpMap02(289,"289", true);
		setUpMap02(290,"290", true);
		setUpMap02(291,"291", true);
		setUpMap02(292,"292", true);
		setUpMap02(293,"293", true);
		setUpMap02(294,"294", true);
		setUpMap02(295,"295", true);
		setUpMap02(296,"296", true);
		setUpMap02(297,"297", true);
		setUpMap02(298,"298", true);
		setUpMap02(299,"299", true);
		setUpMap02(300,"300", true);
		setUpMap02(301,"301", true);
		setUpMap02(302,"302", true);
		setUpMap02(303,"303", true);
		setUpMap02(304,"304", true);
		setUpMap02(305,"305", true);
		setUpMap02(306,"306", true);
		setUpMap02(307,"307", true);
		setUpMap02(308,"308", true);
		setUpMap02(309,"309", true);
		setUpMap02(310,"310", true);
		setUpMap02(311,"311", true);
		setUpMap02(312,"312", true);
		setUpMap02(313,"313", true);
		setUpMap02(314,"314", true);
		setUpMap02(315,"315", true);
		setUpMap02(316,"316", true);
		setUpMap02(317,"317", true);
		setUpMap02(318,"318", true);
		setUpMap02(319,"319", true);
		setUpMap02(320,"320", true);
		setUpMap02(321,"321", true);
		setUpMap02(322,"322", true);
		setUpMap02(323,"323", true);
		setUpMap02(324,"324", true);
		setUpMap02(325,"325", true);
		setUpMap02(326,"326", true);
		setUpMap02(327,"327", true);
		setUpMap02(328,"328", true);
		setUpMap02(329,"329", true);
		setUpMap02(330,"330", true);
		setUpMap02(331,"331", true);
		setUpMap02(332,"332", true);
		setUpMap02(333,"333", true);
		setUpMap02(334,"334", true);
		setUpMap02(335,"335", true);
		setUpMap02(336,"336", true);
		setUpMap02(337,"337", true);
		setUpMap02(338,"338", true);
		setUpMap02(339,"339", true);
		setUpMap02(340,"340", true);
		setUpMap02(341,"341", true);
		setUpMap02(342,"342", true);
		setUpMap02(343,"343", true);
		setUpMap02(344,"344", true);
		setUpMap02(345,"345", true);
		setUpMap02(346,"346", true);
		setUpMap02(347,"347", true);
		setUpMap02(348,"348", true);
		setUpMap02(349,"349", true);
		setUpMap02(350,"350", true);
		setUpMap02(351,"351", true);
		setUpMap02(352,"352", true);
		setUpMap02(353,"353", true);
		setUpMap02(354,"354", true);
		setUpMap02(355,"355", true);
		setUpMap02(356,"356", true);
		setUpMap02(357,"357", true);
		setUpMap02(358,"358", true);
		setUpMap02(359,"359", true);
		setUpMap02(360,"360", true);
		setUpMap02(361,"361", true);
		setUpMap02(362,"362", true);
		setUpMap02(363,"363", true);
		setUpMap02(364,"364", true);
		setUpMap02(365,"365", true);
		setUpMap02(366,"366", true);
		setUpMap02(367,"367", true);
		setUpMap02(368,"368", true);
		setUpMap02(369,"369", true);
		setUpMap02(370,"370", true);
		setUpMap02(371,"371", true);
		setUpMap02(372,"372", true);
		setUpMap02(373,"373", true);
		setUpMap02(374,"374", true);
		setUpMap02(375,"375", true);
		setUpMap02(376,"376", true);
		setUpMap02(377,"377", true);
		setUpMap02(378,"378", true);
		setUpMap02(379,"379", true);
		setUpMap02(380,"380", true);
		setUpMap02(381,"381", true);
		setUpMap02(382,"382", true);
		setUpMap02(383,"383", true);
		setUpMap02(384,"384", true);
		setUpMap02(385,"385", true);
		setUpMap02(386,"386", true);
		setUpMap02(387,"387", true);
		setUpMap02(388,"388", true);
		setUpMap02(389,"389", true);
		setUpMap02(390,"390", true);
		setUpMap02(391,"391", true);
		setUpMap02(392,"392", true);
		setUpMap02(393,"393", true);
		setUpMap02(394,"394", true);
		setUpMap02(395,"395", true);
		setUpMap02(396,"396", true);
		setUpMap02(397,"397", true);
		setUpMap02(398,"398", true);
		setUpMap02(399,"399", true);
		setUpMap02(400,"400", true);
		setUpMap02(401,"401", true);
		setUpMap02(402,"402", true);
		setUpMap02(403,"403", true);
		setUpMap02(404,"404", true);
		setUpMap02(405,"405", true);
		setUpMap02(406,"406", true);
		setUpMap02(407,"407", true);
		setUpMap02(408,"408", true);
		setUpMap02(409,"409", true);
		setUpMap02(410,"410", true);
		setUpMap02(411,"411", true);
		setUpMap02(412,"412", true);
		setUpMap02(413,"413", true);
		setUpMap02(414,"414", true);
		setUpMap02(415,"415", true);
		setUpMap02(416,"416", true);
		setUpMap02(417,"417", true);
		setUpMap02(418,"418", true);
		setUpMap02(419,"419", true);
		setUpMap02(420,"420", true);
		setUpMap02(421,"421", true);
		setUpMap02(422,"422", true);
		setUpMap02(423,"423", true);
		setUpMap02(424,"424", true);
		setUpMap02(425,"425", true);
		setUpMap02(426,"426", true);
		setUpMap02(427,"427", true);
		setUpMap02(428,"428", true);
		setUpMap02(429,"429", true);
		setUpMap02(430,"430", true);
		setUpMap02(431,"431", true);
		setUpMap02(432,"432", true);
		setUpMap02(433,"433", true);
		setUpMap02(434,"434", true);

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
	public void setUpMap02(int index, String imageName, boolean collision) {
		UtilityTool uTool = new UtilityTool();
		try {
			tile[index]= new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream( "/res/title02/"+imageName+".png"));
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

	public void loadMap02(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader( new InputStreamReader(is));
			int col = 0;
			int row = 0;

			while (col< 40 && row <33){
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
