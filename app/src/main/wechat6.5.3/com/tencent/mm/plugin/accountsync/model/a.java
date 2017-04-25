package com.tencent.mm.plugin.accountsync.model;

import android.os.Message;
import com.tencent.mm.e.a.hz;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.ac;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a implements e {
    b cGD = new b(this) {
        final /* synthetic */ a dwz;

        {
            this.dwz = r1;
        }

        public final void ba(boolean z) {
            v.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", Boolean.valueOf(z));
            if (!z) {
                return;
            }
            if (m.Ff().size() > 0) {
                v.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
                ak.vy().a(133, this.dwz);
                System.currentTimeMillis();
                ak.vy().a(new ac(m.Ff(), m.Fe()), 0);
                return;
            }
            v.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
            String[] strArr = (String[]) this.dwz.dww.toArray(new String[0]);
            this.dwz.dww.clear();
            List arrayList = new ArrayList();
            for (String iA : strArr) {
                com.tencent.mm.modelfriend.b iA2 = ah.FL().iA(iA);
                if (iA2 == null || be.kS(iA2.EJ())) {
                    v.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", iA);
                } else {
                    arrayList.add(iA2.EJ());
                    v.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", iA2.EJ(), iA);
                }
            }
            ak.vy().a(32, this.dwz);
            if (arrayList.size() == 0) {
                v.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
                ak.vy().a(new x(), 0);
                return;
            }
            v.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", Integer.valueOf(arrayList.size()));
            ak.vy().a(new x(arrayList, null), 0);
        }
    };
    boolean cZr = false;
    Set<String> dww = Collections.synchronizedSet(new HashSet());
    public c dwx = new c<hz>(this) {
        final /* synthetic */ a dwz;

        {
            this.dwz = r2;
            this.nhz = hz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            v.i("MicroMsg.ContactsAutoSyncLogic ", "sync username=%s isUploading=%b", ((hz) bVar).bhS.username, Boolean.valueOf(this.dwz.cZr));
            this.dwz.dww.add(r7.bhS.username);
            if (!this.dwz.cZr) {
                this.dwz.dwy.removeMessages(0);
                this.dwz.dwy.sendEmptyMessageDelayed(0, 10000);
            }
            return false;
        }
    };
    com.tencent.mm.sdk.platformtools.ac dwy = new com.tencent.mm.sdk.platformtools.ac(this) {
        final /* synthetic */ a dwz;

        {
            this.dwz = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.dwz.cZr = true;
                    if (!com.tencent.mm.modelfriend.a.a(this.dwz.cGD)) {
                        this.dwz.cZr = false;
                    }
                    v.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", Boolean.valueOf(r0));
                    return;
                default:
                    return;
            }
        }
    };

    public a() {
        com.tencent.mm.sdk.c.a.nhr.e(this.dwx);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 133) {
            ak.vy().b(133, (e) this);
            if (i == 0 && i2 == 0) {
                ak.vy().a(32, (e) this);
                ac acVar = (ac) kVar;
                ak.vy().a(new x(acVar.cIn, acVar.cIo), 0);
            } else {
                v.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + i + ", errCode = " + i2);
                this.cZr = false;
            }
        }
        if (kVar.getType() == 32) {
            this.cZr = false;
            ak.vy().b(32, (e) this);
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
                d.aZ(aa.getContext());
                return;
            }
            v.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
    }
}
