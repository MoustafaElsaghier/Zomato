package elsaghier.com.zomato.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

        String categoryId = getIntent().getStringExtra("category_id");

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<RestaurantModel>> call = apiService.getAllRestaurantsInCategory(categoryId);

        call.enqueue(new Callback<ArrayList<RestaurantModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<RestaurantModel>> call,
                                   @NonNull Response<ArrayList<RestaurantModel>> response) {

                mData = response.body();
                adapter = new RestaurantAdapter(mData, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<RestaurantModel>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                Log.e("Error of call ", t.getMessage());
            }
        });

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
