package colonel.com.shumei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import colonel.com.shumei.utils.DiscolourTouchListener;

public class Self5Activity extends AppCompatActivity {
    private ImageView self5_2;
    private ImageView self5_3;
    private ImageView self5_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self5);

        findViewById(R.id.back).setOnTouchListener(new DiscolourTouchListener(0xf4f4f4));

        self5_2 = (ImageView) findViewById(R.id.self5_2);
        self5_3 = (ImageView) findViewById(R.id.self5_3);
        self5_4 = (ImageView) findViewById(R.id.self5_4);

        DiscolourTouchListener tl = new DiscolourTouchListener(getResources().getColor(R.color.whiteBg));
        self5_2.setOnTouchListener(tl);
        self5_3.setOnTouchListener(tl);
        self5_4.setOnTouchListener(tl);

        self5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        self5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        self5_4.setOnClickListener(new View.OnClickListener() {
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
