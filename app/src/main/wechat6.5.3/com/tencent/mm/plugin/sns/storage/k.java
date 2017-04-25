package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.e.b.cs;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k extends cs {
    protected static a chq;
    protected static Map<String, azr> jBP = new ConcurrentHashMap();
    protected static Map<String, aic> jBQ = new ConcurrentHashMap();
    public String jBH = null;
    public int jBI;
    public String jBR = null;
    c jBS;
    private aic jBT = null;
    private boolean jdE = false;

    static {
        a aVar = new a();
        aVar.ddU = new Field[14];
        aVar.bXK = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "snsId";
        aVar.nmd.put("snsId", "LONG");
        stringBuilder.append(" snsId LONG");
        stringBuilder.append(", ");
        aVar.bXK[1] = "userName";
        aVar.nmd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "localFlag";
        aVar.nmd.put("localFlag", "INTEGER");
        stringBuilder.append(" localFlag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "createTime";
        aVar.nmd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "head";
        aVar.nmd.put("head", "INTEGER");
        stringBuilder.append(" head INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "localPrivate";
        aVar.nmd.put("localPrivate", "INTEGER");
        stringBuilder.append(" localPrivate INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = Columns.TYPE;
        aVar.nmd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = "sourceType";
        aVar.nmd.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[8] = "likeFlag";
        aVar.nmd.put("likeFlag", "INTEGER");
        stringBuilder.append(" likeFlag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "pravited";
        aVar.nmd.put("pravited", "INTEGER");
        stringBuilder.append(" pravited INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "stringSeq";
        aVar.nmd.put("stringSeq", "TEXT");
        stringBuilder.append(" stringSeq TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "content";
        aVar.nmd.put("content", "BLOB");
        stringBuilder.append(" content BLOB");
        stringBuilder.append(", ");
        aVar.bXK[12] = "attrBuf";
        aVar.nmd.put("attrBuf", "BLOB");
        stringBuilder.append(" attrBuf BLOB");
        stringBuilder.append(", ");
        aVar.bXK[13] = "postBuf";
        aVar.nmd.put("postBuf", "BLOB");
        stringBuilder.append(" postBuf BLOB");
        aVar.bXK[14] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final aic aUD() {
        if (this.field_postBuf == null) {
            return new aic();
        }
        if (this.jBR == null) {
            this.jBR = g.m(this.field_postBuf);
        }
        if (jBQ.containsKey(this.jBR)) {
            this.jBT = (aic) jBQ.get(this.jBR);
            if (this.jBT != null) {
                return this.jBT;
            }
        }
        try {
            this.jBT = (aic) new aic().az(this.field_postBuf);
            jBQ.put(this.jBR, this.jBT);
            return this.jBT;
        } catch (Exception e) {
            v.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return new aic();
        }
    }

    public k(byte b) {
        cY(0);
    }

    public static k x(k kVar) {
        k kVar2 = new k();
        kVar2.jBI = kVar.jBI;
        kVar2.field_snsId = kVar.field_snsId;
        kVar2.field_userName = kVar.field_userName;
        kVar2.field_localFlag = kVar.field_localFlag;
        kVar2.field_createTime = kVar.field_createTime;
        kVar2.field_head = kVar.field_head;
        kVar2.field_localPrivate = kVar.field_localPrivate;
        kVar2.field_type = kVar.field_type;
        kVar2.field_sourceType = kVar.field_sourceType;
        kVar2.field_likeFlag = kVar.field_likeFlag;
        kVar2.field_pravited = kVar.field_pravited;
        kVar2.field_stringSeq = kVar.field_stringSeq;
        kVar2.field_content = kVar.field_content;
        kVar2.field_attrBuf = kVar.field_attrBuf;
        return kVar2;
    }

    public final void cY(long j) {
        this.field_snsId = j;
        if (j != 0) {
            da(j);
        }
    }

    public final String aUq() {
        if (qC(32)) {
            return s.A("ad_table_", this.field_snsId);
        }
        return s.A("sns_table_", this.field_snsId);
    }

    public final String getUserName() {
        return this.field_userName;
    }

    private static int cZ(long j) {
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date(1000 * j));
        try {
            return Integer.valueOf(format).intValue();
        } catch (Exception e) {
            v.e("MicroMsg.SnsInfo", "error valueOf  " + format);
            return (int) (j / 86400);
        }
    }

    public final void fw(int i) {
        if (i - this.field_createTime >= 180 || i - this.field_createTime < 0) {
            this.field_createTime = i;
            this.field_head = cZ((long) i);
        } else if (this.field_head == 0) {
            this.field_head = cZ((long) this.field_createTime);
        }
    }

    public final int aUE() {
        return this.field_createTime;
    }

    public final void aUF() {
        this.field_localPrivate |= 1;
    }

    public final int aUG() {
        return this.field_localPrivate;
    }

    public final boolean aUH() {
        return (this.field_localFlag & 128) > 0;
    }

    public final void aUI() {
        this.field_localFlag |= 2;
    }

    public final void aUJ() {
        this.field_localFlag &= -3;
    }

    public final boolean aUK() {
        return (this.field_localFlag & 2) > 0;
    }

    public final String aUL() {
        if (qC(32)) {
            return s.A("ad_table_", (long) this.jBI);
        }
        return s.A("sns_table_", (long) this.jBI);
    }

    public final void aC(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.jBH = g.m(this.field_content) + g.m(this.field_attrBuf);
    }

    public final void da(long j) {
        this.field_stringSeq = i.cE(j);
        this.field_stringSeq = i.zT(this.field_stringSeq);
        v.d("MicroMsg.SnsInfo", j + " stringSeq " + this.field_stringSeq);
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.jBI = (int) this.nmb;
    }

    public static synchronized void release() {
        synchronized (k.class) {
            jBP.clear();
            jBQ.clear();
        }
    }

    public final azr aUp() {
        if (this.field_content == null) {
            return d.JI();
        }
        azr com_tencent_mm_protocal_c_azr;
        if (this.jBH == null) {
            this.jBH = g.m(this.field_content) + g.m(this.field_attrBuf);
        }
        if (jBP.containsKey(this.jBH)) {
            com_tencent_mm_protocal_c_azr = (azr) jBP.get(this.jBH);
            if (com_tencent_mm_protocal_c_azr != null) {
                return com_tencent_mm_protocal_c_azr;
            }
        }
        try {
            com_tencent_mm_protocal_c_azr = (azr) new azr().az(this.field_content);
            jBP.put(this.jBH, com_tencent_mm_protocal_c_azr);
            return com_tencent_mm_protocal_c_azr;
        } catch (Exception e) {
            v.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return d.JI();
        }
    }

    public final void b(azr com_tencent_mm_protocal_c_azr) {
        try {
            this.field_content = com_tencent_mm_protocal_c_azr.toByteArray();
        } catch (Throwable e) {
            v.a("MicroMsg.SnsInfo", e, "", new Object[0]);
        }
        this.jBH = g.m(this.field_content) + g.m(this.field_attrBuf);
    }

    public final boolean Bo(String str) {
        try {
            this.field_content = d.ko(str).toByteArray();
            this.jBH = g.m(this.field_content) + g.m(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.SnsInfo", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean aUM() {
        return (this.field_localFlag & 16) > 0;
    }

    public final boolean aUN() {
        return (this.field_localFlag & 32) > 0 && this.field_snsId == 0;
    }

    public final void aUO() {
        this.field_localFlag &= -33;
    }

    public final void aUP() {
        this.field_localFlag |= 32;
    }

    public static boolean db(long j) {
        if (be.ax(j / 1000) > 1200) {
            return true;
        }
        return false;
    }

    public final boolean qC(int i) {
        return (this.field_sourceType & i) > 0;
    }

    public final void qA(int i) {
        this.field_sourceType |= i;
    }

    public final void qD(int i) {
        this.field_sourceType &= i ^ -1;
    }

    public final b aUm() {
        if (this.jBS == null) {
            this.jBS = ad.aSF().cV(this.field_snsId);
        }
        return this.jBS == null ? new b(null) : this.jBS.aUm();
    }

    public final a aUo() {
        if (this.jBS == null) {
            this.jBS = ad.aSF().cV(this.field_snsId);
        }
        return this.jBS == null ? new a(null) : this.jBS.aUo();
    }

    public final String aTz() {
        a aUo = aUo();
        return aUo == null ? "" : aUo.jup;
    }

    public final String aTA() {
        a aUo = aUo();
        return aUo == null ? "" : aUo.juo;
    }

    public final String aUQ() {
        a aUo = aUo();
        if (aUo != null) {
            return aUo.jbF;
        }
        return "";
    }

    public final String aUR() {
        a aUo = aUo();
        if (aUo != null) {
            return aUo.jpt;
        }
        return "";
    }

    public final c aUS() {
        if (this.jBS == null) {
            this.jBS = ad.aSF().cV(this.field_snsId);
        }
        this.jBS.field_createTime = this.field_createTime;
        this.jBS.field_userName = this.field_userName;
        this.jBS.field_likeFlag = this.field_likeFlag;
        this.jBS.field_attrBuf = this.field_attrBuf;
        return this.jBS;
    }

    public final boolean aUT() {
        return qC(32);
    }

    public final boolean isValid() {
        return this.field_snsId != 0;
    }

    public final boolean aSn() {
        return this.field_snsId == 0;
    }
}
