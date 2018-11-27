package exam1;

import java.io.*;
import java.net.URL;
import java.util.*;


public class NFLdata {
	//number of players
	static int players = 0;

	//defining the whole dataset as an arraylist of datapoints
	static ArrayList<DataPoint> data = new ArrayList<DataPoint>();

	//defining each team as a separate arraylist of datapoints
	static ArrayList<DataPoint> CIN = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> NWE = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> GNB = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> MIN = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> NYG = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> CLE = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> SFO = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> ARI = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> WAS = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> CHI = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> DEN = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> DAL = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> HOU = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> IND = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> BAL = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> MIA = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> SEA = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> PIT = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> SDG = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> CAR = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> TAM = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> STL = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> NYJ = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> JAX = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> BUF = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> KAN = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> OAK = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> PHI = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> DET = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> NOR = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> TEN = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> ATL = new ArrayList<DataPoint>();


	//returns the buffered reader from a passage of text online
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		return new BufferedReader(isr); //reads the input of a line one at a time
	}

	//takes the BR and scans each line and adds it to the data arraylist
	public static void analyseData(BufferedReader reader) throws IOException {
		String line = "";
		reader.readLine();
		reader.readLine();
		reader.readLine();
		while ((line = reader.readLine()) != null) { //reads every line from the buffer and checks if its not null
			Scanner s = new Scanner(line).useDelimiter("\t");
			while (s.hasNext()) {
				DataPoint dp = new DataPoint(s.next(),s.next(),s.next(),Double.parseDouble(s.next()),Double.parseDouble(s.next()),Double.parseDouble(s.next()),
						Double.parseDouble(s.next()),Double.parseDouble(s.next()),Double.parseDouble(s.next()),Double.parseDouble(s.next()),Double.parseDouble(s.next()),
						Double.parseDouble(s.next()));
				data.add(dp);
				players++;
			}
			s.close(); //closes the scanner
		}
	}
	//finds the player with the most rushing yards
	public static String mostRuYds(ArrayList<DataPoint> sample) {
		double lRuYds = 0;
		int index = 0;

		for (int i = 0; i < sample.size(); i++) {
			if (lRuYds == 0) {
				lRuYds = sample.get(i).getRuYds(); //first element of the array is set to the 'largest'
			}
			if (lRuYds < sample.get(i).getRuYds()) {
				lRuYds = sample.get(i).getRuYds();
				index = i; //allows me to find the index after
			}
		}
		return "The player with the most rushing yards is \n" + sample.get(index).toString();
	}

	//finds the player who gained the most all purpose yards (sum of receiving and rushing yards)
	public static String mostAllYards(ArrayList<DataPoint> sample) {
		double lYards = 0;
		int index = 0;
		for (int i = 0; i < sample.size(); i++) {
			if (lYards == 0) {
				lYards = sample.get(i).getRuYds() + sample.get(i).getReYds();
			}
			if (lYards < sample.get(i).getRuYds() + sample.get(i).getReYds()) {
				lYards = sample.get(i).getRuYds() + sample.get(i).getReYds();
				index = i;
			}
		}
		return "The player with the all purpose yards is \n" + sample.get(index).toString() + "All purpose yards: " + lYards + "\n";
	}

	//finds the number of players that have touched the ball more than 10 times
	public static int more10TouchNumber(ArrayList<DataPoint> sample) {
		int count = 0;
		for (int i = 0; i < sample.size(); i++) {
			if (sample.get(i).getAtt() + sample.get(i).getTgt() > 10) {
				count++;
			}
		}
		return count;
	}

	//returns an array of datapoints of the players that have touched the ball more than 10 times
	public static ArrayList<DataPoint> more10TouchArray(ArrayList<DataPoint> sample) {
		ArrayList<DataPoint> more10touch = new ArrayList<DataPoint>();
		for (int i = 0; i < sample.size(); i++) {
			if (sample.get(i).getAtt() + sample.get(i).getTgt() > 10) {
				more10touch.add(sample.get(i));
			}
		}
		return more10touch;
	}

	//returns the player who was the greatest liability to the team
	public static String fewestYards(ArrayList<DataPoint> sample) throws Exception {
		ArrayList<Double> fYards = new ArrayList<Double>();
		ArrayList<Double> fYardsUnsort = new ArrayList<Double>();
		for (int i = 0; i < sample.size(); i++) {
			if (sample.get(i).getAtt() + sample.get(i).getTgt() == 0) {
				throw new Exception("Number of touches is 0!, cannot divide by 0.");
			}
			fYards.add((sample.get(i).getRuYds() + sample.get(i).getReYds())/(sample.get(i).getAtt() + sample.get(i).getTgt())); //equation given
		}
		fYardsUnsort = fYards; //saves the old array before it is sorted
		Collections.sort(fYards);
		return sample.get(fYardsUnsort.indexOf(fYards.get(0))).toString();
	}

	//returns the player who dropped the ball more often than his team mates
	public static String droppedOften(ArrayList<DataPoint> sample) throws Exception {
		ArrayList<Double> dOften = new ArrayList<Double>();
		ArrayList<Double> dOftenUnsort = new ArrayList<Double>();
		for (int i = 0; i < sample.size(); i++) {
			if (sample.get(i).getAtt() + sample.get(i).getTgt() == 0) {
				throw new Exception("Number of touches is 0!, cannot divide by 0.");
			}
			dOften.add(((sample.get(i).getTgt() - sample.get(i).getRec()) + sample.get(i).getFmb())/(sample.get(i).getAtt() 
					+ sample.get(i).getTgt())); //equation given
		}
		dOftenUnsort = dOften;
		Collections.sort(dOften);
		return sample.get(dOftenUnsort.indexOf(dOften.get(0))).toString();
	}

	//adds an array of players to their respective teams array
	public static void teamsToArray(ArrayList<DataPoint> sample) {
		for (int i = 0; i < sample.size(); i++) {
			if(sample.get(i).getTeam().equals("CIN")) {
				CIN.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("NWE")) {
				NWE.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("GNB")) {
				GNB.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("MIN")) {
				MIN.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("NYG")) {
				NYG.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("CLE")) {
				CLE.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("SFO")) {
				SFO.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("ARI")) {
				ARI.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("WAS")) {
				WAS.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("CHI")) {
				CHI.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("DEN")) {
				DEN.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("DAL")) {
				DAL.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("HOU")) {
				HOU.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("IND")) {
				IND.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("BAL")) {
				BAL.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("MIA")) {
				MIA.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("SEA")) {
				SEA.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("PIT")) {
				PIT.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("SDG")) {
				SDG.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("CAR")) {
				CAR.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("TAM")) {
				TAM.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("STL")) {
				STL.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("NYJ")) {
				NYJ.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("JAX")) {
				JAX.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("BUF")) {
				BUF.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("KAN")) {
				KAN.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("OAK")) {
				OAK.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("PHI")) {
				PHI.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("DET")) {
				DET.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("NOR")) {
				NOR.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("TEN")) {
				TEN.add(sample.get(i));
			}
			if(sample.get(i).getTeam().equals("ATL")) {
				ATL.add(sample.get(i));
			}
		}
	}


	public static void main(String[] args) {
		try {
			BufferedReader reader = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/NFL2012OffensiveStats.txt"); //url of the data
			analyseData(reader);
			System.out.println("The total number of players is " + players + "\n");
			System.out.println(mostRuYds(data));
			System.out.println(mostAllYards(data));
			teamsToArray(data);

			//for each team, print the no. of players who touched the ball > 10 times
			System.out.println("no. of players that have touched the ball > 10 for the team CIN is " + more10TouchNumber(CIN));
			System.out.println("no. of players that have touched the ball > 10 for the team NWE is " + more10TouchNumber(NWE));
			System.out.println("no. of players that have touched the ball > 10 for the team GNB is " + more10TouchNumber(GNB));
			System.out.println("no. of players that have touched the ball > 10 for the team MIN is " + more10TouchNumber(MIN));
			System.out.println("no. of players that have touched the ball > 10 for the team NYG is " + more10TouchNumber(NYG));
			System.out.println("no. of players that have touched the ball > 10 for the team CLE is " + more10TouchNumber(CLE));
			System.out.println("no. of players that have touched the ball > 10 for the team SFO is " + more10TouchNumber(SFO));
			System.out.println("no. of players that have touched the ball > 10 for the team ARI is " + more10TouchNumber(ARI));
			System.out.println("no. of players that have touched the ball > 10 for the team WAS is " + more10TouchNumber(WAS));
			System.out.println("no. of players that have touched the ball > 10 for the team CHI is " + more10TouchNumber(CHI));
			System.out.println("no. of players that have touched the ball > 10 for the team DEN is " + more10TouchNumber(DEN));	
			System.out.println("no. of players that have touched the ball > 10 for the team DAL is " + more10TouchNumber(DAL));
			System.out.println("no. of players that have touched the ball > 10 for the team HOU is " + more10TouchNumber(HOU));
			System.out.println("no. of players that have touched the ball > 10 for the team IND is " + more10TouchNumber(IND));
			System.out.println("no. of players that have touched the ball > 10 for the team BAL is " + more10TouchNumber(BAL));
			System.out.println("no. of players that have touched the ball > 10 for the team MIA is " + more10TouchNumber(MIA));
			System.out.println("no. of players that have touched the ball > 10 for the team SEA is " + more10TouchNumber(SEA));
			System.out.println("no. of players that have touched the ball > 10 for the team PIT is " + more10TouchNumber(PIT));
			System.out.println("no. of players that have touched the ball > 10 for the team SDG is " + more10TouchNumber(SDG));
			System.out.println("no. of players that have touched the ball > 10 for the team CAR is " + more10TouchNumber(CAR));
			System.out.println("no. of players that have touched the ball > 10 for the team TAM is " + more10TouchNumber(TAM));
			System.out.println("no. of players that have touched the ball > 10 for the team STL is " + more10TouchNumber(STL));
			System.out.println("no. of players that have touched the ball > 10 for the team NYJ is " + more10TouchNumber(NYJ));
			System.out.println("no. of players that have touched the ball > 10 for the team JAX is " + more10TouchNumber(JAX));
			System.out.println("no. of players that have touched the ball > 10 for the team BUF is " + more10TouchNumber(BUF));
			System.out.println("no. of players that have touched the ball > 10 for the team KAN is " + more10TouchNumber(KAN));
			System.out.println("no. of players that have touched the ball > 10 for the team OAK is " + more10TouchNumber(OAK));
			System.out.println("no. of players that have touched the ball > 10 for the team PHI is " + more10TouchNumber(PHI));
			System.out.println("no. of players that have touched the ball > 10 for the team DET is " + more10TouchNumber(DET));
			System.out.println("no. of players that have touched the ball > 10 for the team NOR is " + more10TouchNumber(NOR));
			System.out.println("no. of players that have touched the ball > 10 for the team TEN is " + more10TouchNumber(TEN));
			System.out.println("no. of players that have touched the ball > 10 for the team ATL is " + more10TouchNumber(ATL));
			System.out.println("\n");

			//for each team, print the player who was the greatest liability
			System.out.println("Player who was the greatest liability for the team CIN is \n" + fewestYards(CIN));
			System.out.println("Player who was the greatest liability for the team NWE is \n" + fewestYards(NWE));
			System.out.println("Player who was the greatest liability for the team GNB is \n" + fewestYards(GNB));
			System.out.println("Player who was the greatest liability for the team MIN is \n" + fewestYards(MIN));
			System.out.println("Player who was the greatest liability for the team NYG is \n" + fewestYards(NYG));
			System.out.println("Player who was the greatest liability for the team CLE is \n" + fewestYards(CLE));
			System.out.println("Player who was the greatest liability for the team SFO is \n" + fewestYards(SFO));
			System.out.println("Player who was the greatest liability for the team ARI is \n" + fewestYards(ARI));
			System.out.println("Player who was the greatest liability for the team WAS is \n" + fewestYards(WAS));
			System.out.println("Player who was the greatest liability for the team CHI is \n" + fewestYards(CHI));
			System.out.println("Player who was the greatest liability for the team DEN is \n" + fewestYards(DEN));
			System.out.println("Player who was the greatest liability for the team DAL is \n" + fewestYards(DAL));
			System.out.println("Player who was the greatest liability for the team HOU is \n" + fewestYards(HOU));
			System.out.println("Player who was the greatest liability for the team IND is \n" + fewestYards(IND));
			System.out.println("Player who was the greatest liability for the team BAL is \n" + fewestYards(BAL));
			System.out.println("Player who was the greatest liability for the team MIA is \n" + fewestYards(MIA));
			System.out.println("Player who was the greatest liability for the team SEA is \n" + fewestYards(SEA));
			System.out.println("Player who was the greatest liability for the team PIT is \n" + fewestYards(PIT));
			System.out.println("Player who was the greatest liability for the team SDG is \n" + fewestYards(SDG));
			System.out.println("Player who was the greatest liability for the team CAR is \n" + fewestYards(CAR));
			System.out.println("Player who was the greatest liability for the team TAM is \n" + fewestYards(TAM));
			System.out.println("Player who was the greatest liability for the team STL is \n" + fewestYards(STL));
			System.out.println("Player who was the greatest liability for the team NYJ is \n" + fewestYards(NYJ));
			System.out.println("Player who was the greatest liability for the team JAX is \n" + fewestYards(JAX));
			System.out.println("Player who was the greatest liability for the team BUF is \n" + fewestYards(BUF));
			System.out.println("Player who was the greatest liability for the team KAN is \n" + fewestYards(KAN));
			System.out.println("Player who was the greatest liability for the team OAK is \n" + fewestYards(OAK));
			System.out.println("Player who was the greatest liability for the team PHI is \n" + fewestYards(PHI));
			System.out.println("Player who was the greatest liability for the team DET is \n" + fewestYards(DET));
			System.out.println("Player who was the greatest liability for the team NOR is \n" + fewestYards(NOR));
			System.out.println("Player who was the greatest liability for the team TEN is \n" + fewestYards(TEN));
			System.out.println("Player who was the greatest liability for the team ATL is \n" + fewestYards(ATL));
			System.out.println("\n");

			//for each team and for the players who touched the ball more than 10 times, 
			//prints the players who had the worst butter fingers
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team CIN is \n" + droppedOften(more10TouchArray(CIN)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team NWE is \n" + droppedOften(more10TouchArray(NWE)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team GNB is \n" + droppedOften(more10TouchArray(GNB)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team MIN is \n" + droppedOften(more10TouchArray(MIN)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team NYG is \n" + droppedOften(more10TouchArray(NYG)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team CLE is \n" + droppedOften(more10TouchArray(CLE)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team SFO is \n" + droppedOften(more10TouchArray(SFO)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team ARI is \n" + droppedOften(more10TouchArray(ARI)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team WAS is \n" + droppedOften(more10TouchArray(WAS)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team CHI is \n" + droppedOften(more10TouchArray(CHI)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team DEN is \n" + droppedOften(more10TouchArray(DEN)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team DAL is \n" + droppedOften(more10TouchArray(DAL)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team HOU is \n" + droppedOften(more10TouchArray(HOU)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team IND is \n" + droppedOften(more10TouchArray(IND)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team BAL is \n" + droppedOften(more10TouchArray(BAL)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team MIA is \n" + droppedOften(more10TouchArray(MIA)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team SEA is \n" + droppedOften(more10TouchArray(SEA)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team PIT is \n" + droppedOften(more10TouchArray(PIT)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team SDG is \n" + droppedOften(more10TouchArray(SDG)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team CAR is \n" + droppedOften(more10TouchArray(CAR)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team TAM is \n" + droppedOften(more10TouchArray(TAM)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team STL is \n" + droppedOften(more10TouchArray(STL)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team NYJ is \n" + droppedOften(more10TouchArray(NYJ)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team JAX is \n" + droppedOften(more10TouchArray(JAX)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team BUF is \n" + droppedOften(more10TouchArray(BUF)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team KAN is \n" + droppedOften(more10TouchArray(KAN)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team OAK is \n" + droppedOften(more10TouchArray(OAK)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team PHI is \n" + droppedOften(more10TouchArray(PHI)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team DET is \n" + droppedOften(more10TouchArray(DET)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team NOR is \n" + droppedOften(more10TouchArray(NOR)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team TEN is \n" + droppedOften(more10TouchArray(TEN)));
			System.out.println("Of the players who touched the ball more than 10 times " + "\n" + 
					"the player with the worst butter fingers for the team ATL is \n" + droppedOften(more10TouchArray(ATL)));
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Problem: "+e);
		}
	}


}
