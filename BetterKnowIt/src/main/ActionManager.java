package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;

import games.CountryGame;
import games.PopulationGame;
import games.PresidentsGame;

public class ActionManager implements ActionListener, MouseListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!CountryGame.done) {
		if(e.getSource()==CountryGame.lt) {
			if(Frame.currentIcon.equals(CountryGame.lt.getText())) {
				CountryGame.lt.setBackground(Color.green);
				CountryGame.rt.setBackground(Color.red);
				CountryGame.lb.setBackground(Color.red);
				CountryGame.rb.setBackground(Color.red);
				if(CountryGame.countriesCollected<39) {
				CountryGame.next.setVisible(true);
				}
				CountryGame.done = true;
				CountryGame.countriesCollected++;
			} else {
				if(Frame.currentIcon.equals(CountryGame.rt.getText())) {
					CountryGame.lt.setBackground(Color.black);
					CountryGame.rt.setBackground(Color.green);
					CountryGame.lb.setBackground(Color.red);
					CountryGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(CountryGame.lb.getText())) {
					CountryGame.lt.setBackground(Color.black);
					CountryGame.rt.setBackground(Color.red);
					CountryGame.lb.setBackground(Color.green);
					CountryGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(CountryGame.rb.getText())) {
					CountryGame.lt.setBackground(Color.black);
					CountryGame.rt.setBackground(Color.red);
					CountryGame.lb.setBackground(Color.red);
					CountryGame.rb.setBackground(Color.green);
				}
				CountryGame.done = true;
				Frame.music.play("Incorrect");
			}
		}
		
		if(e.getSource()==CountryGame.rt) {
			if(Frame.currentIcon.equals(CountryGame.rt.getText())) {
				CountryGame.lt.setBackground(Color.red);
				CountryGame.rt.setBackground(Color.green);
				CountryGame.lb.setBackground(Color.red);
				CountryGame.rb.setBackground(Color.red);
				if(CountryGame.countriesCollected<39) {
				CountryGame.next.setVisible(true);
				}
				CountryGame.done = true;
				CountryGame.countriesCollected++;
			} else {
				if(Frame.currentIcon.equals(CountryGame.lt.getText())) {
					CountryGame.lt.setBackground(Color.green);
					CountryGame.rt.setBackground(Color.black);
					CountryGame.lb.setBackground(Color.red);
					CountryGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(CountryGame.lb.getText())) {
					CountryGame.lt.setBackground(Color.red);
					CountryGame.rt.setBackground(Color.black);
					CountryGame.lb.setBackground(Color.green);
					CountryGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(CountryGame.rb.getText())) {
					CountryGame.lt.setBackground(Color.red);
					CountryGame.rt.setBackground(Color.black);
					CountryGame.lb.setBackground(Color.red);
					CountryGame.rb.setBackground(Color.green);
				}
				CountryGame.done = true;
				Frame.music.play("Incorrect");
			}
		}
		
		if(e.getSource()==CountryGame.lb) {
			if(Frame.currentIcon.equals(CountryGame.lb.getText())) {
				CountryGame.lt.setBackground(Color.red);
				CountryGame.rt.setBackground(Color.red);
				CountryGame.lb.setBackground(Color.green);
				CountryGame.rb.setBackground(Color.red);
				if(CountryGame.countriesCollected<39) {
				CountryGame.next.setVisible(true);
				}
				CountryGame.done = true;
				CountryGame.countriesCollected++;
			} else {
				if(Frame.currentIcon.equals(CountryGame.lt.getText())) {
					CountryGame.lt.setBackground(Color.green);
					CountryGame.rt.setBackground(Color.red);
					CountryGame.lb.setBackground(Color.black);
					CountryGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(CountryGame.rt.getText())) {
					CountryGame.lt.setBackground(Color.red);
					CountryGame.rt.setBackground(Color.green);
					CountryGame.lb.setBackground(Color.black);
					CountryGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(CountryGame.rb.getText())) {
					CountryGame.lt.setBackground(Color.red);
					CountryGame.rt.setBackground(Color.red);
					CountryGame.lb.setBackground(Color.black);
					CountryGame.rb.setBackground(Color.green);
				}
				CountryGame.done = true;
				Frame.music.play("Incorrect");
			}
		}
		
		if(e.getSource()==CountryGame.rb) {
			if(Frame.currentIcon.equals(CountryGame.rb.getText())) {
				CountryGame.lt.setBackground(Color.red);
				CountryGame.rt.setBackground(Color.red);
				CountryGame.lb.setBackground(Color.red);
				CountryGame.rb.setBackground(Color.green);
				if(CountryGame.countriesCollected<39) {
				CountryGame.next.setVisible(true);
				}
				CountryGame.done = true;
				CountryGame.countriesCollected++;
			} else {
				if(Frame.currentIcon.equals(CountryGame.lt.getText())) {
					CountryGame.lt.setBackground(Color.green);
					CountryGame.rt.setBackground(Color.red);
					CountryGame.lb.setBackground(Color.red);
					CountryGame.rb.setBackground(Color.black);
				} else if(Frame.currentIcon.equals(CountryGame.rt.getText())) {
					CountryGame.lt.setBackground(Color.red);
					CountryGame.rt.setBackground(Color.green);
					CountryGame.lb.setBackground(Color.red);
					CountryGame.rb.setBackground(Color.black);
				} else if(Frame.currentIcon.equals(CountryGame.lb.getText())) {
					CountryGame.lt.setBackground(Color.red);
					CountryGame.rt.setBackground(Color.red);
					CountryGame.lb.setBackground(Color.green);
					CountryGame.rb.setBackground(Color.black);
				}
				CountryGame.done = true;
				Frame.music.play("Incorrect");
			}
		}
	}
		
	if(!PresidentsGame.done) {
		if(e.getSource()==PresidentsGame.lt) {
			if(Frame.currentIcon.equals(PresidentsGame.lt.getText())) {
				PresidentsGame.lt.setBackground(Color.green);
				PresidentsGame.rt.setBackground(Color.red);
				PresidentsGame.lb.setBackground(Color.red);
				PresidentsGame.rb.setBackground(Color.red);
				if(PresidentsGame.presidentsCollected<39) {
				PresidentsGame.next.setVisible(true);
				}
				PresidentsGame.done = true;
				PresidentsGame.presidentsCollected++;
			} else {
				if(Frame.currentIcon.equals(PresidentsGame.rt.getText())) {
					PresidentsGame.lt.setBackground(Color.black);
					PresidentsGame.rt.setBackground(Color.green);
					PresidentsGame.lb.setBackground(Color.red);
					PresidentsGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(PresidentsGame.lb.getText())) {
					PresidentsGame.lt.setBackground(Color.black);
					PresidentsGame.rt.setBackground(Color.red);
					PresidentsGame.lb.setBackground(Color.green);
					PresidentsGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(PresidentsGame.rb.getText())) {
					PresidentsGame.lt.setBackground(Color.black);
					PresidentsGame.rt.setBackground(Color.red);
					PresidentsGame.lb.setBackground(Color.red);
					PresidentsGame.rb.setBackground(Color.green);
				}
				PresidentsGame.done = true;
				Frame.music.play("Incorrect");
			}
		}
		
		if(e.getSource()==PresidentsGame.rt) {
			if(Frame.currentIcon.equals(PresidentsGame.rt.getText())) {
				PresidentsGame.lt.setBackground(Color.red);
				PresidentsGame.rt.setBackground(Color.green);
				PresidentsGame.lb.setBackground(Color.red);
				PresidentsGame.rb.setBackground(Color.red);
				if(PresidentsGame.presidentsCollected<39) {
				PresidentsGame.next.setVisible(true);
				}
				PresidentsGame.done = true;
				PresidentsGame.presidentsCollected++;
			} else {
				if(Frame.currentIcon.equals(PresidentsGame.lt.getText())) {
					PresidentsGame.lt.setBackground(Color.green);
					PresidentsGame.rt.setBackground(Color.black);
					PresidentsGame.lb.setBackground(Color.red);
					PresidentsGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(PresidentsGame.lb.getText())) {
					PresidentsGame.lt.setBackground(Color.red);
					PresidentsGame.rt.setBackground(Color.black);
					PresidentsGame.lb.setBackground(Color.green);
					PresidentsGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(PresidentsGame.rb.getText())) {
					PresidentsGame.lt.setBackground(Color.red);
					PresidentsGame.rt.setBackground(Color.black);
					PresidentsGame.lb.setBackground(Color.red);
					PresidentsGame.rb.setBackground(Color.green);
				}
				PresidentsGame.done = true;
				Frame.music.play("Incorrect");
			}
		}
		
		if(e.getSource()==PresidentsGame.lb) {
			if(Frame.currentIcon.equals(PresidentsGame.lb.getText())) {
				PresidentsGame.lt.setBackground(Color.red);
				PresidentsGame.rt.setBackground(Color.red);
				PresidentsGame.lb.setBackground(Color.green);
				PresidentsGame.rb.setBackground(Color.red);
				if(PresidentsGame.presidentsCollected<39) {
				PresidentsGame.next.setVisible(true);
				}
				PresidentsGame.done = true;
				PresidentsGame.presidentsCollected++;
			} else {
				if(Frame.currentIcon.equals(PresidentsGame.lt.getText())) {
					PresidentsGame.lt.setBackground(Color.green);
					PresidentsGame.rt.setBackground(Color.red);
					PresidentsGame.lb.setBackground(Color.black);
					PresidentsGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(PresidentsGame.rt.getText())) {
					PresidentsGame.lt.setBackground(Color.red);
					PresidentsGame.rt.setBackground(Color.green);
					PresidentsGame.lb.setBackground(Color.black);
					PresidentsGame.rb.setBackground(Color.red);
				} else if(Frame.currentIcon.equals(PresidentsGame.rb.getText())) {
					PresidentsGame.lt.setBackground(Color.red);
					PresidentsGame.rt.setBackground(Color.red);
					PresidentsGame.lb.setBackground(Color.black);
					PresidentsGame.rb.setBackground(Color.green);
				}
				PresidentsGame.done = true;
				Frame.music.play("Incorrect");
			}
		}
		
		if(e.getSource()==PresidentsGame.rb) {
			if(Frame.currentIcon.equals(PresidentsGame.rb.getText())) {
				PresidentsGame.lt.setBackground(Color.red);
				PresidentsGame.rt.setBackground(Color.red);
				PresidentsGame.lb.setBackground(Color.red);
				PresidentsGame.rb.setBackground(Color.green);
				if(PresidentsGame.presidentsCollected<39) {
				PresidentsGame.next.setVisible(true);
				}
				PresidentsGame.done = true;
				PresidentsGame.presidentsCollected++;
			} else {
				if(Frame.currentIcon.equals(PresidentsGame.lt.getText())) {
					PresidentsGame.lt.setBackground(Color.green);
					PresidentsGame.rt.setBackground(Color.red);
					PresidentsGame.lb.setBackground(Color.red);
					PresidentsGame.rb.setBackground(Color.black);
				} else if(Frame.currentIcon.equals(PresidentsGame.rt.getText())) {
					PresidentsGame.lt.setBackground(Color.red);
					PresidentsGame.rt.setBackground(Color.green);
					PresidentsGame.lb.setBackground(Color.red);
					PresidentsGame.rb.setBackground(Color.black);
				} else if(Frame.currentIcon.equals(PresidentsGame.lb.getText())) {
					PresidentsGame.lt.setBackground(Color.red);
					PresidentsGame.rt.setBackground(Color.red);
					PresidentsGame.lb.setBackground(Color.green);
					PresidentsGame.rb.setBackground(Color.black);
				}
				PresidentsGame.done = true;
				Frame.music.play("Incorrect");
			}
		}
	}
	      if(e.getSource()==PopulationGame.answer && !PopulationGame.done) {
	    	  if(PopulationGame.direction.equals(PopulationGame.correctDir)) {
	    		  PopulationGame.title.setText("                           Жооп туура!");
	    		  PopulationGame.title.setForeground(Color.GREEN);
	    		  PopulationGame.scores++;
	    		  PopulationGame.counter.setText(PopulationGame.scores + "/20");
	    		  if(PopulationGame.scores<20) {
	    			  PopulationGame.next.setVisible(true);
	    		  }
	    	  } else {
	    		  PopulationGame.title.setText("                       Жооп туура эмес!");
	    		  PopulationGame.title.setForeground(Color.RED);
	    		  Frame.music.play("Incorrect");
	    	  }
	    	  PopulationGame.population1.setVisible(true);
	    	  PopulationGame.population2.setVisible(true);
	    	  PopulationGame.population1.setText(PopulationGame.populationDataStr1);
	    	  PopulationGame.population2.setText(PopulationGame.populationDataStr2);
	    	  PopulationGame.done = true;
	      }
	
	      if(e.getSource()==DataPanel.menu) {
	    	  DataPanel.toMenu = true;	    	  
	      }
	      
	      if(e.getSource()==DataPanel.eraseData) {
	    	  try {
	    	  FileWriter fw1 = new FileWriter("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record1.txt");
	    	  fw1.write("0");
	    	  FileWriter fw2 = new FileWriter("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record2.txt");
	    	  fw2.write("0");
	    	  FileWriter fw3 = new FileWriter("C:\\Users\\Shamen\\Desktop\\MyGames\\CountryGame\\Record3.txt");
	    	  fw3.write("0");
	    	  fw1.close(); fw2.close(); fw3.close();
	    	  } catch(Exception exception) {
	    		  exception.printStackTrace();
	    	  }
	      }
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==Frame.countries) {
			Frame.launchCountries = true;
		}
		
		if(e.getSource()==Frame.presidents) {
			Frame.launchPresidents = true;
		}
		
		if(e.getSource()==Frame.population) {
			Frame.launchPopulation = true;
		}
		
		if(e.getSource()==CountryGame.menu) {
			CountryGame.goMenu = true;
			new DataPanel();
		}
		
		if(e.getSource()==PopulationGame.menu) {
			PopulationGame.goMenu = true;
			new DataPanel();
		}
		
		if(e.getSource()==PresidentsGame.menu) {
			PresidentsGame.goMenu = true;
			new DataPanel();
		}
		
		if(e.getSource()==CountryGame.next) {
			CountryGame.goNext = true;
			CountryGame.done = false;
		}
		
		if(e.getSource()==PresidentsGame.next) {
			PresidentsGame.goNext = true;
			PresidentsGame.done = false;
		}
		
		if(e.getSource()==PopulationGame.next) {
			PopulationGame.goNext = true;
			PopulationGame.done = false;
			PopulationGame.title.setText("    Кайсы өлкөнүн элинин саны көбүрөөк?");
			PopulationGame.population1.setVisible(false);
			PopulationGame.population2.setVisible(false);
			PopulationGame.direction = "Left";
			PopulationGame.sign.setText(" >");
		}
		
		if(e.getSource()==PopulationGame.sign && !PopulationGame.done) {
		    switch(PopulationGame.direction) {
		    case "Left": PopulationGame.direction = "Right";
		                 PopulationGame.sign.setText(" <");
		    break;
		    case "Right": PopulationGame.direction = "Left";
                          PopulationGame.sign.setText(" >");
		    break;	
		    }
		}
		
		}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==Frame.countries) {
			Frame.countries.setForeground(Color.white);
		}
		
		if(e.getSource()==Frame.presidents) {
			Frame.presidents.setForeground(Color.white);
		}
		
		if(e.getSource()==Frame.population) {
			Frame.population.setForeground(Color.white);
		}
		
		if(e.getSource()==CountryGame.menu) {
			CountryGame.menu.setForeground(Color.white);
		}
		
		if(e.getSource()==PresidentsGame.menu) {
			PresidentsGame.menu.setForeground(Color.white);			
		}
		
		if(e.getSource()==PopulationGame.menu) {
			PopulationGame.menu.setForeground(Color.white);			
		}
		
		if(e.getSource()==CountryGame.next) {
			CountryGame.next.setForeground(Color.white);	
		}
		
		if(e.getSource()==PresidentsGame.next) {
			PresidentsGame.next.setForeground(Color.white);	
		}
		
		if(e.getSource()==PopulationGame.next) {
			PopulationGame.next.setForeground(Color.white);	
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==Frame.countries) {
			Frame.countries.setForeground(Color.GREEN);
		}	
		
		if(e.getSource()==Frame.presidents) {
			Frame.presidents.setForeground(Color.GREEN);
		}
		
		if(e.getSource()==Frame.population) {
			Frame.population.setForeground(Color.GREEN);
		}
		
		if(e.getSource()==CountryGame.menu) {
			CountryGame.menu.setForeground(Color.GREEN);		
		}
		
		if(e.getSource()==PresidentsGame.menu) {
			PresidentsGame.menu.setForeground(Color.GREEN);		
		}
		
		if(e.getSource()==PopulationGame.menu) {
			PopulationGame.menu.setForeground(Color.GREEN);			
		}
		
		if(e.getSource()==CountryGame.next) {
			CountryGame.next.setForeground(Color.GREEN);
		}
		
		if(e.getSource()==PresidentsGame.next) {
			PresidentsGame.next.setForeground(Color.GREEN);
		}
		
		if(e.getSource()==PopulationGame.next) {
			PopulationGame.next.setForeground(Color.GREEN);
		}
	}

}
