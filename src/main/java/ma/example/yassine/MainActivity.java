package ma.example.yassine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

EditText tv_login,tv_password;
Button login;
TextView tv_sign_in,tv_forget_pwd;
Myapplication context;
Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = (Myapplication) this.getApplicationContext();
        realm = Realm.getDefaultInstance();
        tv_login=findViewById(R.id.tv_login_up);
        tv_password=findViewById(R.id.tv_password_up);
        login=findViewById(R.id.btn_login);
        tv_sign_in=findViewById(R.id.tv_sign_in);
        tv_forget_pwd=findViewById(R.id.tv_forgetpwd);
       login.setOnClickListener( this);
       tv_sign_in.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()) {
           case R.id.btn_login :
                break;
            case R.id.tv_sign_in :
              Intent i = new Intent(MainActivity.this,Signup.class);
              startActivity(i);
               break;
       }
   }


}