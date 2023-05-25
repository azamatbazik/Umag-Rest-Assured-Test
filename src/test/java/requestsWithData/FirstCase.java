package requestsWithData;

import Authorizations.Authorization;
import Environments.CollectionEnvironments;
import Specifications.Specifications;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import static constructorFile.getRequest.getData;
import static io.restassured.RestAssured.given;

public class FirstCase {
    static CollectionEnvironments collectionEnvironments = new CollectionEnvironments();
    static Integer storeId = Authorization.globalEnvironments.getStoreId();
    static long isoTimestampNow = System.currentTimeMillis();
    @Test
    public static void listProduct() {
        JsonPath jsonPath = getData(("/rest/cabinet/nom/product/all?first=0&pageSize=25&type=0&storeId=")+storeId).jsonPath();
        List<Long> barcodeList = jsonPath.getList("list.barcode");
        collectionEnvironments.setBarcode(barcodeList.get(0));
        System.out.println(collectionEnvironments.getBarcode());
    }
    @Test
    public static void listRevisions(){
        long revisionTime = isoTimestampNow-(isoTimestampNow*3650);
        JsonPath jsonPath = getData(("/rest/cabinet/opr/revision/list?first=0&pageSize=25&from="+revisionTime+"&to="+isoTimestampNow+"&storeId="+storeId)).jsonPath();
        List<Long> revisionList = jsonPath.getList("data.createDate");
        collectionEnvironments.setIncorrectRevisionDate(revisionList.get(0)-86400000);
        System.out.println(collectionEnvironments.getIncorrectRevisionDate());
    }
    @Test
    public static void settingsPermissions(){

        JsonPath jsonPath = getData(("/rest/cabinet/org/store/configs?storeId="+storeId)).jsonPath();
        Long maxDayDiff = jsonPath.get("maxDayDiff");
        long incorrectMaxDayDiff = (maxDayDiff+1)*86400000;
        collectionEnvironments.setIncorrectMaxDayDiff(isoTimestampNow-incorrectMaxDayDiff);
    }
    @Test
    public static void userData(){
        JsonPath jsonPath = getData(("/rest/cabinet/org/profile?storeId="+storeId)).jsonPath();
        String firstName = jsonPath.get("firstName");
        collectionEnvironments.setFirstName(firstName);
    }

    @Test
    public static void accountDetails(){
        JsonPath jsonPath = getData(("/rest/cabinet/org/account/list?storeId="+storeId)).jsonPath();
        List<Integer> supplyPaymentScoreId = jsonPath.getList("accounts.id");
        collectionEnvironments.setSupplyPaymentScoreId(supplyPaymentScoreId.get(0));
    }
    @Test
    public static void supplierList(){
        JsonPath jsonPath = getData(("/rest/cabinet/org/agent/list-agent-names?agentType=SUPPLIER&storeId="+storeId)).jsonPath();
        List<Integer> supplierId = jsonPath.getList("id");
        List<String> supplierName = jsonPath.getList("name");
        collectionEnvironments.setSupplierId(supplierId.get(0));
        collectionEnvironments.setSupplierName(supplierName.get(0));
    }

}
