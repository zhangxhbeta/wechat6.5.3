package com.tencent.mm.storage.a;

import com.tencent.mm.e.b.co;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class s extends co {
    protected static a chq;

    protected final a tl() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.ddU = new Field[10];
        aVar.bXK = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "key";
        aVar.nmd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "key";
        aVar.bXK[1] = "cnValue";
        aVar.nmd.put("cnValue", "TEXT");
        stringBuilder.append(" cnValue TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "qqValue";
        aVar.nmd.put("qqValue", "TEXT");
        stringBuilder.append(" qqValue TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "twValue";
        aVar.nmd.put("twValue", "TEXT");
        stringBuilder.append(" twValue TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "enValue";
        aVar.nmd.put("enValue", "TEXT");
        stringBuilder.append(" enValue TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "thValue";
        aVar.nmd.put("thValue", "TEXT");
        stringBuilder.append(" thValue TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "fileName";
        aVar.nmd.put("fileName", "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "eggIndex";
        aVar.nmd.put("eggIndex", "INTEGER default '-1' ");
        stringBuilder.append(" eggIndex INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = "position";
        aVar.nmd.put("position", "INTEGER default '-1' ");
        stringBuilder.append(" position INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "flag";
        aVar.nmd.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        aVar.bXK[10] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    public s(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.field_key = str;
        this.field_cnValue = str3;
        this.field_qqValue = str2;
        this.field_enValue = str5;
        this.field_thValue = str6;
        this.field_twValue = str4;
        this.field_position = i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key:").append(this.field_key).append("/n");
        stringBuilder.append("cn:").append(this.field_cnValue).append("/n");
        stringBuilder.append("qq:").append(this.field_qqValue).append("/n");
        stringBuilder.append("en:").append(this.field_enValue).append("/n");
        stringBuilder.append("th:").append(this.field_thValue).append("/n");
        stringBuilder.append("tw:").append(this.field_twValue).append("/n");
        stringBuilder.append("position:").append(this.field_position).append("/n");
        stringBuilder.append("file Name:").append(this.field_fileName).append("/n");
        stringBuilder.append("egg index:").append(this.field_eggIndex).append("/n");
        return stringBuilder.toString();
    }
}
