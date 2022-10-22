package MScCAII;

public class MScCAIIMarks {

    int semITotal;
    int semIITotal;

    public MScCAIIMarks() {
        this(0, 0);
    }

    public MScCAIIMarks(int semITotal, int semIITotal) {
        this.semITotal = semITotal;
        this.semIITotal = semIITotal;
    }

    public int returnTotal() {
        return (this.semITotal + this.semIITotal) / 2;
    }

}
