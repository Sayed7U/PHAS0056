package exam1;

//Each players stats would be a data point object, can manipulate the variables easily this way
public class DataPoint {
	//Defining the stats as variables
	private String name,team,pos;
	private double games,att,ruYds,ruTD,tgt,rec,reYds,reTd,fmb;


	//defining the constructor
	public DataPoint(String nm,String tm,String ps,double game,double attack,double ruyds,double rutd,double tgtt,double recc,double reyds,double retd,double fmB) {
		this.name = nm; 
		this.team = tm; 
		this.pos = ps;
		this.games = game;
		this.att = attack;
		this.ruTD = rutd;
		this.ruYds = ruyds;
		this.tgt = tgtt;
		this.rec = recc;
		this.reYds = reyds;
		this.reTd = retd;
		this.fmb = fmB;

	}
	//the getter functions, each returns the private variable
	public String getName() {
		return this.name;
	}

	public String getTeam() {
		return this.team;
	}
	public String getPos() {
		return this.pos;
	}
	public double getGames() {
		return this.games;
	}
	public double getAtt() {
		return this.att;
	}
	public double getRuTD() {
		return this.ruTD;
	}
	public double getRuYds() {
		return this.ruYds;
	}
	public double getTgt() {
		return this.tgt;
	}
	public double getRec() {
		return this.rec;
	}
	public double getReYds() {
		return this.reYds;
	}
	public double getReTd() {
		return this.reTd;
	}
	public double getFmb() {
		return this.fmb;
	}
	//What we want to see when the data point is printed to screen
	public String toString() {
		return "Name: " + this.name + "\n" + "Team: " + this.team + "\n" + "Position: " + this.pos + 
				"\n" + "Games: " + this.games + "\n" + "Rushing attempts: " + this.att + "\n"  + "Rushing Yards: " + this.ruYds + "\n" + "Rushing touchdowns: " + this.ruTD + "\n" + 
				"Receiving target: " + this.tgt + "\n" + "Receptions: " + this.rec + "\n" + "Receiving yards: " + this.reYds + "\n" + "Receiving touchdowns: " + this.reTd + "\n"
				+ "Fumbles: " + this.fmb + "\n";
	}
}