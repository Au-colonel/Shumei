package colonel.com.shumei.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SlidingDrawer;


import colonel.com.shumei.R;
import colonel.com.shumei.utils.HomeDialog;

/**
 * Created by Administrator on 2018/4/9.
 */
public class HomeFragment extends Fragment {

    private static  HomeFragment fragment;
    public static HomeFragment newInstance(String fragName) {
        if(fragment == null){
            fragment = new HomeFragment();
            /*Bundle args = new Bundle();
            args.putString("fragName", fragName);
            fragment.setArguments(args);*/
        }
        return fragment;
    }

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        /*Bundle bundle = getArguments();
        String fragName = bundle.getString("fragName");*/
        final HomeDialog dialog = new HomeDialog(getActivity());

        ImageView warn = (ImageView) view.findViewById(R.id.home_warn);
        SlidingDrawer s = (SlidingDrawer) view.findViewById(R.id.home_slide);
        final RelativeLayout middle = (RelativeLayout) view.findViewById(R.id.home_middle);
        final ImageView handle = (ImageView) view.findViewById(R.id.shandle);
        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.home_scroll);
        final ProgressBar bar = (ProgressBar) view.findViewById(R.id.home_bar);


        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int weights = scrollView.getChildAt(0).getHeight() - scrollView.getMeasuredHeight();
                bar.setProgress(scrollView.getScrollY()*100/weights);
            }
        });
        s.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                middle.setVisibility(View.GONE);
                handle.setImageResource(R.drawable.home_arrow_down);
                handle.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        });
        s.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                middle.setVisibility(View.VISIBLE);
                handle.setImageResource(R.drawable.home_arrow_up);
                handle.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        });
        warn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setNoOnclickListener(new HomeDialog.onNoOnclickListener() {
                    @Override
                    public void onNoClick() {
                        dialog.dismiss();
                    }
                });
                dialog.setYesOnclickListener(new HomeDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick() {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        return view;
    }
}
