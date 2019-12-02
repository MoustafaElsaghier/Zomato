package elsaghier.com.zomato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import elsaghier.com.zomato.Model.CategoryModel;

public class HomeActivity extends AppCompatActivity {

    ArrayList<CategoryModel> categoryModels;
    CategoryModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fillCategoryList();
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
        model.setCategoryId("4");
        model.setCategoryName("Catching");
        model.setImageRes(R.drawable.ic_catch_up);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("5");
        model.setCategoryName("Takeaway");
        model.setImageRes(R.drawable.ic_takeaway);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("6");
        model.setCategoryName("Cafes");
        model.setImageRes(R.drawable.ic_cafe);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("7");
        model.setCategoryName("Daily Menus");
        model.setImageRes(R.drawable.ic_menu);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("11");
        model.setCategoryName("Pubs & Bars");
        model.setImageRes(R.drawable.ic_bars);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("8");
        model.setCategoryName("Breakfast");
        model.setImageRes(R.drawable.ic_breakfast);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("9");
        model.setCategoryName("Lunch");
        model.setImageRes(R.drawable.ic_launch);
        categoryModels.add(model);

        model = new CategoryModel();
        model.setCategoryId("10");
        model.setCategoryName("Dinner");
        model.setImageRes(R.drawable.ic_dinner);
        categoryModels.add(model);

    }
}
