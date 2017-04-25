package com.tencent.mm.plugin.wenote.d;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.g;
import com.tencent.mm.bj.a;
import com.tencent.mm.e.a.hp;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wenote.b.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;

public final class b implements e {
    public static HashMap<String, String> luF = new HashMap();
    public static HashMap<String, d> luG = new HashMap();
    public static HashMap<String, String> luH = new HashMap();
    public static b luI = null;

    public static String FX(String str) {
        String str2 = a.bLQ() + "/" + g.m((str.toString()).getBytes());
        if (com.tencent.mm.a.e.aR(str2)) {
            return str2;
        }
        Options JS = com.tencent.mm.sdk.platformtools.d.JS(str);
        if (JS == null || JS.outWidth <= 0 || JS.outHeight <= 0) {
            v.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
            return null;
        }
        int i = JS.outHeight;
        int i2 = JS.outWidth;
        while (i2 * i > 2764800) {
            i2 >>= 1;
            i >>= 1;
        }
        com.tencent.mm.sdk.platformtools.d.b(str, i, i2, CompressFormat.JPEG, 80, str2);
        return str2;
    }

    public static String a(d dVar) {
        com.tencent.mm.pluginsdk.location.b bVar = new com.tencent.mm.pluginsdk.location.b(-1, dVar.bhs, dVar.cNt, dVar.bhu, 1);
        hp hpVar = new hp();
        hpVar.bho.bhs = dVar.bhs;
        hpVar.bho.bht = dVar.cNt;
        hpVar.bho.bhu = dVar.bhu;
        hpVar.bho.bhq = 1;
        com.tencent.mm.sdk.c.a.nhr.z(hpVar);
        String str = hpVar.bhp.path;
        String str2 = a.bLO() + "/" + g.m((bVar.toString()).getBytes()) + ".png";
        String substring = str.substring(str.lastIndexOf(95) + 1);
        if (!com.tencent.mm.a.e.aR(str2)) {
            if (com.tencent.mm.a.e.aR(str)) {
                new com.tencent.mm.plugin.wenote.b.a().blV();
                com.tencent.mm.plugin.wenote.b.a.d(dVar.ltV, dVar.ltW, str, a.bLO() + "/", substring);
            } else {
                if (luI == null) {
                    luI = new b();
                }
                ak.vy().a(648, luI);
                hp hpVar2 = new hp();
                hpVar2.bho.bhs = dVar.bhs;
                hpVar2.bho.bht = dVar.cNt;
                hpVar2.bho.bhu = dVar.bhu;
                hpVar2.bho.height = 450;
                hpVar2.bho.width = 600;
                hpVar2.bho.filename = str;
                hpVar2.bho.bhq = 2;
                com.tencent.mm.sdk.c.a.nhr.z(hpVar2);
                luG.put(str, dVar);
                luF.put(str, str2);
            }
        }
        return str2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 648) {
            try {
                Thread.sleep(100);
            } catch (Throwable e) {
                v.a("MicroMsg.WNNoteUtil", e, "", new Object[0]);
            }
            hp hpVar = new hp();
            hpVar.bho.aZJ = kVar;
            hpVar.bho.bhq = 3;
            com.tencent.mm.sdk.c.a.nhr.z(hpVar);
            String str2 = hpVar.bhp.path;
            if (be.kS(str2)) {
                v.e("MicroMsg.WNNoteUtil", "netSceneGetLocalPath is null");
            } else if (!luF.containsKey(str2)) {
            } else {
                if (i == 0 && i2 == 0) {
                    if (!com.tencent.mm.a.e.aR((String) luF.get(str2))) {
                        d dVar = (d) luG.get(str2);
                        new com.tencent.mm.plugin.wenote.b.a().blV();
                        com.tencent.mm.plugin.wenote.b.a.d(dVar.ltV, dVar.ltW, str2, a.bLO() + "/", str2.substring(str2.lastIndexOf(95) + 1));
                    }
                    luF.remove(str2);
                    v.i("MicroMsg.WNNoteUtil", "get filepath:suc");
                    return;
                }
                v.e("MicroMsg.WNNoteUtil", "get filepath:err");
            }
        }
    }
}
