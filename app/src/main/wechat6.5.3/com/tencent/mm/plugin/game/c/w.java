package com.tencent.mm.plugin.game.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public final class w extends f<v> {
    public static final String[] cic = new String[]{f.a(v.chq, "GamePBCache")};

    public w(d dVar) {
        super(dVar, v.chq, "GamePBCache", null);
    }

    public final byte[] uf(String str) {
        if (be.kS(str) || !u.bsY().equals(aa.getContext().getSharedPreferences("game_center_pref", 0).getString("game_center_pref_lang", u.bsY()))) {
            return null;
        }
        v vVar = new v();
        vVar.field_key = str;
        if (super.b(vVar, new String[0])) {
            return vVar.field_value;
        }
        return null;
    }

    public final boolean a(String str, a aVar) {
        boolean z = false;
        if (be.kS(str) || aVar == null) {
            return z;
        }
        try {
            return n(str, aVar.toByteArray());
        } catch (IOException e) {
            v.e("MicroMsg.GamePBCacheStorage", "Saving Failed: %s", new Object[]{e.getMessage()});
            return z;
        }
    }

    public final boolean n(String str, byte[] bArr) {
        boolean z = false;
        if (!(bArr == null || bArr.length == 0)) {
            v vVar = new v();
            vVar.field_key = str;
            if (super.b(vVar, new String[0])) {
                vVar.field_value = bArr;
                z = super.a(vVar, new String[0]);
            } else {
                vVar.field_value = bArr;
                z = super.b(vVar);
            }
            if (!z) {
                v.e("MicroMsg.GamePBCacheStorage", "Saving cache failed (update or insert)");
            }
        }
        return z;
    }
}
