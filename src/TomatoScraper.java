import com.jaunt.Element;

import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jaunt.component.Form;

public class TomatoScraper {
	
	/**
	 * THIS IS THE CLASS USED FOR ROTTEN-TOMATOES SCRAPING
	 */
	
	String nameOfMovie;
	UserAgent userAgent;
	boolean movieFound = true;
	String movieWriters;
	
	public TomatoScraper(String movieName, String writers) {
		nameOfMovie = movieName;
		System.out.println("last 3 letters of movie name:" + nameOfMovie.substring(nameOfMovie.length()-3,nameOfMovie.length()));
		if (nameOfMovie.substring(nameOfMovie.length()-3,nameOfMovie.length()).equalsIgnoreCase("the")) {
			//System.out.println(nameOfMovie+ ": this movie starts with the");
			nameOfMovie = "the " + nameOfMovie.substring(0, nameOfMovie.length()-5);
			System.out.println("The name of the movie now is:" + nameOfMovie);
		}
		  userAgent = new UserAgent();
		  movieWriters = writers;
	}
	
	public boolean tomatoSearch() {
		 String nameOfMovieWithoutSpaces = nameOfMovie.replace(" ", "%20");
		 
		
		try{
			if (nameOfMovie.equalsIgnoreCase("Fantastic Mr Fox")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1197696_fantastic_mr_fox");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Marley & Me")) {
				  userAgent.visit("//www.rottentomatoes.com/m/marley_and_me/");
				  movieFound=true;
				  return true;
			  }
			  else if(movieWriters.contains("http")) {
				userAgent.visit(movieWriters);
				return true;
			  }
			  
			  nameOfMovieWithoutSpaces = nameOfMovie.replace(" ", "%20");
			  System.out.println("TomatoScaper is visiting this url: " + "https://www.rottentomatoes.com/search/?search=" + nameOfMovieWithoutSpaces.replace("the", ""));
			  
			  try {
			  userAgent.visit("https://www.rottentomatoes.com/search/?search=" + nameOfMovieWithoutSpaces.replace("the", ""));
			  } catch (Exception e) {
				  System.out.println("here32.");
			  }
			  
			  //System.out.println("RT: " + userAgent.getLocation());
			  //if(!userAgent.getLocation().contains("/m/"))
			  //userAgent.visit(userAgent.doc.findFirst("<div id=results_movies_tab>").findFirst("<a>").getAt("href"));
			  //userAgent.visit(userAgent.doc.findFirst("<table class=\"results\">").findFirst("<tr class=\"even detailed\">").findFirst("<a>").getAt("href"));
			  //System.out.println(userAgent.getLocation());
			  

			  for(Element element : userAgent.doc.findEvery("<script>")) {
				if (element.getText().contains("require(['jquery', 'globals', 'search-results', 'bootstrap'],")) {
					
				}
				  //System.out.println("element.getText in Tomato Scraper: " + element.getText() + );
				  
				  if (element.getText().contains("mount($(")) {
					  //System.out.println("ROTTEN TOMATOES Movie: " + element.getText() + " - OUR Movie: " + nameOfMovie.replace(", The", "").replace(", A",  ""));
					  
					  /*
					   * In the HTML document for tomato, it looks like this for the search results:
					   *  require(['jquery', 'globals', 'search-results', 'bootstrap'], function($, RT, mount) {
                            mount($("#search-results-root").get(0), RT.PrivateApiV2FrontendHost, 'ides of march,', {"actorCount":0,"criticCount":0,"franchiseCount":0,"movieCount":1,"movies":[{"name":"The Ides of March","year":2011,"url":"/m/the_ides_of_march","image":"https://resizing.flixster.com/MHDjhbdL6eNXRkiVjU21HesDKzM=/fit-in/80x80/v1.bTsxMTE2Mzc2OTtqOzE3MzE5OzEyMDA7NjQwOzk2MA","meterClass":"certified_fresh","meterScore":84,"castItems":[{"name":"Ryan Gosling","url":"/celebrity/ryan_gosling"},{"name":"George Clooney","url":"/celebrity/george_clooney"},{"name":"Philip Seymour Hoffman","url":"/celebrity/philip_seymour_hoffman"}],"subline":"Ryan Gosling, George Clooney, Philip Seymour Hoffman, "}],"tvCount":0});
                        });
                        We want to isolate the JSON data. The JSON data begins at the second "{".
                        the int i is the index of the first occurance of "{", i2 is the second occurence.
					   */
					  
					  int i = element.getText().indexOf("{");
					  int i2 = element.getText().indexOf("{",i+1
							  );
					  int ending = element.getText().indexOf(");");
					  String JSONstring = element.getText().substring(i2, ending);
					  System.out.println("JSONSTRING: " + JSONstring);
					  
					  JSONObject obj = new JSONObject(JSONstring);
					  JSONArray arr = obj.getJSONArray("movies");
					  for (int j = 0; j < arr.length(); j++)
					  {
					      String JSONmovieName = arr.getJSONObject(j).getString("name");
					      System.out.println("tomato search generated this movie name:" + JSONmovieName);
					      if (JSONmovieName.equalsIgnoreCase(nameOfMovie)) {
					    	  System.out.println("User agent is visiting:https://www.rottentomatoes.com" + arr.getJSONObject(j).getString("url"));
					    	  userAgent.visit("https://www.rottentomatoes.com" + arr.getJSONObject(j).getString("url"));
					    	  movieFound=true;
							  return true;
					      }
					  }
				  }
				  if(element.getText().replace("The ", "").contains(nameOfMovie.replace(", The", "").replace(", A", ""))) {
					  userAgent.visit(element.getAt("href"));
					  
					  boolean found = false;
					  //System.out.println(userAgent.getLocation());
					  for(Element element2 : userAgent.doc.findEvery("<div>")) {
						  if(found == true) {
							  for(Element element3 : element2.findEvery("<span>")) {
								  if(movieWriters.replaceAll("[^a-zA-Z ]", "").toLowerCase().contains(element3.getText().replaceAll("[^a-zA-Z ]", "").toLowerCase())) {
									  //System.out.println("MOVIE MATCH Tomato");
									  return true;
								  }
							  }
							  break;
						  }
						  if(element2.getText().contains("Written By")) {
							  found = true;
							  continue;
						  }
					  }
					  continue;
				  }
			  }
			  System.out.println(userAgent.getLocation());
			  return false;
			}
			catch(JauntException e){ 
				try {
					System.out.println("Visiting: " + userAgent.visit("https://www.rottentomatoes.com/m/" + nameOfMovie.replace(" ",  "_")));
					movieFound = true;
					userAgent.visit("https://www.rottentomatoes.com/m/" + nameOfMovie.replace(" ",  "_"));
					movieFound = true;
				}
				catch(JauntException e2) {
					movieFound = false;
				}

			}
		return false;
	}
	
	public String getTomatorMeterRating() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<span>")) {
				  if(element.innerHTML().contains("<span>")) {
					  return element.findFirst("<span>").getText();
				  }
			 }
			return "";
		} else return null;
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getTomatoYear()  {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try{
			return userAgent.doc.findFirst("<time").getText();
		} catch(JauntException e) {
			
		} 
		return "NOT LISTED";
	}
	
	public String getAverageCriticRating() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {
			if(userAgent.doc.findFirst("<div class=superPageFontColor>").getText().contains("/"))
			return userAgent.doc.findFirst("<div class=superPageFontColor>").getText().trim();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getAudienceScore() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {
			int index = 0;
			return userAgent.doc.findFirst("<div class=meter-value>").findFirst("<span>").getText();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getNumberCriticReviews() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {
			int index = 0;
			for(Element e : userAgent.doc.findEvery("<div class=superPageFontcolor>")) {
				if(index == 1) {
					int index2 = 0;
					for(Element e2 : e.findEvery("<span>")) {
						if(index2 == 1) {
							return e2.getText();
						}
						index2++;
					}
				}
				index++;
			}
//		} catch(JauntException e) {
//			
//		}
		return null;
	}
	
	public String getAudienceRating() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {
			for(Element e : userAgent.doc.findEvery("<div>")) {
				if(e.innerHTML().contains("Average")) {
					if(e.getText().contains("/5")) {
						return e.getText().trim();
					}
				}
			}
//		} catch(JauntException e) {
//			
//		}
		return null;
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
	
}
