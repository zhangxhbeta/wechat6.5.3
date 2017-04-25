package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class d {
    private static d aCo;
    private final a aCj;
    private final c aCk;
    final ad aCl;
    final ConcurrentMap<am, Boolean> aCm;
    private final an aCn;
    private final Context mContext;

    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] aCq = new int[a.mh().length];

        static {
            try {
                aCq[a.aCC - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                aCq[a.aCD - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                aCq[a.aCE - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public interface a {
    }

    private d(Context context, a aVar, c cVar, ad adVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.aCl = adVar;
        this.aCj = aVar;
        this.aCm = new ConcurrentHashMap();
        this.aCk = cVar;
        this.aCk.a(new b(this) {
            final /* synthetic */ d aCp;

            {
                this.aCp = r1;
            }

            public final void g(Map<String, Object> map) {
                Object obj = map.get("event");
                if (obj != null) {
                    d.a(this.aCp, obj.toString());
                }
            }
        });
        this.aCk.a(new ag(this.mContext));
        this.aCn = new an();
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new ComponentCallbacks2(this) {
                final /* synthetic */ d aCp;

                {
                    this.aCp = r1;
                }

                public final void onConfigurationChanged(Configuration configuration) {
                }

                public final void onLowMemory() {
                }

                public final void onTrimMemory(int i) {
                    if (i == 20) {
                        this.aCp.aCl.mj();
                    }
                }
            });
        }
    }

    public static d M(Context context) {
        d dVar;
        synchronized (d.class) {
            if (aCo == null) {
                if (context == null) {
                    m.lL();
                    throw new NullPointerException();
                }
                aCo = new d(context, new a() {
                }, new c(new ap(context)), ae.mk());
            }
            dVar = aCo;
        }
        return dVar;
    }

    static /* synthetic */ void a(d dVar, String str) {
        for (am ao : dVar.aCm.keySet()) {
            ao.ao(str);
        }
    }

    final synchronized boolean d(Uri uri) {
        boolean z;
        w mg = w.mg();
        if (mg.d(uri)) {
            String str = mg.aBV;
            switch (AnonymousClass4.aCq[mg.aCz - 1]) {
                case 1:
                    for (am amVar : this.aCm.keySet()) {
                        if (amVar.mo().equals(str)) {
                            amVar.mp();
                            amVar.refresh();
                        }
                    }
                    break;
                case 2:
                case 3:
                    for (am amVar2 : this.aCm.keySet()) {
                        String str2;
                        if (amVar2.mo().equals(str)) {
                            str2 = mg.aCA;
                            amVar2.mp();
                            amVar2.refresh();
                        } else {
                            if (amVar2.aDF) {
                                m.lL();
                                str2 = "";
                            } else {
                                str2 = amVar2.aDE.mq();
                            }
                            if (str2 != null) {
                                amVar2.mp();
                                amVar2.refresh();
                            }
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
