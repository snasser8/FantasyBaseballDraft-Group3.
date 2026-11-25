package fantasy;

import java.util.function.IntPredicate;

public class BatterStats implements PlayerStats{
	
	private int rk;
	private String name;
	private int age;
	private String team;
	private int g;
	private int pa;
	private int ab;
	private int r;
	private int h;
	private int doubles;
	private int triples;
	private int hr;
	private int rbi;
	private int sb;
	private int cs;
	private int bb;
	private int so;
	private double ba;
	private double obp;
	private double slg;
	private double ops;
	private int opsPlus;
	private int tb;
	private int gdp;
	private int hbp;
	private int sh;
	private int sf;
	private int ibb;
	private String posSummary;
	private String nameAdditional;
	
	
	public BatterStats() {
		
		
	}
	@Override
	public String getPosition() {
		IntPredicate isOneThroughNine = c -> c >= 49 && c <= 57;
	
		for(int x= 0;x<posSummary.length();x++) {
			
		char currentChar	=posSummary.charAt(x);
		
		boolean isValid = isOneThroughNine.test(currentChar);
		
		if(isValid) {
			
			int positionNumber= Character.getNumericValue(currentChar);
			return getPosition(positionNumber);
		}
		
	}
		return "Invalid";
		
	}
	
	
	public static String getPosition(int positionNumber) {
        return switch (positionNumber) {
            case 1 -> "P";
            case 2 -> "C";
            case 3 -> "1B";
            case 4 -> "2B";
            case 5 -> "3B";
            case 6 -> "SS";
            case 7 -> "LF";
            case 8 -> "CF";
            case 9 -> "RF";
            default -> "Invalid";
        };
    }
	
	@Override
	public double getStat    (String statName) throws IllegalArgumentException {
	    if (statName == null) {
	        throw new IllegalArgumentException("Stat name cannot be null");
	    }
	    return switch (statName.trim().toUpperCase()) {
	        case "RK"       -> this.rk;
	        case "AGE"      -> this.age;
	        case "G"        -> this.g;
	        case "PA"       -> this.pa;
	        case "AB"       -> this.ab;
	        case "R"        -> this.r;
	        case "H"        -> this.h;
	        case "2B"       -> this.doubles;
	        case "3B"       -> this.triples;
	        case "HR"       -> this.hr;
	        case "RBI"      -> this.rbi;
	        case "SB"       -> this.sb;
	        case "CS"       -> this.cs;
	        case "BB"       -> this.bb;
	        case "SO"       -> this.so;
	        case "BA", "AVG"-> this.ba;
	        case "OBP"      -> this.obp;
	        case "SLG"      -> this.slg;
	        case "OPS"      -> this.ops;
	        case "OPS+"     -> this.opsPlus;
	        case "TB"       -> this.tb;
	        case "GDP"      -> this.gdp;
	        case "HBP"      -> this.hbp;
	        case "SH"       -> this.sh;
	        case "SF"       -> this.sf;
	        case "IBB"      -> this.ibb;
	        default         -> throw new IllegalArgumentException("Bad agurment");
	    };
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void setStat(int col, Object val) {
        switch (col) {
            case 0  -> this.rk = (Integer) val;
            case 1  -> this.name = (String) val;
            case 2  -> this.age = (Integer) val;
            case 3  -> this.team = (String) val;
            case 4  -> this.g = (Integer) val;
            case 5  -> this.pa = (Integer) val;
            case 6  -> this.ab = (Integer) val;
            case 7  -> this.r = (Integer) val;
            case 8  -> this.h = (Integer) val;
            case 9  -> this.doubles = (Integer) val;
            case 10 -> this.triples = (Integer) val;
            case 11 -> this.hr = (Integer) val;
            case 12 -> this.rbi = (Integer) val;
            case 13 -> this.sb = (Integer) val;
            case 14 -> this.cs = (Integer) val;
            case 15 -> this.bb = (Integer) val;
            case 16 -> this.so = (Integer) val;
            case 17 -> this.ba = (Double) val;
            case 18 -> this.obp = (Double) val;
            case 19 -> this.slg = (Double) val;
            case 20 -> this.ops = (Double) val;
            case 21 -> this.opsPlus = (Integer) val;
            case 22 -> this.tb = (Integer) val;
            case 23 -> this.gdp = (Integer) val;
            case 24 -> this.hbp = (Integer) val;
            case 25 -> this.sh = (Integer) val;
            case 26 -> this.sf = (Integer) val;
            case 27 -> this.ibb = (Integer) val;
            case 28 -> this.posSummary = (String) val;
            case 29 -> this.nameAdditional = (String) val;
            default -> throw new IllegalArgumentException("Invalid Batter column index: " + col);
        }
	
	}
	
	
	
		public BatterStats(int rk, String name, int age, String team, int g, int pa, int ab, int r, int h, int doubles,
				int triples, int hr, int rbi, int sb, int cs, int bb, int so, double ba, double obp, double slg,
				double ops, int opsPlus, int tb, int gdp, int hbp, int sh, int sf, int ibb, String posSummary,
				String nameAdditional) {
			super();
			this.rk = rk;
			this.name = name;
			this.age = age;
			this.team = team;
			this.g = g;
			this.pa = pa;
			this.ab = ab;
			this.r = r;
			this.h = h;
			this.doubles = doubles;
			this.triples = triples;
			this.hr = hr;
			this.rbi = rbi;
			this.sb = sb;
			this.cs = cs;
			this.bb = bb;
			this.so = so;
			this.ba = ba;
			this.obp = obp;
			this.slg = slg;
			this.ops = ops;
			this.opsPlus = opsPlus;
			this.tb = tb;
			this.gdp = gdp;
			this.hbp = hbp;
			this.sh = sh;
			this.sf = sf;
			this.ibb = ibb;
			this.posSummary = posSummary;
			this.nameAdditional = nameAdditional;
		}
		
		@Override
		public int getRk() {
			return rk;
		}
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		
		
		@Override
		public String getTeam() {
			return team;
		}
		public int getG() {
			return g;
		}
		public int getPa() {
			return pa;
		}
		public int getAb() {
			return ab;
		}
		public int getR() {
			return r;
		}
		public int getH() {
			return h;
		}
		public int getDoubles() {
			return doubles;
		}
		public int getTriples() {
			return triples;
		}
		public int getHr() {
			return hr;
		}
		public int getRbi() {
			return rbi;
		}
		public int getSb() {
			return sb;
		}
		public int getCs() {
			return cs;
		}
		public int getBb() {
			return bb;
		}
		public int getSo() {
			return so;
		}
		public double getBa() {
			return ba;
		}
		public double getObp() {
			return obp;
		}
		public double getSlg() {
			return slg;
		}
		public double getOps() {
			return ops;
		}
		public int getOpsPlus() {
			return opsPlus;
		}
		public int getTb() {
			return tb;
		}
		public int getGdp() {
			return gdp;
		}
		public int getHbp() {
			return hbp;
		}
		public int getSh() {
			return sh;
		}
		public int getSf() {
			return sf;
		}
		public int getIbb() {
			return ibb;
		}
		public String getPosSummary() {
			return posSummary;
		}
		public String getNameAdditional() {
			return nameAdditional;
		}
		@Override
		public String toString() {
			return "BatterStats [rk=" + rk + ", name=" + name + ", age=" + age + ", team=" + team + ", g=" + g + ", pa="
					+ pa + ", ab=" + ab + ", r=" + r + ", h=" + h + ", doubles=" + doubles + ", triples=" + triples
					+ ", hr=" + hr + ", rbi=" + rbi + ", sb=" + sb + ", cs=" + cs + ", bb=" + bb + ", so=" + so
					+ ", ba=" + ba + ", obp=" + obp + ", slg=" + slg + ", ops=" + ops + ", opsPlus=" + opsPlus + ", tb="
					+ tb + ", gdp=" + gdp + ", hbp=" + hbp + ", sh=" + sh + ", sf=" + sf + ", ibb=" + ibb
					+ ", posSummary=" + posSummary + ", nameAdditional=" + nameAdditional + "]";
		}
	    
	    
	    
	    
	    
	    

}
