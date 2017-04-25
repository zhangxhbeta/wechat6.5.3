package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public final class l extends o {
    protected String afG;
    protected String afH;
    protected int afJ;
    protected boolean afv;
    protected boolean agq;
    protected int agr;
    protected boolean ags;
    protected boolean agt;

    public l(q qVar) {
        super(qVar);
    }

    public final int getLogLevel() {
        hX();
        return this.agr;
    }

    public final String hJ() {
        hX();
        return this.afH;
    }

    public final String hK() {
        hX();
        return this.afG;
    }

    public final boolean hL() {
        hX();
        return this.agq;
    }

    public final boolean hM() {
        hX();
        return this.ags;
    }

    public final int hN() {
        hX();
        return this.afJ;
    }

    public final boolean hO() {
        hX();
        return this.agt;
    }

    public final boolean hP() {
        hX();
        return this.afv;
    }

    protected final void hm() {
        ApplicationInfo applicationInfo;
        Context context = this.afY.mContext;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            f("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            F("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                b bVar = (b) new ak(this.afY).bB(i);
                if (bVar != null) {
                    String str;
                    int i2;
                    C("Loading global XML config values");
                    if (bVar.afG != null) {
                        str = bVar.afG;
                        this.afG = str;
                        e("XML config - app name", str);
                    }
                    if (bVar.afH != null) {
                        str = bVar.afH;
                        this.afH = str;
                        e("XML config - app version", str);
                    }
                    if (bVar.afI != null) {
                        str = bVar.afI.toLowerCase();
                        i2 = "verbose".equals(str) ? 0 : "info".equals(str) ? 1 : "warning".equals(str) ? 2 : "error".equals(str) ? 3 : -1;
                        if (i2 >= 0) {
                            this.agr = i2;
                            d("XML config - log level", Integer.valueOf(i2));
                        }
                    }
                    if (bVar.afJ >= 0) {
                        i2 = bVar.afJ;
                        this.afJ = i2;
                        this.ags = true;
                        e("XML config - dispatch period (sec)", Integer.valueOf(i2));
                    }
                    if (bVar.afK != -1) {
                        boolean z = bVar.afK == 1;
                        this.afv = z;
                        this.agt = true;
                        e("XML config - dry run", Boolean.valueOf(z));
                    }
                }
            }
        }
    }
}
