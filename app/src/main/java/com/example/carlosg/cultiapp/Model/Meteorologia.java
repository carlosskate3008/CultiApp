package com.example.carlosg.cultiapp.Model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by CarlosG on 14/04/2016.
 */
public class Meteorologia {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String humedad;
    @DatabaseField
    private String temperatura;
    @DatabaseField
    private String version;

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
