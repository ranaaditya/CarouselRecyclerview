package com.rana_aditya.newrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class newcreaation extends AppCompatActivity {
private RecyclerView recyclerView;
private RecyclerView.LayoutManager manager;
private List<Integer> data=new ArrayList<>();
private adapter myadapter;
private carouselLayout mylayout;
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    private EndlessrecyclerView scrollListener;
    private Button get_btn;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcreaation);
        imageView=findViewById(R.id.ticket);
        get_btn=findViewById(R.id.button);
        mylayout=new carouselLayout(this,carouselLayout.HORIZONTAL,false);
        //manager=new carouselLayout(this,carouselLayout.HORIZONTAL,false);
        // mylayout.scrollToPosition(3);
        manager=mylayout;
       mylayout.setSmoothScrollbarEnabled(true);
        data.add(R.drawable.data1);
        data.add(R.drawable.data2);
        data.add(R.drawable.data4);
        data.add(R.drawable.data5);
        data.add(R.drawable.data6);
        myadapter=new adapter(data,newcreaation.this);
        recyclerView=findViewById(R.id.recyler);
       // recyclerView.setLayoutManager(new carouselLayout(this,carouselLayout.HORIZONTAL,false));

        recyclerView.setLayoutManager(manager);




get_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       //Toast.makeText(newcreaation.this,String.valueOf( myadapter.getItemCount()),Toast.LENGTH_SHORT).show();
        int first=mylayout.findFirstVisibleItemPosition();
        int last=mylayout.findLastVisibleItemPosition();
        int middle=(last-first)/2 + first;
        if (middle>4){
            while(middle>=5){
                middle-=5;
            }
        }
        switch (middle){
            case 0: imageView.setImageResource(R.drawable.data1);
                break;
            case 1: imageView.setImageResource(R.drawable.data2);
                break;
            case 2: imageView.setImageResource(R.drawable.data4);
                break;
            case 3: imageView.setImageResource(R.drawable.data5);
                break;
            case 4: imageView.setImageResource(R.drawable.data6);
                break;
                default: imageView.setImageResource(R.drawable.data1);
        }
        Toast.makeText(newcreaation.this,String.valueOf(middle),Toast.LENGTH_SHORT).show();
    }
});



scrollListener=new EndlessrecyclerView(mylayout) {
    @Override
    public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

        Toast.makeText(newcreaation.this,"LAST",Toast.LENGTH_SHORT).show();
       loadmore();
        myadapter.notifyDataSetChanged();
    }
};

recyclerView.addOnScrollListener(scrollListener);
        recyclerView.setAdapter(myadapter);
        myadapter.notifyDataSetChanged();
    }
public void loadmore(){
    data.add(R.drawable.data1);
    data.add(R.drawable.data2);
    data.add(R.drawable.data4);
    data.add(R.drawable.data5);
    data.add(R.drawable.data6);
}
}
