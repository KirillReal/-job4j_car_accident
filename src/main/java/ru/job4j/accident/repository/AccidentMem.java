package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;

@Repository
public class AccidentMem {
    private static int idAcc;
    private final HashMap<Integer, Accident> accidentHashMap = new HashMap<>();

    public AccidentMem() {
        accidentHashMap.put(+idAcc, new Accident(1, "accident", "Honda", "Delovaya,7"));
        accidentHashMap.put(+idAcc, new Accident(2, "accident", "Lada", "Gagarina,13"));
        accidentHashMap.put(+idAcc, new Accident(3, "accident", "Toyota", "Lenina,9"));
    }

    public HashMap<Integer, Accident> getAccidentHashMap() {
        return accidentHashMap;
    }

    public void  create(Accident accident) {
        accident.setId(++idAcc);
        accidentHashMap.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return accidentHashMap.get(id);
    }

    public Accident updateAcc(Accident accident) {
        return accidentHashMap.put(accident.getId(), accident);
    }

}
