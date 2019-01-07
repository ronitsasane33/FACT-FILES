package com.example.shubh.factfiles;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Info extends AppCompatActivity {

    ImageButton copy,fav,share;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        copy=(ImageButton)findViewById(R.id.copy);
        fav=(ImageButton)findViewById(R.id.fav);
        share=(ImageButton)findViewById(R.id.share);

        View v = this.getWindow().getDecorView();


        Bundle bn=getIntent().getExtras();
         final int pos=bn.getInt("catagory");

        //Toast.makeText(getApplicationContext(),"p= "+pos,Toast.LENGTH_SHORT).show();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        /*copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Fact Copied to Copy board",Toast.LENGTH_SHORT).show();
            }
        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Fact added to favorites",Toast.LENGTH_SHORT).show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Share fact",Toast.LENGTH_SHORT).show();
            }
        });*/


        if(pos==0) {

           // getActionBar().setTitle("Universe");
                v.setBackgroundResource(R.drawable.background);
            data = new ArrayList<DataModel>();
            for (int i = 0; i <technology.nameArray.length; i++) {
                data.add(new DataModel(
                        technology.nameArray[i],
                        // MyData.versionArray[i],
                        technology.id_[i]
                        // MyData.drawableArray[i]
                ));
            }
        }
        else  if(pos==1) {
            v.setBackgroundResource(R.drawable.backgroundyellow);
            data = new ArrayList<DataModel>();
            for (int i = 0; i <Universe.nameArray.length; i++) {
                data.add(new DataModel(
                        Universe.nameArray[i],
                        // MyData.versionArray[i],
                        Universe.id_[i]
                        // MyData.drawableArray[i]
                ));
            }
        }
        else  if(pos==2) {
            v.setBackgroundResource(R.drawable.backgroundred);

            data = new ArrayList<DataModel>();
            for (int i = 0; i < relationship.nameArray.length; i++) {
                data.add(new DataModel(
                        relationship.nameArray[i],
                        // MyData.versionArray[i],
                        relationship.id_[i]
                        // MyData.drawableArray[i]
                ));
            }
        }
        else  if(pos==3) {
            v.setBackgroundResource(R.drawable.backgroundchoco);

            data = new ArrayList<DataModel>();
            for (int i = 0; i < food.nameArray.length; i++) {
                data.add(new DataModel(
                        food.nameArray[i],
                        // MyData.versionArray[i],
                        food.id_[i]
                        // MyData.drawableArray[i]
                ));
            }
        }
        else  if(pos==4) {
            v.setBackgroundResource(R.drawable.backgroundpink);

            data = new ArrayList<DataModel>();
            for (int i = 0; i < architecture.nameArray.length; i++) {
                data.add(new DataModel(
                        architecture.nameArray[i],
                        // MyData.versionArray[i],
                        architecture.id_[i]
                        // MyData.drawableArray[i]
                ));
            }
        }
        else  if(pos==5) {
            v.setBackgroundResource(R.drawable.backgroundviolet);

            data = new ArrayList<DataModel>();
            for (int i = 0; i <health.nameArray.length; i++) {
                data.add(new DataModel(
                        health.nameArray[i],
                        // MyData.versionArray[i],
                        health.id_[i]
                        // MyData.drawableArray[i]
                ));
            }
        }
        else  if(pos==6) {
            v.setBackgroundResource(R.drawable.backgroundblack);

            data = new ArrayList<DataModel>();
            for (int i = 0; i < earth.nameArray.length; i++) {
                data.add(new DataModel(
                        earth.nameArray[i],
                        // MyData.versionArray[i],
                        earth.id_[i]
                        // MyData.drawableArray[i]
                ));
            }
        } else  if(pos==7) {
            v.setBackgroundResource(R.drawable.backgroundgrey);

            data = new ArrayList<DataModel>();
            for (int i = 0; i < health.nameArray.length; i++) {
                data.add(new DataModel(
                        health.nameArray[i],
                        // MyData.versionArray[i],
                        health.id_[i]
                        // MyData.drawableArray[i]
                ));
            }
        }



        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
