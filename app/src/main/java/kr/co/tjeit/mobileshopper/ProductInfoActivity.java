package kr.co.tjeit.mobileshopper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import kr.co.tjeit.mobileshopper.data.ProductData;
import kr.co.tjeit.mobileshopper.util.GeneralData;

public class ProductInfoActivity extends BaseActivity {

    private android.widget.TextView productBtn;
    private android.widget.TextView priceBtn;
    private android.widget.EditText countEdt;
    private android.widget.Button buyBtn;
    private android.widget.Button cancleBtn;
    String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        bindViews();
        setUpEvents();
        setValues();

        test = (String)priceBtn.getText();
    }

    @Override
    public void bindViews() {
        this.cancleBtn = (Button) findViewById(R.id.cancleBtn);
        this.buyBtn = (Button) findViewById(R.id.buyBtn);
        this.countEdt = (EditText) findViewById(R.id.countEdt);
        this.priceBtn = (TextView) findViewById(R.id.priceBtn);
        this.productBtn = (TextView) findViewById(R.id.productBtn);
    }

    @Override
    public void setUpEvents() {
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 상품명, 가격, 수량을 ProductListViewActivity로 넘겨준다.
                Intent intent = new Intent(mContext, ProcductListViewActivity.class);

                String price = priceBtn.getText().toString();
                String count = countEdt.getText().toString();

                ProductData productData = new ProductData(productBtn.getText().toString(), Integer.parseInt(price), Integer.parseInt(count), R.drawable.logo_shop);
                GeneralData.grobalDatas.add(productData);

                finish();
            }
        });

        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BarcodeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void setValues() {

    }
}
