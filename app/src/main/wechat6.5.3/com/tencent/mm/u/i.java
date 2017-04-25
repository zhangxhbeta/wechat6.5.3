package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;
import junit.framework.Assert;

public final class i extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )"};
    com.tencent.mm.bg.g cuX;
    final f<String, h> cyG = new f(800);

    public i(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final h gQ(String str) {
        h hVar = (h) this.cyG.get(str);
        if (hVar != null && hVar.getUsername().equals(str)) {
            return hVar;
        }
        Cursor rawQuery = this.cuX.rawQuery("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + be.lZ(str) + "\"", null);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            hVar = new h();
            hVar.b(rawQuery);
        } else {
            hVar = null;
        }
        rawQuery.close();
        this.cyG.k(str, hVar);
        return hVar;
    }

    public final boolean a(h hVar) {
        boolean z;
        v.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", hVar.Bf(), hVar.Be());
        if (gQ(hVar.getUsername()) == null) {
            this.cyG.k(hVar.getUsername(), hVar);
            if (hVar == null || hVar.getUsername() == null) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(z);
            hVar.cyB = (int) (System.currentTimeMillis() / 1000);
            hVar.Bg();
            hVar.bkU = -1;
            z = ((int) this.cuX.insert("img_flag", "username", hVar.Bd())) >= 0;
            if (z) {
                a(hVar.getUsername(), 2, hVar.getUsername());
            }
        } else {
            v.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", gQ(hVar.getUsername()).Bf(), gQ(hVar.getUsername()).Be());
            this.cyG.remove(hVar.getUsername());
            z = (hVar == null || hVar.getUsername() == null) ? false : true;
            Assert.assertTrue(z);
            hVar.cyB = (int) (System.currentTimeMillis() / 1000);
            hVar.bkU |= 4;
            z = this.cuX.update("img_flag", hVar.Bd(), "username=?", new String[]{new StringBuilder().append(hVar.getUsername()).toString()}) > 0;
            if (z) {
                a(hVar.getUsername(), 3, hVar.getUsername());
            }
        }
        return z;
    }

    public final boolean z(List<h> list) {
        if (list.size() == 0) {
            return false;
        }
        boolean z;
        long er = this.cuX.er(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                a((h) list.get(i));
                i++;
            } catch (Exception e) {
                v.e("MicroMsg.ImgFlagStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.cuX.es(er);
        return z;
    }

    public final void gR(String str) {
        if (!be.kS(str)) {
            this.cyG.remove(str);
            this.cuX.delete("img_flag", "username=?", new String[]{str});
        }
    }
}
