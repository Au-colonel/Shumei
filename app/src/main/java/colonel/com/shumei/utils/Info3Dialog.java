package colonel.com.shumei.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import colonel.com.shumei.R;


public class Info3Dialog extends Dialog {

    private ImageView no;//取消按钮

    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器



    public void setNoOnclickListener(onNoOnclickListener onNoOnclickListener) {
        this.noOnclickListener = onNoOnclickListener;
    }

    public Info3Dialog(Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info3_dialog_layout);

        setCanceledOnTouchOutside(true);

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

    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        no = (ImageView) findViewById(R.id.info3_close);
    }

    public interface onYesOnclickListener {
        public void onYesClick();
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }
}