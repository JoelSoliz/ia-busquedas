import java.util.List;

public class Response
{
    private List<State> state;
    private int pending;
    private boolean found;

    public Response(List<State> state, int pending, boolean found)
    {
        this.state = state;
        this.pending = pending;
        this.found = found;
    }
    
    public List<State> getState() {
        return state;
    }
    
    public int getPending() {
        return pending;
    }
    
    public boolean getFound() {
        return found;
    }
}
