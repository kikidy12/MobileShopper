package kr.co.tjeit.mobileshopper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShopInfoActivity extends BaseActivity {

    private android.widget.Button pointBtn;
    private android.widget.Button buyRecordBtn;
    private android.widget.Button produceAddBtn;
    private android.widget.ImageView addItmeImg;
    private android.widget.ImageView cartImg;
    private android.widget.ImageView searchItemImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);
        bindViews();
        setUpEvents();
        setValues();
    }

    @Override
    public void bindViews() {
        this.produceAddBtn = (Button) findViewById(R.id.produceAddBtn);
        this.buyRecordBtn = (Button) findViewById(R.id.buyRecordBtn);
        this.pointBtn = (Button) findViewById(R.id.pointBtn);
        this.searchItemImg = (ImageView) findViewById(R.id.searchItemImg);
        this.cartImg = (ImageView) findViewById(R.id.cartImg);
        this.addItmeImg = (ImageView) findViewById(R.id.addItmeImg);
    }

    @Override
    public void setUpEvents() {
        produceAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProcductListViewActivity.class);
                startActivity(intent);
                finish();
            }
        });

        addItmeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BarcodeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setValues() {

    }
}
