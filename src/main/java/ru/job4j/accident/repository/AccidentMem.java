package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidentHashMap = new HashMap<>();

    public AccidentMem() {
        accidentHashMap.put(1, new Accident(1, "accident", "Honda", "Delovaya,7"));
        accidentHashMap.put(2, new Accident(2, "accident", "Lada", "Gagarina,13"));
        accidentHashMap.put(3, new Accident(3, "accident", "Toyota", "Lenina,9"));
    }


    public HashMap<Integer, Accident> getAccidentHashMap() {
        return accidentHashMap;
    }
}
