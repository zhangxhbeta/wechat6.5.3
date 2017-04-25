package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.at;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class u implements OnClickListener {
    int gjl = 0;
    private c gjs;
    String gpa = null;
    private int gyP;
    private Context mContext;

    public u(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof c) {
            this.gjs = (c) view.getTag();
            v.i("MicroMsg.GameTMAssistClickListener", "Clicked appid = " + this.gjs.field_appId);
            if (g.o(this.mContext, this.gjs.field_appId)) {
                v.d("MicroMsg.GameTMAssistClickListener", "launchFromWX, appId = " + this.gjs.field_appId + ", pkg = " + this.gjs.field_packageName + ", openId = " + this.gjs.field_openId);
                af.a(this.mContext, this.gjs.scene, this.gjs.bmG, 1, 3, this.gjs.field_appId, this.gjl, this.gpa);
                e.R(this.mContext, this.gjs.field_appId);
                return;
            }
            at.arX();
            this.gyP = at.uj(this.gjs.bxz);
            v.i("MicroMsg.GameTMAssistClickListener", "get download status:[%s]", new Object[]{Integer.valueOf(this.gyP)});
            switch (this.gyP) {
                case 1:
                    asC();
                    return;
                case 2:
                    asC();
                    return;
                case 3:
                    asC();
                    return;
                case 4:
                    asC();
                    return;
                case 5:
                    asC();
                    return;
                default:
                    asC();
                    return;
            }
        }
        v.e("MicroMsg.GameTMAssistClickListener", "No GameAppInfo");
    }

    private void asC() {
        int i;
        String str = this.gjs.bxz;
        if (!be.kS(str)) {
            str = str.replace("ANDROIDWX.GAMECENTER", "ANDROIDWX.YYB.GAMECENTER");
        }
        if (this.gjs.status == 3) {
            at.arX();
            at.startToAuthorized(this.mContext, str);
        } else {
            at.arX();
            at.V(this.mContext, str);
        }
        int i2 = 5;
        if (this.gjs.status == 3) {
            i2 = 10;
        }
        if (this.gyP == 4) {
            i = 8;
        } else {
            i = i2;
        }
        af.a(this.mContext, this.gjs.scene, this.gjs.bmG, this.gjs.position, i, this.gjs.field_appId, this.gjl, this.gjs.bln, this.gpa);
    }
}
