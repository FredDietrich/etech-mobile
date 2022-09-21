package org.etech.etechmobile.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.etech.etechmobile.R;

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

    private Retrofit retrofit;

    private RetrofitFactory(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.login_prefs_key), Context.MODE_PRIVATE);
        String usuario = sharedPreferences.getString(context.getString(R.string.login_usuario_key), "");
        String senha = sharedPreferences.getString(context.getString(R.string.senha_usuario_key), "");
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(usuario, senha))
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5169/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    public static synchronized RetrofitFactory getInstance(Context context) {
        if(instance == null) {
            instance = new RetrofitFactory(context);
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
