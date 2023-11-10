import java.util.List;

public class State {
    private List<WaterJug> jugs;
    private int parent;
    private int gn;
    private int hn;
    private String action;

    public State(List<WaterJug> jugs, int parent, int gn, int hn, String action) {
        this.jugs = jugs;
        this.parent = parent;
        this.gn = gn;
        this.hn = hn;
        this.action = action;
    }

    public List<WaterJug> getJugs() {
        return jugs;
    }

    public int getParent() {
        return parent;
    }

    public int getGn() {
        return gn;
    }

    public int getHn() {
        return hn;
    }
    
    public String getAction() {
        return action;
    }
}