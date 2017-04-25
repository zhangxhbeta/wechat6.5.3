package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.e.b.cr;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.pu;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import java.lang.reflect.Field;

public final class i extends cr {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[14];
        aVar.bXK = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "userName";
        aVar.nmd.put("userName", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" userName TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "userName";
        aVar.bXK[1] = "md5";
        aVar.nmd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "newerIds";
        aVar.nmd.put("newerIds", "TEXT");
        stringBuilder.append(" newerIds TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "bgId";
        aVar.nmd.put("bgId", "TEXT");
        stringBuilder.append(" bgId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "bgUrl";
        aVar.nmd.put("bgUrl", "TEXT");
        stringBuilder.append(" bgUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "older_bgId";
        aVar.nmd.put("older_bgId", "TEXT");
        stringBuilder.append(" older_bgId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "local_flag";
        aVar.nmd.put("local_flag", "INTEGER");
        stringBuilder.append(" local_flag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = "istyle";
        aVar.nmd.put("istyle", "INTEGER");
        stringBuilder.append(" istyle INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[8] = "iFlag";
        aVar.nmd.put("iFlag", "INTEGER");
        stringBuilder.append(" iFlag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "icount";
        aVar.nmd.put("icount", "INTEGER");
        stringBuilder.append(" icount INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "faultS";
        aVar.nmd.put("faultS", "BLOB");
        stringBuilder.append(" faultS BLOB");
        stringBuilder.append(", ");
        aVar.bXK[11] = "snsBgId";
        aVar.nmd.put("snsBgId", "LONG");
        stringBuilder.append(" snsBgId LONG");
        stringBuilder.append(", ");
        aVar.bXK[12] = "snsuser";
        aVar.nmd.put("snsuser", "BLOB");
        stringBuilder.append(" snsuser BLOB");
        stringBuilder.append(", ");
        aVar.bXK[13] = "adsession";
        aVar.nmd.put("adsession", "BLOB");
        stringBuilder.append(" adsession BLOB");
        aVar.bXK[14] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final void aUx() {
        this.field_local_flag &= -3;
    }

    public final boolean aUy() {
        return (this.field_local_flag & 2) > 0;
    }

    public final axg aUz() {
        try {
            return (axg) new axg().az(this.field_snsuser);
        } catch (Exception e) {
            return null;
        }
    }

    public final pu aUA() {
        rb rbVar = new rb();
        pu puVar = new pu();
        if (be.bl(this.field_faultS)) {
            return puVar;
        }
        try {
            pu puVar2;
            rbVar = (rb) new rb().az(this.field_faultS);
            if (rbVar.muQ.size() > 0) {
                puVar2 = (pu) rbVar.muQ.getFirst();
            } else {
                puVar2 = puVar;
            }
            return puVar2;
        } catch (Exception e) {
            return puVar;
        }
    }
}
