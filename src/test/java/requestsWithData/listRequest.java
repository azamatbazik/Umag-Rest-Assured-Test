package requestsWithData;

import Authorizations.Authorization;
import Environments.CollectionEnvironments;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.util.List;

import static constructorFile.getRequest.getData;
import static io.restassured.RestAssured.given;

public class listRequest {
    public static CollectionEnvironments collectionEnvironments = new CollectionEnvironments();
    public static Integer storeId = Authorization.globalEnvironments.getStoreId();
    static long isoTimestampNow = System.currentTimeMillis();

    @Test
    public static void listProduct() {
        JsonPath jsonPath = getData(("/rest/cabinet/nom/product/all?first=0&pageSize=25&type=0&storeId=") + storeId).jsonPath();
        List<Long> barcodeList = jsonPath.getList("list.barcode");
        collectionEnvironments.setBarcode(barcodeList.get(0));
        System.out.println(collectionEnvironments.getBarcode());
    }

    @Test
    public static void listRevisions() {
        long revisionTime = isoTimestampNow - (isoTimestampNow * 3650);
        JsonPath jsonPath = getData(("/rest/cabinet/opr/revision/list?first=0&pageSize=25&from=" + revisionTime + "&to=" + isoTimestampNow + "&storeId=" + storeId)).jsonPath();
        List<Long> revisionList = jsonPath.getList("data.createDate");
        collectionEnvironments.setIncorrectRevisionDate(revisionList.get(0) - 86400000);
        System.out.println(collectionEnvironments.getIncorrectRevisionDate());
    }

    @Test
    public static void settingsPermissions() {

        JsonPath jsonPath = getData(("/rest/cabinet/org/store/configs?storeId=" + storeId)).jsonPath();
        int maxDayDiff = jsonPath.get("maxDayDiff");
        long incorrectMaxDayDiff = (long)((maxDayDiff + 1) *86400000);
        collectionEnvironments.setIncorrectMaxDayDiff(isoTimestampNow - incorrectMaxDayDiff);
    }

    @Test
    public static void userData() {
        JsonPath jsonPath = getData(("/rest/cabinet/org/profile?storeId=" + storeId)).jsonPath();
        String firstName = jsonPath.get("firstName");
        collectionEnvironments.setFirstName(firstName);
    }

    @Test
    public static void accountDetails() {
        JsonPath jsonPath = getData(("/rest/cabinet/org/account/list?storeId=" + storeId)).jsonPath();
        List<Integer> supplyPaymentScoreId = jsonPath.getList("accounts.id");
        collectionEnvironments.setSupplyPaymentScoreId(supplyPaymentScoreId.get(0));
    }

    @Test
    public static void supplierList() {
        JsonPath jsonPath = getData(("/rest/cabinet/org/agent/list-agent-names?agentType=SUPPLIER&storeId=" + storeId)).jsonPath();
        List<Integer> supplierId = jsonPath.getList("id");
        List<String> supplierName = jsonPath.getList("name");
        collectionEnvironments.setSupplierId(supplierId.get(0));
        collectionEnvironments.setSupplierName(supplierName.get(0));
    }

    @Test
    public static void productDataNotPrice() {
        JsonPath jsonPath = getData(("/rest/cabinet/nom/product/findProductByBarcode?showServices=false&showPackages=false&showDeleted=true&barcode=" + collectionEnvironments.getBarcode() + "&create=true&storeId=" + storeId)).jsonPath();
        Object object = jsonPath.get("product");
        int stockQuantity = (jsonPath.get("stockQuantity"));
        collectionEnvironments.setStockQuantity(stockQuantity);
        collectionEnvironments.setDataOfProduct(object);
    }

    @Test
    public static void productDataWithPrice() {
        JsonPath jsonPath = getData(("/rest/cabinet/nom/product/" + collectionEnvironments.getBarcode() + "?storeId=" + storeId)).jsonPath();
        Object category = jsonPath.get("category");
        if (category != null) {
            collectionEnvironments.setDataOfCategory(category);
            Object subCategory = jsonPath.get("subCategory");
            collectionEnvironments.setDataOfSubCategory(subCategory);

        } else {
            collectionEnvironments.setDataOfCategory(null);
        }
        collectionEnvironments.setSupplyProductId(jsonPath.get("productInfo.id"));
        collectionEnvironments.setSupplyArrivalCostProductPrise(jsonPath.get("productPrice.arrivalCost"));
        collectionEnvironments.setSupplySellingPriceProductPrise(jsonPath.get("productPrice.sellingPrice"));
        collectionEnvironments.setSupplyWholesalePriceProductPrice(jsonPath.get("productPrice.wholesalePrice"));

        float supplyArrivalCostProduct = (jsonPath.get("productPrice.arrivalCost"));
        float supplySellingPriceProduct = (jsonPath.get("productPrice.sellingPrice"));

        float amountMarkup = supplySellingPriceProduct - supplyArrivalCostProduct;
        float onePercent = supplyArrivalCostProduct / 100;
        float percentMarkup = Float.parseFloat(String.valueOf(amountMarkup / onePercent));
        collectionEnvironments.setPercentMarkup(percentMarkup);

        int quantityProduct = 1;
        collectionEnvironments.setQuantityProduct(quantityProduct);

        Float supplyAmount = supplyArrivalCostProduct*quantityProduct;
        collectionEnvironments.setSupplyAmount(supplyAmount);

        int newQuantityProduct = 10;
        float newSupplyArrivalCostProduct = supplyArrivalCostProduct + 10;
        float supplySumMarkup = (newSupplyArrivalCostProduct/100)*percentMarkup;
        float newSupplySellingPriceProduct = newSupplyArrivalCostProduct+supplySumMarkup;
        float newSupplyAmount = newSupplyArrivalCostProduct*newQuantityProduct;

        collectionEnvironments.setNewQuantityProduct(newQuantityProduct);
        collectionEnvironments.setNewSupplyAmount(newSupplyAmount);
        collectionEnvironments.setNewSupplyArrivalCostProduct(newSupplyArrivalCostProduct);
        collectionEnvironments.setNewSupplySellingPriceProduct(newSupplySellingPriceProduct);
    }
}
