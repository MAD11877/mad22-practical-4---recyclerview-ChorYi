package sg.edu.np.mad.mad_exercise4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    public static ArrayList<User> userData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Create a list of 20 User objects

        //ArrayList<User> userData = new ArrayList<>();
        for (int i=0; i<20; i++){
            Random r = new Random();
            String name = "Name" + r.nextInt();
            String desc = "Description " + Math.abs(r.nextInt());
            Boolean followed = r.nextBoolean();
            userData.add(new User(name, desc, i, followed));
        }

        RecyclerView rv = findViewById(R.id.recyclerView);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        ListActAdapter adapter = new ListActAdapter(userData);

        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);
    }
}