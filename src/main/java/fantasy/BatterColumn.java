package fantasy;

public enum BatterColumn implements ColumnSchema {
	
	
	
	
	RK(DataType.INT),          // position 0
    NAME(DataType.STRING),     // position 1
    AGE(DataType.INT),         // position 2
    TM(DataType.STRING),       // position 3
    G(DataType.INT),           // position 4
    PA(DataType.INT),          // position 5
    AB(DataType.INT),          // position 6
    R(DataType.INT),           // position 7
    H(DataType.INT),           // position 8
    DOUBLES(DataType.INT),     // position 9
    TRIPLES(DataType.INT),     // position 10
    HR(DataType.INT),          // position 11
    RBI(DataType.INT),         // position 12
    SB(DataType.INT),          // position 13
    CS(DataType.INT),          // position 14
    BB(DataType.INT),          // position 15
    SO(DataType.INT),          // position 16
    BA(DataType.DOUBLE),       // position 17
    OBP(DataType.DOUBLE),      // position 18
    SLG(DataType.DOUBLE),      // position 19
    OPS(DataType.DOUBLE),      // position 20
    OPS_PLUS(DataType.INT),    // position 21
    TB(DataType.INT),          // position 22
    GDP(DataType.INT),         // position 23
    HBP(DataType.INT),         // position 24
    SH(DataType.INT),          // position 25
    SF(DataType.INT),          // position 26
    IBB(DataType.INT),         // position 27
    POS_SUMMARY(DataType.STRING),     // position 28
    NAME_ADDITIONAL(DataType.STRING); // position 29

    // Just ONE field on the enum!
    public final DataType type;

    BatterColumn(DataType type) {
        this.type = type;
    }
    @Override
    public DataType getType() {
    	return this.type;
    }

}
