package com.example.shubh.factfiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Home extends AppCompatActivity {

    
    GridView simpleGrid;
    int logos[] = {R.drawable.tech,R.drawable.universe,
            R.drawable.relp,R.drawable.food,
            R.drawable.architecture,R.drawable.human,
            R.drawable.earth,R.drawable.fit};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        simpleGrid = (GridView) findViewById(R.id.simpleGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomAdapterSelector customAdapter = new CustomAdapterSelector(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent;

                switch(position){
                    case 0:
                         intent = new Intent(view.getContext(), Info.class);
                        intent.putExtra("catagory", 0); // put image data in Intent
                        startActivity(intent); // start Intent
                        break;
                    case 1:
                        intent = new Intent(view.getContext(), Info.class);
                        intent.putExtra("catagory", 1); // put image data in Intent
                        startActivity(intent);
                        break;// start Intent
                    case 2:
                        intent = new Intent(view.getContext(), Info.class);
                        intent.putExtra("catagory", 2); // put image data in Intent
                        startActivity(intent);
                        break;// start Intent

                    case 3:
                        intent = new Intent(view.getContext(), Info.class);
                        intent.putExtra("catagory", 3); // put image data in Intent
                        startActivity(intent); // start Intent
                        break;
                    case 4:
                        intent = new Intent(view.getContext(), Info.class);
                        intent.putExtra("catagory", 4); // put image data in Intent
                        startActivity(intent); // start Intent
                        break;
                    case 5:
                        intent = new Intent(view.getContext(), Info.class);
                        intent.putExtra("catagory", 5); // put image data in Intent
                        startActivity(intent); // start Intent
                        break;
                    case 6:
                        intent = new Intent(view.getContext(), Info.class);
                        intent.putExtra("catagory", 6); // put image data in Intent
                        startActivity(intent); // start Intent
                        break;
                    case 7:
                        intent = new Intent(view.getContext(), Info.class);
                        intent.putExtra("catagory", 7); // put image data in Intent
                        startActivity(intent); // start Intent
                        break;

                }

            }
        });
    }

}
