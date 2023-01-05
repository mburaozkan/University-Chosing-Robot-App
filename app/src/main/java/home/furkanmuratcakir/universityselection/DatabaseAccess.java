package home.furkanmuratcakir.universityselection;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private static final String TAG = "DatabaseAccess";
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static  DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static  DatabaseAccess getInstance(Context context){
        // veritabanı farklı yerlerden açılması önlenmesi için tek methodda kendiliğinden açılan veritabanı.
        if (instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        // veritabanı açılır.
        db = openHelper.getWritableDatabase();
    }

    public void close(){
        // veritabanı kapatılır.
        if (db!=null){
            db.close();
        }
    }

    public List<String> getData( String tableName, String where, String searchCriteria, int columnIndex){
        // veritabanına imleç yardımıyla veriler toplanır
        c = db.rawQuery("SELECT * FROM " + tableName + " WHERE " + where + " LIKE '%" + searchCriteria + "%';", new String[]{});
        // Select * from lisans bolum where bolum Like %bilgisayar%;"
        List<String> result = new ArrayList<>();
        // imleç ilk satıra.
        c.moveToFirst();
        do {
            // idleri toplayıp result listesine atar.
            String data = c.getString(columnIndex);
            Log.d(TAG, "getData: " + data);
            result.add(data);
        } while (c.moveToNext());
        return result;
    }

    public List<Item> getItems(String tableName, String where, String searchCriteria){
        // veritabanından verileri item halinde almayı sağlar
        c = db.rawQuery("SELECT * FROM " + tableName + " WHERE " + where + " = '" + searchCriteria + "';", new String[]{});
        // "SELECT * FROM lisansbolum WHERE id = 5"
        List<Item> result = new ArrayList<>();
        c.moveToFirst();
        do {
            // itemleri
            Item item = new Item(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
            Log.d(TAG, "getItems: "+ item.getTaban_puan());
            result.add(item);
        } while (c.moveToNext());
        return result;
    }
}
