package Environments;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.org.apache.xpath.internal.objects.XString;

public class CollectionEnvironments {
    private Long barcode;
    private Long incorrectRevisionDate;
    private Long incorrectMaxDayDiff;
    private String firstName;
    private Integer supplyPaymentScoreId;
    private Integer supplierId;
    private String supplierName;
    private Object dataOfProduct;
    private Object dataOfCategory;
    private Object dataOfSubCategory;
    private Long supplyProductId;
    private Double supplyArrivalCostProductPrise;
    private Double supplySellingPriceProductPrise;
    private Double supplyWholesalePriceProductPrice;

    public Long getSupplyProductId() {
        return supplyProductId;
    }

    public void setSupplyProductId(Long supplyProductId) {
        this.supplyProductId = supplyProductId;
    }

    public Double getSupplyArrivalCostProductPrise() {
        return supplyArrivalCostProductPrise;
    }

    public void setSupplyArrivalCostProductPrise(Double supplyArrivalCostProductPrise) {
        this.supplyArrivalCostProductPrise = supplyArrivalCostProductPrise;
    }

    public Double getSupplySellingPriceProductPrise() {
        return supplySellingPriceProductPrise;
    }

    public void setSupplySellingPriceProductPrise(Double supplySellingPriceProductPrise) {
        this.supplySellingPriceProductPrise = supplySellingPriceProductPrise;
    }

    public Double getSupplyWholesalePriceProductPrice() {
        return supplyWholesalePriceProductPrice;
    }

    public void setSupplyWholesalePriceProductPrice(Double supplyWholesalePriceProductPrice) {
        this.supplyWholesalePriceProductPrice = supplyWholesalePriceProductPrice;
    }

    public Object getDataOfSubCategory() {
        return dataOfSubCategory;
    }

    public void setDataOfSubCategory(Object dataOfSubCategory) {
        this.dataOfSubCategory = dataOfSubCategory;
    }

    public Object getDataOfCategory() {
        return dataOfCategory;
    }

    public void setDataOfCategory(Object dataOfCategory) {
        this.dataOfCategory = dataOfCategory;
    }

    public Object getDataOfProduct() {
        return dataOfProduct;
    }

    public void setDataOfProduct(Object dataOfProduct) {
        this.dataOfProduct = dataOfProduct;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getSupplyPaymentScoreId() {
        return supplyPaymentScoreId;
    }

    public void setSupplyPaymentScoreId(Integer supplyPaymentScoreId) {
        this.supplyPaymentScoreId = supplyPaymentScoreId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getIncorrectMaxDayDiff() {
        return incorrectMaxDayDiff;
    }

    public void setIncorrectMaxDayDiff(Long incorrectMaxDayDiff) {
        this.incorrectMaxDayDiff = incorrectMaxDayDiff;
    }

    public Long getIncorrectRevisionDate() {
        return incorrectRevisionDate;
    }

    public void setIncorrectRevisionDate(Long incorrectRevisionDate) {
        this.incorrectRevisionDate = incorrectRevisionDate;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public CollectionEnvironments() {
    }
}
