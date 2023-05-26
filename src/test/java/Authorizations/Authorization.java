package Authorizations;
import Environments.GlobalEnvironments;
import Specifications.Specifications;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;


import static constructorFile.getRequest.getAuthData;
import static constructorFile.getRequest.getData;
import static io.restassured.RestAssured.given;
import static requestsWithData.FirstCase.*;

public class Authorization extends GlobalEnvironments{
    public static GlobalEnvironments globalEnvironments = new GlobalEnvironments();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input user_login_pass - ");
        globalEnvironments.setUser_login_pass(bufferedReader.readLine());
        System.out.print("Input setApiVer - ");
        globalEnvironments.setApiVer(bufferedReader.readLine());
        System.out.print("Input clientVer - ");
        globalEnvironments.setClientVer(bufferedReader.readLine());
        System.out.print("Input host - ");
        globalEnvironments.setHost(bufferedReader.readLine());
        globalEnvironments.setBasic_auth(globalEnvironments.getUser_login_pass());
        authorizationSignin();
        authorizationList();
        listProduct();
        productDataNotPrice();
    }

    @Test
    public static void authorizationSignin() throws JsonProcessingException {
//        Specifications.installSpecification(Specifications.requestSpec(globalEnvironments.getHost()), Specifications.responseSpecOk200());
//        Response response = given()
//                .header("Authorization", globalEnvironments.getBasic_auth())
//                .header("api_ver", globalEnvironments.getApiVer())
//                .header("client-ver", globalEnvironments.getClientVer())
//                .when()
//                .get("/rest/cabinet/org/login/signin")
//                .then()/*.log().all()*/
//                .extract().response();


        JsonPath jsonPath = getAuthData("/rest/cabinet/org/login/signin").jsonPath();
        Integer userId = jsonPath.get("userId");
        String sessionToken = jsonPath.get("sessionToken");
        globalEnvironments.setUserId(userId);
        globalEnvironments.setAuthorization(sessionToken);
    }
    @Test
    public static void authorizationList()throws JsonProcessingException{
//        Specifications.installSpecification(Specifications.requestSpec(globalEnvironments.getHost()), Specifications.responseSpecOk200());
//        Response response = given()
//                .header("Authorization", globalEnvironments.getAuthorization().toString())
//                .header("api-ver", globalEnvironments.getApiVer().toString())
//                .header("client-ver", globalEnvironments.getClientVer().toString())
//                .when()
//                .get("/rest/cabinet/org/store/list")
//                .then().log().all()
//                .extract().response();
        JsonPath jsonPath = getData("/rest/cabinet/org/store/list").jsonPath();
        List<Integer> storeIds = jsonPath.getList("id");
        List<Integer> storeGroupIds = jsonPath.getList("storeGroupId");
        globalEnvironments.setStoreId(storeIds.get(0));
        globalEnvironments.setStoreGroupId(storeGroupIds.get(0));

    }
}
