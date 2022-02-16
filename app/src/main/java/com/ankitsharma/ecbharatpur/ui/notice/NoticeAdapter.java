package com.ankitsharma.ecbharatpur.ui.notice;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ankitsharma.ecbharatpur.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {

    private Context context;
    private ArrayList<NoticeData> list;
    AlertDialog.Builder builder;
    DatabaseReference databaseReference;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view =LayoutInflater.from (context).inflate (R.layout.newsfeed_item_layout,parent,false);
        return new NoticeViewAdapter (view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, @SuppressLint("RecyclerView") int position) {

        NoticeData currentItem = list.get (position);
        holder.deleteNoticeTitle.setText (currentItem.getTitle ());
        holder.date.setText (currentItem.getData ());
        holder.time.setText (currentItem.getTime ());
        try {
            if (currentItem.getImage ()!=null){
                Picasso.get ().load (currentItem.getImage ()).into (holder.deleteNoticeImage);
            }
        } catch (Exception e){
            e.printStackTrace ();
        }
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {
        private TextView deleteNoticeTitle,date,time;
        private ImageView deleteNoticeImage;

        public NoticeViewAdapter(@NonNull View itemView) {
            super (itemView);
            date = itemView.findViewById (R.id.date);
            time = itemView.findViewById (R.id.time);
            deleteNoticeTitle = itemView.findViewById (R.id.deleteNoticeTitle);
            deleteNoticeImage = itemView.findViewById (R.id.deleteNoticeImage);


        }
    }
}
