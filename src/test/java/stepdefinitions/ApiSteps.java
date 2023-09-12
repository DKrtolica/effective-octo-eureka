package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    public static ValidatableResponse response;


    @Given("I am authenticated with {string} and {int}")

    public String getDayOfWeek(String dayofWeek, int count) {
        List<String> stringList =
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        for (int i = 0; i < stringList.size(); i++) {
            if(stringList.get(i).equalsIgnoreCase(dayofWeek)){
                int reminder = (count + i)  % 7;
                String s  = stringList.get(reminder);
                System.out.println("reminder is: " + reminder);
                System.out.println("day is: " + s);
                return stringList.get(reminder);
            }
        }
        int reminder = count % 7;
        String s  = stringList.get(reminder);
        System.out.println("day is: " + s);
        return stringList.get(reminder);
    }

    @Given("I am authenticated as api user with {string} and {string}")
    public void authenticateUser(String username, String password) {
        get("https://petstore.swagger.io/v2/user/login?username=dkrtolica&password=Admin123!",
                200);
    }

    @When("I submit request to create new user with username {string} and random values")
    public void createNewUser(String username) {
        Random random = new Random();
        UserUtil user = getPostUserPayloadWithRandomValues();

        post("https://petstore.swagger.io/v2/user/", user, 200);
    }

    @When("I submit request to get user {string}")
    public void getUserByUserName(String username) {
        get("https://petstore.swagger.io/v2/user/" + username,
                200);
    }

    @Then("status code is  {int}")
    public void validateStatusCode(int statusCode) {
        checkStatus(200);
    }

    public static ValidatableResponse get(String url, int statusCode) {
        response = given().log().all()
                .when().get(url)
                .then().log().all();
        checkStatus(statusCode);
        return response;
    }

    public static ValidatableResponse post(String url, Object body, int statusCode) {
        response = given().log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when().post(url)
                .then().log().all();
        checkStatus(statusCode);
        return response;
    }

    private static void checkStatus(int statusCode) {
        if (statusCode == response.extract().statusCode()) {
            return;
        }
        String errorMessage = "Expected response: " + statusCode + " but it was: " +
                response.extract().statusCode();
        throw new RuntimeException(errorMessage.toString());
    }

    public UserUtil getPostUserPayloadWithRandomValues() {
        Random random = new Random();
        String username = "" + random.nextInt(1000);
        System.out.println("Username is: " + username);
        return UserUtil.builder()
                .id(random.nextInt(1000))
                .userName(username)
                .firstName("" + random.nextInt(1000))
                .lastName("" + random.nextInt(1000))
                .email("dragisa.krtolica@gmail.com")
                .password("Admin123!")
                .phone("" + random.nextInt(1000))
                .userStatus("" + random.nextInt(1000))
                .build();
    }
}
