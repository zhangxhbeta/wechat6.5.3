package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.e.a.gm;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements e {
    private static a gEm = null;
    private boolean cwY = false;
    private long gEi = -1;
    private long gEj = -1;
    private long gEk = -1;
    private long gEl = -1;

    static /* synthetic */ void a(a aVar) {
        v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "updateUsernameAfterGetMFriend");
        aVar.gEk = System.currentTimeMillis();
        ArrayList auT = i.aur().auT();
        if (auT != null && auT.size() > 0) {
            v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "addressitemList.size: %d", new Object[]{Integer.valueOf(auT.size())});
            long auU = i.aur().auU();
            Iterator it = auT.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                String vh = com.tencent.mm.plugin.ipcall.b.a.vh(cVar.field_contactId);
                if (cVar.nmb > 0 && !be.kS(vh)) {
                    v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username for contactId: %s, newUsername: %s, oldUsername: %s", new Object[]{cVar.field_contactId, vh, cVar.field_wechatUsername});
                    if ((!be.kS(cVar.field_wechatUsername) && !cVar.field_wechatUsername.equals(vh)) || be.kS(cVar.field_wechatUsername)) {
                        cVar.field_wechatUsername = vh;
                        i.aur().a(cVar.nmb, cVar);
                    }
                }
            }
            i.aur().cb(auU);
        }
        aVar.gEl = System.currentTimeMillis();
        v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username use %dms", new Object[]{Long.valueOf(aVar.gEl - aVar.gEk)});
        aVar.cwY = false;
        atJ();
    }

    private a() {
    }

    public static a atI() {
        if (gEm == null) {
            gEm = new a();
        }
        return gEm;
    }

    public final void MR() {
        if (!com.tencent.mm.plugin.ipcall.b.a.Fb()) {
            v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
        }
        if (this.cwY) {
            v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        if (Math.abs(currentTimeMillis - ((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqv, Long.valueOf(0))).longValue()) >= 86400000) {
            this.cwY = true;
            this.gEi = -1;
            this.gEj = -1;
            this.gEk = -1;
            this.gEl = -1;
            ak.vy().a(32, this);
            com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                final /* synthetic */ a gEn;

                {
                    this.gEn = r1;
                }

                public final void run() {
                    v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
                    gm gmVar = new gm();
                    gmVar.bfY.scene = 2;
                    com.tencent.mm.sdk.c.a.nhr.z(gmVar);
                    this.gEn.gEi = System.currentTimeMillis();
                }
            }, "IPCallAddressBookUpdater_updateUsername");
            return;
        }
        v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.cwY)});
        if (this.cwY) {
            ak.vy().b(32, this);
            this.gEj = System.currentTimeMillis();
            v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[]{Long.valueOf(this.gEj - this.gEi)});
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                    final /* synthetic */ a gEn;

                    {
                        this.gEn = r1;
                    }

                    public final void run() {
                        a.a(this.gEn);
                    }
                }, "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
                return;
            }
            v.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
            this.cwY = false;
            atJ();
        }
    }

    private static void atJ() {
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nqv, Long.valueOf(currentTimeMillis));
    }
}
