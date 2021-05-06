package ma.example.yassine;

import android.app.Application;
import android.widget.Toast;

import io.realm.Realm;
import ma.example.yassine.Model.Users;

public class Myapplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }


}
