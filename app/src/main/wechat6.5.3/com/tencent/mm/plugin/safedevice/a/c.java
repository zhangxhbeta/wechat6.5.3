package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.e.b.ch;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class c extends ch {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[4];
        aVar.bXK = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "uid";
        aVar.nmd.put("uid", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" uid TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "uid";
        aVar.bXK[1] = "name";
        aVar.nmd.put("name", "TEXT default '' ");
        stringBuilder.append(" name TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "devicetype";
        aVar.nmd.put("devicetype", "TEXT default '' ");
        stringBuilder.append(" devicetype TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "createtime";
        aVar.nmd.put("createtime", "LONG default '0' ");
        stringBuilder.append(" createtime LONG default '0' ");
        aVar.bXK[4] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public c() {
        this.field_uid = "0";
        this.field_name = "";
        this.field_devicetype = "";
        this.field_createtime = 0;
    }

    public c(arh com_tencent_mm_protocal_c_arh) {
        this.field_createtime = (long) com_tencent_mm_protocal_c_arh.hNS;
        this.field_devicetype = com_tencent_mm_protocal_c_arh.meq;
        this.field_name = com_tencent_mm_protocal_c_arh.gkB;
        this.field_uid = com_tencent_mm_protocal_c_arh.moU;
    }
}
