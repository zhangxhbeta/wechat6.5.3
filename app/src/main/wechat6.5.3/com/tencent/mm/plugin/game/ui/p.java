package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class p implements OnClickListener {
    int exT;
    private c ghX;
    String gwm = null;
    protected Context mContext;

    public p(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof c) {
            this.ghX = (c) view.getTag();
            v.i("MicroMsg.GamePreemptiveCliclListener", "Clicked appid = " + this.ghX.field_appId);
            if (g.o(this.mContext, this.ghX.field_appId)) {
                v.d("MicroMsg.GamePreemptiveCliclListener", "launchFromWX, appId = " + this.ghX.field_appId + ", pkg = " + this.ghX.field_packageName + ", openId = " + this.ghX.field_openId);
                e.R(this.mContext, this.ghX.field_appId);
                af.a(this.mContext, this.ghX.scene, this.ghX.bmG, this.ghX.position, 3, this.ghX.field_appId, this.exT, this.ghX.bln, this.ghX.ghF);
                return;
            }
            v.i("MicroMsg.GamePreemptiveCliclListener", "get preemptive url:[%s]", new Object[]{this.gwm});
            if (be.kS(this.gwm)) {
                v.e("MicroMsg.GamePreemptiveCliclListener", "null or nill preemptive url");
                return;
            }
            com.tencent.mm.plugin.game.e.c.W(this.mContext, this.gwm);
            af.a(this.mContext, this.ghX.scene, this.ghX.bmG, this.ghX.position, 11, this.ghX.field_appId, this.exT, this.ghX.bln, this.ghX.ghF);
            return;
        }
        v.e("MicroMsg.GamePreemptiveCliclListener", "No GameAppInfo");
    }
}
