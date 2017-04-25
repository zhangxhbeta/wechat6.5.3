package com.tencent.mm.plugin.recharge.a;

import android.telephony.PhoneNumberUtils;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a implements ag {
    private List<com.tencent.mm.plugin.recharge.model.a> imh = null;

    public static a aJi() {
        a aVar = (a) ak.yP().fY("plugin.recharge");
        if (aVar != null) {
            return aVar;
        }
        v.w("MicroMsg.SubCoreRecharge", "not found in MMCore, new one");
        aVar = new a();
        ak.yP().a("plugin.recharge", aVar);
        return aVar;
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
    }

    public final void th() {
    }

    public final boolean a(com.tencent.mm.plugin.recharge.model.a aVar) {
        if (aVar == null || !PhoneNumberUtils.isGlobalPhoneNumber(aVar.imk)) {
            return false;
        }
        List<com.tencent.mm.plugin.recharge.model.a> aJj = aJj();
        for (com.tencent.mm.plugin.recharge.model.a aVar2 : aJj) {
            if (aVar.imk.equals(aVar2.imk)) {
                if (be.kS(aVar.name)) {
                    aVar.name = aVar2.name;
                }
                aJj.remove(aVar2);
                aJj.add(0, aVar);
                bc(aJj);
                return true;
            }
        }
        aJj.add(0, aVar);
        bc(aJj);
        return true;
    }

    public final void bc(List<com.tencent.mm.plugin.recharge.model.a> list) {
        this.imh = list;
        if (list == null || list.size() == 0) {
            this.imh = new LinkedList();
        } else if (list.size() > 5) {
            for (int size = list.size() - 1; size >= 5; size--) {
                list.remove(size);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (com.tencent.mm.plugin.recharge.model.a aVar : this.imh) {
            stringBuilder.append(aVar.imk).append("=").append(aVar.name).append("&");
        }
        v.d("MicroMsg.SubCoreRecharge", "setMobileHistory : " + stringBuilder.toString());
        ak.yW();
        com.tencent.mm.model.c.vf().set(270337, stringBuilder.toString());
        ak.yW();
        com.tencent.mm.model.c.vf().iB(true);
    }

    public final List<com.tencent.mm.plugin.recharge.model.a> aJj() {
        if (this.imh != null) {
            return this.imh;
        }
        this.imh = new LinkedList();
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(6, null);
        ak.yW();
        String str2 = (String) com.tencent.mm.model.c.vf().get(270337, null);
        if (!be.kS(str2)) {
            String[] split = str2.split("&");
            if (split != null && split.length > 0) {
                str2 = str;
                for (int i = 0; i < Math.min(split.length, 100); i++) {
                    String[] split2 = split[i].split("=");
                    if (!be.kS(str2) && split2 != null && split2.length > 0 && str2.equals(split2[0])) {
                        str2 = null;
                    }
                    if (split2.length == 2) {
                        this.imh.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], split2[1], 2));
                    } else if (split2.length == 1) {
                        this.imh.add(new com.tencent.mm.plugin.recharge.model.a(split2[0], "", 2));
                    }
                }
                str = str2;
            }
        }
        if (!be.kS(str)) {
            this.imh.add(new com.tencent.mm.plugin.recharge.model.a(str, " ", 2));
        }
        v.d("MicroMsg.SubCoreRecharge", "getMobileHistory : " + this.imh.size());
        return this.imh;
    }
}
