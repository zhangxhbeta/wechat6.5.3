package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.booter.c;
import com.tencent.mm.plugin.zero.a.a;

public final class d implements a {
    final c enT;

    public d(Context context) {
        this.enT = c.ao(context);
    }

    public final String WR() {
        return this.enT.getString(".com.tencent.mm.debug.server.host.http");
    }

    public final String WS() {
        return this.enT.getString(".com.tencent.mm.debug.server.ports.http");
    }

    public final String WT() {
        return this.enT.getString(".com.tencent.mm.debug.server.host.socket");
    }

    public final String WU() {
        return this.enT.getString(".com.tencent.mm.debug.server.ports.socket");
    }

    public final String WV() {
        return this.enT.getString(".com.tencent.mm.debug.server.host.newdns");
    }
}
