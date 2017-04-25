package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.e.a.jo;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wenote.b.f;
import com.tencent.mm.plugin.wenote.b.f.AnonymousClass1;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.v;

public final class c extends com.tencent.mm.sdk.c.c<jo> {
    public c() {
        this.nhz = jo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jo joVar = (jo) bVar;
        jb jbVar = new jb();
        jbVar.bjB.type = 3;
        jbVar.bjB.bjy = 3;
        a.nhr.z(jbVar);
        v.i("MicroMsg.OpenNoteFromSessionListener", "do OpenNoteFromSessionListener");
        com.tencent.mm.plugin.wenote.b.b fVar = new f();
        com.tencent.mm.plugin.wenote.c.b.bma().lur = fVar;
        String str = joVar.bjY.bjZ;
        Long valueOf = Long.valueOf(joVar.bjY.bao);
        Context context = joVar.bjY.context;
        fVar.bjZ = str;
        fVar.lui = valueOf;
        fVar.cS(context);
        ak.vA().x(new AnonymousClass1(fVar, str));
        return false;
    }
}
