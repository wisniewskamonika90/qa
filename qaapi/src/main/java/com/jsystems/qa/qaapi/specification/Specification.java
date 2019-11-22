package com.jsystems.qa.qaapi.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {

    public static RequestSpecification fakeAzureSpecBuilder(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://fakerestapi.azurewebsites.net")
                .build();
    }
}
