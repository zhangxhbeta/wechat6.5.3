package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ab {
    public Bankcard kFU = null;
    ArrayList<Bankcard> kGO = new ArrayList();
    ArrayList<Bankcard> kGP = new ArrayList();
    private aa kQQ = null;
    public Bankcard kQR = null;
    z kQS = null;
    public h kQT = null;
    public b kQU = null;
    public long kQV = be.Nh();
    public long kQW = -1;
    private String kQX = "";
    private int kQY = 10;
    public String kQZ = "";

    public ab() {
        bgF();
    }

    public final boolean bgu() {
        return this.kQQ == null || (this.kQQ != null && this.kQQ.bgt());
    }

    public final boolean bgv() {
        if (this.kQQ != null) {
            if (this.kQQ.field_is_reg == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean bgs() {
        return this.kQQ != null && this.kQQ.bgs();
    }

    public final boolean bgw() {
        if (this.kQQ != null) {
            if (this.kQQ.field_is_reg == 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean bgx() {
        if (this.kQQ != null) {
            if (this.kQQ.field_is_open_touch == 1) {
                return true;
            }
        }
        return false;
    }

    public final String bgy() {
        if (this.kQQ != null) {
            return this.kQQ.field_ftf_pay_url;
        }
        return null;
    }

    public final z bgz() {
        if (this.kQS == null) {
            return new z();
        }
        return this.kQS;
    }

    public final boolean bgA() {
        return this.kQQ != null && this.kQQ.field_isDomesticUser;
    }

    public final String bgB() {
        if (this.kQQ != null) {
            return this.kQQ.field_true_name;
        }
        return null;
    }

    public final int bgC() {
        if (this.kQQ != null) {
            return this.kQQ.field_cre_type;
        }
        return 1;
    }

    public final String bgD() {
        if (this.kQQ != null) {
            return this.kQQ.field_lct_wording;
        }
        return null;
    }

    public final String bgE() {
        if (this.kQQ != null) {
            return this.kQQ.field_lct_url;
        }
        return null;
    }

    public final void bgF() {
        h hVar = null;
        ak.yW();
        if (c.ww() == 0) {
            v.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
            return;
        }
        Bankcard bankcard;
        this.kQQ = k.bfX().bgT();
        if (this.kQQ != null) {
            this.kQS = new z(this.kQQ.field_switchConfig);
        } else {
            this.kQS = new z();
        }
        com.tencent.mm.plugin.wallet_core.c.c bfY = k.bfY();
        Cursor rawQuery = bfY.cie.rawQuery("select * from WalletBankcard where cardType & " + Bankcard.kNo + " != 0 ", null);
        if (rawQuery == null) {
            bankcard = null;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            bankcard = null;
        } else {
            if (rawQuery.moveToNext()) {
                bankcard = new Bankcard();
                bankcard.b(rawQuery);
            } else {
                bankcard = null;
            }
            rawQuery.close();
        }
        this.kFU = bankcard;
        e.a("wallet_balance", new b(this) {
            final /* synthetic */ ab kRa;

            {
                this.kRa = r1;
            }

            public final void aZ(Object obj) {
                if (obj == null || !(obj instanceof Double)) {
                    v.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
                    if (this.kRa.kFU != null) {
                        this.kRa.kFU.kNv = -1.0d;
                    }
                } else if (this.kRa.kFU != null) {
                    this.kRa.kFU.kNv = ((Double) obj).doubleValue();
                }
            }
        });
        this.kGO = k.bfY().bgG();
        this.kGP = k.bfY().bgR();
        bfY = k.bfY();
        rawQuery = bfY.cie.rawQuery("select * from WalletBankcard where cardType & " + Bankcard.kNp + " != 0 ", null);
        if (rawQuery == null) {
            bankcard = null;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            bankcard = null;
        } else {
            if (rawQuery.moveToNext()) {
                bankcard = new Bankcard();
                bankcard.b(rawQuery);
            } else {
                bankcard = null;
            }
            rawQuery.close();
        }
        this.kQR = bankcard;
        Cursor rawQuery2 = k.bgc().cie.rawQuery("select * from LoanEntryInfo", null);
        if (rawQuery2 != null) {
            if (rawQuery2.getCount() == 0) {
                rawQuery2.close();
            } else {
                if (rawQuery2.moveToNext()) {
                    hVar = new h();
                    hVar.b(rawQuery2);
                }
                rawQuery2.close();
            }
        }
        this.kQT = hVar;
        v.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
        bgJ();
    }

    public final void amB() {
        if (this.kQQ != null) {
            this.kQQ.field_is_reg = -1;
            this.kQQ = null;
        }
        if (this.kQS != null) {
            this.kQS = null;
        }
        if (this.kFU != null) {
            this.kFU = null;
        }
        if (this.kGO != null) {
            this.kGO.clear();
            this.kGO = null;
        }
        if (this.kGP != null) {
            this.kGP.clear();
            this.kGP = null;
        }
        e.a(new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1)));
        this.kQV = be.Nh();
    }

    public final ArrayList<Bankcard> bgG() {
        if (this.kGO == null || this.kGO.size() <= 0) {
            this.kGO = k.bfY().bgG();
        }
        if (this.kGO == null || this.kGO.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.kGO.iterator();
        while (it.hasNext()) {
            arrayList.add((Bankcard) it.next());
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> bgH() {
        if (this.kGO == null || this.kGO.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.kGO.iterator();
        while (it.hasNext()) {
            Bankcard bankcard = (Bankcard) it.next();
            if (!bankcard.bfH()) {
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> hk(boolean z) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (!(!z || this.kFU == null || bgs())) {
            arrayList.add(this.kFU);
        }
        if (this.kGO != null && this.kGO.size() > 0) {
            Iterator it = this.kGO.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        return arrayList;
    }

    public final void d(ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2) {
        if (this.kGO == null || arrayList == null || arrayList2 == null) {
            v.e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
            return;
        }
        Iterator it;
        arrayList.clear();
        arrayList2.clear();
        if (this.kGO != null) {
            it = this.kGO.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        if (this.kGP != null) {
            it = this.kGP.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bankcard.field_wxcreditState == 0) {
                    arrayList2.add(bankcard);
                } else {
                    arrayList.add(bankcard);
                }
            }
        }
    }

    public static boolean bA(List<Bankcard> list) {
        if (list.size() == 0) {
            return false;
        }
        ak.yW();
        String str = (String) c.vf().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            return true;
        }
        int i = 0;
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Bankcard bankcard = (Bankcard) list.get(i2);
                    if (bankcard != null && obj.equals(bankcard.field_bankcardType)) {
                        i++;
                        break;
                    }
                }
            }
        }
        if (i < list.size()) {
            return true;
        }
        return false;
    }

    public final boolean Dd(String str) {
        if (be.kS(str)) {
            return false;
        }
        Iterator it;
        Bankcard bankcard;
        if (this.kGO != null) {
            it = this.kGO.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.bfF()) {
                    return false;
                }
            }
        }
        if (this.kGP != null) {
            it = this.kGP.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.field_bankcardState == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void a(aa aaVar, ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2, Bankcard bankcard, Bankcard bankcard2, h hVar, b bVar, int i) {
        this.kQQ = aaVar;
        this.kGO = arrayList;
        this.kGP = arrayList2;
        this.kFU = bankcard;
        this.kQS = new z(aaVar.field_switchConfig);
        this.kQR = bankcard2;
        this.kQT = hVar;
        this.kQU = bVar;
        v.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + aaVar.field_switchConfig);
        bgJ();
        if (i < 0) {
            i = 600;
        }
        this.kQV = be.Nh() + ((long) i);
        v.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d", new Object[]{Integer.valueOf(i), Long.valueOf(this.kQV)});
        k.bfY().cie.dF("WalletBankcard", "delete from WalletBankcard");
        if (arrayList != null) {
            k.bfY().bC(arrayList);
        }
        if (arrayList2 != null) {
            k.bfY().bC(arrayList2);
        }
        if (bankcard != null) {
            k.bfY().d(bankcard);
        }
        if (bankcard2 != null) {
            k.bfY().d(bankcard2);
        }
        k.bfX().cie.dF("WalletUserInfo", "delete from WalletUserInfo");
        k.bfX().a(aaVar);
        k.bgc().cie.dF("LoanEntryInfo", "delete from LoanEntryInfo");
        if (hVar != null) {
            k.bgc().b(hVar);
        }
    }

    public final void De(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.WalletUserInfoManger", "hy: retrSec is null or nill. abort");
            this.kQY = 10;
        }
        try {
            this.kQY = be.getInt(str, 10);
        } catch (NumberFormatException e) {
            v.e("MicroMsg.WalletUserInfoManger", "hy: number format exception when parsing timeout second: " + e.toString());
            this.kQY = 10;
        }
    }

    public static void Df(String str) {
        if (!be.kS(str)) {
            ak.yW();
            c.vf().set(196612, str);
        }
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2) {
        if (arrayList == null) {
            arrayList = this.kGO;
        }
        if (be.kS(str)) {
            ak.yW();
            str = (String) c.vf().get(196612, null);
        }
        if (z && this.kFU != null) {
            if (bgw()) {
                return this.kFU;
            }
            if (str != null && str.equals(this.kFU.field_bindSerial)) {
                return this.kFU;
            }
            if (!bgs() && (arrayList == null || arrayList.size() == 0)) {
                return this.kFU;
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            v.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        } else if (arrayList.size() == 1 && z2) {
            v.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
            return (Bankcard) arrayList.get(0);
        } else {
            v.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
            if (!be.kS(str)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                        return bankcard;
                    }
                }
            }
            return z2 ? (Bankcard) arrayList.get(0) : null;
        }
    }

    public final String bgI() {
        if (this.kGO == null || this.kGO.size() <= 0) {
            v.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        }
        Iterator it = this.kGO.iterator();
        if (it.hasNext()) {
            return ((Bankcard) it.next()).field_bindSerial;
        }
        return null;
    }

    private void bgJ() {
        v.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
        if (this.kQQ == null) {
            v.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
        }
        if (this.kGO == null) {
            v.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
        } else if (this.kGO.size() == 0) {
            v.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        } else {
            v.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.kGO.size());
        }
        if (this.kGP == null) {
            v.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
        } else if (this.kGP.size() == 0) {
            v.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        } else {
            v.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.kGP.size());
        }
        if (this.kFU == null) {
            v.i("MicroMsg.WalletUserInfoManger", "balance == null");
        } else {
            v.i("MicroMsg.WalletUserInfoManger", "balance != null");
        }
        if (this.kQR == null) {
            v.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
        } else {
            v.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
        }
        if (this.kQT == null) {
            v.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
        } else {
            v.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
        }
    }
}
