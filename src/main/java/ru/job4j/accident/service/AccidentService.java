package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.repository.AccidentTypeRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class AccidentService {
    private final AccidentMem accidentMem;
    private final AccidentTypeRepository accidentType;

    public AccidentService(AccidentMem accidentMem, AccidentTypeRepository accidentType) {
        this.accidentMem = accidentMem;
        this.accidentType = accidentType;
    }

    public Collection<Accident> accidentGetAll() {
        return accidentMem.getAccidentHashMap();
    }

    public List<AccidentType> getAccidentTypesList() {
        List<AccidentType> accidentTypes = new ArrayList<>();
        accidentType.findAll().forEach(accidentTypes::add);
        return accidentTypes;
    }

    public void create(Accident accident) {
        accidentMem.create(accident);
    }

    public void createOrUpdate(Accident accident) {
        if (accident.getId() == 0) {
            this.create(accident);
        } else {
            this.update(accident);
        }
    }

    public void update(Accident accident) {
        accidentMem.updateAcc(accident);
    }

    public Accident findAccident(int id) {
        return accidentMem.findById(id);
    }
}
