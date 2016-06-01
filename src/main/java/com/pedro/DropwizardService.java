package com.pedro;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.pedro.resources.DropwizardResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;


public class DropwizardService extends Service<DropwizardConfiguration>{

    public static MongoDatabase db;
    public static MongoClient mongoClient;

    public static void main(String[] args) throws Exception {
        new DropwizardService().run(args);
        mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDatabase("peopledb");
    }


    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(DropwizardConfiguration configuration, Environment environment) {
        environment.addResource(DropwizardResource.class);
    }
}
