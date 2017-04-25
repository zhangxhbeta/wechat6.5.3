package com.tencent.mm.plugin.favorite.b;

import android.os.Bundle;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.plugin.favorite.b.u.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class af implements a {
    public static u fMi = null;
    private static af fMj = null;
    public int bdW;
    public int duration;
    public String path;

    public static af aml() {
        if (fMj == null) {
            fMj = new af();
        }
        return fMj;
    }

    public static u amm() {
        if (fMi == null) {
            fMi = new u();
        }
        return fMi;
    }

    public static u amn() {
        return fMi;
    }

    public final void av(String str, int i) {
        v.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 1);
        if (be.ah(str, "").equals(this.path)) {
            bundle.putBoolean("result", false);
        } else {
            bundle.putBoolean("result", true);
        }
        bundle.putInt("position", i);
        jb jbVar = new jb();
        jbVar.bjB.bjx = bundle;
        jbVar.bjB.type = 4;
        com.tencent.mm.sdk.c.a.nhr.z(jbVar);
    }

    public final void onFinish() {
        fMi.XV();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 2);
        jb jbVar = new jb();
        jbVar.bjB.bjx = bundle;
        jbVar.bjB.type = 4;
        com.tencent.mm.sdk.c.a.nhr.z(jbVar);
    }

    public final void onPause() {
        fMi.alO();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 3);
        jb jbVar = new jb();
        jbVar.bjB.bjx = bundle;
        jbVar.bjB.type = 4;
        com.tencent.mm.sdk.c.a.nhr.z(jbVar);
    }
}
