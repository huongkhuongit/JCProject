package utils;

import constants.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;

import static api.LoginAPI.getCookie;

public class RequestSpec {
    /**
     * Set RequestSpecification to reduce duplicate when setting headers
     */
    private RequestSpec() {
    }

    private static final String AUTHORIZATION = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ACCEPT = "application/json";
    private static final String RETAILER = "Retailer";
    private static final String BRANCH_ID = "branchId";

    private static void setRestAssured() {
        RestAssured.requestSpecification = null;
    }

    public static RequestSpecification headerFormData() {
        String retailer = Serenity.sessionVariableCalled(GlobalVariables.RETAILER);
        setRestAssured();
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader(CONTENT_TYPE, "multipart/form-data");
        builder.addHeader(AUTHORIZATION, Serenity.sessionVariableCalled(GlobalVariables.TOKEN));
        builder.setAccept(ACCEPT);
        builder.addHeader(RETAILER, retailer);
        builder.addHeader(BRANCH_ID, Serenity.sessionVariableCalled(GlobalVariables.BRANCH_ID).toString());
        builder.addCookies(getCookie());
        return builder.build();
    }

    public static RequestSpecification baseHeader() {
        String retailer = Serenity.sessionVariableCalled(GlobalVariables.RETAILER);
        setRestAssured();
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader(CONTENT_TYPE, "application/json; charset=utf-8");
        builder.addHeader(AUTHORIZATION, Serenity.sessionVariableCalled(GlobalVariables.TOKEN));
        builder.setAccept(ACCEPT);
        builder.addHeader(RETAILER, retailer);
        builder.addHeader(BRANCH_ID, Serenity.sessionVariableCalled(GlobalVariables.BRANCH_ID).toString());
        builder.addCookies(getCookie());
        return builder.build();
    }

    public static RequestSpecification headerLogin() {
        String retailer = Serenity.sessionVariableCalled(GlobalVariables.RETAILER);
        String host = Serenity.sessionVariableCalled(GlobalVariables.HOST);
        String pathOrigin;
        String pathRefer = String.format("https://%s/login", host);
        pathOrigin = String.format("https://%s", host);

        setRestAssured();
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("redirect", "%2f");
        builder.addHeader(RETAILER, retailer);
        builder.addHeader("Referer", pathRefer);
        builder.addHeader("Sec-Fetch-Mode", "cors");
        builder.addHeader("Sec-Fetch-Site", "pathRefer");
        builder.addHeader("Accept-Language", "en-US,en;q=0.5");
        builder.addHeader("Origin", pathOrigin);
        builder.addHeader("Accept", "*/*");
        builder.addHeader("X-Requested-With", "XMLHttpRequest");
        builder.addHeader(CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
        builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:92.0) Gecko/20100101 Firefox/92.0");
        builder.addHeader("Sec-Fetch-Dest", "empty");
        return builder.build();
    }
}
