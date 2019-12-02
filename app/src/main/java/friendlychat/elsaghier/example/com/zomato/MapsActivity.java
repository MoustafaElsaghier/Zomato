package friendlychat.elsaghier.example.com.zomato;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import friendlychat.elsaghier.example.com.zomato.Model.Restaurant;

import static friendlychat.elsaghier.example.com.zomato.R.id.map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Restaurant restaurant;
    TextView res_name, res_rate, res_address;
    ImageView res_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        restaurant = (Restaurant) getIntent().getExtras().get("rest_item");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        init();
        setData();
        mapFragment.getMapAsync(this);
    }

    public void init() {
        res_img = (ImageView) findViewById(R.id.detail_img);
        res_address = (TextView) findViewById(R.id.detail_address);
        res_name = (TextView) findViewById(R.id.detail_rest_name);
        res_rate = (TextView) findViewById(R.id.detail_rating);
    }

    public void setData() {
        res_address.setText(restaurant.getAddress());
        res_rate.setText(restaurant.getRating());
        res_name.setText(restaurant.getName());
        if (restaurant.getImageUrl().isEmpty())
            res_img.setImageResource(R.mipmap.ic_launcher);
        else
            Glide.with(this).load(restaurant.getImageUrl()).into(res_img);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(restaurant.getLatitiude(), restaurant.getLongitude());
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18.0f));
        mMap.addMarker(new MarkerOptions()
                .title(restaurant.getName())
                .snippet("The most populous Restaurant.")
                .position(sydney));

    }
}
