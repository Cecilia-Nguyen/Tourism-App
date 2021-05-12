package com.example.tourismapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PlaceAdapter.OnRowClickListener{
    Button btn_previous,btn_next;
    RecyclerView rv_top_destinations, rv_places_to_go;
    PlaceAdapter placeAdapter;
    List<Place> placeList=new ArrayList<>();
    DestinationAdapter destinationAdapter;
    List<Destination> destinationList=new ArrayList<>();
    private static Integer[] destinationImageList={R.drawable.goreme__turkey,R.drawable.london__uk,R.drawable.newyorkcity__newyork,R.drawable.zermatt__switzerland,R.drawable.prague__czechrepublic};
    private static Integer[] placeImageList={R.drawable.sydney_harbour,R.drawable.great_barrier_reef,R.drawable.hyams_beach,R.drawable.cottesloe_beach,R.drawable.margaret_river};
    private static String[] titleList={"Sydney Harbour","Great Barrier Reef","Hyams Beach","Cottesloe Beach","Margaret River"};
    private static String[] descriptionList={"Sydney’s sparkling waterway is the highlight of Australia’s largest city.",
            "The world’s largest coral reef system spans 2,300km (1,429mi) of tropical North Queensland terrain.",
            "Hyams Beach is blessed with the whitest and brightest sand in the world.",
            "Cottesloe Beach is one of Perth's most popular beaches.",
            "It’s the series of world-class surf beaches and acres of tumbling green hills that make Margaret River easily the most beautiful wine region in Australia"
    };
    private int currentPosition=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_previous=findViewById(R.id.btn_previous);
        btn_next=findViewById(R.id.btn_next);
        rv_top_destinations=findViewById(R.id.rv_top_destinations);
        rv_places_to_go=findViewById(R.id.rv_places_to_go);
        destinationAdapter=new DestinationAdapter(destinationList,MainActivity.this);
        placeAdapter=new PlaceAdapter(placeList,MainActivity.this,this);
        rv_top_destinations.setAdapter(destinationAdapter);
        rv_places_to_go.setAdapter(placeAdapter);
        RecyclerView.LayoutManager horizontal_layout_manager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager vertical_layout_manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_top_destinations.setLayoutManager(horizontal_layout_manager);
        rv_places_to_go.setLayoutManager(vertical_layout_manager);
        for (int i=0;i<destinationImageList.length;i++){
            com.example.tourismapp2.Destination destination=new com.example.tourismapp2.Destination(i,destinationImageList[i]);
            destinationList.add(destination);
        }
        for (int i=0;i<placeImageList.length;i++){
            com.example.tourismapp2.Place place=new com.example.tourismapp2.Place(i,placeImageList[i],titleList[i],descriptionList[i]);
            placeList.add(place);
        }
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPosition<destinationAdapter.getItemCount()){
                    currentPosition+=3;
                    if (currentPosition>destinationAdapter.getItemCount()) currentPosition=destinationAdapter.getItemCount()-1;
                    rv_top_destinations.smoothScrollToPosition(currentPosition);
                }

            }
        });
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPosition>0){
                    currentPosition-=3;
                    if (currentPosition<0) currentPosition=0;
                    rv_top_destinations.smoothScrollToPosition(currentPosition);
                }
            }
        });


    }

    @Override
    public void onItemClick(int image, String title, String description) {
        PlaceFragment fragment=PlaceFragment.newInstance(image,title,description);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment).commit();
        findViewById(R.id.layout).setVisibility(View.GONE);
    }
}