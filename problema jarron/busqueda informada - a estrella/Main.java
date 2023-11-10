import java.util.ArrayList;
import java.util.List;

public class Main {
    

    public static void main(String[] args) {
        WaterJugProblem solver = new WaterJugProblem();
        
        List<WaterJug> waterJugs = new ArrayList<>();
        waterJugs.add(new WaterJug(3));
        waterJugs.add(new WaterJug(8));
        waterJugs.add(new WaterJug(12));
        
        int goal = 1;
        
        solver.solveProblem(waterJugs, goal);
    }
}
