package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.ak.j.b;
import com.tencent.mm.ak.m;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.FileUtils;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class k {
    public static boolean eo(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String xF = xF();
        if (xF != null && xF.length() > 0) {
            return xF.equals(str);
        }
        v.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
        return false;
    }

    public static int xE() {
        g.vx();
        Integer num = (Integer) g.vw().vf().get(9, null);
        return num == null ? 0 : num.intValue();
    }

    public static String getUserBindEmail() {
        g.vx();
        return be.ma((String) g.vw().vf().get(5, null));
    }

    public static String xF() {
        g.vx();
        return (String) g.vw().vf().get(2, null);
    }

    public static String xG() {
        g.vx();
        return (String) g.vw().vf().get(42, null);
    }

    public static String xH() {
        g.vx();
        return (String) g.vw().vf().get(4, null);
    }

    public static String xI() {
        String xG = xG();
        return !be.kS(xG) ? xG : xF();
    }

    public static int xJ() {
        g.vx();
        Integer num = (Integer) g.vw().vf().get(7, null);
        return num == null ? 0 : num.intValue();
    }

    public static long xK() {
        g.vx();
        Long l = (Long) g.vw().vf().get(147457, null);
        return l == null ? 0 : l.longValue();
    }

    public static int xL() {
        g.vx();
        Integer num = (Integer) g.vw().vf().get(40, null);
        return num == null ? 0 : num.intValue();
    }

    public static int xM() {
        g.vx();
        Integer num = (Integer) g.vw().vf().get(339975, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean eF(int i) {
        return (i & 8192) != 0;
    }

    public static boolean xN() {
        return (xL() & 16384) != 0;
    }

    public static boolean xO() {
        return (xL() & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0;
    }

    public static void xP() {
        int xL = xL() | WXMediaMessage.THUMB_LENGTH_LIMIT;
        g.vx();
        g.vw().vf().set(40, Integer.valueOf(xL));
    }

    public static int xQ() {
        g.vx();
        Integer num = (Integer) g.vw().vf().get(34, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean xR() {
        return (xJ() & 64) != 0;
    }

    public static boolean xS() {
        boolean z;
        if ((xJ() & 262144) != 0) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", Boolean.valueOf(z), Integer.valueOf(xJ()));
        return z;
    }

    public static boolean xT() {
        g.vx();
        g.vw().vf().iB(true);
        if (xM() == 1) {
            return true;
        }
        return false;
    }

    public static boolean xU() {
        g.vx();
        g.vw().vf().iB(true);
        if (xM() == 2) {
            return true;
        }
        return false;
    }

    public static boolean xV() {
        g.vx();
        g.vw().vf().iB(true);
        if (xM() == 4) {
            return true;
        }
        return false;
    }

    public static boolean xW() {
        return (xQ() & 32) == 0;
    }

    public static boolean xX() {
        return (xJ() & 4096) != 0;
    }

    public static boolean xY() {
        ax Nr = ((d) g.f(d.class)).wN().Nr("@t.qq.com");
        return Nr != null && Nr.aeX();
    }

    public static boolean xZ() {
        return (xQ() & 2) == 0;
    }

    public static boolean ya() {
        return (xQ() & 16) == 0;
    }

    public static boolean yb() {
        return (xQ() & FileUtils.S_IWUSR) == 0;
    }

    public static boolean yc() {
        g.vx();
        return be.c((Boolean) g.vw().vf().get(8200, null));
    }

    public static boolean yd() {
        return (xQ() & 524288) == 0;
    }

    public static boolean ye() {
        return (xQ() & 262144) == 0;
    }

    public static boolean yf() {
        return (xQ() & 8192) == 0;
    }

    public static boolean yg() {
        return (xQ() & 65536) == 0;
    }

    public static boolean yh() {
        g.vx();
        String str = (String) g.vw().vf().get(65825, null);
        if (be.kS(str)) {
            return false;
        }
        if (str.equals("0")) {
            return false;
        }
        try {
            if (be.d(Long.valueOf(be.getLong(str, 0))) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean yi() {
        return (xQ() & 1) == 0;
    }

    public static boolean yj() {
        return (xJ() & 131072) == 0;
    }

    public static int yk() {
        g.vx();
        return be.a((Integer) g.vw().vf().get(8201, null), 22);
    }

    public static int yl() {
        g.vx();
        return be.a((Integer) g.vw().vf().get(8208, null), 8);
    }

    public static u ym() {
        a LX = ((d) g.f(d.class)).wH().LX(xF());
        if (LX != null && ((int) LX.chr) > 0) {
            return LX;
        }
        u uVar = new u();
        g.vx();
        String str = (String) g.vw().vf().get(2, null);
        g.vx();
        String str2 = (String) g.vw().vf().get(4, null);
        uVar.setUsername(str);
        uVar.bS(str2);
        ((d) g.f(d.class)).wH().N(uVar);
        return ((d) g.f(d.class)).wH().LX(str);
    }

    public static b o(int i, String str) {
        b mVar;
        switch (i) {
            case 2:
                mVar = new m(str, 1);
                break;
            case android.support.v7.a.a.k.MG /*18*/:
                mVar = new m(str, 2);
                break;
            default:
                mVar = null;
                break;
        }
        ((d) g.f(d.class)).wG().b(mVar);
        return mVar;
    }

    public static boolean yn() {
        g.vx();
        return new o(be.f((Integer) g.vw().vf().get(9, null))).longValue() != 0;
    }

    public static boolean a(String str, String str2, boolean z) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
            return false;
        } else if (str2 != null && str2.length() > 0 && (u.LH(str2) || u.LJ(str2))) {
            return false;
        } else {
            boolean z2;
            double d;
            double d2;
            Options options = new Options();
            if (str == null || str.length() == 0) {
                v.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
            } else {
                if (e.aQ(str) < 65536) {
                    z2 = true;
                } else {
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
                    d = (double) options.outWidth;
                    double d3 = (double) options.outHeight;
                    if (d < 100.0d && d3 < 100.0d) {
                        v.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d + ", height = " + d3);
                        z2 = true;
                    }
                }
                if (z2) {
                    d = (double) options.outWidth;
                    d2 = (double) options.outHeight;
                    if (d / d2 < 2.5d || d2 / d >= 2.5d) {
                        v.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > 2.5");
                        return true;
                    } else if (z) {
                        return false;
                    } else {
                        return true;
                    }
                }
                v.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
                return true;
            }
            z2 = false;
            if (z2) {
                d = (double) options.outWidth;
                d2 = (double) options.outHeight;
                if (d / d2 < 2.5d) {
                }
                v.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > 2.5");
                return true;
            }
            v.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
            return true;
        }
    }

    public static void a(int i, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[]{entry.getKey(), entry.getValue()}));
        }
        g.vx();
        if (g.vw() != null) {
            g.vx();
            if (g.vw().vf() != null) {
                g.vx();
                g.vw().vf().set(327682, stringBuilder.toString());
            }
        }
    }

    public static void b(int i, Map<String, String> map) {
        map.clear();
        g.vx();
        if (g.vw() != null) {
            g.vx();
            if (g.vw().vf() != null) {
                g.vx();
                String str = (String) g.vw().vf().get(327682, null);
                if (str != null) {
                    String[] split = str.split("\n");
                    if (split.length % 2 != 0) {
                        v.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(split.length));
                        return;
                    }
                    for (int i2 = 0; i2 < split.length; i2 += 2) {
                        map.put(split[i2], split[i2 + 1]);
                    }
                    return;
                }
                return;
            }
        }
        v.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
    }

    public static Boolean yo() {
        if (g.uz()) {
            g.vx();
            String str = (String) g.vw().vf().get(6, null);
            g.vx();
            if (!Boolean.valueOf(be.c((Boolean) g.vw().vf().get(340241, null))).booleanValue() || be.kS(str)) {
                return Boolean.valueOf(false);
            }
            String str2 = "86";
            if (str.startsWith("+")) {
                str = al.vl(str);
            } else {
                str = str2;
            }
            if (str == "86") {
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(true);
        }
        v.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
        return Boolean.valueOf(false);
    }
}
