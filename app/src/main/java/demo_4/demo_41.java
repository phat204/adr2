package demo_4;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import ph37313.poly.bai1.R;

public class demo_41 extends AppCompatActivity {
    Button btnAn,btnHien;
    Fragment_1 frg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo41);
        btnAn=findViewById(R.id.button5);
        btnHien=findViewById(R.id.button6);
        btnAn.setOnClickListener(v->{
            FragmentManager fragmentManager = getSupportFragmentManager();
            frg=(Fragment_1) fragmentManager.findFragmentById(R.id.fg2);
            fragmentManager.beginTransaction()
                    .hide(frg)
                    .commit();
        });
        btnHien.setOnClickListener(v->{
            FragmentManager fragmentManager=getSupportFragmentManager();
            frg=(Fragment_1) fragmentManager.findFragmentById(R.id.fg2);
            fragmentManager.beginTransaction()
                    .show(frg)
                    .commit();
        });
    }
}