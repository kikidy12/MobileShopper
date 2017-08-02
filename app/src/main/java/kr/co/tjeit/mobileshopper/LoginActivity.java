package kr.co.tjeit.mobileshopper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends BaseActivity {

    private android.widget.Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setUpEvents();
        setValues();
    }

    @Override
    public void bindViews() {
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
    }

    @Override
    public void setUpEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO - 서버로 아이디 비번을 보내고 일치하는 것이 있을 시 로그인을 허가한다.
                Intent intent = new Intent(mContext, ShopInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void setValues() {
        super.setValues();
    }
}
