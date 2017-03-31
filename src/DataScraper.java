import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

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
		try {
		imdbDirector = imdb.getDirector();
		} catch (Exception e) {
			
		}
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
	
	public void MovieCountryMarch14Report(String movieName, String imdbURL, String movieWriters) {
		System.out.println("working on movie:" + movieName + " with imdbURL: "  + imdbURL);
		/*
			//movies to exclude
			if ( !(movieName.contains("Nightmare on") || movieName.contains("nightmare on") || movieName.contains("Adaptation") || movieName.contains("Arctic")) ) {
				finalString = "";
				return;
			}
			
		*/ 
		
		/*
		if (!(movieName.contains("Matrix")  )) {
			finalString = "";
			return;
		}
		*/
		/*
		if (!(movieName.contains("9")  )) {
			finalString = "";
			return;
		}
		
		*/
			
			System.out.println("made it here");
		try {
			
			System.out.println("moviename:" + movieName + " imdbURL: " + imdbURL);
			String countryInfo="";
			
			ImdbScraper imdb;
			if (imdbURL== null) {
				imdb = new ImdbScraper(movieName, movieWriters);
				imdb.imdbSearch();
			}
			else {
				imdb = new ImdbScraper(movieName, imdbURL, true);
			}
		
			String imdbCountry = "";

			try {
				imdbCountry = imdb.getCountry();
				System.out.println("imdbSearch returned true. imdbYear:" + imdbCountry);
			} catch (Exception e){
				System.out.println("could not find country info from imdb");
			
			}

			
			
			
			/*
			if (imdbCountry.equalsIgnoreCase("")); {
				MojoScraper mojo = new MojoScraper(movieName, BoxOfficeURL, true);
			
			
				String mojoCountry = mojo.getMojoCountry();
			}
			*/
			
			
			int USA = 0;
			if (imdbCountry.contains("USA")) {
				USA = 1;
			}
			
			
			finalString += movieName +  "~" + imdbCountry + "~" + USA + "\n";
			System.out.println("finalString for " + movieName + ": " + finalString);
			
		} catch (Exception e) {
			
		}
	}
	
	public void doMovieTitlesAndYears(String movieName, String writers, boolean urlActive) {
			
		/*
			//movies to exclude
			if ( !(movieName.contains("Nightmare on") || movieName.contains("nightmare on") || movieName.contains("Adaptation") || movieName.contains("Arctic")) ) {
				finalString = "";
				return;
			}
			
		*/ 
		
		/*
		if (!(movieName.contains("Matrix")  )) {
			finalString = "";
			return;
		}
		*/
		/*
		if (!(movieName.contains("9")  )) {
			finalString = "";
			return;
		}
		
		*/
			
			System.out.println("made it here");
		try {
			
			System.out.println("moviename:" + movieName + " writers: " + writers);
			ImdbScraper imdb = new ImdbScraper(movieName, writers);
			
			System.out.println("is urlActive:" + urlActive);
			if(urlActive) {
				imdb = new ImdbScraper(movieName, writers);
			}
		
			String imdbYear = "";

			if(imdb.imdbSearch() == false) {
				System.out.println("imdbSearch returned false. it failed");
				//finalString = "\n";
				
			}
			else {
			
			imdbYear = imdb.getYear();
			System.out.println("imdbSearch returned true. imdbYear:" + imdbYear);
			}

			UserAgent agent = new UserAgent();
			
			
			
			movieName = movieName.toLowerCase();
			
			
			
			
			MojoScraper mojo = new MojoScraper(movieName, writers);
			
			if(mojo.mojoSearch() == false) {
				System.out.println("mojoSearch returned false. it failed");
				//finalString = "\n";
				//return;
			}
			
			
			String mojoYear = mojo.getMojoYear();
			
			/*
			if (!mojoYear.equalsIgnoreCase("MOVIE NOT FOUND")){
					mojoYear = mojoYear.substring(mojoYear);
			}
			*/
			
			if (!mojoYear.equalsIgnoreCase("not listed") && !mojoYear.equalsIgnoreCase("movie not found")) {
				mojoYear = mojoYear.substring(mojoYear.length()-4,mojoYear.length());
			}
			System.out.println("mojoYear: " + mojoYear);
			
			TomatoScraper tomato = new TomatoScraper(movieName, writers);
			if(tomato.tomatoSearch() == false) {
				System.out.println("tomatoSearch returned false. it failed");
				//finalString = "\n";
				//return;
			} else {
				System.out.println("tomatoSearch returned true");
			}
			String tomatoYear = "";
			try {
			tomatoYear = tomato.getTomatoYear();
			} catch (Exception e) {
				System.out.println("getTomatoYear() failed");
			}
			if (!(tomatoYear.equalsIgnoreCase("NOT LISTED") || tomatoYear.equalsIgnoreCase("MOVIE NOT FOUND"))){
				tomatoYear = tomatoYear.substring(tomatoYear.lastIndexOf(' ') + 1);
			}
			System.out.println("tomatoYear: " + tomatoYear);
			
			NumbersScraper n;
			String numbersYear = "";
			
				try {
					n = new NumbersScraper(movieName, writers);
					if(n.numbersSearch()) {
						numbersYear = n.getYear();
					}
				} catch (Exception e) {
					e.printStackTrace();
					numbersYear= "";
				}
				System.out.println("numbersYear: " + numbersYear);
			
			
			
			if(movieName.length() > 5 && movieName.toLowerCase().substring(movieName.length() - 5).contains(", the")) {
				movieName = movieName.toLowerCase().replace(", the", "");
				movieName = "the " + movieName;
			}
			
			if(movieName.length() > 3 && movieName.toLowerCase().substring(movieName.length() - 3).contains(", a")) {
				movieName = movieName.toLowerCase().replace(", a", "");
				movieName = "a " + movieName;
			}
			
			if (imdbYear.equalsIgnoreCase("") && mojoYear.equalsIgnoreCase("") && tomatoYear.equalsIgnoreCase("") ) {
				System.out.println("imdbYear.equalsIgnoreCase(\"\") && mojoYear.equalsIgnoreCase(\"\") && tomatoYear.equalsIgnoreCase(\"\") is true. Final string should be empty.");
			} else {
				
				
				finalString += movieName +  "~" + imdbYear + "~" + mojoYear + "~" + tomatoYear + "~" + numbersYear + "\n";
				System.out.println("finalString for " + movieName + ": " + finalString);
			}
		} catch (Exception e) {
			
		}
	}

		
		
	public void movieImdbScriptInfo(String movieName) {
		//HashSet<String> writers = new HashSet<String>();
		String writers = "";
		String genres = "";
		try {
			UserAgent userAgent = new UserAgent();
			userAgent.visit("http://www.imsdb.com/Movie%20Scripts/" + movieName.replace(" ", "%20") + "%20Script.html");
			
			
			Element table= userAgent.doc.findFirst("<table class=script-details align=center>");
			
			//the strategy here is you pull everything in the table. it will pull both writers and genres, but also this thing called "read ___ Script". We Will exclude the "read___script".
			for(Element header : table.findEvery("<td>")) {
				
					for(Element as: header.findEvery("<a>")) {
						//System.out.println(as.getText());
						if (!as.getText().contains("Read") && !as.getText().contains("Script")) {
							if (as.getText().contains(" ")) {
								//if there is a space, that means we know this string is a Writer, because genres are only one word, but writers have first and last names, therfore a space
								
								if (writers.equalsIgnoreCase("")) {
									//then we don't have a writer yet. This is for comma formatting, we don't want to add a comma before the first writer, but after second
									writers = as.getText();
									
								} else {
									//we have already found a writer
									writers = writers + ", " + as.getText();
									
								}
							} else {
								//if in else block, we know this is a genre
								if (genres.equalsIgnoreCase("")) {
									//then we don't have a writer yet. This is for comma formatting, we don't want to add a comma before the first writer, but after second
									genres = as.getText();
									
								} else {
									//we have already found a writer
									genres = genres + ", " + as.getText();
									
								}
							}
						}
					}
					//System.out.println(header.findFirst("<a>").getText());
					
				}
			System.out.println(writers);
			System.out.println(genres);
			
			boolean hasScriptDate = false;
			boolean hasMovieReleaseDate = false;
			String ScriptYear = "N/A";
			String ScriptMonth = "N/A";
			String date1 = "";
			String date2 = "";
			for (Element header: table.findEvery("<b>")) {
				
				if (header.getText().contains("Script Date")) {
					hasScriptDate = true;
				}
				if (header.getText().contains("Release Date")) {
					hasMovieReleaseDate = true;
				}
			}
			for (Element header: table.findEvery("<td>")) {
				
				if (header.getText().contains("January") || header.getText().contains("February") || header.getText().contains("March") || header.getText().contains("April") || header.getText().contains("May") || header.getText().contains("June") || header.getText().contains("July") || header.getText().contains("August") || header.getText().contains("September") || header.getText().contains("October") || header.getText().contains("November") || header.getText().contains("December")) {
					if (date1.equalsIgnoreCase("")) {
						date1= header.getText();
					} else {
						date2 = header.getText();
					}
				}
				
			}
			
			if (hasScriptDate) {
				StringTokenizer st = new StringTokenizer(date1);
				while (st.hasMoreTokens()) {
			         String s = st.nextToken();
			         if (isMonth(s) && ScriptMonth.equalsIgnoreCase("N/A")) {
			        	 ScriptMonth = s;
			        	 System.out.println("scriptmonth: " + s);
			         }
			         else if (isNumeric(s) && ScriptYear.equalsIgnoreCase("N/A")) {
			        	 ScriptYear = s;
			        	 System.out.println("scriptyear: " + s);
			         }
			     }
				
			}
			int Action = 0;
			if (genres.contains("Action")) {
				Action = 1;
			}
			int Adventure = 0;
			if (genres.contains("Action")) {
				Adventure = 1;
			}
			int Animation = 0;
			if (genres.contains("Animation")) {
				Animation = 1;
			}
			int Comedy = 0;
			if (genres.contains("Comedy")) {
				Comedy = 1;
			}
			int Crime = 0;
			if (genres.contains("Crime")) {
				Crime = 1;
			}
			int Drama = 0;
			if (genres.contains("Drama")) {
				Drama = 1;
			}
			int Family = 0;
			if (genres.contains("Family")) {
				Family = 1;
			}
			int Fantasy = 0;
			if (genres.contains("Fantasy")) {
				Fantasy = 1;
			}
			int FilmNoir = 0;
			if (genres.contains("Noir")) {
				FilmNoir = 1;
			}
			int Horror = 0;
			if (genres.contains("Horror")) {
				Horror = 1;
			}
			int Musical = 0;
			if (genres.contains("Musical")) {
				Musical = 1;
			}
			int Mystery = 0;
			if (genres.contains("Mystery")) {
				Mystery = 1;
			}
			int Romance = 0;
			if (genres.contains("Romance")) {
				Romance = 1;
			}
			int SciFi = 0;
			if (genres.contains("Sci-Fi")) {
				SciFi = 1;
			}
			int Short = 0;
			if (genres.contains("Short")) {
				Short = 1;
			}
			int Thriller = 0;
			if (genres.contains("Thriller")) {
				Thriller = 1;
			}
			int War = 0;
			if (genres.contains("War")) {
				War = 1;
			}
			int Western = 0;
			if (genres.contains("Western")) {
				Western = 1;
			}
			
			finalString += movieName +  "~" + writers + "~" + ScriptMonth + "~" + ScriptYear +"~"+ genres + "~" + Action + "~" + Adventure + "~" + Animation + "~" + Comedy + "~" + Crime + "~" + Drama + "~" + Family+ "~" + Fantasy + "~" + FilmNoir + "~" + Horror + "~" + Musical + "~" + Mystery + "~" + Romance + "~" + SciFi + "~" + Short + "~" + Thriller + "~" + War + "~" + Western + "\n";
					
					
					
					
			
		} catch (Exception e) {
			
		}
		
		
		
	}
	
	public boolean isMonth(String word) {
		return word.contains("January") || word.contains("February") || word.contains("March") || word.contains("April") || word.contains("May") || word.contains("June") || word.contains("July") || word.contains("August") || word.contains("September") || word.contains("October") || word.contains("November") || word.contains("December");

	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

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
		
	
	
	public void doStarPower(String movieName, String writers, boolean urlActive) {
		
		/*
		if (!containsIgnoreCase(movieName,"Horse Whisperer")  ) {
			finalString = "";
			return;
		}
		*/
		
		try {
			
			System.out.println("moviename:" + movieName + " writers: " + writers);
			ImdbScraper imdb = new ImdbScraper(movieName, writers);
			
			
			System.out.println("is urlActive:" + urlActive);
			if(urlActive) {
				imdb = new ImdbScraper(movieName, writers,true);
			}
			
			
			
			
			
			if(imdb.imdbSearch() == false ) {
				System.out.println("imdbSearch returned false. it failed");
				finalString = "\n";
				return;
			}
			
			String imdbTitle = imdb.getIMDBTitle();
			
			
			System.out.println("imdbSearch returned true. Okay. URL visiting: " + imdb.userAgent.doc.getUrl());
			
			
			ArrayList<String> starUrls = imdb.getStarsUrls();
			System.out.println("here 5000");
			for (String url : starUrls) {   
			    System.out.println( "Star URL: " + url);
			}
			
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
				System.out.println("visiting: " + starUrls.get(i));
				agent.visit(starUrls.get(i));
				;
				/*
				 * This block of code deals with issues on the IMDB Page where certain people are primarily directors yet
				 * starred in a movie. Originally the code just had 
				 * Element movieSection = agent.doc.findFirst("div class=filmo-category-section");
				 * instead of this whole code block. The problem was on a page like: 
				 * http://www.imdb.com/name/nm0639321/?ref_=tt_ov_st_sm
				 * this guy is primarily a writer, so the findFirst() method will go through those movies when really we
				 * are concerned with the guy as a writer. It took me a while to figure out the fix but basically you have 
				 * to work with Jaunt and use the findEvery then filter out the one's that aren't dealing with actors.
				 */
				Elements potentialMovieSections = agent.doc.findEvery("div class=filmo-category-section");
				
				Element movieSection = null;
				for (Element e: potentialMovieSections) {
					
						//System.out.println(e.findFirst("div").getAt("id"));
						if(e.findFirst("div").getAt("id").contains("actor") || e.findFirst("div").getAt("id").contains("actress")) {
							movieSection = e;
						}
				}
				
				
				
				
				boolean found = false;
				int index = 0;
				int USAcount = 0;
				
				System.out.println("here21334");
				
				for(Element element : movieSection.findEvery("div")) {
					System.out.println("here34");
					if(element.innerHTML().contains("(Video)") || element.innerHTML().contains("(TV Series documentary)") || element.innerHTML().contains("(TV Series)") || element.innerHTML().contains("(TV Movie)") || element.innerHTML().contains("(Video Game)") || element.innerHTML().contains("(TV Short)") || element.innerHTML().contains("(Video short)") || element.innerHTML().contains("(TV Mini-Series)") || element.innerHTML().contains("(Short)")) {
						continue;
					}
					if(!element.innerHTML().contains("year_column")) {
						continue;
					}
					System.out.println("here3344");
					System.out.println("index: " + index + " innerHTML: " + element.innerHTML());
					//System.out.println(imdb.getStars().split(",")[i] + ": " + element.findFirst("a").getText());
					if(found == true) {
						//if(index > 10 ) break;
						if(index >= 10 && USAcount >=10) break;
						System.out.println("element.findFirst(\"a\").getAt(\"href\"): " + element.findFirst("a").getAt("href"));
						ImdbScraper tempScraper = new ImdbScraper(movieName, element.findFirst("a").getAt("href"),false);
						//tempScraper.imdbSearch();
						String actor = imdb.getStars().split(",")[i];
						String gross = tempScraper.getGross();
						String budget = tempScraper.getBudget();
						String year = tempScraper.getYear();
						String country = tempScraper.getCountry();
						int USA = -1;
						System.out.println("here32342344");
						if (country.contains("USA")) {
							USA = 1;
							USAcount++;
						}
						else {
							USA = 0;
						}
						
						String subFinalString = movieName + "~" + imdb.getYear() + "~" + actor + "~" + element.findFirst("a").getText() + "~" + year + "~" + gross.replaceAll("$", "").replaceAll(",", "") + "~" + budget.replaceAll("$", "").replaceAll(",", "") +"~" + country + "~" + USA;
						
						finalString += subFinalString + "\n";
						
						index++;
					} else {
						System.out.println("comparing to imdbTitle:" + imdbTitle);
						if(element.findFirst("a").getText().toLowerCase().equalsIgnoreCase(imdbTitle)) {
							//System.out.println(starUrls.get(i));
							System.out.println("------------------------");
							found = true;
						} else if (imdbTitle.equalsIgnoreCase("Dumb &amp; Dumber")) {
							if(element.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Dumb & Dumber")) {
								found = true;
							}
						} else if (imdbTitle.equalsIgnoreCase("Batman &amp; Robin")) {
							if(element.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Batman & Robin")) {
								found = true;
							}
						} else if (imdbTitle.equalsIgnoreCase("Sugar &amp; Spice")) {
							if(element.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Sugar & Spice")) {
								found = true;
							}
						} else if (imdbTitle.equalsIgnoreCase("Love &amp; Basketball")) {
							if(element.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Love & Basketball")) {
								found = true;
							}
						} else if (imdbTitle.equalsIgnoreCase("Harold &amp; Kumar Go to White Castle")) {
							if(element.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Harold & Kumar Go to White Castle")) {
								found = true;
							}
						}
					}
				}
				
				//
				
			}

		} catch(JauntException e) {
			System.out.println(e.getMessage());
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public DataScraper(String movieName, String writers, String string2, String string3) {
		

		
		// TODO Auto-generated constructor stub
	}
	
	public DataScraper() {
		
	}
	
	public void doGenresFromAllSources(String movieName, String imdbURL, String BoxOfficeMojoURL, String RottenTomatoURL, String TheNumbersURL, String writers) {
		try {
			
			ImdbScraper s;
			String imdbGenres;
			if(imdbURL == null) {
				s = new ImdbScraper(movieName, writers);
				if(s.imdbSearch() == false) {
					System.out.println("In DataScarper, s.imdbSearch() returned false.");
					return;
				} else {
					System.out.println("imdbSearch returned true. Okay. URL visiting: " + s.userAgent.doc.getUrl());
					imdbGenres = s.getGenres();
				}
			} else {
				//URLS where included
				System.out.println("imdb url is: " + imdbURL);
				s = new ImdbScraper(movieName, imdbURL, true);
				imdbGenres = s.getGenres();
				System.out.println("imdb genres:" + imdbGenres);
			}
			
			TomatoScraper t;
			String tomatoGenres;
			if(RottenTomatoURL == null) {
				t = new TomatoScraper(movieName, writers);
				if(t.tomatoSearch() == false) {
					System.out.println("In DataScarper, tomatoScraper.Search() returned false.");
					return;
				} else {
					System.out.println("tomato returned true. Okay. URL visiting: " + t.userAgent.doc.getUrl());
					tomatoGenres = t.getGenres();
				}
			} else {
				//URLS where included
				t = new TomatoScraper(movieName, RottenTomatoURL, true);
				tomatoGenres = t.getGenres();
				System.out.println("tomato genres:" + tomatoGenres);
			}
			
			MojoScraper m;
			String mojoGenres;
			if(BoxOfficeMojoURL == null) {
				m = new MojoScraper(movieName, writers);
				if(m.mojoSearch() == false) {
					System.out.println("In DataScarper, mojoScraper.Search() returned false.");
					return;
				} else {
					System.out.println("mojo returned true. Okay. URL visiting: " + m.userAgent.doc.getUrl());
					mojoGenres = m.getGenres();
					System.out.println("mojo genres:" + mojoGenres);
				}
			} else {
				//URLS where included
				m = new MojoScraper(movieName, BoxOfficeMojoURL, true);
				mojoGenres = m.getGenres();
				System.out.println("mojo genres:" + mojoGenres);
			}
			
			NumbersScraper n;
			String numbersGenres = "";
			if(TheNumbersURL == null) {
				try {
					n = new NumbersScraper(movieName, writers);
					if(n.numbersSearch()) {
						numbersGenres = n.getGenres();
					}
				} catch (Exception e) {
					e.printStackTrace();
					numbersGenres= "";
				}
			} else {
				// theNumbers has URL
				n = new NumbersScraper(movieName,TheNumbersURL, false);
				numbersGenres = n.getGenres();
				System.out.println("numbers genres:" + numbersGenres);
			}
			
			String subFinalString = movieName + "~" + imdbGenres + "~" + mojoGenres + "~" + tomatoGenres + "~" + numbersGenres;
			
			
			finalString += subFinalString + "\n";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doDirectorPower(String movieName, String writers) {
		
		ArrayList<String> al = new ArrayList<String>();
		
		/*
		al.add("Conspiracy Theory");

		al.add("Spiderman, Amazing");

		al.add("Hellraiser 3: Hell on Earth");

		al.add("Transformers: The Movie");

		al.add("maltese falcon the");

		al.add("ford fairlane");

		al.add("The Smurfs 2");

		al.add("thief");

		al.add("mighty joe young");

		al.add("Inferno");

		al.add("Mummy,  The");

		al.add("Twilight New Moon");
		
		
		al.add("V for Vendetta");

				al.add("thin red line (1998)");

				al.add("my own private idaho");

				al.add("Trumbo");

				al.add("Get On Up");

				al.add("my name is bruce");

				al.add("Annie");

				al.add("Batman and Robin");

				al.add("Hudson Hawk");

				al.add("Alien");

				al.add("Royal tenenbaums, the");

				al.add("Star Wars: Return of the Jedi");

				al.add("nightmare on elm street3 Dream Warriors");

				al.add("Family Man, The");

				al.add("Mission Impossible");

				al.add("lost boys");

				al.add("Beloved");

				al.add("quills");

				al.add("New Nightmare");

				al.add("muppets, the");

				al.add("We Need to Talk About Kevin");

				al.add("Way Way Back");

				al.add("Les Miserables");

				al.add("mother and child");

				al.add("Island of dr moreau, the");

				al.add("Batman Forever");

				al.add("no country for old men");

				al.add("Olympus Has Fallen");

				al.add("xXx");

				al.add("Leap Year");

				al.add("Searchers, The");

				al.add("Star Wars Revenge of the Jedi");

				al.add("Pawn Sacrifice");

				al.add("Atonement");

				al.add("Somewhere");

				al.add("pans labyrinth");

				al.add("Spotlight");

				al.add("Indiana Jones and the Raiders of the Lost Ark");

				al.add("unborn, the");

				al.add("Producer, The");

				al.add("flightplan");

				al.add("shining");

				al.add("Sleepy Hollow");

				al.add("demolition man");

				al.add("Fabulous Baker Boys, The");

				al.add("Kundun");

				/*
		al.add("Angel Eyes");

		al.add("Savages");

		al.add("Wedding Date");

		al.add("world war z");

		al.add("Children of Men");

		al.add("S1m0ne");

		al.add("15 Minutes");

		al.add("Outbreak");

		al.add("Life As A House");

		al.add("1492: Conquest of Paradise");

		al.add("elizabeth the golden age");

		al.add("Bridget Jones's Baby");

		al.add("The Tourist");

		al.add("last temptation of christ 1988");

		al.add("World is not Enough, The");

		al.add("superman Man of steel");

		al.add("halloween h20");

		al.add("Leviathan");

		al.add("memphis belle");

		al.add("superman 3");

		al.add("superman 2");

		al.add("Bottle Rocket");

		al.add("million dollar baby");

		al.add("Hellraiser 2 Hellbound");

		al.add("X-men");

		al.add("hurt locker");

		al.add("I am Sam");

		al.add("This is 40");

		al.add("Space Cowboys");

		al.add("Matchstick Men");

		al.add("Croupier");

		al.add("Trainwreck");

		al.add("Spartan");

		al.add("Lara Croft Tomb Raider");

		al.add("Lord of the Rings: Fellowship of the Ring, The");

		al.add("Raging Bull");

		al.add("Blade II");

		al.add("Rock, The");

		al.add("safety not guaranteed");

		al.add("Wag the Dog");

		al.add("MY BIG FAT GREEK WEDDING 2");

		al.add("Danish Girl, the");

		al.add("prestige the");

		al.add("Toy Story");

		al.add("Terminator 2: Judgement Day");
		
		al.add("jaws3");

		al.add("Jeepers Creepers 2");

		al.add("Before Sunrise");

		al.add("Revenant, The");

		al.add("nothing but a man");

		al.add("Catwoman");

		al.add("star trek 1978");

		al.add("Sugar and Spice");

		al.add("Letters to Juliet");

		al.add("Malcolm X");

		al.add("Frozen_disney");

		al.add("Max Payne");

		al.add("Boondock Saints II: All Saints Day");

		al.add("hustler, the");

		al.add("Straight Outta Compton");

		al.add("zodiac");

		al.add("Heist");

		al.add("Freddy's Dead: The Final Nightmare");

		al.add("lone survivor");

		al.add("Hills have eyes, the 1976");

		al.add("St. Vincent");

		al.add("vicky cristina barcelona");

		al.add("Ring");

		al.add("rapture");

		al.add("Pitch Black");

		al.add("Evil Dead II: Dead by Dawn");

		al.add("Blade Runner");

		al.add("Sin Nombre");

		al.add("Looney Tunes Back in action");

		al.add("One Chance");

		al.add("sounder");

		al.add("Bound");

		al.add("Love and Basketball");

		al.add("Beetlejuice");

		al.add("never let me go");

		al.add("Face/ Off");

		al.add("Batman Begins");

		al.add("hate crime");

		al.add("where the wild things are");

		al.add("maria full of grace");

		al.add("Truth");

		al.add("little monsters");

		al.add("I Smile Back");

		al.add("town");

		al.add("spiderman the original

		al.add("Goosebumps

		al.add("Judge Dredd

		al.add("Kids

		al.add("Three Men and a Baby

		al.add("Hotel Transylvania 2

		Hateful eight, the

		Cell, The

		labor day

		runaways, the

		Mississippi Grind

		midnight run 1988

		millers crossing

		Time Machine, The

		Crow, The

		Point Break

		Fracture

		Crouching Tiger, Hidden Dragon

		MASH

		iron giant

		Armored

		SLACKERS

		Book of Shadows: Blair Witch 2

		Wild At Heart

		i hope they serve beer in hell

		single man, a

		MOVIE_TITLE

		Battle of Shaker Heights, The

		untraceable

		Its Kind of a Funny Story

		Take Shelter

		something borrowed

		Kung Fu Panda

		Gone in 60 Seconds

		House Bunny, the

		Godfather Part II

		Infinitely Polar Bear

		You Can Count On Me

		Signs

		Her

		Mumford

		King Kong

		Whiplash

		expendables

		Star Trek: First Contact

		punch drunk love

		no one lives 2011

		Snow Falling On Cedars

		Relic, The

		Moon

		stay (2005)

		young adult

		Man on the Moon

		Visitor, The

		Snatch

		Ed Wood

		Thirteen Days

		Assignment, The

		Promised Land

		Apocalypse Now Redux

		fisher king

		Something's Gotta Give

		Night at the roxbury

		hardware

		Airplane II: The Sequel 

		Last Tango in Paris

		Star Trek: Nemesis

		true crime

		Star Wars: Attack of the Clones

		Margin Call

		sex tape

		house on haunted hill

		Kramer vs Kramer

		Annabelle

		Frozen

		Jason vs Freddy

		An American Werewolf in Paris

		Breakfast Club, The

		Jennifer Eight

		Star Wars: The Force Awakens

		Informers, the

		Next

		Blue Velvet

		Life

		Machine Gun Preacher

		Imitation Game The

		Time Travelers Wife

		Knocked Up

		Possession1

		Ricki and the Flash

		monsters ball

		Ladykillers, The

		Apartment, The

		Twelve Monkeys

		Spider-man

		Soldier

		Gothika

		joe vs volcano

		Officer and a Gentleman, An

		Star Trek

		Matrix Reloaded, The

		sicario

		idiocracy

		predators

		Warrior

		Avengers, The (2012)

		rabbit hole

		Blood Work

		Queen of the Damned

		Thunderheart

		Mimic

		Detroit Rock City

		Lord of the Rings: Return of the King

		Independence  Day

		Mystery Men

		Batman

		Body of Evidence

		Air Force One

		Middle of Nowhere

		Jay and Silent Bob Strike Back

		Secret Life of Walter MItty,The

		nightmare on elm street2 Freddys revenge

		Dead Poets Society

		Scarface

		Cradle 2 the Grave

		Bull Durham

		incredible hulk the

		Reservoir Dogs

		Starman

		Antz

		Flintstones, The

		I AM LEGEND

		halloween

		Someone To Watch Over Me

		straw dogs

		Hannibal

		domino

		Terminator Salvation

		Mud

		G.I. Jane

		Godfather

		LITTLE MISS SUNSHINE

		hope and glory

		New Moon

		Mystic River

		Life of Pi

		Alone in the Dark

		Raising Arizona

		Hangover, The

		Se7en

		Halloween: Resurrection

		Basquiat

		Rush Hour

		Unforgiven

		Harold and Kumar Go to White Castle

		Liar Liar

		let me in

		Three Kings (Spoils of War)

		Saving Private Ryan

		Basic

		Fear of clowns

		Lorax

		Dances with Wolves

		Still Alice

		Ferris Bueller's Day Off

		Moneyball

		hero

		L.A. Confidential

		Star Wars: A New Hope

		Bean

		network

		Shrek the Third

		Maverick

		Ocean's Twelve

		king of comedy

		Horse Whisperer, The

		Slither

		Citizen Kane

		Interview, the

		Broadcast News

		Book of Eli, The

		Witches of Eastwick

		smoke

		Ted

		Wedding Ringer

		Ghostbusters 2

		Casino

		Star Wars: The Empire Strikes Back

		Bamboozled

		Slumdog Millionaire

		boolean skip = true;
		
		for (String s: al) {
			if (movieName.equalsIgnoreCase(s) ) {
				skip =false;
				
			}
		}
		
		if (skip) {
			return;
		}
		
		*/
		//movieName = movieName.toLowerCase();
		
		try {
			
			ImdbScraper s = null;
			
			s = new ImdbScraper(movieName, writers);
			
			try {
				boolean hi = s.imdbSearch();
			} catch (Exception e) {
				System.out.println("imdbSearch caused an exception");
			}
			
			if(s.imdbSearch() == false) {
				System.out.println("In DataScarper, s.imdbSearch() returned false.");
				return;
			} else {
				System.out.println("imdb search returned true.");
			}
			
			
			String imdbMovie = s.getIMDBTitle();
			if(movieName.length() > 5 && movieName.toLowerCase().substring(movieName.length() - 5).contains(", the")) {
				movieName = movieName.toLowerCase().replace(", the", "");
				movieName = "the " + movieName;
			}
			
			if(movieName.length() > 3 && movieName.toLowerCase().substring(movieName.length() - 3).contains(", a")) {
				movieName = movieName.toLowerCase().replace(", a", "");
				movieName = "a " + movieName;
			}
			
			movieName = movieName.toLowerCase();
			String imdbMovieName = s.getIMDBTitle();
			UserAgent userAgent = new UserAgent();
			
			System.out.println("made it here in DataScaper 1");

			
			finalString = "";
			
			ArrayList<String> directorUrls = s.getDirectorUrls();
			if(directorUrls == null) {
				return;
			}
			
			System.out.println("made it here in DataScaper 2");
			
			for(String directorLink : directorUrls) {
				System.out.println("directorLink: "  + directorLink);
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
					System.out.println("Filmography Block null");
					finalString = "\n";
					return;
				} else {
					System.out.println("Filmography Block not null");
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
						
						if (movieName.equalsIgnoreCase("Arcade")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("Arcade")) {
								currentMovieFound = true;
								System.out.println("movieDivider.findFirst(\"<a>\").getText().equalsIgnoreCase(\"Arcade (Video)\")" + "is True");
								continue;
							}
						} else if (movieName.equalsIgnoreCase("Avventura, L' (The Adventure)")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("L'Avventura")) {
								currentMovieFound = true;
								System.out.println("L'Avventura found on Director's page.");
								continue;
							}
						} else if (movieName.equalsIgnoreCase("Back to the Future II & III")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("Back to the Future Part II")) {
								currentMovieFound = true;
								System.out.println("L'Avventura found on Director's page.");
								continue;
							}
						}else if (movieName.equalsIgnoreCase("Hellraiser: Deader")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("Hellraiser: Deader")) {
								currentMovieFound = true;
								System.out.println(".");
								continue;
							}
						}else if (movieName.equalsIgnoreCase("Jeux Interdits")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("Forbidden Games")) {
								currentMovieFound = true;
								System.out.println("Jeux Interdits is known as Forbindden games");
								continue;
							}
						} else if (movieName.equalsIgnoreCase("Le Diable par la Queue")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("The Devil by the Tail")) {
								currentMovieFound = true;
								System.out.println("Le Diable par la Queue is known as The Devil by the Tail");
								continue;
							}
						} else if (movieName.equalsIgnoreCase("Les Tontons Flingueurs")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("Monsieur Gangster")) {
								currentMovieFound = true;
								System.out.println("Les Tontons Flingueurs is known as Monsieur Gangster");
								continue;
							}
						} else if (movieName.equalsIgnoreCase("Mr Blandings Builds His Dream House")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("Mr. Blandings Builds His Dream House")) {
								currentMovieFound = true;
								System.out.println("Mr. Blandings Builds His Dream House dealing with period");
								continue;
							}
						}else if (movieName.equalsIgnoreCase("Warm Springs")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("Warm Springs")) {
								currentMovieFound = true;
								System.out.println("dealing with issue with Warm Springs");
								continue;
							}
						}else if (movieName.equalsIgnoreCase("Wild Things: Diamonds in the Rough")) {
							if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("Wild Things: Diamonds in the Rough")) {
								currentMovieFound = true;
								System.out.println("Les Tontons Flingueurs is known as Monsieur Gangster");
								continue;
							}
						}
						if(movieDivider.innerHTML().contains("(Video)") || movieDivider.innerHTML().contains("(TV Series documentary)") || movieDivider.innerHTML().contains("(TV Series)") || movieDivider.innerHTML().contains("(TV Movie)") || movieDivider.innerHTML().contains("(Video Game)") || movieDivider.innerHTML().contains("(TV Short)") || movieDivider.innerHTML().contains("(Video short)") || movieDivider.innerHTML().contains("(TV Mini-Series)") || movieDivider.innerHTML().contains("(Short)")) {
							System.out.println("skipping: " + movieDivider.innerHTML() );
							continue;
						}
						if(!movieDivider.innerHTML().contains("year_column")) {
							continue;
						}
						if(currentMovieFound == true) {
							System.out.println("Working on :" + movieDivider.findFirst("a").getAt("href"));
							if(index == 10) break;
							ImdbScraper tempScraper = new ImdbScraper(movieName, movieDivider.findFirst("a").getAt("href"),false);
							System.out.println("In Data Scaper, created and IMDBScraper with movie title:" + tempScraper.getIMDBTitle());
							tempScraper.imdbSearch();
							String director = s.getDirector();
							String gross = tempScraper.getGross();
							String budget = tempScraper.getBudget();
							String year = tempScraper.getYear();
							
							
							String subFinalString = movieName + "~" + s.getYear() + "~" + director + "~" + movieDivider.findFirst("a").getText() + "~" + year + "~" + gross.replaceAll("$", "").replaceAll(",", "") + "~" + budget.replaceAll("$", "").replaceAll(",", "");
							
							
							finalString += subFinalString + "\n";
							if (finalString.equalsIgnoreCase(movieName + "\n")) {
									finalString="";
								
							}
							
							index++;
							
							
						} else {
							System.out.println("else statement because currentMovieFound=false. movieDivider.findFirst(\"<a>\").getText():" + movieDivider.findFirst("<a>").getText());
							if (movieName.equalsIgnoreCase("American Shaolin: King of Kickboxers II")) {
								if(movieDivider.findFirst("<a>").getText().equalsIgnoreCase("American Shaolin")) {
									currentMovieFound = true;
								}
							}
							//System.out.println("Paramter movie: " + movieName + " --- Imdb Movie Name: " + movieDivider.findFirst("a").getText().toLowerCase());
							if(movieDivider.findFirst("<a>").getText().toLowerCase().equalsIgnoreCase(imdbMovieName)) {
								System.out.println(movieDivider.findFirst("<a>").getText());
								currentMovieFound = true;
							} else if (imdbMovieName.equalsIgnoreCase("Dumb &amp; Dumber")) {
								if(movieDivider.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Dumb & Dumber")) {
									currentMovieFound = true;
								}
							} else if (imdbMovieName.equalsIgnoreCase("Batman &amp; Robin")) {
								if(movieDivider.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Batman & Robin")) {
									currentMovieFound = true;
								}
							} else if (imdbMovieName.equalsIgnoreCase("Sugar &amp; Spice")) {
								if(movieDivider.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Sugar & Spice")) {
									currentMovieFound = true;
								}
							} else if (imdbMovieName.equalsIgnoreCase("Love &amp; Basketball")) {
								if(movieDivider.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Love & Basketball")) {
									currentMovieFound = true;
								}
							} else if (imdbMovieName.equalsIgnoreCase("Harold &amp; Kumar Go to White Castle")) {
								if(movieDivider.findFirst("a").getText().toLowerCase().equalsIgnoreCase("Harold & Kumar Go to White Castle")) {
									currentMovieFound = true;
								}
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
