package com.tencent.mm.az;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.mm.ak.j;
import com.tencent.mm.ba.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b {
    public static void run() {
        long j = 0;
        if (ak.uz() && !ak.uG()) {
            long Nh = be.Nh();
            ak.yW();
            long a = be.a((Long) c.vf().get(331797, null), 0);
            if (10013 != q.dqj || q.dqk == 0) {
                j = a;
            }
            if (j < Nh) {
                ak.yW();
                c.vf().set(331797, Long.valueOf(432000 + Nh));
                try {
                    a com_tencent_mm_protocal_c_abk = new abk();
                    com_tencent_mm_protocal_c_abk.mCG = SQLiteDatabase.KeyEmpty;
                    for (Account account : AccountManager.get(aa.getContext()).getAccountsByType("com.google")) {
                        if (!be.kS(com_tencent_mm_protocal_c_abk.mCG)) {
                            break;
                        }
                        v.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", account.name);
                        com_tencent_mm_protocal_c_abk.mCG = account.name;
                    }
                    if (10013 == q.dqj && q.dqk != 0) {
                        com_tencent_mm_protocal_c_abk.mCG = "rssjbbk@gmail.com";
                    }
                    if (be.kS(com_tencent_mm_protocal_c_abk.mCG)) {
                        v.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
                        return;
                    }
                    ak.yW();
                    c.wG().b(new j.a(57, com_tencent_mm_protocal_c_abk));
                } catch (Exception e) {
                    v.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", e.getMessage());
                }
            }
        }
    }
}
