package com.fxz.recyclerviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    // 创建一个list集合
    List<Contact> mData;
    private RecyclerView recyclerView;
    private RecyclerViewBaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取RecyclerView控件
        recyclerView = findViewById(R.id.recyclerView);
        //初始化数据
        initData();
        //默认显示ListView的效果
        showList(true,false);

        //初始化监听事件
        initListener();
    }

    private void initListener() {
        mAdapter.setOnItemClickListener();
    }

    //初始化模拟数据
    private void initData() {
        mData=new ArrayList<Contact>();
        // 定义并初始化保存图片id的数组
        int[] imageid=new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,
                R.drawable.img04,R.drawable.img05,R.drawable.img06,
                R.drawable.img07,R.drawable.img08,R.drawable.img09,
                R.drawable.img07,R.drawable.img08,R.drawable.img09};
        // 定义并初始化保存列表项名字和号码的数组
        String[] names=new String[]{"刘一","陈二","张三",
                "李四","王五","赵六",
                "孙七","周八","吴九",
                "蒋十","郑十一","冯十二"};
        String[] numbers=new String[]{"志当存高远","有志者事竟成","欲穷千里目",
                "更上一层楼","活着就是为了改变世界，难道还有其他原因么？","领袖和跟风者的区别就在于创新",
                "310","320","330",
                "410","420","430"};

        //通过for循环将图片id和列表项文字放到Contact对象中，并添加到list集合中
        for (int i = 0; i < imageid.length; i++) {
            // 实例化Contact对象
            Contact contact=new Contact(names[i], numbers[i], imageid[i]);
            //将Contact对象添加到List集合中
            mData.add(contact);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);//加载当前Activity的选项菜单
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //ListView部分
            case R.id.list_view_vertical_stander:
                Log.d(TAG, "点击了ListView的垂直标准");
                showList(true,false);
                break;
            case R.id.list_view_vertical_reverse:
                showList(true,true);
                break;
            case R.id.list_view_horizontal_stander:
                showList(false,false);
                break;
            case R.id.list_view_horizontal_reverse:
                showList(false,true);
                break;
            //GridView部分
            case R.id.grid_view_vertical_stander:
                showGrid(true,false);
                break;
            case R.id.grid_view_vertical_reverse:
                showGrid(true,true);
                break;
            case R.id.grid_view_horizontal_stander:
                showGrid(false,false);
                break;
            case R.id.grid_view_horizontal_reverse:
                showGrid(false,true);
                break;
            //StaggerView部分
            case R.id.stagger_view_vertical_stander:
                showStagger(true,false);
                break;
            case R.id.stagger_view_vertical_reverse:
                showStagger(true,true);
                break;
            case R.id.stagger_view_horizontal_stander:
                showStagger(false,false);
                break;
            case R.id.stagger_view_horizontal_reverse:
                showStagger(false,true);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //实现瀑布流效果
    private void showStagger(boolean isVertical, boolean isReverse) {
        //创建布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,
                isVertical?StaggeredGridLayoutManager.VERTICAL:StaggeredGridLayoutManager.HORIZONTAL);
        //设置布局管理器的方向
        layoutManager.setReverseLayout(isReverse);
        //设置布局管理器到RecyclerView里
        recyclerView.setLayoutManager(layoutManager);
        //创建适配器
        mAdapter = new StaggerAdapter(mData);
        recyclerView.setAdapter(mAdapter);
    }

    //显示GridView的效果
    private void showGrid(boolean isVertical, boolean isReverse) {
        //创建GridLayoutManager布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        //通过设置布局管理器来控制水平or垂直和正向or反向
        layoutManager.setOrientation(isVertical?GridLayoutManager.VERTICAL:GridLayoutManager.HORIZONTAL);
        layoutManager.setReverseLayout(isReverse);
        //指定RecyclerView的布局为GridLayoutManager
        recyclerView.setLayoutManager(layoutManager);
        //创建适配器
        mAdapter = new GridViewAdapter(mData);
        recyclerView.setAdapter(mAdapter);
    }

    //显示ListView的效果
    private void showList(boolean isVertical, boolean isReverse) {
        //创建LinearLayoutManager布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //通过设置布局管理器来控制水平or垂直和正向or反向
        layoutManager.setOrientation(isVertical?LinearLayoutManager.VERTICAL:LinearLayoutManager.HORIZONTAL);
        layoutManager.setReverseLayout(isReverse);
        //指定RecyclerView的布局为LinearLayoutManager
        recyclerView.setLayoutManager(layoutManager);
        //创建适配器
        mAdapter = new ContactViewAdapter(mData);
        recyclerView.setAdapter(mAdapter);
    }
}