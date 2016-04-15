package com.example.carlosg.cultiapp.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.carlosg.cultiapp.Model.Meteorologia;
import com.example.carlosg.cultiapp.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by CarlosG on 14/04/2016.
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME="cultiapp.sql";
    private static final int DATABASE_VERSION= 1;

    private Dao<Meteorologia, Integer>  meteorologiaDAO = null;
    private RuntimeExceptionDao<Meteorologia, Integer> meteorologiaRuntimeDao = null;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null ,DATABASE_VERSION);// R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Meteorologia.class);
        }catch (SQLException e){
            Log.e(DataBaseHelper.class.getSimpleName(), "No se pudo crear la base de datos", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Meteorologia.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void resetMeteorologia() {
        try {
            ConnectionSource source = this.getConnectionSource();
            TableUtils.dropTable(source, Meteorologia.class, true);
            TableUtils.createTable(source, Meteorologia.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        super.close();
        meteorologiaDAO=null;
        meteorologiaRuntimeDao=null;
    }

    public Dao<Meteorologia, Integer> getMeteorologiaDAO() throws SQLException{
        if (meteorologiaDAO == null) meteorologiaDAO = getDao(Meteorologia.class);
        return meteorologiaDAO;
    }

    public RuntimeExceptionDao<Meteorologia, Integer> getMeteorologiaRuntimeDao() throws SQLException{
        if (meteorologiaRuntimeDao == null) meteorologiaRuntimeDao = getRuntimeExceptionDao(Meteorologia.class);
        return meteorologiaRuntimeDao;
    }
}

