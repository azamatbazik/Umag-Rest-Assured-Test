package casesOfRequests;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Authorizations.Authorization.globalEnvironments;
import static constructorFile.postRequest.postData;
import static requestsWithData.listRequest.collectionEnvironments;
import static requestsWithData.listRequest.storeId;

public class time {
    static long isoTimestampNow = System.currentTimeMillis();
    @Test
    public static void currentDate(){

        Map<String, Object> productDetail = new HashMap<>();
        productDetail.put("productUnits", new Object[0]);
        productDetail.put("product", collectionEnvironments.getDataOfProduct());
        productDetail.put("additionalCodes", new Object[0]);
        productDetail.put("arrivalCost", collectionEnvironments.getSupplyArrivalCostProductPrise());
        productDetail.put("sellingPrice", collectionEnvironments.getSupplySellingPriceProductPrise());
        productDetail.put("wholesalePrice", collectionEnvironments.getSupplyWholesalePriceProductPrice());
        productDetail.put("markup", collectionEnvironments.getPercentMarkup());
        productDetail.put("packages", new Object[0]);
        productDetail.put("isPackage", false);
        productDetail.put("isService", false);
        productDetail.put("additionalExpense", false);
        productDetail.put("storeId", globalEnvironments.getStoreId());
        productDetail.put("productId", collectionEnvironments.getSupplyProductId());
        productDetail.put("isHiddenOnScale", false);
        productDetail.put("numberOnScale", null);
        productDetail.put("stockQuantity", collectionEnvironments.getStockQuantity());
        productDetail.put("category", collectionEnvironments.getDataOfCategory());
        productDetail.put("subCategory", collectionEnvironments.getDataOfSubCategory());


        Map<String, Object> bodySupplyProduct = new HashMap<>();
        bodySupplyProduct.put("isDisabledSellingPrice", false);
        bodySupplyProduct.put("isVisiblePriceBefore", false);
        bodySupplyProduct.put("isVisibleOldSellingPrice", false);
        bodySupplyProduct.put("__markupOrigin", collectionEnvironments.getPercentMarkup());
        bodySupplyProduct.put("productDetail", productDetail);
        bodySupplyProduct.put("quantity", collectionEnvironments.getQuantityProduct());
        bodySupplyProduct.put("arrivalCost", collectionEnvironments.getSupplyArrivalCostProductPrise());
        bodySupplyProduct.put("priceBefore", collectionEnvironments.getSupplySellingPriceProductPrise());
        bodySupplyProduct.put("oldArrivalCost", collectionEnvironments.getSupplyArrivalCostProductPrise());
        bodySupplyProduct.put("discount", 0);
        bodySupplyProduct.put("sellingPrice", collectionEnvironments.getSupplySellingPriceProductPrise());
        bodySupplyProduct.put("oldSellingPrice", collectionEnvironments.getSupplySellingPriceProductPrise());
        bodySupplyProduct.put("sellingPriceCopy", collectionEnvironments.getSupplySellingPriceProductPrise());
        bodySupplyProduct.put("rowId", 0);
        bodySupplyProduct.put("price", collectionEnvironments.getSupplyArrivalCostProductPrise());
        bodySupplyProduct.put("amount", collectionEnvironments.getSupplyAmount());
        bodySupplyProduct.put("oldAmount", collectionEnvironments.getSupplyAmount());
        bodySupplyProduct.put("oldMarkup", 0);

        List<Object> supplyProducts = new ArrayList<>();
        supplyProducts.add(0, bodySupplyProduct);

        Map<String, Object> body = new HashMap<>();
        body.put("time", isoTimestampNow);
        body.put("amount", collectionEnvironments.getSupplyAmount());
        body.put("paymentType", 0);
        body.put("payment", 0);
        body.put("supplyProducts", supplyProducts.get(0));
        body.put("bonusProducts", new Object[0]);
        body.put("overdueProducts", new Object[0]);
        body.put("type", 0);
        body.put("isSupplyChange", true);
        body.put("isBindProductToSupplier", true);
        body.put("isSellingPriceChangeable", true);
        body.put("isSumSameProducts", true);
        body.put("isRestoreDeletedProducts", true);
        body.put("supplierId", collectionEnvironments.getSupplierId());
        body.put("accountId", collectionEnvironments.getSupplyPaymentScoreId());
        JsonPath jsonPath = postData(("/rest/cabinet/opr/supplies/create?storeId="+storeId), body).jsonPath();

    }
}
