
import java.util.ArrayList;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jaunt.component.Form;

/**
 * 
 * @author dpourmehr
 *
 *THIS IS THE IMDB SCRAPING CLASS
 *
 */

public class ImdbScraper {

	String nameOfMovie;
	UserAgent userAgent;
	String movieWriters;
	boolean constructedWithURL;

	
	public ImdbScraper(String movieName, String writers) {
		nameOfMovie = movieName;
		movieWriters = writers;
		constructedWithURL = false;
		System.out.println("the nameOfMovie variable instantiated in ImdbScraper (which may be a url) is:" + nameOfMovie);
		System.out.println("the movieWriters variable instantiated in ImdbScraper (which may be a url) is:" + movieWriters);
	}
	
	//constructor with URL. boolean is just to distinguish between the other constructor and is never used
	public ImdbScraper(String movieName, String imdbURL, boolean fakeVariable) {
		nameOfMovie = movieName;
		constructedWithURL = true;
		//when this Scraper was first coded, this constructor didnt exist, only the one above.  the movieWriters variable was set to hold the URL sometimes. I haven't fixed it so its more clear.
		movieWriters = imdbURL;
		userAgent = new UserAgent();
		try {
			userAgent.visit(imdbURL);
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * This function goes to imdb's homepage and types in the search field
	 * what the name of the movie is that is passed to the constructor.
	 * 
	 * We assume that the first result is the correct movie we are searching
	 * for, and therefore change the userAgent's page to that new link.
	 * @return
	 */
	
	public boolean imdbSearch() {
		if (constructedWithURL) {
			//in the constructor with URLs, the userAgent has already been directed to the correct URL
			return true;
		}
		try{
			  userAgent = new UserAgent(); 
			  //create new userAgent (headless browser).
//			  userAgent.visit("http://www.imdb.com/?ref_=nv_home");  //visit a url
//			  Form f = userAgent.doc.getForm(userAgent.doc.findFirst("<form>"));
//			  f.setTextField("q", nameOfMovie);
//			  f.submit();
			  if (nameOfMovie.equalsIgnoreCase("Sleepy Hollow")) {
				  userAgent.visit("http://www.imdb.com/title/tt0162661/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("breakdown")) {
				  userAgent.visit("http://www.imdb.com/title/tt0118771/?ref_=nv_sr_2");
				  return true;
			  }	else if (nameOfMovie.equalsIgnoreCase("Alien vs. Predator")) {
				  userAgent.visit("http://www.imdb.com/title/tt0370263/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Fantastic Mr Fox")) {
				  userAgent.visit("http://www.imdb.com/title/tt0432283/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("http://www.imdb.com/title/tt0472033/");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("12")) {
				  userAgent.visit("http://www.imdb.com/title/tt0192947/");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("http://www.imdb.com/title/tt0453562/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("1492: conquest of paradise")) {
				  userAgent.visit("http://www.imdb.com/title/tt0103594/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("15 minutes")) {
				  userAgent.visit("http://www.imdb.com/title/tt0179626/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("50-50")) {
				  userAgent.visit("http://www.imdb.com/title/tt1306980/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("after.life")) {
				  userAgent.visit("http://www.imdb.com/title/tt0838247/?ref_=nv_sr_3");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("airplane 2: the sequel")) {
				  userAgent.visit("http://www.imdb.com/title/tt0083530/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("alien")) {
				  userAgent.visit("http://www.imdb.com/title/tt0078748/?ref_=fn_al_tt_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("alien 3")) {
				  userAgent.visit("http://www.imdb.com/title/tt0103644/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("alien nation")) {
				  userAgent.visit("http://www.imdb.com/title/tt0094631/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("alien: resurrection")) {
				  userAgent.visit("http://www.imdb.com/title/tt0118583/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("all the president's men")) {
				  userAgent.visit("http://www.imdb.com/title/tt0074119/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("american psycho")) {
				  userAgent.visit("http://www.imdb.com/title/tt0144084/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("american splendor")) {
				  userAgent.visit("http://www.imdb.com/title/tt0305206/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("angel eyes")) {
				  userAgent.visit("http://www.imdb.com/title/tt0225071/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("American, The")) {
				  System.out.println("working on the american. visitng http://www.imdb.com/title/tt1440728/?ref_=nv_sr_2");
				  userAgent.visit("http://www.imdb.com/title/tt1440728/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("as good as it gets")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119822/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the assignment")) {
				  userAgent.visit("http://www.imdb.com/title/tt0118647/?ref_=nv_sr_3");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("austin powers - international man of mystery")) {
				  userAgent.visit("http://www.imdb.com/title/tt0118655/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("austin powers - the spy who shagged me")) {
				  userAgent.visit("http://www.imdb.com/title/tt0145660/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("avengers, the (2012)")) {
				  userAgent.visit("http://www.imdb.com/title/tt0848228/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("batman and robin")) {
				  userAgent.visit("http://www.imdb.com/title/tt0118688/?ref_=nv_sr_3");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("batman begins")) {
				  userAgent.visit("http://www.imdb.com/title/tt0372784/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("batman forever")) {
				  userAgent.visit("http://www.imdb.com/title/tt0112462/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("battle: los angeles")) {
				  userAgent.visit("http://www.imdb.com/title/tt1217613/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("beavis and butt-head do america")) {
				  userAgent.visit("http://www.imdb.com/title/tt0115641/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("bean")) {
				  userAgent.visit("http://www.imdb.com/title/tt0118689/?ref_=fn_al_tt_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("beloved")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120603/?ref_=fn_al_tt_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the best exotic marigold hotel")) {
				  userAgent.visit("http://www.imdb.com/title/tt1412386/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("blade ii")) {
				  userAgent.visit("http://www.imdb.com/title/tt0187738/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("blade runner")) {
				  userAgent.visit("http://www.imdb.com/title/tt0083658/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("boondock saints 2: all saints day")) {
				  userAgent.visit("http://www.imdb.com/title/tt1300851/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("bound")) {
				  userAgent.visit("http://www.imdb.com/title/tt0115736/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("broken embraces")) {
				  userAgent.visit("http://www.imdb.com/title/tt0913425/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("cars 2")) {
				  userAgent.visit("http://www.imdb.com/title/tt1216475/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("catwoman")) {
				  userAgent.visit("http://www.imdb.com/title/tt0327554/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("cecil b. demented")) {
				  userAgent.visit("http://www.imdb.com/title/tt0173716/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("chronicles of narnia: the lion, the witch and the wardrobe")) {
				  userAgent.visit("http://www.imdb.com/title/tt0363771/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("city of joy")) {
				  userAgent.visit("http://www.imdb.com/title/tt0103976/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("clash of the titans")) {
				  userAgent.visit("http://www.imdb.com/title/tt0800320/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("commando")) {
				  userAgent.visit("http://www.imdb.com/title/tt0088944/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("cradle 2 the grave")) {
				  userAgent.visit("http://www.imdb.com/title/tt0306685/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("crouching tiger, hidden dragon")) {
				  userAgent.visit("http://www.imdb.com/title/tt0190332/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the crow")) {
				  userAgent.visit("http://www.imdb.com/title/tt0109506/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the day the earth stood still")) {
				  userAgent.visit("http://www.imdb.com/title/tt0043456/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("days of heaven")) {
				  userAgent.visit("http://www.imdb.com/title/tt0077405/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("death at a funeral")) {
				  userAgent.visit("http://www.imdb.com/title/tt1321509/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("death to smoochy")) {
				  userAgent.visit("http://www.imdb.com/title/tt0266452/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("deep rising")) {
				  userAgent.visit("http://www.imdb.com/title/tt0118956/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the distinguished gentleman")) {
				  userAgent.visit("http://www.imdb.com/title/tt0104114/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("do the right thing")) {
				  userAgent.visit("http://www.imdb.com/title/tt0097216/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("donnie brasco")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119008/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("dumb and dumber")) {
				  userAgent.visit("http://www.imdb.com/title/tt0109686/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("ed tv")) {
				  userAgent.visit("http://www.imdb.com/title/tt0131369/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("escape from l.a.")) {
				  userAgent.visit("http://www.imdb.com/title/tt0116225/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("escape from new york")) {
				  userAgent.visit("http://www.imdb.com/title/tt0082340/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("evil dead ii: dead by dawn")) {
				  userAgent.visit("http://www.imdb.com/title/tt0092991/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("fabulous baker boys, the")) {
				  userAgent.visit("http://www.imdb.com/title/tt0097322/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("face off")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119094/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the flintstones")) {
				  userAgent.visit("http://www.imdb.com/title/tt0109813/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("four feathers")) {
				  userAgent.visit("http://www.imdb.com/title/tt0240510/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("fracture")) {
				  userAgent.visit("http://www.imdb.com/title/tt0488120/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("freddy vs. jason")) {
				  userAgent.visit("http://www.imdb.com/title/tt0329101/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("fright night (1985)")) {
				  userAgent.visit("http://www.imdb.com/title/tt0089175/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("frozen")) {
				  userAgent.visit("http://www.imdb.com/title/tt1323045/?ref_=nv_sr_3");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("frozen (disney)")) {
				  userAgent.visit("http://www.imdb.com/title/tt2294629/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the game")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119174/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("ghost rider")) {
				  userAgent.visit("http://www.imdb.com/title/tt0259324/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("ghostbusters 2")) {
				  userAgent.visit("http://www.imdb.com/title/tt0097428/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("glengarry glen gross")) {
				  userAgent.visit("http://www.imdb.com/title/tt0104348/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("go")) {
				  userAgent.visit("http://www.imdb.com/title/tt0139239/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("godzilla")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120685/?ref_=nv_sr_4");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("grand hotel")) {
				  userAgent.visit("http://www.imdb.com/title/tt0022958/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("gravity")) {
				  userAgent.visit("http://www.imdb.com/title/tt1454468/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("gremlins 2")) {
				  userAgent.visit("http://www.imdb.com/title/tt0099700/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("grosse point blank")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119229/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("hanna")) {
				  userAgent.visit("http://www.imdb.com/title/tt0993842/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("hannibal")) {
				  userAgent.visit("http://www.imdb.com/title/tt0212985/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("hard to kill")) {
				  userAgent.visit("http://www.imdb.com/title/tt0099739/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("harold and kumar go to white castle")) {
				  userAgent.visit("http://www.imdb.com/title/tt0366551/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("heist")) {
				  userAgent.visit("http://www.imdb.com/title/tt0252503/?ref_=nv_sr_5");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("hellboy 2: the golden army")) {
				  userAgent.visit("http://www.imdb.com/title/tt0411477/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("hellraiser 3: hell on earth")) {
				  userAgent.visit("http://www.imdb.com/title/tt0104409/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("highlander: endgame")) {
				  userAgent.visit("http://www.imdb.com/title/tt0144964/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("hudson hawk")) {
				  userAgent.visit("http://www.imdb.com/title/tt0102070/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("i am sam")) {
				  userAgent.visit("http://www.imdb.com/title/tt0277027/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("i, robot")) {
				  userAgent.visit("http://www.imdb.com/title/tt0343818/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the imaginarium of doctor parnassus")) {
				  userAgent.visit("http://www.imdb.com/title/tt1054606/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("indiana jones and the raiders of the lost ark")) {
				  userAgent.visit("http://www.imdb.com/title/tt0082971/?ref_=nv_sr_5");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("insidious")) {
				  userAgent.visit("http://www.imdb.com/title/tt1591095/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("insomnia")) {
				  userAgent.visit("http://www.imdb.com/title/tt0278504/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("jennifer eight")) {
				  userAgent.visit("http://www.imdb.com/title/tt0104549/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("judge dredd")) {
				  userAgent.visit("http://www.imdb.com/title/tt0113492/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("jurassic park")) {
				  userAgent.visit("http://www.imdb.com/title/tt0107290/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("jurassic park: the lost world")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119567/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("kill bill volume 1 & 2")) {
				  userAgent.visit("http://www.imdb.com/title/tt0266697/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("kramer vs kramer")) {
				  userAgent.visit("http://www.imdb.com/title/tt0079417/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("kung fu panda")) {
				  userAgent.visit("http://www.imdb.com/title/tt0441773/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the last of the mohicans")) {
				  userAgent.visit("http://www.imdb.com/title/tt0104691/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("les miserables")) {
				  userAgent.visit("http://www.imdb.com/title/tt1707386/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("leviathan")) {
				  userAgent.visit("http://www.imdb.com/title/tt0097737/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("liar liar")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119528/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("life as a house")) {
				  userAgent.visit("http://www.imdb.com/title/tt0264796/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("logan's run")) {
				  userAgent.visit("http://www.imdb.com/title/tt0074812/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the lord of the rings: fellowship of the ring")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120737/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("lord of the rings: the two towers")) {
				  userAgent.visit("http://www.imdb.com/title/tt0167261/?ref_=nv_sr_3");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("love and basketball")) {
				  userAgent.visit("http://www.imdb.com/title/tt0199725/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mad max 2: the road warrior")) {
				  userAgent.visit("http://www.imdb.com/title/tt0082694/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("made")) {
				  userAgent.visit("http://www.imdb.com/title/tt0227005/?ref_=nv_sr_5");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("majestic, the (the bijou)")) {
				  userAgent.visit("http://www.imdb.com/title/tt0268995/?ref_=fn_al_tt_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("malcolm x")) {
				  userAgent.visit("http://www.imdb.com/title/tt0104797/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("man on fire")) {
				  userAgent.visit("http://www.imdb.com/title/tt0328107/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mariachi, el")) {
				  userAgent.visit("http://www.imdb.com/title/tt0104815/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("matchstick men")) {
				  userAgent.visit("http://www.imdb.com/title/tt0325805/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("max payne")) {
				  userAgent.visit("http://www.imdb.com/title/tt0467197/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("men in black")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119654/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mimic")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119675/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mission impossible")) {
				  userAgent.visit("http://www.imdb.com/title/tt0117060/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mission impossible ii")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120755/?ref_=nv_sr_6");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("monte carlo")) {
				  userAgent.visit("http://www.imdb.com/title/tt1067774/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mr brooks")) {
				  userAgent.visit("http://www.imdb.com/title/tt0780571/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mrs. brown")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119280/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mulholland drive")) {
				  userAgent.visit("http://www.imdb.com/title/tt0166924/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the neverending story")) {
				  userAgent.visit("http://www.imdb.com/title/tt0088323/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("freddy vs. jason")) {
				  userAgent.visit("http://www.imdb.com/title/tt0329101/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("o brother where art thou?")) {
				  userAgent.visit("http://www.imdb.com/title/tt0190590/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("officer and a gentleman, an")) {
				  userAgent.visit("http://www.imdb.com/title/tt0084434/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("187")) {
				  userAgent.visit("http://www.imdb.com/title/tt0118531/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("outbreak")) {
				  userAgent.visit("http://www.imdb.com/title/tt0114069/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Pi")) {
				  userAgent.visit("http://www.imdb.com/title/tt0138704/?ref_=nv_sr_4");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("pitch black")) {
				  userAgent.visit("http://www.imdb.com/title/tt0134847/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("point break")) {
				  userAgent.visit("http://www.imdb.com/title/tt0102685/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("pride and prejudice")) {
				  userAgent.visit("http://www.imdb.com/title/tt0414387/");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the producer")) {
				  userAgent.visit("http://www.imdb.com/title/tt0329101/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the proposal")) {
				  userAgent.visit("http://www.imdb.com/title/tt1041829/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("raging bull")) {
				  userAgent.visit("http://www.imdb.com/title/tt0081398/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("rambo: first blood ii: the mission")) {
				  userAgent.visit("http://www.imdb.com/title/tt0089880/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("rebel without a cause")) {
				  userAgent.visit("http://www.imdb.com/title/tt0048545/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the relic")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120004/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("remember me")) {
				  userAgent.visit("http://www.imdb.com/title/tt1403981/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("resident evil")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120804/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the rock")) {
				  userAgent.visit("http://www.imdb.com/title/tt0117500/");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("romeo & juliet")) {
				  userAgent.visit("http://www.imdb.com/title/tt0117509/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the ruins")) {
				  userAgent.visit("http://www.imdb.com/title/tt0963794/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("simone")) {
				  userAgent.visit("http://www.imdb.com/title/tt0258153/");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the saint")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120053/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the sandlot kids")) {
				  userAgent.visit("http://www.imdb.com/title/tt0108037/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("save the last dance")) {
				  userAgent.visit("http://www.imdb.com/title/tt0206275/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("scott pilgrim vs the world")) {
				  userAgent.visit("http://www.imdb.com/title/tt0446029/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the searchers")) {
				  userAgent.visit("http://www.imdb.com/title/tt0049730/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("sex, lies and videotape")) {
				  userAgent.visit("http://www.imdb.com/title/tt0098724/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("shrek the third")) {
				  userAgent.visit("http://www.imdb.com/title/tt0413267/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("snow falling on cedars")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120834/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("solaris")) {
				  userAgent.visit("http://www.imdb.com/title/tt0307479/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("soldier")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120157/?ref_=nv_sr_3");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("spartan")) {
				  userAgent.visit("http://www.imdb.com/title/tt0360009/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("speed racer")) {
				  userAgent.visit("http://www.imdb.com/title/tt0811080/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("star trek: first contact")) {
				  userAgent.visit("http://www.imdb.com/title/tt0117731/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("star wars: a new hope")) {
				  userAgent.visit("http://www.imdb.com/title/tt0076759/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("star wars: attack of the clones")) {
				  userAgent.visit("http://www.imdb.com/title/tt0121765/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("star wars: return of the jedi")) {
				  userAgent.visit("http://www.imdb.com/title/tt0086190/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("star wars: revenge of the sith")) {
				  userAgent.visit("http://www.imdb.com/title/tt0121766/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("star wars: the empire strikes back")) {
				  userAgent.visit("http://www.imdb.com/title/tt0080684/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("star wars: the phantom menace")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120915/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the sting")) {
				  userAgent.visit("http://www.imdb.com/title/tt0070735/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("sugar and spice")) {
				  userAgent.visit("http://www.imdb.com/title/tt0186589/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("sunset blvd.")) {
				  userAgent.visit("http://www.imdb.com/title/tt0043014/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("terminator 2: judgement day")) {
				  userAgent.visit("http://www.imdb.com/title/tt0103064/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the rage: carrie 2")) {
				  userAgent.visit("http://www.imdb.com/title/tt0144814/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("they")) {
				  userAgent.visit("http://www.imdb.com/title/tt0283632/");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("this is 40")) {
				  userAgent.visit("http://www.imdb.com/title/tt1758830/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("three kings (spoils of war)")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120188/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("three men and a baby")) {
				  userAgent.visit("http://www.imdb.com/title/tt0094137/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("thunderbirds")) {
				  userAgent.visit("http://www.imdb.com/title/tt0167456/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the time machine")) {
				  userAgent.visit("http://www.imdb.com/title/tt0268695/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("top gun")) {
				  userAgent.visit("http://www.imdb.com/title/tt0092099/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("toy story")) {
				  userAgent.visit("http://www.imdb.com/title/tt0114709/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("transformers: the movie")) {
				  userAgent.visit("http://www.imdb.com/title/tt0092106/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("tristan and isolde")) {
				  userAgent.visit("http://www.imdb.com/title/tt0375154/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("tron: legacy")) {
				  userAgent.visit("http://www.imdb.com/title/tt1104001/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("12 monkeys")) {
				  userAgent.visit("http://www.imdb.com/title/tt0114746/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("twilight: new moon")) {
				  userAgent.visit("http://www.imdb.com/title/tt1259571/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("two for the money")) {
				  userAgent.visit("http://www.imdb.com/title/tt0417217/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("unforgiven")) {
				  userAgent.visit("http://www.imdb.com/title/tt0105695/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Up")) {
				  userAgent.visit("http://www.imdb.com/title/tt1049413/?ref_=nv_sr_3");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("v for vendetta")) {
				  userAgent.visit("http://www.imdb.com/title/tt0434409/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("vanilla sky")) {
				  userAgent.visit("http://www.imdb.com/title/tt0259711/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the visitor")) {
				  userAgent.visit("http://www.imdb.com/title/tt0857191/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("wag the dog")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120885/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("wall-e")) {
				  userAgent.visit("http://www.imdb.com/title/tt0910970/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("when a stranger calls")) {
				  userAgent.visit("http://www.imdb.com/title/tt0080130/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("who framed roger rabbit?")) {
				  userAgent.visit("http://www.imdb.com/title/tt0096438/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("wild at heart")) {
				  userAgent.visit("http://www.imdb.com/title/tt0100935/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("withnail and i")) {
				  userAgent.visit("http://www.imdb.com/title/tt0094336/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("wonder boys")) {
				  userAgent.visit("http://www.imdb.com/title/tt0185014/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the world is not enough")) {
				  userAgent.visit("http://www.imdb.com/title/tt0143145/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the wrestler")) {
				  userAgent.visit("http://www.imdb.com/title/tt1125849/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the x-files: fight the future")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120902/");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("x-men")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120903/?ref_=nv_sr_5");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("xxx")) {
				  userAgent.visit("http://www.imdb.com/title/tt0295701/?ref_=nv_sr_3");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("you can count on me")) {
				  userAgent.visit("http://www.imdb.com/title/tt0203230/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("youth in revolt")) {
				  userAgent.visit("http://www.imdb.com/title/tt0403702/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Assassins")) {
				  userAgent.visit("http://www.imdb.com/title/tt0112401/?ref_=nv_sr_8");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Assignment, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0118647/?ref_=nv_sr_4");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Basquiat")) {
				  userAgent.visit("http://www.imdb.com/title/tt0115632/?ref_=fn_al_tt_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Burlesque")) {
				  userAgent.visit("http://www.imdb.com/title/tt1126591/?ref_=fn_al_tt_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("crow, the")) {
				  userAgent.visit("http://www.imdb.com/title/tt0109506/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Day the Earth Stood Still, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0043456/?ref_=fn_al_tt_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Distinguished Gentleman, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0104114/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Fabulous Baker Boys, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0097322/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Flintstones, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0109813/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Game, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0119174/?ref_=fn_al_tt_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Imaginarium of Doctor Parnassus, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt1054606/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Last of the Mohicans, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0104691/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Life")) {
				  userAgent.visit("http://www.imdb.com/title/tt0123964/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Lord of the Rings: Fellowship of the Ring, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120737/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Matrix, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0133093/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Neverending Story, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0088323/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Nick of Time")) {
				  userAgent.visit("http://www.imdb.com/title/tt0113972/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Pretty Woman")) {
				  userAgent.visit("http://www.imdb.com/title/tt0100405/?ref_=fn_al_tt_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Producer, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0063462/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Proposal, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt1041829/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Relic, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120004/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Rock, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0117500/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Ruins, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0963794/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Saint, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120053/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Sandlot Kids, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0108037/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Searchers, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0049730/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Someone To Watch Over Me")) {
				  userAgent.visit("http://www.imdb.com/title/tt0094008/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Sphere")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120184/?ref_=fn_al_tt_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Spider-Man")) {
				  userAgent.visit("http://www.imdb.com/title/tt0145487/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Sting, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0070735/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Time Machine, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0268695/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Visitor, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0857191/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("World is not Enough, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0143145/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Wrestler, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt1125849/?ref_=nv_sr_2");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("X-Files: Fight the Future, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120902/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Adventures of Buckaroo Banzai Across the Eighth Dimension, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0086856/?ref_=nv_sr_1");
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("American Shaolin: King of Kickboxers II")) {
				  userAgent.visit("http://www.imdb.com/title/tt0101327/");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Arcade")) {
				  userAgent.visit("http://www.imdb.com/title/tt0106302/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Avventura, L' (The Adventure)")) {
				  userAgent.visit("http://www.imdb.com/title/tt0053619/");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Back to the Future II & III")) {
				  userAgent.visit("http://www.imdb.com/title/tt0096874/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Batman 2")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Dry White Season, A")) {
				  userAgent.visit("http://www.imdb.com/title/tt0097243/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Halloween: The Curse of Michael Myers")) {
				  userAgent.visit("http://www.imdb.com/title/tt0113253/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Hellraiser: Deader")) {
				  userAgent.visit("http://www.imdb.com/title/tt0337636/?ref_=nm_flmg_dr_18");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Henry Fool")) {
				  userAgent.visit("http://www.imdb.com/title/tt0122529/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Jeux Interdits")) {
				  userAgent.visit("http://www.imdb.com/title/tt0043686/");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Le Diable par la Queue")) {
				  userAgent.visit("http://www.imdb.com/title/tt0064232/");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Les Tontons Flingueurs")) {
				  userAgent.visit("http://www.imdb.com/title/tt0057591/");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Mr Blandings Builds His Dream House")) {
				  userAgent.visit("http://www.imdb.com/title/tt0040613/");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Mr Deeds Goes to Town")) {
				  userAgent.visit("http://www.imdb.com/title/tt0027996/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("My Mother Dreams the Satan's Disciples in New York")) {
				  userAgent.visit("http://www.imdb.com/title/tt0177023/");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Ni vu ni connu")) {
				  userAgent.visit("http://www.imdb.com/title/tt0051989/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Orgy of the Dead")) {
				  userAgent.visit("http://www.imdb.com/title/tt0054240/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Petulia")) {
				  userAgent.visit("http://www.imdb.com/title/tt0063426/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Night Time (The Poltergeist Treatment)")) {
				  userAgent.visit("http://www.imdb.com/title/tt0084516/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("RKO 281")) {
				  userAgent.visit("http://www.imdb.com/title/tt0120801/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Un Singe en Hiver")) {
				  userAgent.visit("http://www.imdb.com/title/tt0056636/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Warm Springs")) {
				  userAgent.visit("http://www.imdb.com/title/tt0423510/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Wild Things: Diamonds in the Rough")) {
				  userAgent.visit("http://www.imdb.com/title/tt0448179/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Little Mermaid, The")) {
				  userAgent.visit("http://www.imdb.com/title/tt0097757/?ref_=nv_sr_2");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Machete")) {
				  userAgent.visit("http://www.imdb.com/title/tt0985694/?ref_=nv_sr_2");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("get carter")) {
				  userAgent.visit("http://www.imdb.com/title/tt0067128/");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("cobb")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("http://www.imdb.com/title/tt1142977/?ref_=nv_sr_1");
				  return true;
			  }
			  
			  else if(movieWriters.contains("http")) {
				  //System.out.println("contains https");
				  System.out.println("useragent is visiting this website: " + movieWriters);
				  userAgent.visit(movieWriters);
				  return true;
			  } 
			   else userAgent.visit("http://www.imdb.com/search/title?title=" + nameOfMovie.replace(" ", "%20").replace(":", "%3A") + "&title_type=feature");
			  //System.out.println(userAgent.getLocation());

			  Boolean searchFound = false;
			  //userAgent.visit(userAgent.doc.findFirst("<table class=\"results\">").findFirst("<tr class=\"even detailed\">").findFirst("<a>").getAt("href"));
			  Element resultsTable = userAgent.doc.findFirst("<div class=lister-list>");
			  
			  for(Element element : resultsTable.findEvery("<a>")) {
				  //System.out.println("IMDB Movie " + element.getText().replace("The ", "") + " - OUR Movie " + nameOfMovie.replace(", The", "").replace(", A",  ""));
				  String webSearchResult = element.getText().replace(":", "");
				  if(webSearchResult.indexOf("The ") < 2) webSearchResult = webSearchResult.replace("The ", "");
				  //System.out.println(webSearchResult + " - " + nameOfMovie.replace(", The", "").replace(", A",  "").replace(":", ""));
				  if(webSearchResult.contains(nameOfMovie.replace(", The", "").replace(", A",  "").replace(":", ""))) {
					  userAgent.visit(element.getAt("href"));
					  
					  boolean international = false;
					  
					  if(!userAgent.doc.findFirst("<div class=subtext>").innerHTML().contains("(USA)")) international = true;
					  
					  String[] writers;
					  
					  if(international == false) {
						  //if(this.getWriters() != null) System.out.println("IMDB WRITERS: " + this.getWriters());
//						  System.out.println(movieSubString);
//						  System.out.println("-----------------------");
//						  System.out.println(this.getWriters());
						  if(this.getWriters() != null && this.getWriters().contains(","))
							  writers = this.getWriters().split(", ");
						  else {
							  writers = new String[1];
							  writers[0] = this.getWriters();
						  }
						  
						  boolean found = false;
						  
						  for(int i = 0; i < writers.length; i++) {
							  if(movieWriters == null || writers == null || writers[i] == null) return false;
							  if(movieWriters.replaceAll("[^a-zA-Z ]", "").toLowerCase().contains(writers[i].replaceAll("[^a-zA-Z ]", "").toLowerCase())) {
								  //System.out.println(nameOfMovie + " - MOVIE MATCH: " + movieWriters + " - " + writers[i]);
								  System.out.println(userAgent.getLocation());
								  return true;
							  }
						  }
						  
						  //System.out.println("Found: " + found);
						  
						  if(found == false) {
							  continue;
						  }
					  }
					  else return international;
					  //System.out.println("IMDB: " + userAgent.getLocation());

				  }
			  }
			  //System.out.println("No more links to match");
//			  for(Element element : resultsTable.findEvery("<a>")) {
//				  if(element.getText().toLowerCase().contains(nameOfMovie.toLowerCase())) {
//					  userAgent.visit(element.getAt("href"));
//					  return true;
//				  }
//			  }
			  return false;
			}
			catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
			  //System.err.println(e);
			}   
			
		
		return false;
	}
	
	public String[] getNumbAwards() {
		String[] awardArray = new String[6];
		/**
		 * 
		 * Element 0 = # wins
		 * Element 1 = # nominations
		 * Element 2 = # Oscar wins
		 * Element 3 = # Oscar Nominations
		 * Element 4 = # Golden Globe wins
		 * Element 5 = # Golden Globe Nominations
		 * 
		 */
		for(Element link : userAgent.doc.findEvery("<div id=titleAwardsRanks>")) {
			for(Element spans: link.findEvery("<span>")) {
				if(spans.innerHTML().contains("Nominated")) {
					if(spans.innerHTML().contains("Oscar")) {
						awardArray[3] = spans.innerHTML().split("\n")[3].trim();
					} else if(spans.innerHTML().contains("Golden Globe")) {
						awardArray[5] = spans.innerHTML().split("\n")[3].trim();
					}
					//System.out.println(spans.innerHTML().split("\n")[3].trim());
				} else if(spans.innerHTML().contains("Won")) {
					if(spans.innerHTML().contains("Oscar")) {
						awardArray[2] = spans.innerHTML().split("\n")[3].trim();
					} else if(spans.innerHTML().contains("Golden Globe")) {
						awardArray[4] = spans.innerHTML().split("\n")[3].trim();
					}
					//System.out.println(spans.innerHTML().split("\n")[3].trim());					
				}
				else if(spans.getText().toLowerCase().contains(" wins ") || spans.getText().toLowerCase().contains(" win ")) { //if the title has some win(s) 
					String temp = spans.getText().trim().substring(0, spans.getText().trim().indexOf("win") - 1);
					temp = temp.replace("Another\n", "");
					temp = temp.trim();
					awardArray[0] = temp;
					temp = spans.getText().trim();
					temp = temp.replace("Another\n", "");
					temp = temp.trim();
					temp = temp.replace("&amp;", "");
					if(temp.contains("nominat")) {
						temp = temp.substring(temp.indexOf("  ") + 2, temp.indexOf("nominat") - 1).trim();
						awardArray[1] = temp;
					}
					for(int i = 0; i < 6; i++) {
						if(awardArray[i] == null) {
							awardArray[i] = "0";
						}
					}
				} else if(spans.getText().toLowerCase().contains("nominations")) { //if the title has 0 wins and some nominations it would get here
					String temp = spans.getText().trim().substring(0,  spans.getText().trim().indexOf("nominat") - 1).replace("Another\n", "");
					awardArray[1] = temp;
				}
			}
		 }
		for(int i = 0; i < 6; i++) {
			if(awardArray[i] == null) {
				awardArray[i] = "0";
			}
		}
		return awardArray;
	}
	
	public String getDirector() throws NotFound {
		String director = "";
		try {
			for(Element header : userAgent.doc.findEvery("<div class=credit_summary_item>")) {
				if(header.findFirst("<h4>").getText().contains("Director:") || header.findFirst("<h4>").getText().contains("Directors:")) {
					for(Element spans : header.findEvery("<a>")) {
						if(!spans.innerHTML().contains("span")) return director;
							if(director.length() < 1) {
								director = director +  spans.findFirst("<span>").getText();
							} else director = director +  ", " + spans.findFirst("<span>").getText();
					}
					return director;
				}
			}
		} catch(JauntException e) {
			
		} 

	
		
		return "";
	}
	
	public String getWriters() {
		String writers = "";
		try {
			for(Element header : userAgent.doc.findEvery("<div class=credit_summary_item>")) {
				if(header.findFirst("<h4>").getText().contains("Writer:") || header.findFirst("<h4>").getText().contains("Writers:")) {
					for(Element spans : header.findEvery("<a>")) {
						if(!spans.innerHTML().contains("span")) return writers;
							if(writers.length() < 1) {
								writers = writers +  spans.findFirst("<span>").getText();
							} else writers = writers +  ", " + spans.findFirst("<span>").getText();
					}
					return writers;
				}
			}

		} catch(JauntException e) {
			System.out.println(e.getMessage());
		}
		

	
		return null;
	}
	
	public String getStars() {
		String stars = "";
		try {
			for(Element header : userAgent.doc.findEvery("<div class=credit_summary_item>")) {
				if(header.findFirst("<h4>").getText().contains("Star:") || header.findFirst("<h4>").getText().contains("Stars:")) {
					for(Element spans : header.findEvery("<a>")) {
						if(!spans.innerHTML().contains("span")) return stars;
							if(stars.length() < 1) {
								stars = stars +  spans.findFirst("<span>").getText();
							} else stars = stars +  ", " + spans.findFirst("<span>").getText();
					}
					return stars;
				}
			}

		} catch(JauntException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}
	
	public ArrayList<String> getStarsUrls() {
		System.out.println("getting star urls");
		ArrayList<String> starUrls = new ArrayList<String>();
		try {
			System.out.println("here23");
			for(Element header : userAgent.doc.findEvery("<div class=credit_summary_item>")) {
				System.out.println("here12");
				System.out.println(header.findFirst("<h4>").getText());
				if(header.findFirst("<h4>").getText().contains("Star:") || header.findFirst("<h4>").getText().contains("Stars:")) {
					
					for(Element spans : header.findEvery("<a>")) {
						if(!spans.innerHTML().contains("span")) return starUrls;
							System.out.println("here14");
							starUrls.add(spans.getAt("href"));
					}
					return starUrls;
				}
			}

		} catch(JauntException e) {
			System.out.println(e.getMessage());
		}  

		return null;
	}
	
	public ArrayList<String> getDirectorUrls() {
		ArrayList<String> directorUrls = new ArrayList<String>();
		
		try {
			Elements directors = userAgent.doc.findEvery("<span itemprop=director>");
			
			for(Element spanBlock : directors) {
				for(Element link : spanBlock.findEvery("<a>")) {
					directorUrls.add(link.getAt("href"));
				}
			}
			
			return directorUrls;

		} catch(JauntException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public String getYear() {
		String year = "";
		try {
			if(userAgent.doc.findFirst("<title>") != null && !userAgent.doc.findFirst("<title>").equals(""))
			year = userAgent.doc.findFirst("<title>").getText();
			else year = "NOT FOUND";
			if(year.contains("(") && year.contains(")")) {
				year = year.substring(year.indexOf("(") + 1, year.indexOf(")"));
			} else year = "NOT FOUND";
			//return year;
			return year;
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getIMDBTitle() {
		String imdbTitle = "";
		try {
			if(userAgent.doc.findFirst("<title>") != null && !userAgent.doc.findFirst("<title>").equals(""))
			imdbTitle = userAgent.doc.findFirst("<title>").getText();
			else imdbTitle = "NOT FOUND";
			/*
			if(year.contains("(") && year.contains(")")) {
				year = year.substring(year.indexOf("(") + 1, year.indexOf(")"));
			} else year = "NOT FOUND";
			//return year;
			return year;
			*/
			if(imdbTitle.contains("(") && imdbTitle.contains(")")) {
				imdbTitle = imdbTitle.substring(0, imdbTitle.indexOf("(") -1);
			} else imdbTitle = "NOT FOUND";
			return imdbTitle;
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getRunTime() {
		try {
			String time = userAgent.doc.findFirst("<div class=subtext>").findFirst("<time>").getText().trim();
			int hours, minutes;
			
			if(time.contains("h")) hours = Integer.parseInt(time.substring(0, time.indexOf("h")));
			else hours = 0;
			
			if(time.contains("m")) minutes = Integer.parseInt(time.substring(time.indexOf(" "), time.indexOf("m")).trim());
			else minutes = 0;
			
			int temp = hours*60;
			minutes = temp + minutes;
			String newTime = minutes + "min";
			
			return newTime;
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getMpaa() {
		try {
			String innerhtml = userAgent.doc.findFirst("<div class=subtext>").innerHTML();
			if(innerhtml != "" && innerhtml != null && innerhtml.contains(">") && innerhtml.contains("<span")) {
				innerhtml = innerhtml.substring(innerhtml.indexOf(">") + 1, innerhtml.indexOf("<span")).trim();
			} else innerhtml = "NOT FOUND";
			return innerhtml;
			//return userAgent.doc.findFirst("<div class=txt-block>").findFirst("<span>").getText();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getGenres() {
		String genreString = "";
		String[] genres = {"Action", "Comedy", "Family", "History", "Mystery", "Sci-Fi", "War", "Adventure", "Crime", "Fantasy", "Horror", "News", "Sport", "Western", "Animation", "Documentary", "Film-Noir", "Music", "Reality-TV", "Talk-Show", "Biography", "Drama", "Game-Show", "Musical", "Romance", "Thriller"};
		try {
			for(Element e : userAgent.doc.findFirst("<div class=subtext>").findEvery("<span>")) {
				for(int i = 0; i < genres.length; i++) {
					if(genres[i].equalsIgnoreCase(e.getText())) {
						if(genreString.length() < 1) {
							genreString = genreString +  e.getText();
						} else genreString = genreString +  ", " + e.getText();
					}
				}
			}
			return genreString.trim();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getRating() {
		try {
			return userAgent.doc.findFirst("<span class=rating>").getText().trim();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getGross() {
		try {
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
				temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "business");
			else temp.visit(userAgent.getLocation() + "business");	
			String content = temp.doc.findFirst("<div id=tn15content>").innerHTML();
			if(content.contains("<h5>Gross</h5>")) {
				content = content.substring(content.indexOf("<h5>Gross</h5>") + 14);
				content = content.substring(0, content.indexOf("(")).trim();
				content = content.replace("&#163;", "\u00a3");
				return content.trim();
			} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
			return null;
	}
	
	public String getBudget() {
		try {
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
				temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "business");
			else temp.visit(userAgent.getLocation() + "business");	
			//System.out.println(userAgent.getLocation());
			//System.out.println(temp.getLocation());
			String content = temp.doc.findFirst("<div id=tn15content>").innerHTML();
			if(content.contains("<h5>Budget</h5>")) {
				content = content.substring(content.indexOf("<h5>Budget</h5>") + 15);
				content = content.substring(0, content.indexOf("(")).trim();
				content = content.replace("&#163;", "\u00a3");
				return content.trim();
			} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getProductionCompanies() {
		String companies = "";
		for(Element e : userAgent.doc.findEvery("<div class=txt-block>")) {
			if(e.innerHTML().contains("Production")) {
				for(Element e2 : e.findEvery("<span class=itemprop>")) {
					if(companies.length() < 1) {
						companies = e2.getText();
					} else companies += ", " + e2.getText();
				}
				return companies;
			}
		}
		return null;
	}
	
	public String getMetaScore() {
		try {
			//System.out.println(userAgent.doc.findFirst("<div classs=titleReviewBarItem>").innerHTML());
			//if(!userAgent.doc.findFirst("<div classs=titleReviewBarItem>").findFirst("<span>").getText().contains("("))
			if(!userAgent.doc.findFirst("<div class=titleReviewBarItem>").innerHTML().contains("Metascore")) {
				return "NOT LISTED";
			}
			return userAgent.doc.findFirst("<div class=titleReviewBarItem>").findFirst("<span>").getText().replace("\t",  "").replace("( )", "");
		} catch (JauntException e) {
			
		}
		return "NOT LISTED";
	}
	
	public String getUserReviews() {
		try {
			for(Element e : userAgent.doc.findEvery("<span class=subtext>")) {
				if(e.innerHTML().contains("reviews?")) {
					return e.findFirst("<a>").getText().replace(" user", "");
				}
			}
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getCriticReviews() {
		try {
			for(Element e : userAgent.doc.findEvery("<span class=subtext>")) {
				if(e.innerHTML().contains("reviews?")) {
					for(Element e2 : e.findEvery("<a>")) {
						if(e2.getAt("href").contains("external")) {
							return e2.getText().replace(" critic", "");
						}
					}
				}
			}
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getVotes() {
		try {
			return userAgent.doc.findFirst("<span class=small>").getText();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getReleaseDate() {
		
		
			for(Element e : userAgent.doc.findEvery("<div class=txt-block>")) {
				if(e.innerHTML().contains("Release Date:")) {
					try {
					String temp = e.innerHTML().substring(e.innerHTML().indexOf("</h4>") + 6, e.innerHTML().indexOf("("));
					return temp;
					} catch (NullPointerException er) {
						return "";
					}
					
					
					//return e.getText();
				}
			}
		
	
		return "";
		
	}
	
	public String getWeekendRevenue() {
		try {
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
				temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "business");
			else temp.visit(userAgent.getLocation() + "business");	
			String content = temp.doc.findFirst("<div id=tn15content>").innerHTML();
			if(content.contains("<h5>Opening Weekend</h5>")) {
				content = content.substring(content.indexOf("<h5>Opening Weekend</h5>") + 24);
				content = content.substring(0, content.indexOf("(")).trim();
				content = content.replace("&#163;", "\u00a3");
				return content.trim();
			} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getCountry(){
		
		String country = "";
		try {
			System.out.println("inside try");
			for(Element header : userAgent.doc.findEvery("<div class=txt-block>")) {
				System.out.println("inside for");
				
				
				//if(header.findEvery("<h4>").size() > 0) the line of code below deals with the special case of the movie http://www.imdb.com/title/tt0368725/?ref_=nm_flmg_act_18 The fever. For whatever reason this page does not work well with the findFirst() and 
				if(header.findEvery("<h4>").size() > 0){
					if(header.findFirst("<h4>").getText().contains("Country:") || header.findFirst("<h4>").getText().contains("Country:")) {
						System.out.println("inside if");
						for(Element spans : header.findEvery("<a>")) {
							//if(!spans.innerHTML().contains("span")) return country;
								if(country.length() < 1) {
									country = country +  spans.getText();
									System.out.println(country);
								} else country = country +  ", " + spans.getText();
						}
						System.out.println(country);
						return country;
					}
				}
			}
		} catch(JauntException e) {
			System.out.println(e.getMessage());
		
		}
		
		return null;
		
		
	}

	public int basedOnNovel() {
		try {
			UserAgent temp = new UserAgent();
			
			String location = userAgent.getLocation();
			
			location = location.substring(0, location.lastIndexOf("/") + 1) + "fullcredits";
			
			temp.visit(location);
			
			if(temp.doc.innerHTML().contains("(novel)") || temp.doc.innerHTML().contains("(book)")|| temp.doc.innerHTML().contains("(based on the novel by)") || temp.doc.innerHTML().contains("(based on the book by)")) {
				return 1;
			}
			

		} catch(JauntException e) {
			
		}
		return 0;
	}
	
	public int screenPlayWins() {
		try {
			int numWins = 0;
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
			temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "awards");
			else temp.visit(userAgent.getLocation() + "awards");	
			for(Element table : temp.doc.findEvery("<table class=awards>")) {
				for(Element row : table.findEvery("<tr>")) {
					if(row.innerHTML().contains("<b>Nominated</b>") || row.innerHTML().contains("place</b>")) {
						break;
					}
					for(Element cell : row.findEvery("<td class=award_description>")) {
						if(cell.getText().contains("Screenplay")) {
							//System.out.println(cell.getText());
							numWins++;
						}
					}
				}
			}
			
			return numWins;
		} catch(JauntException e) {
			return 0;
		}
	}
	
	public int screenPlayNominations() {
		try {
			int numNominations = 0;
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
			temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "awards");
			else temp.visit(userAgent.getLocation() + "awards");	
			boolean onWon = false;
			
			for(Element table : temp.doc.findEvery("<table class=awards>")) {
				for(Element row : table.findEvery("<tr>")) {
					if(row.innerHTML().contains("<b>Won</b>") || row.innerHTML().contains("place</b>")) {
						onWon = true;
					}
					if(row.innerHTML().contains("<b>Nominated</b>")) {
						onWon = false;
					}
					if(onWon) continue;
					for(Element cell : row.findEvery("<td class=award_description>")) {

						if(cell.innerHTML().contains("Screenplay")) {
//							System.out.println(cell.getText());
//							System.out.println("----------------------");
							numNominations++;
						}
					}
				}
			}
			
			return numNominations;
		} catch(JauntException e) {
			return 0;
		}
	}
	
	public int screenWriterWins() {
		try {
			int numWins = 0;
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
			temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "awards");
			else temp.visit(userAgent.getLocation() + "awards");	
			for(Element table : temp.doc.findEvery("<table class=awards>")) {
				for(Element row : table.findEvery("<tr>")) {
					if(row.innerHTML().contains("<b>Nominated</b>") || row.innerHTML().contains("place</b>")) {
						break;
					}
					for(Element cell : row.findEvery("<td class=award_description>")) {
						if(cell.getText().contains("Screenwriter")) {
							//System.out.println(cell.getText());
							numWins++;
						}
					}
				}
			}
			
			return numWins;
		} catch(JauntException e) {
			return 0;
		}
	}
	
	public int screenWriterNominations() {
		try {
			int numNominations = 0;
			UserAgent temp = new UserAgent();
			if(userAgent.getLocation().contains("?"))
			temp.visit(userAgent.getLocation().substring(0, userAgent.getLocation().indexOf("?")) + "awards");
			else temp.visit(userAgent.getLocation() + "awards");	
			boolean onWon = false;
			
			for(Element table : temp.doc.findEvery("<table class=awards>")) {
				for(Element row : table.findEvery("<tr>")) {
					if(row.innerHTML().contains("<b>Won</b>") || row.innerHTML().contains("place</b>")) {
						onWon = true;
					}
					if(row.innerHTML().contains("<b>Nominated</b>")) {
						onWon = false;
					}
					if(onWon) continue;
					for(Element cell : row.findEvery("<td class=award_description>")) {

						if(cell.innerHTML().contains("Screenwriter")) {
//							System.out.println(cell.getText());
//							System.out.println("----------------------");
							numNominations++;
						}
					}
				}
			}
			
			return numNominations;
		} catch(JauntException e) {
			return 0;
		}
	}
}
