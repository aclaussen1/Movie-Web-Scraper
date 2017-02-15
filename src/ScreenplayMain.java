

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ScreenplayMain {
	
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
		  try {
		    //create a temporary file
			  
			String fileName = JOptionPane.showInputDialog(null, "What would you like to name your file?\nExample: primaryReport.txt\n\nFILE HAS TO BE A .TXT EXTENSION");
		    File logFile = new File("C:\\Users\\aclaussen1\\Downloads\\" + fileName);
		    
		
		    // This will output the full path where the file will be written to...
		

		    writer = new BufferedWriter(new FileWriter(logFile));
		    
		    String name = JOptionPane.showInputDialog(null, "Please enter the task number:\n1 = Primary Three\n2 = The-Numbers.com\n3 = Star Power\n4 = Director Power");
		    int choice = Integer.parseInt(name);
		    

			//UNCOMMENT THE NEXT LINE TO SET THE HEADER ROW FOR PRIMARY 3 SCRAPING 
		    String titleString = "";
		    if(choice == 1) titleString = "screenplay_id~MOVIE_TITLE~Sequel~Year~MPAA~Genre~Release_Date~Release_Q1~Release_Q2~Release_Q3~Release_Q4~holidays~Country~Runtime_min~IMDB_Rating~No_votes~Metascore~No_reviews~No_critic~Awards_wins~Awards_nominations~No_Oscar_nomination~No_Oscar_wins~No_Golden_Globe_Noms~No_Golden_Globe_Wins~Director~Writer~Stars~imdb_budget~imdb_BO_opening_wk~imdb_BO_gross~Production_Co~mojo_BO_ROI~mojo_BO_domestic_gross~mojo_BO_foreign_gross~mojo_BO_worldwide~mojo_BO_opening_wk~mojo_theater_opening_wk~mojo_revpertheater_opening_wk~mojo_perc_opening_wk_rev~mojo_budget~mojo_distributor~RT_tomatometer~RT_critic_avg_rating~RT_no_critic_reviews~RT_audience_score~RT_audience_rating~RT_no_user_ratings~Novel_Based~Awards_Screenplay~Nominated_Screenplay~Awards_Screenwriter~Nominated_Screenwriter";
			
			//UNCOMMENT THE NEXT LINE TO SET THE HEADER ROW FOR THE-NUMBER.COM DATA
		    if(choice == 2) titleString = "MOVIE_TITLE~Year~Date~wknd_rank~wknd_gross~wknd_Theaters~cum_wknd_gross~wknd_Days~wkly_rank~wkly_gross~wkly_Theaters~cum_wkly_gross~wkly_days";
			
			//UNCOMMENT THE NEXT LINE FOR STAR-POWER
		    if(choice == 3) titleString = "MOVIE_TITLE~Year~Actor~movie_name~movie_year~gross~budget";
			   
			//UNCOMMENT THE NEXT LINE FOR DIRECTOR-POWER
		    if(choice == 4) titleString = "MOVIE_TITLE~Year~Director~movie_name~movie_year~gross~budget";
	
			writer.write(titleString + "\n");
				int index = 0;
				
			//DataScraper sp = new DataScraper();
			if(!usingUrls) {
				for(String key : screenPlays.keySet()) {
					DataScraper sp = new DataScraper();
					//UNCOMMENT THE NEXT LINE TO ENABLE PRIMARY 3 SCRAPING WITHOUT URLS
					if(choice == 1) sp.doPrimaryThree(key, new String[] {screenPlays.get(key)}, false); //normal data with names
					
					//UNCOMMENT THE NEXT LINE TO ENABLE THE-NUMBERS.COM FINANCIAL DATA WITHOUT URLS
					if(choice == 2) sp.doNumbersCom(key, screenPlays.get(key), false);
					
					//UNCOMMENT THE NEXT LINE TO ENABLE STAR-POWER WITHOUT URLS
					if(choice == 3) sp.doStarPower(key, screenPlays.get(key), false);
					
					//UNCOMMENT THE NEXT LINE TO ENABLE DIRECTOR-POWER WITHOUT URLS
					if(choice == 4) sp.doDirectorPower(key, screenPlays.get(key));
					
					String finalSentence = sp.getFinal();
					
					if(finalSentence != null) {
						finalSentence = finalSentence.replaceAll("$", "");
					}
					else finalSentence = "\n" + key + "\n";
		
					if(finalSentence.length() > 4 && !finalSentence.equals("\n" + key + "\n") && finalSentence.substring(0, 4).equals("null")) finalSentence = finalSentence.replaceFirst("null", "");
					
					writer.write(finalSentence);
					index++;
					if(index == 5) break;
				}
			}
	
			else {
				for (String key : urls.keySet()) { //**UNCOMMENT THIS WHEN YOU'RE USING URLS
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
					index++;
					if(index == 5) break;
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
			  } catch (Exception e) {
			  }
		  }

	}
}
