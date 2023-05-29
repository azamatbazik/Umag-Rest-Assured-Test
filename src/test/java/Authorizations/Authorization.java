package Authorizations;
import Environments.GlobalEnvironments;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;


import static casesOfRequests.time.currentDate;
import static constructorFile.getRequest.getAuthData;
import static constructorFile.getRequest.getData;
import static io.restassured.RestAssured.given;
import static requestsWithData.listRequest.*;

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
        currentDate();
    }

    @Test
    public static void authorizationSignin() throws JsonProcessingException {

        JsonPath jsonPath = getAuthData("/rest/cabinet/org/login/signin").jsonPath();
        Integer userId = jsonPath.get("userId");
        String sessionToken = jsonPath.get("sessionToken");
        globalEnvironments.setUserId(userId);
        globalEnvironments.setAuthorization(sessionToken);
    }
    @Test
    public static void authorizationList()throws JsonProcessingException{

        JsonPath jsonPath = getData("/rest/cabinet/org/store/list").jsonPath();
        List<Integer> storeIds = jsonPath.getList("id");
        List<Integer> storeGroupIds = jsonPath.getList("storeGroupId");
        globalEnvironments.setStoreId(storeIds.get(0));
        globalEnvironments.setStoreGroupId(storeGroupIds.get(0));

    }
}
