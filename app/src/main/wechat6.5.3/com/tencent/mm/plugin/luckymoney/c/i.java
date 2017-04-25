package com.tencent.mm.plugin.luckymoney.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.c.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i implements e, b {
    p dwg = null;
    HashSet<k> dxw = new HashSet();
    HashSet<k> dxx = new HashSet();
    private Set<Integer> dxz = new HashSet();
    private c hbn = null;
    private Context mContext;
    private String mProcessName;

    public i(Context context, c cVar) {
        this.mContext = context;
        this.hbn = cVar;
    }

    public final void a(k kVar, boolean z) {
        i(kVar);
        this.dxw.add(kVar);
        if (z && (this.dwg == null || !(this.dwg == null || this.dwg.isShowing()))) {
            if (this.dwg != null) {
                this.dwg.dismiss();
            }
            this.dwg = g.a(this.mContext, this.mContext.getString(2131233521), false, new OnCancelListener(this) {
                final /* synthetic */ i hbo;

                {
                    this.hbo = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.hbo.axF();
                }
            });
        }
        ak.vy().a(kVar, 0);
    }

    public final void b(k kVar, boolean z) {
        v.d("MicroMsg.WalletNetSceneMgr", "isShowProgress " + z);
        i(kVar);
        this.dxx.add(kVar);
        if (z && (this.dwg == null || !(this.dwg == null || this.dwg.isShowing()))) {
            if (this.dwg != null) {
                this.dwg.dismiss();
            }
            this.dwg = g.a(this.mContext, this.mContext.getString(2131233521), true, new OnCancelListener(this) {
                final /* synthetic */ i hbo;

                {
                    this.hbo = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.hbo.dwg != null && this.hbo.dxw.isEmpty()) {
                        this.hbo.dwg.dismiss();
                        Iterator it = this.hbo.dxx.iterator();
                        while (it.hasNext()) {
                            ak.vy().c((k) it.next());
                        }
                        this.hbo.dxx.clear();
                    }
                }
            });
        }
        ak.vy().a(kVar, 0);
    }

    public final void axF() {
        if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
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

    public final void a(int i, int i2, String str, k kVar) {
        Object obj;
        boolean z;
        if (this.dxx.contains(kVar)) {
            this.dxx.remove(kVar);
            v.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
            obj = 1;
        } else if (this.dxw.contains(kVar)) {
            this.dxw.remove(kVar);
            v.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
            int i3 = 1;
        } else {
            obj = null;
        }
        if (this.dxx.isEmpty() && this.dxw.isEmpty()) {
            if (this.dwg != null) {
                this.dwg.dismiss();
                this.dwg = null;
            }
            z = true;
        } else {
            z = false;
        }
        if (obj != null && this.hbn != null) {
            this.hbn.b(i, i2, str, kVar, z);
        }
    }

    public final boolean axG() {
        if (this.dxx.isEmpty() && this.dxw.isEmpty()) {
            return false;
        }
        return true;
    }

    private void i(k kVar) {
        if (kVar != null && (kVar instanceof com.tencent.mm.wallet_core.b.k)) {
            ((com.tencent.mm.wallet_core.b.k) kVar).mProcessName = this.mProcessName;
        }
    }

    public final void axH() {
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
    }
}
