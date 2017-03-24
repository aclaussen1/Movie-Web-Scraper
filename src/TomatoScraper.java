import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import com.jaunt.component.Form;

public class TomatoScraper {
	
	/**
	 * THIS IS THE CLASS USED FOR ROTTEN-TOMATOES SCRAPING
	 */
	
	String nameOfMovie;
	UserAgent userAgent;
	boolean movieFound = true;
	String movieWriters;
	
	public TomatoScraper(String movieName, String writers) {
		nameOfMovie = movieName;
		try {
		System.out.println("last 3 letters of movie name:" + nameOfMovie.substring(nameOfMovie.length()-3,nameOfMovie.length()));
			if (nameOfMovie.substring(nameOfMovie.length()-3,nameOfMovie.length()).equalsIgnoreCase("the")) {
				//System.out.println(nameOfMovie+ ": this movie starts with the");
				nameOfMovie = "the " + nameOfMovie.substring(0, nameOfMovie.length()-5);
				System.out.println("The name of the movie now is:" + nameOfMovie);
			}
		} catch (Exception e) {
			System.out.println("This movie title must be under 3 words.");
		}
		
		  userAgent = new UserAgent();
		  movieWriters = writers;
	}
	
	public TomatoScraper(String movieName, String tomatoURL, boolean fakeVariable) {
		nameOfMovie = movieName;

		userAgent = new UserAgent();
		try {
			System.out.println("tomatoURL:" + tomatoURL);
			userAgent.visit(tomatoURL);
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean tomatoSearch() {
		 String nameOfMovieWithoutSpaces = nameOfMovie.replace(" ", "%20");
		 
		
		try{
			if (nameOfMovie.equalsIgnoreCase("Fantastic Mr Fox")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1197696_fantastic_mr_fox");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("Marley & Me")) {
				  userAgent.visit("//www.rottentomatoes.com/m/marley_and_me/");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("9")) {
				  userAgent.visit("https://www.rottentomatoes.com/search/?search=9");
				  System.out.println("found the movie 9 on rotten tomato");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("42")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/42_2013");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("12 and holding")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/twelve_and_holding");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("50-50")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/5050_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("ace ventura: pet detective")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/ace_ventura_pet_detective");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("affliction")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/affliction");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("after.life")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/after.life");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("alien: resurrection")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/alien_resurrection");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("alone in the dark")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/alone_in_the_dark");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("anna karenina")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/anna_karenina_2012");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("anonymous")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/anonymous_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("arthur")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/arthur_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("austin powers - international man of mystery")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/austin_powers_international_man_of_mystery");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("austin powers - the spy who shagged me")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/austin_powers_the_spy_who_shagged_me");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("batman and robin")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1077027_batman_and_robin");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the bling ring")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/the_bling_ring_2013");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bodyguard")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1042108_bodyguard");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("boondock saints 2: all saints day")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/boondock_saints_ii_all_saints_day");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("bridesmaids")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/bridesmaids_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("clash of the titans")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/clash_of_the_titans_2010");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("conan the barbarian")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/conan_the_barbarian_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("coriolanus")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/coriolanus_2010");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("crash")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1076271_crash");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("crazy, stupid, love")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/771203531/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("dawn of the dead")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/dawn_of_the_dead");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("death at a funeral")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/death_at_a_funeral_2010");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("defiance")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/10009458_defiance");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("drive")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/drive_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("e.t.")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/et_the_extraterrestrial");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("ed tv")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/edtv");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("escape from l.a.")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/escape_from_la");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("evil dead")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/the_evil_dead");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("evil dead ii: dead by dawn")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/evil_dead_2_dead_by_dawn");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("face off")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/faceoff");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("fair game")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/fair_game_2010");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("flight")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/flight_2012");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("fright night")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/fright_night_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frozen")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/10012051_frozen");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frozen (disney)")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/frozen_2013");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("fury")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/fury_2015");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the girl with the dragon tattoo")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/the_girl_with_the_dragon_tattoo");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("go")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1087053_go");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("gone in 60 seconds")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1097865_gone_in_60_seconds");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("gravity")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/gravity_2013");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("gremlins 2")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/gremlins_2_the_new_batch");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("grosse point blank")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/grosse_pointe_blank");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("hellraiser 3: hell on earth")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/hellraiser_iii_hell_on_earth");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the hills have eyes")) {
				  userAgent.visit("http://www.imdb.com/title/tt0454841/?ref_=nv_sr_1");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the informant")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1200661_informant");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the italian job")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/italian_job");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("jane eyre")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/jane_eyre_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("jennifer eight")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/jennifer_8");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("king kong")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/king_kong");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the last samurai")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/last_samurai");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("les miserables")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/les_miserables_2012");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("man in the iron mask")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1082400_man_in_the_iron_mask");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the manchurian candidate")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/manchurian_candidate");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("margaret")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/margaret_2010/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("mariachi, el")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/el_mariachi");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenstein")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/mary_shelleys_frankenstein/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("master and commander")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/master_and_commander_the_far_side_of_the_world");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the mechanic")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/mechanic");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("men in black 3")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/men_in_black_iii");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("milk")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/milk");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("mirrors")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1197016_mirrors");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("monte carlo")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/monte_carlo_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("a nightmare on elm street")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/nightmare_on_elm_street");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("oblivion")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/oblivion_2013");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("obsessed")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1207523_obsessed");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("officer and a gentleman, an")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/officer_and_a_gentleman");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("pariah")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/pariah_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("a perfect world")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/perfect_world");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("Pi")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/pi/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("priest")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/10009274_priest");
				  movieFound=true;
				  return true;
			  } else if (nameOfMovie.equalsIgnoreCase("the producer")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1016819_producers");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the proposal")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/10010458_proposal");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("public enemies")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/10009526_public_enemies");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("red riding hood")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/girl_with_the_red_riding_hood");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("remember me")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1211619_remember_me");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the revenant")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/the_revenant_2015");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("rush")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/rush_2013/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("s. darko")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/s_darko_a_donnie_darko_tale");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("se7en")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/seven");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("sex, lies and videotape")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/sex_lies_and_videotape");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("shame")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/shame_2011");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("silver bullet")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/stephen_kings_silver_bullet");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("south park")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/south_park_bigger_longer_and_uncut");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("star trek: generations")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/star_trek_generations");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("star trek: nemesis")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/star_trek_nemesis");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("star wars: a new hope")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/star_wars");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("sunset blvd.")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/sunset_boulevard");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("ted")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/ted_2012");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the tourist")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/tourist");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the thing")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1021244_thing");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the time machine")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/1112951_time_machine");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("tristan and isolde")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/10004209_tristan_and_isolde");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("tron: legacy")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/10011582_TRON_legacy");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("true grit")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/true_grit_2010");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("twilight")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/twilight");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("twilight: new moon")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/twilight_saga_new_moon");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("twin peaks")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/twin_peaks_fire_walk_with_me");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("u turn")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/u_turn_1997");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("unknown")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/unknown_white_male");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("up")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/up/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("a walk to remember")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/walk_to_remember");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("the way back")) {
				  
				  movieFound=false;
				  return false;
			  }else if (nameOfMovie.equalsIgnoreCase("x-men origins: wolverine")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/wolverine");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("big eyes")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/big_eyes");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("birdman")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/birdman_of_alcatraz/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("frankenweenie")) {
				  userAgent.visit("https://www.rottentomatoes.com/m/frankenweenie_2012");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("tristan and isolde")) {
				  userAgent.visit("//www.rottentomatoes.com/m/marley_and_me/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("tristan and isolde")) {
				  userAgent.visit("//www.rottentomatoes.com/m/marley_and_me/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("tristan and isolde")) {
				  userAgent.visit("//www.rottentomatoes.com/m/marley_and_me/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("tristan and isolde")) {
				  userAgent.visit("//www.rottentomatoes.com/m/marley_and_me/");
				  movieFound=true;
				  return true;
			  }else if (nameOfMovie.equalsIgnoreCase("tristan and isolde")) {
				  userAgent.visit("//www.rottentomatoes.com/m/marley_and_me/");
				  movieFound=true;
				  return true;
			  }
			  else if(movieWriters.contains("http")) {
				userAgent.visit(movieWriters);
				return true;
			  }
			  
			  nameOfMovieWithoutSpaces = nameOfMovie.replace(" ", "%20");
			  System.out.println("TomatoScaper is visiting this url: " + "https://www.rottentomatoes.com/search/?search=" + nameOfMovieWithoutSpaces.replace("the", ""));
			  
			  try {
			  userAgent.visit("https://www.rottentomatoes.com/search/?search=" + nameOfMovieWithoutSpaces.replace("the", ""));
			  } catch (Exception e) {
				  System.out.println("here32.");
			  }
			  
			  //System.out.println("RT: " + userAgent.getLocation());
			  //if(!userAgent.getLocation().contains("/m/"))
			  //userAgent.visit(userAgent.doc.findFirst("<div id=results_movies_tab>").findFirst("<a>").getAt("href"));
			  //userAgent.visit(userAgent.doc.findFirst("<table class=\"results\">").findFirst("<tr class=\"even detailed\">").findFirst("<a>").getAt("href"));
			  //System.out.println(userAgent.getLocation());
			  

			  for(Element element : userAgent.doc.findEvery("<script>")) {
				if (element.getText().contains("require(['jquery', 'globals', 'search-results', 'bootstrap'],")) {
					
				}
				  //System.out.println("element.getText in Tomato Scraper: " + element.getText() + );
				  
				  if (element.getText().contains("mount($(")) {
					  //System.out.println("ROTTEN TOMATOES Movie: " + element.getText() + " - OUR Movie: " + nameOfMovie.replace(", The", "").replace(", A",  ""));
					  
					  /*
					   * In the HTML document for tomato, it looks like this for the search results:
					   *  require(['jquery', 'globals', 'search-results', 'bootstrap'], function($, RT, mount) {
                            mount($("#search-results-root").get(0), RT.PrivateApiV2FrontendHost, 'ides of march,', {"actorCount":0,"criticCount":0,"franchiseCount":0,"movieCount":1,"movies":[{"name":"The Ides of March","year":2011,"url":"/m/the_ides_of_march","image":"https://resizing.flixster.com/MHDjhbdL6eNXRkiVjU21HesDKzM=/fit-in/80x80/v1.bTsxMTE2Mzc2OTtqOzE3MzE5OzEyMDA7NjQwOzk2MA","meterClass":"certified_fresh","meterScore":84,"castItems":[{"name":"Ryan Gosling","url":"/celebrity/ryan_gosling"},{"name":"George Clooney","url":"/celebrity/george_clooney"},{"name":"Philip Seymour Hoffman","url":"/celebrity/philip_seymour_hoffman"}],"subline":"Ryan Gosling, George Clooney, Philip Seymour Hoffman, "}],"tvCount":0});
                        });
                        We want to isolate the JSON data. The JSON data begins at the second "{".
                        the int i is the index of the first occurance of "{", i2 is the second occurence.
					   */
					  
					  int i = element.getText().indexOf("{");
					  int i2 = element.getText().indexOf("{",i+1
							  );
					  int ending = element.getText().indexOf(");");
					  String JSONstring = element.getText().substring(i2, ending);
					  System.out.println("JSONSTRING: " + JSONstring);
					  
					  JSONObject obj = new JSONObject(JSONstring);
					  JSONArray arr = obj.getJSONArray("movies");
					  for (int j = 0; j < arr.length(); j++)
					  {
					      String JSONmovieName = arr.getJSONObject(j).getString("name");
					      System.out.println("tomato search generated this movie name:" + JSONmovieName);
					      if (JSONmovieName.equalsIgnoreCase(nameOfMovie)) {
					    	  System.out.println("User agent is visiting:https://www.rottentomatoes.com" + arr.getJSONObject(j).getString("url"));
					    	  userAgent.visit("https://www.rottentomatoes.com" + arr.getJSONObject(j).getString("url"));
					    	  movieFound=true;
							  return true;
					      }
					  }
				  }
				  if(element.getText().replace("The ", "").contains(nameOfMovie.replace(", The", "").replace(", A", ""))) {
					  userAgent.visit(element.getAt("href"));
					  
					  boolean found = false;
					  //System.out.println(userAgent.getLocation());
					  for(Element element2 : userAgent.doc.findEvery("<div>")) {
						  if(found == true) {
							  for(Element element3 : element2.findEvery("<span>")) {
								  if(movieWriters.replaceAll("[^a-zA-Z ]", "").toLowerCase().contains(element3.getText().replaceAll("[^a-zA-Z ]", "").toLowerCase())) {
									  //System.out.println("MOVIE MATCH Tomato");
									  return true;
								  }
							  }
							  break;
						  }
						  if(element2.getText().contains("Written By")) {
							  found = true;
							  continue;
						  }
					  }
					  continue;
				  }
			  }
			  System.out.println(userAgent.getLocation());
			  return false;
			}
			catch(JauntException e){ 
				try {
					System.out.println("Visiting: " + userAgent.visit("https://www.rottentomatoes.com/m/" + nameOfMovie.replace(" ",  "_")));
					movieFound = true;
					userAgent.visit("https://www.rottentomatoes.com/m/" + nameOfMovie.replace(" ",  "_"));
					movieFound = true;
				}
				catch(JauntException e2) {
					movieFound = false;
				}

			}
		return false;
	}
	
	public String getTomatorMeterRating() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {  
		if(movieFound == true) {
			//System.out.println(userAgent.doc.innerHTML());
			for(Element element : userAgent.doc.findEvery("<span>")) {
				  if(element.innerHTML().contains("<span>")) {
					  return element.findFirst("<span>").getText();
				  }
			 }
			return "";
		} else return null;
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getTomatoYear()  {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try{
			return userAgent.doc.findFirst("<time").getText();
		} catch(JauntException e) {
			
		} 
		return "NOT LISTED";
	}
	
	public String getAverageCriticRating() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {
			if(userAgent.doc.findFirst("<div class=superPageFontColor>").getText().contains("/"))
			return userAgent.doc.findFirst("<div class=superPageFontColor>").getText().trim();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getAudienceScore() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		try {
			int index = 0;
			return userAgent.doc.findFirst("<div class=meter-value>").findFirst("<span>").getText();
		} catch(JauntException e) {
			
		}
		return null;
	}
	
	public String getNumberCriticReviews() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {
			int index = 0;
			for(Element e : userAgent.doc.findEvery("<div class=superPageFontcolor>")) {
				if(index == 1) {
					int index2 = 0;
					for(Element e2 : e.findEvery("<span>")) {
						if(index2 == 1) {
							return e2.getText();
						}
						index2++;
					}
				}
				index++;
			}
//		} catch(JauntException e) {
//			
//		}
		return null;
	}
	
	public String getGenres() {
		if(movieFound == false) return "MOVIE NOT FOUND";
		
		String tomatoGenres = "";
		
		Elements potentialMovieSections = userAgent.doc.findEvery("<li class='meta-row clearfix'>");
		
		Element movieSection = null;
		//int index =0;
		for (Element e: potentialMovieSections) {
			//System.out.println("index: " + index);
			//index++;
			/*
				try {
					System.out.println(e.findFirst("div").getText());
				} catch (NotFound e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			*/
				try {
					if(e.findFirst("div").getText().contains("Genre") || e.findFirst("div").getText().contains("Genres")) {
						movieSection = e;
						System.out.println("found genres in tomato");
						
					}
				} catch (NotFound e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		Elements genreHTMLElements = movieSection.findEvery("a");
		for (Element el: genreHTMLElements) {
			System.out.println(el.getText().trim());
			
			if (tomatoGenres.equalsIgnoreCase("")) {
				//first genre
				tomatoGenres += el.getText().trim();
			} else {
				//this genre is second or later...
				tomatoGenres += ", " + el.getText().trim();
			}
			
		}
		
		return tomatoGenres;
	}
	
	
	public String getAudienceRating() {
		if(movieFound == false) return "MOVIE NOT FOUND";
//		try {
			for(Element e : userAgent.doc.findEvery("<div>")) {
				if(e.innerHTML().contains("Average")) {
					if(e.getText().contains("/5")) {
						return e.getText().trim();
					}
				}
			}
//		} catch(JauntException e) {
//			
//		}
		return null;
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
	
}
