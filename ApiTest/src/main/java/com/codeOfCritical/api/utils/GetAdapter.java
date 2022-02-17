package com.codeOfCritical.api.utils;

import com.codeOfCritical.response.GetResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by syed.sayem on 6/26/15.
 */

public class GetAdapter extends AbstractAdapter {
    private String name;

    protected GetAdapter(GetBuilder<?, ?> builder) {
        super(builder);
        this.name = builder.name;

    }

    public static GetBuilder<?, ?> builder() {
        return new DefaultGetBuilder();
    }

    public String getName() {
        return name;
    }

    //    @Override
    RestAdapter restAdapter = (GetResponse x) -> {
        Gson jsonParser = new Gson();
        final String endpoint = getEndPoint() + getMethod();
        String body = jsonParser.toJson(getObject());
        HttpURLConnection request = null;
        try {
            request = getRequest(endpoint);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String response = null;
        try {
            response = makeRawRequest(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Request \n" + prettyPrint(body) + "\n");
        System.out.println("Response \n" + prettyPrint(response) + "\n");
        return jsonParser.fromJson(response, x);
    };

    private HttpURLConnection getRequest(String command) throws IOException {
        URL obj = new URL(command);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod(MethodType.GET.getMethodType());
        con.setRequestProperty("Content-Type", ContentType.JSON.getContentType());
        return con;
    }


    public static abstract class GetBuilder<S extends GetAdapter, B extends GetBuilder<S, B>> extends AbstractBuilder<S, B> {
        private String name;

        @SuppressWarnings("unchecked")
        public B name(String name) {
            this.name = name;
            return (B) this;
        }

    }

    private static class DefaultGetBuilder extends GetBuilder<GetAdapter, DefaultGetBuilder> {
        @Override
        public GetAdapter build() {
            return new GetAdapter(this);
        }
    }
}
