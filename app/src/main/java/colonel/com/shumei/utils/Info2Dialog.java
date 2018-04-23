package colonel.com.shumei.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import colonel.com.shumei.R;


public class Info2Dialog extends Dialog {

    private LinearLayout yes;//确定按钮
    private LinearLayout no;//取消按钮

    private TextView tv_date;
    private String date = "日期：2018年3月31日";//从外界设置的日期



    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器



    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener(onYesOnclickListener onYesOnclickListener) {
        this.yesOnclickListener = onYesOnclickListener;
    }

    public void setNoOnclickListener(onNoOnclickListener onNoOnclickListener) {
        this.noOnclickListener = onNoOnclickListener;
    }

    public Info2Dialog(Context context) {
        super(context, R.style.MyDialog1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info2_dialog_layout);

        setCanceledOnTouchOutside(false);

        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();

    }

    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {

        DiscolourTouchListener tl = new DiscolourTouchListener(0xf4f4f4);
        yes.setOnTouchListener(tl);
        no.setOnTouchListener(tl);
        //设置确定按钮被点击后，向外界提供监听
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListener != null) {
                    noOnclickListener.onNoClick();
                }
            }
        });

    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果设置按钮的文字
        if (date != null) {
            tv_date.setText(date);
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        yes = (LinearLayout) findViewById(R.id.yes);
        no = (LinearLayout) findViewById(R.id.no);


        tv_date = (TextView) findViewById(R.id.date);
    }

    /**
     * 从外界Activity为Dialog设置日期
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }


    public interface onYesOnclickListener {
        public void onYesClick();
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }
}