package games;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import main.ActionManager;
import main.DataPanel;
import main.Frame;

public class CountryGame extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	 Thread gThread;
	 ActionManager am;	
	 public PutCountryNames pcn;
	 
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
	 // Array of flags
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
	 
	 // Integers
	 public static int countriesCollected = 0;
	 
	 // Booleans
	 volatile private static boolean running = false;	 
	 volatile public static boolean goMenu = false;
	 volatile public static boolean goNext = true;	 
	 volatile public static boolean done = false;
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
	 
	 // Buttons
	 public static JButton lt, rt, lb, rb;	
	 
	 // Labels
	 public static JLabel countryLabel;
	 public static JLabel menu;
	 public static JLabel counter;
	 public static JLabel next;
	 
	 // Panels
	 private JPanel gPanel;
	 
	 public CountryGame() {		
		 PutCountryNames.index = 1;
		 setTitle(Frame.name);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(700,540);		 
		 setResizable(false);
		 setLayout(null);
		 getContentPane().setBackground(Color.BLUE);	 
		 
		 setFlags();
		 setComponents();
		 setButtons();			 
		 
		 
		 pcn.putCountryNames();
		 
		 setLocationRelativeTo(null);
		 setVisible(true);		 
	 }
	 
	 @Override
	 public void run() {
		 running = true;
		 while(running) {
			 if(goNext && Frame.initial) {
			      putFlag();
			      Frame.initial = false;
			 }
			 counter.setText(countriesCollected + "/40");	
			 if(goNext) {
				 putFlag();	
				 lt.setText(""); rt.setText("");
				 lb.setText(""); rb.setText("");
				 pcn.putCountryNames();
				 lt.setBackground(Color.magenta); rt.setBackground(Color.darkGray);
				 lb.setBackground(Color.yellow); rb.setBackground(Color.cyan);
			     next.setVisible(false);
			 }
			 if(goMenu) {
				 goMenu = false;
				 running = false;
				 goNext = true;
				 Frame.initial = true;
				 for(int i = 0; i<validation.length; i++) {
					 validation[i] = true;
				 }				 
				 DataPanel.collectionOfCountries = countriesCollected;
				 countriesCollected = 0;
				 dispose();
				 try {
				gThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 }			 
		}
	}
	 
	 public static void putLtText() {
		 if(lt.getText().equals("")) {
		       Random random = new Random();
		       int getNum = random.nextInt(40);
		       if(!(flagNames[getNum].equals(rt.getText())) && !(flagNames[getNum].equals(lb.getText())) && !(flagNames[getNum].equals(rb.getText()))) {
		    	   lt.setText(flagNames[getNum]);
		       } else {
		    	   putLtText();
		       }
	        }
	 }
	 
	 public static void putRtText() {
		 if(rt.getText().equals("")) {
		       Random random = new Random();
		       int getNum = random.nextInt(40);
		       if(!(flagNames[getNum].equals(lt.getText())) && !(flagNames[getNum].equals(lb.getText())) && !(flagNames[getNum].equals(rb.getText()))) {
		    	   rt.setText(flagNames[getNum]);
		       } else {
		    	   putRtText();
		       }
	        }
	 }
	 
	 public static void putLbText() {
		 if(lb.getText().equals("")) {
		       Random random = new Random();
		       int getNum = random.nextInt(40);
		       if(!(flagNames[getNum].equals(lt.getText())) && !(flagNames[getNum].equals(rt.getText())) && !(flagNames[getNum].equals(rb.getText()))) {
		    	   lb.setText(flagNames[getNum]);
		       } else {
		    	   putLbText();
		       }
	        }
	 }
	 
	 public static void putRbText() {
		 if(rb.getText().equals("")) {
		       Random random = new Random();
		       int getNum = random.nextInt(40);
		       if(!(flagNames[getNum].equals(lt.getText())) && !(flagNames[getNum].equals(lb.getText())) && !(flagNames[getNum].equals(rt.getText()))) {
		    	   rb.setText(flagNames[getNum]);
		       } else {
		    	   putRbText();
		       }
	        }
	 }
	 
	 public void setFlags() {
		// Europe	
			austria = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Austria.png");
			estonia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Estonia.png");
			france = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\France.png");
			germany = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Germany.png");
			greece = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Greece.png");
			iceland = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Iceland.png");
			ireland = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Ireland.png");
			italy = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Italy.png");
			latvia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Latvia.png");
			portugal = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Portugal.png");
			sweden = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Sweden.png");
			switzerland = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Switzerland.png");
			uk = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\UK.png");
			ukraine = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Ukraine.png");
			// Asia
			kyrgyzstan = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Kyrgyzstan.png");		
			china = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\China.png");
			azerbaijan = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Azerbaijan.png");
			armenia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Armenia.png");
			bangladesh = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Bangladesh.png");	
			iraq = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Iraq.png");
			israel = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Israel.png");
			kazakhstan = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Kazakhstan.png");
			pakistan = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Pakistan.png");
			saudiArabia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Saudi-Arabia.png");
			southKorea = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\South-Korea.png");
			thailand = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Thailand.png");
			turkey = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Turkey.png");
			// Africa
			egypt = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Egypt.png");
			ethiopia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Ethiopia.png");
			kenya = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Kenya.png");
			morocco = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Morocco.png");
			nigeria = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Nigeria.png");
			senegal = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Senegal.png");
			uganda = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Uganda.png");
			// America
			canada = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Canada.png");
			colombia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Colombia.png");
			brazil = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Brazil.png");
			mexico = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Mexico.png");
			usa = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\USA.png");
			venezuela = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\Venezuela.png");
	 }	 
	 
	 public void setButtons() {		 
		 lt = new JButton();	
		 lt.setBackground(Color.magenta);
		 lt.setForeground(Color.white);
		 lt.setFont(new Font("Serif", Font.BOLD, 15));
		 lt.addActionListener(am);
		 lt.setFocusable(false);
		 lt.setBounds(0,0,350,100);
		 
		 rt = new JButton();
		 rt.setBackground(Color.darkGray);
		 rt.setForeground(Color.white);
		 rt.setFont(new Font("Serif", Font.BOLD, 15));
		 rt.addActionListener(am);
		 rt.setFocusable(false);
		 rt.setBounds(350,0,350,100);
		 
		 lb = new JButton();
		 lb.setBackground(Color.yellow);
		 lb.setForeground(Color.white);
		 lb.setFont(new Font("Serif", Font.BOLD, 15));
		 lb.addActionListener(am);
		 lb.setFocusable(false);
		 lb.setBounds(0,100,350,100);
		 
		 rb = new JButton();
		 rb.setBackground(Color.cyan);
		 rb.setForeground(Color.white);
		 rb.setFont(new Font("Serif", Font.BOLD, 15));
		 rb.addActionListener(am);
		 rb.setFocusable(false);
		 rb.setBounds(350,100,350,100);
		 
		 gPanel.add(lt); gPanel.add(rt);
		 gPanel.add(lb); gPanel.add(rb);		  
	 }
	 
	 public void putFlag() {
			 Random random = new Random();
			 
			 int getNum = random.nextInt(40);
			 switch(getNum) {
			 case 0:if(validation[0]) {
				    countryLabel.setIcon(armenia); 
				    Frame.currentIcon = "Армения";
				    validation[0] = false;
				    goNext = false;				    
			        } else {
			        putFlag();	
			        }
			 break;
			 case 1:if(validation[1]) {
				    countryLabel.setIcon(austria); 
				    Frame.currentIcon = "Австрия";
				    validation[1] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 2:if(validation[2]) {
				    countryLabel.setIcon(azerbaijan);  
				    Frame.currentIcon = "Азербайджан";
				    validation[2] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 3:if(validation[3]) {
				    countryLabel.setIcon(brazil); 
				    Frame.currentIcon = "Бразилия";
				    validation[3] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 4:if(validation[4]) {
				    countryLabel.setIcon(canada);  
				    Frame.currentIcon = "Канада";
				    validation[4] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 5:if(validation[5]) {
				    countryLabel.setIcon(china);  
				    Frame.currentIcon = "Кытай";
				    validation[5] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 6:if(validation[6]) {
				    countryLabel.setIcon(colombia);  
				    Frame.currentIcon = "Колумбия";
				    validation[6] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 7:if(validation[7]) {
				    countryLabel.setIcon(egypt);
				    Frame.currentIcon = "Египет";
				    validation[7] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 8:if(validation[8]) {
				    countryLabel.setIcon(estonia);  
				    Frame.currentIcon = "Эстония";
				    validation[8] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 9:if(validation[9]) {
				    countryLabel.setIcon(france); 
				    Frame.currentIcon = "Франция";
				    validation[9] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 10:if(validation[10]) {
				    countryLabel.setIcon(germany);  
				    Frame.currentIcon = "Германия";
				    validation[10] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 11:if(validation[11]) {
				    countryLabel.setIcon(greece);  
				    Frame.currentIcon = "Грекия";
				    validation[11] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 12:if(validation[12]) {
				    countryLabel.setIcon(iceland); 
				    Frame.currentIcon = "Исландия";
				    validation[12] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 13:if(validation[13]) {
				    countryLabel.setIcon(ireland);  
				    Frame.currentIcon = "Ирландия";
				    validation[13] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 14:if(validation[14]) {
				    countryLabel.setIcon(israel); 
				    Frame.currentIcon = "Израил";
				    validation[14] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 15:if(validation[15]) {
				    countryLabel.setIcon(italy);  
				    Frame.currentIcon = "Италия";
				    validation[15] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 16:if(validation[16]) {
				    countryLabel.setIcon(kazakhstan);  
				    Frame.currentIcon = "Казахстан";
				    validation[16] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 17:if(validation[17]) {
				    countryLabel.setIcon(kenya); 
				    Frame.currentIcon = "Кения";
				    validation[17] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 18:if(validation[18]) {
				    countryLabel.setIcon(kyrgyzstan);  
				    Frame.currentIcon = "Кыргызстан";
				    validation[18] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 19:if(validation[19]) {
				    countryLabel.setIcon(mexico);  
				    Frame.currentIcon = "Мексика";
				    validation[19] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 20:if(validation[20]) {
				    countryLabel.setIcon(morocco);  
				    Frame.currentIcon = "Марокко";
				    validation[20] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 21:if(validation[21]) {
				    countryLabel.setIcon(nigeria);  
				    Frame.currentIcon = "Нигерия";
				    validation[21] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 22:if(validation[22]) {
				    countryLabel.setIcon(portugal);  
				    Frame.currentIcon = "Португалия";
				    validation[22] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 23:if(validation[23]) {
				    countryLabel.setIcon(saudiArabia);  
				    Frame.currentIcon = "Сауд Арабиясы";
				    validation[23] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 24:if(validation[24]) {
				    countryLabel.setIcon(southKorea);  
				    Frame.currentIcon = "Түштүк Корея";
				    validation[24] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 25:if(validation[25]) {
				    countryLabel.setIcon(sweden);  
				    Frame.currentIcon = "Швеция";
				    validation[25] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 26:if(validation[26]) {
				    countryLabel.setIcon(switzerland); 
				    Frame.currentIcon = "Швейцария";
				    validation[26] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 27:if(validation[27]) {
				    countryLabel.setIcon(turkey);  
				    Frame.currentIcon = "Туркия";
				    validation[27] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 28:if(validation[28]) {
				    countryLabel.setIcon(uganda); 
				    Frame.currentIcon = "Уганда";
				    validation[28] = false;
				    goNext = false;
			        } else {
			        putFlag();	
			        }
			 break;
			 case 29:if(validation[29]) {
				    countryLabel.setIcon(uk);  
				    Frame.currentIcon = "Улуу Британия";
				    validation[29] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 30:if(validation[30]) {
				    countryLabel.setIcon(ukraine); 
				    Frame.currentIcon = "Украина";
				    validation[30] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 31:if(validation[31]) {
				    countryLabel.setIcon(usa);  
				    Frame.currentIcon = "АКШ";
				    validation[31] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 32:if(validation[32]) {
				    countryLabel.setIcon(venezuela);  
				    Frame.currentIcon = "Венесуэла";
				    validation[32] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 33:if(validation[33]) {
				    countryLabel.setIcon(senegal);  
				    Frame.currentIcon = "Сенегал";
				    validation[33] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 34:if(validation[34]) {
				    countryLabel.setIcon(iraq);  
				    Frame.currentIcon = "Ирак";
				    validation[34] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 35:if(validation[35]) {
				    countryLabel.setIcon(latvia);  
				    Frame.currentIcon = "Латвия";
				    validation[35] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 36:if(validation[36]) {
				    countryLabel.setIcon(bangladesh);  
				    Frame.currentIcon = "Бангладеш";
				    validation[36] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 37:if(validation[37]) {
				    countryLabel.setIcon(thailand);  
				    Frame.currentIcon = "Тайланд";
				    validation[37] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 38:if(validation[38]) {
				    countryLabel.setIcon(ethiopia);  
				    Frame.currentIcon = "Эфиопия";
				    validation[38] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 case 39:if(validation[39]) {
				    countryLabel.setIcon(pakistan);  
				    Frame.currentIcon = "Пакистан";
				    validation[39] = false;
				    goNext = false;
			        } else {
			        putFlag();
			        }
			 break;
			 }
	 }	 
	 
	 public void setComponents() {		
		 gThread = new Thread(this);	
		 am = new ActionManager();		 
		 countryLabel = new JLabel();
		 countryLabel.setBounds(getWidth()/2 - 125, 30,250,250);		 
		 gPanel = new JPanel();
		 gPanel.setBackground(Color.green);
		 gPanel.setLayout(null);
		 gPanel.setBounds(0,300,700,200);		 
		 menu = new JLabel("Меню");
		 menu.setFont(new Font("Serif", Font.BOLD, 25));
		 menu.setForeground(Color.green);
		 menu.addMouseListener(am);
		 menu.setBounds(10,5,68,25);		 
		 counter = new JLabel(countriesCollected + "/40");
		 counter.setFont(new Font("Serif", Font.BOLD, 25));
		 counter.setForeground(Color.green);
		 counter.setBounds(625,5,60,25);		 
		 next = new JLabel("Эмкиси");	
		 next.setFont(new Font("Serif", Font.BOLD, 25));
		 next.setForeground(Color.green);
		 next.addMouseListener(am);
		 next.setBounds(575,250,90,25);
		 next.setVisible(false);		
		 add(countryLabel); add(gPanel);
		 add(menu); add(counter); add(next);
		 pcn = new PutCountryNames();
		 gThread.start();
	 }
}
