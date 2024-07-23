package demo_4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import ph37313.poly.bai1.R;

public class demo_4 extends AppCompatActivity {

    Button btnGui;
    EditText edNhap;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo4);

        btnGui = findViewById(R.id.btnGui);
        edNhap = findViewById(R.id.edNhap);
        btnGui.setOnClickListener(v -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment_1 fragment1 = (Fragment_1) fragmentManager.findFragmentById(R.id.fg1);
            fragment1.ed1.setText(edNhap.getText().toString());
        });
    }
}