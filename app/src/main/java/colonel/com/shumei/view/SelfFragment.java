package colonel.com.shumei.view;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.RelativeLayout;

import colonel.com.shumei.MainActivity;
import colonel.com.shumei.R;
import colonel.com.shumei.Self1Activity;
import colonel.com.shumei.Self2Activity;
import colonel.com.shumei.Self3Activity;
import colonel.com.shumei.Self4Activity;
import colonel.com.shumei.Self5Activity;
import colonel.com.shumei.utils.DiscolourTouchListener;

/**
 * Created by Administrator on 2018/4/9.
 */
public class SelfFragment extends Fragment{
    private  String TAG = "SelfFragment";
    private static  SelfFragment fragment;
    public static SelfFragment newInstance(String fragName) {
        if(fragment == null){
            fragment = new SelfFragment();
            /*Bundle args = new Bundle();
            args.putString("fragName", fragName);
            fragment.setArguments(args);*/
        }
        return fragment;
    }

    public SelfFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.self_fragment, container, false);

        DiscolourTouchListener tl = new DiscolourTouchListener(Color.parseColor("#ffffff") );

        RelativeLayout self_1 = (RelativeLayout) view.findViewById(R.id.self_1);
        RelativeLayout self_2 = (RelativeLayout) view.findViewById(R.id.self_2);
        RelativeLayout self_3 = (RelativeLayout) view.findViewById(R.id.self_3);
        RelativeLayout self_4 = (RelativeLayout) view.findViewById(R.id.self_4);
        RelativeLayout self_5 = (RelativeLayout) view.findViewById(R.id.self_5);
        Button self_6 = (Button) view.findViewById(R.id.self_6);

        self_1.setOnTouchListener(tl);
        self_2.setOnTouchListener(tl);
        self_3.setOnTouchListener(tl);
        self_4.setOnTouchListener(tl);
        self_5.setOnTouchListener(tl);

        self_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"我的资料");
                Intent intent = new Intent(getActivity(),Self1Activity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });

        self_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"我的车辆");
                Intent intent = new Intent(getActivity(),Self2Activity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });

        self_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"违章查询");
                Intent intent = new Intent(getActivity(),Self3Activity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });

        self_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"帮助");
                Intent intent = new Intent(getActivity(),Self4Activity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });

        self_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"分享");
                Intent intent = new Intent(getActivity(),Self5Activity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_from_left);
            }
        });

        self_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        return view;
    }


}
