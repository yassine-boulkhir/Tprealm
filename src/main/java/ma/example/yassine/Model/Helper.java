package ma.example.yassine.Model;

import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import ma.example.yassine.Signup;

public class Helper  {

    Realm realm;

    public Helper() {
        this.realm = Realm.getDefaultInstance();
    }

    public RealmResults<Users> GetAll (){
        return realm.where(Users.class).findAll();
    }
    public void addUser(String login , String pass){
        int id;
        realm.beginTransaction();
        Number currentIdNum = realm.where(Users.class).max("id_user");
        if(currentIdNum==null)
            id=1;
        else
            id =(int) currentIdNum.longValue()+1;
        Users user = realm.createObject(Users.class,id);
        user.setLogin(login);
        user.setPassword(pass);
        realm.commitTransaction();
        //Toast.makeText(Signup.this,"Seccus",Toast.LENGTH_LONG).show();
    }
    public void Modifier(int id , String login , String pass){
        realm.beginTransaction();
        Users user =  realm.where(Users.class).equalTo("id_user",id).findFirst();
        user.setLogin(login);
        user.setPassword(pass);
        realm.commitTransaction();
    }

    public void Delete(int id){
        realm.beginTransaction();
        Users user =  realm.where(Users.class).equalTo("id_user",id).findFirst();
        user.deleteFromRealm();
        realm.commitTransaction();
    }

    public Users getUser(int id ){
       return realm.where(Users.class).equalTo("id_user",id).findFirst() ;
    }
}
