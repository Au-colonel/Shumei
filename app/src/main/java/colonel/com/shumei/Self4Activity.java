package colonel.com.shumei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import colonel.com.shumei.utils.DiscolourTouchListener;

public class Self4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self4);

        DiscolourTouchListener tl = new DiscolourTouchListener(0xffffff);

        findViewById(R.id.back).setOnTouchListener(new DiscolourTouchListener(0xf4f4f4));

        findViewById(R.id.item1).setOnTouchListener(tl);
        findViewById(R.id.item2).setOnTouchListener(tl);
        findViewById(R.id.item3).setOnTouchListener(tl);
        findViewById(R.id.self_searcher).setOnTouchListener(tl);

        findViewById(R.id.item1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.item2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.item3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.self_searcher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void back(View v){
        finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_from_right);
    }
}
