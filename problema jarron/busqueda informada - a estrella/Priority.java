import java.util.List;

class Priority {
    private int position;
    private int fn;

    public Priority(int position, int fn) {
        this.position = position;
        this.fn = fn;
    }

    public int getPosition() {
        return position;        
    }

    public int getFn() {
        return fn;
    }
}