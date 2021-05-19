package ru.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentHibernate;
import ru.job4j.accident.repository.AccidentMem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccidentService {
    private final AccidentHibernate accidentHibernate;

    @Autowired
    public AccidentService(AccidentHibernate accidentHibernate) {
        this.accidentHibernate = accidentHibernate;
    }

    public Collection<Accident> accidentGetAll() {
        return accidentHibernate.getAll();
    }

    public List<AccidentType> getAccidentTypesList() {
        return new ArrayList<>(accidentHibernate.getAccidentTypes());
    }

    public void create(Accident accident) {
        accidentHibernate.create(accident);
    }

    public void createOrUpdate(Accident accident) {
        if (accident.getId() == 0) {
            this.create(accident);
        } else {
            this.update(accident);
        }
    }

    public void update(Accident accident) {
        accidentHibernate.updateAcc(accident);
    }

    public Accident findAccident(int id) {
        return accidentHibernate.findById(id);
    }

    public Collection<Rule> getAllRule() {
        return accidentHibernate.getRules();
    }

    public Rule findByIdRule(int id) {
        return accidentHibernate.findRule(id);
    }
}
