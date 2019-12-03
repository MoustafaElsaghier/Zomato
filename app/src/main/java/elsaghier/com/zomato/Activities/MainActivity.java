package elsaghier.com.zomato.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import elsaghier.com.zomato.Adapter.RestaurantAdapter;
import elsaghier.com.zomato.Model.CategoryModel;
import elsaghier.com.zomato.Model.RestaurantModel;
import elsaghier.com.zomato.Network.ApiClient;
import elsaghier.com.zomato.Network.ApiInterface;
import elsaghier.com.zomato.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<RestaurantModel> mData;
    RestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        mData = new ArrayList<>();
        recyclerView = findViewById(R.id.restaurant_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        String categoryId = getIntent().getStringExtra("category_id");

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<List<CategoryModel>> call = apiService.getAllRestaurantsInCategory(categoryId);

        call.enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<CategoryModel>> call,
                                   @NonNull Response<List<CategoryModel>> response) {

            }

            @Override
            public void onFailure(@NonNull Call<List<CategoryModel>> call, @NonNull Throwable t) {

            }
        });
//        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://developers.zomato.com/api/v2.1/search?lat=-33.92127&lon=18.4180213&count=10";
//        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray arr = response.getJSONArray("restaurants");
//
//                            for (int i = 0; i < arr.length(); ++i) {
//
////                                JSONObject obj = arr.getJSONObject(i).getJSONObject("restaurant");
////                                mData.add(new RestaurantModel(obj.getString("name")
////                                        , obj.getJSONObject("location").getString("address")
////                                        , obj.getJSONObject("user_rating").getString("aggregate_rating")
////                                        , obj.getString("average_cost_for_two")
////                                        , obj.getString("thumb")
////                                        , obj.getString("currency")
////                                        , obj.getJSONObject("location").getDouble("longitude")
////                                        , obj.getJSONObject("location").getDouble("latitude")
////                                        , obj.getJSONObject("R").getString("res_id")));
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                        adapter = new RestaurantAdapter(mData, MainActivity.this);
//                        recyclerView.setAdapter(adapter);
//                        Log.d("Response", response.toString());
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                        Log.d("ERROR", "error => " + error.toString());
//                    }
//                }
//        ) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("user-key", "55a1d18014dd0c0dac534c02598a3368");
//                params.put("Accept", "application/json");
//
//                return params;
//            }
//        };
//        queue.add(postRequest);
        adapter = new RestaurantAdapter(mData, this);
        recyclerView.setAdapter(adapter);
    }


    private void init() {
        mData = new ArrayList<>();
        recyclerView = findViewById(R.id.restaurant_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new RestaurantAdapter(mData, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
