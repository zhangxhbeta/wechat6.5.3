package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ae;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class l {
    public static boolean Hm() {
        boolean z;
        g.vx();
        if (be.ma((String) g.vw().vf().get(8195, null)).length() > 0) {
            g.vx();
            if (be.f((Integer) g.vw().vf().get(15, null)) != 0) {
                z = false;
                v.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
                return z;
            }
        }
        z = true;
        v.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
        return z;
    }

    public static void a(int i, byte[] bArr, byte[] bArr2, long j) {
        b bVar = new b();
        PByteArray pByteArray = new PByteArray();
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt = new PInt();
        try {
            if (!MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, new PInt())) {
                v.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
            } else if (pInt.value == -13) {
                bVar.lWU = pInt.value;
                v.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
            } else {
                int y = bVar.y(pByteArray2.value);
                v.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
                bVar.lWU = y;
                bVar.lWT = (long) bArr.length;
                g.vx();
                byte[] KG = be.KG(be.ma((String) g.vw().vf().get(8195, null)));
                byte[] a = m.a(bVar.lXt.mkF);
                g.vx();
                g.vu().aA(bVar.lXt.eeO, bVar.lXt.mLh);
                a.eA(bVar.lXt.eeO);
                if (be.bl(a) || !ae.j(KG, a)) {
                    v.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
                } else {
                    ((d) g.f(d.class)).Ho().a(bVar, i, j);
                }
            }
        } catch (Throwable e) {
            v.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", e);
            v.a("MicroMsg.NewSyncMgr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }
}
