package com.tencent.mm.sdk.h;

import android.os.Looper;

public abstract class j {
    private final h<b, a> nmh = new h<b, a>(this) {
        final /* synthetic */ j nms;

        {
            this.nms = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            b bVar = (b) obj;
            a aVar = (a) obj2;
            if (this.nms.EP()) {
                bVar.a(aVar.bey, aVar.nmt, aVar.obj);
            }
        }
    };

    private class a {
        int bey;
        final /* synthetic */ j nms;
        j nmt;
        Object obj;

        a(j jVar, int i, j jVar2, Object obj) {
            this.nms = jVar;
            this.bey = i;
            this.obj = obj;
            this.nmt = jVar2;
        }
    }

    public interface b {
        void a(int i, j jVar, Object obj);
    }

    public abstract boolean EP();

    public final void a(b bVar) {
        if (bVar != null) {
            this.nmh.a(bVar, Looper.getMainLooper());
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.nmh.remove(bVar);
        }
    }

    public final void b(int i, j jVar, Object obj) {
        this.nmh.bg(new a(this, i, jVar, obj));
        this.nmh.Ls();
    }
}
