
import java.util.ArrayList;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.UserAgent;
import com.jaunt.component.Form;

/**
 * 
 * @author dpourmehr
 *
 *THIS IS THE IMDB SCRAPING CLASS
 *
 */

public class ImdbScraper {

	String nameOfMovie;
	UserAgent userAgent;
	String movieWriters;
	
	public ImdbScraper(String movieName, String writers) {
		nameOfMovie = movieName;
		movieWriters = writers;
	}
	
	/***
	 * This function goes to imdb's homepage and types in the search field
	 * what the name of the movie is that is passed to the constructor.
	 * 
	 * We assume that the first result is the correct movie we are searching
	 * for, and therefore change the userAgent's page to that new link.
	 * @return
	 */
	
	public boolean imdbSearch() {
		try{
			  userAgent = new UserAgent(); 
			  //create new userAgent (headless browser).
//			  userAgent.visit("http://www.imdb.com/?ref_=nv_home");  //visit a url
//			  Form f = userAgent.doc.getForm(userAgent.doc.findFirst("<form>"));
//			  f.setTextField("q", nameOfMovie);
//			  f.submit();
			  if(movieWriters.contains("http")) {
				  //System.out.println("contains https");
				  userAgent.visit(movieWriters);
				  return true;
			  } else userAgent.visit("http://www.imdb.com/search/title?title=" + nameOfMovie.replace(" ", "%20").replace(":", "%3A") + "&title_type=feature");
			  //System.out.println(userAgent.getLocation());

			  Boolean searchFound = false;
			  //userAgent.visit(userAgent.doc.findFirst("<table class=\"results\">").findFirst("<tr class=\"even detailed\">").findFirst("<a>").getAt("href"));
			  Element resultsTable = userAgent.doc.findFirst("<div class=lister-list>");
			  
			  for(Element element : resultsTable.findEvery("<a>")) {
				  //System.out.println("IMDB Movie " + element.getText().replace("The ", "") + " - OUR Movie " + nameOfMovie.replace(", The", "").replace(", A",  ""));
				  String webSearchResult = element.getText().replace(":", "");
				  if(webSearchResult.indexOf("The ") < 2) webSearchResult = webSearchResult.replace("The ", "");
				  //System.out.println(webSearchResult + " - " + nameOfMovie.replace(", The", "").replace(", A",  "").replace(":", ""));
				  if(webSearchResult.contains(nameOfMovie.replace(", The", "").replace(", A",  "").replace(":", ""))) {
					  userAgent.visit(element.getAt("href"));
					  
					  boolean international = false;
					  
					  if(!userAgent.doc.findFirst("<div class=subtext>").innerHTML().contains("(USA)")) international = true;
					  
					  String[] writers;
					  
					  if(international == false) {
						  //if(this.getWriters() != null) System.out.println("IMDB WRITERS: " + this.getWriters());
//						  System.out.println(movieSubString);
//						  System.out.println("-----------------------");
//						  System.out.println(this.getWriters());
						  if(this.getWriters() != null && this.getWriters().contains(","))
							  writers = this.getWriters().split(", ");
						  else {
							  writers = new String[1];
							  writers[0] = this.getWriters();
						  }
						  
						  boolean found = false;
						  
						  for(int i = 0; i < writers.length; i++) {
							  if(movieWriters == null || writers == null || writers[i] == null) return false;
							  if(movieWriters.replaceAll("[^a-zA-Z ]", "").toLowerCase().contains(writers[i].replaceAll("[^a-zA-Z ]", "").toLowerCase())) {
								  //System.out.println(nameOfMovie + " - MOVIE MATCH: " + movieWriters + " - " + writers[i]);
								  System.out.println(userAgent.getLocation());
								  return true;
							  }
						  }
						  
						  //System.out.println("Found: " + found);
						  
						  if(found == false) {
							  continue;
						  }
					  }
					  else return international;
					  //System.out.println("IMDB: " + userAgent.getLocation());

				  }
			  }
			  //System.out.println("No more links to match");
//			  for(Element element : resultsTable.findEvery("<a>")) {
//				  if(element.getText().toLowerCase().contains(nameOfMovie.toLowerCase())) {
//					  userAgent.visit(element.getAt("href"));
//					  return true;
//				  }
//			  }
			  return false;
			}
			catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
			  //System.err.println(e);
			}   
			
		
		return false;
	}
	
	public String[] getNumbAwards() {
		String[] awardArray = new String[6];
		/**
		 * 
		 * Element 0 = # wins
		 * Element 1 = # nominations
		 * Element 2 = # Oscar wins
		 * Element 3 = # Oscar Nominations
		 * Element 4 = # Golden Globe wins
		 * Element 5 = # Golden Globe Nominations
		 * 
		 */
		for(Element link : userAgent.doc.findEvery("<div id=titleAwardsRanks>")) {
			for(Element spans: link.findEvery("<span>")) {
				if(spans.innerHTML().contains("Nominated")) {
					if(spans.innerHTML().contains("Oscar")) {
						awardArray[3] = spans.innerHTML().split("\n")[3].trim();
					} else if(spans.innerHTML().contains("Golden Globe")) {
						awardArray[5] = spans.innerHTML().split("\n")[3].trim();
					}
					//System.out.println(spans.innerHTML().split("\n")[3].trim());
				} else if(spans.innerHTML().contains("Won")) {
					if(spans.innerHTML().contains("Oscar")) {
						awardArray[2] = spans.innerHTML().split("\n")[3].trim();
					} else if(spans.innerHTML().contains("Golden Globe")) {
						awardArray[4] = spans.innerHTML().split("\n")[3].trim();
					}
					//System.out.println(spans.innerHTML().split("\n")[3].trim());					
				}
				else if(spans.getText().toLowerCase().contains(" wins ") || spans.getText().toLowerCase().contains(" win ")) { //if the title has some win(s) 
					String temp = spans.getText().trim().substring(0, spans.getText().trim().indexOf("win") - 1);
					temp = temp.replace("Another\n", "");
					temp = temp.trim();
					awardArray[0] = temp;
					temp = spans.getText().trim();
					temp = temp.replace("Another\n", "");
					temp = temp.trim();
					temp = temp.replace("&amp;", "");
					if(temp.contains("nominat")) {
						temp = temp.substring(temp.indexOf("  ") + 2, temp.indexOf("nominat") - 1).trim();
						awardArray[1] = temp;
					}
					for(int i = 0; i < 6; i++) {
						if(awardArray[i] == null) {
							awardArray[i] = "0";
						}
					}
				} else if(spans.getText().toLowerCase().contains("nominations")) { //if the title has 0 wins and some nominations it would get here
					String temp = spans.getText().trim().substring(0,  spans.getText().trim().indexOf("nominat") - 1).replace("Another\n", "");
					awardArray[1] = temp;
				}
			}
		 }
		for(int i = 0; i < 6; i++) {
			if(awardArray[i] == null) {
				awardArray[i] = "0";
			}
		}
		return awardArray;
	}
	
	public String getDirector() throws NotFound {
		String director = "";
		try {
			for(Element header : userAgent.doc.findEvery("<div class=credit_summary_item>")) {
				if(header.findFirst("<h4>").getText().contains("Director:") || header.findFirst("<h4>").getText().contains("Directors:")) {
					for(Element spans : header.findEvery("<a>")) {
						if(!spans.innerHTML().contains("span")) return director;
							if(director.length() < 1) {
								director = director +  spans.findFirst("<span>").getText();
							} else director = director +  ", " + spans.findFirst("<span>").getText();
					}
					return director;
				}
			}
		} catch(JauntException e) {
			
		} 

	
		
		return "";
	}
	
	public String getWriters() {
		String writers = "";
		try {
			for(Element header : userAgent.doc.findEvery("<div class=credit_summary_item>")) {
				if(header.findFirst("<h4>").getText().contains("Writer:") || header.findFirst("<h4>").getText().contains("Writers:")) {
					for(Element spans : header.findEvery("<a>")) {
						if(!spans.innerHTML().contains("span")) return writers;
							if(writers.length() < 1) {
								writers = writers +  spans.findFirst("<span>").getText();
							} else writers = writers +  ", " + spans.findFirst("<span>").getText();
					}
					return writers;
				}
			}

		} catch(JauntException e) {
			System.out.println(e.getMessage());
		}
		

	
		return null;
	}
	
	public String getStars() {
		String stars = "";
		try {
			for(Element header : userAgent.doc.findEvery("<div class=credit_summary_item>")) {
				if(header.findFirst("<h4>").getText().contains("Star:") || header.findFirst("<h4>").getText().contains("Stars:")) {
					for(Element spans : header.findEvery("<a>")) {
						if(!spans.innerHTML().contains("span")) return stars;
							if(stars.length() < 1) {
								stars = stars +  spans.findFirst("<span>").getText();
							} else stars = stars +  ", " + spans.findFirst("<span>").getText();
					}
					return stars;
				}
			}

		} catch(JauntException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}
	
	public ArrayList<String> getStarsUrls() {
		ArrayList<String> starUrls = new ArrayList<String>();
		try {
			for(Element header : userAgent.doc.findEvery("<div class=credit_summary_item>")) {
				if(header.findFirst("<h4>").getText().contains("Star:") || header.findFirst("<h4>").getText().contains("Stars:")) {
					for(Element spans : header.findEvery("<a>")) {
						if(!spans.innerHTML().contains("span")) return starUrls;
						starUrls.add(spans.getAt("href"));
					}
					return starUrls;
				}
			}

		} catch(JauntException e) {
			System.out.println(e.getMessage());
		}  

		return null;
	}
	
	public ArrayList<String> getDirectorUrls() {
		ArrayList<String> directorUrls = new ArrayList<String>();
		
		try {
			Elements directors = userAgent.doc.findEvery("<span itemprop=director>");
			
			for(Element spanBlock : directors) {
				for(Element link : spanBlock.findEvery("<a>")) {
					directorUrls.add(link.getAt("href"));
				}
			}
			
			return directorUrls;

		} catch(JauntException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public String getYear() {
		String year = "";
		try {
			if(userAgent.doc.findFirst("<title>") != null && !userAgent.doc.findFirst("<title>").equals(""))
			year = userAgent.doc.findFirst("<title>").getText();
			else year = "NOT FOUND";
			if(year.contains("(") && year.contains(")")) {
				year = year.substring(year.indexOf("(") + 1, year.indexOf(")"));
			} else year = "NOT FOUND";
			//return year;
			return year;
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getRunTime() {
		try {
			String time = userAgent.doc.findFirst("<div class=subtext>").findFirst("<time>").getText().trim();
			int hours, minutes;
			
			if(time.contains("h")) hours = Integer.parseInt(time.substring(0, time.indexOf("h")));
			else hours = 0;
			
			if(time.contains("m")) minutes = Integer.parseInt(time.substring(time.indexOf(" "), time.indexOf("m")).trim());
			else minutes = 0;
			
			int temp = hours*60;
			minutes = temp + minutes;
			String newTime = minutes + "min";
			
			return newTime;
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getMpaa() {
		try {
			String innerhtml = userAgent.doc.findFirst("<div class=subtext>").innerHTML();
			if(innerhtml != "" && innerhtml != null && innerhtml.contains(">") && innerhtml.contains("<span")) {
				innerhtml = innerhtml.substring(innerhtml.indexOf(">") + 1, innerhtml.indexOf("<span")).trim();
			} else innerhtml = "NOT FOUND";
			return innerhtml;
			//return userAgent.doc.findFirst("<div class=txt-block>").findFirst("<span>").getText();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getGenres() {
		String genreString = "";
		String[] genres = {"Action", "Comedy", "Family", "History", "Mystery", "Sci-Fi", "War", "Adventure", "Crime", "Fantasy", "Horror", "News", "Sport", "Western", "Animation", "Documentary", "Film-Noir", "Music", "Reality-TV", "Talk-Show", "Biography", "Drama", "Game-Show", "Musical", "Romance", "Thriller"};
		try {
			for(Element e : userAgent.doc.findFirst("<div class=subtext>").findEvery("<span>")) {
				for(int i = 0; i < genres.length; i++) {
					if(genres[i].equalsIgnoreCase(e.getText())) {
						if(genreString.length() < 1) {
							genreString = genreString +  e.getText();
						} else genreString = genreString +  ", " + e.getText();
					}
				}
			}
			return genreString.trim();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getRating() {
		try {
			return userAgent.doc.findFirst("<span class=rating>").getText().trim();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getGross() {
		try {
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
				temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "business");
			else temp.visit(userAgent.getLocation() + "business");	
			String content = temp.doc.findFirst("<div id=tn15content>").innerHTML();
			if(content.contains("<h5>Gross</h5>")) {
				content = content.substring(content.indexOf("<h5>Gross</h5>") + 14);
				content = content.substring(0, content.indexOf("(")).trim();
				content = content.replace("&#163;", "\u00a3");
				return content.trim();
			} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
			return null;
	}
	
	public String getBudget() {
		try {
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
				temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "business");
			else temp.visit(userAgent.getLocation() + "business");	
			//System.out.println(userAgent.getLocation());
			//System.out.println(temp.getLocation());
			String content = temp.doc.findFirst("<div id=tn15content>").innerHTML();
			if(content.contains("<h5>Budget</h5>")) {
				content = content.substring(content.indexOf("<h5>Budget</h5>") + 15);
				content = content.substring(0, content.indexOf("(")).trim();
				content = content.replace("&#163;", "\u00a3");
				return content.trim();
			} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getProductionCompanies() {
		String companies = "";
		for(Element e : userAgent.doc.findEvery("<div class=txt-block>")) {
			if(e.innerHTML().contains("Production")) {
				for(Element e2 : e.findEvery("<span class=itemprop>")) {
					if(companies.length() < 1) {
						companies = e2.getText();
					} else companies += ", " + e2.getText();
				}
				return companies;
			}
		}
		return null;
	}
	
	public String getMetaScore() {
		try {
			//System.out.println(userAgent.doc.findFirst("<div classs=titleReviewBarItem>").innerHTML());
			//if(!userAgent.doc.findFirst("<div classs=titleReviewBarItem>").findFirst("<span>").getText().contains("("))
			if(!userAgent.doc.findFirst("<div class=titleReviewBarItem>").innerHTML().contains("Metascore")) {
				return "NOT LISTED";
			}
			return userAgent.doc.findFirst("<div class=titleReviewBarItem>").findFirst("<span>").getText().replace("\t",  "").replace("( )", "");
		} catch (JauntException e) {
			
		}
		return "NOT LISTED";
	}
	
	public String getUserReviews() {
		try {
			for(Element e : userAgent.doc.findEvery("<span class=subtext>")) {
				if(e.innerHTML().contains("reviews?")) {
					return e.findFirst("<a>").getText().replace(" user", "");
				}
			}
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getCriticReviews() {
		try {
			for(Element e : userAgent.doc.findEvery("<span class=subtext>")) {
				if(e.innerHTML().contains("reviews?")) {
					for(Element e2 : e.findEvery("<a>")) {
						if(e2.getAt("href").contains("external")) {
							return e2.getText().replace(" critic", "");
						}
					}
				}
			}
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getVotes() {
		try {
			return userAgent.doc.findFirst("<span class=small>").getText();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getReleaseDate() {
		
		
			for(Element e : userAgent.doc.findEvery("<div class=txt-block>")) {
				if(e.innerHTML().contains("Release Date:")) {
					try {
					String temp = e.innerHTML().substring(e.innerHTML().indexOf("</h4>") + 6, e.innerHTML().indexOf("("));
					return temp;
					} catch (NullPointerException er) {
						return "";
					}
					
					
					//return e.getText();
				}
			}
		
	
		return "";
		
	}
	
	public String getWeekendRevenue() {
		try {
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
				temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "business");
			else temp.visit(userAgent.getLocation() + "business");	
			String content = temp.doc.findFirst("<div id=tn15content>").innerHTML();
			if(content.contains("<h5>Opening Weekend</h5>")) {
				content = content.substring(content.indexOf("<h5>Opening Weekend</h5>") + 24);
				content = content.substring(0, content.indexOf("(")).trim();
				content = content.replace("&#163;", "\u00a3");
				return content.trim();
			} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getCountry(){
		
		String country = "";
		try {
			System.out.println("inside try");
			for(Element header : userAgent.doc.findEvery("<div class=txt-block>")) {
				System.out.println("inside for");
				
				
				//if(header.findEvery("<h4>").size() > 0) the line of code below deals with the special case of the movie http://www.imdb.com/title/tt0368725/?ref_=nm_flmg_act_18 The fever. For whatever reason this page does not work well with the findFirst() and 
				if(header.findEvery("<h4>").size() > 0){
					if(header.findFirst("<h4>").getText().contains("Country:") || header.findFirst("<h4>").getText().contains("Country:")) {
						System.out.println("inside if");
						for(Element spans : header.findEvery("<a>")) {
							//if(!spans.innerHTML().contains("span")) return country;
								if(country.length() < 1) {
									country = country +  spans.getText();
									System.out.println(country);
								} else country = country +  ", " + spans.getText();
						}
						System.out.println(country);
						return country;
					}
				}
			}
		} catch(JauntException e) {
			System.out.println(e.getMessage());
		
		}
		
		return null;
		
		
	}

	public int basedOnNovel() {
		try {
			UserAgent temp = new UserAgent();
			
			String location = userAgent.getLocation();
			
			location = location.substring(0, location.lastIndexOf("/") + 1) + "fullcredits";
			
			temp.visit(location);
			
			if(temp.doc.innerHTML().contains("(novel)") || temp.doc.innerHTML().contains("(book)")|| temp.doc.innerHTML().contains("(based on the novel by)") || temp.doc.innerHTML().contains("(based on the book by)")) {
				return 1;
			}
			

		} catch(JauntException e) {
			
		}
		return 0;
	}
	
	public int screenPlayWins() {
		try {
			int numWins = 0;
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
			temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "awards");
			else temp.visit(userAgent.getLocation() + "awards");	
			for(Element table : temp.doc.findEvery("<table class=awards>")) {
				for(Element row : table.findEvery("<tr>")) {
					if(row.innerHTML().contains("<b>Nominated</b>") || row.innerHTML().contains("place</b>")) {
						break;
					}
					for(Element cell : row.findEvery("<td class=award_description>")) {
						if(cell.getText().contains("Screenplay")) {
							//System.out.println(cell.getText());
							numWins++;
						}
					}
				}
			}
			
			return numWins;
		} catch(JauntException e) {
			return 0;
		}
	}
	
	public int screenPlayNominations() {
		try {
			int numNominations = 0;
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
			temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "awards");
			else temp.visit(userAgent.getLocation() + "awards");	
			boolean onWon = false;
			
			for(Element table : temp.doc.findEvery("<table class=awards>")) {
				for(Element row : table.findEvery("<tr>")) {
					if(row.innerHTML().contains("<b>Won</b>") || row.innerHTML().contains("place</b>")) {
						onWon = true;
					}
					if(row.innerHTML().contains("<b>Nominated</b>")) {
						onWon = false;
					}
					if(onWon) continue;
					for(Element cell : row.findEvery("<td class=award_description>")) {

						if(cell.innerHTML().contains("Screenplay")) {
//							System.out.println(cell.getText());
//							System.out.println("----------------------");
							numNominations++;
						}
					}
				}
			}
			
			return numNominations;
		} catch(JauntException e) {
			return 0;
		}
	}
	
	public int screenWriterWins() {
		try {
			int numWins = 0;
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
			temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "awards");
			else temp.visit(userAgent.getLocation() + "awards");	
			for(Element table : temp.doc.findEvery("<table class=awards>")) {
				for(Element row : table.findEvery("<tr>")) {
					if(row.innerHTML().contains("<b>Nominated</b>") || row.innerHTML().contains("place</b>")) {
						break;
					}
					for(Element cell : row.findEvery("<td class=award_description>")) {
						if(cell.getText().contains("Screenwriter")) {
							//System.out.println(cell.getText());
							numWins++;
						}
					}
				}
			}
			
			return numWins;
		} catch(JauntException e) {
			return 0;
		}
	}
	
	public int screenWriterNominations() {
		try {
			int numNominations = 0;
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
			temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "awards");
			else temp.visit(userAgent.getLocation() + "awards");	
			boolean onWon = false;
			
			for(Element table : temp.doc.findEvery("<table class=awards>")) {
				for(Element row : table.findEvery("<tr>")) {
					if(row.innerHTML().contains("<b>Won</b>") || row.innerHTML().contains("place</b>")) {
						onWon = true;
					}
					if(row.innerHTML().contains("<b>Nominated</b>")) {
						onWon = false;
					}
					if(onWon) continue;
					for(Element cell : row.findEvery("<td class=award_description>")) {

						if(cell.innerHTML().contains("Screenwriter")) {
//							System.out.println(cell.getText());
//							System.out.println("----------------------");
							numNominations++;
						}
					}
				}
			}
			
			return numNominations;
		} catch(JauntException e) {
			return 0;
		}
	}
}
