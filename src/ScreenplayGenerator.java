import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;

public class ScreenplayGenerator {
	
	/**
	 * 
	 * @param movieTitleWithDashes
	 * 
	 * THIS CODE IS RESPONSIBLE FOR PULLING DOWN MOVIE SCRIPTS FROM
	 * IMSBD.COM
	 */
	
	  public void saveScreenPlay(String movieTitleWithDashes) {
		try{
		  UserAgent userAgent = new UserAgent(); 
		  //create new userAgent (headless browser).
		  userAgent.visit("http://www.imsdb.com/scripts/" + movieTitleWithDashes + ".html");  //visit a url   
		  String test = "";
		  
		  for (Element element : userAgent.doc.findEvery("<pre>")) {
			  if(element.innerHTML().contains("<html>")) continue;
			  if(element.innerHTML().contains("<HTML>")) continue;
			  if(element.innerHTML().contains("<PRE>")) {
				  for (Element element2 : userAgent.doc.findEvery("<PRE>")) {
					  if(element2.innerHTML().contains("<html>")) continue;
					  if(element2.innerHTML().contains("<HTML>")) continue;
					  test = (String)element2.innerHTML();
					  test = test.replace("<br>", "");
					  test = test.replace("<b>", "");
					  test = test.replace("</b>", "");
					  test = test.replace("<TT>", "");
					  test = test.replace("</TT>", "");
					  test = test.replace("<FONT SIZE=-1>", "");
					  test = test.replace("</FONT>", "");
					  //System.out.println(test);
					  test = test.replaceAll("\n", System.lineSeparator());
					  
					  this.saveFile(test, movieTitleWithDashes);
				  }
				  break;
			  }
			  
			  test = (String)element.innerHTML();
			  test = test.replace("<br>", "");
			  test = test.replace("<b>", "");
			  test = test.replace("</b>", "");
			  test = test.replace("<TT>", "");
			  test = test.replace("</TT>", "");
			  test = test.replace("<FONT SIZE=-1>", "");
			  test = test.replace("</FONT>", "");
			  //System.out.println(test);
			  //if (!test.contains("1   EXT.") && !test.contains("1   INT.")) break;
			  test = test.replaceAll("\n", System.lineSeparator());
			  this.saveFile(test, movieTitleWithDashes);
		  }
		}
		catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
		  //System.err.println(e);
		}
	  }
	  
	  public void saveFile(String screenplayText, String movieName) {
		  BufferedWriter writer = null;
		  try {
		    //create a temporary file
		    File logFile = new File("/Users/darienpourmehr/Documents/Screenplays/" + movieName.replace("-", " ") + ".txt");
		    
		
		    // This will output the full path where the file will be written to...
		
		    writer = new BufferedWriter(new FileWriter(logFile));
		    writer.write(screenplayText);
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
