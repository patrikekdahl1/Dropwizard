package com.pedro.resources;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.pedro.core.Person;
import com.pedro.views.PersonView;
import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.pedro.DropwizardService.*;

@Path("/")
public class DropwizardResource {

    FindIterable<Document> iterable;

    public DropwizardResource() {
        super();
    }

    @Path("person")
    @Produces(MediaType.TEXT_HTML)
    @GET
    public PersonView view() {

        ArrayList<Person> personList1 = new ArrayList<Person>();

        iterable = db.getCollection("peoplecollection").find();
        for (Document document : iterable) {
            personList1.add(new Person(document));
        }
        return new PersonView(personList1);
    }


    @Path("searchPerson")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public PersonView view(@QueryParam("name") String name) {

        ArrayList<Person> personList = new ArrayList<Person>();

        if (name != null) {
            Pattern regex = Pattern.compile(name, Pattern.CASE_INSENSITIVE);

            BasicDBObject fName = new BasicDBObject("fName", regex);
            BasicDBObject lName = new BasicDBObject("lName", regex);
            BasicDBObject fullName = new BasicDBObject("fullName", regex);

            BasicDBList or = new BasicDBList();
            or.add(fName);
            or.add(lName);
            or.add(fullName);

            BasicDBObject query = new BasicDBObject("$or", or);

            iterable = db.getCollection("peoplecollection").find(query);

            for (Document document : iterable) {
                personList.add(new Person(document));
            }
        }
        return new PersonView(personList);
    }

}