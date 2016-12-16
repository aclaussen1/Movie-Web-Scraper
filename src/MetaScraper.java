import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;

import javax.swing.JOptionPane;

import com.jaunt.*;

public class MetaScraper {
	
	String finalSentence;
	String nameOfMovie;

	public MetaScraper(String movieName, String string) {
		nameOfMovie = movieName;
		this.metaSearch();
	}
	
	public void metaSearch() {
		
		UserAgent agent = new UserAgent();
		
		nameOfMovie = nameOfMovie.length() > 5 && nameOfMovie.substring(nameOfMovie.length() - 5).contains(", The") ? "The " + nameOfMovie.substring(0, nameOfMovie.length() - 5) : nameOfMovie;
		nameOfMovie = nameOfMovie.toLowerCase().replaceAll(" ", "-");
		try {
			agent.visit("http://www.metacritic.com/movie/" + nameOfMovie);
			//System.out.println(agent.getLocation());
		} catch(JauntException e) {
			System.out.println(nameOfMovie + ": " + e.getMessage());
		}
		
	}

	public String getFinal() {
		return finalSentence;
	}

}
