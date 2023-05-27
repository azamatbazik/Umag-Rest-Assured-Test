package constructorFile;

import Specifications.Specifications;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static Authorizations.Authorization.globalEnvironments;

public class postRequest {
    public static Response postData(String rest, Object body){
        Specifications.installSpecification(Specifications.requestSpec(globalEnvironments.getHost()), Specifications.responseSpecOk200());
        return given()
                .header("Authorization", globalEnvironments.getAuthorization())
                .header("api-ver", globalEnvironments.getApiVer())
                .header("client-ver", globalEnvironments.getClientVer())
                .body(body)
                .when()
                .post(rest)
                .then().log().all()
                .extract().response();
    }
}
