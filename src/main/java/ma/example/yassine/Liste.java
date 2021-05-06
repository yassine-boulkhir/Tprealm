package ma.example.yassine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import ma.example.yassine.Model.Users;

public class Liste extends AppCompatActivity {
ListView mylist ;
public static MyAddapter Addapeter ;
List<Users> users ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste2);
        mylist=findViewById(R.id.UsersList);
        Realm realm = Realm.getDefaultInstance();
        users = new ArrayList<>();
        users.addAll( realm.where(Users.class).findAll());
        Addapeter= new MyAddapter(this,users );
        mylist.setAdapter(Addapeter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Liste.this, EditList.class );
                i.putExtra("Id_to_up", realm.where(Users.class).findAll().get(position).getId_user());
                startActivity(i);
            }
        });
    }
}