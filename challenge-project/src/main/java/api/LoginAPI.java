package api;

import config.ConfigLoader;
import constants.ApiEndpoints;
import constants.GlobalVariables;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import utils.RequestSpec;

import java.util.HashMap;

public class LoginAPI extends BaseAPI {
    public LoginAPI() {
        super();
    }

    private static Cookies cookie;

    public static void setCookie(Cookies newCookie) {
        cookie = newCookie;
    }

    public static Cookies getCookie() {
        return cookie;
    }


    public void login(String userName, String password) {
        setReqSpec(RequestSpec.headerLogin());
        Response response = postForm(ApiEndpoints.LOGIN, setParameter(userName, password));
        setCookie(response.getDetailedCookies());
        Serenity.setSessionVariable(GlobalVariables.TOKEN).to("Bearer " + getJsonValue(response, "BearerToken"));
        Serenity.setSessionVariable(GlobalVariables.BRANCH_ID).to(Integer.valueOf(getJsonValue(response, "BranchId")));
    }

    public void login() {
        login(ConfigLoader.getUserName(), ConfigLoader.getPassword());
    }

    private HashMap<String, String> setParameter(String userName, String password) {
        HashMap<String, String> paramLogin = new HashMap<>();
        paramLogin.put("format", "json");
        paramLogin.put("provider", "credentials");
        paramLogin.put("UserName", userName);
        paramLogin.put("Password", password);
        paramLogin.put("UseTokenCookie", "json");
        paramLogin.put("FingerPrintKey", "json");
        paramLogin.put("IsManageLogin", "false");
        paramLogin.put("Language", "vi-VN");
        return paramLogin;
    }
}
