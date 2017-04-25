package com.tencent.mm.plugin.accountsync.model;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.ac;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class ContactsSyncService extends Service implements e {
    private static Account cYi;
    private a dwB = null;
    private Looper dwC;

    private class a extends AbstractThreadedSyncAdapter {
        final /* synthetic */ ContactsSyncService dwD;
        private Context mContext;

        public a(ContactsSyncService contactsSyncService, Context context) {
            this.dwD = contactsSyncService;
            super(context, true);
            this.mContext = context;
            v.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
        }

        public final void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            v.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
            if (ak.uz()) {
                try {
                    Looper.prepare();
                    this.dwD.dwC = Looper.myLooper();
                    ContactsSyncService.a(this.dwD, account);
                    Looper.loop();
                    return;
                } catch (Exception e) {
                    this.dwD.Od();
                    v.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + e.getMessage());
                    return;
                }
            }
            v.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
        }
    }

    static /* synthetic */ void a(ContactsSyncService contactsSyncService, Account account) {
        cYi = account;
        if (!ak.uN() || ak.uG()) {
            contactsSyncService.Od();
            v.e("MicroMsg.ContactsSyncService", "performSync error: no user login");
        } else if (m.EW()) {
            v.i("MicroMsg.ContactsSyncService", "performSync start");
            if (!com.tencent.mm.modelfriend.a.a(new b(contactsSyncService) {
                final /* synthetic */ ContactsSyncService dwD;

                {
                    this.dwD = r1;
                }

                public final void ba(boolean z) {
                    v.i("MicroMsg.ContactsSyncService", "performSync end, succ:%b", Boolean.valueOf(z));
                    if (z) {
                        ak.vy().a(133, this.dwD);
                        System.currentTimeMillis();
                        ak.vy().a(new ac(m.Ff(), m.Fe()), 0);
                        return;
                    }
                    this.dwD.Od();
                }
            })) {
                contactsSyncService.Od();
                v.i("MicroMsg.ContactsSyncService", "performSync result false");
            }
        } else {
            v.e("MicroMsg.ContactsSyncService", "this user has not agreed to upload address book");
            contactsSyncService.Od();
        }
    }

    public ContactsSyncService() {
        v.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = null;
        if (com.tencent.mm.pluginsdk.i.a.aP(this, "android.permission.READ_CONTACTS")) {
            if (this.dwB == null) {
                this.dwB = new a(this, getApplicationContext());
            }
            iBinder = this.dwB.getSyncAdapterBinder();
        } else {
            v.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
        }
        v.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", iBinder);
        return iBinder;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
        if (kVar.getType() == 133) {
            ak.vy().b(133, (e) this);
            v.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + i + ", errCode = " + i2);
            ak.yW();
            long longValue = ((Long) c.vf().get(327728, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            v.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + currentTimeMillis + ", lastTime=" + longValue);
            if (i2 == 0 || currentTimeMillis - longValue >= 86400000) {
                ak.yW();
                c.vf().set(327728, Long.valueOf(currentTimeMillis));
                ak.vy().a(32, (e) this);
                ac acVar = (ac) kVar;
                ak.vy().a(new x(acVar.cIn, acVar.cIo), 0);
            } else {
                Od();
                v.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
                return;
            }
        }
        if (kVar.getType() == 32) {
            ak.vy().b(32, (e) this);
            v.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + i + ", errCode = " + i2);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.i.e.c(new com.tencent.mm.modelsimple.b(this, cYi), "MMAccountManager_updateLocalContacts").start();
            }
            Od();
        }
    }

    private void Od() {
        if (this.dwC != null) {
            this.dwC.quit();
        }
    }

    public void onDestroy() {
        v.i("MicroMsg.ContactsSyncService", "contacts sync service destory");
        super.onDestroy();
    }
}
