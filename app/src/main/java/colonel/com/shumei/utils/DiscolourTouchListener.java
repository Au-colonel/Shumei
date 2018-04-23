package colonel.com.shumei.utils;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2018/4/11.
 */
public class DiscolourTouchListener implements View.OnTouchListener{

    private int colorBefore;
    private int colorAfter = 0x99000000;

    public DiscolourTouchListener(int bgColor){
        this.colorBefore = bgColor;
    }
    public DiscolourTouchListener(int bgColor, int colorAfter){
        this.colorBefore = bgColor;
        this.colorAfter = colorAfter;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                v.setBackgroundColor(colorAfter);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                v.setBackgroundColor(colorBefore);
                break;
        }
        return false;
    }
}
