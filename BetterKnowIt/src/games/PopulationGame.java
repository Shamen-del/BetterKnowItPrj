package games;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.*;
import main.ActionManager;
import main.DataPanel;
import main.Frame;

public class PopulationGame extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	Thread gThread;
	ActionManager am;
	
	// Flags of America
	public static ImageIcon usa, mexico, brazil, venezuela, canada, colombia;
	// Flags of Asia
	public static ImageIcon kyrgyzstan, kazakhstan, azerbaijan, turkey, china, pakistan;
	public static ImageIcon armenia, israel, southKorea, saudiArabia, bangladesh, iraq, thailand;
	// Flags of Europe
	public static ImageIcon uk, ireland, austria, greece, iceland, ukraine, france;
	public static ImageIcon portugal, italy, germany, switzerland, sweden, estonia, latvia;
	// Flags of Africa
	public static ImageIcon nigeria, kenya, egypt, morocco, uganda, ethiopia, senegal;
	// Array
	public static String[] populationData = new String[40];
	public static long[] populationDataNum = new long[40];
	
	public static String[] flagNames = {"Армения","Австрия","Азербайджан","Бразилия","Канада","Кытай","Колумбия","Египет","Эстония","Франция","Германия",
            "Грекия","Исландия","Ирландия","Израил","Италия","Казахстан","Кения","Кыргызстан","Мексика","Марокко","Нигерия",
            "Португалия","Сауд Арабиясы","Түштүк Корея","Швеция","Швейцария","Туркия","Уганда","Улуу Британия","Украина","АКШ","Венесуэла",
            "Сенегал", "Ирак", "Латвия", "Бангладеш", "Тайланд", "Эфиопия", "Пакистан"};
	
	boolean[] validation = {armeniaIsValid,austriaIsValid,azerbaijanIsValid,brazilIsValid,canadaIsValid
			 ,chinaIsValid,colombiaIsValid,egyptIsValid,estoniaIsValid,franceIsValid,germanyIsValid,
            greeceIsValid,icelandIsValid,irelandIsValid,israelIsValid,italyIsValid,kazakhstanIsValid
            ,kenyaIsValid,kyrgyzstanIsValid,mexicoIsValid,moroccoIsValid,nigeriaIsValid,
            portugalIsValid,saudiArabiaIsValid,southKoreaIsValid,swedenIsValid,switzerlandIsValid
            ,turkeyIsValid,ugandaIsValid,ukIsValid,ukraineIsValid,usaIsValid,venezuelaIsValid,senegalIsValid,iraqIsValid
            ,latviaIsValid,bangladeshIsValid,thailandIsValid,ethiopiaIsValid,pakistanIsValid};
	
	ImageIcon[] icons = {armenia,austria,azerbaijan,brazil,canada
			 ,china,colombia,egypt,estonia,france,germany,
           greece,iceland,ireland,israel,italy,kazakhstan
           ,kenya,kyrgyzstan,mexico,morocco,nigeria,
           portugal,saudiArabia,southKorea,sweden,switzerland
           ,turkey,uganda,uk,ukraine,usa,venezuela,senegal,iraq
           ,latvia,bangladesh,thailand,ethiopia,pakistan};
	
	// Integers
	public static int scores = 0;
	public static volatile long populationData1 = 0;
	public static volatile long populationData2 = 0;
	
	// Booleans
	private volatile boolean running = false;
	public static volatile boolean goMenu = false;
	public static volatile boolean goNext = true;
	public static volatile boolean done = false;
	volatile public static boolean armeniaIsValid = true;
	volatile public static boolean austriaIsValid = true;
	volatile public static boolean azerbaijanIsValid = true;
	volatile public static boolean brazilIsValid = true;
	volatile public static boolean canadaIsValid = true;
	volatile public static boolean chinaIsValid = true;
	volatile public static boolean colombiaIsValid = true;
	volatile public static boolean egyptIsValid = true;
	volatile public static boolean estoniaIsValid = true;
    volatile public static boolean franceIsValid = true;
	volatile public static boolean germanyIsValid = true;
	volatile public static boolean greeceIsValid = true;
	volatile public static boolean icelandIsValid = true;
	volatile public static boolean irelandIsValid = true;
	volatile public static boolean israelIsValid = true;
	volatile public static boolean italyIsValid = true;
	volatile public static boolean kazakhstanIsValid = true;
	volatile public static boolean kenyaIsValid = true;
	volatile public static boolean kyrgyzstanIsValid = true;
	volatile public static boolean mexicoIsValid = true;
	volatile public static boolean moroccoIsValid = true;
	volatile public static boolean nigeriaIsValid = true;
	volatile public static boolean portugalIsValid = true;
	volatile public static boolean saudiArabiaIsValid = true;
	volatile public static boolean southKoreaIsValid = true;
	volatile public static boolean swedenIsValid = true;
	volatile public static boolean switzerlandIsValid = true;
	volatile public static boolean turkeyIsValid = true;
	volatile public static boolean ugandaIsValid = true;
	volatile public static boolean ukIsValid = true;
	volatile public static boolean ukraineIsValid = true;
	volatile public static boolean usaIsValid = true;
	volatile public static boolean venezuelaIsValid = true;
	volatile public static boolean senegalIsValid = true;
	volatile public static boolean iraqIsValid = true;
	volatile public static boolean latviaIsValid = true;
	volatile public static boolean bangladeshIsValid = true;
	volatile public static boolean thailandIsValid = true;
	volatile public static boolean ethiopiaIsValid = true;
	volatile public static boolean pakistanIsValid = true;
	
	// Strings
	public static volatile String direction = "Left";
	public static volatile String correctDir = "Left";
	public static String populationDataStr1 = null;
	public static String populationDataStr2 = null;
	
	// Buttons
	public static JButton answer;
	
	// Labels
	public static JLabel sign;
	public static JLabel countryLabel1;
	public static JLabel countryLabel2;
	public static JLabel population1;
	public static JLabel population2;
	public static JLabel title;
	public static JLabel menu;
	public static JLabel counter;
	public static JLabel next;
	
	public PopulationGame() {
		setTitle(Frame.name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,540);		 
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.BLUE);
		Frame.initial = true;
		
		setFlags();
		setComponents();
		setPopulationDataNum();
		setPopulationData();
		putFlag1(); putFlag2();		
		Frame.initial = false;
		goNext = false;
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void run() {
		running = true;
		while(running) {
			if(goNext && !Frame.initial) {
				next.setVisible(false);
				putFlag1(); putFlag2();					
			}
			if(goMenu) {
				 goMenu = false;
				 running = false;
				 goNext = true;
				 Frame.initial = true;
				 direction = "Left";
				 for(int i = 0; i<validation.length; i++) {
					 validation[i] = true;
				 }				
				 DataPanel.collectionOfScores = scores;
				 scores = 0;
				 dispose();
				 try {
				gThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 }
		}
	}
	
	public void setPopulationData() {
		populationData[0] = "         2,791,000";
		populationData[1] = "         8,956,000";
		populationData[2] = "         10,140,000";
		populationData[3] = "        214,300,000";
		populationData[4] = "         38,250,000";
		populationData[5] = "      1,412,000,000";
		populationData[6] = "         51,520,000";
		populationData[7] = "        109,300,000";
		populationData[8] = "         1,331,000";
		populationData[9] = "         67,750,000";
		populationData[10] = "         83,200,000";
		populationData[11] = "         10,640,000";
		populationData[12] = "           372,520";
		populationData[13] = "         50,033,000";
		populationData[14] = "         9,364,000";
		populationData[15] = "         59,110,000";
		populationData[16] = "         20,000,000";
		populationData[17] = "         53,010,000";
		populationData[18] = "         7,000,000";
		populationData[19] = "        126,700,000";
		populationData[20] = "         37,080,000";
		populationData[21] = "        213,400,000";
		populationData[22] = "         10,330,000";
		populationData[23] = "         35,950,000";
		populationData[24] = "         51,740,000";
		populationData[25] = "         10,420,000";
		populationData[26] = "         8,703,000";
		populationData[27] = "         84,780,000";
		populationData[28] = "         45,850,000";
		populationData[29] = "         67,330,000";
		populationData[30] = "         43,790,000";
		populationData[31] = "        331,900,000";
		populationData[32] = "         28,200,000";
		populationData[33] = "         16,880,000";
		populationData[34] = "         43,530,000";
		populationData[35] = "         1,884,000";
		populationData[36] = "        169,400,000";
		populationData[37] = "         71,600,000";
		populationData[38] = "        120,300,000";
		populationData[39] = "        231,400,000";
	}
	
	public void setPopulationDataNum() {
		populationDataNum[0] = 2791000;
		populationDataNum[1] = 8956000;
		populationDataNum[2] = 10140000;
		populationDataNum[3] = 214300000;
		populationDataNum[4] = 38250000;
		populationDataNum[5] = 1412000000;
		populationDataNum[6] = 51520000;
		populationDataNum[7] = 109300000;
		populationDataNum[8] = 1331000;
		populationDataNum[9] = 67750000;
		populationDataNum[10] = 83200000;
		populationDataNum[11] = 10640000;
		populationDataNum[12] = 372520;
		populationDataNum[13] = 50033000;
		populationDataNum[14] = 9364000;
		populationDataNum[15] = 59110000;
		populationDataNum[16] = 20000000;
		populationDataNum[17] = 53010000;
		populationDataNum[18] = 7000000;
		populationDataNum[19] = 126700000;
		populationDataNum[20] = 37080000;
		populationDataNum[21] = 213400000;
		populationDataNum[22] = 10330000;
		populationDataNum[23] = 35950000;
		populationDataNum[24] = 51740000;
		populationDataNum[25] = 10420000;
		populationDataNum[26] = 8703000;
		populationDataNum[27] = 84780000;
		populationDataNum[28] = 45850000;
		populationDataNum[29] = 67330000;
		populationDataNum[30] = 43790000;
		populationDataNum[31] = 331900000;
		populationDataNum[32] = 28200000;
		populationDataNum[33] = 16880000;
		populationDataNum[34] = 43530000;
		populationDataNum[35] = 1884000;
		populationDataNum[36] = 169400000;
		populationDataNum[37] = 71600000;
		populationDataNum[38] = 120300000;
		populationDataNum[39] = 231400000;
	}
	
	public void setFlags() {
		// Europe	
			icons[1] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Austria.png");
			icons[8] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Estonia.png");
			icons[9] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\France.png");
			icons[10] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Germany.png");
			icons[11] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Greece.png");
			icons[12] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Iceland.png");
			icons[13] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Ireland.png");
			icons[15] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Italy.png");
			icons[35] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Latvia.png");
			icons[22] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Portugal.png");
			icons[25] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Sweden.png");
			icons[26] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Switzerland.png");
			icons[29] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\UK.png");
			icons[30] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Ukraine.png");
			// Asia
			icons[18] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Kyrgyzstan.png");		
			icons[5] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\China.png");
			icons[2] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Azerbaijan.png");
			icons[0] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Armenia.png");
			icons[36] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Bangladesh.png");	
			icons[34] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Iraq.png");
			icons[14] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Israel.png");
			icons[16] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Kazakhstan.png");
			icons[39] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Pakistan.png");
			icons[23] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Saudi-Arabia.png");
			icons[24] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\South-Korea.png");
			icons[37] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Thailand.png");
			icons[27] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Turkey.png");
			// Africa
			icons[7] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Egypt.png");
			icons[38] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Ethiopia.png");
			icons[17] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Kenya.png");
			icons[20] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Morocco.png");
			icons[21] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Nigeria.png");
			icons[33] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Senegal.png");
			icons[28] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Uganda.png");
			// America
			icons[4] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Canada.png");
			icons[6] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Colombia.png");
			icons[3] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Brazil.png");
			icons[19] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Mexico.png");
			icons[31] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\USA.png");
			icons[32] = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Venezuela.png");
	 }
	
	public void setComponents() {		
		 gThread = new Thread(this);	
		 am = new ActionManager();		 
		 countryLabel1 = new JLabel();
		 countryLabel1.setBounds(getWidth()/2 - 290,50,250,250);	
		 countryLabel1.setIcon(icons[0]);
		 countryLabel2 = new JLabel();
		 countryLabel2.setBounds(getWidth()/2 + 40,50,250,250);	
		 menu = new JLabel("Меню");
		 menu.setFont(new Font("Serif", Font.BOLD, 25));
		 menu.setForeground(Color.green);
		 menu.addMouseListener(am);
		 menu.setBounds(10,5,68,25);		
		 sign = new JLabel(" >");
		 sign.setBounds(getWidth()/2 - 25,150,50,50);
		 sign.setFont(new Font("Serif", Font.PLAIN, 50));
		 sign.setForeground(Color.WHITE);
		 sign.addMouseListener(am);
		 title = new JLabel("    Кайсы өлкөнүн элинин саны көбүрөөк?");
		 title.setBounds(getWidth()/2 - 290,320,580,65);
		 title.setFont(new Font("Serif", Font.PLAIN, 30));
		 title.setForeground(Color.white);
		 population1 = new JLabel();
		 population1.setBounds(getWidth()/2 - 265, 5, 200, 40);
		 population1.setFont(new Font("Serif", Font.PLAIN, 23));
		 population1.setForeground(Color.WHITE);
		 population2 = new JLabel();
		 population2.setBounds(getWidth()/2 + 65, 5, 200, 40);
		 population2.setFont(new Font("Serif", Font.PLAIN, 23));
		 population2.setForeground(Color.WHITE);
		 population1.setVisible(false); population2.setVisible(false);		 
		 counter = new JLabel(scores + "/20");
		 counter.setFont(new Font("Serif", Font.BOLD, 25));
		 counter.setForeground(Color.green);
		 counter.setBounds(625,5,60,25);	
		 answer = new JButton("Жооп берүү");
		 answer.setBounds(getWidth()/2 - 150,420,300,65);
		 answer.setFont(new Font("Serif", Font.PLAIN, 40));
		 answer.setForeground(Color.blue);
		 answer.setBackground(Color.GREEN);		 
		 answer.setFocusable(false);
		 answer.addActionListener(am);
		 next = new JLabel("Эмкиси");	
		 next.setFont(new Font("Serif", Font.BOLD, 25));
		 next.setForeground(Color.green);
		 next.addMouseListener(am);
		 next.setBounds(580,460,90,25);
		 next.setVisible(false);		
		 add(countryLabel1); add(countryLabel2);
		 add(menu); add(counter); add(next);
		 add(sign); add(answer); add(title);
		 add(population1); add(population2);
		 gThread.start();
	 }
	
	public void putFlag1() {
		Random random = new Random();
		 
		int getNum = random.nextInt(40);
		
		if(validation[getNum]) {
			countryLabel1.setIcon(icons[getNum]);
			populationData1 = populationDataNum[getNum];
			populationDataStr1 = populationData[getNum];
			validation[getNum] = false;
			goNext = false;
			Frame.currentIcon1 = flagNames[getNum];
		} else {
			putFlag1();
		}
	}
	
	public void putFlag2() {
		Random random = new Random();
		 
		int getNum = random.nextInt(40);
		
		if(validation[getNum]) {
			countryLabel2.setIcon(icons[getNum]);
			populationData2 = populationDataNum[getNum];
			populationDataStr2 = populationData[getNum];
			validation[getNum] = false;
			goNext = false;
			Frame.currentIcon2 = flagNames[getNum];
			if(populationData1>populationData2) {
				correctDir = "Left";
			} else {
				correctDir = "Right";
			}
		} else {
			putFlag2();
		}
	}

}
