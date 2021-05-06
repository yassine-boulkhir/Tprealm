package ma.example.yassine.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Product extends RealmObject {
    @PrimaryKey
    private int id ;
    @Setter private String name ;
    @Setter private float prix ;
    byte [] image ;

}
