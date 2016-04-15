package com.example.carlosg.cultiapp.Controller;

import android.content.Context;
import android.util.Log;

import com.example.carlosg.cultiapp.DataBase.DataBaseHelper;
import com.example.carlosg.cultiapp.Model.Meteorologia;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CarlosG on 14/04/2016.
 */
public class MeteorologiaController {
    private DataBaseHelper helper;

    public boolean crear(Meteorologia meteorologia, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Meteorologia, Integer> meteorologiaDao = helper.getMeteorologiaRuntimeDao();
            meteorologiaDao.create(meteorologia); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("MeteorologiaController", "error: ", e);
        }

        return res;
    }

    public boolean borrar(Meteorologia meteorologia, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Meteorologia, Integer> meteorologiaDao = helper.getMeteorologiaRuntimeDao();
            meteorologiaDao.delete(meteorologia); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("MeteorologiaController","error: ", e);
        }

        return res;
    }
    public boolean actualizar(Meteorologia meteorologia, Context context){
        boolean res = true;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Meteorologia, Integer> meteorologiaDao = helper.getMeteorologiaRuntimeDao();
            meteorologiaDao.update(meteorologia); //delete, update
        }catch (Exception e){
            res = false;
            Log.e("MeteorologiaController","error: ", e);
        }

        return res;
    }

    public ArrayList<Meteorologia> listaMeteorologica(Context context){
        ArrayList<Meteorologia> listaameteorologias = null;
        try {
            helper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
            RuntimeExceptionDao<Meteorologia, Integer> meteorologiaDao = helper.getMeteorologiaRuntimeDao();
            listaameteorologias =(ArrayList) meteorologiaDao.queryForAll();
        }catch (Exception e){
        }
        return listaameteorologias;
    }

}
