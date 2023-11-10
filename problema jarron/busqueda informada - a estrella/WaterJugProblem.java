import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaterJugProblem
{
    private List<String> validOperations(List<WaterJug> waterJugs) {
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < waterJugs.size(); i++) {
            WaterJug waterJug = waterJugs.get(i);
            if (waterJug.getContent() > 0) {
                operations.add("vaciar " + i);
            }
            
            if (waterJug.getContent() < waterJug.getMaxContent()) {
                operations.add("llenar " + i);
            }
            
            for (int j = i + 1; j < waterJugs.size(); j++) {
                WaterJug otherJug = waterJugs.get(j);
                if (waterJug.getContent() > 0 && otherJug.getContent() < otherJug.getMaxContent()) {
                    operations.add("pasar " + j + " " + i);
                } else if (otherJug.getContent() > 0 && waterJug.getContent() < waterJug.getMaxContent()) {
                    operations.add("pasar " + i + " " + j);
                }
            }
        }
        return operations;
    }

    private int h(List<WaterJug> newJugs, int target) {
        int total = 0;
        for (WaterJug jug : newJugs) {
            total += Math.abs(jug.getContent() - target);
        }
        return total;
    }
    
    private List<WaterJug> deepcopy(List<WaterJug> waterJugs) {
        List<WaterJug> newWaterJugs = new ArrayList<>();
        for (WaterJug waterJug : waterJugs) {
            newWaterJugs.add(waterJug.copy());
        }
        
        return newWaterJugs;
    }

    private Response evaluate(List<WaterJug> initialJugs, int target) {
        int parent = -1;
        int gn = 0;
        int hn = h(initialJugs, target);
        List<State> state = new ArrayList<>();
        state.add(new State(initialJugs, parent, gn, hn, "Estado inicial."));
        List<Priority> priorities = new ArrayList<>();
        priorities.add(new Priority(0, hn));
        while (true) {
            if (priorities.size() == 0) {
                System.out.println("No se puede resolver el problema!\n");
                break;
            }
            
            priorities.sort((p1, p2) -> {
                if (p1.getFn() == p2.getFn()) {
                    return Integer.compare(p1.getPosition(), p2.getPosition());
                }
                return Integer.compare(p1.getFn(), p2.getFn());
            });
            
            Priority pos = priorities.get(0);
            priorities.remove(0);
            
            List<WaterJug> waterJugs = state.get(pos.getPosition()).getJugs();
            gn++;
            for (String operation : validOperations(waterJugs)) {
                List<WaterJug> newJugs = deepcopy(waterJugs);
                String[] parts = operation.split(" ");
                String op = parts[0];
                int data1 = Integer.parseInt(parts[1]);
                String action = "";
                if (op.equals("vaciar")) {
                    action += "Vaciamos el jarron " + (data1 + 1) + " al suelo";
                    newJugs.get(data1).empty();
                } else if (op.equals("llenar")) {
                    action += "Llenamos el jarron " + (data1 + 1) + " con agua del grifo";
                    newJugs.get(data1).fill();
                } else {
                    int data2 = Integer.parseInt(parts[2]);
                    action += "Vaciamos el jarron " + (data2 + 1) + " en el jarron " + (data1 + 1);
                    newJugs.get(data1).fillWithJug(newJugs.get(data2));
                }
                boolean found = false;
                for (State s : state) {
                    if (s.getJugs().equals(newJugs)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    hn = h(newJugs, target);
                    state.add(new State(newJugs, pos.getPosition(), gn, hn, action));
                    int fn = gn + hn;
                    priorities.add(new Priority(state.size() - 1, fn));
                    if (newJugs.stream().anyMatch(jug -> jug.getContent() == target)) {
                        System.out.println("Se puede resolver el problema!\n");
                        return new Response(state, priorities.size(), true);
                    }
                }
            }
        }

        return new Response(state, priorities.size(), false);
    }

    private List<State> bestSolution(List<State> state) {
        List<State> bestSol = new ArrayList<>();
        int count = state.size() - 1;
        while (count != -1) {
            bestSol.add(0, state.get(count));
            count = state.get(count).getParent();
        }
        return bestSol;
    }

    public void solveProblem(List<WaterJug> waterJugs, int goal) {
        Response response = evaluate(waterJugs, goal);
        List<State> bestPath = bestSolution(response.getState());
        for (int i = 0; i < bestPath.size(); i++) {
            if (!response.getFound() && i > 0) {
                break;
            }
            
            List<WaterJug> jugs = bestPath.get(i).getJugs();
            System.out.println("** " + bestPath.get(i).getAction() + " **");
            for (WaterJug jug : jugs) {
                System.out.println(jug);
            }
            System.out.println();
        }
        
        if (response.getFound()) {
            int totalMoves = bestPath.size() - 1;
            System.out.println("\nPasos para alcanzar la meta: " + totalMoves);
        } else {
            System.out.println("\nMeta no alcanzada.");
        }
        
        int visit = response.getState().size() - response.getPending();
        System.out.println("Total de nodos visitados: " + visit + "\n");
    }
}
