package com.tencent.c.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import org.json.JSONObject;

public class i {
    static f aOA = null;
    public static volatile long aOB = 0;
    static h aOC = null;
    private static i aOz = null;
    public static Context mContext = null;
    public static Handler mHandler = null;
    private g aOD = null;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ i aOE;
        private final /* synthetic */ String aOF;

        public AnonymousClass1(i iVar, String str) {
            this.aOE = iVar;
            this.aOF = str;
        }

        public final void run() {
            try {
                new StringBuilder("receive data:").append(this.aOF);
                int i = 100;
                int i2 = 3;
                if (s.aM(this.aOF)) {
                    JSONObject jSONObject = new JSONObject(this.aOF);
                    if (!jSONObject.isNull("mid")) {
                        String optString = jSONObject.optString("mid");
                        if (s.aN(optString) && !s.aN(this.aOE.nQ())) {
                            this.aOE.aOD.aOx = optString;
                            this.aOE.aOD.aOw = s.W(i.mContext);
                            this.aOE.aOD.aKA = s.V(i.mContext);
                            if (jSONObject.isNull("ts")) {
                                this.aOE.aOD.aOy = System.currentTimeMillis();
                            } else {
                                long optLong = jSONObject.optLong("ts");
                                if (optLong > 0) {
                                    this.aOE.aOD.aOy = optLong;
                                }
                            }
                            new StringBuilder("new mid midEntity:").append(this.aOE.aOD.toString());
                            r.T(i.mContext).b(this.aOE.aOD);
                        }
                    }
                    if (!jSONObject.isNull(a.aOe)) {
                        i = jSONObject.getInt(a.aOe);
                    }
                    if (!jSONObject.isNull(a.aOf)) {
                        i2 = jSONObject.getInt(a.aOf);
                    }
                    j.aOG = jSONObject.optInt("disable", 0);
                    j.aOH = jSONObject.optInt("limit", 0);
                }
                r T = r.T(i.mContext);
                a nW = T.nW();
                if (i > 0) {
                    nW.aOa = i;
                }
                if (i2 > 0) {
                    nW.aOb = i2;
                }
                nW.aNY = System.currentTimeMillis();
                nW.aNZ = 0;
                T.b(nW);
            } catch (Throwable th) {
            }
        }
    }

    private i(Context context) {
        HandlerThread handlerThread = new HandlerThread(i.class.getSimpleName());
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());
        Context applicationContext = context.getApplicationContext();
        mContext = applicationContext;
        aOB = PreferenceManager.getDefaultSharedPreferences(applicationContext).getLong("__MID_LAST_CHECK_TIME__", 0);
    }

    public static i R(Context context) {
        if (aOz == null) {
            synchronized (i.class) {
                if (aOz == null) {
                    aOz = new i(context);
                }
            }
        }
        return aOz;
    }

    public static void a(f fVar) {
        aOA = fVar;
    }

    public final String nQ() {
        if (this.aOD == null || !s.aN(this.aOD.aOx)) {
            int i;
            this.aOD = r.T(mContext).nV();
            if (s.aN(this.aOD.aOx)) {
                i = 2;
            } else {
                i = 1;
            }
            if (mHandler != null) {
                mHandler.post(new n(mContext, i));
            }
            new StringBuilder("wx get mid:").append(this.aOD.aOx);
        }
        return this.aOD.aOx;
    }

    public final String nR() {
        if (this.aOD == null || !s.aN(this.aOD.aOx)) {
            this.aOD = r.T(mContext).nV();
        }
        return this.aOD.aOx;
    }
}
