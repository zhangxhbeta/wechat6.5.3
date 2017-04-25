package com.tencent.mm.plugin.notification.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.e.a.je;
import com.tencent.mm.e.a.lq;
import com.tencent.mm.e.a.nx;
import com.tencent.mm.e.a.ny;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class d extends a<b> {
    private c hIW = new c<ny>(this) {
        final /* synthetic */ d hIY;

        {
            this.hIY = r2;
            this.nhz = ny.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final ny nyVar = (ny) bVar;
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 hJa;

                public final void run() {
                    ny nyVar = nyVar;
                    b bVar = new b();
                    bVar.id = nyVar.boV.boU;
                    this.hJa.hIY.aP(bVar);
                }
            });
            return false;
        }
    };
    private c hIX = new c<nx>(this) {
        final /* synthetic */ d hIY;

        {
            this.hIY = r2;
            this.nhz = nx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final nx nxVar = (nx) bVar;
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 hJc;

                public final void run() {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(589825, Boolean.valueOf(true));
                    nx nxVar = nxVar;
                    b bVar = new b();
                    bVar.id = nxVar.boT.boU;
                    this.hJc.hIY.aO(bVar);
                }
            });
            return false;
        }
    };

    protected final /* bridge */ /* synthetic */ long aQ(Object obj) {
        return ((b) obj).id;
    }

    protected final /* synthetic */ ArrayList aR(Object obj) {
        ArrayList aVa = j.ak.lyk.aVa();
        if (aVa.size() == 0) {
            v.e("MicroMsg.SendSnsFailNotification", "getAllFailMsgFromDb, resendList is empty");
        }
        return aVa;
    }

    protected final void aEo() {
        List runningTasks = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            if (componentName != null) {
                v.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", new Object[]{componentName.getClassName()});
                if (componentName.getClassName().contains("SnsTimeLineUI")) {
                    v.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
                    return;
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("sns_resume_state", false);
        intent.putExtra("sns_timeline_NeedFirstLoadint", true);
        intent.putExtra("preferred_tab", 2);
        if (VERSION.SDK_INT < 16) {
            intent.putExtra("is_need_resend_sns", true);
        }
        intent.putExtra("From_fail_notify", true);
        intent.putExtra("jump_sns_from_notify", true);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        com.tencent.mm.ay.c.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
    }

    protected final int getType() {
        return 2;
    }

    protected final void K(ArrayList<Long> arrayList) {
        je jeVar = new je();
        jeVar.bjK.bfC = arrayList;
        com.tencent.mm.sdk.c.a.nhr.z(jeVar);
    }

    public final void aEt() {
        com.tencent.mm.sdk.c.a.nhr.e(this.hIX);
    }

    public final void aEu() {
        com.tencent.mm.sdk.c.a.nhr.e(this.hIW);
    }

    public final void cn(final long j) {
        ad.o(new Runnable(this) {
            final /* synthetic */ d hIY;

            public final void run() {
                v.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[]{Long.valueOf(j)});
                lq lqVar = new lq();
                lqVar.bmT.bmU = (int) j;
                com.tencent.mm.sdk.c.a.nhr.z(lqVar);
            }
        });
    }

    public final void aEv() {
        com.tencent.mm.sdk.c.a.nhr.f(this.hIX);
    }

    public final void aEw() {
        com.tencent.mm.sdk.c.a.nhr.f(this.hIW);
    }

    protected final String nG(int i) {
        return this.mContext.getString(2131234068, new Object[]{Integer.valueOf(i)});
    }

    protected final String ca(int i, int i2) {
        return this.mContext.getString(2131234101, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String H(int i, int i2, int i3) {
        return this.mContext.getString(2131234102, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String cb(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(2131234098, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(2131234069, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean co(long j) {
        v.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", new Object[]{Long.valueOf(j), Boolean.valueOf(j.ak.lyk.qF((int) j))});
        return j.ak.lyk.qF((int) j);
    }

    protected final void aEe() {
        if (ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(589825, Boolean.valueOf(false));
        }
    }
}
