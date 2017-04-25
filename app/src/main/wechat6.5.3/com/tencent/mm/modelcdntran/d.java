package com.tencent.mm.modelcdntran;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.a.g;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class d {
    public static int cFm = 1;
    public static int cFn = 2;
    public static int cFo = 3;
    public static int cFp = -1;
    public static int cFq = 3;
    public static int cFr = 4;
    public static int cFs = 5;
    public static int cFt = 1;
    public static int cFu = 2;
    public static int cFv = -10001;
    public static int cFw = -10002;
    public static int cFx = -10003;
    public static int cFy = -10004;

    public static void a(byte[] bArr, String str, int i) {
        if (be.bl(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            v.e(str, str2);
        } else if (i == 3) {
            v.w(str, str2);
        } else if (i == 2) {
            v.i(str, str2);
        } else if (i == 1) {
            v.d(str, str2);
        } else if (i == 0) {
            v.v(str, str2);
        }
    }

    private static String ir(String str) {
        if (be.kS(str)) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!be.i(charAt) && !be.j(charAt)) {
                return null;
            }
        }
        return str;
    }

    public static String a(String str, long j, String str2, String str3) {
        v.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", str, Long.valueOf(j), str2, str3, be.bur());
        if (be.kS(ir(str)) || be.kS(str2) || j <= 0) {
            return null;
        }
        String ma = be.ma(ir(str3));
        String str4 = "a" + str + "_" + g.m((k.xF() + "-" + str2).getBytes()).substring(0, 16) + "_" + j;
        if (be.kS(ma)) {
            return str4;
        }
        return str4 + "_" + ma;
    }

    public static int aN(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return cFm;
            }
            if (activeNetworkInfo.getType() == 1) {
                return cFo;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return cFm;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return cFm;
            }
            if (activeNetworkInfo.getSubtype() >= 3) {
                return cFn;
            }
            return cFm;
        } catch (Throwable e) {
            v.e("MicroMsg.CdnUtil", "exception:%s", be.e(e));
            return cFm;
        }
    }

    public static int aO(Context context) {
        int netType = ak.getNetType(context);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return cFp;
        }
        if (activeNetworkInfo.getType() == 1) {
            return cFt;
        }
        if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
            return cFq;
        }
        if (activeNetworkInfo.getSubtype() >= 13) {
            return cFs;
        }
        if (activeNetworkInfo.getSubtype() >= 3) {
            return cFr;
        }
        if (ak.isWap(netType)) {
            return cFu;
        }
        return cFq;
    }
}
