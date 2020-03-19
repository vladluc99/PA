import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {
    private Map<Hospital, List<Resident>> hosPrefMap;
    private Map<Resident, List<Hospital>> resPrefMap;

    public Problem(Map<Hospital, List<Resident>> hosPrefMap, Map<Resident, List<Hospital>> resPrefMap) {
        this.hosPrefMap = hosPrefMap;
        this.resPrefMap = resPrefMap;
    }

    public List<Matching<Resident, Hospital>> rezolva() {
        List<Matching<Resident, Hospital>> solutie = new ArrayList<>();
        Map<Hospital, Integer> gradOcupare = new HashMap<>();   //pe masura ce se adauga clienti in spitale se va actualiza gradul acestuia de ocupare
        for (Hospital spital : hosPrefMap.keySet()) {
            gradOcupare.put(spital, 0);
        }
        for (Resident rezident : resPrefMap.keySet()) {
            int i = 0;
            boolean ok = true;
            while (i < resPrefMap.get(rezident).size() && ok) { //se parcurge in ordine lista preferintelor rezidentului
                if (gradOcupare.get(resPrefMap.get(rezident).get(i)) <= resPrefMap.get(rezident).get(i).getCapacity()) // daca spitalul i nu este plin inca
                {
                    solutie.add(new Matching<>(rezident, resPrefMap.get(rezident).get(i)));
                    int count = gradOcupare.get(resPrefMap.get(rezident).get(i)); //se va incrementa gradul de ocupare al spitalului respectiv
                    count++;
                    gradOcupare.put(resPrefMap.get(rezident).get(i), count);
                    ok = false;
                } else
                    i++; //daca nu, se trece la urmatorul spital din lista preferintelor ; daca toate sunt pline, rezidentul ramane fara spital
            }
        }

        return solutie;
    }
}
