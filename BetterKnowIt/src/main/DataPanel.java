package main;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;

public class DataPanel extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private final Font font = new Font("Serif", Font.PLAIN, 25);
	ActionManager am;
	
	private boolean running = false;
	public volatile static boolean toMenu = false;
	public static int recordOfCountries;
	public static int recordOfPresidents;
	public static int recordOfScores;
	public static int collectionOfCountries = 0;
	public static int collectionOfPresidents = 0;
	public static int collectionOfScores = 0;
	
	public static JButton menu, eraseData;
	private Thread dataPanelT;
	
	private JLabel data, record1, record2, record3;
	public JLabel info1, info2, info3;
	
	public DataPanel() {
		am = new ActionManager();
		setTitle(Frame.name);
		setSize(300,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.blue);
		setLayout(null);
		setButtons();
		setLabels();	
		compareAndSet();
		dataPanelT = new Thread(this);
		dataPanelT.start();
		running = true;
	}
	
	public void setButtons() {
		menu = new JButton("Меню");
		add(menu);
		eraseData = new JButton("Өчүрүү");
		add(eraseData);
		
		menu.setFocusable(false);
		menu.addActionListener(am);
		menu.setBounds(20,205,100,50);
		menu.setFont(new Font("Serif", Font.PLAIN, 20));
		menu.setBackground(Color.GREEN);
		menu.setForeground(Color.BLUE);
		add(menu);
		
		eraseData.setFocusable(false);
		eraseData.addActionListener(am);
		eraseData.setBounds(165,205,100,50);
		eraseData.setFont(new Font("Serif", Font.PLAIN, 20));
		eraseData.setBackground(Color.GREEN);
		eraseData.setForeground(Color.BLUE);
		add(eraseData);
	}
	
	public void setLabels() {
		data = new JLabel("Инфо");
		record1 = new JLabel();
		record2 = new JLabel();
		record3 = new JLabel();
		
		data.setFont(font);
		data.setForeground(Color.GREEN);
		data.setBounds(110,5,223,30);
	    add(data);
		
		record1.setFont(font);
		record1.setForeground(Color.GREEN);
		record1.setBounds(20,55,199,30);
		add(record1);
		
		record2.setFont(font);
		record2.setForeground(Color.GREEN);
		record2.setBounds(20,105,216,30);
		add(record2);
		
		record3.setFont(font);
		record3.setForeground(Color.GREEN);
		record3.setBounds(20,155,199,30);
		add(record3);
		
		info1 = new JLabel();
		info2 = new JLabel();
		info3 = new JLabel();
		
		info1.setFont(font);
		info1.setForeground(Color.WHITE);
		info1.setBounds(219,55,50,30);	
		add(info1);
		
		info2.setFont(font);
		info2.setForeground(Color.WHITE);
		info2.setBounds(236,105,50,30);
		add(info2);
		
		info3.setFont(font);
		info3.setForeground(Color.WHITE);
		info3.setBounds(155,155,50,30);
		add(info3);
		
		try {
			
			FileReader fr1 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record1.txt");
			FileReader fr2 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record2.txt");
			FileReader fr3 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record3.txt");
			
			BufferedReader br1 = new BufferedReader(fr1);
			BufferedReader br2 = new BufferedReader(fr2);
			BufferedReader br3 = new BufferedReader(fr3);
			
			info1.setText(br1.readLine());
			info2.setText(br2.readLine());		
			info3.setText(br3.readLine());
			
			FileReader fReader1 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record1.txt");
			FileReader fReader2 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record2.txt");
			FileReader fReader3 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record3.txt");
			
			BufferedReader bReader1 = new BufferedReader(fReader1);
			BufferedReader bReader2 = new BufferedReader(fReader2);
			BufferedReader bReader3 = new BufferedReader(fReader3);
			
			String str;
			while((str = bReader1.readLine()) != null) {
				int i = Integer.parseInt(str);
				recordOfCountries = i;
			}
			
			while((str = bReader2.readLine()) != null) {
				int i = Integer.parseInt(str);
				recordOfPresidents = i;
			}
			
			while((str = bReader3.readLine()) != null) {
				int i = Integer.parseInt(str);
				recordOfScores = i;
			}
			
			record1.setText("Өлкөлөр рекорду: ");
			record2.setText("Башчылар рекорду: ");	
			record3.setText("Эл рекорду: ");
			br1.close(); br2.close(); br3.close();
			bReader1.close(); bReader2.close(); bReader3.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void compareAndSet() {
		if(collectionOfCountries > recordOfCountries) {
			try {
			FileWriter fw = new FileWriter("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record1.txt");
			fw.write(String.valueOf(collectionOfCountries));
			fw.close();
			collectionOfCountries = 0;
			FileReader fr1 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record1.txt");
			BufferedReader br1 = new BufferedReader(fr1);
			info1.setText(br1.readLine());
			br1.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
		
		if(collectionOfPresidents > recordOfPresidents) {
			try {
			FileWriter fw = new FileWriter("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record2.txt");
			fw.write(String.valueOf(collectionOfPresidents));
			fw.close();	
			collectionOfPresidents = 0;
			FileReader fr2 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record2.txt");
			BufferedReader br2 = new BufferedReader(fr2);
			info2.setText(br2.readLine());
			br2.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(collectionOfScores > recordOfScores) {
			try {
			FileWriter fw = new FileWriter("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record3.txt");
			fw.write(String.valueOf(collectionOfScores));
			fw.close();	
			collectionOfScores = 0;
			FileReader fr3 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record3.txt");
			BufferedReader br3 = new BufferedReader(fr3);
			info3.setText(br3.readLine());
			br3.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {	
		while(running) {
			try {
			FileReader fr1 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record1.txt");
			FileReader fr2 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record2.txt");	
			FileReader fr3 = new FileReader("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record3.txt");
			BufferedReader br1 = new BufferedReader(fr1);
			BufferedReader br2 = new BufferedReader(fr2);		
			BufferedReader br3 = new BufferedReader(fr3);
			info1.setText(br1.readLine());
			info2.setText(br2.readLine());
			info3.setText(br3.readLine());
			br1.close(); br2.close(); br3.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			if(toMenu) {
				new Frame();
				this.dispose();
				toMenu = false;
				Frame.countries.setVisible(true);
				Frame.presidents.setVisible(true);
				Frame.population.setVisible(true);
				try {
					dataPanelT.join();				
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	

}
