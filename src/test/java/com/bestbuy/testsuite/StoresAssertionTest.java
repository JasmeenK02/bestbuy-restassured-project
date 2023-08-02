package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class StoresAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }
    @Test

    public void test001(){
        response.body("total",equalTo(1561));
    }

    @Test
    //2. Verify the if the stores of limit is equal to 10
    public void test002(){
        response.body("limit", equalTo(10));

    }
    @Test
    //3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    public void test003(){
        response.body("data.name", hasItem("Inver Grove Heights"));
    }
    @Test
    //4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    public void test004(){
        response.body("data.name", hasItems(" Roseville, Burnsville, Maplewood"));

    }


    //5. Verify the storeId=7 inside storeservices of the third store of second services

    @Test
    public void test005(){
        response.body("data[2].services[1].storeservices",hasKey("storeId"));
    }





    //6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
    @Test
    public void test006(){
    // response.body("data.findAll{it.name == 'Roseville'}.services.storeservices.createdAt", HashMap<String,>);
    }

    @Test
    public void test008(){
        response.body("data[8].name", equalTo("Rochester"));
    }
}
