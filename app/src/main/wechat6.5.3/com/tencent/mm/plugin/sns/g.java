package com.tencent.mm.plugin.sns;

import android.database.Cursor;
import com.tencent.mm.e.a.ks;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends c<ks> {
    public g() {
        this.nhz = ks.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ks ksVar = (ks) bVar;
        if (ksVar instanceof ks) {
            List linkedList = new LinkedList();
            ksVar.blY.blZ = null;
            ksVar.blY.bma = null;
            ksVar.blY.bmb = null;
            v.i("MicroMsg.RecentlySnsMediaObjListener", "recently username " + ksVar.blX.username);
            if (!be.kS(ksVar.blX.username)) {
                ak.yW();
                boolean z = ksVar.blX.username.equals((String) com.tencent.mm.model.c.vf().get(2, null));
                l aSE = ad.aSE();
                String str = ("select *,rowid from SnsInfo " + l.ao(ksVar.blX.username, z)) + " AND type in ( 1 , 15)" + l.jBY + " limit 3";
                v.d("MicroMsg.SnsInfoStorage", "getUserNewerInfo " + str);
                Cursor rawQuery = aSE.cie.rawQuery(str, null);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        int i = 0;
                        do {
                            k kVar = new k();
                            kVar.b(rawQuery);
                            if (kVar.field_type != 21) {
                                Iterator it = kVar.aUp().mWq.mom.iterator();
                                while (it.hasNext()) {
                                    aib com_tencent_mm_protocal_c_aib = (aib) it.next();
                                    if (com_tencent_mm_protocal_c_aib.efm == 2 || com_tencent_mm_protocal_c_aib.efm == 6) {
                                        i++;
                                        linkedList.add(com_tencent_mm_protocal_c_aib);
                                        if (i >= 3) {
                                            break;
                                        }
                                    }
                                    i = i;
                                }
                            }
                        } while (rawQuery.moveToNext());
                        rawQuery.close();
                        if (linkedList.size() > 0) {
                            ksVar.blY.blZ = (aib) linkedList.get(0);
                        }
                        if (linkedList.size() > 1) {
                            ksVar.blY.bma = (aib) linkedList.get(1);
                        }
                        if (linkedList.size() > 2) {
                            ksVar.blY.bmb = (aib) linkedList.get(2);
                        }
                    } else {
                        rawQuery.close();
                    }
                }
            }
            return true;
        }
        v.f("MicroMsg.RecentlySnsMediaObjListener", "mismatched event");
        return false;
    }
}
