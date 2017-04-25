package com.tencent.mm.modelmulti;

import com.tencent.mm.plugin.f.a.a.f;
import com.tencent.mm.plugin.f.a.a.h;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.storage.at;

public final class n implements h {
    private final a cSi = new a();
    private com.tencent.mm.plugin.f.a.a.h.a cSj;

    private static final class a extends com.tencent.mm.av.a<f> implements f {
        private a() {
        }

        public final void a(final aih com_tencent_mm_protocal_c_aih, final at atVar) {
            a(new com.tencent.mm.av.a.a<f>(this) {
                final /* synthetic */ a cSl;

                public final /* synthetic */ void an(Object obj) {
                    ((f) obj).a(com_tencent_mm_protocal_c_aih, atVar);
                }
            });
        }
    }

    public final String o(at atVar) {
        if (this.cSj != null) {
            return this.cSj.o(atVar);
        }
        return null;
    }

    public final void a(f fVar) {
        this.cSi.ay(fVar);
    }

    public final void a(com.tencent.mm.plugin.f.a.a.h.a aVar) {
        this.cSj = aVar;
    }

    public final f Hn() {
        return this.cSi;
    }
}
