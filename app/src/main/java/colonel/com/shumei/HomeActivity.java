package colonel.com.shumei;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import colonel.com.shumei.view.HomeFragment;
import colonel.com.shumei.view.InfoFragment;
import colonel.com.shumei.view.SelfFragment;
import colonel.com.shumei.view.ServiceFragment;

public class HomeActivity extends AppCompatActivity {
    private HomeFragment mHomeFragment;
    private InfoFragment mInfoFragment;
    private ServiceFragment mServiceFragment;
    private SelfFragment mSelfFragment;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        new Thread(new Runnable() {
            @Override
            public void run() {
                mHomeFragment = HomeFragment.newInstance("首页");
                mInfoFragment = mInfoFragment.newInstance("信息");
                mServiceFragment = mServiceFragment.newInstance("服务");
                mSelfFragment = mSelfFragment.newInstance("我的");
            }
        }).start();

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor("#AEC1D6")
                .setInActiveColor("#cccccc")
                .setBarBackgroundColor("#f4f4f4")
                .addItem(new BottomNavigationItem(R.drawable.home, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.info, "信息"))
                .addItem(new BottomNavigationItem(R.drawable.service, "服务"))
                .addItem(new BottomNavigationItem(R.drawable.self, "我的"))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                if (fm == null) fm = getFragmentManager();
                final FragmentTransaction transaction = fm.beginTransaction();
                switch (position) {
                    case 0:
                        if (mHomeFragment == null) {
                            mHomeFragment = HomeFragment.newInstance("首页");
                        }
                        transaction.replace(R.id.content, mHomeFragment);
                        break;
                    case 1:
                        if (mInfoFragment == null) {
                            mInfoFragment = mInfoFragment.newInstance("信息");
                        }
                        transaction.replace(R.id.content, mInfoFragment);
                        break;
                    case 2:
                        if (mServiceFragment == null) {
                            mServiceFragment = mServiceFragment.newInstance("服务");
                        }
                        transaction.replace(R.id.content, mServiceFragment);
                        break;
                    case 3:
                        if (mSelfFragment == null) {
                            mSelfFragment = mSelfFragment.newInstance("我的");
                        }
                        transaction.replace(R.id.content, mSelfFragment);
                        break;
                    default:
                        break;
                }

                transaction.commit();// 事务提交

            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        if (fm == null) fm = getFragmentManager();
        final FragmentTransaction transaction = fm.beginTransaction();


        mHomeFragment = HomeFragment.newInstance("首页");
        transaction.replace(R.id.content, mHomeFragment);


        transaction.commit();// 事务提交

    }
}
