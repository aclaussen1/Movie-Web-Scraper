import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;

import javax.swing.JOptionPane;

public class MetaCriticMain {
	public static void main(String[] args) {
		ScreenplayGenerator sg = new ScreenplayGenerator();
		MovielistGenerator mg = new MovielistGenerator();
		
		HashMap<String, String> screenPlays = new HashMap<String, String>();
		String[] movieStrings = new String[1058];
		screenPlays = mg.getMovies(); //**UNCOMMENT THIS WHEN THE FILE IS MOVIE NAMES
		//HashMap<String, String[]> urls = mg.getUrls(); **UN COMMENT THIS WHEN THE FILE IS URLS
		
		
//		boolean done = true;
//		for(String key : screenPlays.keySet()) {
//			sg.saveScreenPlay(key.replace(" " , "-"));
//			//if(i == 30) break;
//		}
//		if(done == true) return;
		BufferedWriter writer = null;
		  try {
		    //create a temporary file
		    File logFile = new File("/Users/dpourmehr/documents/brianna_reports/meta-critic.txt");
		    
		
		    // This will output the full path where the file will be written to...
		
		   writer = new BufferedWriter(new FileWriter(logFile));

		//String titleString = "screenplay_id~MOVIE_TITLE~Sequel~Year~MPAA~Genre~Release_Date~Release_Q1~Release_Q2~Release_Q3~Release_Q4~holidays~Country~Runtime_min~IMDB_Rating~No_votes~Metascore~No_reviews~No_critic~Awards_wins~Awards_nominations~No_Oscar_nomination~No_Oscar_wins~No_Golden_Globe_Noms~No_Golden_Globe_Wins~Director~Writer~Stars~imdb_budget~imdb_BO_opening_wk~imdb_BO_gross~Production_Co~mojo_BO_ROI~mojo_BO_domestic_gross~mojo_BO_foreign_gross~mojo_BO_worldwide~mojo_BO_opening_wk~mojo_theater_opening_wk~mojo_revpertheater_opening_wk~mojo_perc_opening_wk_rev~mojo_budget~mojo_distributor~RT_tomatometer~RT_critic_avg_rating~RT_no_critic_reviews~RT_audience_score~RT_audience_rating~RT_no_user_ratings~Novel_Based~Awards_Screenplay~Nominated_Screenplay~Awards_Screenwriter~Nominated_Screenwriter";
		String titleString = "MOVIE_TITLE~Year~Date~wknd_rank~wknd_gross~wknd_Theaters~cum_wknd_gross~wknd_Days~wkly_rank~wkly_gross~wkly_Theaters~cum_wkly_gross~wkly_days";
			writer.write(titleString + "\n");
			int index = 0;
		for(String key : screenPlays.keySet()) { //UNCOMMENT THIS WHEN YOU'RE USING MOVIE NAMES
		//for (String key : urls.keySet()) { //**UNCOMMENT THIS WHEN YOU'RE USING URLS
			//if(!key.contains(":")) continue;
			//DataScraper sp = new DataScraper(key, screenPlays.get(key)); //using movie names
			//DataScraper sp = new DataScraper(key, urls.get(key)); //using urls
			//DataScraper sp = new DataScraper(key, screenPlays.get(key), "numbers.com"); //for the-numbers.com
			MetaScraper ms = new MetaScraper(key, screenPlays.get(key));
			String finalSentence = ms.getFinal();
			
			if(finalSentence != null) {
				finalSentence = finalSentence.replaceAll("$", "");
			}
			else finalSentence = key;
			if(finalSentence != key && finalSentence.substring(0, 4).equals("null")) finalSentence = finalSentence.replaceFirst("null", "");
			writer.write(finalSentence + "\n");
			//if(index == 100) break;
			//System.out.print("\n----------------------------------------\n");
		}
//		for(int i = 0; i < screenPlays.size(); i++) {


//			//String finalSentence = sp.getFinal();
////			if(finalSentence != null && finalSentence.contains("\n")) {
////				System.out.println(finalSentence.replaceAll("\\r\\n|\\r|\\n", "") + "\n\n\nHas a line break");
////			}
//
//		    
//			System.out.print("\n----------------------------------------\n");
//			if(i == 30) return;
//		}
		  } catch (Exception e) {
			    e.printStackTrace();
		  } finally {
			  try {
			    // Close the writer regardless of what happens...
			        writer.close();
			  } catch (Exception e) {
			  }
		  }

	}
}
