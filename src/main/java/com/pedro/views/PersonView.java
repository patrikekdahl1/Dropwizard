package com.pedro.views;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pedro.core.Person;

import java.util.List;
import com.yammer.dropwizard.views.View;

public class PersonView extends View{

    @JsonProperty
    private final List<Person> personList;

    public PersonView(List<Person> personList) {
        super("/views/person.mustache");
        this.personList = personList;
    }

    @JsonProperty
    public List<Person> getPersonList() {
        return  personList;
    }
}
