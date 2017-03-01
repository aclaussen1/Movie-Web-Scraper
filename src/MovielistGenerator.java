import com.jaunt.*;
import com.jaunt.component.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.util.*;

public class MovielistGenerator {

	String csvFile = "";
	
	public HashMap getMovies() {
		try{
			  UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).
			  userAgent.visit("http://www.imsdb.com/all%20scripts/");  //visit a url   
			  String test = "";
			  boolean listStarted = false;
			  ArrayList<String> movies = new ArrayList<String>();
			  
			  HashMap<String, String> movies2 = new HashMap<String, String>();
			  
			  for (Element element : userAgent.doc.findEvery("<p>")) {
				  //System.out.println(element.findFirst("<i>").getText());
				  Element link = element.findFirst("<a>");
				  System.out.println(link.getText());
				  if (link.getText().equals("10 Things I Hate About You")) listStarted = true;
				  if (listStarted == true) {
					  movies2.put(link.getText(), element.findFirst("<i>").getText().replace("Written by ", ""));
				  }
				  if (link.getText().equals("Zerophilia")) {
					  return movies2;
				  }
			  }
			}
			catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
			  System.err.println(e);
			}
		return null;
	}
	

	public HashMap<String, String[]> getUrls(String csvFile) {
		//final String csvFile = null;
//	    JFrame.setDefaultLookAndFeelDecorated(true);
//	    JDialog.setDefaultLookAndFeelDecorated(true);
//	    JFrame frame = new JFrame("JComboBox Test");
//	    frame.setLayout(new FlowLayout());
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    JButton button = new JButton("Select File");
//	    button.addActionListener(new ActionListener() {
//	      public void actionPerformed(ActionEvent ae) {
//	        JFileChooser fileChooser = new JFileChooser();
//	        int returnValue = fileChooser.showOpenDialog(null);
//	        if (returnValue == JFileChooser.APPROVE_OPTION) {
//	          File selectedFile = fileChooser.getSelectedFile();
//	          try {
//				csvFile = selectedFile.getCanonicalPath();
//	          } catch (IOException e) {
//				e.printStackTrace();
//	          }
//	        }
//	      }
//	    });
//	    frame.add(button);
//	    frame.pack();
//	    frame.setVisible(true);
	    
        //String csvFile = "C://Users//dpourmehr//Documents//brianna_reports//allMovieUrls.csv";

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        HashMap<String, String[]> mainMap = new HashMap<String, String[]>();
        
        int mainMapIndex = 0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	
            	 //regex solution to why urls aren't working. see http://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes. Don't really understand the regex but it should work
                 String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                 String[] urls = new String[11];
                 int i = 0;
                 for(String t : tokens) {
                	 System.out.println("t:" + t + " i:" + i);
                     urls[i] = t;
                     i++;
                     
                 }
            	
                // use comma as separator
                //String[] urls = line.split(cvsSplitBy);
                
                String[] urlArray = new String[5];

                urlArray[0] = urls[0];
                System.out.println("urlArray[0]" + urlArray[0]);
                urlArray[1] = urls[3];
                System.out.println("urlArray[1]" + urlArray[1]);
                urlArray[2] = urls[4];
                System.out.println("urlArray[2]" + urlArray[2]);
                urlArray[3] = urls[5];
                System.out.println("urlArray[3]" + urlArray[3]);
                urlArray[4] = urls[6];
                System.out.println("urlArray[4]" + urlArray[4]);
                
                
                mainMap.put(urls[0], urlArray);
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return mainMap;
	}
	
}
