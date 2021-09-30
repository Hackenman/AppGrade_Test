package com.example.appgrade_v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class ClickerAdapter extends RecyclerView.Adapter<ClickerAdapter.ClickerView> {

    ArrayList<Clicker> clickersList = new ArrayList();

    public ClickerAdapter(ArrayList<Clicker> clickers) {

        this.clickersList = clickers;
    }

    @NonNull
    @Override
    public ClickerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view,parent,false);

        return new ClickerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClickerView holder, int position) {

        Clicker clicker = clickersList.get(position);
        holder.textSubject.setText(clicker.getSubject());
        holder.textGradelvl.setText(clicker.getGradelvl());

    }

    @Override
    public int getItemCount() {
        return clickersList.size();
    }

    public class ClickerView extends RecyclerView.ViewHolder{

        TextView textSubject,textGradelvl;
        public ClickerView(@NonNull View itemView) {
            super(itemView);

            textSubject = (TextView)itemView.findViewById(R.id.text_subject);
            textGradelvl = (TextView)itemView.findViewById(R.id.text_grade_lvl);
        }
    }
}
