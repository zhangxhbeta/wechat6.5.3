package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
    boolean aHp;
    com.tencent.mm.modelgeo.a dGN;
    com.tencent.mm.modelgeo.a.a dGO;
    ac dGP;

    class AnonymousClass1 implements com.tencent.mm.modelgeo.a.a {
        final /* synthetic */ a gbU;
        final /* synthetic */ b gbV;

        AnonymousClass1(b bVar, a aVar) {
            this.gbV = bVar;
            this.gbU = aVar;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!z) {
                return true;
            }
            v.v(b.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
            if (this.gbV.dGN != null) {
                this.gbV.dGN.c(this.gbV.dGO);
            }
            if (this.gbV.dGO == null) {
                v.w(b.TAG, "already callback");
                return false;
            }
            this.gbV.dGO = null;
            this.gbU.n(f, f2);
            return false;
        }
    }

    public interface a {
        void n(float f, float f2);
    }

    private static class b {
        private static b gbW = new b();
    }

    private b() {
        this.dGN = null;
        this.dGO = null;
        this.dGP = null;
        this.aHp = false;
    }

    public static b aqa() {
        return b.gbW;
    }
}
