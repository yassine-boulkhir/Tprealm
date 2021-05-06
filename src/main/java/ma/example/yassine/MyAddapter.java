package ma.example.yassine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ma.example.yassine.Model.Product;
import ma.example.yassine.Model.Users;

public class MyAddapter extends ArrayAdapter<Users> {


    public MyAddapter(@NonNull Context context, List<Users> users) {
        super(context, R.layout.list_item,users);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View userView=inflater.inflate(R.layout.list_item,parent,false);
        Users user = getItem(position);
        TextView tv_id, tv_pwd,tv_user;
        tv_id=userView.findViewById(R.id.tv_id);
        tv_pwd=userView.findViewById(R.id.tv_pwd);
        tv_user=userView.findViewById(R.id.tv_users);
        tv_id.setText(String.valueOf(user.getId_user()));
        tv_user.setText(user.getLogin());
        tv_pwd.setText(user.getPassword());
        return userView;
    }
}
