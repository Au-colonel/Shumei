package colonel.com.shumei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


import colonel.com.shumei.utils.DiscolourTouchListener;

public class Info1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);

        DiscolourTouchListener tl = new DiscolourTouchListener(0xffffff);

        findViewById(R.id.back).setOnTouchListener(new DiscolourTouchListener(0xf4f4f4));
        findViewById(R.id.item1).setOnTouchListener(tl);
        findViewById(R.id.item2).setOnTouchListener(tl);
        findViewById(R.id.item3).setOnTouchListener(tl);

        findViewById(R.id.item1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Info1","Item1");
                Intent i = new Intent(Info1Activity.this, Info1MoreActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });
        findViewById(R.id.item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Info1","Item2");
                Intent i = new Intent(Info1Activity.this, Info1MoreActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });
        findViewById(R.id.item3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Info1","Item3");
                Intent i = new Intent(Info1Activity.this, Info1MoreActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });
    }

    public void back(View v){
        finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_from_right);
    }
}
