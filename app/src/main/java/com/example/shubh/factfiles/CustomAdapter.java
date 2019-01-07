package com.example.shubh.factfiles;

      import android.content.ActivityNotFoundException;
      import android.content.ClipData;
      import android.content.ClipboardManager;
      import android.content.Context;
      import android.content.Intent;
      import android.graphics.Bitmap;
      import android.net.Uri;
      import android.os.Environment;
      import android.support.v7.widget.RecyclerView;
      import android.util.Log;
      import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
      import android.widget.Adapter;
      import android.widget.ImageButton;
      import android.widget.ImageView;
        import android.widget.TextView;
      import android.widget.Toast;

      import java.io.File;
      import java.io.FileNotFoundException;
      import java.io.FileOutputStream;
      import java.io.IOException;
      import java.util.ArrayList;

      import static android.support.v4.content.ContextCompat.startActivity;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;
    private Adapter mAdapter;

    public CustomAdapter(Adapter adapter) {
    mAdapter = adapter;


    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageButton copy,share,love;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.copy=(ImageButton)itemView.findViewById(R.id.copy);
            this.share=(ImageButton)itemView.findViewById(R.id.share);
            this.love=(ImageButton)itemView.findViewById(R.id.fav);



        }
    }

    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(Info.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        ImageButton copy=holder.copy;
        ImageButton share=holder.share;
        ImageButton love=holder.love;

        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());

        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(),"Fact copied to Clip Board",Toast.LENGTH_SHORT).show();

                String a="";
                ClipboardManager clipboard = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(a, (dataSet.get(listPosition).getName()));
                clipboard.setPrimaryClip(clip);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,"FACT Shared From Andoid app FACT FILES :  \n\n"+dataSet.get(listPosition).getName());
                startActivity(view.getContext(),Intent.createChooser(sharingIntent, view.getContext().getResources().getString(R.string.share_using)),null);
               }
        });


    }



        @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

