package colonel.com.shumei.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import colonel.com.shumei.R;

public class SpinerButtonPopWindow extends PopupWindow {
    private LayoutInflater inflater;


    public SpinerButtonPopWindow(Context context, View.OnClickListener clickListener) {
        super(context);  
        inflater=LayoutInflater.from(context);
        init(clickListener);  
    }  
      
    private void init(View.OnClickListener clickListener){
        View view = inflater.inflate(R.layout.spiner_button_layout, null);
        setContentView(view);
        setFocusable(true);  
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);

        view.findViewById(R.id.plus_but).setOnClickListener(clickListener);

    }  
      

}  