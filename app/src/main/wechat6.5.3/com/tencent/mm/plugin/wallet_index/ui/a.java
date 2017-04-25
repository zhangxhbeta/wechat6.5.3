package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {
    public static boolean a(Context context, String str, b bVar, com.tencent.mm.sdk.g.a.a aVar) {
        v.d("MicroMsg.PayCallbackHelper", "callback, packageName = " + str);
        String str2 = (aVar == null || be.kS(aVar.nhP)) ? str + ".wxapi.WXPayEntryActivity" : aVar.nhP;
        int i = (aVar == null || aVar.nhQ == -1) ? SQLiteDatabase.CREATE_IF_NECESSARY : aVar.nhQ;
        v.d("MicroMsg.PayCallbackHelper", "callback, cbPkg = " + str + ", cbCls = " + str2 + ", cbFlags(hex) = " + Integer.toHexString(i));
        Bundle bundle = new Bundle();
        bundle.putString("wx_token_key", "com.tencent.mm.openapi.token");
        if (bVar != null) {
            bVar.t(bundle);
        }
        com.tencent.mm.sdk.a.a.a aVar2 = new com.tencent.mm.sdk.a.a.a();
        aVar2.nhj = str;
        aVar2.nhk = str2;
        aVar2.nhl = bundle;
        aVar2.flags = i;
        return com.tencent.mm.sdk.a.a.a(context, aVar2);
    }
}
