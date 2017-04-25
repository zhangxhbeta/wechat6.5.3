package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.b.dg;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.reflect.Field;

public final class aa extends dg {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[14];
        aVar.bXK = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.nmd.put(OpenSDKTool4Assistant.EXTRA_UIN, "TEXT PRIMARY KEY ");
        stringBuilder.append(" uin TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.bXK[1] = "is_reg";
        aVar.nmd.put("is_reg", "INTEGER");
        stringBuilder.append(" is_reg INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "true_name";
        aVar.nmd.put("true_name", "TEXT");
        stringBuilder.append(" true_name TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "card_num";
        aVar.nmd.put("card_num", "INTEGER");
        stringBuilder.append(" card_num INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "isDomesticUser";
        aVar.nmd.put("isDomesticUser", "INTEGER");
        stringBuilder.append(" isDomesticUser INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "cre_type";
        aVar.nmd.put("cre_type", "INTEGER");
        stringBuilder.append(" cre_type INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "main_card_bind_serialno";
        aVar.nmd.put("main_card_bind_serialno", "TEXT");
        stringBuilder.append(" main_card_bind_serialno TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "ftf_pay_url";
        aVar.nmd.put("ftf_pay_url", "TEXT");
        stringBuilder.append(" ftf_pay_url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "switchConfig";
        aVar.nmd.put("switchConfig", "INTEGER");
        stringBuilder.append(" switchConfig INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "reset_passwd_flag";
        aVar.nmd.put("reset_passwd_flag", "TEXT");
        stringBuilder.append(" reset_passwd_flag TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "find_passwd_url";
        aVar.nmd.put("find_passwd_url", "TEXT");
        stringBuilder.append(" find_passwd_url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "is_open_touch";
        aVar.nmd.put("is_open_touch", "INTEGER");
        stringBuilder.append(" is_open_touch INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[12] = "lct_wording";
        aVar.nmd.put("lct_wording", "TEXT");
        stringBuilder.append(" lct_wording TEXT");
        stringBuilder.append(", ");
        aVar.bXK[13] = "lct_url";
        aVar.nmd.put("lct_url", "TEXT");
        stringBuilder.append(" lct_url TEXT");
        aVar.bXK[14] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean bgs() {
        return this.field_is_reg == 0;
    }

    public final boolean bgt() {
        return this.field_is_reg == -1;
    }
}
