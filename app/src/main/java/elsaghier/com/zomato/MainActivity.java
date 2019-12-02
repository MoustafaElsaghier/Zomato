package elsaghier.com.zomato;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import elsaghier.com.zomato.Adapter.RestaurantAdapter;
import elsaghier.com.zomato.Model.Restaurant;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Restaurant> mData;
    RestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        mData = new ArrayList<>();
        mData = new ArrayList<>();
        recyclerView = findViewById(R.id.restaurant_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://developers.zomato.com/api/v2.1/search?lat=-33.92127&lon=18.4180213&count=10";
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray arr = response.getJSONArray("restaurants");

                            for (int i = 0; i < arr.length(); ++i) {

                                JSONObject obj = arr.getJSONObject(i).getJSONObject("restaurant");
                                mData.add(new Restaurant(obj.getString("name")
                                        , obj.getJSONObject("location").getString("address")
                                        , obj.getJSONObject("user_rating").getString("aggregate_rating")
                                        , obj.getString("average_cost_for_two")
                                        , obj.getString("thumb")
                                        , obj.getString("currency")
                                        , obj.getJSONObject("location").getDouble("longitude")
                                        , obj.getJSONObject("location").getDouble("latitude")
                                        , obj.getJSONObject("R").getString("res_id")));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter = new RestaurantAdapter(mData, MainActivity.this);
                        recyclerView.setAdapter(adapter);
                        Log.d("Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        Log.d("ERROR", "error => " + error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user-key", "55a1d18014dd0c0dac534c02598a3368");
                params.put("Accept", "application/json");

                return params;
            }
        };
        queue.add(postRequest);
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
