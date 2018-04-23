package colonel.com.shumei;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import colonel.com.shumei.utils.DiscolourTouchListener;
import colonel.com.shumei.utils.SpinerVerticalListPopWindow;

public class Self2AddActivity extends AppCompatActivity {
    private Toast toast;
    private SpinerVerticalListPopWindow<String> mSpinerPopWindow;
    private List<String> list;
    private TextView tvValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self2add);


        initData();
        Button add_car = (Button) findViewById(R.id.add_car);
        tvValue = (TextView) findViewById(R.id.tv_value);
        add_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Self2Activity.add = true;
                String msg = "添加成功";
                toast = Toast.makeText(Self2AddActivity.this,msg,Toast.LENGTH_SHORT);
                toast.show();
                back(v);
            }
        });

        mSpinerPopWindow = new SpinerVerticalListPopWindow<String>(this, list, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSpinerPopWindow.dismiss();
                tvValue.setText(list.get(position));
                Log.i("listview",list.get(position));
            }
        });
        mSpinerPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setTextImage(R.drawable.self_arrow_down);
            }
        });

        tvValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpinerPopWindow.setWidth(tvValue.getWidth());
                mSpinerPopWindow.showAsDropDown(tvValue);
                setTextImage(R.drawable.self_arrow_up);
            }
        });


        findViewById(R.id.back).setOnTouchListener(new DiscolourTouchListener(0xf4f4f4));

    }

    public void back(View v){
        finish();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_from_right);
    }

    private void initData() {
        list = new ArrayList<String>();
        list.add("大型货车");
        list.add("小型汽车");
        list.add("小型自动挡汽车");
    }

    private void setTextImage(int resId) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),drawable.getMinimumHeight());// 必须设置图片大小，否则不显示
        tvValue.setCompoundDrawables(null, null, drawable, null);
    }
}
