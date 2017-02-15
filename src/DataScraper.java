import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.jaunt.component.Form;
public class DataScraper {

	/**
	 * THIS CODE IS RESPONSBILE FOR ALL WEB SCRAPING
	 */


	String imdbBOWeekendRevenue; // done
	String imdbMetaScore; // done
	String imdbNumbCriticReviews; // done
	String imdbNumbReviews; // done
	String imdbNumbVotes; // done
	String imdbReleaseDate; // done
	String imdbProductionCompany; // done	
	String imdbBudget; // done	
	String imdbBOGross; // done	
	String imdbRating; // done
	String imdbNumbAwardsNominated; // done
	String imdbNumbAwardWins; // done
	String imdbCountryOfProduction; // done
	String imdbDirector; // done
	String imdbGenres; // done
	String imdbMpaa; // done	
	String imdbNumbOscarNominations; // done
	String imdbRunTime; // done
	String imdbStars; // done
	String imdbWriters; // done
	String imdbYear; // done
	String imdbNumbOscarWins; // done
	String imdbNumbGoldenGlobeNominations; // done
	String imdbNumbGoldenGlobeWins; // done
	String imdbBasedOnBook; //keywords in writers are novel or book
	int isNovel;
	int screenPlayWins;
	int screenPlayNominations;
	int screenWriterWins;
	int screenWriterNominations;
	
	// ROTTEN TOMATO VARIABLES
	
	String tomatoMeterRating;
	String tomatoAverageCriticRating;
	String tomatoNumberCriticVotes;
	String tomatoAudienceRating;
	String tomatoAudienceScore;
	String tomateAudienceUserRatings;
	
	// BOX OFFICE MOJO VARIABLES
	
	String mojoDomesticGross;
	String mojoForeignGross;
	String mojoWorldGross;
	String mojoWeekendRevenue;
	String mojoBudget;
	String mojoDistributors;
	String mojoNumbTheaters;
	String mojoRevPerTheater;
	String mojoPercTotalGross;
	
	String finalString;
	
	public void doPrimaryThree(String movieName, String[] info, boolean urlActive) {
		ImdbScraper imdb = null;
		TomatoScraper ts = null;
		MojoScraper ms = null;
		
		if(urlActive) {
			String imdbUrl = info[1];
			String mojoUrl = info[2];
			String tomatoUrl = info[3];
			
			imdb = new ImdbScraper(movieName, imdbUrl);
			ts = new TomatoScraper(movieName, tomatoUrl);
			ms = new MojoScraper(movieName, mojoUrl);
		} else {
			imdb = new ImdbScraper(movieName, info[0]);
			ts = new TomatoScraper(movieName, info[0]);
			ms = new MojoScraper(movieName, info[0]);
		}
		
		if(imdb.imdbSearch() == false) return;
		System.out.println("here1");
		if(ts.tomatoSearch() == false) return;
		System.out.println("here2");
		ms.mojoSearch();
		System.out.println("here3");
		String[] awards = imdb.getNumbAwards();
		imdbNumbAwardsNominated = awards[1];
		imdbNumbAwardWins = awards[0];
		imdbNumbOscarNominations = awards[3];
		imdbNumbOscarWins = awards[2];
		imdbNumbGoldenGlobeNominations = awards[5];
		imdbNumbGoldenGlobeWins = awards[4];
		imdbDirector = imdb.getDirector();
		imdbWriters = imdb.getWriters();
		imdbStars = imdb.getStars();
		imdbYear = imdb.getYear();
		imdbRunTime = imdb.getRunTime();
		imdbMpaa = imdb.getMpaa();
		imdbBOGross = imdb.getGross();
		imdbGenres = imdb.getGenres();
		imdbBudget = imdb.getBudget();
		imdbProductionCompany = imdb.getProductionCompanies();
		imdbReleaseDate = imdb.getReleaseDate();
		imdbRating = imdb.getRating();
		isNovel = imdb.basedOnNovel();
		screenPlayWins = imdb.screenPlayWins();
		screenPlayNominations = imdb.screenPlayNominations();
		screenWriterWins = imdb.screenWriterWins();
		screenWriterNominations = imdb.screenWriterNominations();
		
		
		tomatoMeterRating = ts.getTomatorMeterRating();
		if(ts.getAverageCriticRating() != null)
		tomatoAverageCriticRating = ts.getAverageCriticRating().replace("/10", "");
		else tomatoAverageCriticRating = null;
		tomatoNumberCriticVotes = ts.getNumberCriticReviews();
		if(ts.getAudienceScore() != null)
		tomatoAudienceScore = (Double.parseDouble(ts.getAudienceScore().replace("%", ""))/100) + "";
		else tomatoAudienceScore = null;
		if(ts.getAudienceRating() != null)
		tomatoAudienceRating = ts.getAudienceRating().replace("/5", "");
		else tomatoAudienceRating = null;
		if(ts.getNumberUserRatings() != null)
		tomateAudienceUserRatings = ts.getNumberUserRatings().replaceAll(",", "");
		else tomateAudienceUserRatings = null;
		mojoDomesticGross = ms.getMojoDomesticGross();
		mojoForeignGross = ms.getMojoForeignGross();
		mojoWorldGross = ms.getMojoWorldGross();
		mojoWeekendRevenue = ms.getMojoOpeningWeekendRevenue();
		mojoNumbTheaters = ms.getMojoNumbTheatres();
		mojoRevPerTheater = ms.getMojoRevPerTheatre();
		if(mojoWeekendRevenue.equals("NOT LISTED") || mojoWeekendRevenue.equals("MOVIE NOT FOUND") || mojoDomesticGross.equals("NOT LISTED") || mojoDomesticGross.equals("MOVIE NOT FOUND") || mojoDomesticGross == null)
		mojoPercTotalGross = "NOT ABLE TO CALCULATE";
		else mojoPercTotalGross = "" + (round((Double.parseDouble(mojoWeekendRevenue.replace("$", "").replace(",", ""))/Double.parseDouble(mojoDomesticGross.replace("$", "").replace(",", "")))*100, 2)/100);
		mojoBudget = ms.getBudget();
		mojoDistributors = ms.getDistributor();
		
		finalString = "~" + movieName + "~~" + imdbYear + "~" + imdbMpaa + "~" + imdbGenres + "~" + imdbReleaseDate + "~~~~~~USA~" +
		imdbRunTime + "~" + imdbRating + "~" + imdb.getVotes() + "~" + imdb.getMetaScore() + "~" + imdb.getUserReviews() + "~" + 
		imdb.getCriticReviews() + "~" + imdbNumbAwardWins + "~" + imdbNumbAwardsNominated + "~" + imdbNumbOscarNominations + 
		"~" + imdbNumbOscarWins + "~" + imdbNumbGoldenGlobeNominations + "~" + imdbNumbGoldenGlobeWins + "~" + imdbDirector + "~" +
		imdbWriters + "~" + imdbStars + "~" + imdbBudget + "~" + imdb.getWeekendRevenue() + "~" + imdbBOGross + "~" +
		imdbProductionCompany + "~~" + mojoDomesticGross + "~" + mojoForeignGross + "~" + mojoWorldGross + "~" + mojoWeekendRevenue +  "~" + mojoNumbTheaters + "~" + mojoRevPerTheater + "~" + mojoPercTotalGross + "~" + mojoBudget + "~" + mojoDistributors + "~" + ts.getTomatorMeterRating() + "~" + ts.getAverageCriticRating() + "~" +
		tomatoNumberCriticVotes + "~" + tomatoAudienceScore + "~" + tomatoAudienceRating + "~" + tomateAudienceUserRatings + "~" + isNovel + "~" + screenPlayWins + "~" + screenPlayNominations + "~" + screenWriterWins + "~" + screenWriterNominations;
		
		finalString = finalString.replaceAll("$", "");
	}


	public void doNumbersCom(String movieName, String writers, boolean urlActive) throws ParseException {
		
		UserAgent userAgent = new UserAgent();
		
		//userAgent.visit("http://www.imdb.com/search/title?title=" + nameOfMovie.replace(" ", "%20").replace(":", "%3A") + "&title_type=feature");
		try {
			if(!urlActive) {
			
				//System.out.println(writers);
				if(movieName.length() > 5 && movieName.toLowerCase().substring(movieName.length() - 5).contains(", the")) {
					movieName = movieName.toLowerCase().replace(", the", "");
					movieName = "the " + movieName;
				}
				
				if(movieName.length() > 3 && movieName.toLowerCase().substring(movieName.length() - 3).contains(", a")) {
					movieName = movieName.toLowerCase().replace(", a", "");
					movieName = "a " + movieName;
				}
				
				movieName = movieName.toLowerCase();
				
				userAgent.visit("http://the-numbers.com");
				userAgent.doc.getForm(0).apply(movieName);
				userAgent.doc.getForm(0).submit();
				
				Element resultsTable = null;
				for(Element charts : userAgent.doc.findEvery("<div id=page_filling_chart>")) {
					
					if(charts.innerHTML().contains("<table>")) {
						resultsTable = charts.findFirst("table");
					}
					
				}
				
				if(resultsTable == null) {
					return;
				}
				
				System.out.println(movieName);
				
				boolean found = false;
				
				for(Element searchResult : resultsTable.findEvery("<a>")) {
					String newUrl = searchResult.getAt("href").replace("tab=summary", "tab=cast-and-crew");
					userAgent.visit(newUrl);
					String[] arrayOfWriters= writers.split(",");
					for(Element castDivs : userAgent.doc.findEvery("div id=cast")) {
						if(castDivs.innerHTML().contains("Production and Technical")) {
							Element productTable = castDivs.findFirst("table");
							for(String writer : arrayOfWriters) {
								if(productTable.innerHTML().toLowerCase().contains(writer.toLowerCase())) {
									//System.out.println("For movie: " + movieName + "....the writer found is: " + writer);
									found = true;
									break;
								}
							}
							if(found == true) break;
						}
					}
					if(found == true) {
						break;
					}
	
				}
				
				if(found == false) {
					userAgent.visit("http://the-numbers.com");
					userAgent.doc.getForm(0).apply(movieName);
					userAgent.doc.getForm(0).submit();
	
					for(Element searchResult  : resultsTable.findEvery("<a>")) {
						//System.out.println(searchResult.innerText().toLowerCase() + " - " + movieName);
						if(searchResult.innerText().toLowerCase().equals(movieName)) {
							userAgent.visit(searchResult.getAt("href"));
							//System.out.println("For movie: " + movieName);
							found = true;
							break;
						}
					}
					
				}
				
				if(found == false) {
					return;
				}
			}
			
			
			else userAgent.visit(writers);
			//IF YOU GET TO THIS POINT, THE MOVIE WAS FOUND


			
			//ALL FOR NUMBERS.COM
			String weekendDate = null;
			String weekendRank = null;
			String weekendGross = null;
			String weekendTheaters = null;
			String weekendTotalGross = null;
			String weekendDays = null;
			
			String weeklyDate = null;
			String weeklyRank = null;
			String weeklyGross = null;
			String weeklyTheaters = null;
			String weeklyTotalGross = null;
			String weeklyDays = null;
			
			System.out.println(userAgent.getLocation());
			
			String year = userAgent.doc.findFirst("<h1 itemprop=name>").getText();
			year = year.substring(year.indexOf(" (") + 2, year.indexOf(")"));
			
			ArrayList<String> tableLines = new ArrayList<String>();
			
			if(!userAgent.getLocation().contains("tab=box-office")) {
				if(userAgent.getLocation().contains("tab=summary")) {
					userAgent.visit(userAgent.getLocation().replace("tab=summary", "tab=box-office"));
				}
				if(userAgent.getLocation().contains("tab=cast-and-crew")) {
					userAgent.visit(userAgent.getLocation().replace("tab=cast-and-crew", "tab=box-office"));
				}
			}
			
			int tableNumb = 1;
			
			int arrayListIndex = 0;
			
			for(Element tables : userAgent.doc.findFirst("div id=box-office").findEvery("table")) {
				if(tableNumb == 1) {
					
					for(Element rows : tables.findEvery("tr")) {
						if(rows.innerHTML().contains("<TH>")) {
							continue;
						}
						int cellIndex = 0;
						for(Element cells : rows.findEvery("td")) {
							
							if(cellIndex == 0) {
								//System.out.println(cells.innerText());
								weekendDate = cells.findFirst("a").innerText();
							}
							if(cellIndex == 1) weekendRank = cells.getText();
							if(cellIndex == 2) weekendGross = cells.getText().replace("$", "").replaceAll(",", "");
							if(cellIndex == 4) weekendTheaters = cells.getText().replaceAll(",", "");
							if(cellIndex == 6) weekendTotalGross = cells.getText().replace("$", "").replaceAll(",", "");
							if(cellIndex == 7) weekendDays = cells.getText();
							cellIndex++;
						}
						
						String lineString = movieName + "~" + year + "~" + weekendDate + "~" + weekendRank + "~" + weekendGross + "~" + weekendTheaters + "~" + weekendTotalGross.replaceAll("&nbsp;", "") + "~" + weekendDays;
						tableLines.add(lineString);
						
						//System.out.println(movieName + "here");
						
					}
					
				}
				
				if(tableNumb == 3 || (tableNumb == 2 && userAgent.doc.findFirst("div id=box-office").findEvery("table").size() == 2)) {
					
					for(Element rows : tables.findEvery("tr")) {
						if(rows.innerHTML().contains("<TH>")) {
							continue;
						}
						int cellIndex = 0;
						for(Element cells : rows.findEvery("td")) {
							
							if(cellIndex == 0) weeklyDate = cells.findFirst("a").innerText();
							if(cellIndex == 1) weeklyRank = cells.getText();
							if(cellIndex == 2) weeklyGross = cells.getText().replace("$", "").replaceAll(",", "");
							if(cellIndex == 4) weeklyTheaters = cells.getText().replaceAll(",", "");
							if(cellIndex == 6) weeklyTotalGross = cells.getText().replace("$", "").replaceAll(",", "");
							if(cellIndex == 7) weeklyDays = cells.getText();
							cellIndex++;
						}
	
						for(int i = 0; i < tableLines.size(); i++) {
							DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
							Date date1 = df.parse(tableLines.get(i).split("~")[2]);
							Date date2 = df.parse(weeklyDate);
							
							if(date1.compareTo(date2) == 0) {
								tableLines.set(i, tableLines.get(i) + "~" + weeklyRank + "~" + weeklyGross + "~" + weeklyTheaters + "~" + weeklyTotalGross.replaceAll("&nbsp;", "") + "~" + weeklyDays);
								break;
							} else if(arrayListIndex == 0 && date1.compareTo(date2) > 0) {
								//System.out.println(date1 + " - " + date2);
								tableLines.set(0, movieName + "~" + year + "~" + weeklyDate + "~~~~~~" + weeklyRank + "~" + weeklyGross + "~" + weeklyTheaters + "~" + weeklyTotalGross.replaceAll("&nbsp;", "") + "~" + weeklyDays);
								arrayListIndex++;
								break;
							} else if(arrayListIndex == (tableLines.size() - 1) && date1.compareTo(date2) < 0) {
								tableLines.add(movieName + "~" + year + "~" + weeklyDate + "~~~~~~" + weeklyRank + "~" + weeklyGross + "~" + weeklyTheaters + "~" + weeklyTotalGross.replaceAll("&nbsp;", "") + "~" + weeklyDays);
								arrayListIndex++;
								break;
							}
							
						}
						
					}
					
				}
				tableNumb++;
			}
			
			for(int i = 0; i < tableLines.size(); i++) {
				if(i == tableLines.size() - 1) {
					finalString += tableLines.get(i);
					break;
				}
				//System.out.println(tableLines.get(i));
				finalString += tableLines.get(i) + "\n";
			}
		
		} catch (JauntException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doStarPower(String movieName, String writers, boolean urlActive) {
		try {
			
			System.out.println("here1");
			ImdbScraper imdb = new ImdbScraper(movieName, writers);
			
			if(urlActive) {
				imdb = new ImdbScraper(movieName, writers);
			}
			
			System.out.println("here2");
			
			if(imdb.imdbSearch() == false) {
				finalString = "\n";
				return;
			}
			
			System.out.println("here3");
			
			ArrayList<String> starUrls = imdb.getStarsUrls();
			
			if(starUrls == null) {
				return;
			}
			
			System.out.println("here4");
			
			UserAgent agent = new UserAgent();
			
			if(movieName.length() > 5 && movieName.toLowerCase().substring(movieName.length() - 5).contains(", the")) {
				movieName = movieName.toLowerCase().replace(", the", "");
				movieName = "the " + movieName;
				System.out.println("here5");
			}
			
			if(movieName.length() > 3 && movieName.toLowerCase().substring(movieName.length() - 3).contains(", a")) {
				movieName = movieName.toLowerCase().replace(", a", "");
				movieName = "a " + movieName;
				System.out.println("here6");
			}
			
			movieName = movieName.toLowerCase();
			
			for(int i = 0; i < starUrls.size(); i++) {
				System.out.println("------------------------");
				agent.visit(starUrls.get(i));
				
				Element movieSection = agent.doc.findFirst("div class=filmo-category-section");
				
				boolean found = false;
				int index = 0;
				
				for(Element element : movieSection.findEvery("div")) {
					if(element.innerHTML().contains("(Video)") || element.innerHTML().contains("(TV Series documentary)") || element.innerHTML().contains("(TV Series)") || element.innerHTML().contains("(TV Movie)") || element.innerHTML().contains("(Video Game)") || element.innerHTML().contains("(TV Short)") || element.innerHTML().contains("(Video short)") || element.innerHTML().contains("(TV Mini-Series)") || element.innerHTML().contains("(Short)")) {
						continue;
					}
					if(!element.innerHTML().contains("year_column")) {
						continue;
					}
					//System.out.println(imdb.getStars().split(",")[i] + ": " + element.findFirst("a").getText());
					if(found == true) {
						if(index > 10) break;
						//System.out.println(element.findFirst("a").getAt("href"));
						ImdbScraper tempScraper = new ImdbScraper(movieName, element.findFirst("a").getAt("href"));
						tempScraper.imdbSearch();
						String actor = imdb.getStars().split(",")[i];
						String gross = tempScraper.getGross();
						String budget = tempScraper.getBudget();
						String year = tempScraper.getYear();
						
						String subFinalString = movieName + "~" + imdb.getYear() + "~" + actor + "~" + element.findFirst("a").getText() + "~" + year + "~" + gross.replaceAll("$", "").replaceAll(",", "") + "~" + budget.replaceAll("$", "").replaceAll(",", "");
						
						finalString += subFinalString + "\n";
						
						index++;
					} else {
						if(element.findFirst("a").getText().toLowerCase().contains(movieName)) {
							//System.out.println(starUrls.get(i));
							//System.out.println("------------------------");
							found = true;
						}
					}
				}
				
				//
				
			}

		} catch(JauntException e) {
			
		}
	}

	public DataScraper(String movieName, String writers, String string2, String string3) {
		

		
		// TODO Auto-generated constructor stub
	}
	
	public DataScraper() {
		
	}
	
	public void doDirectorPower(String movieName, String writers) {

		
		//movieName = movieName.toLowerCase();
		
		try {
			
			ImdbScraper s = null;
			
			s = new ImdbScraper(movieName, writers);
			
			if(s.imdbSearch() == false) {
				return;
			}
			
			if(movieName.length() > 5 && movieName.toLowerCase().substring(movieName.length() - 5).contains(", the")) {
				movieName = movieName.toLowerCase().replace(", the", "");
				movieName = "the " + movieName;
			}
			
			if(movieName.length() > 3 && movieName.toLowerCase().substring(movieName.length() - 3).contains(", a")) {
				movieName = movieName.toLowerCase().replace(", a", "");
				movieName = "a " + movieName;
			}
			
			movieName = movieName.toLowerCase();
			
			UserAgent userAgent = new UserAgent();
			

			
			finalString = "";
			
			ArrayList<String> directorUrls = s.getDirectorUrls();
			if(directorUrls == null) {
				return;
			}
			
			for(String directorLink : directorUrls) {
				
				userAgent.visit(directorLink);
				
				Element filmographyBlock = null;
				
				for(Element divs : userAgent.doc.findEvery("<div class=filmo-category-section>")) {
					if(divs.innerHTML().contains("director-")) {
						filmographyBlock = divs;
						System.out.println("here");
						break;
					} else continue;
				}
				
				if(filmographyBlock == null) {
					finalString = "\n";
					return;
				}
				
				//Element filmographyBlock = userAgent.doc.findFirst("<div class=filmo-category-section>");

				
//				for(int i = 0; i < filmographyBlock.findEvery("<div>").size(); i++) {
//					if(i == 0) continue;
//					
//					Element directorMoviesBlock = filmographyBlock.findEvery("<div>").getElement(i);
//					
					boolean currentMovieFound = false;
					int index = 0;
					
					for(Element movieDivider : filmographyBlock.findEvery("<div>")) {
						if(movieDivider.innerHTML().contains("(Video)") || movieDivider.innerHTML().contains("(TV Series documentary)") || movieDivider.innerHTML().contains("(TV Series)") || movieDivider.innerHTML().contains("(TV Movie)") || movieDivider.innerHTML().contains("(Video Game)") || movieDivider.innerHTML().contains("(TV Short)") || movieDivider.innerHTML().contains("(Video short)") || movieDivider.innerHTML().contains("(TV Mini-Series)") || movieDivider.innerHTML().contains("(Short)")) {
							continue;
						}
						if(!movieDivider.innerHTML().contains("year_column")) {
							continue;
						}
						if(currentMovieFound == true) {
							if(index == 10) break;
							ImdbScraper tempScraper = new ImdbScraper(movieName, movieDivider.findFirst("a").getAt("href"));
							tempScraper.imdbSearch();
							String director = s.getDirector();
							String gross = tempScraper.getGross();
							String budget = tempScraper.getBudget();
							String year = tempScraper.getYear();
							
							
							String subFinalString = movieName + "~" + s.getYear() + "~" + director + "~" + movieDivider.findFirst("a").getText() + "~" + year + "~" + gross.replaceAll("$", "").replaceAll(",", "") + "~" + budget.replaceAll("$", "").replaceAll(",", "");
							
							finalString += subFinalString + "\n";
							
							index++;
							
							
						} else {
							//System.out.println("Paramter movie: " + movieName + " --- Imdb Movie Name: " + movieDivider.findFirst("a").getText().toLowerCase());
							if(movieDivider.findFirst("<a>").getText().toLowerCase().contains(movieName)) {
								//System.out.println("match found");
								currentMovieFound = true;
							}
						}
					}
					
				}
//				
//			}
		
		}
		catch(JauntException e) {
			
		}
	}




	private double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	public String getFinal() {
		return finalString;
	}
	

	
}