package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.e.b.e;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c extends e {
    protected static a chq;
    protected static Map<String, b> jBJ = new ConcurrentHashMap();
    protected static Map<String, a> jBK = new ConcurrentHashMap();
    public String jBH = null;
    protected int jBI;

    static {
        a aVar = new a();
        aVar.ddU = new Field[20];
        aVar.bXK = new String[21];
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
        stringBuilder.append(", ");
        aVar.bXK[14] = "adinfo";
        aVar.nmd.put("adinfo", "TEXT");
        stringBuilder.append(" adinfo TEXT");
        stringBuilder.append(", ");
        aVar.bXK[15] = "adxml";
        aVar.nmd.put("adxml", "TEXT");
        stringBuilder.append(" adxml TEXT");
        stringBuilder.append(", ");
        aVar.bXK[16] = "createAdTime";
        aVar.nmd.put("createAdTime", "INTEGER");
        stringBuilder.append(" createAdTime INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[17] = "exposureTime";
        aVar.nmd.put("exposureTime", "INTEGER");
        stringBuilder.append(" exposureTime INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[18] = "firstControlTime";
        aVar.nmd.put("firstControlTime", "INTEGER");
        stringBuilder.append(" firstControlTime INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[19] = "recxml";
        aVar.nmd.put("recxml", "TEXT");
        stringBuilder.append(" recxml TEXT");
        aVar.bXK[20] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final b aUm() {
        b bVar;
        if (this.field_adxml == null) {
            bVar = null;
        } else if (jBJ.containsKey(this.field_adxml)) {
            return (b) jBJ.get(this.field_adxml);
        } else {
            bVar = new b(this.field_adxml);
            jBJ.put(this.field_adxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final b aUn() {
        b bVar;
        if (this.field_recxml == null) {
            bVar = null;
        } else if (jBJ.containsKey(this.field_recxml)) {
            return (b) jBJ.get(this.field_recxml);
        } else {
            bVar = new b(this.field_recxml);
            jBJ.put(this.field_recxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final a aUo() {
        a aVar;
        if (this.field_adinfo == null) {
            aVar = null;
        } else if (jBK.containsKey(this.field_adinfo)) {
            return (a) jBK.get(this.field_adinfo);
        } else {
            aVar = new a(this.field_adinfo);
            jBK.put(this.field_adinfo, aVar);
        }
        return aVar == null ? new a(null) : aVar;
    }

    public final int getSource() {
        b aUn = aUn();
        return aUn == null ? 0 : aUn.juJ;
    }

    public final void b(azr com_tencent_mm_protocal_c_azr) {
        try {
            this.field_content = com_tencent_mm_protocal_c_azr.toByteArray();
        } catch (Throwable e) {
            v.a("MicroMsg.AdSnsInfo", e, "", new Object[0]);
        }
    }

    public final boolean Bo(String str) {
        try {
            this.field_content = d.ko(str).toByteArray();
            this.jBH = g.m(this.field_content) + g.m(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.AdSnsInfo", e, "", new Object[0]);
            return false;
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
        if (k.jBP.containsKey(this.jBH)) {
            com_tencent_mm_protocal_c_azr = (azr) k.jBP.get(this.jBH);
            if (com_tencent_mm_protocal_c_azr != null) {
                return com_tencent_mm_protocal_c_azr;
            }
        }
        try {
            com_tencent_mm_protocal_c_azr = (azr) new azr().az(this.field_content);
            k.jBP.put(this.jBH, com_tencent_mm_protocal_c_azr);
            return com_tencent_mm_protocal_c_azr;
        } catch (Exception e) {
            v.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
            return d.JI();
        }
    }

    public final void aC(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.jBH = g.m(this.field_content) + g.m(this.field_attrBuf);
    }

    public final void qA(int i) {
        this.field_sourceType |= i;
    }

    public final String aUq() {
        return s.A("ad_table_", this.field_snsId);
    }

    public final k aUr() {
        k kVar = new k();
        kVar.b(aUp());
        v.d("MicroMsg.AdSnsInfo", "from server xml ok %d", new Object[]{Long.valueOf(this.field_snsId)});
        kVar.jBI = this.jBI;
        kVar.field_userName = this.field_userName;
        kVar.fw(this.field_createTime);
        kVar.field_likeFlag = this.field_likeFlag;
        kVar.cY(this.field_snsId);
        kVar.field_sourceType = this.field_sourceType;
        kVar.field_content = this.field_content;
        kVar.qA(2);
        kVar.qA(32);
        kVar.field_attrBuf = this.field_attrBuf;
        azr aUp = kVar.aUp();
        aUp.gln = this.field_userName;
        kVar.field_pravited = aUp.mHR;
        kVar.aUI();
        kVar.b(aUp);
        kVar.field_type = aUp.mWq.mol;
        kVar.jBS = this;
        return kVar;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.jBI = (int) this.nmb;
    }
}
