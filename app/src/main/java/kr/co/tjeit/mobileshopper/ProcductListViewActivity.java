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
import kr.co.tjeit.mobileshopper.util.GeneralData;

public class ProcductListViewActivity extends BaseActivity {



    private android.widget.ListView productListVIew;
    ProductAdapter productAdapter;
    private android.widget.Button addItemTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procduct_list_view);
        bindViews();
        setUpEvents();
        setValues();
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
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        productAdapter.notifyDataSetChanged();
    }


    @Override
    public void setValues() {
        productAdapter = new ProductAdapter(mContext, GeneralData.grobalDatas);
        productListVIew.setAdapter(productAdapter);
    }
}
