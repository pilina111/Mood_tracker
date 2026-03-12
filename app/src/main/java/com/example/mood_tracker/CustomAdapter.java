package com.example.mood_tracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

  private Context context;

 private ArrayList note_id, date, title, text;



CustomAdapter(Context context, ArrayList note_id, ArrayList date, ArrayList title, ArrayList text)
{

this.context = context;
this.note_id = note_id;
this.date = date;
this.title = title;
this.text = text;

}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.my_row, parent, false);
    return new MyViewHolder(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {


    holder.note_id_txt.setText(String.valueOf(note_id.get(position)));
    holder.date_txt.setText(String.valueOf(date.get(position)));
    holder.title_txt.setText(String.valueOf(title.get(position)));
    holder.text_txt.setText(String.valueOf(text.get(position)));
    holder.mainLayout.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {

Intent intent = new Intent(context, UpdateActivity.class);
intent.putExtra("id", String.valueOf(note_id.get(position)));
intent.putExtra("date", String.valueOf(date.get(position)));
intent.putExtra("title", String.valueOf(title.get(position)));

intent.putExtra("text", String.valueOf(text.get(position)));

context.startActivity(intent);


        }
    });
    }

    @Override
    public int getItemCount() {
        return note_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView note_id_txt, date_txt, title_txt, text_txt;
    LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            note_id_txt = itemView.findViewById(R.id.note_id_txt);
            date_txt = itemView.findViewById(R.id.date_txt);
            title_txt = itemView.findViewById(R.id.title_txt);
            text_txt = itemView.findViewById(R.id.text_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);





        }
    }
}