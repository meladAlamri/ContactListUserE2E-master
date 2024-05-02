package stepDefinitionsContact;

import Pojos.ContactPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.response.Response;
import org.junit.runner.RunWith;

import static base_urls.UserContactsBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


public class ContactListContactStepDefinitions {
    ContactPojo expectedData;
    Response response;
    String deleteResponse;
    String id;

    @Given("set the url for adding contact")
    public void set_the_url_for_adding_contact() {

        spec.pathParam("first", "contacts");
    }

    @And("set the expected data for adding contact")
    public void set_the_expected_data_for_adding_contact() throws JsonProcessingException {
        String strJson = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }""";

        expectedData = new ObjectMapper().readValue(strJson, ContactPojo.class);
        System.out.println("expectedData = " + expectedData);


    }

    @When("send the post request for adding contact")
    public void send_the_post_request_for_adding_contact() {
        response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();
        id = response.jsonPath().getString("_id");
    }


    @Then("do assertion for adding contact")
    public void do_assertion_for_adding_contact() {
        response
                .then()
                .assertThat()
                .statusCode(201)
                .body("firstName", equalTo(expectedData.getFirstName()),
                        "lastName", equalTo(expectedData.getLastName()),
                        "birthdate", equalTo(expectedData.getBirthdate())
                        , "country", equalTo(expectedData.getCountry())

                        , "phone", equalTo(expectedData.getPhone())
                        , "city", equalTo(expectedData.getCity())
                        , "postalCode", equalTo(expectedData.getPostalCode())
                        , "stateProvince", equalTo(expectedData.getStateProvince())
                        , "street1", equalTo(expectedData.getStreet1())
                        , "street2", equalTo(expectedData.getStreet2())
                        , "email", equalTo(expectedData.getEmail())
                );

    }

    @Given("set the url for reading contact")
    public void setTheUrlForReadingContact() {
        //https://thinking-tester-contact-list.herokuapp.com/contacts/
        spec.pathParam("first", "contacts");
    }

    @And("set the expected data for reading contact")
    public void setTheExpectedDataForReadingContact() throws JsonProcessingException {
        String strJson = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }""";

        expectedData = new ObjectMapper().readValue(strJson, ContactPojo.class);
        System.out.println("expectedData = " + expectedData);
    }

    @When("send the get request for reading contact")
    public void sendThePostRequestForReadingContact() {
        response = given(spec).get("{first}/"+id);
        response.prettyPrint();

    }

    @Then("do assertion for reading contact")
    public void doAssertionForReadingContact() {
        response
                .then()
                .assertThat()
                .statusCode(404);

    }

    @Given("set the url for updating contact")
    public void setTheUrlForUpdatingContact() {
        spec.pathParam("first", "contacts");
    }

    @And("set the expected data for updating contact")
    public void setTheExpectedDataForUpdatingContact() throws JsonProcessingException {
        String strJson = """
                {
                    "firstName": "Dana",
                    "lastName": "AlDana",
                    "birthdate": "1990-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }""";

        expectedData = new ObjectMapper().readValue(strJson, ContactPojo.class);
        System.out.println("expectedData = " + expectedData);

    }

    @When("send the post request for updating contact")
    public void sendThePostRequestForUpdatingContact() {
        response = given(spec).body(expectedData).put("{first}/"+id);
        response.prettyPrint();
    }

    @Then("do assertion for updating contact")
    public void doAssertionForUpdatingContact() {
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstName", equalTo(expectedData.getFirstName()),
                        "lastName", equalTo(expectedData.getLastName()),
                        "birthdate", equalTo(expectedData.getBirthdate())
                        , "country", equalTo(expectedData.getCountry())

                        , "phone", equalTo(expectedData.getPhone())
                        , "city", equalTo(expectedData.getCity())
                        , "postalCode", equalTo(expectedData.getPostalCode())
                        , "stateProvince", equalTo(expectedData.getStateProvince())
                        , "street1", equalTo(expectedData.getStreet1())
                        , "street2", equalTo(expectedData.getStreet2())
                        , "email", equalTo(expectedData.getEmail())
                );
    }

    @Given("set the url for deleting contact")
    public void setTheUrlForDeletingContact() {
        spec.pathParam("first", "contacts");
    }

    @And("set the expected data for deleting contact")
    public void setTheExpectedDataForDeletingContact() {
        deleteResponse = "Contact deleted";

    }

    @When("send the delete request for deleting contact")
    public void sendThePostRequestForDeletingContact() {
        response = given(spec).delete("{first}/"+id);
        //--
        response.prettyPrint();
    }

    @Then("do assertion for deleting contact")
    public void doAssertionForDeletingContact() {
        response
                .then()
                .assertThat()
                .statusCode(200);
        assertEquals(response.asString(),deleteResponse);
    }

    @Then("do assertion for negative reading contact")
    public void doAssertionForNegativeReadingContact() {
        response
                .then()
                .assertThat()
                .statusCode(404);
    }

}