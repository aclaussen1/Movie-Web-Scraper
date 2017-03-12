import com.jaunt.Element;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class MojoScraper {
	String nameOfMovie;
	UserAgent userAgent;
	boolean movieFound = false;
	String movieWriters;
	
	/**
	 * 
	 * @param movieName
	 * @param writers
	 *
	 *	THIS IS THE BOX-OFFICE MOJO SCRAPING CLASS
	 *
	 */
	
	public MojoScraper(String movieName, String writers) {
		nameOfMovie = movieName;
		  userAgent = new UserAgent();
		movieWriters = writers;
	}
	
	public boolean mojoSearch() {
		try{
			 if (nameOfMovie.equalsIgnoreCase("Fantastic Mr Fox")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=fantasticmrfox.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Fantastic Mr Fox")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=fantasticmrfox.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("12 and holding")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=twelveandholding.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("2001: a space odyssey")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=2001.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("50-50")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=50fifty.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("50-50")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=50fifty.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("a nightmare on elm street")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=elmst.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("a perfect world")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=perfectworld.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("a.i.")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=ai.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("adaptation")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=adaptation.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("airplane")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=airplane.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("american werewolf in london")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=americanwerewolfinlondon.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("angels & demons")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=angelsanddemons.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("apocalypse now")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=apocalypsenow.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("arsenic and old lace")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=arsenicandoldlace.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bodies, rest & motion")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=bodiesrestandmotion.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("body heat")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=bodyheat.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bonfire of the vanities")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=bonfireofthevanities.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bonnie and clyde")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=bonnieandclyde.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("cable guy")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=cableguy.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("casablanca")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=casablanca.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("charade")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=charade.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("chinatown")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=chinatown.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("cowboys & aliens")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=cowboysandaliens.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("crying game")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=cryinggame.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("dog day afternoon")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=dogdayafternoon.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("four feathers")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=fourfeathers.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("frankenstein")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=frankenstein.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("friday the 13th part viii: jason takes manhattan")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=friday13th8.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("house of 1000 corpses")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=houseof1000corpses.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("i love you phillip morris")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=iloveyouphillipmorris.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("i, robot")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=irobot.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("jaws 2")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=jaws2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("land of the dead")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=landofthedead.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("lock, stock and two smoking barrels")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=lockstockandtwosmokingbarrels.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("lord of the rings: return of the king")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=iloveyouphillipmorris.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("marty")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=marty.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("master and commander")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=masterandcommander.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mean streets")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=meanstreets.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("men in black 3")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("midnight cowboy")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=midnightcowboy.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mighty morphin power rangers: the movie")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=powerrangers.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("mission impossible")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=missionimpossible.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("pirates of the caribbean")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=piratesofthecaribbean.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("platinum blonde")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mib3.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("predator")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=predator.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("rear window")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=rearwindow.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=9.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=42.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("2012")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=2012.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("500 days of summer")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=500daysofsummer.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("airplane 2: the sequel")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=airplane2.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("alien")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=alien.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("alien: resurrection")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=alienresurrection.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("anonymous")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=anonymous.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("austin powers - international man of mystery")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=austinpowers.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("austin powers - the spy who shagged me")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=austinpowers2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("avengers, the (2012)")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=avengers11.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("beloved")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=beloved.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("big")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=big.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the blast from the past")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=blastfromthepast.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bodyguard")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=bodyguard.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("boondock saints 2: all saints day")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=boondocksaints2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("carrie")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=carrie.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("chronicles of narnia: the lion, the witch and the wardrobe")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=narnia.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("crash")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=crash.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("crazy, stupid, love")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=crazystupidlove.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("crouching tiger, hidden dragon")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=crouchingtigerhiddendragon.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the day the earth stood still")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=daytheearthstoodstill.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("devil's advocate")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=devilsadvocate.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("die hard 2")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=diehard2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("donnie darko")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=donniedarko.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("e.t.")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=et.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("ed tv")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=edtv.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("evil dead")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=evildead.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("evil dead ii: dead by dawn")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=evildead2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the fabulous baker boys")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=fabulousbakerboys.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("face off")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=faceoff.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("fantastic four")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=fantasticfour.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("fright night (1985)")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=frightnight.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frozen")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=frozen.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frozen (disney)")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=frozen2013.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the getaway")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=getaway72.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("ghostbusters 2")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=ghostbusters2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("glengarry glen gross")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=glengarryglenross.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("go")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=go.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("godfather")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=godfather.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("godfather part ii")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=godfather2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("godzilla")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=godzilla.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("gremlins 2")) {
				  userAgent.visit("http://www.boxofficemojo.com/search/?q=gremlins%202");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("grosse point blank")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=grossepointeblank.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("heist")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=heist.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("hellboy 2: the golden army")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=hellboy2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("hellraiser 3: hell on earth")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=hellraiser3.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("indiana jones and the raiders of the lost ark")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=raidersofthelostark.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the informant")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=informant.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("jennifer eight")) {
				  userAgent.visit("www.boxofficemojo.com/movies/?id=jennifereight.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("john q")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=johnq.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("jurassic park: the lost world")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=jurassicpark2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("kill bill volume 1 & 2")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=killbill.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("kramer vs kramer")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=kramervskramer.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("legend")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=legend.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("leviathan")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=leviathan.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("life")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=life.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the lord of the rings: fellowship of the ring")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=fellowshipofthering.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("lord of the rings: return of the king")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=returnoftheking.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("lord of the rings: the two towers")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=twotowers.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("love and basketball")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=loveandbasketball.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("mad max 2: the road warrior")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=roadwarrior.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("majestic, the (the bijou)")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=majestic.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("man in the iron mask")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=manintheironmask.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("mariachi, el")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=elmariachi.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("mission impossible ii")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mi2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("mr brooks")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mrbrooks.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the mummy")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mummy.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("my best friend's wedding")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=mybestfriendswedding.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the nightmare before christmas")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=nightmarebeforechristmas.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("a nightmare on elm street")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=elmst.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("o brother where art thou?")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=obrotherwhereartthou.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("officer and a gentleman, an")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=officerandagentleman.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("a perfect world")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=perfectworld.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("pi")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=pi.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the planet of the apes")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=planetoftheapes.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("point break")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=pointbreak.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("precious")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=preciouspush.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("pretty woman (final script)")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=prettywoman.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the program")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=program.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("psycho")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=psycho.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("rambo: first blood ii: the mission")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=rambo2.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the road")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=road08.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("romeo & juliet")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=romeoandjuliet.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("s. darko")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/intl/?page=&country=UE&id=_fSDARKO01");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the sandlot kids")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=sandlot.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("scott pilgrim vs the world")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=scottpilgrim.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("sex, lies and videotape")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=sexliesandvideotape.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("silence of the lambs")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=silenceofthelambs.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("south park")) {
				  userAgent.visit("http://www.boxofficemojo.com/search/?q=south%20park");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("star wars: a new hope")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=starwars4.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("star wars: attack of the clones")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=starwars2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("star wars: return of the jedi")) {
				  userAgent.visit("http://www.boxofficemojo.com/search/?q=return%20of%20the%20jedi");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("star wars: revenge of the sith")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=starwars3.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("star wars: the empire strikes back")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=starwars5.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("star wars: the phantom menace")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=starwars.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("sugar and spice")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=suguarandspice.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("sunset blvd.")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=sunsetboulevard.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("synecdoche, new york")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=synecdochenewyork.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the taking of pelham one two three")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=takingofpelham09.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("terminator")) {
				  userAgent.visit("http://www.boxofficemojo.com/search/?q=terminator");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("terminator 2: judgement day")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=terminator2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("they")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=they.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the thing")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=thing.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("three kings (spoils of war)")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=threekings.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the three musketeers")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=threemusketeers.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("tinker tailor soldier spy")) {
				  userAgent.visit("http://www.boxofficemojo.com/search/?q=tinker%20tailor%20soldier%20spy");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("total recall")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=totalrecall.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("tron: legacy")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=tron2.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("12 monkeys")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=twelvemonkeys.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("twilight: new moon")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=newmoon.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("twin peaks")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=twinpeaksfirewalkwithme.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("u turn")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=u-turn.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Up")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=up.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("a walk to remember")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=walktoremember.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("wanted")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=wanted.htm");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("when a stranger calls")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=whenastrangercalls.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("who framed roger rabbit?")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=whoframedrogerrabbit.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("withnail and i")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=withnailandi.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the world is not enough")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=worldisnotenough.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the x-files: fight the future")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=x-filesfightthefuture.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("birdman")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=crazystupidlove.htm");
				  //movieFound=true;
				  return false;
			  }else if (nameOfMovie.equalsIgnoreCase("se7en")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=seven.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("crazy, stupid, love")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=crazystupidlove.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("crazy, stupid, love")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=crazystupidlove.htm");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("crazy, stupid, love")) {
				  userAgent.visit("http://www.boxofficemojo.com/movies/?id=crazystupidlove.htm");
				  movieFound=true;
				  return true;
			  }
			 else if(movieWriters.contains("http")) {
				  userAgent.visit(movieWriters);
				  movieFound = true;

				  return true;
			  } else {

				  if(nameOfMovie.contains(", The")) {
					  nameOfMovie = nameOfMovie.replace(", The",  "");
					  nameOfMovie = "The " + nameOfMovie;
					  System.out.println("name of movie in mojo scrapper became:" + nameOfMovie);
				  }
				  if(nameOfMovie.contains(", A")) {
					  nameOfMovie = nameOfMovie.replace(", A", "");
					  nameOfMovie = "A " + nameOfMovie;
					  System.out.println("name of movie in mojo scrapper became:" + nameOfMovie);
				  } if(nameOfMovie.contains(",")) {
					  nameOfMovie = nameOfMovie.replace(",", "");
					  System.out.println("name of movie in mojo scrapper became:" + nameOfMovie);
				  }
				  if (nameOfMovie.substring(nameOfMovie.length()-3,nameOfMovie.length()).equalsIgnoreCase("the")) {
						//System.out.println(nameOfMovie+ ": this movie starts with the");
						nameOfMovie = "the " + nameOfMovie.substring(0, nameOfMovie.length()-4);
						System.out.println("The name of the movie now in mojoScaper is:" + nameOfMovie);
					}
				  System.out.println("movieName:" + nameOfMovie);
				  System.out.println("mojo user agent is visiting: " + "http://www.boxofficemojo.com/search/?q=" + nameOfMovie.replace(" ", "%20") );
				  userAgent.visit("http://www.boxofficemojo.com/search/?q=" + nameOfMovie.replace(" ", "%20"));
				  
			  //System.out.println(nameOfMovie);
			  String[] writerNames;
			  
			  if(movieWriters.length() > 0) writerNames = movieWriters.split(",");
			  else return false;
			  
			  for(Element element : userAgent.doc.findEvery("<a>")) {
				  String temp = element.getText().toLowerCase();
				  //System.out.println(temp);
				  String year;
				  boolean old = false;
				  if(temp.contains("(")) {
					  year = temp.substring(temp.indexOf("("));
					  temp = temp.replace(year, "").trim();
					  old = true;
				  }
				  
				  //System.out.println("BOX OFFICE MOJO Movie: " + temp.replace("the ", "") + " - OUR Movie: " + nameOfMovie.replace(", The", "").replace(", A",  "").toLowerCase());
				  nameOfMovie = nameOfMovie.replace("&", "and");
				  //System.out.println("The variable called temp (name of movie in mojo): " + temp);
				  if( temp.equals(nameOfMovie.toLowerCase())) {
					  System.out.println("mojo user Agent is visiting:" + element.getAt("href"));
					  userAgent.visit(element.getAt("href"));
					  movieFound = true;
					  return true;
//					  for(int i = 0; i < writerNames.length; i++) {
//						  //System.out.println(writerNames[i]);
//						  //System.out.println(userAgent.doc.findFirst("<div class=mp_box_content>").innerHTML());
//						  if(userAgent.doc.innerHTML().toLowerCase().contains(writerNames[i].replaceAll("[^a-zA-Z ]", "").toLowerCase())) {
//							  movieFound = true;
//							  //System.out.println("Movie match MOJO");
//							  return true;
//						  }
//						  if(old == true) {
//							  movieFound = true;
//							  return true;
//						  }
//					  }
//					  continue;
				  }
			  }
			  return false;
			  }
			}
			catch(JauntException e){ 
				try {
					userAgent.visit("https://www.rottentomatoes.com/m/" + nameOfMovie.replace(" ",  "_"));
					movieFound = true;
				}
				catch(JauntException e2) {
					movieFound = false;
				}

			}
		return movieFound;
	}
	
	public String getMojoDomesticGross() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<font>")) {
				  if(element.getText().contains("Domestic Total Gross")) {
					  return element.findFirst("<b>").getText();
				  }
			 }
		} else return "FoundButNotListed";
		} catch(JauntException e) {
			
		}
		return "FoundButNotListed";
	}
	
	public String getMojoYear() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<td>")) {
				//System.out.println("here1");
				  if(element.getText().contains("Release Date")) {
					  //System.out.println("here2");
					  return element.findFirst("<a>").getText();
				  }
			 }
		} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return "NOT LISTED";
	}
	
	public String getMojoForeignGross() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			boolean found = false;
			for(Element element : userAgent.doc.findEvery("<td width='35%'>")) {
				  //System.out.println(element.innerHTML());
				  if(found == true) {
					  return element.getText().replace("&nbsp;", "");
				  }
				  
				  if(!element.getText().contains("<b>")) {
					  found = true;
				  }
			 }
		} else return "NOT LISTED";
//		} catch(JauntException e) {
//			
//		}
		return "NOT LISTED";
	}
	
	public String getMojoWorldGross() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			int found = 0;
			for(Element element : userAgent.doc.findEvery("<td width='35%'>")) {
				  if(element.innerHTML().contains("<b>")) {
					  found++;
				  }
				  if(found == 2) {
					  return element.innerHTML().replace("&nbsp;", "").replace("<b>", "").replace("</b>", "");
				  }
			 }
		} else return "NOT LISTED";
//		} catch(JauntException e) {
//			
//		}
		return "NOT LISTED";
	}
	
	public String getMojoOpeningWeekendRevenue() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			boolean found = false;
			for(Element element : userAgent.doc.findEvery("<div class=mp_box_content>")) {
				if(element.innerHTML().contains("Opening&nbsp;Weekend:")) {
					boolean wide = false;
					for(Element element2: element.findEvery("<td>"))  {
						if(element.innerHTML().contains("Wide&nbsp;Opening&nbsp;Weekend")) {
							wide = true;
						}
						  if(found == true) {
							  return element2.getText().replace("&nbsp;", "").trim().replace("\n", "");
						  }
						  if(element2.innerHTML().contains("Opening&nbsp;Weekend") && wide == false) found = true;
						  if(element2.innerHTML().contains("Wide&nbsp;Opening&nbsp;Weekend")) found = true;
						//System.out.println(element2.innerHTML());
					}
				}

			 }
		} else return "NOT LISTED";
//		} catch(JauntException e) {
//			
//		}
		return "NOT LISTED";
	}
	
	public String getMojoNumbTheatres() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			boolean found = false;
			for(Element element : userAgent.doc.findEvery("<div class=mp_box_content>")) {
				boolean wide = false;
				int index = 0;
				for(Element element2: element.findEvery("<td align=center>"))  {
					if(element.innerHTML().contains("Wide&nbsp;Opening&nbsp;Weekend")) {
						wide = true;
					}
					if(index == 1 && wide == false) {
						String temp = element2.findFirst("<font>").getText().replace(" theaters", "");
						if(temp.split(", ").length > 1)
							return temp.split(", ")[1];
						else return "NOT LISTED";
					}
					if(index == 4 && wide == true) {
						String temp = element2.findFirst("<font>").getText().replace(" theaters", "");;
						if(temp.split(", ").length > 1)
							return temp.split(", ")[1];
						else return "NOT LISTED";
					}
						index++;
				}

			 }
		} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return "NOT LISTED";
	}
	
	public String getMojoRevPerTheatre() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			boolean found = false;
			for(Element element : userAgent.doc.findEvery("<div class=mp_box_content>")) {
				boolean wide = false;
				int index = 0;
				for(Element element2: element.findEvery("<td align=center>"))  {
					if(element.innerHTML().contains("Wide&nbsp;Opening&nbsp;Weekend")) {
						wide = true;
					}
					if(index == 1 && wide == false) {
						String temp = element2.findFirst("<font>").getText();
						if(temp.split(", ").length > 2)
							return temp.split(", ")[2].replace(" average)", "");
						else return "NOT LISTED";
						
					}
					if(index == 4 && wide == true) {
						String temp = element2.findFirst("<font>").getText();
						if(temp.split(", ").length > 2)
							return temp.split(", ")[2].replace(" average)", "");
						else return "NOT LISTED";
					}
						index++;
				}

			 }
		} else return "NOT LISTED";
		} catch(JauntException e) {
			
		}
		return "NOT LISTED";
	}
	
	public String getNumberUserRatings() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {
			int index = 0;
			for(Element e : userAgent.doc.findEvery("<div>")) {
				//System.out.println(e.getText().trim());
				if(e.innerHTML().contains("User Ratings") && e.innerHTML().contains("subtle superPageFontColor")) {
					index++;
					String temp = e.getText().trim();
					if(index == 8) return temp;
				}
			}
		} catch(Exception e) {
			
		}
		return null;
	}
	
	public String getBudget() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {

			for(Element e : userAgent.doc.findEvery("<td valign='top'>")) {
				if(e.innerHTML().contains("Production Budget:")) {
					String temp1 =  e.innerHTML().substring(e.innerHTML().indexOf("Production Budget:") + 19);
					//System.out.println(temp1);
					String temp = temp1.substring(0, temp1.indexOf("</b>"));
					temp = temp.replace("<b>", "");
					return temp.replace(" million", ",000,000");
				}
				else return "NOT LISTED";
			}
		} catch(Exception e) {
			
		}
		return null;
	}
	
	public String getDistributor() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {

			for(Element e : userAgent.doc.findEvery("<td valign='top'>")) {
				if(e.innerHTML().contains("Distributor:")) {
					String temp1 =  e.innerHTML().substring(e.innerHTML().indexOf("Distributor:") + 11);
					//System.out.println(temp1);
					temp1 = temp1.replace("<b>", "").replace("</b>", "");
					String temp = temp1.substring(temp1.indexOf(">") + 1, temp1.indexOf("</a>"));
					return temp;
				}
				else return "NOT LISTED";
			}
		} catch(Exception e) {
			
		}
		return null;
	}
}
