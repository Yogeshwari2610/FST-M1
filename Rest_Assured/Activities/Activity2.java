package activities;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Activity2 {
	
	//https://petstore.swagger.io/v2/user
	  String RootURL= "https://petstore.swagger.io/v2/user";
	
  @Test(priority=1)
  public void addUser() throws IOException  {
	
		  //import Json File
		  FileInputStream inputfile = new FileInputStream("C:\\Users\\002GLT744\\eclipse-workspace\\RestAssured_Project\\src\\test\\java\\activities\\userInfo.json");
		  
		  //read Json file
		  String reqBody = new String(inputfile.readAllBytes());
		   
		  Response response =
				    given()
				    .header("Content-Type","application/json")
				    .body(reqBody).when().post(RootURL);   	
		  inputfile.close();
		  //Assertion
		  response.then().statusCode(200);
		  response.then().log().all(); 	 
		  response.then().body("code", equalTo(200));
  }
  
  @Test(priority=2)
  public void retrieveUserDetails() throws FileNotFoundException {
	  //import json file to write to
	  File outputFile = new File("src\\test\\java\\activities\\userResponse.json");
	  
	  Response response =
			    given().header("Content-Type","application/json")
			    .when().pathParam("username", "lavanya")
			    .get(RootURL + "/{username}");
	  
	  //Get Response Body
	  String resBody = response.getBody().asPrettyString();
	  
	  try {
		  outputFile.createNewFile();
		  
		  FileWriter writer = new FileWriter(outputFile.getPath());
		  writer.write(resBody);
		  writer.close();		   	  
	  }
	  catch(IOException excp){
		  excp.printStackTrace();
	  }
	  //Assertions
	// Assertion
      response.then().body("id", equalTo(73965));
      response.then().body("username", equalTo("Lise"));
      response.then().body("firstName", equalTo("Nik"));
      response.then().body("lastName", equalTo("Case"));
      response.then().body("email", equalTo("lisenik@mail.com"));
      response.then().body("password", equalTo("password123"));
      response.then().body("phone", equalTo("4162349087"));
    }
  
  @Test(priority=3)
  public void deleteUser() {
	  Response response =
			   given().header("Content-Type","application/json")
			   .when().pathParam("username", "lavanya")
			   .delete(RootURL +"/{username}");
	  //assertions
	  response.then().statusCode(200);
			   
  }
  
}