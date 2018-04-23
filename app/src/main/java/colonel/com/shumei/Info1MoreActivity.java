package colonel.com.shumei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import colonel.com.shumei.utils.DiscolourTouchListener;

public class Info1MoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1_more);

        findViewById(R.id.back).setOnTouchListener(new DiscolourTouchListener(0xf4f4f4));

    }

    public void back(View v){
        finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_from_right);
    }
}
