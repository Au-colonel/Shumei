package colonel.com.shumei.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import colonel.com.shumei.R;

public class SpinerHorizontalListPopWindow extends PopupWindow {
    private LayoutInflater inflater;
    private TextView tv1;
    private TextView tv2;

    public SpinerHorizontalListPopWindow(Context context, View.OnClickListener clickListener) {
        super(context);  
        inflater=LayoutInflater.from(context);
        init(clickListener);  
    }  
      
    private void init(View.OnClickListener clickListener){
        View view = inflater.inflate(R.layout.spiner_horizontal_list_layout, null);
        setContentView(view);
        setFocusable(true);  
        ColorDrawable dw = new ColorDrawable(0x00);
        setBackgroundDrawable(dw);

        tv1 = (TextView) view.findViewById(R.id.tv1);
        tv2 = (TextView) view.findViewById(R.id.tv2);
        tv1.setOnClickListener(clickListener);
        tv2.setOnClickListener(clickListener);

    }  
      

}  