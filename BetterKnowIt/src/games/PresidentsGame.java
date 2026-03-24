package games;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.*;
import main.ActionManager;
import main.DataPanel;
import main.Frame;

public class PresidentsGame extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	Thread gThread;
	ActionManager am;
	public PutCountryNames pcn;

	// Presidents of America
	public static ImageIcon canada, colombia, brazil, mexico, usa, venezuela;
	// Presidents of Asia
	public static ImageIcon kyrgyzstan, armenia, azerbaijan, china, israel, kazakhstan, saudiArabia;
	public static ImageIcon southKorea, turkey, iraq, bangladesh, thailand, pakistan; 
	// Presidents of Europe 
	public static ImageIcon austria, estonia, france, germany, greece, iceland, ireland, italy;	
	public static ImageIcon portugal, sweden, switzerland, uk, ukraine, latvia;
	// Presidents of Africa		
	public static ImageIcon egypt, kenya, morocco, nigeria, uganda, senegal, ethiopia;
	// Array of presidents
	public static String[] countriesNames = {"Армения","Австрия","Азербайджан","Бразилия","Канада","Кытай","Колумбия","Египет","Эстония","Франция","Германия",
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
	public static int presidentsCollected = 0;
	
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
	
	//  Buttons
	public static JButton lt, rt, lb, rb;
	
	// Labels
	public static JLabel presidentLabel;
	public static JLabel menu;
	public static JLabel counter;
	public static JLabel next;
	
	// Panels
	JPanel gPanel;
	
	public PresidentsGame() {
		PutCountryNames.index = 2;
		setTitle(Frame.name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,540);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.BLUE);
		
		setPictures();
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
				 putImage();
				 Frame.initial = false;
		    }
		    counter.setText(presidentsCollected + "/40");	
			if(goNext) {
			    putImage();	
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
				DataPanel.collectionOfPresidents = presidentsCollected;
				presidentsCollected = 0;
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
		       if(!(countriesNames[getNum].equals(rt.getText())) && !(countriesNames[getNum].equals(lb.getText())) && !(countriesNames[getNum].equals(rb.getText()))) {
		    	   lt.setText(countriesNames[getNum]);
		       } else {
		    	   putLtText();
		       }
	        }
	 }
	 
	 public static void putRtText() {
		 if(rt.getText().equals("")) {
		       Random random = new Random();
		       int getNum = random.nextInt(40);
		       if(!(countriesNames[getNum].equals(lt.getText())) && !(countriesNames[getNum].equals(lb.getText())) && !(countriesNames[getNum].equals(rb.getText()))) {
		    	   rt.setText(countriesNames[getNum]);
		       } else {
		    	   putRtText();
		       }
	        }
	 }
	 
	 public static void putLbText() {
		 if(lb.getText().equals("")) {
		       Random random = new Random();
		       int getNum = random.nextInt(40);
		       if(!(countriesNames[getNum].equals(lt.getText())) && !(countriesNames[getNum].equals(rt.getText())) && !(countriesNames[getNum].equals(rb.getText()))) {
		    	   lb.setText(countriesNames[getNum]);
		       } else {
		    	   putLbText();
		       }
	        }
	 }
	 
	 public static void putRbText() {
		 if(rb.getText().equals("")) {
		       Random random = new Random();
		       int getNum = random.nextInt(40);
		       if(!(countriesNames[getNum].equals(lt.getText())) && !(countriesNames[getNum].equals(lb.getText())) && !(countriesNames[getNum].equals(rt.getText()))) {
		    	   rb.setText(countriesNames[getNum]);
		       } else {
		    	   putRbText();
		       }
	        }
	 }
	
	public void setPictures() {
		// Europe	
		austria = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Austria.jpg");
		estonia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Estonia.jpg");
		france = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\France.jpg");
		germany = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Germany.jpg");
		greece = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Greece.jpg");
		iceland = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Iceland.jpg");
		ireland = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Ireland.jpg");
		italy = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Italy.jpg");
		latvia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Latvia.jpg");
		portugal = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Portugal.jpg");
		sweden = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Sweden.jpg");
		switzerland = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Switzerland.jpg");
		uk = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\UK.jpg");
		ukraine = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Ukraine.jpg");
		// Asia
		kyrgyzstan = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Kyrgyzstan.jpg");		
		china = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\China.jpg");
		azerbaijan = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Azerbaijan.jpg");
		armenia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Armenia.jpg");
		bangladesh = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Bangladesh.jpg");	
		iraq = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Iraq.jpg");
		israel = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Israel.jpg");
		kazakhstan = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Kazakhstan.jpg");
		pakistan = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Pakistan.jpg");
		saudiArabia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Saudi-Arabia.jpg");
		southKorea = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\South-Korea.jpg");
		thailand = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Thailand.jpg");
		turkey = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Turkey.jpg");
		// Africa
		egypt = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Egypt.jpg");
		ethiopia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Ethiopia.jpg");
		kenya = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Kenya.jpg");
		morocco = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Morocco.jpg");
		nigeria = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Nigeria.jpg");
		senegal = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Senegal.jpg");
		uganda = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Uganda.jpg");
		// America
		canada = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Canada.jpg");
		colombia = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Colombia.jpg");
		brazil = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Brazil.jpg");
		mexico = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Mexico.jpg");
		usa = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\USA.jpg");
		venezuela = new ImageIcon("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\res\\CountryPresidents\\Venezuela.jpg");
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
	
	public void putImage() {
		Random random = new Random();
		 
		 int getNum = random.nextInt(40);
		 switch(getNum) {
		 case 0:if(validation[0]) {
			    presidentLabel.setIcon(armenia); 
			    Frame.currentIcon = "Армения";
			    validation[0] = false;
			    goNext = false;				    
		        } else {
		        putImage();	
		        }
		 break;
		 case 1:if(validation[1]) {
			    presidentLabel.setIcon(austria); 
			    Frame.currentIcon = "Австрия";
			    validation[1] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 2:if(validation[2]) {
			    presidentLabel.setIcon(azerbaijan);  
			    Frame.currentIcon = "Азербайджан";
			    validation[2] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 3:if(validation[3]) {
			    presidentLabel.setIcon(brazil); 
			    Frame.currentIcon = "Бразилия";
			    validation[3] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 4:if(validation[4]) {
			    presidentLabel.setIcon(canada);  
			    Frame.currentIcon = "Канада";
			    validation[4] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 5:if(validation[5]) {
			    presidentLabel.setIcon(china);  
			    Frame.currentIcon = "Кытай";
			    validation[5] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 6:if(validation[6]) {
			    presidentLabel.setIcon(colombia);  
			    Frame.currentIcon = "Колумбия";
			    validation[6] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 7:if(validation[7]) {
			    presidentLabel.setIcon(egypt);
			    Frame.currentIcon = "Египет";
			    validation[7] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 8:if(validation[8]) {
			    presidentLabel.setIcon(estonia);  
			    Frame.currentIcon = "Эстония";
			    validation[8] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 9:if(validation[9]) {
			    presidentLabel.setIcon(france); 
			    Frame.currentIcon = "Франция";
			    validation[9] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 10:if(validation[10]) {
			    presidentLabel.setIcon(germany);  
			    Frame.currentIcon = "Германия";
			    validation[10] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 11:if(validation[11]) {
			    presidentLabel.setIcon(greece);  
			    Frame.currentIcon = "Грекия";
			    validation[11] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 12:if(validation[12]) {
			    presidentLabel.setIcon(iceland); 
			    Frame.currentIcon = "Исландия";
			    validation[12] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 13:if(validation[13]) {
			    presidentLabel.setIcon(ireland);  
			    Frame.currentIcon = "Ирландия";
			    validation[13] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 14:if(validation[14]) {
			    presidentLabel.setIcon(israel); 
			    Frame.currentIcon = "Израил";
			    validation[14] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 15:if(validation[15]) {
			    presidentLabel.setIcon(italy);  
			    Frame.currentIcon = "Италия";
			    validation[15] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 16:if(validation[16]) {
			    presidentLabel.setIcon(kazakhstan);  
			    Frame.currentIcon = "Казахстан";
			    validation[16] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 17:if(validation[17]) {
			    presidentLabel.setIcon(kenya); 
			    Frame.currentIcon = "Кения";
			    validation[17] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 18:if(validation[18]) {
			    presidentLabel.setIcon(kyrgyzstan);  
			    Frame.currentIcon = "Кыргызстан";
			    validation[18] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 19:if(validation[19]) {
			    presidentLabel.setIcon(mexico);  
			    Frame.currentIcon = "Мексика";
			    validation[19] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 20:if(validation[20]) {
			    presidentLabel.setIcon(morocco);  
			    Frame.currentIcon = "Марокко";
			    validation[20] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 21:if(validation[21]) {
			    presidentLabel.setIcon(nigeria);  
			    Frame.currentIcon = "Нигерия";
			    validation[21] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 22:if(validation[22]) {
			    presidentLabel.setIcon(portugal);  
			    Frame.currentIcon = "Португалия";
			    validation[22] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 23:if(validation[23]) {
			    presidentLabel.setIcon(saudiArabia);  
			    Frame.currentIcon = "Сауд Арабиясы";
			    validation[23] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 24:if(validation[24]) {
			    presidentLabel.setIcon(southKorea);  
			    Frame.currentIcon = "Түштүк Корея";
			    validation[24] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 25:if(validation[25]) {
			    presidentLabel.setIcon(sweden);  
			    Frame.currentIcon = "Швеция";
			    validation[25] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 26:if(validation[26]) {
			    presidentLabel.setIcon(switzerland); 
			    Frame.currentIcon = "Швейцария";
			    validation[26] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 27:if(validation[27]) {
			    presidentLabel.setIcon(turkey);  
			    Frame.currentIcon = "Туркия";
			    validation[27] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 28:if(validation[28]) {
			    presidentLabel.setIcon(uganda); 
			    Frame.currentIcon = "Уганда";
			    validation[28] = false;
			    goNext = false;
		        } else {
		        putImage();	
		        }
		 break;
		 case 29:if(validation[29]) {
			    presidentLabel.setIcon(uk);  
			    Frame.currentIcon = "Улуу Британия";
			    validation[29] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 30:if(validation[30]) {
			    presidentLabel.setIcon(ukraine); 
			    Frame.currentIcon = "Украина";
			    validation[30] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 31:if(validation[31]) {
			    presidentLabel.setIcon(usa);  
			    Frame.currentIcon = "АКШ";
			    validation[31] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 32:if(validation[32]) {
			    presidentLabel.setIcon(venezuela);  
			    Frame.currentIcon = "Венесуэла";
			    validation[32] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 33:if(validation[33]) {
			    presidentLabel.setIcon(senegal);  
			    Frame.currentIcon = "Сенегал";
			    validation[33] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 34:if(validation[34]) {
			    presidentLabel.setIcon(iraq);  
			    Frame.currentIcon = "Ирак";
			    validation[34] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 35:if(validation[35]) {
			    presidentLabel.setIcon(latvia);  
			    Frame.currentIcon = "Латвия";
			    validation[35] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 36:if(validation[36]) {
			    presidentLabel.setIcon(bangladesh);  
			    Frame.currentIcon = "Бангладеш";
			    validation[36] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 37:if(validation[37]) {
			    presidentLabel.setIcon(thailand);  
			    Frame.currentIcon = "Тайланд";
			    validation[37] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 38:if(validation[38]) {
			    presidentLabel.setIcon(ethiopia);  
			    Frame.currentIcon = "Эфиопия";
			    validation[38] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 case 39:if(validation[39]) {
			    presidentLabel.setIcon(pakistan);  
			    Frame.currentIcon = "Пакистан";
			    validation[39] = false;
			    goNext = false;
		        } else {
		        putImage();
		        }
		 break;
		 }
	}
	
	public void setComponents() {		
		gThread = new Thread(this);			
		am = new ActionManager();		
		presidentLabel = new JLabel();
		presidentLabel.setBounds(getWidth()/2 - 125, 30,250,250);				
		gPanel = new JPanel();
		gPanel.setBackground(Color.green);
		gPanel.setLayout(null);
		gPanel.setBounds(0,300,700,200);		
		menu = new JLabel("Меню");
		menu.setFont(new Font("Serif", Font.BOLD, 25));
		menu.setForeground(Color.green);
		menu.addMouseListener(am);
		menu.setBounds(10,5,68,25);		
		counter = new JLabel(presidentsCollected + "/40");
		counter.setFont(new Font("Serif", Font.BOLD, 25));
		counter.setForeground(Color.green);
		counter.setBounds(625,5,60,25);		
		next = new JLabel("Эмкиси");	
		next.setFont(new Font("Serif", Font.BOLD, 25));
		next.setForeground(Color.green);
		next.addMouseListener(am);
		next.setBounds(575,250,90,25);
		next.setVisible(false);
		add(presidentLabel); add(gPanel);
		add(menu); add(counter); add(next);
		pcn = new PutCountryNames();
		gThread.start();
	}
}
