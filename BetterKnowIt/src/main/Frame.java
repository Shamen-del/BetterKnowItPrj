package main;

import java.awt.*;
import javax.swing.*;
import games.CountryGame;
import games.PopulationGame;
import games.PresidentsGame;

public class Frame extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	public final static String name = "Билиш керек";
	
	Thread mainT;	
	
	private ActionManager am;
	public static Music music = new Music();
	
	public volatile static String currentIcon = null;
	public volatile static String currentIcon1 = null;	
	public volatile static String currentIcon2 = null;
	
	// Booleans	
	private volatile static boolean running = false;	
	public static boolean launchCountries = false;
	public static boolean launchPresidents = false;
	public static boolean launchPopulation = false;
	volatile public static boolean initial = true;
	
	// Labels	
	public static JLabel countries;
	public static JLabel presidents;
	public static JLabel population;

	public Frame() {
		launchMainFrame();
		createComponents();		
		createButtons();
	}
	
	@Override
	public void run() {
		CountryGame.done = false;
		PresidentsGame.done = false;
		PopulationGame.done = false;
		running = true;
		music = new Music();
		while(running) {
			if(launchCountries) {
				launchCountriesGameFrame();
				launchCountries = false;
				running = false;				
				this.dispose();
				try {
					mainT.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if(launchPresidents) {
				launchPresidentsGameFrame();
				launchPresidents = false;
				running = false;
				this.dispose();
				try {
					mainT.join();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			} else if(launchPopulation) {
				launchPopulationGameFrame();
				launchPopulation = false;
				running = false;
				this.dispose();
				try {
					mainT.join();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			}
	}
	
	public void launchMainFrame() {
		setTitle(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(300,300);
		setResizable(false);
		getContentPane().setBackground(Color.BLUE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	
	public void createButtons() {
		countries = new JLabel("Өлкөлөр");
		countries.setBounds(88, 20, 100, 30);
		countries.setFont(new Font("Serif", Font.BOLD, 25));
		countries.setForeground(Color.GREEN);
		countries.setForeground(Color.GREEN);
		countries.addMouseListener(am);
		
		presidents = new JLabel("Башчылар");
		presidents.setBounds(78,100,123,30);
		presidents.setFont(new Font("Serif", Font.BOLD, 25));
		presidents.setForeground(Color.GREEN);
		presidents.addMouseListener(am);
		
		population = new JLabel("Элдин саны");
		population.setBounds(73,180,135,30);
		population.setFont(new Font("Serif", Font.BOLD, 25));
		population.setForeground(Color.GREEN);
		population.addMouseListener(am);
		
		add(countries); add(presidents); add(population);
	}
	
	private void createComponents() {
		mainT = new Thread(this);
		am = new ActionManager();
		mainT.start();
	}
	
	public void launchCountriesGameFrame() {
		new CountryGame();
	} 
	
	public void launchPresidentsGameFrame() {
		new PresidentsGame();
	}
	
	public void launchPopulationGameFrame() {
		new PopulationGame();
	}
	
}
