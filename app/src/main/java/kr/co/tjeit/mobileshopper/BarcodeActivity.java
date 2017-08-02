package kr.co.tjeit.mobileshopper;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class BarcodeActivity extends BaseActivity {

    private android.widget.TextView barcodeidTxt;
    IntentResult result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        this.barcodeidTxt = (TextView) findViewById(R.id.barcodeidTxt);

        // 바코드 스캔하기
        new IntentIntegrator(this).initiateScan();
    }

    // 바코드 촬영 후 바코드 정보가 저장된 이후
    @Override
    protected void onRestart() {
        super.onRestart();
        // TODO - 바코드 번호와 일치하는 데이터를 서버에서 가져온다.
        // TODO - 이 정보를 ProductInfoActivity로 넘겨준다.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, ProductInfoActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }

    // 바코드 정보를 저장한다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // QR코드/바코드를 스캔한 결과 값을 가져옵니다.
        result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        barcodeidTxt.setText(result.getContents()+"");
        Toast.makeText(mContext, result.getContents(), Toast.LENGTH_SHORT).show();
    }

}
