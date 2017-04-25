package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class e extends f<p> {
    public static final String[] cic = new String[]{f.a(p.chq, "WalletFunciontList")};
    public d cie;

    public e(d dVar) {
        super(dVar, p.chq, "WalletFunciontList", null);
        this.cie = dVar;
    }

    public final void c(int i, String str, String str2, String str3, String str4) {
        p pVar = new p();
        pVar.field_wallet_region = i;
        pVar.field_function_list = str;
        pVar.field_new_list = str2;
        pVar.field_banner_list = str3;
        pVar.field_type_name_list = str4;
        super.a(pVar);
    }
}
