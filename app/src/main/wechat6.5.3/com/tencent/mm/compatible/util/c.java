package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.compatible.util.b.b;
import com.tencent.mm.sdk.platformtools.v;

@TargetApi(8)
public final class c implements b {
    private AudioManager cfZ;
    a cga;
    private OnAudioFocusChangeListener cgb = new OnAudioFocusChangeListener(this) {
        final /* synthetic */ c cgc;

        {
            this.cgc = r1;
        }

        public final void onAudioFocusChange(int i) {
            if (this.cgc.cga != null) {
                v.d("MicroMsg.AudioFocusHelper", "jacks change: %d", Integer.valueOf(i));
                this.cgc.cga.dV(i);
            }
        }
    };
    private Context context;

    public final void a(a aVar) {
        this.cga = aVar;
    }

    public c(Context context) {
        this.context = context;
    }

    public final boolean requestFocus() {
        if (this.cfZ == null && this.context != null) {
            this.cfZ = (AudioManager) this.context.getSystemService("audio");
        }
        boolean z = this.cfZ != null ? 1 == this.cfZ.requestAudioFocus(this.cgb, 3, 2) : false;
        v.j("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.cgb.hashCode()));
        return z;
    }

    public final boolean si() {
        if (this.cfZ == null && this.context != null) {
            this.cfZ = (AudioManager) this.context.getSystemService("audio");
        }
        boolean z = this.cfZ != null ? 1 == this.cfZ.abandonAudioFocus(this.cgb) : false;
        v.j("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.cgb.hashCode()));
        return z;
    }
}
