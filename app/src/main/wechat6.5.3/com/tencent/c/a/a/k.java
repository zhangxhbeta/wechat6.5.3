package com.tencent.c.a.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

final class k extends q {
    public k(Context context) {
        super(context);
    }

    protected final String nN() {
        String string;
        synchronized (this) {
            string = PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
        }
        return string;
    }

    protected final void write(String str) {
        synchronized (this) {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
            edit.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            edit.commit();
        }
    }

    protected final boolean nM() {
        return true;
    }

    protected final a nO() {
        a aVar;
        synchronized (this) {
            aVar = new a(PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), null));
            new StringBuilder("read CheckEntity from sharedPreferences:").append(aVar.toString());
        }
        return aVar;
    }

    protected final void a(a aVar) {
        synchronized (this) {
            new StringBuilder("write CheckEntity to sharedPreferences:").append(aVar.toString());
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
            edit.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), aVar.toString());
            edit.commit();
        }
    }
}
