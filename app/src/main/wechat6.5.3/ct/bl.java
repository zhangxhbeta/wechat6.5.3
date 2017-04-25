package ct;

import android.text.TextUtils;

public final class bl {
    public final bk a;
    public int b;
    String c;
    String d;
    public String e;
    String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public int l;
    public long m;
    public String n;
    String o = "4.9.8.1";
    String p = "151219";
    public String q = "4.9.8.1";
    public boolean r = true;
    public boolean s = false;
    public boolean t = false;

    bl(bk bkVar) {
        this.a = bkVar;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.c)) {
            return "0123456789ABCDEF";
        }
        return this.c;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.d)) {
            return "0123456789ABCDEF";
        }
        return this.d;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.f) || this.f.contains("0000")) {
            return "0123456789ABCDEF";
        }
        return this.f;
    }

    public final String d() {
        if (this.o == null) {
            return "None";
        }
        return this.o;
    }

    public final String e() {
        if (this.p == null) {
            return "None";
        }
        return this.p;
    }
}
