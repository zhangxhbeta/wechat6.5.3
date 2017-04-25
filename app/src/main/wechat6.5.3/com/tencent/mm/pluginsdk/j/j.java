package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;

public final class j extends b {
    public j(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(p pVar) {
        v.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean c(p pVar) {
        v.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean d(p pVar) {
        v.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean e(p pVar) {
        v.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }
}
