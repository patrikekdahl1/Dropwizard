package com.pedro.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Person {

    /*
    @JsonProperty
    private ObjectId id;

    */

    @JsonProperty
    private String fullName;


    @JsonProperty
    private String fName;

    @JsonProperty
    private String lName;



    public Person() {
        // Jackson deserialization
    }

    public Person(Document document){
       // this.id = document.getObjectId("_id");
        this.fName = document.getString("fName");
        this.lName = document.getString("lName");
        this.fullName = document.getString("fullName");
    }

     /*
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    */

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

}
