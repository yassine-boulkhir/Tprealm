package ma.example.yassine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import ma.example.yassine.Model.Helper;
import ma.example.yassine.Model.Users;

public class Signup extends AppCompatActivity {
   TextView login , pass, confirme;
   Button sign_up;
   Realm realm;
   Myapplication app ;
   List<Users> users ;
   Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        app = (Myapplication) getApplicationContext();
helper = new Helper();
       users = new ArrayList<>();
       users.addAll( helper.GetAll());
        login= findViewById(R.id.tv_new_login);
        pass=findViewById(R.id.tv_new_password);
        confirme =findViewById(R.id.tv_confirme_pwd);
        sign_up=findViewById(R.id.btn_signup);
        sign_up.setOnClickListener(new View.OnClickListener() {
              @Override
                 public void onClick(View v) {
                  helper.addUser(login.getText().toString(),pass.getText().toString());
                  Intent i = new Intent(Signup.this, Liste.class);
                  startActivity(i);
              }
        }
        );

        for (Users u: users ) {
            System.out.println(u.getLogin()+"-------------------------");
                }
    }

//    public void addUser(){
//        int id;
//        realm.beginTransaction();
//        Number currentIdNum = realm.where(Users.class).max("id_user");
//        if(currentIdNum==null)
//            id=1;
//        else
//            id =(int) currentIdNum.longValue()+1;
//        Users user = realm.createObject(Users.class,id);
//        user.setLogin(login.getText().toString());
//        user.setPassword(pass.getText().toString());
//        realm.commitTransaction();
//        Toast.makeText(Signup.this,"Seccus",Toast.LENGTH_LONG).show();
//    }
    }