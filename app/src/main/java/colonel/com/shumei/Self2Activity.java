package colonel.com.shumei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import colonel.com.shumei.utils.DiscolourTouchListener;

public class Self2Activity extends AppCompatActivity {

    static boolean add ;
    RelativeLayout added_item;
    TextView des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self2);

        add = false;

        added_item = (RelativeLayout) findViewById(R.id.added_item);
        des = (TextView) findViewById(R.id.des);


        findViewById(R.id.add_car).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Self2Activity.this,Self2AddActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });

        DiscolourTouchListener tl = new DiscolourTouchListener(0xf4f4f4);
        findViewById(R.id.back).setOnTouchListener(tl);
        added_item.setOnTouchListener(tl);
        added_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onRestart() {
        if( add == true ){
            des.setVisibility(View.GONE);
            added_item.setVisibility(View.VISIBLE);
        }
        super.onRestart();
    }

    public void back(View v){
        finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_from_right);
    }


}
