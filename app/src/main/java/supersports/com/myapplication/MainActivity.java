package supersports.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private BackTitleTextView mTri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mTri.setDrawText("张哈哈哈哈哈哈");
    }


    private void initView() {
        mTri = findViewById(R.id.tri);
    }
}
