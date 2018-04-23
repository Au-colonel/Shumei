package colonel.com.shumei.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import colonel.com.shumei.Info1Activity;
import colonel.com.shumei.Info2Activity;
import colonel.com.shumei.Info3Activity;
import colonel.com.shumei.R;
import colonel.com.shumei.utils.DiscolourTouchListener;

/**
 * Created by Administrator on 2018/4/9.
 */
public class InfoFragment extends Fragment {

    private static  InfoFragment fragment;
    public static InfoFragment newInstance(String fragName) {
        if(fragment == null){
            fragment = new InfoFragment();
            /*Bundle args = new Bundle();
            args.putString("fragName", fragName);
            fragment.setArguments(args);*/
        }
        return fragment;
    }

    public InfoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_fragment, container, false);
        /*Bundle bundle = getArguments();
        String fragName = bundle.getString("fragName");*/

        DiscolourTouchListener tl1 = new DiscolourTouchListener(getResources().getColor(R.color.whiteBg),getResources().getColor(R.color.ButBgPre));
        DiscolourTouchListener tl2 = new DiscolourTouchListener(getResources().getColor(R.color.ButBg),getResources().getColor(R.color.ButBgPre));

        RelativeLayout item1 = (RelativeLayout) view.findViewById(R.id.item1);
        RelativeLayout item2 = (RelativeLayout) view.findViewById(R.id.item2);
        RelativeLayout item3 = (RelativeLayout) view.findViewById(R.id.item3);

        item1.setOnTouchListener(tl1);
        item2.setOnTouchListener(tl2);
        item3.setOnTouchListener(tl1);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("InfoFram","Item1");
                Intent i = new Intent(getActivity(), Info1Activity.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("InfoFram","Item2");
                Intent i = new Intent(getActivity(), Info2Activity.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("InfoFram","Item3");
                Intent i = new Intent(getActivity(), Info3Activity.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });

        return view;
    }
}
