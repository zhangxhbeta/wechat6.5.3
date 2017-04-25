package com.tencent.mm.plugin.freewifi.d;

import android.app.Activity;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public abstract class c extends k implements j {
    protected Activity aXH;
    protected b cif;
    protected e cii;
    protected e fZt;

    protected abstract void apq();

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        m.tE("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " returns [" + i2 + "," + i3 + "]");
        if (this.fZt != null) {
            this.fZt.a(i2, i3, str, this);
        }
        if ((this.aXH == null || !this.aXH.isFinishing()) && this.cii != null) {
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str2 = str;
            final p pVar2 = pVar;
            final byte[] bArr2 = bArr;
            ad.o(new Runnable(this) {
                final /* synthetic */ c fZu;

                public final void run() {
                    this.fZu.a(i4, i5, i6, str2);
                    if (this.fZu.cii != null) {
                        this.fZu.cii.a(i5, i6, str2, this.fZu);
                    }
                }
            });
        }
    }

    protected void a(int i, int i2, int i3, String str) {
    }

    public final void b(e eVar) {
        this.cii = eVar;
        m.tE("netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        ak.vy().a(this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.fZt = eVar2;
        return a(eVar, this.cif, this);
    }

    public final c v(Activity activity) {
        this.aXH = activity;
        return this;
    }
}
