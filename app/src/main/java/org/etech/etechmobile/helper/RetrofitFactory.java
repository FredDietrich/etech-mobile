package org.etech.etechmobile.helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static RetrofitFactory instance;

    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    private OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new BasicAuthInterceptor("admin", "admin"))
            .build();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5169/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build();

    private RetrofitFactory() {}

    public static synchronized RetrofitFactory getInstance() {
        if(instance == null) {
            instance = new RetrofitFactory();
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return this.retrofit;
    }

}

class BasicAuthInterceptor implements Interceptor {

    private String credentials;

    public BasicAuthInterceptor(String user, String password) {
        this.credentials = Credentials.basic(user, password);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials).build();
        return chain.proceed(authenticatedRequest);
    }

}
