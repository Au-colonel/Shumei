package colonel.com.shumei;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import colonel.com.shumei.utils.Info3Dialog;
import colonel.com.shumei.utils.DiscolourTouchListener;

public class Info3Activity extends AppCompatActivity {

    private Info3Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info3);

        findViewById(R.id.back).setOnTouchListener(new DiscolourTouchListener(0xf4f4f4));


    }

    public void back(View v){
        finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_from_right);
    }

    public void showLetter(View v){
        dialog = new Info3Dialog(Info3Activity.this);
        dialog.setNoOnclickListener(new Info3Dialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
