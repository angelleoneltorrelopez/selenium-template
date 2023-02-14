package test.api;

import auxiliary.tools.RequestMethods;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestAPI {

    @BeforeClass
    public void setUp(){
        RequestMethods.changeURL("https://reqres.in/api");
    }

    @Test
    public void testGet(){
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("id", 2);
        JsonPath response = RequestMethods.rawToJson(RequestMethods.getRequest("/users/", parameters, 200));
        Assert.assertEquals(response.getString("data.id"), "2");
    }

    @Test
    public void testPost(){
        String body = "{\"id\": 2, \"name\": \"Angel\", \"job\": \"QA\"}";
        JsonPath response = RequestMethods.rawToJson(RequestMethods.postRequest("/users/", body, 201));
        Assert.assertEquals(response.getString("name"), "Angel");
    }

    @Test
    public void testPut(){
        String body = "{\"name\": \"Leonel\", \"job\": \"QM\"}";
        JsonPath response = RequestMethods.rawToJson(RequestMethods.putRequest("/users/2", body, 200));
        Assert.assertEquals(response.getString("name"), "Leonel");
        Assert.assertEquals(response.getString("job"), "QM");
    }

    @Test
    public void testDelete(){
        RequestMethods.deleteRequest("https://reqres.in/api/users/2",  204);
    }
}
