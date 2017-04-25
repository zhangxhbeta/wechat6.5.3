package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public abstract class c implements OnClickListener {
    protected int gjl;
    protected int goT = 1301;
    protected Context mContext;

    public c(Context context) {
        this.mContext = context;
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        }
    }

    protected static int a(Context context, n nVar) {
        if (nVar == null) {
            v.e("MicroMsg.GameMessageOnClickListener", "game message is null.");
            return 0;
        } else if (be.kS(nVar.field_appId)) {
            v.e("MicroMsg.GameMessageOnClickListener", "message type : " + nVar.field_msgType + " ,message.field_appId is null.");
            return 0;
        } else {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("game_app_id", nVar.field_appId);
            bundle.putInt("game_report_from_scene", 1301);
            return com.tencent.mm.plugin.game.e.c.a(context, nVar.field_appId, null, bundle);
        }
    }
}
