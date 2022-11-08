package com.feng.p9p4_androidnetwork;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feng.p9p4_androidnetwork.adapter.ItemListAdapter;
import com.feng.p9p4_androidnetwork.domain.TextItems;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ItemListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.view_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top=5;
                outRect.bottom=5;
            }
        });
        mAdapter = new ItemListAdapter();
        recyclerView.setAdapter(mAdapter);
    }

    public void loadJson(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.sunofbeaches.com/shop/discovery/categories");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(10000);
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
                    connection.setRequestProperty("Accept","*/*");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    if(responseCode == 200) {
                        Map<String, List<String>> headerFields = connection.getHeaderFields();
                        Log.d(TAG, "Map<String, List<String>> headerFields: " + headerFields.toString());
                        Set<Map.Entry<String, List<String>>> entries = headerFields.entrySet();
                        Log.d(TAG, "Set<Map.Entry<String, List<String>>> entries: " + entries.toString());
                        for (Map.Entry<String, List<String>> entry : entries) {
                            Log.d(TAG, entry.getKey() + "==" + entry.getValue());
                        }
                        InputStream inputStream = connection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            content.append(line);
                        }
                        Log.d(TAG, "content--> " + content);
                        Gson gson = new Gson();
                        TextItems textItems = gson.fromJson(content.toString(), TextItems.class);
                        updateUI(textItems);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void updateUI(TextItems textItems) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.setData(textItems);
            }
        });
    }
}