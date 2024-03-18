package com.coderfaysal.roja;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);


        hashMap = new HashMap<>();
        hashMap.put("title", "রোযা কি?");
        hashMap.put("message", "রোযা বা রোজা (ফার্সি روزہ রুজ়ে), সাউম বা সাওম (আরবি صوم স্বাউম্, অর্থঃ সংযম), বা সিয়াম ইসলাম ধর্মের পাঁচটি মূল ভিত্তির তৃতীয়।\n" +
                "সুবহে সাদেক বা ভোরের সূক্ষ আলো থেকে শুরু করে সূর্যাস্ত পর্যন্ত সকল প্রকার পানাহার,পাপাচার, কামাচার এবং সেই সাথে যাবতীয় ভোগ-বিলাস থেকেও বিরত থাকার নাম রোযা।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "রোজার প্রকারভেদ");
        hashMap.put("message", "রোজা পাঁচ প্রকার, যথা—\n" +
                "১.ফরজ রোজা \n" +
                "২.ওয়াজিব রোজা \n" +
                "৩.সুন্নত রোজা \n" +
                "৪.নফল রোজা ও \n" +
                "৫.মোস্তাহাব রোজা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "রোজার ৩ টি ফরজ হলো—");
        hashMap.put("message", "১.নিয়ত করা\n" +
                "২.সব ধরনের পানাহার থেকে বিরত থাকা\n" +
                "৩.যৌন আচরণ থেকে বিরত থাকা।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "রোজা রাখার ৪ টি মৌলিক শর্ত—");
        hashMap.put("message", "১.মুসলিম হওয়া \n" +
                "২.বালেগ হওয়া\n" +
                "৩.অক্ষম না হওয়া\n" +
                "৪.ঋতুস্রাব থেকে বিরত থাকা নারী।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "রোজার উপকারিতা:");
        hashMap.put("message", "রমজানের একটি বিশেষ ফজিলত বা মাহাত্ম্য হচ্ছে,এই পবিত্র রমজান মাসে আল কোরআন অবতীর্ণ হয়েছে। রমজান মাসের রোজা মানুষকে পাপ-পঙ্কিলতা থেকে মুক্তি দেয়,মানুষের কুপ্রবৃত্তি ধুয়ে মুছে দেয় এবং আত্মাকে দহন করে ঈমানের শাখা প্রশাখা সঞ্জিবীত করে। সর্বোপরি আল্লাহ রাব্বুল আলামিনের নৈকট্য ও সন্তুষ্টি লাভ করা যায়। এই মর্মে মহানবী ইরশাদ করেছেন,\n" +
                "“রোজাদারের জন্য দুটি খুশি। একটি হলো তার ইফতারের সময়, আর অপরটি হলো আল্লাহর সঙ্গে সাক্ষাতের সময়।” —(বুখারী ও মুসলিম)");
        arrayList.add(hashMap);


        XAdapter xAdapter = new XAdapter();
        recyclerView.setAdapter(xAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }


    private class XAdapter extends RecyclerView.Adapter<XAdapter.XViewHolder>{


        @NonNull
        @Override
        public XViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.items, parent, false );
            return new XViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull XViewHolder holder, int position) {

            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String message = hashMap.get("message");

            holder.textView.setText(title);

            holder.cardView.setOnClickListener(view -> {
                Details.TITLE = title;
                Details.MESSAGE = message;
                startActivity(new Intent(MainActivity.this, Details.class));
            });


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class XViewHolder extends RecyclerView.ViewHolder{

            TextView textView;
            CardView cardView;

            public XViewHolder(@NonNull View itemView) {
                super(itemView);

                textView = itemView.findViewById(R.id.textView);
                cardView = itemView.findViewById(R.id.cardView);
            }
        }

    }






}