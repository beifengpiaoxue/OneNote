package com.example.OneNote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.OneNote.adapter.NoteAdapter;
import com.example.OneNote.model.DateModel;
import com.example.OneNote.model.NoteModel;
import com.example.OneNote.util.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyActivity extends Activity {

    private NoteAdapter noteAdapter;
    private GridView gridView;
    private ArrayList<DateModel> lists;
    private Calendar calendar;
    private TextView tv;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化数据
        initData();
        //初始化界面
        initView();
    }

    /**
     * 点击事件监听
     * @param view
     */
    public void click(View view){
        switch (view.getId()){
            case R.id.next:
                calendar.add(Calendar.MONTH,1);
                refreshView();
                break;
            case R.id.pre:
                calendar.add(Calendar.MONTH,-1);
                refreshView();
                break;
        }
    }

    /**
     * 加载View
     */
    public void initView(){
        setContentView(R.layout.main);
        tv= (TextView) findViewById(R.id.date);
        gridView = (GridView) findViewById(R.id.gridview);
        noteAdapter=new NoteAdapter(this,lists);
        gridView.setAdapter(noteAdapter);
        refreshView();
    }

    /**
     * 加载数据
     */
    public void initData(){
        lists=new ArrayList<DateModel>();
        calendar = Calendar.getInstance();
    }

    /**
     * 刷新View
     */
    public void refreshView(){
        lists.clear();
        for(int i=0;i<7;i++){
            lists.add(new DateModel());
        }
        tv.setText(calendar.get(Calendar.YEAR)+"年"+(calendar.get(Calendar.MONTH)+1)+"月");
        lists.addAll(DateUtil.getDates(calendar));
        noteAdapter.notifyDataSetChanged();
    }
}
