package com.example.camilo.vectorderotacion.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.camilo.vectorderotacion.models.Movimiento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by camilo on 04/04/2017.
 */
public class MovimientoDao {
    static final String TABLE = "movimeintos";
    static final String C_MINICIAL = "minicial";
    static final String C_MFINAL = "mfinal";
    static final String C_MANGULO = "mangulo";
    static final String C_ID = "_id";


    SQLiteDatabase db;
    public MovimientoDao(Context context){
        DataBaseHelper helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();

    }

    public void insert(Movimiento movimiento){
        ContentValues cV = new ContentValues();
        cV.put(C_MFINAL, movimiento.getMfinal());
        cV.put(C_MINICIAL, movimiento.getMinicial());
        cV.put(C_MANGULO, movimiento.getMangulo());
        long id = db.insert(TABLE, null, cV);
        movimiento.setId(id);


    }
    public void update(Movimiento movimiento){
        ContentValues cV = new ContentValues();
        cV.put(C_MFINAL, movimiento.getMfinal());
        cV.put(C_MINICIAL, movimiento.getMinicial());
        cV.put(C_MANGULO, movimiento.getMangulo());
        db.update(TABLE, cV, "_id = ?", new String[]{movimiento.getId()+""});
    }
    public void delete(long id){
        db.delete(TABLE, "_id = "+id, null);

    }

    public Movimiento getById(long id){

        Cursor c= db.rawQuery("SELECT * FROM movimientos WHERE _id="+id, null);
        return cursorToMovimiento(c);
    }
    public List<Movimiento> getAll(){
        Cursor c= db.rawQuery("SELECT * FROM movimientos ", null);
        return cursorToList(c);
    }
    //no se podria implementar el buscar por inicial o final creo
    public List<Movimiento> getByMinicial(Double minicial){
        Cursor c= db.rawQuery("SELECT * FROM movimientos ", null);
        return cursorToList(c);
    }

    private Movimiento cursorToMovimiento(Cursor c){
        Movimiento movimiento = null;
        if(c.moveToNext()){
            movimiento = new Movimiento();
            movimiento.setId(c.getLong(0));
            movimiento.setMinicial(c.getDouble(1));
            movimiento.setMfinal(c.getDouble(2));
            movimiento.setMangulo(c.getDouble(3));
        }
        return movimiento;
    }
    private List<Movimiento> cursorToList(Cursor c){
        List<Movimiento> data = new ArrayList<>();
        for (int i = 0; i< c.getCount();i++){
            Movimiento m = cursorToMovimiento(c);
            data.add(m);

        }
        return data;
    }
}
