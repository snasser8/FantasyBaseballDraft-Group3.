package fantasy;

public class PitcherStats implements PlayerStats {
	private int rk;
	private String name;
	private int age;
	private String team;
	private int w;
	private int l;
	private double winLossPct;
	private double era;
	private int g;
	private int gs;
	private int gf;
	private int cg;
	private int sho;
	private int sv;
	private double ip;
	private int h;
	private int r;
	private int er;
	private int hr;
	private int bb;
	private int ibb;
	private int so;
	private int hbp;
	private int bk;
	private int wp;
	private int bf;
	private int eraPlus;
	private double fip;
	private double whip;
	private double h9;
	private double hr9;
	private double bb9;
	private double so9;
	private double soPerW;
	private String nameAdditional;
	    
	    public PitcherStats() {
			
	    	
	    	
	    }
	    @Override
	    public String getPosition() {
			
			return "P";
		}
	   
	    
	    @Override
	    public void setStat(int col, Object val) {
	        switch (col) {
	            case 0  -> this.rk = (Integer) val;
	            case 1  -> this.name = (String) val;
	            case 2  -> this.age = (Integer) val;
	            case 3  -> this.team = (String) val;
	            case 4  -> this.w = (Integer) val;
	            case 5  -> this.l = (Integer) val;
	            case 6  -> this.winLossPct = (Double) val;
	            case 7  -> this.era = (Double) val;
	            case 8  -> this.g = (Integer) val;
	            case 9  -> this.gs = (Integer) val;
	            case 10 -> this.gf = (Integer) val;
	            case 11 -> this.cg = (Integer) val;
	            case 12 -> this.sho = (Integer) val;
	            case 13 -> this.sv = (Integer) val;
	            case 14 -> this.ip = (Double) val;
	            case 15 -> this.h = (Integer) val;
	            case 16 -> this.r = (Integer) val;
	            case 17 -> this.er = (Integer) val;
	            case 18 -> this.hr = (Integer) val;
	            case 19 -> this.bb = (Integer) val;
	            case 20 -> this.ibb = (Integer) val;
	            case 21 -> this.so = (Integer) val;
	            case 22 -> this.hbp = (Integer) val;
	            case 23 -> this.bk = (Integer) val;
	            case 24 -> this.wp = (Integer) val;
	            case 25 -> this.bf = (Integer) val;
	            case 26 -> this.eraPlus = (Integer) val;
	            case 27 -> this.fip = (Double) val;
	            case 28 -> this.whip = (Double) val;
	            case 29 -> this.h9 = (Double) val;
	            case 30 -> this.hr9 = (Double) val;
	            case 31 -> this.bb9 = (Double) val;
	            case 32 -> this.so9 = (Double) val;
	            case 33 -> this.soPerW = (Double) val;
	            case 34 -> this.nameAdditional = (String) val;
	            default -> throw new IllegalArgumentException("Invalid Pitcher column index: " + col);
	        }
	    }
	    @Override
	    public double getStat  (String statName) throws IllegalArgumentException  {
	        if (statName == null) {
	            throw new IllegalArgumentException("Stat name cannot be null");
	        }
	        return switch (statName.trim().toUpperCase()) {
	            case "RK"       -> this.rk;
	            case "AGE"      -> this.age;
	            case "W"        -> this.w;
	            case "L"        -> this.l;
	            case "W-L%"     -> this.winLossPct;
	            case "ERA"      -> this.era;
	            case "G"        -> this.g;
	            case "GS"       -> this.gs;
	            case "GF"       -> this.gf;
	            case "CG"       -> this.cg;
	            case "SHO"      -> this.sho;
	            case "SV"       -> this.sv;
	            case "IP"       -> this.ip;
	            case "H"        -> this.h;
	            case "R"        -> this.r;
	            case "ER"       -> this.er;
	            case "HR"       -> this.hr;
	            case "BB"       -> this.bb;
	            case "IBB"      -> this.ibb;
	            case "SO"       -> this.so;
	            case "HBP"      -> this.hbp;
	            case "BK"       -> this.bk;
	            case "WP"       -> this.wp;
	            case "BF"       -> this.bf;
	            case "ERA+"     -> this.eraPlus;
	            case "FIP"      -> this.fip;
	            case "WHIP"     -> this.whip;
	            case "H9"       -> this.h9;
	            case "HR9"      -> this.hr9;
	            case "BB9"      -> this.bb9;
	            case "SO9"      -> this.so9;
	            case "SO/W"     -> this.soPerW;
	            default         -> throw new IllegalArgumentException("Unknown Pitcher stat: " + statName);
	        };
	        
	        
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

		public PitcherStats(int rk, String name, int age, String team, int w, int l, double winLossPct, double era,
				int g, int gs, int gf, int cg, int sho, int sv, double ip, int h, int r, int er, int hr, int bb,
				int ibb, int so, int hbp, int bk, int wp, int bf, int eraPlus, double fip, double whip, double h9,
				double hr9, double bb9, double so9, double soPerW, String nameAdditional) {
			super();
			this.rk = rk;
			this.name = name;
			this.age = age;
			this.team = team;
			this.w = w;
			this.l = l;
			this.winLossPct = winLossPct;
			this.era = era;
			this.g = g;
			this.gs = gs;
			this.gf = gf;
			this.cg = cg;
			this.sho = sho;
			this.sv = sv;
			this.ip = ip;
			this.h = h;
			this.r = r;
			this.er = er;
			this.hr = hr;
			this.bb = bb;
			this.ibb = ibb;
			this.so = so;
			this.hbp = hbp;
			this.bk = bk;
			this.wp = wp;
			this.bf = bf;
			this.eraPlus = eraPlus;
			this.fip = fip;
			this.whip = whip;
			this.h9 = h9;
			this.hr9 = hr9;
			this.bb9 = bb9;
			this.so9 = so9;
			this.soPerW = soPerW;
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


		public int getW() {
			return w;
		}


		public int getL() {
			return l;
		}


		public double getWinLossPct() {
			return winLossPct;
		}


		public double getEra() {
			return era;
		}


		public int getG() {
			return g;
		}


		public int getGs() {
			return gs;
		}


		public int getGf() {
			return gf;
		}


		public int getCg() {
			return cg;
		}


		public int getSho() {
			return sho;
		}


		public int getSv() {
			return sv;
		}


		public double getIp() {
			return ip;
		}


		public int getH() {
			return h;
		}


		public int getR() {
			return r;
		}


		public int getEr() {
			return er;
		}


		public int getHr() {
			return hr;
		}


		public int getBb() {
			return bb;
		}


		public int getIbb() {
			return ibb;
		}


		public int getSo() {
			return so;
		}


		public int getHbp() {
			return hbp;
		}


		public int getBk() {
			return bk;
		}


		public int getWp() {
			return wp;
		}


		public int getBf() {
			return bf;
		}


		public int getEraPlus() {
			return eraPlus;
		}


		public double getFip() {
			return fip;
		}


		public double getWhip() {
			return whip;
		}


		public double getH9() {
			return h9;
		}


		public double getHr9() {
			return hr9;
		}


		public double getBb9() {
			return bb9;
		}


		public double getSo9() {
			return so9;
		}


		public double getSoPerW() {
			return soPerW;
		}


		public String getNameAdditional() {
			return nameAdditional;
		}
		@Override
		public String toString() {
			return "PitcherStats [rk=" + rk + ", name=" + name + ", age=" + age + ", team=" + team + ", w=" + w + ", l="
					+ l + ", winLossPct=" + winLossPct + ", era=" + era + ", g=" + g + ", gs=" + gs + ", gf=" + gf
					+ ", cg=" + cg + ", sho=" + sho + ", sv=" + sv + ", ip=" + ip + ", h=" + h + ", r=" + r + ", er="
					+ er + ", hr=" + hr + ", bb=" + bb + ", ibb=" + ibb + ", so=" + so + ", hbp=" + hbp + ", bk=" + bk
					+ ", wp=" + wp + ", bf=" + bf + ", eraPlus=" + eraPlus + ", fip=" + fip + ", whip=" + whip + ", h9="
					+ h9 + ", hr9=" + hr9 + ", bb9=" + bb9 + ", so9=" + so9 + ", soPerW=" + soPerW + ", nameAdditional="
					+ nameAdditional + "]";
		}
	    
	    
	
	

}
