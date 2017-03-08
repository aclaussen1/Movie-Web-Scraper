import com.jaunt.Element;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class MojoScraper {
	String nameOfMovie;
	UserAgent userAgent;
	boolean movieFound = false;
	String movieWriters;
	
	/**
	 * 
	 * @param movieName
	 * @param writers
	 *
	 *	THIS IS THE BOX-OFFICE MOJO SCRAPING CLASS
	 *
	 */
	
	public MojoScraper(String movieName, String writers) {
		nameOfMovie = movieName;
		  userAgent = new UserAgent();
		movieWriters = writers;
	}
	
	public boolean mojoSearch() {
		try{
			 if (nameOfMovie.equalsIgnoreCase("Fantastic Mr Fox")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=fantasticmrfox.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Fantastic Mr Fox")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=fantasticmrfox.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("12 and holding")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=twelveandholding.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("2001: a space odyssey")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=2001.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("50-50")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=50fifty.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("50-50")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=50fifty.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("a nightmare on elm street")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=elmst.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("a perfect world")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=perfectworld.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("a.i.")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=ai.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("adaptation")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=adaptation.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("airplane")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=airplane.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("american werewolf in london")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=americanwerewolfinlondon.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("angels & demons")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=angelsanddemons.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("apocalypse now")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=apocalypsenow.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("arsenic and old lace")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=arsenicandoldlace.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bodies, rest & motion")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=bodiesrestandmotion.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("body heat")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=bodyheat.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bonfire of the vanities")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=bonfireofthevanities.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bonnie and clyde")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=bonnieandclyde.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("cable guy")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=cableguy.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("casablanca")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=casablanca.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("charade")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=charade.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("chinatown")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=chinatown.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("cowboys & aliens")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=cowboysandaliens.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("crying game")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=cryinggame.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("dog day afternoon")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=dogdayafternoon.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("four feathers")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=fourfeathers.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("frankenstein")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=frankenstein.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("friday the 13th part viii: jason takes manhattan")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=friday13th8.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("house of 1000 corpses")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=houseof1000corpses.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("i love you phillip morris")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=iloveyouphillipmorris.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("i, robot")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=irobot.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("jaws 2")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=jaws2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("land of the dead")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=landofthedead.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("lock, stock and two smoking barrels")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=lockstockandtwosmokingbarrels.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("lord of the rings: return of the king")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=iloveyouphillipmorris.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("marty")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=marty.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("master and commander")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=masterandcommander.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mean streets")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=meanstreets.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("men in black 3")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("midnight cowboy")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=midnightcowboy.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mighty morphin power rangers: the movie")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=powerrangers.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mission impossible")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=missionimpossible.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("pirates of the caribbean")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=piratesofthecaribbean.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("platinum blonde")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("predator")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=predator.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("rear window")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=rearwindow.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("men in black 3")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("men in black 3")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("men in black 3")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("men in black 3")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("men in black 3")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } 
			 else if(movieWriters.contains("http")) {
				  userAgent.visit(movieWriters);
				  movieFound = true;

				  return true;
			  } else {

				  if(nameOfMovie.contains(", The")) {
					  nameOfMovie = nameOfMovie.replace(", The",  "");
					  nameOfMovie = "The " + nameOfMovie;
					  System.out.println("name of movie in mojo scrapper became:" + nameOfMovie);
				  }
				  if(nameOfMovie.contains(", A")) {
					  nameOfMovie = nameOfMovie.replace(", A", "");
					  nameOfMovie = "A " + nameOfMovie;
					  System.out.println("name of movie in mojo scrapper became:" + nameOfMovie);
				  } if(nameOfMovie.contains(",")) {
					  nameOfMovie = nameOfMovie.replace(",", "");
					  System.out.println("name of movie in mojo scrapper became:" + nameOfMovie);
				  }
				  System.out.println("movieName:" + nameOfMovie);
				  System.out.println("mojo user agent is visiting: " + "http://www.boxofficemojo.com/search/?q=" + nameOfMovie.replace(" ", "%20") );
				  userAgent.visit("http://www.boxofficemojo.com/search/?q=" + nameOfMovie.replace(" ", "%20"));
				  
			  //System.out.println(nameOfMovie);
			  String[] writerNames;
			  
			  if(movieWriters.length() > 0) writerNames = movieWriters.split(",");
			  else return false;
			  if(nameOfMovie.contains("the")) {
				  nameOfMovie = nameOfMovie.replace(" the", "");
				  nameOfMovie = "the " + nameOfMovie;
				  System.out.println("name of movie in mojo scrapper became:" + nameOfMovie);
			  }
			  for(Element element : userAgent.doc.findEvery("<a>")) {
				  String temp = element.getText().toLowerCase();
				  //System.out.println(temp);
				  String year;
				  boolean old = false;
				  if(temp.contains("(")) {
					  year = temp.substring(temp.indexOf("("));
					  temp = temp.replace(year, "").trim();
					  old = true;
				  }
				  
				  //System.out.println("BOX OFFICE MOJO Movie: " + temp.replace("the ", "") + " - OUR Movie: " + nameOfMovie.replace(", The", "").replace(", A",  "").toLowerCase());
				  nameOfMovie = nameOfMovie.replace("&", "and");
				  //System.out.println("The variable called temp (name of movie in mojo): " + temp);
				  if( temp.equals(nameOfMovie.toLowerCase())) {
					  
					  userAgent.visit(element.getAt("href"));
					  movieFound = true;
					  return true;
//					  for(int i = 0; i < writerNames.length; i++) {
//						  //System.out.println(writerNames[i]);
//						  //System.out.println(userAgent.doc.findFirst("<div class=mp_box_content>").innerHTML());
//						  if(userAgent.doc.innerHTML().toLowerCase().contains(writerNames[i].replaceAll("[^a-zA-Z ]", "").toLowerCase())) {
//							  movieFound = true;
//							  //System.out.println("Movie match MOJO");
//							  return true;
//						  }
//						  if(old == true) {
//							  movieFound = true;
//							  return true;
//						  }
//					  }
//					  continue;
				  }
			  }
			  return false;
			  }
			}
			catch(JauntException e){ 
				try {
					userAgent.visit("https://www.rottentomatoes.com/m/" + nameOfMovie.replace(" ",  "_"));
					movieFound = true;
				}
				catch(JauntException e2) {
					movieFound = false;
				}

			}
		return movieFound;
	}
	
	public String getMojoDomesticGross() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<font>")) {
				  if(element.getText().contains("Domestic Total Gross")) {
					  return element.findFirst("<b>").getText();
				  }
			 }
		} else return "FoundButNotListed";
		} catch(JauntException e) {
			
		}
		return "FoundButNotListed";
	}
	
	public String getMojoYear() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<td>")) {
				//System.out.println("here1");
				  if(element.getText().contains("Release Date")) {
					  //System.out.println("here2");
					  return element.findFirst("<a>").getText();
				  }
			 }
		} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return "NOT LISTED";
	}
	
	public String getMojoForeignGross() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			boolean found = false;
			for(Element element : userAgent.doc.findEvery("<td width='35%'>")) {
				  //System.out.println(element.innerHTML());
				  if(found == true) {
					  return element.getText().replace("&nbsp;", "");
				  }
				  
				  if(!element.getText().contains("<b>")) {
					  found = true;
				  }
			 }
		} else return "NOT LISTED";
//		} catch(JauntException e) {
//			
//		}
		return "NOT LISTED";
	}
	
	public String getMojoWorldGross() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			int found = 0;
			for(Element element : userAgent.doc.findEvery("<td width='35%'>")) {
				  if(element.innerHTML().contains("<b>")) {
					  found++;
				  }
				  if(found == 2) {
					  return element.innerHTML().replace("&nbsp;", "").replace("<b>", "").replace("</b>", "");
				  }
			 }
		} else return "NOT LISTED";
//		} catch(JauntException e) {
//			
//		}
		return "NOT LISTED";
	}
	
	public String getMojoOpeningWeekendRevenue() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			boolean found = false;
			for(Element element : userAgent.doc.findEvery("<div class=mp_box_content>")) {
				if(element.innerHTML().contains("Opening&nbsp;Weekend:")) {
					boolean wide = false;
					for(Element element2: element.findEvery("<td>"))  {
						if(element.innerHTML().contains("Wide&nbsp;Opening&nbsp;Weekend")) {
							wide = true;
						}
						  if(found == true) {
							  return element2.getText().replace("&nbsp;", "").trim().replace("\n", "");
						  }
						  if(element2.innerHTML().contains("Opening&nbsp;Weekend") && wide == false) found = true;
						  if(element2.innerHTML().contains("Wide&nbsp;Opening&nbsp;Weekend")) found = true;
						//System.out.println(element2.innerHTML());
					}
				}

			 }
		} else return "NOT LISTED";
//		} catch(JauntException e) {
//			
//		}
		return "NOT LISTED";
	}
	
	public String getMojoNumbTheatres() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			boolean found = false;
			for(Element element : userAgent.doc.findEvery("<div class=mp_box_content>")) {
				boolean wide = false;
				int index = 0;
				for(Element element2: element.findEvery("<td align=center>"))  {
					if(element.innerHTML().contains("Wide&nbsp;Opening&nbsp;Weekend")) {
						wide = true;
					}
					if(index == 1 && wide == false) {
						String temp = element2.findFirst("<font>").getText().replace(" theaters", "");
						if(temp.split(", ").length > 1)
							return temp.split(", ")[1];
						else return "NOT LISTED";
					}
					if(index == 4 && wide == true) {
						String temp = element2.findFirst("<font>").getText().replace(" theaters", "");;
						if(temp.split(", ").length > 1)
							return temp.split(", ")[1];
						else return "NOT LISTED";
					}
						index++;
				}

			 }
		} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return "NOT LISTED";
	}
	
	public String getMojoRevPerTheatre() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			boolean found = false;
			for(Element element : userAgent.doc.findEvery("<div class=mp_box_content>")) {
				boolean wide = false;
				int index = 0;
				for(Element element2: element.findEvery("<td align=center>"))  {
					if(element.innerHTML().contains("Wide&nbsp;Opening&nbsp;Weekend")) {
						wide = true;
					}
					if(index == 1 && wide == false) {
						String temp = element2.findFirst("<font>").getText();
						if(temp.split(", ").length > 2)
							return temp.split(", ")[2].replace(" average)", "");
						else return "NOT LISTED";
						
					}
					if(index == 4 && wide == true) {
						String temp = element2.findFirst("<font>").getText();
						if(temp.split(", ").length > 2)
							return temp.split(", ")[2].replace(" average)", "");
						else return "NOT LISTED";
					}
						index++;
				}

			 }
		} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return "NOT LISTED";
	}
	
	public String getNumberUserRatings() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {
			int index = 0;
			for(Element e : userAgent.doc.findEvery("<div>")) {
				//System.out.println(e.getText().trim());
				if(e.innerHTML().contains("User Ratings") && e.innerHTML().contains("subtle superPageFontColor")) {
					index++;
					String temp = e.getText().trim();
					if(index == 8) return temp;
				}
			}
		} catch(Exception e) {
			
		}
		return null;
	}
	
	public String getBudget() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {

			for(Element e : userAgent.doc.findEvery("<td valign='top'>")) {
				if(e.innerHTML().contains("Production Budget:")) {
					String temp1 =  e.innerHTML().substring(e.innerHTML().indexOf("Production Budget:") + 19);
					//System.out.println(temp1);
					String temp = temp1.substring(0, temp1.indexOf("</b>"));
					temp = temp.replace("<b>", "");
					return temp.replace(" million", ",000,000");
				}
				else return "NOT LISTED";
			}
		} catch(Exception e) {
			
		}
		return null;
	}
	
	public String getDistributor() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {

			for(Element e : userAgent.doc.findEvery("<td valign='top'>")) {
				if(e.innerHTML().contains("Distributor:")) {
					String temp1 =  e.innerHTML().substring(e.innerHTML().indexOf("Distributor:") + 11);
					//System.out.println(temp1);
					temp1 = temp1.replace("<b>", "").replace("</b>", "");
					String temp = temp1.substring(temp1.indexOf(">") + 1, temp1.indexOf("</a>"));
					return temp;
				}
				else return "NOT LISTED";
			}
		} catch(Exception e) {
			
		}
		return null;
	}
}
