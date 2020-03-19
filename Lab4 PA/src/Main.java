import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var r = IntStream.rangeClosed(0, 3) //creem si initializam obiectele de tip resident
                .mapToObj(i -> new Resident("R" + i))
                .toArray(Resident[]::new);

        var h = IntStream.rangeClosed(0, 2) //creem si initializam obiectele de tip hospital
                .mapToObj(i -> new Hospital("H" + i))
                .toArray(Hospital[]::new);
        h[0].setCapacity(1);
        h[1].setCapacity(2);
        h[2].setCapacity(2);


        /*r[0].setPreferences(new Hospital[]{h[0], h[1], h[2]});
        r[1].setPreferences(new Hospital[]{h[0], h[1], h[2]});       aici am incercat fara maps
        r[2].setPreferences(new Hospital[]{h[0], h[1]});
        r[3].setPreferences(new Hospital[]{h[0], h[2]});*/
        List<Resident> residentList = new ArrayList<>();
        residentList.addAll(Arrays.asList(r));
        residentList.sort(Comparator.comparing(Resident::getName)); //se sorteaza rezidentii dupa nume

        Set<Hospital> hospitalList = new TreeSet<>();
        hospitalList.addAll(Arrays.asList(h));

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>(); //este creata mapa rezident-preferinte
        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2])); //se populeaza mapa
        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> hosPrefMap = new HashMap<>(); //este creata mapa spital-preferinte si initializata in mod diferit
        List<Resident> prefList1 = new ArrayList<>();
        prefList1.add(r[3]);
        prefList1.add(r[0]);
        prefList1.add(r[1]);
        prefList1.add(r[2]);
        hosPrefMap.put(h[0], prefList1);

        //prefList.clear();  //lista este curatata pentru a adauga urmatoarea lista de preferinte
        List<Resident> prefList2 = new ArrayList<>();
        prefList2.add(r[0]);
        prefList2.add(r[2]);
        prefList2.add(r[1]);
        hosPrefMap.put(h[1], prefList2);

        //prefList.clear();
        List<Resident> prefList3 = new ArrayList<>();
        prefList3.add(r[0]);
        prefList3.add(r[1]);
        prefList3.add(r[3]);
        hosPrefMap.put(h[2], prefList3);
        //System.out.println(hosPrefMap); //debug

        List<Hospital> target = Arrays.asList(h[0], h[2]); //se salveaza intr-o lista spitalele cautate
        residentList
                .stream()
                .filter(res -> resPrefMap.get(res).containsAll(target))
                .forEach(res -> System.out.println(res.getName() + " are in preferinte H0 si H2"));

        hospitalList
                .stream()
                .filter(hos -> hosPrefMap.get(hos).get(0).equals(r[0]))
                .forEach(hos -> System.out.println(hos.getName() + " are in topul preferintelor R0"));
        Problem p = new Problem(hosPrefMap,resPrefMap);
        List<Matching<Resident,Hospital>> problema = new ArrayList<>();
        problema=p.rezolva();
        for (Matching<Resident, Hospital> residentHospitalMatching : problema) {
            System.out.println(residentHospitalMatching);
        }

    }
}
