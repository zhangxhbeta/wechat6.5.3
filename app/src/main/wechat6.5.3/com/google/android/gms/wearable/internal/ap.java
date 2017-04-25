package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.internal.w.a;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.m.c;
import com.google.android.gms.wearable.p;
import com.google.android.gms.wearable.q;
import java.util.List;

final class ap<T> extends a {
    p.a aFO;
    q.a aFP;
    b aFQ;
    j.a aFR;
    m.b aFS;
    c aFT;
    com.google.android.gms.wearable.b.a aFU;
    com.google.android.gms.wearable.a.a aFV;
    final IntentFilter[] aFW;
    final String aFX;
    final String aFY;

    public final void a(DataHolder dataHolder) {
        if (this.aFQ != null) {
            try {
                this.aFQ.a(new e(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public final void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
    }

    public final void a(AncsNotificationParcelable ancsNotificationParcelable) {
    }

    public final void a(CapabilityInfoParcelable capabilityInfoParcelable) {
    }

    public final void a(ChannelEventParcelable channelEventParcelable) {
        if (this.aFU != null) {
            channelEventParcelable.mB();
        }
    }

    public final void a(MessageEventParcelable messageEventParcelable) {
        if (this.aFR != null) {
            this.aFR.a(messageEventParcelable);
        }
    }

    public final void a(NodeParcelable nodeParcelable) {
        if (this.aFS != null) {
            this.aFS.a(nodeParcelable);
        }
    }

    public final void b(NodeParcelable nodeParcelable) {
        if (this.aFS != null) {
            this.aFS.b(nodeParcelable);
        }
    }

    public final void m(List<NodeParcelable> list) {
    }
}
