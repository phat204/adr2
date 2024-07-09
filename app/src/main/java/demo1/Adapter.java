package demo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ph37313.poly.bai1.R;

public class Adapter extends ArrayAdapter<Model> {
    public Adapter(@NonNull Context context, List<Model> models) {
        super(context, 0, models);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_view, parent, false);
        }
        Model model = getItem(position);
        if (model != null) {
            TextView tvTit = convertView.findViewById(R.id.tvTit);
            TextView tvDes = convertView.findViewById(R.id.tvDes);

            tvTit.setText(model.getTitle());
            tvDes.setText(model.getDescription());
//            tvTit.setText("Title: " + model.getTitle());
//            tvDes.setText("Description: " + model.getDescription());
        }
        return convertView;
    }
}
