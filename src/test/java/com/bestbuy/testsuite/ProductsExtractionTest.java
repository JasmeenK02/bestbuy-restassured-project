package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    //21. Extract the limit
    @Test
    public void test021() {
        int limit = response.extract().path("limit");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("The value of limit is: " + limit);
        System.out.println("---------------------End of Test---------------------");
    }

    //22. Extract the total
    @Test
    public void test022() {
        int total = response.extract().path("total");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("The value of limit is: " + total);
        System.out.println("---------------------End of Test---------------------");
    }

    //23. Extract the name of 5th product
    @Test
    public void test023() {
        String productName = response.extract().path("data[4].name");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("The name of 5th product is: " + productName);
        System.out.println("---------------------End of Test---------------------");
    }

    //24. Extract the names of all the products
    @Test
    public void test024() {
        List<String> productNames = response.extract().path("data.name");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("The names of all product are: " + productNames);
        System.out.println("---------------------End of Test---------------------");
    }

    //25. Extract the productId of all the products
    @Test
    public void test025() {
        List<Integer> productId = response.extract().path("data.id");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("The Id's of all product are: " + productId);
        System.out.println("---------------------End of Test---------------------");
    }

    //26. Print the size of the data list
    @Test
    public void test026() {
        int dataList = response.extract().path("data.size");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("The size of data list is: " + dataList);
        System.out.println("---------------------End of Test---------------------");
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test027() {
        List<HashMap<String, ?>> productValue = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("The values of all product are: " + productValue);
        System.out.println("---------------------End of Test---------------------");
    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test028() {
        List<String> productModel = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("The model of the product is: " + productModel);
        System.out.println("---------------------End of Test---------------------");
    }

    //29. Get all the categories of 8th products
    @Test
    public void test029() {
        List<?> allCategories = response.extract().path("data[7].categories");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("All the categories of 8th product are: " + allCategories);
        System.out.println("---------------------End of Test---------------------");
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void test030() {
        List<?> categories = response.extract().path("data.findAll{it.id == 150115}.categories");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("All the categories of store with id 150115 are: " + categories);
        System.out.println("---------------------End of Test---------------------");
    }

    //31. Get all the descriptions of all the products
    @Test
    public void test031() {
        List<String> allDescription = response.extract().path("data.description");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("All the description of all the products are: " + allDescription);
        System.out.println("---------------------End of Test---------------------");
    }

    //32. Get id of all the all categories of all the products
    @Test
    public void test032() {
        List<HashMap<String, ?>> allId = response.extract().path("data.categories.id");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("All the id's of all categories of all products is: " + allId);
        System.out.println("---------------------End of Test---------------------");
    }

    //33. Find the product names Where type = HardGood
    @Test
    public void test033() {
        List<HashMap<String, ?>> productNames = response.extract().path("data.findAll{it.type == 'HardGood'}.name");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("All the names where type is HardGood: " + productNames);
        System.out.println("---------------------End of Test---------------------");
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034() {
        List<?> totalCategories = response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Total number of categories is: " + totalCategories.size());
        System.out.println("---------------------End of Test---------------------");
    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035() {
        List<String> createdAt = response.extract().path("data.findAll{it.price <5.49}.createdAt");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Created at whose price is <5.49: " + createdAt);
        System.out.println("---------------------End of Test---------------------");
    }

    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void test036() {
        List<HashMap<String, ?>> allCategories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Name of all categories: " + allCategories);
        System.out.println("---------------------End of Test---------------------");
    }

    //37. Find the manufacturer of all the products
    @Test
    public void test037() {
        List<HashMap<String, ?>> manufacturer = response.extract().path("data.manufacturer");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Name of all manufacturer: " + manufacturer);
        System.out.println("---------------------End of Test---------------------");
    }

    //38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void test038() {
        List<HashMap<String, ?>> image = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Image of product is: " + image);
        System.out.println("---------------------End of Test---------------------");
    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039() {
        List<HashMap<String, ?>> createdAt = response.extract().path("data.findAll{it.price >5.99}.createdAt");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Created at whose price is >5.49: " + createdAt);
        System.out.println("---------------------End of Test---------------------");
    }

    //40. Find the url of all the products
    @Test
    public void test040 () {
        List<HashMap<String, ?>> url = response.extract().path("data.url");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Url of products are: " + url);
        System.out.println("---------------------End of Test---------------------");
    }
}
