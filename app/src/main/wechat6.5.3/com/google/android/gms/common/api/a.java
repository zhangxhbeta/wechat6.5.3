package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class a<O> {
    private final a<?, O> akA;
    final e<?, O> akB = null;
    private final c<?> akC;
    final f<?> akD;
    final String mName;

    public static abstract class a<T extends b, O> {
        public abstract T a(Context context, Looper looper, h hVar, O o, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar);

        public List<Scope> jc() {
            return Collections.emptyList();
        }
    }

    public interface b {
        void a(com.google.android.gms.common.api.c.e eVar);

        void a(p pVar);

        void a(p pVar, Set<Scope> set);

        void a(String str, PrintWriter printWriter);

        void disconnect();

        boolean isConnected();

        boolean jd();

        boolean je();
    }

    public static final class c<C extends b> {
    }

    public interface d<T extends IInterface> {
        String jf();

        String jg();

        T jh();
    }

    public interface e<T extends d, O> {
        T ji();

        int jj();
    }

    public static final class f<C extends d> {
    }

    public <C extends b> a(String str, a<C, O> aVar, c<C> cVar) {
        w.h(aVar, "Cannot construct an Api with a null ClientBuilder");
        w.h(cVar, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.akA = aVar;
        this.akC = cVar;
        this.akD = null;
    }

    public final a<?, O> ja() {
        w.a(this.akA != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.akA;
    }

    public final c<?> jb() {
        w.a(this.akC != null, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.akC;
    }
}
