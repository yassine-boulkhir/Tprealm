package ma.example.yassine.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Users extends RealmObject {
    @PrimaryKey
    private int id_user;
    @Setter private String login;
    @Setter private String password;



}
