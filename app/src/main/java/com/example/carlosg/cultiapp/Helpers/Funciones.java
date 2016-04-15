package com.example.carlosg.cultiapp.Helpers;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;

import com.example.carlosg.cultiapp.R;

/**
 * Created by CarlosAndres on 17/01/2016.
 */
public class Funciones {
    ProgressDialog dialog;

    private Context contexto;
    public void funciones(){
    }
    public Funciones(Context contexto){
        this.contexto = contexto;
    }
    public void setContext(Context contexto){
        this.contexto = contexto;
    }
    public void alertasDialog(String Titulo, String Alerta){
        final AlertDialog.Builder alertaSimple = new AlertDialog.Builder(new ContextThemeWrapper(contexto, R.style.DialogTheme));
        alertaSimple.setTitle(Titulo);
        alertaSimple.setMessage(Alerta);
        alertaSimple.setPositiveButton("Aceptar",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
            }
        });
        alertaSimple.show();
    }
    public void alertasAsincronicas(String titulo,String mensaje){
        dialog = new ProgressDialog(contexto);
        dialog.setCancelable(false);
        dialog.setTitle(titulo);
        dialog.setMessage(mensaje);
        dialog.show();
    }
    public void cancelarDialog(){
        dialog.cancel();
    }
}
