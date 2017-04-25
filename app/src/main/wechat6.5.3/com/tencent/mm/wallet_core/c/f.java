package com.tencent.mm.wallet_core.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.e.a.h;
import com.tencent.mm.wallet_core.e.a.j;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f implements e, b {
    HashSet<k> dxw = new HashSet();
    HashSet<k> dxx = new HashSet();
    public Dialog dxy = null;
    private Set<Integer> dxz = new HashSet();
    private c hbn = null;
    public Context mContext;
    public String mProcessName;
    private a piU;
    public Bundle uA;

    public f(Context context, c cVar) {
        this.mContext = context;
        this.hbn = cVar;
        this.piU = new a(this);
    }

    public final void a(k kVar, boolean z) {
        o(kVar);
        this.dxw.add(kVar);
        if (z && (this.dxy == null || !(this.dxy == null || this.dxy.isShowing()))) {
            if (this.dxy != null) {
                this.dxy.dismiss();
            }
            this.dxy = g.a(this.mContext, false, new OnCancelListener(this) {
                final /* synthetic */ f piV;

                {
                    this.piV = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.piV.axF();
                }
            });
        }
        ak.vy().a(kVar, 0);
    }

    public final void a(k kVar, boolean z, boolean z2) {
        v.d("MicroMsg.WalletNetSceneMgr", "isShowProgress " + z);
        o(kVar);
        this.dxx.add(kVar);
        if (z && (this.dxy == null || !(this.dxy == null || this.dxy.isShowing()))) {
            if (this.dxy != null) {
                this.dxy.dismiss();
            }
            if (z2) {
                this.dxy = g.a(this.mContext, false, new OnCancelListener(this) {
                    final /* synthetic */ f piV;

                    {
                        this.piV = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (this.piV.dxy != null && this.piV.dxw.isEmpty()) {
                            this.piV.dxy.dismiss();
                            Iterator it = this.piV.dxx.iterator();
                            while (it.hasNext()) {
                                ak.vy().c((k) it.next());
                            }
                            this.piV.dxx.clear();
                        }
                    }
                });
            } else {
                this.dxy = g.a(this.mContext, this.mContext.getString(2131236356), false, new OnCancelListener(this) {
                    final /* synthetic */ f piV;

                    {
                        this.piV = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (this.piV.dxy != null && this.piV.dxw.isEmpty()) {
                            this.piV.dxy.dismiss();
                            Iterator it = this.piV.dxx.iterator();
                            while (it.hasNext()) {
                                ak.vy().c((k) it.next());
                            }
                            this.piV.dxx.clear();
                        }
                    }
                });
            }
        }
        ak.vy().a(kVar, 0);
    }

    public final void axF() {
        if (this.dxy != null) {
            this.dxy.dismiss();
            this.dxy = null;
        }
        Iterator it = this.dxw.iterator();
        while (it.hasNext()) {
            ak.vy().c((k) it.next());
        }
        it = this.dxx.iterator();
        while (it.hasNext()) {
            ak.vy().c((k) it.next());
        }
        this.dxw.clear();
        this.dxx.clear();
    }

    public final void gQ(int i) {
        this.dxz.add(Integer.valueOf(i));
        ak.vy().a(i, this);
    }

    public final void gR(int i) {
        ak.vy().b(i, this);
        this.dxz.remove(Integer.valueOf(i));
        if (this.dxz.isEmpty()) {
            axF();
            this.hbn = null;
            this.mContext = null;
        }
    }

    public final void axH() {
        beT();
    }

    private boolean c(int i, int i2, k kVar) {
        v.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is " + kVar.toString());
        if ((kVar instanceof h) && !(i == 0 && i2 == 0)) {
            h hVar = (h) kVar;
            boolean z = (hVar.pji || !(i == 0 || i == BaseReportManager.MAX_READ_COUNT || i == 2)) && !hVar.pjj;
            if (!z && this.piU.a(hVar)) {
                v.i("MicroMsg.WalletNetSceneMgr", "doing delay order query");
                return true;
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj;
        boolean z;
        if (this.dxx.contains(kVar)) {
            v.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
            if (c(i, i2, kVar)) {
                v.i("MicroMsg.WalletNetSceneMgr", "do delay order query.break off!");
                return;
            }
            v.i("MicroMsg.WalletNetSceneMgr", "Not need delay query order,remove scene");
            this.dxx.remove(kVar);
            obj = 1;
        } else if (this.dxw.contains(kVar)) {
            v.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
            if (c(i, i2, kVar)) {
                v.i("MicroMsg.WalletNetSceneMgr", "do delay order query.break off!");
                return;
            }
            this.dxw.remove(kVar);
            v.i("MicroMsg.WalletNetSceneMgr", "Not need delay query order,remove scene");
            int i3 = 1;
        } else {
            obj = null;
        }
        if (!this.dxx.isEmpty() || !this.dxw.isEmpty()) {
            z = false;
        } else if (kVar instanceof j) {
            j jVar = (j) kVar;
            if ((jVar.pji || !(i == 0 || i == BaseReportManager.MAX_READ_COUNT || i == 2)) && !jVar.pjj) {
                v.i("MicroMsg.WalletNetSceneMgr", "hy: should retry. do not close the dialog");
                z = false;
            } else {
                beT();
                z = true;
            }
        } else {
            beT();
            z = true;
        }
        if (obj != null && this.hbn != null) {
            this.hbn.b(i, i2, str, kVar, z);
        }
    }

    public final void beT() {
        if (this.dxy != null) {
            this.dxy.dismiss();
            this.dxy = null;
        }
    }

    public final boolean axG() {
        if (this.dxx.isEmpty() && this.dxw.isEmpty()) {
            return false;
        }
        return true;
    }

    private void o(k kVar) {
        if (kVar != null && (kVar instanceof com.tencent.mm.wallet_core.b.k)) {
            ((com.tencent.mm.wallet_core.b.k) kVar).mProcessName = this.mProcessName;
            if (this.uA != null) {
                ((com.tencent.mm.wallet_core.b.k) kVar).uA = this.uA;
            } else if (this.mContext instanceof WalletBaseUI) {
                ((com.tencent.mm.wallet_core.b.k) kVar).uA = ((WalletBaseUI) this.mContext).uA;
            }
        }
    }
}
