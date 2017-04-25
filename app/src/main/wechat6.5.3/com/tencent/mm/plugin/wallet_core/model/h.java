package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.b.bw;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class h extends bw {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[7];
        aVar.bXK = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "title";
        aVar.nmd.put("title", "TEXT PRIMARY KEY ");
        stringBuilder.append(" title TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "title";
        aVar.bXK[1] = "loan_jump_url";
        aVar.nmd.put("loan_jump_url", "TEXT");
        stringBuilder.append(" loan_jump_url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "red_dot_index";
        aVar.nmd.put("red_dot_index", "INTEGER");
        stringBuilder.append(" red_dot_index INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "is_show_entry";
        aVar.nmd.put("is_show_entry", "INTEGER");
        stringBuilder.append(" is_show_entry INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "tips";
        aVar.nmd.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "is_overdue";
        aVar.nmd.put("is_overdue", "INTEGER");
        stringBuilder.append(" is_overdue INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "available_otb";
        aVar.nmd.put("available_otb", "TEXT");
        stringBuilder.append(" available_otb TEXT");
        aVar.bXK[7] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
