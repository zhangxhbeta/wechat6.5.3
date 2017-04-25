package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.e.b.bx;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.j.ai;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class a {
    public String aZy;
    public int bgA;
    public long dby;
    public String desc;
    public long lAh;
    public int size;
    public String url;

    public static a bne() {
        ak.yW();
        String str = (String) c.vf().get(352273, SQLiteDatabase.KeyEmpty);
        if (be.kS(str)) {
            return null;
        }
        a aVar = new a(str);
        if (aVar.isValid() && !aVar.bnf()) {
            return aVar;
        }
        bng();
        return null;
    }

    public a(String str) {
        Map q = bf.q(str, "msg");
        this.desc = (String) q.get(".msg.appmsg.des");
        this.bgA = be.getInt((String) q.get(".msg.alphainfo.clientVersion"), 0);
        this.url = (String) q.get(".msg.alphainfo.url");
        this.size = be.getInt((String) q.get(".msg.alphainfo.size"), 0);
        this.aZy = (String) q.get(".msg.alphainfo.md5");
        this.lAh = be.getLong((String) q.get(".msg.alphainfo.maxAge"), 0);
        this.dby = be.getLong((String) q.get(".msg.alphainfo.expireTime"), 0);
        v.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", str, Integer.valueOf(this.bgA), this.url, Integer.valueOf(this.size), this.aZy, this.desc, Long.valueOf(this.lAh), Long.valueOf(this.dby));
    }

    private boolean isValid() {
        boolean z;
        if (this.bgA <= d.lWh || be.kS(this.url) || be.kS(this.aZy) || be.kS(this.desc)) {
            z = false;
        } else {
            z = true;
        }
        v.i("MicroMsg.AlphaUpdateInfo", "isValid %b", Boolean.valueOf(z));
        return z;
    }

    private boolean bnf() {
        boolean z;
        ak.yW();
        if (System.currentTimeMillis() - ((Long) c.vf().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue() > this.lAh || System.currentTimeMillis() > this.dby) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", Boolean.valueOf(z));
        return z;
    }

    public static void bng() {
        ak.yW();
        c.vf().set(352273, null);
        ak.yW();
        c.vf().set(352274, null);
    }

    public final void bnh() {
        bx atVar = new at();
        atVar.z(aw.h("weixin", be.Nh()));
        atVar.setType(1);
        atVar.setContent(this.desc);
        v.d("MicroMsg.AlphaUpdateInfo", atVar.field_content);
        atVar.di(0);
        atVar.cH("weixin");
        atVar.dh(3);
        aw.e(atVar);
        v.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
        bng();
    }

    public final void bni() {
        v.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
        if (isValid() && !bnf()) {
            int i;
            if (be.KL(j.sU().getValue("SilentDownloadApkAtWiFi")) != 0) {
                i = 0;
            } else {
                ak.yW();
                i = (!com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext()) || ((((Integer) c.vf().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : 0) == 0) ? 0 : 1;
                if ((f.aPY & 1) != 0) {
                    v.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
                    i = 0;
                } else {
                    v.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
                }
            }
            if (i == 0) {
                bnh();
                return;
            }
            v.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", this.aZy, Integer.valueOf(this.size), this.desc, this.url);
            ai.bmA().c(this.aZy, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
        }
    }
}
