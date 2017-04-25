package com.tencent.mm.ar;

import com.tencent.mm.e.b.ck;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public class j extends ck {
    protected static a chq;
    protected static Field[] ddU = c.o(j.class);

    static {
        a aVar = new a();
        aVar.ddU = new Field[11];
        aVar.bXK = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "svrid";
        aVar.nmd.put("svrid", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "svrid";
        aVar.bXK[1] = "status";
        aVar.nmd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "type";
        aVar.nmd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "scene";
        aVar.nmd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "createtime";
        aVar.nmd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.bXK[5] = "talker";
        aVar.nmd.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "content";
        aVar.nmd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "sayhiuser";
        aVar.nmd.put("sayhiuser", "TEXT");
        stringBuilder.append(" sayhiuser TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "sayhicontent";
        aVar.nmd.put("sayhicontent", "TEXT");
        stringBuilder.append(" sayhicontent TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "imgpath";
        aVar.nmd.put("imgpath", "TEXT");
        stringBuilder.append(" imgpath TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "isSend";
        aVar.nmd.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        aVar.bXK[11] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
