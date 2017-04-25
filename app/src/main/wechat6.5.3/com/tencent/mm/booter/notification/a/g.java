package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class g {
    public b bZY;
    public c bZZ;
    public d caa;
    public h cab;
    public f cac;
    public a cad;
    public int cae;
    public int caf;
    public int cag;
    public int cah;
    public boolean cai;
    private int caj = -1;
    private int cak = -1;
    public boolean cal;
    public boolean cam;
    public Context mContext;

    public g(Context context) {
        this.mContext = context;
        this.bZY = new b();
        this.bZZ = new c();
        this.caa = new d();
        this.cab = new h();
        this.cad = new a();
        this.cac = a.bZX;
    }

    public static String a(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        String str = SQLiteDatabase.KeyEmpty;
        int length = jArr.length;
        int i = 0;
        while (i < length) {
            i++;
            str = str + String.valueOf(jArr[i]) + ",";
        }
        return !str.isEmpty() ? str.substring(0, str.length() - 1) : str;
    }
}
