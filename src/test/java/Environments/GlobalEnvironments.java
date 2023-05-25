package Environments;

import java.util.Base64;

public class GlobalEnvironments {
    private String host;
    private String apiVer;
    private String authorization;
    private String clientVer;
    private String user_login_pass;
    private String basic_auth;
    private String firstName;
    private Integer storeId;
    private Integer userId;
    private Integer storeGroupId;

    public Integer getStoreGroupId() {
        return storeGroupId;
    }

    public void setStoreGroupId(Integer storeGroupId) {
        this.storeGroupId = storeGroupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public GlobalEnvironments() {
    }

    public String getApiVer() {
        return apiVer;
    }

    public void setApiVer(String apiVer) {
        this.apiVer = apiVer;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getClientVer() {
        return clientVer;
    }

    public void setClientVer(String clientVer) {
        this.clientVer = clientVer;
    }

    public String getUser_login_pass() {
        return user_login_pass;
    }

    public void setUser_login_pass(String user_login_pass) {
        this.user_login_pass = user_login_pass;
    }

    public String getBasic_auth() {
        return basic_auth;
    }

    public void setBasic_auth(String globalEnvironments) {
        Base64.Encoder encoder = Base64.getEncoder();
        this.basic_auth = "Basic " + encoder.encodeToString((globalEnvironments.getBytes()));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
