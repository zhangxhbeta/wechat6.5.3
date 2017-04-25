package com.tencent.mm.plugin.address.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b implements e {
    private a dxv = null;
    HashSet<k> dxw = new HashSet();
    HashSet<k> dxx = new HashSet();
    Dialog dxy = null;
    private Set<Integer> dxz = new HashSet();
    private Context mContext;

    public b(Context context, a aVar) {
        this.mContext = context;
        this.dxv = aVar;
    }

    public final void f(k kVar) {
        v.d("MicroMsg.WalletNetSceneMgr", new StringBuilder("isShowProgress true").toString());
        this.dxx.add(kVar);
        if (this.dxy == null || !(this.dxy == null || this.dxy.isShowing())) {
            if (this.dxy != null) {
                this.dxy.dismiss();
            }
            this.dxy = g.a(this.mContext, "", true, new OnCancelListener(this) {
                final /* synthetic */ b dxA;

                {
                    this.dxA = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.dxA.dxy != null && this.dxA.dxw.isEmpty()) {
                        this.dxA.dxy.dismiss();
                        Iterator it = this.dxA.dxx.iterator();
                        while (it.hasNext()) {
                            ak.vy().c((k) it.next());
                        }
                        this.dxA.dxx.clear();
                    }
                }
            });
        }
        ak.vy().a(kVar, 0);
    }

    public final void gQ(int i) {
        this.dxz.add(Integer.valueOf(i));
        ak.vy().a(i, this);
    }

    public final void gR(int i) {
        ak.vy().b(i, this);
        this.dxz.remove(Integer.valueOf(i));
        if (this.dxz.isEmpty()) {
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
            this.dxv = null;
            this.mContext = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        if (this.dxx.contains(kVar)) {
            this.dxx.remove(kVar);
            v.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
        } else if (this.dxw.contains(kVar)) {
            this.dxw.remove(kVar);
            v.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        } else {
            obj = null;
        }
        if (this.dxx.isEmpty() && this.dxw.isEmpty() && this.dxy != null) {
            this.dxy.dismiss();
            this.dxy = null;
        }
        if (obj != null && this.dxv != null) {
            this.dxv.e(i, i2, str, kVar);
        }
    }
}
