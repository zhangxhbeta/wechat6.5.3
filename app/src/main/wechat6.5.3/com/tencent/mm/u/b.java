package com.tencent.mm.u;

import android.graphics.Bitmap;
import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;

public final class b {
    public static String N(String str, String str2) {
        return str + "?access_token=" + str2;
    }

    public static Bitmap gv(String str) {
        return a(str + "@google", false, -1);
    }

    private static String gw(String str) {
        return "http://graph.facebook.com/" + str + "/picture";
    }

    public static void gx(String str) {
        if (!be.kS(str)) {
            String str2 = str + "@fb";
            h gQ = n.Bo().gQ(str2);
            if (gQ == null || !str2.equals(gQ.getUsername()) || 3 != gQ.bBY) {
                if (gQ == null) {
                    gQ = new h();
                }
                gQ.username = str2;
                gQ.bBY = 3;
                gQ.cyD = gw(str);
                gQ.cyC = gw(str);
                gQ.aP(true);
                gQ.bkU = 31;
                n.Bo().a(gQ);
            }
        }
    }

    public static Bitmap gy(String str) {
        return a(str + "@fb", false, -1);
    }

    public static long gz(String str) {
        long j = -1;
        if (u.LK(str)) {
            try {
                j = be.getLong(str.split("@")[0], -1);
            } catch (Exception e) {
            }
        }
        return j;
    }

    private static String O(long j) {
        return new o(j) + "@qqim";
    }

    public static long gA(String str) {
        long j = -1;
        if (u.LJ(str)) {
            try {
                j = be.getLong(str.split("@")[0], -1);
            } catch (Exception e) {
            }
        }
        return j;
    }

    public static boolean d(long j, int i) {
        if (i != 3) {
            return false;
        }
        return gB(O(j));
    }

    public static boolean gB(String str) {
        if (str == null) {
            v.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        } else if (str.endsWith("@qqim")) {
            h hVar = new h();
            hVar.username = str;
            hVar.bBY = 3;
            hVar.bkU = 3;
            return n.Bo().a(hVar);
        } else {
            v.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
            return false;
        }
    }

    public static Bitmap P(long j) {
        return a(O(j), false, -1);
    }

    public static boolean r(String str, int i) {
        if (be.kS(str)) {
            return false;
        }
        h gQ = n.Bo().gQ(str);
        if (gQ != null && str.equals(gQ.getUsername()) && i == gQ.bBY) {
            return true;
        }
        if (gQ == null) {
            gQ = new h();
        }
        gQ.username = str;
        gQ.bBY = i;
        gQ.bkU = 3;
        return n.Bo().a(gQ);
    }

    public static Bitmap b(String str, int i, int i2, int i3) {
        if (!be.kS(str)) {
            ak.yW();
            if (c.ww() != 0) {
                Bitmap bitmap;
                n.AX();
                v.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
                if (be.kS(str)) {
                    bitmap = null;
                } else {
                    bitmap = d.a(d.s(str, true), i, i2, null, 0, 0, 1);
                }
                if (bitmap == null) {
                    final e eVar = new e();
                    eVar.a(str, new com.tencent.mm.u.e.b() {
                        public final int aG(int i, int i2) {
                            eVar.Bb();
                            v.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                            return 0;
                        }
                    });
                    return a(str, false, i3);
                } else if (i3 > 5) {
                    return d.a(bitmap, false, (float) i3);
                } else {
                    return bitmap;
                }
            }
        }
        return null;
    }

    public static Bitmap a(String str, boolean z, int i) {
        if (!be.kS(str)) {
            ak.yW();
            if (c.ww() != 0) {
                ak.yW();
                if (!c.wy()) {
                    return n.AX().aM(aa.getContext());
                }
                if (u.ew(str)) {
                    str = u.LM(str);
                }
                return n.Bq().b(str, z, i);
            }
        }
        return null;
    }

    public static String r(String str, boolean z) {
        if (be.kS(str)) {
            return null;
        }
        ak.yW();
        if (c.ww() == 0) {
            return null;
        }
        ak.yW();
        if (!c.wy()) {
            return null;
        }
        if (u.ew(str)) {
            n.AX();
            return d.s(u.LM(str), z);
        }
        n.AX();
        return d.s(str, z);
    }

    public static void gC(String str) {
        h gQ = n.Bo().gQ(str);
        if (gQ != null && str.equals(gQ.getUsername())) {
            gQ.cyF = 0;
            gQ.bkU = 64;
            n.Bo().a(gQ);
        }
    }

    public static h a(String str, ais com_tencent_mm_protocal_c_ais) {
        h hVar = new h();
        hVar.bkU = -1;
        hVar.username = str;
        hVar.cyC = com_tencent_mm_protocal_c_ais.mlZ;
        hVar.cyD = com_tencent_mm_protocal_c_ais.mlY;
        v.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", hVar.getUsername(), hVar.Be(), hVar.Bf());
        hVar.aP(com_tencent_mm_protocal_c_ais.mIY != 0);
        if (com_tencent_mm_protocal_c_ais.mIT == 3 || com_tencent_mm_protocal_c_ais.mIT == 4) {
            hVar.bBY = com_tencent_mm_protocal_c_ais.mIT;
        } else if (com_tencent_mm_protocal_c_ais.mIT == 2) {
            hVar.bBY = 3;
            if (!k.xF().equals(str)) {
                n.AX();
                d.t(str, false);
                n.AX();
                d.t(str, true);
                n.Bq().gD(str);
            }
        }
        return hVar;
    }
}
