package colonel.com.shumei;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import colonel.com.shumei.utils.Info2Dialog;
import colonel.com.shumei.utils.DiscolourTouchListener;

public class Info2Activity extends AppCompatActivity {

    private TextView now;
    private TextView his;
    private ImageView info_1;
    private ImageView info_2;
    private ImageView info_3;
    private ImageView info_4;
    private Chronometer timer;
    private LinearLayout now_content;
    private LinearLayout his_content;
    private Info2Dialog infoDialog;

    private ImageView play1;
    private ProgressBar progress1;
    private boolean p1show = false;
    private Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            progress1.setProgress(0);
            while (progress1.getProgress() < progress1.getMax()){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                int progress = progress1.getProgress() + 2;
                progress1.setProgress(progress);
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    p1show = false;
                    play1.setImageResource(R.drawable.info2_3);
                    progress1.setProgress(0);
                    progress1.setVisibility(View.GONE);


                }
            });
        }

    });

    private ImageView play2;
    private ProgressBar progress2;
    private boolean p2show = false;
    private Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            progress2.setProgress(0);
            while (progress2.getProgress() < progress2.getMax()){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                int progress = progress2.getProgress() + 3;
                progress2.setProgress(progress);
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    p2show = false;
                    play2.setImageResource(R.drawable.info2_3);
                    progress2.setProgress(0);
                    progress2.setVisibility(View.GONE);
                }
            });
        }

    });

    private ImageView play3;
    private ProgressBar progress3;
    private boolean p3show = false;
    private Thread t3 = new Thread(new Runnable() {

        @Override
        public void run() {
            progress3.setProgress(0);
            while (progress3.getProgress() < progress3.getMax()){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                int progress = progress3.getProgress() + 2;
                progress3.setProgress(progress);
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    p3show = false;
                    play3.setImageResource(R.drawable.info2_3);
                    progress3.setProgress(0);
                    progress3.setVisibility(View.GONE);
                }
            });
        }

    });


    private boolean count = false;
    private long time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        findViewById(R.id.back).setOnTouchListener(new DiscolourTouchListener(0xf4f4f4));

        now = (TextView) findViewById(R.id.now);
        his = (TextView) findViewById(R.id.his);
        info_1 = (ImageView) findViewById(R.id.info2_1);
        info_2 = (ImageView) findViewById(R.id.info2_2);
        info_3 = (ImageView) findViewById(R.id.info2_3);
        info_4 = (ImageView) findViewById(R.id.info2_4);
        timer = (Chronometer) findViewById(R.id.info2_time);
        play1 = (ImageView) findViewById(R.id.info2_play1);
        progress1 = (ProgressBar) findViewById(R.id.info2_progress1);
        play2 = (ImageView) findViewById(R.id.info2_play2);
        progress2 = (ProgressBar) findViewById(R.id.info2_progress2);
        play3 = (ImageView) findViewById(R.id.info2_play3);
        progress3 = (ProgressBar) findViewById(R.id.info2_progress3);

        now_content = (LinearLayout) findViewById(R.id.now_content);
        his_content = (LinearLayout) findViewById(R.id.his_content);

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p1show == false){
                    play1.setImageResource(R.drawable.info2_3pre2);
                    p1show = true;
                    progress1.setVisibility(View.VISIBLE);
                    t1.start();
                }else{
                    t1.interrupt();
                }
            }
        });
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p2show == false){
                    play2.setImageResource(R.drawable.info2_3pre2);
                    p2show = true;
                    progress2.setVisibility(View.VISIBLE);
                    t2.start();
                }else{
                    t2.interrupt();
                }
            }
        });

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p3show == false){
                    play3.setImageResource(R.drawable.info2_3pre2);
                    p3show = true;
                    progress3.setVisibility(View.VISIBLE);
                    t3.start();
                }else{
                    t3.interrupt();
                }
            }
        });

        info_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == false){
                    count = true;
                    info_3.setImageResource(R.drawable.info2_3pre);
                    info_1.setImageResource(R.drawable.info2_1pre);
                    resetTimer();
                    timer.start();
                }else{
                    count = false;
                    info_3.setImageResource(R.drawable.info2_3);
                    info_1.setImageResource(R.drawable.info2_1);
                    timer.stop();
                    time = SystemClock.elapsedRealtime() - timer.getBase();
                }
            }
        });

        now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info2","now clicked");
                now.setTextColor(getResources().getColor(R.color.textSel));
                his.setTextColor(getResources().getColor(R.color.textNoSel));
                now_content.setVisibility(View.VISIBLE);
                his_content.setVisibility(View.GONE);
            }
        });

        his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info2","his clicked");
                now.setTextColor(getResources().getColor(R.color.textNoSel));
                his.setTextColor(getResources().getColor(R.color.textSel));
                now_content.setVisibility(View.GONE);
                his_content.setVisibility(View.VISIBLE);
            }
        });

        info_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        info_2.setImageResource(R.drawable.info2_2pre);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        info_2.setImageResource(R.drawable.info2_2);
                        now.setTextColor(getResources().getColor(R.color.textNoSel));
                        his.setTextColor(getResources().getColor(R.color.textSel));
                        now_content.setVisibility(View.GONE);
                        his_content.setVisibility(View.VISIBLE);
                        break;
                }
                return true;
            }
        });

        info_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        info_4.setImageResource(R.drawable.info2_4pre);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        info_4.setImageResource(R.drawable.info2_2);
                        count = true;
                        info_3.callOnClick();
                        infoDialog = new Info2Dialog(Info2Activity.this);
                        Date date= new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                        infoDialog.setDate("日期：" + sdf.format(date));
                        infoDialog.setYesOnclickListener(new Info2Dialog.onYesOnclickListener() {
                            @Override
                            public void onYesClick() {
                                time = 0;
                                timer.setText("00:00:00");
                                infoDialog.dismiss();
                            }
                        });
                        infoDialog.setNoOnclickListener(new Info2Dialog.onNoOnclickListener() {
                            @Override
                            public void onNoClick() {
                                infoDialog.dismiss();
                            }
                        });
                        infoDialog.show();
                        break;
                }
                return true;
            }
        });

    }

    public void back(View v){
        finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_from_right);
    }

    private void resetTimer(){
        timer.setBase(SystemClock.elapsedRealtime() - time);//计时器清零
        int hour = (int) ((SystemClock.elapsedRealtime() - timer.getBase()) / 1000 / 60);
        timer.setFormat("0"+String.valueOf(hour)+":%s");
    }

}
