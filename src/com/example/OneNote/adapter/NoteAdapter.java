package com.example.OneNote.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.OneNote.R;
import com.example.OneNote.model.DateModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Administrator on 2014/12/22.
 */
public class NoteAdapter extends BaseAdapter{
    private ArrayList<DateModel> lists;
    private Context mContext;

    public NoteAdapter(Context context,ArrayList<DateModel> lists){
        mContext = context;
        this.lists = lists;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder mViewHolder ;
        if(view == null){
            mViewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item,null);
            mViewHolder.class_name= (TextView) view.findViewById(R.id.item_date);
            view.setTag(mViewHolder);
        }else{
            mViewHolder= (ViewHolder) view.getTag();
        }

        if(i<7){
            setWeek(i,mViewHolder.class_name);
            mViewHolder.class_name.setTextColor(Color.BLUE);
            view.setBackgroundColor(Color.YELLOW);
        }else{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd");
            String d=simpleDateFormat.format(lists.get(i).getDate());
            int str=Integer.parseInt(d);
            mViewHolder.class_name.setText(str+"");

            if(lists.get(i).isThisMonth()){
                mViewHolder.class_name.setTextColor(Color.WHITE);
            }else{
                mViewHolder.class_name.setTextColor(Color.GRAY);
            }

            if(lists.get(i).isToday()){
                view.setBackgroundColor(Color.GREEN);
            }else{
                view.setBackgroundResource(0);
            }
        }

        return view;
    }

    public void setWeek(int week,TextView tv){
        switch (week){
            case 0:
                tv.setText("周日");
                break;
            case 1:
                tv.setText("周一");
                break;
            case 2:
                tv.setText("周二");
                break;
            case 3:
                tv.setText("周三");
                break;
            case 4:
                tv.setText("周四");
                break;
            case 5:
                tv.setText("周五");
                break;
            case 6:
                tv.setText("周六");
                break;
        }
    }
    class ViewHolder {
        TextView class_name;
    }
}
