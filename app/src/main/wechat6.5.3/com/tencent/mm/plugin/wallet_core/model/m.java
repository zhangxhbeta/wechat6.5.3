package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class m {
    public List<ElementQuery> kLr = null;
    public SparseArray<String> kQm = null;

    public final String E(Context context, int i) {
        if (this.kQm != null) {
            String str = (String) this.kQm.get(i);
            if (!be.kS(str)) {
                return str;
            }
        }
        return context.getString(2131236070);
    }

    public final ElementQuery Da(String str) {
        if (this.kLr == null || this.kLr.size() == 0) {
            v.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
            return null;
        }
        for (ElementQuery elementQuery : this.kLr) {
            if (elementQuery.hMt != null && elementQuery.hMt.equals(str)) {
                return elementQuery;
            }
        }
        v.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[]{str});
        return null;
    }

    public final ElementQuery Db(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
            return null;
        } else if (this.kLr != null || this.kLr.size() == 0) {
            for (ElementQuery elementQuery : this.kLr) {
                if (str.equals(elementQuery.hMu)) {
                    return elementQuery;
                }
            }
            v.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
            return null;
        } else {
            v.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
            return null;
        }
    }
}
