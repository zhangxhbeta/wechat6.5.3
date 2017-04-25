package com.tencent.mm.storage;

import com.tencent.mm.bg.f.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;

public final class bf extends f<be> implements a {
    public static final String[] cic = new String[]{f.a(be.chq, "VoiceTransText")};
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return a((be) cVar);
    }

    public bf(d dVar) {
        this(dVar, be.chq, "VoiceTransText");
    }

    private bf(d dVar, c.a aVar, String str) {
        super(dVar, aVar, str, null);
        this.cie = dVar;
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final boolean a(be beVar) {
        if (beVar == null) {
            return false;
        }
        if (this.cie.replace("VoiceTransText", "msgId", beVar.py()) >= 0) {
            return true;
        }
        return false;
    }
}
