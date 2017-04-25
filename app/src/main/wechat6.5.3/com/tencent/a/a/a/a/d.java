package com.tencent.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

final class d extends f {
    public d(Context context) {
        super(context);
    }

    protected final void a(String str) {
        synchronized (this) {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
            edit.putString(h.d("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            edit.commit();
        }
    }

    protected final boolean a() {
        return true;
    }

    protected final String b() {
        String string;
        synchronized (this) {
            string = PreferenceManager.getDefaultSharedPreferences(this.a).getString(h.d("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
        }
        return string;
    }
}
