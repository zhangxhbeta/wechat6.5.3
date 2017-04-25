package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.e.b.dc;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;

public final class p extends dc {
    public static a chq;
    public ArrayList<MallFunction> hid = new ArrayList();
    private ArrayList<MallNews> hie = new ArrayList();
    private ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> hif = new ArrayList();
    public SparseArray<String> hig = new SparseArray();

    static {
        a aVar = new a();
        aVar.ddU = new Field[5];
        aVar.bXK = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "wallet_region";
        aVar.nmd.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "wallet_region";
        aVar.bXK[1] = "function_list";
        aVar.nmd.put("function_list", "TEXT");
        stringBuilder.append(" function_list TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "new_list";
        aVar.nmd.put("new_list", "TEXT");
        stringBuilder.append(" new_list TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "banner_list";
        aVar.nmd.put("banner_list", "TEXT");
        stringBuilder.append(" banner_list TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "type_name_list";
        aVar.nmd.put("type_name_list", "TEXT");
        stringBuilder.append(" type_name_list TEXT");
        aVar.bXK[5] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        String str = this.field_function_list;
        String str2 = this.field_new_list;
        String str3 = this.field_banner_list;
        String str4 = this.field_type_name_list;
        try {
            if (!be.kS(str)) {
                this.hid = b.u(new JSONArray(str));
            }
        } catch (Throwable e) {
            v.a("MicroMsg.WalletFunciontListInfo", e, "", new Object[0]);
        }
        try {
            if (!be.kS(str2)) {
                this.hie = b.r(new JSONArray(str2));
            }
        } catch (Throwable e2) {
            this.hie = null;
            v.a("MicroMsg.WalletFunciontListInfo", e2, "", new Object[0]);
        }
        try {
            if (!be.kS(str3)) {
                this.hif = b.s(new JSONArray(str3));
            }
        } catch (Throwable e22) {
            this.hif = null;
            v.a("MicroMsg.WalletFunciontListInfo", e22, "", new Object[0]);
        }
        try {
            if (!be.kS(str4)) {
                this.hig = b.t(new JSONArray(str4));
            }
        } catch (Throwable e222) {
            this.hig = null;
            v.a("MicroMsg.WalletFunciontListInfo", e222, "", new Object[0]);
        }
    }
}
