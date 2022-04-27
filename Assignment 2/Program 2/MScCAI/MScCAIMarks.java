package MScCAI;

public class MScCAIMarks {

    int semITotal;
    int semIITotal;

    public MScCAIMarks() {
        this(0, 0);
    }

    public MScCAIMarks(int semITotal, int semIITotal) {
        this.semITotal = semITotal;
        this.semIITotal = semIITotal;
    }

    public int returnTotal() {
        return (this.semITotal + this.semIITotal) / 2;
    }

}
