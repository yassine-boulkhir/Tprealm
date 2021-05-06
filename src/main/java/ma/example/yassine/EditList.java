package ma.example.yassine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ma.example.yassine.Model.Helper;
import ma.example.yassine.Model.Users;

public class EditList extends AppCompatActivity {
    EditText Ed_login , Ed_pass;
    Button btn_modifier, btn_delete;
    Helper helper;
    int id_pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);
        Ed_login=findViewById(R.id.tv_login_up);
        Ed_pass = findViewById(R.id.tv_password_up);
        btn_delete=findViewById(R.id.btn_delete);
        btn_modifier=findViewById(R.id.btn_modifier);
        helper = new Helper();
        Intent i = getIntent();
        id_pos = i.getIntExtra("Id_to_up",-1);
        Users user = helper.getUser(id_pos);
        Ed_login.setText(user.getLogin());
        Ed_pass.setText(user.getPassword());
    }

    public void modifierOnClick(View view) {
        helper.Modifier(id_pos,Ed_login.getText().toString(),Ed_pass.getText().toString());
        Liste.Addapeter.notifyDataSetChanged();
        Toast.makeText(EditList.this, "Modifier",Toast.LENGTH_LONG).show();
    }


    public void DeleteInClick(View view) {
        helper.Delete(id_pos);
        Liste.Addapeter.notifyDataSetChanged();
    }
}