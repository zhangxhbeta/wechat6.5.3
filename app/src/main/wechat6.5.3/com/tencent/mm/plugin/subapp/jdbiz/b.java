package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.j.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class b implements h {
    public String blu = SQLiteDatabase.KeyEmpty;
    public long dby = 0;
    public String iconUrl = SQLiteDatabase.KeyEmpty;
    public String jumpUrl = SQLiteDatabase.KeyEmpty;
    public String keU = SQLiteDatabase.KeyEmpty;
    public String keV = SQLiteDatabase.KeyEmpty;
    public boolean keW = false;
    public boolean keX = false;
    public String keY = SQLiteDatabase.KeyEmpty;
    public String keZ = SQLiteDatabase.KeyEmpty;
    public long kfa;
    public long kfb;
    public long kfc;
    public long kfd;
    public String kfe = SQLiteDatabase.KeyEmpty;
    public String kff = SQLiteDatabase.KeyEmpty;
    public String kfg = SQLiteDatabase.KeyEmpty;
    public String kfh = SQLiteDatabase.KeyEmpty;
    public long startTime;
    public String title = SQLiteDatabase.KeyEmpty;

    public static b aZb() {
        ak.yW();
        String str = (String) c.vf().get(327942, SQLiteDatabase.KeyEmpty);
        b bVar = new b();
        v.i("MicroMsg.JdMsgContent", " create xml : " + str);
        bVar.Bc(str);
        return bVar;
    }

    public final void Bc(String str) {
        this.keU = SQLiteDatabase.KeyEmpty;
        this.keV = SQLiteDatabase.KeyEmpty;
        this.dby = 0;
        this.keY = SQLiteDatabase.KeyEmpty;
        this.keW = false;
        this.keX = false;
        this.kff = SQLiteDatabase.KeyEmpty;
        this.kfg = SQLiteDatabase.KeyEmpty;
        this.kfh = SQLiteDatabase.KeyEmpty;
        this.kfe = SQLiteDatabase.KeyEmpty;
        this.jumpUrl = SQLiteDatabase.KeyEmpty;
        this.blu = SQLiteDatabase.KeyEmpty;
        this.blu = str;
        if (!be.kS(str)) {
            v.i("MicroMsg.JdMsgContent", "feed xml %s", str);
            Map q = bf.q(str, "sysmsg");
            if (q != null) {
                this.keU = be.ah((String) q.get(".sysmsg.biztype"), SQLiteDatabase.KeyEmpty);
                this.kfe = be.ah((String) q.get(".sysmsg.alert"), SQLiteDatabase.KeyEmpty);
                this.keV = be.ah((String) q.get(".sysmsg.activityid"), SQLiteDatabase.KeyEmpty);
                this.startTime = be.KM((String) q.get(".sysmsg.starttime"));
                this.dby = be.KM((String) q.get(".sysmsg.expiretime"));
                this.title = be.ah((String) q.get(".sysmsg.content.title"), SQLiteDatabase.KeyEmpty);
                this.iconUrl = be.ah((String) q.get(".sysmsg.content.icon"), SQLiteDatabase.KeyEmpty);
                this.jumpUrl = be.ah((String) q.get(".sysmsg.content.jumpurl"), SQLiteDatabase.KeyEmpty);
                this.kfa = be.KM((String) q.get(".sysmsg.content.urlstarttime"));
                this.kfb = be.KM((String) q.get(".sysmsg.content.urlexpiretime"));
                this.keY = be.ah((String) q.get(".sysmsg.content.jdcelltitle"), SQLiteDatabase.KeyEmpty);
                this.keZ = be.ah((String) q.get(".sysmsg.content.jdcellicon"), SQLiteDatabase.KeyEmpty);
                this.kfc = be.KM((String) q.get(".sysmsg.content.titlestarttime"));
                this.kfd = be.KM((String) q.get(".sysmsg.content.titleexpiretime"));
                this.keW = "1".equals(q.get(".sysmsg.content.findshowreddot"));
                this.keX = "1".equals(q.get(".sysmsg.content.jdcellshowred"));
                this.kff = be.ah((String) q.get(".sysmsg.content.alertviewtitle"), SQLiteDatabase.KeyEmpty);
                this.kfg = be.ah((String) q.get(".sysmsg.content.alertviewconfirm"), SQLiteDatabase.KeyEmpty);
                this.kfh = be.ah((String) q.get(".sysmsg.content.alertviewcancel"), SQLiteDatabase.KeyEmpty);
            }
        }
    }

    public final boolean Iz() {
        return this.startTime < System.currentTimeMillis() / 1000;
    }

    public final boolean aZc() {
        return this.dby != 0 && this.dby < System.currentTimeMillis() / 1000;
    }

    public final boolean a(b bVar) {
        if (bVar != null && be.ah(this.keV, SQLiteDatabase.KeyEmpty).equals(be.ah(bVar.keV, SQLiteDatabase.KeyEmpty))) {
            return false;
        }
        return true;
    }

    public final String Wb() {
        return be.ah(this.blu, SQLiteDatabase.KeyEmpty);
    }

    public final String aZd() {
        return this.keV;
    }

    public final String aZe() {
        return this.keY;
    }

    public final boolean aZf() {
        return this.keX;
    }

    public final String aZg() {
        return this.keU;
    }

    public final String aZh() {
        return this.jumpUrl;
    }
}
