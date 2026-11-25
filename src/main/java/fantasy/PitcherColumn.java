package fantasy;

public enum PitcherColumn implements ColumnSchema{
	
	    RK(DataType.INT),                 // 0
	    NAME(DataType.STRING),            // 1
	    AGE(DataType.INT),                // 2
	    TM(DataType.STRING),              // 3
	    W(DataType.INT),                  // 4
	    L(DataType.INT),                  // 5
	    W_L_PCT(DataType.DOUBLE),         // 6
	    ERA(DataType.DOUBLE),             // 7
	    G(DataType.INT),                  // 8
	    GS(DataType.INT),                 // 9
	    GF(DataType.INT),                 // 10
	    CG(DataType.INT),                 // 11
	    SHO(DataType.INT),                // 12
	    SV(DataType.INT),                 // 13
	    IP(DataType.DOUBLE),              // 14
	    H(DataType.INT),                  // 15
	    R(DataType.INT),                  // 16
	    ER(DataType.INT),                 // 17
	    HR(DataType.INT),                 // 18
	    BB(DataType.INT),                 // 19
	    IBB(DataType.INT),                // 20
	    SO(DataType.INT),                 // 21
	    HBP(DataType.INT),                // 22
	    BK(DataType.INT),                 // 23
	    WP(DataType.INT),                 // 24
	    BF(DataType.INT),                 // 25
	    ERA_PLUS(DataType.INT),           // 26
	    FIP(DataType.DOUBLE),             // 27
	    WHIP(DataType.DOUBLE),            // 28
	    H9(DataType.DOUBLE),              // 29
	    HR9(DataType.DOUBLE),             // 30
	    BB9(DataType.DOUBLE),             // 31
	    SO9(DataType.DOUBLE),             // 32
	    SO_W(DataType.DOUBLE),            // 33
	    NAME_ADDITIONAL(DataType.STRING); // 34

	    public final DataType type;

	    PitcherColumn(DataType type) {
	        this.type = type;
	    }
	    
	    @Override
	    public DataType getType() {
	    	return this.type;
	    }
	}


