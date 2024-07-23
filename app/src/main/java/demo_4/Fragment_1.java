package demo_4;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ph37313.poly.bai1.R;
public class Fragment_1 extends Fragment {
    EditText ed1;
    Button btn1;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        btn1 = view.findViewById(R.id.btn1);
        ed1 = view.findViewById(R.id.ed1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Ban " + ed1.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}