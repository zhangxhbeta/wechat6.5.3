package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.signin.internal.i;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public final class b {
    public static final c<i> aBE = new c();
    public static final c<i> aBF = new c();
    public static final a<i, e> aBG = new a<i, e>() {
        public final /* synthetic */ com.google.android.gms.common.api.a.b a(Context context, Looper looper, h hVar, Object obj, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
            return new i(context, looper, true, hVar, bVar, cVar, Executors.newSingleThreadExecutor());
        }

        public final /* synthetic */ List jc() {
            return Arrays.asList(new Scope[]{b.aBI, b.aBJ});
        }
    };
    static final a<i, Object> aBH = new a<i, Object>() {
        public final /* synthetic */ com.google.android.gms.common.api.a.b a(Context context, Looper looper, h hVar, Object obj, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
            e eVar = e.aBN;
            return new i(context, looper, false, hVar, bVar, cVar, Executors.newSingleThreadExecutor());
        }
    };
    public static final Scope aBI = new Scope("profile");
    public static final Scope aBJ = new Scope("email");
    public static final com.google.android.gms.common.api.a<e> aBK = new com.google.android.gms.common.api.a("SignIn.API", aBG, aBE);
    public static final com.google.android.gms.common.api.a<Object> aBL = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", aBH, aBF);
    public static final c aBM = new com.google.android.gms.signin.internal.h();
}
