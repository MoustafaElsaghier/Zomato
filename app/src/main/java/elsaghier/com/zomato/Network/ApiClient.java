package elsaghier.com.zomato.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ELSaghier on 1/25/2018.
 */

public class ApiClient {


    /*
    1- add dependances to gradle
    // RetroFit,Gson
     compile 'com.squareup.retrofit2:retrofit:2.3.0'
     compile 'com.squareup.retrofit2:converter-gson:2.3.0'
     compile 'com.google.code.gson:gson:2.8.0'
     2- create model
     3- create apiClient class
    *
    * */
//    private static final String BASE_URL = "https://developers.zomato.com/api/v2.1/search?lat=-33.92127&lon=18.4180213&count=10/";
    private static final String BASE_URL = "https://developers.zomato.com/api/v2.1/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
