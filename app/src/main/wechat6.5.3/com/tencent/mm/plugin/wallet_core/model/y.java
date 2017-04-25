package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;

public final class y {
    public ArrayList<Bankcard> kQN = new ArrayList();
    public String kQO;

    public final Bankcard Dc(String str) {
        if (this.kQN.size() > 0) {
            Bankcard bankcard;
            Iterator it = this.kQN.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (bankcard.field_bindSerial.equals(str)) {
                    break;
                }
            }
            bankcard = null;
            if (bankcard == null) {
                v.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
                return bankcard;
            }
            v.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
            return bankcard;
        }
        v.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
        return null;
    }

    public final boolean bgl() {
        return this.kQN.size() > 0;
    }

    public final Bankcard bgm() {
        if (!bgl()) {
            v.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
            return null;
        } else if (!TextUtils.isEmpty(this.kQO)) {
            return Dc(this.kQO);
        } else {
            v.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
            return (Bankcard) this.kQN.get(0);
        }
    }
}
