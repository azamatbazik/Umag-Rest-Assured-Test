package casesOfRequests;

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

public class copyTime {
    static long isoTimestampNow = System.currentTimeMillis();
    @Test
    public static void currentDate(){
        Map<String, Object> category = new HashMap<>();
        category.put("id", 333492);
        category.put("name", "Незаданные");
        category.put("isDeleted", false);
        category.put("storeGroupId", 2305);
        category.put("parentId", null);
        category.put("globalCategory", -1);
        category.put("editTime", Long.parseLong("1679026701000"));
        category.put("createTime", Long.parseLong("1679026701000"));


        Map<String,Object > product = new HashMap<>();
        product.put("id",  81780741);
        product.put("storeGroupId", 2305);
        product.put("code", "3800024932762");
        product.put("barcode", Long.parseLong("3800024932762"));
        product.put("name", "Акура со вкусом малины винный напиток аромат.0.75л 8.5г");
        product.put("createTime", Long.parseLong("1683179227000"));
        product.put("editTime", "2023-05-28T15:12:29+0600");
        product.put("categoryId", 333492);
        product.put("type", 0);
        product.put("measure", 0);
        product.put("isDelete", false);
        product.put("auxAttrTypeId", 2);

        Map<String, Object> productDetail = new HashMap<>();
        productDetail.put("productUnits", new Object[0]);
        productDetail.put("product", product);
        productDetail.put("additionalCodes", new Object[0]);
        productDetail.put("arrivalCost", 100);
        productDetail.put("sellingPrice", 120);
        productDetail.put("wholesalePrice", 0);
        productDetail.put("markup", 20);
        productDetail.put("packages", new Object[0]);
        productDetail.put("isPackage", false);
        productDetail.put("isService", false);
        productDetail.put("additionalExpense", false);
        productDetail.put("storeId", 2413);
        productDetail.put("productId", 81780741);
        productDetail.put("isHiddenOnScale", false);
        productDetail.put("numberOnScale", null);
        productDetail.put("stockQuantity", 11);
        productDetail.put("category", category);
        productDetail.put("subCategory", null);


        Map<String, Object> bodySupplyProduct = new HashMap<>();
        bodySupplyProduct.put("isDisabledSellingPrice", false);
        bodySupplyProduct.put("isVisiblePriceBefore", false);
        bodySupplyProduct.put("isVisibleOldSellingPrice", false);
        bodySupplyProduct.put("__markupOrigin", 20);
        bodySupplyProduct.put("productDetail", productDetail);
        bodySupplyProduct.put("quantity", 1);
        bodySupplyProduct.put("arrivalCost", 100);
        bodySupplyProduct.put("priceBefore", 120);
        bodySupplyProduct.put("oldArrivalCost", 100);
        bodySupplyProduct.put("discount", 0);
        bodySupplyProduct.put("sellingPrice", 120);
        bodySupplyProduct.put("oldSellingPrice", 120);
        bodySupplyProduct.put("sellingPriceCopy", 120);
        bodySupplyProduct.put("rowId", 0);
        bodySupplyProduct.put("price", 100);
        bodySupplyProduct.put("amount", 100);
        bodySupplyProduct.put("oldAmount", 100);
        bodySupplyProduct.put("oldMarkup", 0);

        List<Object> supplyProducts = new ArrayList<>();
        supplyProducts.add(0, bodySupplyProduct);

        Map<String, Object> body = new HashMap<>();
        body.put("time", isoTimestampNow);
        body.put("amount", 100);
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
        body.put("supplierId", 180942);
        body.put("accountId", 11484);
        JsonPath jsonPath = postData(("/rest/cabinet/opr/supplies/create?storeId="+storeId), body).jsonPath();

    }
}
