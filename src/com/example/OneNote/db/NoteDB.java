package com.example.OneNote.db;

import android.content.Context;
import com.example.OneNote.model.NoteModel;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

/**
 * Created by Administrator on 2014/12/19.
 */
public class NoteDB {
    private static NoteDB instance;

    public static NoteDB getInstance(){
        if(instance == null){
            instance = new NoteDB();
        }
        return instance;
    }

    public void add(Context context,NoteModel noteModel){
        DbUtils dbUtils=DbUtils.create(context);
        try {
            dbUtils.saveOrUpdate(noteModel);
        } catch (DbException e) {
            e.printStackTrace();
        }
        dbUtils.close();
    }

    public void update(Context context,NoteModel noteModel){
        DbUtils dbUtils=DbUtils.create(context);
        try {
            dbUtils.saveOrUpdate(noteModel);
        } catch (DbException e) {
            e.printStackTrace();
        }
        dbUtils.close();
    }

    public void delete(Context context,String id){
        DbUtils dbUtils=DbUtils.create(context);
        try {
            dbUtils.deleteById(NoteModel.class,id);
        } catch (DbException e) {
            e.printStackTrace();
        }
        dbUtils.close();
    }
}
