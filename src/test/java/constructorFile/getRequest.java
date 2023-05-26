package constructorFile;

import Specifications.Specifications;
import io.restassured.response.Response;
import org.junit.Test;

import static Authorizations.Authorization.globalEnvironments;
import static io.restassured.RestAssured.given;

public class getRequest {
    public static Response getAuthData(String rest){
        Specifications.installSpecification(Specifications.requestSpec(globalEnvironments.getHost()), Specifications.responseSpecOk200());
        return given()
                .header("Authorization", globalEnvironments.getBasic_auth())
                .header("api_ver", globalEnvironments.getApiVer())
                .header("client-ver", globalEnvironments.getClientVer())
                .when()
                .get(rest)
                .then().log().all()
                .extract().response();
    }
    public static Response getData(String rest){
        Specifications.installSpecification(Specifications.requestSpec(globalEnvironments.getHost()), Specifications.responseSpecOk200());
        return given()
                .header("Authorization", globalEnvironments.getAuthorization())
                .header("api-ver", globalEnvironments.getApiVer())
                .header("client-ver", globalEnvironments.getClientVer())
                .when()
                .get(rest)
                .then().log().all()
                .extract().response();
    }
}
