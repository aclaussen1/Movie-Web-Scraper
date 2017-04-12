
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
		  //System.out.println(x);
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
			if (nameOfMovie.equalsIgnoreCase("nashville")) {
				  				  movieFound=false;
				  return false;
			  } else if (nameOfMovie.equalsIgnoreCase("Marley & Me")) {
				  userAgent.visit("http://www.the-numbers.com/movie/Marley-and-Me#tab=summary");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("lost horizon")) {
				 
				  
				  movieFound=false;
				  return false;
			  }else if (nameOfMovie.equalsIgnoreCase("all the king's men")) {
				  return false;
			  } else if (nameOfMovie.equalsIgnoreCase("fantastic mr fox")) {
				  userAgent.visit("http://www.the-numbers.com/movie/Fantastic-Mr-Fox-The#tab=summary");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("http://www.the-numbers.com/movie/9#tab=summary");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("little athens")) {
				  movieFound=false;
				  return false;
			  } else if (nameOfMovie.equalsIgnoreCase("pokemon: mewtwo returns")) {
				  movieFound=false;
				  return false;
			  }else if (nameOfMovie.equalsIgnoreCase("sweeney todd: the demon barber of fleet street")) {
				  userAgent.visit("http://www.the-numbers.com/movie/Sweeney-Todd-The-Demon-Barber-of-Fleet-Street#tab=summary");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("my mother dreams the satan's disciples in new york")) {
				  movieFound=false;
				  return false;
			  }else if (nameOfMovie.equalsIgnoreCase("cowboys & aliens")) {
				  userAgent.visit("http://www.the-numbers.com/movie/Cowboys-and-Aliens#tab=summary");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("frankenstein")) {
				  userAgent.visit("http://www.the-numbers.com/movie/Frankenstein-(1994)#tab=summary");
				  movieFound=false;
				  return false;
			  }else if (nameOfMovie.equalsIgnoreCase("arctic blue")) {
				  
				  movieFound=false;
				  return false;
			  } else if (nameOfMovie.equalsIgnoreCase("blade: trinity")) {
				  userAgent.visit("http://www.the-numbers.com/movie/Blade-Trinity#tab=summary");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("conan the barbarian")) {
				  userAgent.visit("http://www.the-numbers.com/movie/Conan#tab=summary");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("ringu")) {
				  movieFound=false;
				  return false;
			  }else if (nameOfMovie.equalsIgnoreCase("a dry white season")) {
				  movieFound=false;
				  return false;
			  } else if (nameOfMovie.equalsIgnoreCase("death at a funeral")) {
				  userAgent.visit("http://www.the-numbers.com/movie/Death-at-a-Funeral-(2010)#tab=summary");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bodyguard")) {
				  userAgent.visit("http://www.the-numbers.com/movie/Bodyguard-The#tab=summary");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("august: osage county")) {
				  userAgent.visit("http://www.the-numbers.com/movie/August-Osage-County#tab=summary");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("https://www.rottentomatoes.com/search/?search=9");
				  System.out.println("found the movie 9 on rotten tomato");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("https://www.rottentomatoes.com/search/?search=9");
				  System.out.println("found the movie 9 on rotten tomato");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("https://www.rottentomatoes.com/search/?search=9");
				  System.out.println("found the movie 9 on rotten tomato");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("https://www.rottentomatoes.com/search/?search=9");
				  System.out.println("found the movie 9 on rotten tomato");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("https://www.rottentomatoes.com/search/?search=9");
				  System.out.println("found the movie 9 on rotten tomato");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("https://www.rottentomatoes.com/search/?search=9");
				  System.out.println("found the movie 9 on rotten tomato");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("https://www.rottentomatoes.com/search/?search=9");
				  System.out.println("found the movie 9 on rotten tomato");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("https://www.rottentomatoes.com/search/?search=9");
				  System.out.println("found the movie 9 on rotten tomato");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  }
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
		System.out.println("in numbersScraper, nameOfMovie variable:" + nameOfMovie);
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<a>")) {
				//System.out.println("NumbersScraper, inside getGenres():element.getText():" + element.getText());
				if(element.getAt("href").contains("genre") && !element.getAt("href").contains("record")) {
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
