package com.tencent.recovery.c;

import java.util.ArrayList;
import java.util.List;

public final class a implements com.tencent.recovery.c.b.a {
    List<a> pue = new ArrayList(100);

    private class a {
        int level;
        String puf;
        Object[] pug;
        Throwable puh;
        final /* synthetic */ a pui;
        String tag;

        private a(a aVar) {
            this.pui = aVar;
        }
    }

    public final void v(String str, String str2, Object... objArr) {
        if (this.pue.size() < 100) {
            a aVar = new a();
            aVar.level = 1;
            aVar.tag = str;
            aVar.puf = str2;
            aVar.pug = objArr;
            this.pue.add(aVar);
        }
    }

    public final void d(String str, String str2, Object... objArr) {
        if (this.pue.size() < 100) {
            a aVar = new a();
            aVar.level = 2;
            aVar.tag = str;
            aVar.puf = str2;
            aVar.pug = objArr;
            this.pue.add(aVar);
        }
    }

    public final void i(String str, String str2, Object... objArr) {
        if (this.pue.size() < 100) {
            a aVar = new a();
            aVar.level = 3;
            aVar.tag = str;
            aVar.puf = str2;
            aVar.pug = objArr;
            this.pue.add(aVar);
        }
    }

    public final void w(String str, String str2, Object... objArr) {
        if (this.pue.size() < 100) {
            a aVar = new a();
            aVar.level = 4;
            aVar.tag = str;
            aVar.puf = str2;
            aVar.pug = objArr;
            this.pue.add(aVar);
        }
    }

    public final void e(String str, String str2, Object... objArr) {
        if (this.pue.size() < 100) {
            a aVar = new a();
            aVar.level = 5;
            aVar.tag = str;
            aVar.puf = str2;
            aVar.pug = objArr;
            this.pue.add(aVar);
        }
    }

    public final void a(String str, Throwable th, String str2, Object... objArr) {
        if (this.pue.size() < 100) {
            a aVar = new a();
            aVar.level = 5;
            aVar.tag = str;
            aVar.puf = str2;
            aVar.pug = objArr;
            aVar.puh = th;
            this.pue.add(aVar);
        }
    }
}
