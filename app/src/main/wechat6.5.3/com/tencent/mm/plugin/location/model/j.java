package com.tencent.mm.plugin.location.model;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements a {
    HashMap<Long, WeakReference<ImageView>> gSk = new HashMap();
    HashMap<Long, b> gSl = new HashMap();
    HashMap<Long, WeakReference<ProgressBar>> gSm = new HashMap();
    HashMap<Long, WeakReference<ImageView>> gSn = new HashMap();
    HashMap<b, at> gSo = new HashMap();
    HashMap<Long, Integer> gSp = new HashMap();
    HashSet<Long> gSq = new HashSet();
    int h = 300;
    int w = 300;

    public j() {
        start();
    }

    public final void start() {
        k awg = l.awg();
        if (this != null) {
            for (a equals : awg.bXt) {
                if (equals(equals)) {
                    return;
                }
            }
            awg.bXt.add(this);
            v.i("MicroMsg.StaticMapServer", "addMapCallBack " + awg.bXt.size());
            if (awg.bXt.size() == 1) {
                awg.start();
            }
        }
    }

    public final void a(String str, com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.gSl.containsKey(Long.valueOf(bVar.lyQ))) {
            at atVar = (at) this.gSo.remove((b) this.gSl.get(Long.valueOf(bVar.lyQ)));
            if (atVar != null) {
                WeakReference weakReference = (WeakReference) this.gSk.get(Long.valueOf(atVar.field_msgId));
                if (weakReference != null && weakReference.get() != null && this.gSp.containsKey(Long.valueOf(atVar.field_msgId))) {
                    ((ImageView) weakReference.get()).setImageBitmap(n.GH().a(atVar.field_msgId, str, ((Integer) this.gSp.remove(Long.valueOf(atVar.field_msgId))).intValue(), this.w, this.h, atVar.field_isSend == 0));
                    weakReference = (WeakReference) this.gSm.remove(Long.valueOf(atVar.field_msgId));
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((ProgressBar) weakReference.get()).setVisibility(8);
                    }
                    WeakReference weakReference2 = (WeakReference) this.gSn.remove(Long.valueOf(atVar.field_msgId));
                    if (weakReference2 != null && weakReference2.get() != null) {
                        ((ImageView) weakReference2.get()).setVisibility(0);
                    }
                }
            }
        }
    }

    public final void a(com.tencent.mm.pluginsdk.location.b bVar) {
        if (bVar != null && this.gSl.containsKey(Long.valueOf(bVar.lyQ))) {
            at atVar = (at) this.gSo.remove((b) this.gSl.get(Long.valueOf(bVar.lyQ)));
            if (atVar != null) {
                this.gSk.get(Long.valueOf(atVar.field_msgId));
                if (atVar == null) {
                    return;
                }
                if (atVar.bNu < 0 || atVar.bNu > 5) {
                    atVar.dv(0);
                    atVar.dv(atVar.bNu + 1);
                    if (ak.uz()) {
                        ak.yW();
                        c.wJ().a(atVar.field_msgId, atVar);
                        v.i("MicroMsg.StaticMapMsgLogic", "on error count %d", new Object[]{Integer.valueOf(atVar.bNu)});
                    }
                }
            }
        }
    }
}
