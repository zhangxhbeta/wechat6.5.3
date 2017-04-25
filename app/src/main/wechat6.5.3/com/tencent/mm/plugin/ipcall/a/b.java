package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.mm.e.a.hg;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    private static c gEy = new c<hg>() {
        {
            this.nhz = hg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (((hg) bVar) instanceof hg) {
                e.a(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 gEz;

                    {
                        this.gEz = r1;
                    }

                    public final void run() {
                        b.sq();
                    }
                }, "IPCall_SyncAddressBook");
            }
            return false;
        }
    };

    static /* synthetic */ void sq() {
        if (ak.uz()) {
            v.d("MicroMsg.IPCallAddressUpdater", "start updateAddressStorage");
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.ipcall.a.g.b bVar = new com.tencent.mm.plugin.ipcall.a.g.b();
            ArrayList auT = i.aur().auT();
            if (auT != null && auT.size() > 0) {
                HashMap auS = com.tencent.mm.plugin.ipcall.a.g.b.auS();
                if (auS != null && auS.size() >= 0) {
                    com.tencent.mm.plugin.ipcall.a.g.c cVar;
                    long auU = i.aur().auU();
                    v.d("MicroMsg.IPCallAddressUpdater", "start delete not exist address");
                    v.d("MicroMsg.IPCallAddressUpdater", "oldItemList.size: %d", new Object[]{Integer.valueOf(auT.size())});
                    Iterator it = auT.iterator();
                    while (it.hasNext()) {
                        cVar = (com.tencent.mm.plugin.ipcall.a.g.c) it.next();
                        if (!auS.containsKey(cVar.field_contactId)) {
                            long j = cVar.nmb;
                            i.aur().delete(j);
                            v.d("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord, id: %d", new Object[]{Long.valueOf(j)});
                            Cursor cc = i.aus().cc(j);
                            if (cc != null) {
                                try {
                                    if (cc.moveToFirst()) {
                                        while (!cc.isAfterLast()) {
                                            k kVar = new k();
                                            kVar.b(cc);
                                            kVar.field_addressId = -1;
                                            kVar.field_phoneType = -1;
                                            i.aus().a(kVar);
                                            cc.moveToNext();
                                        }
                                    }
                                } catch (Exception e) {
                                    v.e("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord error: %s", new Object[]{e.getMessage()});
                                    if (cc != null) {
                                        try {
                                            cc.close();
                                        } catch (Exception e2) {
                                            v.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage error:" + e2.getMessage());
                                            return;
                                        }
                                    }
                                    continue;
                                } catch (Throwable th) {
                                    if (cc != null) {
                                        cc.close();
                                    }
                                }
                            }
                            if (cc != null) {
                                cc.close();
                            } else {
                                continue;
                            }
                        }
                    }
                    v.d("MicroMsg.IPCallAddressUpdater", "start update or insert address");
                    for (com.tencent.mm.plugin.ipcall.a.g.c cVar2 : auS.values()) {
                        com.tencent.mm.plugin.ipcall.a.g.c uK = i.aur().uK(cVar2.field_contactId);
                        if (uK == null || uK.nmb == -1) {
                            i.aur().b(cVar2);
                        } else {
                            i.aur().a(uK.nmb, cVar2);
                        }
                    }
                    i.aur().cb(auU);
                    v.d("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                }
                return;
            }
            return;
        }
        v.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, acc not ready");
    }

    public static void init() {
        a.nhr.e(gEy);
    }

    public static void release() {
        a.nhr.f(gEy);
    }
}
