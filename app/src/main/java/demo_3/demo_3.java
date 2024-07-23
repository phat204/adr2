package demo_3;

import static android.view.View.inflate;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ph37313.poly.bai1.R;

public class demo_3 extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo3);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

        btn1.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Thong bao");
            builder.setMessage("Noi dung can thong bao");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Ban dong y", Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Huy", Toast.LENGTH_LONG).show();
                }
            });
            builder.create().show();
        });

        btn2.setOnClickListener(v -> {
            String[] arr = {"xanh", "do", "tim", "vang"};
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Tieu de");
            builder.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Ban chon " + arr[which], Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        });

        btn3.setOnClickListener(v -> {
            String[] arr = {"xanh", "do", "tim", "vang"};
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Tieu de");
            builder.setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    Toast.makeText(getApplicationContext(), "Ban chon " + arr[which], Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        });

        btn4.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.login_form, null);
            builder.setView(view);
            final EditText txtUser = (EditText) view.findViewById(R.id.txt_user);
            final EditText txtPass = (EditText) view.findViewById(R.id.txt_pass);
            builder.setTitle("Login Form");
            builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Xin chao " + txtUser.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Ban da huy", Toast.LENGTH_LONG).show();
                }
            });
            builder.create().show();
        });
    }
}