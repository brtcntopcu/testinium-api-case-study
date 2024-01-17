package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public static String API_KEY = ;
    public static String TOKEN = ;

    RequestSpecification requestSpecification;
    public RequestSpec(String baseUrl){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .addQueryParam("key",API_KEY)
                .addQueryParam("token",TOKEN)
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

}
