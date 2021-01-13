package day08;

public class CurrentPos {
    int pos;
    int acc;

    public CurrentPos() {
        this(0, 0);
    }

    public CurrentPos(int pos, int acc) {
        this.pos = pos;
        this.acc = acc;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

}
