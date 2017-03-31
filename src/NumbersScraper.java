
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
	
	public static boolean containsIgnoreCase(String str, String searchStr)     {
	    if(str == null || searchStr == null) return false;

	    final int length = searchStr.length();
	    if (length == 0)
	        return true;

	    for (int i = str.length() - length; i >= 0; i--) {
	        if (str.regionMatches(true, i, searchStr, 0, length))
	            return true;
	    }
	    return false;
	}
	
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
		System.out.println("in numbersSearch(), the name of the movie is:" + nameOfMovie);
		try{
		 if(nameOfMovie.contains(", the")) {
			 	System.out.println("in numbers scraper, the movieTitle contains ,the");
			  nameOfMovie = nameOfMovie.replace(", the",  "");
			  nameOfMovie = "the " + nameOfMovie;
		  }
		  if(nameOfMovie.contains(", a")) {
			  nameOfMovie = nameOfMovie.replace(", a", "");
			  nameOfMovie = "a " + nameOfMovie;
		  } if(nameOfMovie.contains(",")) {
			  nameOfMovie = nameOfMovie.replace(",", "");
		  } if(nameOfMovie.contains(":")) {
			  nameOfMovie = nameOfMovie.replace(":", "");
		  }
		  
			userAgent.visit("http://www.the-numbers.com/search?searchterm=" + nameOfMovie.replace(" ", "+"));
			System.out.println("user agent in numbersscraper is vising: " + "http://www.the-numbers.com/search?searchterm=" + nameOfMovie.replace(" ", "+") );
			
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

						//e1.printStackTrace();
					}
			}
			
			
			
			Elements potentialMovieLinks = movieSection.findEvery("<a>");
			for (Element e: potentialMovieLinks) {
				try {
					System.out.println("1.in Numbers Scraper, potential movie url:" +e.getAt("href"));
					System.out.println("2. In numbers scraper, e.getText(): " + e.getText());
					//to deal with movies with ",the" at the end
					System.out.println("3. In numbers scraper nameOfMovie.substring(0, nameOfMovie.length()-3)" + nameOfMovie.substring(0, nameOfMovie.length()-3));
					if(containsIgnoreCase(e.getText(), nameOfMovie) || containsIgnoreCase(e.getText(), nameOfMovie.substring(0, nameOfMovie.length()-3))) {
						userAgent.visit(e.getAt("href"));
						movieFound = true;
						System.out.println("movie was found");
						return true;
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
	
	public String getName() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<h1>")) {
				//System.out.println("element.getText():" + element.getText());
				  if(element.getAt("itemprop").contains("name")) {
					  //System.out.println("here2");
					  //System.out.println("The name of this movie is:" + element.getText());
					  return element.getText().substring(0, element.getText().length()-7);
				  }
			 }
		} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return "NOT LISTED";
	}
	
	public String getYear() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<h1>")) {
				//System.out.println("element.getText():" + element.getText());
				  if(element.getAt("itemprop").contains("name")) {
					  //System.out.println("here2");
					  //System.out.println("The name of this movie is:" + element.getText());
					  return element.getText().substring(element.getText().length()-5, element.getText().length()-1);
				  }
			 }
		} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return "NOT LISTED";
	}
}
