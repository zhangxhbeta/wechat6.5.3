package com.tencent.mm.modelstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.b;
import com.tencent.mm.sdk.platformtools.ar.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashSet;
import junit.framework.Assert;

public final class l extends g implements c<Integer, j> {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS netstat ( id INTEGER PRIMARY KEY, peroid INT, textCountIn INT, textBytesIn INT, imageCountIn INT, imageBytesIn INT, voiceCountIn INT, voiceBytesIn INT, videoCountIn INT, videoBytesIn INT, mobileBytesIn INT, wifiBytesIn INT, sysMobileBytesIn INT, sysWifiBytesIn INT, textCountOut INT, textBytesOut INT, imageCountOut INT, imageBytesOut INT, voiceCountOut INT, voiceBytesOut INT, videoCountOut INT, videoBytesOut INT, mobileBytesOut INT, wifiBytesOut INT, sysMobileBytesOut INT, sysWifiBytesOut INT, reserved1 INT, reserved2 INT, reserved3 TEXT, realMobileBytesIn INT, realWifiBytesIn INT, realMobileBytesOut INT, realWifiBytesOut INT) ", "CREATE INDEX IF NOT EXISTS  statInfoIndex ON netstat ( peroid ) "};
    private static final String[] ddp = new String[]{"realMobileBytesIn", "realWifiBytesIn", "realMobileBytesOut", "realWifiBytesOut"};
    public com.tencent.mm.bg.g cuX;
    private long ddm;
    public ar<Integer, j> ddn = new ar(this, ak.vA().htb.getLooper(), 30, 2, 300000, 60000);
    private long ddo;

    public l(com.tencent.mm.bg.g gVar) {
        int i = 0;
        this.cuX = gVar;
        HashSet hashSet = new HashSet();
        for (Object add : ddp) {
            hashSet.add(add);
        }
        Cursor rawQuery = this.cuX.rawQuery("PRAGMA table_info(netstat);", null);
        int columnIndex = rawQuery.getColumnIndex("name");
        while (rawQuery.moveToNext()) {
            hashSet.remove(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        String[] strArr = ddp;
        columnIndex = strArr.length;
        while (i < columnIndex) {
            String str = strArr[i];
            if (hashSet.contains(str)) {
                this.cuX.dF("netstat", "ALTER TABLE netstat ADD COLUMN " + str + " INT;");
            }
            i++;
        }
        this.ddo = System.currentTimeMillis();
    }

    public final j gm(int i) {
        j jVar = (j) this.ddn.get(Integer.valueOf(i));
        if (jVar == null) {
            Cursor query = this.cuX.query("netstat", null, "peroid = " + i, null, null, null, null);
            if (query.moveToFirst()) {
                jVar = new j();
                jVar.b(query);
            }
            query.close();
            if (jVar != null) {
                this.ddn.q(Integer.valueOf(i), jVar);
                return jVar;
            }
            ar arVar = this.ddn;
            Integer valueOf = Integer.valueOf(i);
            j jVar2 = new j();
            jVar2.bkU = 0;
            jVar2.id = 0;
            jVar2.dcz = 0;
            jVar2.dcA = 0;
            jVar2.dcB = 0;
            jVar2.dcC = 0;
            jVar2.dcD = 0;
            jVar2.dcE = 0;
            jVar2.dcF = 0;
            jVar2.dcG = 0;
            jVar2.dcH = 0;
            jVar2.dcI = 0;
            jVar2.dcJ = 0;
            jVar2.dcK = 0;
            jVar2.dcL = 0;
            jVar2.dcM = 0;
            jVar2.dcN = 0;
            jVar2.dcO = 0;
            jVar2.dcP = 0;
            jVar2.dcQ = 0;
            jVar2.dcR = 0;
            jVar2.dcS = 0;
            jVar2.dcT = 0;
            jVar2.dcU = 0;
            jVar2.dcV = 0;
            jVar2.dcW = 0;
            jVar2.dcX = 0;
            jVar2.dcY = 0;
            jVar2.dcZ = 0;
            jVar2.dda = 0;
            jVar2.ddb = 0;
            arVar.q(valueOf, jVar2);
            return jVar;
        } else if (jVar.dcz != i) {
            return null;
        } else {
            return jVar;
        }
    }

    public final void a(j jVar) {
        Assert.assertNotNull(jVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (jVar.dcz <= 0) {
            jVar.dcz = (int) (currentTimeMillis / 86400000);
        }
        if (jVar.dcz > 0) {
            j gm = gm(jVar.dcz);
            if (gm == null || jVar.dcz != gm.dcz) {
                jVar.bkU |= 2;
                jVar.id = -1;
                if (gm != null) {
                    v.i("MicroMsg.NetStat", gm.toString());
                } else {
                    v.i("MicroMsg.NetStat", "NetStat started.");
                }
            } else {
                jVar.bkU = gm.bkU | 1;
                jVar.dcA += gm.dcB;
                jVar.dcB += gm.dcB;
                jVar.dcC += gm.dcD;
                jVar.dcD += gm.dcD;
                jVar.dcE += gm.dcE;
                jVar.dcF += gm.dcF;
                jVar.dcG += gm.dcG;
                jVar.dcH += gm.dcH;
                jVar.dcI += gm.dcI;
                jVar.dcJ += gm.dcJ;
                jVar.dcK += gm.dcK;
                jVar.dcL += gm.dcL;
                jVar.dcM += gm.dcN;
                jVar.dcN += gm.dcN;
                jVar.dcO += gm.dcP;
                jVar.dcP += gm.dcP;
                jVar.dcQ += gm.dcQ;
                jVar.dcR += gm.dcR;
                jVar.dcS += gm.dcS;
                jVar.dcT += gm.dcT;
                jVar.dcU += gm.dcU;
                jVar.dcV += gm.dcV;
                jVar.dcW += gm.dcW;
                jVar.dcX += gm.dcX;
                jVar.dcY += gm.dcY;
                jVar.dcZ += gm.dcZ;
                jVar.dda += gm.dda;
                jVar.ddb += gm.ddb;
                if (jVar.dcI <= 4096 && jVar.dcJ <= 4096 && jVar.dcU <= 4096) {
                    int i = jVar.dcV;
                }
                jVar.id = gm.id;
                if (currentTimeMillis - this.ddo > 300000) {
                    v.i("MicroMsg.NetStat", jVar.toString());
                }
                b(jVar);
            }
            this.ddo = currentTimeMillis;
            b(jVar);
        }
    }

    public final boolean b(j jVar) {
        Assert.assertNotNull(jVar);
        Assert.assertTrue(jVar.dcz > 0);
        return this.ddn.q(Integer.valueOf(jVar.dcz), jVar);
    }

    public final long Kd() {
        this.ddn.iy(true);
        int buk = (int) (be.buk() / 86400000);
        Cursor rawQuery = this.cuX.rawQuery("SELECT peroid FROM netstat  WHERE peroid > " + ((int) ((be.Ni() - 1296000000) / 86400000)) + " order by peroid limit 1", null);
        if (rawQuery.moveToFirst()) {
            buk = rawQuery.getInt(rawQuery.getColumnIndex("peroid"));
        }
        rawQuery.close();
        return ((long) buk) * 86400000;
    }

    public final j gn(int i) {
        j jVar = null;
        this.ddn.iy(true);
        Cursor rawQuery = this.cuX.rawQuery("SELECT MAX( id), MAX( peroid), SUM( textCountIn), SUM( textBytesIn), SUM( imageCountIn), SUM( imageBytesIn), SUM( voiceCountIn), SUM( voiceBytesIn), SUM( videoCountIn), SUM( videoBytesIn), SUM( mobileBytesIn), SUM( wifiBytesIn), SUM( sysMobileBytesIn), SUM( sysWifiBytesIn), SUM( textCountOut), SUM( textBytesOut), SUM( imageCountOut), SUM( imageBytesOut), SUM( voiceCountOut), SUM( voiceBytesOut), SUM( videoCountOut), SUM( videoBytesOut), SUM( mobileBytesOut), SUM( wifiBytesOut), SUM( sysMobileBytesOut), SUM( sysWifiBytesOut ), SUM( realMobileBytesIn ), SUM( realWifiBytesIn ), SUM( realMobileBytesOut ), SUM( realWifiBytesOut ) FROM netstat WHERE peroid >= " + i, null);
        if (rawQuery.moveToFirst()) {
            jVar = new j();
            jVar.b(rawQuery);
        }
        rawQuery.close();
        return jVar;
    }

    public final boolean Ke() {
        if (this.cuX.inTransaction()) {
            v.i("MicroMsg.NetStat", "summer preAppend inTransaction return false");
            return false;
        }
        this.ddm = this.cuX.er(Thread.currentThread().getId());
        if (this.ddm > 0) {
            return true;
        }
        v.i("MicroMsg.NetStat", "summer preAppend ticket: " + this.ddm + " return false");
        return false;
    }

    public final void a(ar<Integer, j> arVar, b<Integer, j> bVar) {
        int i = bVar.nkN;
        j jVar = (j) bVar.values;
        if (jVar != null && i == 1) {
            i = jVar.dcz;
            int i2 = jVar.id;
            if (i > 0) {
                ContentValues contentValues = new ContentValues();
                if ((jVar.bkU & 2) != 0) {
                    contentValues.put("peroid", Integer.valueOf(jVar.dcz));
                }
                if ((jVar.bkU & 4) != 0) {
                    contentValues.put("textCountIn", Integer.valueOf(jVar.dcA));
                }
                if ((jVar.bkU & 8) != 0) {
                    contentValues.put("textBytesIn", Integer.valueOf(jVar.dcB));
                }
                if ((jVar.bkU & 16) != 0) {
                    contentValues.put("imageCountIn", Integer.valueOf(jVar.dcC));
                }
                if ((jVar.bkU & 32) != 0) {
                    contentValues.put("imageBytesIn", Integer.valueOf(jVar.dcD));
                }
                if ((jVar.bkU & 64) != 0) {
                    contentValues.put("voiceCountIn", Integer.valueOf(jVar.dcE));
                }
                if ((jVar.bkU & FileUtils.S_IWUSR) != 0) {
                    contentValues.put("voiceBytesIn", Integer.valueOf(jVar.dcF));
                }
                if ((jVar.bkU & FileUtils.S_IRUSR) != 0) {
                    contentValues.put("videoCountIn", Integer.valueOf(jVar.dcG));
                }
                if ((jVar.bkU & 512) != 0) {
                    contentValues.put("videoBytesIn", Integer.valueOf(jVar.dcH));
                }
                if ((jVar.bkU & 1024) != 0) {
                    contentValues.put("mobileBytesIn", Integer.valueOf(jVar.dcI));
                }
                if ((jVar.bkU & 2048) != 0) {
                    contentValues.put("wifiBytesIn", Integer.valueOf(jVar.dcJ));
                }
                if ((jVar.bkU & 4096) != 0) {
                    contentValues.put("sysMobileBytesIn", Integer.valueOf(jVar.dcK));
                }
                if ((jVar.bkU & 8192) != 0) {
                    contentValues.put("sysWifiBytesIn", Integer.valueOf(jVar.dcL));
                }
                if ((jVar.bkU & 16384) != 0) {
                    contentValues.put("textCountOut", Integer.valueOf(jVar.dcM));
                }
                if ((jVar.bkU & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
                    contentValues.put("textBytesOut", Integer.valueOf(jVar.dcN));
                }
                if ((jVar.bkU & 65536) != 0) {
                    contentValues.put("imageCountOut", Integer.valueOf(jVar.dcO));
                }
                if ((jVar.bkU & 131072) != 0) {
                    contentValues.put("imageBytesOut", Integer.valueOf(jVar.dcP));
                }
                if ((jVar.bkU & 262144) != 0) {
                    contentValues.put("voiceCountOut", Integer.valueOf(jVar.dcQ));
                }
                if ((jVar.bkU & 524288) != 0) {
                    contentValues.put("voiceBytesOut", Integer.valueOf(jVar.dcR));
                }
                if ((jVar.bkU & 1048576) != 0) {
                    contentValues.put("videoCountOut", Integer.valueOf(jVar.dcS));
                }
                if ((jVar.bkU & 2097152) != 0) {
                    contentValues.put("videoBytesOut", Integer.valueOf(jVar.dcT));
                }
                if ((jVar.bkU & 4194304) != 0) {
                    contentValues.put("mobileBytesOut", Integer.valueOf(jVar.dcU));
                }
                if ((jVar.bkU & 8388608) != 0) {
                    contentValues.put("wifiBytesOut", Integer.valueOf(jVar.dcV));
                }
                if ((jVar.bkU & 16777216) != 0) {
                    contentValues.put("sysMobileBytesOut", Integer.valueOf(jVar.dcW));
                }
                if ((jVar.bkU & 33554432) != 0) {
                    contentValues.put("sysWifiBytesOut", Integer.valueOf(jVar.dcX));
                }
                if ((jVar.bkU & 67108864) != 0) {
                    contentValues.put("realMobileBytesIn", Integer.valueOf(jVar.dcY));
                }
                if ((jVar.bkU & 134217728) != 0) {
                    contentValues.put("realWifiBytesIn", Integer.valueOf(jVar.dcZ));
                }
                if ((jVar.bkU & SQLiteDatabase.CREATE_IF_NECESSARY) != 0) {
                    contentValues.put("realMobileBytesOut", Integer.valueOf(jVar.dda));
                }
                if ((jVar.bkU & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) {
                    contentValues.put("realWifiBytesOut", Integer.valueOf(jVar.ddb));
                }
                if (i2 < 0) {
                    jVar.id = (int) this.cuX.insert("netstat", "id", contentValues);
                } else {
                    this.cuX.update("netstat", contentValues, "peroid=" + i, null);
                }
            }
        }
    }

    public final void Kf() {
        if (this.ddm > 0) {
            this.cuX.es(this.ddm);
        }
    }
}
