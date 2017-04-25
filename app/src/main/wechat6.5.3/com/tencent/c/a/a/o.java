package com.tencent.c.a.a;

import android.content.Context;
import android.provider.Settings.System;

public final class o extends q {
    public o(Context context) {
        super(context);
    }

    protected final boolean nM() {
        return s.l(this.context, "android.permission.WRITE_SETTINGS");
    }

    protected final String nN() {
        String string;
        synchronized (this) {
            string = System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }

    protected final void write(String str) {
        synchronized (this) {
            p.S(this.context).n(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    protected final a nO() {
        a aVar;
        synchronized (this) {
            aVar = new a(System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=")));
            new StringBuilder("read readCheckEntity from Settings.System:").append(aVar.toString());
        }
        return aVar;
    }

    protected final void a(a aVar) {
        synchronized (this) {
            new StringBuilder("write CheckEntity to Settings.System:").append(aVar.toString());
            p.S(this.context).n(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), aVar.toString());
        }
    }
}
