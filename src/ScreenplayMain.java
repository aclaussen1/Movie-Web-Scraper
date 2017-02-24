

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ScreenplayMain {
	
	
	//helper methods 
	public static boolean parseFile(String fileName,String searchStr) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(fileName));
        
        while(scan.hasNext()){
            String line = scan.nextLine().toString();
            if(line.contains(searchStr)){
                return true;
            }
        }
        return false;
    }
	
	//THIS IS THE MAIN RUNNING FILE
	
	public static void main(String[] args) {
		ScreenplayGenerator sg = new ScreenplayGenerator();
		
		MovielistGenerator mg = new MovielistGenerator(); //THIS GETS THE LIST OF MOVIES
		
		long startTime = System.nanoTime();
		HashMap<String, String> screenPlays = new HashMap<String, String>();
		
		String[] movieStrings = new String[1058];
		
		HashMap<String, String[]> urls = null;
		
		//screenPlays = mg.getMovies(); //**UNCOMMENT THIS WHEN THE FILE IS MOVIE NAMES
		boolean usingUrls = false;
		
	    int reply = JOptionPane.showConfirmDialog(null, "Will you be using URLs?", "Brianna's External Data Program", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          usingUrls = true;
        }
        
        if(usingUrls) {
	        JFileChooser fileChooser = new JFileChooser();
	        int returnValue = fileChooser.showOpenDialog(new JFrame());
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	          File selectedFile = fileChooser.getSelectedFile();
	          try {
				String csvFile = selectedFile.getCanonicalPath();
				urls = mg.getUrls(csvFile);
	          } catch (IOException e) {
				e.printStackTrace();
	          }
	        }
        } else screenPlays = mg.getMovies();
		
		
		BufferedWriter writer = null;
		BufferedWriter writer2 = null;
		  try {
		    //create a temporary file
			  
			String fileName = JOptionPane.showInputDialog(null, "What would you like to name your file?\nExample: primaryReport.txt\n\nDO NOT INCLUDE .TXT extension. This is automatically added in the code");
		    File logFile = new File("C:\\Users\\aclaussen1\\Downloads\\" + fileName + ".txt");
		    
		    //the purpose of the complementaryLogFile is to track which movies have been done so we can save our progress. The web scraping takes a long time. If one movie on imdb causes problems, without the complementary file, we'd need to start over. THis allows us to save progress.
		    File complementaryLogFile = new File("C:\\Users\\aclaussen1\\Downloads\\" + fileName + "tracker.txt");
		
		    // This will output the full path where the file will be written to...

		    writer = new BufferedWriter(new FileWriter(logFile, true));
		    
		    /*
		    //Try to create a BufferedWriter from 
		    boolean isExistingFile = false;
		    try {
		    writer2 = new BufferedWriter(new FileWriter(complementaryLogFile, false));
		    System.out.println("made it to this point in inner try block");
		    } catch (IOException e) {
		    	
		    }
		    */
		    
		    boolean complementaryFileFound = true;
		    
		    //Try to read complementaryLogFile. THis essential tests to see if the file already exists. If it exists, then we will continue writing to that excel/txt file where we
		    //left off. Otherwise we have to start fresh
		    try {
		    	if ( parseFile("C:\\Users\\aclaussen1\\Downloads\\" + fileName + "tracker.txt", "randomString") ) {
		    		System.out.println("test successful");
		    	}
		    	//if this point is code is reached, then the file was found
		    	complementaryFileFound = true;
		   
		    } catch (FileNotFoundException e) {
		    	System.out.println("file Not found");
		    	complementaryFileFound = false;
		    }
		    
		    
		    
		    String name = JOptionPane.showInputDialog(null, "Please enter the task number:\n1 = Primary Three\n2 = The-Numbers.com\n3 = Star Power\n4 = Director Power\n5 = Movie Year Information");
		    int choice = Integer.parseInt(name);
		    

			//UNCOMMENT THE NEXT LINE TO SET THE HEADER ROW FOR PRIMARY 3 SCRAPING 
		    String titleString = "";
		    if(choice == 1) titleString = "screenplay_id~MOVIE_TITLE~Sequel~Year~MPAA~Genre~Release_Date~Release_Q1~Release_Q2~Release_Q3~Release_Q4~holidays~Country~Runtime_min~IMDB_Rating~No_votes~Metascore~No_reviews~No_critic~Awards_wins~Awards_nominations~No_Oscar_nomination~No_Oscar_wins~No_Golden_Globe_Noms~No_Golden_Globe_Wins~Director~Writer~Stars~imdb_budget~imdb_BO_opening_wk~imdb_BO_gross~Production_Co~mojo_BO_ROI~mojo_BO_domestic_gross~mojo_BO_foreign_gross~mojo_BO_worldwide~mojo_BO_opening_wk~mojo_theater_opening_wk~mojo_revpertheater_opening_wk~mojo_perc_opening_wk_rev~mojo_budget~mojo_distributor~RT_tomatometer~RT_critic_avg_rating~RT_no_critic_reviews~RT_audience_score~RT_audience_rating~RT_no_user_ratings~Novel_Based~Awards_Screenplay~Nominated_Screenplay~Awards_Screenwriter~Nominated_Screenwriter";
			
			//UNCOMMENT THE NEXT LINE TO SET THE HEADER ROW FOR THE-NUMBER.COM DATA
		    if(choice == 2) titleString = "MOVIE_TITLE~Year~Date~wknd_rank~wknd_gross~wknd_Theaters~cum_wknd_gross~wknd_Days~wkly_rank~wkly_gross~wkly_Theaters~cum_wkly_gross~wkly_days";
			
			//UNCOMMENT THE NEXT LINE FOR STAR-POWER
		    if(choice == 3) titleString = "MOVIE_TITLE~Year~Actor~movie_name~movie_year~gross~budget~Country~USA";
			   
			//UNCOMMENT THE NEXT LINE FOR DIRECTOR-POWER
		    if(choice == 4) titleString = "MOVIE_TITLE~Year~Director~movie_name~movie_year~gross~budget";
		    
		    if(choice == 5) titleString = "Movie_title~imdb_year~mojo_year~RT_year";
	
		    //if this is an existing file, check if there is already the titleSTring. If it is new there shouldn't be. THen add the titleString. OTherwise the existing titleString is kept.
		    if ( !parseFile("C:\\Users\\aclaussen1\\Downloads\\" + fileName + ".txt", titleString) ) {
		    	writer.write(titleString + "\n");
		    	System.out.println("must be a new file. Writing titleString to top: " + titleString);
	    	} else {
	    		System.out.println("this must have already been started as the titleString:" + titleString + " has already been found");
	    	}
			writer.close();
			
				int index = 0;
				
			//DataScraper sp = new DataScraper();
			if(!usingUrls) {
				
				for(String key : screenPlays.keySet()) {
					//these writers will be closed after ever iteration of the for loop. the close() method for the FileWriter class is what actually writes to the file. OTherwise you could lose all you work. So we want the file to get written to after each movie is finished, not when the entire code is finished running.
					writer = new BufferedWriter(new FileWriter(logFile, true));
					writer2 = new BufferedWriter(new FileWriter(complementaryLogFile, true));
					
					/*
					//following if is just for testing purposes.
					//include this commented-out code to do a test on only one particular movie (in this case, changeling)
					if (!key.equalsIgnoreCase("Bottle Rocket")) {
						continue;
					}
					*/
					
					//tests to see if this movie has already been included.
					if(complementaryFileFound) {
						if ( parseFile("C:\\Users\\aclaussen1\\Downloads\\" + fileName + "tracker.txt", key) ) {
							System.out.println(key + " has already been done. Skipping to next movie.");
				    		continue;
				    	}
					}
					
					System.out.println("Working on:" + key);
					DataScraper sp = new DataScraper();
					//UNCOMMENT THE NEXT LINE TO ENABLE PRIMARY 3 SCRAPING WITHOUT URLS
					if(choice == 1) sp.doPrimaryThree(key, new String[] {screenPlays.get(key)}, false); //normal data with names
					
					//UNCOMMENT THE NEXT LINE TO ENABLE THE-NUMBERS.COM FINANCIAL DATA WITHOUT URLS
					if(choice == 2) sp.doNumbersCom(key, screenPlays.get(key), false);
					
					
					//UNCOMMENT THE NEXT LINE TO ENABLE STAR-POWER WITHOUT URLS
					if(choice == 3) sp.doStarPower(key, screenPlays.get(key), false);
					
					//UNCOMMENT THE NEXT LINE TO ENABLE DIRECTOR-POWER WITHOUT URLS
					if(choice == 4) sp.doDirectorPower(key, screenPlays.get(key));
					
					if(choice == 5) sp.doMovieTitles(key, screenPlays.get(key), false);
					
					String finalSentence = sp.getFinal();
					
					if(finalSentence != null) {
						finalSentence = finalSentence.replaceAll("$", "");
					}
					else finalSentence = "\n" + key + "\n";
		
					if(finalSentence.length() > 4 && !finalSentence.equals("\n" + key + "\n") && finalSentence.substring(0, 4).equals("null")) finalSentence = finalSentence.replaceFirst("null", "");
					
					writer.write(finalSentence);
					writer.close();
					writer2.write(key);
					writer2.close();
					
					index++;
					//if(index == 5) break;
				}
			}
	
			else {
				for (String key : urls.keySet()) { //**UNCOMMENT THIS WHEN YOU'RE USING URLS
					
					
					
					writer = new BufferedWriter(new FileWriter(logFile, true));
					writer2 = new BufferedWriter(new FileWriter(complementaryLogFile, true));
					if(complementaryFileFound) {
						if ( parseFile("C:\\Users\\aclaussen1\\Downloads\\" + fileName + "tracker.txt", key) ) {
							System.out.println(key + " has already been done. Skipping to next movie.");
				    		continue;
				    	}
					}
					DataScraper sp = new DataScraper();
					//System.out.println(key);
					//System.out.println(key + " - WRITERS: " + screenPlays.get(key));
					//if(!key.contains(":")) continue;
					
					//GENERIC DATA SCRAPER CONSTRUCTOR
		
					
					//UNCOMMENT THE NEXT LINE TO ENABLE PRIMARY 3 SCRAPING WITH URLS
					if(choice == 1) sp.doPrimaryThree(key, urls.get(key), true); //normal data with urls
					
					//UNCOMMENT THE NEXT LINE TO ENABLE THE-NUMBERS.COM FINANCIAL DATA WITH URLS
					if(choice == 2) sp.doNumbersCom(key, urls.get(key)[4], true); //the-numbers.com data with urls
					
					//UNCOMMENT THE NEXT LINE TO ENABLE STAR-POWER WITH URLS
					if(choice == 3) sp.doStarPower(key, urls.get(key)[1], true);
					
					if(choice == 4) sp.doDirectorPower(key, urls.get(key)[1]);
					String finalSentence = sp.getFinal();
					
					if(finalSentence != null) {
						System.out.println(finalSentence);
						finalSentence = finalSentence.replaceAll("$", "");
						finalSentence = finalSentence + "\n";
					}
					else {
						System.out.println("here" + key);
						if(choice < 3) finalSentence = key + "\n";
						else finalSentence = "\n" + key + "\n";
					}
					//finalSentence = finalSentence + "\n";
					
		//			if(finalSentence == null) {
		//
		//			}
		//			
					if(finalSentence.length() > 4 && !finalSentence.equals("\n" + key + "\n") && finalSentence.substring(0, 4).equals("null")) finalSentence = finalSentence.replaceFirst("null", "");
					
					writer.write(finalSentence);
					writer.close();
					writer2.write(key);
					writer2.close();
					//index++;
					//if(index == 5) break;
					//System.out.print("\n----------------------------------------\n");
				}
			}


		  } catch (Exception e) {
			    e.printStackTrace();
		  } finally {
			  try {
			    // Close the writer regardless of what happens...
				  long endTime = System.nanoTime();
				  System.out.println("Took "+(endTime - startTime) + " ns"); 
			        writer.close();
			        writer2.close();
			  } catch (Exception e) {
			  }
		  }

	}
}
