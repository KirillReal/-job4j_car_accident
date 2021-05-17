package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentMem {
    private static int idAcc;
    private final HashMap<Integer, Accident> accidentHashMap = new HashMap<>();

    private final List<AccidentType> types = List.of(
            AccidentType.of(1, "Две машины"),
            AccidentType.of(2, "Машина и человек"),
            AccidentType.of(3, "Машина и велосипед")
    );

    public AccidentMem() {
        accidentHashMap.put(+idAcc, new Accident(1, "accident", "Honda", "Delovaya,7"));
        accidentHashMap.put(+idAcc, new Accident(2, "accident", "Lada", "Gagarina,13"));
        accidentHashMap.put(+idAcc, new Accident(3, "accident", "Toyota", "Lenina,9"));
    }

    public Collection<Accident> getAccidentHashMap() {
        return accidentHashMap.values();
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
