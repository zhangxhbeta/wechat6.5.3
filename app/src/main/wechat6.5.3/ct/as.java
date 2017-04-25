package ct;

import android.content.Context;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class as {
    private static as k = null;
    private String a = SQLiteDatabase.KeyEmpty;
    private String b = SQLiteDatabase.KeyEmpty;
    private String c = SQLiteDatabase.KeyEmpty;
    private String d = SQLiteDatabase.KeyEmpty;
    private String e = SQLiteDatabase.KeyEmpty;
    private String f = SQLiteDatabase.KeyEmpty;
    private String g = SQLiteDatabase.KeyEmpty;
    private String h = SQLiteDatabase.KeyEmpty;
    private String i = SQLiteDatabase.KeyEmpty;
    private String j = SQLiteDatabase.KeyEmpty;

    private as() {
    }

    public static synchronized void a(Context context) {
        synchronized (as.class) {
            if (context != null) {
                if (k == null) {
                    k = new as();
                }
                synchronized (k) {
                    as asVar = k;
                    at.a(context);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(at.a());
                    stringBuffer.append(";Android ");
                    stringBuffer.append(at.b());
                    stringBuffer.append(",level ");
                    stringBuffer.append(at.c());
                    asVar.a(stringBuffer.toString());
                    k.l();
                    k.d("unknown");
                    k.c(ar.c(context));
                    asVar = k;
                    at.a(context);
                    asVar.e(at.b(context));
                    asVar = k;
                    at.a(context);
                    asVar.e = at.c(context);
                    asVar = k;
                    at.a(context);
                    asVar.f = at.e(context);
                    asVar = k;
                    at.a(context);
                    asVar.g = at.d(context);
                    k.f(p.f);
                    k.b(ar.a(context));
                    asVar = k;
                    at.a(context);
                    asVar.i = at.d();
                    asVar = k;
                    at.a(context);
                    asVar.j = at.a();
                }
            }
        }
    }

    private synchronized void a(String str) {
        this.a = str;
    }

    private synchronized void b(String str) {
        this.b = str;
    }

    private synchronized void c(String str) {
        this.c = str;
    }

    private synchronized void d(String str) {
    }

    private synchronized void e(String str) {
        this.d = str;
    }

    private synchronized void f(String str) {
        this.h = str;
    }

    public static synchronized as k() {
        as asVar;
        synchronized (as.class) {
            asVar = k;
        }
        return asVar;
    }

    private synchronized void l() {
    }

    public final synchronized String a() {
        return this.a;
    }

    public final synchronized String b() {
        return this.b;
    }

    public final synchronized String c() {
        return this.c;
    }

    public final synchronized String d() {
        return this.d;
    }

    public final synchronized String e() {
        return this.h;
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.f;
    }

    public final String h() {
        return this.g;
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }
}
