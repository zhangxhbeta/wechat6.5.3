package com.google.android.gms.analytics.internal;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.c.aa;
import com.google.android.gms.common.internal.w;
import java.util.HashSet;
import java.util.Set;

public final class ac {
    private final q ahP;
    private volatile Boolean ahQ;
    private String ahR;
    private Set<Integer> ahS;

    protected ac(q qVar) {
        w.Z(qVar);
        this.ahP = qVar;
    }

    public static boolean iC() {
        return ((Boolean) aj.aid.get()).booleanValue();
    }

    public static int iD() {
        return ((Integer) aj.aiA.get()).intValue();
    }

    public static long iE() {
        return ((Long) aj.ail.get()).longValue();
    }

    public static long iF() {
        return ((Long) aj.aio.get()).longValue();
    }

    public static int iG() {
        return ((Integer) aj.aiq.get()).intValue();
    }

    public static int iH() {
        return ((Integer) aj.air.get()).intValue();
    }

    public static String iI() {
        return (String) aj.ait.get();
    }

    public static String iJ() {
        return (String) aj.ais.get();
    }

    public static String iK() {
        return (String) aj.aiu.get();
    }

    public static long iM() {
        return ((Long) aj.aiI.get()).longValue();
    }

    public final boolean iB() {
        if (this.ahQ == null) {
            synchronized (this) {
                if (this.ahQ == null) {
                    ApplicationInfo applicationInfo = this.ahP.mContext.getApplicationInfo();
                    String m = aa.m(this.ahP.mContext, Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(m);
                        this.ahQ = Boolean.valueOf(z);
                    }
                    if ((this.ahQ == null || !this.ahQ.booleanValue()) && "com.google.android.gms.analytics".equals(m)) {
                        this.ahQ = Boolean.TRUE;
                    }
                    if (this.ahQ == null) {
                        this.ahQ = Boolean.TRUE;
                        this.ahP.hZ().G("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.ahQ.booleanValue();
    }

    public final Set<Integer> iL() {
        String str = (String) aj.aiD.get();
        if (this.ahS == null || this.ahR == null || !this.ahR.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.ahR = str;
            this.ahS = hashSet;
        }
        return this.ahS;
    }
}
