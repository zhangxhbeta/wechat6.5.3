package com.tencent.mm.sdk.h;

import android.os.Looper;

public abstract class g {
    public final h<a, i> nmh = new h<a, i>(this) {
        final /* synthetic */ g nmj;

        {
            this.nmj = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            i iVar = (i) obj2;
            ((a) obj).a(iVar.aXv, iVar);
        }
    };
    private final h<Object, String> nmi = new h<Object, String>(this) {
        final /* synthetic */ g nmj;

        {
            this.nmj = r1;
        }

        protected final /* bridge */ /* synthetic */ void o(Object obj, Object obj2) {
        }
    };

    public interface a {
        void a(String str, i iVar);
    }

    public void lock() {
        this.nmh.lock();
    }

    public void unlock() {
        this.nmh.unlock();
    }

    public final void c(a aVar) {
        this.nmh.a(aVar, Looper.getMainLooper());
    }

    public final void a(a aVar, Looper looper) {
        this.nmh.a(aVar, looper);
    }

    public final void d(a aVar) {
        this.nmh.remove(aVar);
    }

    public final void Ls() {
        this.nmh.bg(new i("*"));
        this.nmh.Ls();
    }

    public final void Lf(String str) {
        this.nmh.bg(new i(str));
        this.nmh.Ls();
    }

    public final void a(String str, int i, Object obj) {
        i iVar = new i();
        iVar.aXv = str;
        iVar.nmq = i;
        iVar.obj = obj;
        iVar.nmr = this;
        this.nmh.bg(iVar);
        this.nmh.Ls();
    }
}
