import com.jaunt.Element;
import com.jaunt.JauntException;
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
		  userAgent = new UserAgent();
		  movieWriters = writers;
	}
	
	public boolean tomatoSearch() {
		try{

			if(movieWriters.contains("http")) {
				userAgent.visit(movieWriters);
				return true;
			}
			  if(nameOfMovie.contains("The ")) {
				  nameOfMovie = nameOfMovie.replace("The ",  "");
			  }
			  userAgent.visit("https://www.rottentomatoes.com/search/?search=" + nameOfMovie.replace(" ", "%20"));
			  //System.out.println("RT: " + userAgent.getLocation());
			  //if(!userAgent.getLocation().contains("/m/"))
			  //userAgent.visit(userAgent.doc.findFirst("<div id=results_movies_tab>").findFirst("<a>").getAt("href"));
			  //userAgent.visit(userAgent.doc.findFirst("<table class=\"results\">").findFirst("<tr class=\"even detailed\">").findFirst("<a>").getAt("href"));
			  //System.out.println(userAgent.getLocation());
			  Element resultsDiv = userAgent.doc.findFirst("<section id=SummaryResults>");
			  //System.out.println("here");
			  for(Element element : resultsDiv.findEvery("<a>")) {
					System.out.println("here");
				  //System.out.println(element.getText() + " - " + nameOfMovie);
				  //System.out.println("ROTTEN TOMATOES Movie: " + element.getText().replace("The ", "") + " - OUR Movie: " + nameOfMovie.replace(", The", "").replace(", A",  ""));
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
