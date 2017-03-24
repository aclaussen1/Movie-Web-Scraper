
import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class NumbersScraper {
	String nameOfMovie;
	UserAgent userAgent;
	boolean movieFound = false;
	String movieWriters;
	
	public NumbersScraper(String movieName, String writers) {
		nameOfMovie = movieName;
		  userAgent = new UserAgent();
		movieWriters = writers;
	}
	
	public NumbersScraper(String movieName, String numbersURL, boolean fakeVariable) {
		nameOfMovie = movieName;
		  userAgent = new UserAgent();
		  try {
			userAgent.visit(numbersURL);
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  movieFound = true;
	}
	
	public boolean numbersSearch() {
		try{
		 if(nameOfMovie.contains(", The")) {
			  nameOfMovie = nameOfMovie.replace(", The",  "");
			  nameOfMovie = "The " + nameOfMovie;
		  }
		  if(nameOfMovie.contains(", A")) {
			  nameOfMovie = nameOfMovie.replace(", A", "");
			  nameOfMovie = "A " + nameOfMovie;
		  } if(nameOfMovie.contains(",")) {
			  nameOfMovie = nameOfMovie.replace(",", "");
		  } if(nameOfMovie.contains(":")) {
			  nameOfMovie = nameOfMovie.replace(":", "");
		  }
		  
			userAgent.visit("http:/http://www.the-numbers.com/search?searchterm==" + nameOfMovie.replace(" ", "+"));
			
			
			/*
			 * There are two <table> sections on theNumbers search result pages. The purpsoe of this code block is to get to the one that we care about.
			 */
			Elements potentialMovieSections = userAgent.doc.findEvery("<table>");
			Element movieSection = null;
			for (Element e: potentialMovieSections) {

					try {
						if(e.findFirst("<th>").getText().contains("Match")) {
							movieSection = e;
						}
					} catch (NotFound e1) {

						e1.printStackTrace();
					}
			}
			
			
			
			Elements potentialMovieLinks = movieSection.findEvery("<a>");
			for (Element e: potentialMovieLinks) {
				try {
					System.out.println(e.getAt("href"));
					if(e.getAt("href").contains("movie")) {
						userAgent.visit(e.getAt("href"));
					}
				} catch (NotFound e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			
			
				
			

		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public String getGenres() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<a>")) {
				//System.out.println("element.getText():" + element.getText());
				  if(element.getAt("href").contains("genre")) {
					  //System.out.println("here2");
					  System.out.println("genre:" + element.getText());
					  return element.getText();
				  }
			 }
		} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return "NOT LISTED";
	}
}
