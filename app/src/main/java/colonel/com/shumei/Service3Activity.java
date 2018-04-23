package colonel.com.shumei;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import colonel.com.shumei.utils.DiscolourTouchListener;
import colonel.com.shumei.utils.ServiceDialog;
import colonel.com.shumei.utils.SpinerHorizontalListPopWindow;
import colonel.com.shumei.utils.SpinerButtonPopWindow;

public class Service3Activity extends AppCompatActivity {

    private Toast toast;
    private TextView now;
    private TextView his;
    private TextView tv_value;
    private TextView tv_value1;
    private TextView tv_value2;
    private TextView tv_value5;
    private LinearLayout now_content;
    private LinearLayout now_content_p;
    private LinearLayout his_content;
    private RelativeLayout r2;
    private RelativeLayout item1;
    private Button comfirm;
    private SpinerHorizontalListPopWindow spw1;
    private SpinerButtonPopWindow spw2;

    private ServiceDialog serviceDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service3);



        now = (TextView) findViewById(R.id.now);
        his = (TextView) findViewById(R.id.his);
        tv_value1 = (TextView) findViewById(R.id.tv_value1);
        tv_value2 = (TextView) findViewById(R.id.tv_value2);
        tv_value5 = (TextView) findViewById(R.id.tv_value5);

        tv_value = tv_value1;
        now_content = (LinearLayout) findViewById(R.id.now_content);
        now_content_p = (LinearLayout) findViewById(R.id.now_content_p);
        his_content = (LinearLayout) findViewById(R.id.his_content);

        r2 = (RelativeLayout) findViewById(R.id.r2);
        comfirm = (Button) findViewById(R.id.confirm);
        item1 = (RelativeLayout) findViewById(R.id.item1);



        spw1 = new SpinerHorizontalListPopWindow(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spw1.dismiss();
                tv_value.setText(((TextView)v).getText());
            }
        });


        spw1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setTextImage(R.drawable.self_arrow_down,tv_value);
            }
        });

        spw2 = new SpinerButtonPopWindow(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spw2.dismiss();
            }
        });

        spw2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setTextImage(R.drawable.self_arrow_down,tv_value);
            }
        });


        DiscolourTouchListener tl = new DiscolourTouchListener(0xf4f4f4);
        findViewById(R.id.back).setOnTouchListener(tl);
        findViewById(R.id.add).setOnTouchListener(tl);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        item1.setOnTouchListener(new DiscolourTouchListener(getResources().getColor(R.color.whiteBg)));
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Service1","now clicked");
                now_content.setVisibility(View.VISIBLE);
                his_content.setVisibility(View.GONE);
                now_content_p.setVisibility(View.GONE);
                now.setTextColor(getResources().getColor(R.color.textSel));
                his.setTextColor(getResources().getColor(R.color.textNoSel));
            }
        });

        his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Service1","his clicked");
                his_content.setVisibility(View.VISIBLE);
                now_content.setVisibility(View.GONE);
                now_content_p.setVisibility(View.GONE);
                his.setTextColor(getResources().getColor(R.color.textSel));
                now.setTextColor(getResources().getColor(R.color.textNoSel));
            }
        });

        /*comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                his_content.setVisibility(View.GONE);
                now_content.setVisibility(View.GONE);
                now_content_p.setVisibility(View.VISIBLE);
                toast = Toast.makeText(Service2Activity.this,"救援中...",Toast.LENGTH_SHORT);
                toast.show();
            }
        });*/

        comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceDialog = new ServiceDialog(Service3Activity.this);
                serviceDialog.setTitle("已为您自动匹配距您最近的4s店,预计费用为");
                serviceDialog.setMessage("300.00元");
                serviceDialog.setYesOnclickListener("确认继续", new ServiceDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick() {
                        his_content.setVisibility(View.GONE);
                        now_content.setVisibility(View.GONE);
                        now_content_p.setVisibility(View.VISIBLE);
                        toast = Toast.makeText(Service3Activity.this,"维修受理中...",Toast.LENGTH_SHORT);
                        toast.show();
                        serviceDialog.dismiss();
                    }
                });
                serviceDialog.show();
            }
        });

        tv_value1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)spw1.getContentView().findViewById(R.id.tv1)).setText("京A XXXXX");
                ((TextView)spw1.getContentView().findViewById(R.id.tv2)).setText("京B XXXXX");

                tv_value = tv_value1;

                //先要设置宽高，否则不显示
                spw1.setWidth(tv_value1.getWidth());
                spw1.setHeight(tv_value1.getHeight()*5/3);
                spw1.showAsDropDown(tv_value1);
                setTextImage(R.drawable.self_arrow_up, (TextView) v);
            }
        });

        tv_value2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)spw1.getContentView().findViewById(R.id.tv1)).setText("小型轿车");
                ((TextView)spw1.getContentView().findViewById(R.id.tv2)).setText("中型轿车");

                tv_value = tv_value2;
                //先要设置宽高，否则不显示
                spw1.setWidth(tv_value2.getWidth());
                spw1.setHeight(tv_value2.getHeight()*5/3);
                spw1.showAsDropDown(tv_value2);
                setTextImage(R.drawable.self_arrow_up, (TextView) v);
            }
        });


        tv_value5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_value = tv_value5;
                //先要设置宽高，否则不显示
                spw2.setWidth(tv_value5.getWidth()*17/10);
                spw2.setHeight(tv_value5.getHeight()*5/3*3);
                spw2.showAsDropDown(r2,160,0);
                setTextImage(R.drawable.self_arrow_up, (TextView) v);
            }
        });
    }

    public void back(View v){
        finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_from_right);
    }

    private void setTextImage(int resId,TextView tv) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
        tv.setCompoundDrawables(null, null, drawable, null);
    }
}
