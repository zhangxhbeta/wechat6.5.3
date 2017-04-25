package com.tencent.mm.model;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class d {
    private Context aHq = aa.getContext();
    private com.tencent.mm.compatible.util.b aUX;
    private com.tencent.mm.compatible.util.b.a crm;
    a crn;
    private boolean cro = false;

    public interface a {
    }

    private class b implements com.tencent.mm.compatible.util.b.a {
        final /* synthetic */ d crp;

        private b(d dVar) {
            this.crp = dVar;
        }

        public final void dV(int i) {
            switch (i) {
                case -3:
                    v.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    if (this.crp.crn == null) {
                        return;
                    }
                    return;
                case -2:
                    v.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
                    if (this.crp.crn == null) {
                        return;
                    }
                    return;
                case -1:
                    v.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
                    if (this.crp.crn == null) {
                        return;
                    }
                    return;
                case 1:
                    v.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
                    if (this.crp.crn == null) {
                        return;
                    }
                    return;
                default:
                    v.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
                    return;
            }
        }
    }

    public final boolean a(a aVar) {
        this.crn = aVar;
        com.tencent.mm.compatible.util.b.a bVar = new b();
        if (this.aUX == null) {
            this.aUX = new com.tencent.mm.compatible.util.b(this.aHq);
        }
        if (this.crm != bVar) {
            this.crm = bVar;
        }
        com.tencent.mm.compatible.util.b bVar2 = this.aUX;
        com.tencent.mm.compatible.util.b.a aVar2 = this.crm;
        if (bVar2.cfW != null) {
            bVar2.cfW.a(aVar2);
        }
        if (this.aUX == null || this.cro) {
            return false;
        }
        this.aUX.requestFocus();
        this.cro = true;
        return this.cro;
    }

    public final boolean aN(boolean z) {
        boolean si;
        if (this.aUX != null) {
            si = this.aUX.si();
        } else {
            si = false;
        }
        this.cro = false;
        if (z) {
            this.aUX = null;
            this.crm = null;
            this.crn = null;
        }
        return si;
    }
}
