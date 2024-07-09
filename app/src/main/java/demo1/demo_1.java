package demo1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import ph37313.poly.bai1.R;

public class demo_1 extends AppCompatActivity {

    private Adapter adapter;
    private List<Model> list;
    dbheper dbhepers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo1);

        ListView listView = findViewById(R.id.lvDemo1);
        TextView edTit = findViewById(R.id.edTit);
        TextView edDes = findViewById(R.id.edDes);
        Button btnThem = findViewById(R.id.btnSub);
        dbhepers = new dbheper(this);
        list = dbhepers.getAllData();
        adapter = new Adapter(this, list);
        listView.setAdapter(adapter);

        btnThem.setOnClickListener(v -> {
            String tit = edTit.getText().toString();
            String des = edDes.getText().toString();
            if (!tit.isEmpty() && !des.isEmpty()) {
                Model model = new Model(tit, des);
                dbhepers.them(model);
                list.add(model);
                adapter.notifyDataSetChanged();
                edTit.setText("");
                edDes.setText("");
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}