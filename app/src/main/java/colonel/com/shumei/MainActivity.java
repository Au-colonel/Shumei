package colonel.com.shumei;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toast toast;
    private LinearLayout main_content;
    private LinearLayout pwdLogin;
    private LinearLayout register;
    private LinearLayout verLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView loginBut = (TextView) findViewById(R.id.login);
        final TextView registerBut = (TextView) findViewById(R.id.register);

        main_content = (LinearLayout) findViewById(R.id.main_content);
        pwdLogin = (LinearLayout) main_content.findViewById(R.id.pwd_login);
        register = (LinearLayout) main_content.findViewById(R.id.register);
        verLogin = (LinearLayout) main_content.findViewById(R.id.ver_login);

        final CheckBox agree = (CheckBox) register.findViewById(R.id.agree);
        final Button submitRegister = (Button) register.findViewById(R.id.submit_register);


        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(agree.isChecked()){
                    submitRegister.setEnabled(true);
                }else{
                    submitRegister.setEnabled(false);
                }
            }
        });

        agree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        submitRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast = Toast.makeText(MainActivity.this,"注册成功，自动登录",Toast.LENGTH_SHORT);
                toast.show();
                login(submitRegister);
            }
        });

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentHide();
                verLogin.setVisibility(View.VISIBLE);
                loginBut.setTextColor(Color.parseColor("#AEC1D6"));
                registerBut.setTextColor(Color.parseColor("#cccccc"));
            }
        });

        registerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentHide();
                register.setVisibility(View.VISIBLE);
                loginBut.setTextColor(Color.parseColor("#cccccc"));
                registerBut.setTextColor(Color.parseColor("#AEC1D6"));
            }
        });
    }

    public void sendCode(View v){
        String msg = "验证码已发送";
        if(toast == null){
            toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        }else{
            toast.cancel();
            toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    public void pwdLogin(View v){
        contentHide();
        pwdLogin.setVisibility(View.VISIBLE);
    }

    public void verLogin(View v){
        contentHide();
        verLogin.setVisibility(View.VISIBLE);
    }

    public void login(View v){
        Intent i = new Intent(this,HomeActivity.class);
        startActivity(i);
        finish();
    }

    private void contentHide(){
        pwdLogin.setVisibility(View.GONE);
        register.setVisibility(View.GONE);
        verLogin.setVisibility(View.GONE);
    }
}
