package com.tencent.wxop.stat.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.wxop.stat.b;
import java.util.Locale;
import java.util.TimeZone;

final class e {
    String a;
    String b;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    String m;
    String n;
    String p;
    DisplayMetrics pLI;
    Context pLJ;
    String pLK;
    String q;
    String s;

    private e(Context context) {
        this.b = "2.0.3";
        this.d = VERSION.SDK_INT;
        this.e = Build.MODEL;
        this.f = Build.MANUFACTURER;
        this.g = Locale.getDefault().getLanguage();
        this.l = 0;
        this.m = null;
        this.n = null;
        this.pLJ = null;
        this.p = null;
        this.q = null;
        this.pLK = null;
        this.s = null;
        this.pLJ = context.getApplicationContext();
        this.pLI = l.gV(this.pLJ);
        this.a = l.ha(this.pLJ);
        this.h = b.gE(this.pLJ);
        this.i = l.gZ(this.pLJ);
        this.j = TimeZone.getDefault().getID();
        this.l = l.bQB();
        this.k = l.he(this.pLJ);
        this.m = this.pLJ.getPackageName();
        if (this.d >= 14) {
            this.p = l.hj(this.pLJ);
        }
        this.q = l.bQF().toString();
        this.pLK = l.hi(this.pLJ);
        this.s = l.d();
        this.n = l.ho(this.pLJ);
    }
}
