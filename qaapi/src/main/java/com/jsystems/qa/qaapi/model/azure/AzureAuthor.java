package com.jsystems.qa.qaapi.model.azure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AzureAuthor {

    @JsonProperty(value = "ID", required = true)
    public long id;

    @JsonProperty(value = "IDBook", required = true)
    public long idBook;

    @JsonProperty(value = "FirstName")
    public String firstName;

    @JsonProperty(value = "LastName")
    public  String lastName;
}
