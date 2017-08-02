package kr.co.tjeit.mobileshopper;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.mobileshopper.adapters.ProductAdapter;
import kr.co.tjeit.mobileshopper.data.ProductData;

public class ProcductListViewActivity extends BaseActivity {



    private android.widget.ListView productListVIew;
    public static List<ProductData> productDataList = new ArrayList<>();
    ProductAdapter productAdapter;
    private android.widget.Button addItemTxt;
    ProductData productData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procduct_list_view);
        bindViews();
        setUpEvents();
        setValues();
        if(productData != null){

        }
        setProductList();
    }

    public void setProductList() {
        productDataList.clear();
        productDataList.add(new ProductData("칸초", 10000, 1, R.drawable.logo_shop));
//        productDataList.add(new ProductData("죠리퐁", 2000, 1, R.drawable.logo_shop));
//        productDataList.add(new ProductData("가위", 5000, 2, R.drawable.logo_shop));
//        productDataList.add(new ProductData("돌", 1, 4, R.drawable.logo_shop));
//        productDataList.add(new ProductData("꽃", 100, 5, R.drawable.logo_shop));
//        productDataList.add(new ProductData("나무", 100000, 6, R.drawable.logo_shop));
    }

    @Override
    public void bindViews() {
        this.addItemTxt = (Button) findViewById(R.id.addItemTxt);
        this.productListVIew = (ListView) findViewById(R.id.productListVIew);
    }

    @Override
    public void setUpEvents() {
        addItemTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BarcodeActivity.class);
                setResult(RESULT_OK, intent);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000){

            if(resultCode == RESULT_OK){
                ProductData productData = (ProductData) getIntent().getSerializableExtra("test");
                productDataList.add(productData);
                productAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void setValues() {
        productAdapter = new ProductAdapter(mContext, productDataList);
        productListVIew.setAdapter(productAdapter);
    }
}
