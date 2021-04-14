package com.hackaton.bbva.model.response;

import com.hackaton.bbva.util.DateUtil;

import java.util.Date;
import java.util.HashMap;

public class Row extends HashMap<String, Object> {

    public Row() { }

    public Row(HashMap<? extends String, ?> t) {
        super(t);
    }

    public Row(String key, Object value) {
        this.put(key, value);
    }

    public Object get(String key) {
        return super.get(key);
    }

    public String getString(String key) {
        Object valor = this.get(key);
        if (valor == null) {
            return null;
        } else {
            return valor instanceof Date ? DateUtil.toString((Date) valor) : valor.toString();
        }
    }

    public Date getDate(String key) {
        return this.get(key) != null ? (Date) this.get(key) : null;
    }

    public Integer getInteger(String key) {
        return this.get(key) != null ? Integer.parseInt(this.get(key).toString()) : null;
    }

    public byte[] getArrayByte(String key) {
        return (byte[]) this.get(key);
    }

    public boolean getBoolean(String key) {
        int valor = Integer.parseInt(this.get(key).toString());
        return valor == 1;
    }

    public <T> T getValue(String key, Class<T> clazz) {
        return clazz.cast(this.get(key));
    }
}