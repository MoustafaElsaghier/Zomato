package elsaghier.com.zomato.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import elsaghier.com.zomato.Adapter.CategoryAdapter;
import elsaghier.com.zomato.Model.CategoryModel;
import elsaghier.com.zomato.R;

public class HomeActivity extends AppCompatActivity {

    ArrayList<CategoryModel> categoryModels;
    @BindView(R.id.category_recycler)
    RecyclerView categoryRecycler;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        fillCategoryList();
        initRecyclerView();
    }

    private void initRecyclerView() {
        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void fillCategoryList() {
        categoryModels = new ArrayList<>();
        CategoryModel model;

        model = new CategoryModel();
        model.setCategoryId("1");
        model.setCategoryName("Delivery");
        model.setImageRes(R.drawable.ic_delivery);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("3");
        model.setCategoryName("Night Life");
        model.setImageRes(R.drawable.ic_night_life);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("2");
        model.setCategoryName("Catching");
        model.setImageRes(R.drawable.ic_night_life);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("5");
        model.setCategoryName("Takeaway");
        model.setImageRes(R.drawable.ic_night_life);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("6");
        model.setCategoryName("Cafes");
        model.setImageRes(R.drawable.ic_cafe);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("17");
        model.setCategoryName("Daily Menus");
        model.setImageRes(R.drawable.ic_night_life);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("11");
        model.setCategoryName("Pubs & Bars");
        model.setImageRes(R.drawable.ic_cafe);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("8");
        model.setCategoryName("Breakfast");
        model.setImageRes(R.drawable.ic_cafe);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("9");
        model.setCategoryName("Lunch");
        model.setImageRes(R.drawable.ic_night_life);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("10");
        model.setCategoryName("Dinner");
        model.setImageRes(R.drawable.ic_cafe);
        categoryModels.add(model);

        categoryAdapter = new CategoryAdapter(this, categoryModels);
    }
}
