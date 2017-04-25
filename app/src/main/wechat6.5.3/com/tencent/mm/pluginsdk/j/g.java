package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;

public final class g extends b {
    public g(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ErrorClientProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(p pVar) {
        v.d("MicroMsg.ErrorClientProcessor", "handleOpenUrl");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean c(p pVar) {
        v.d("MicroMsg.ErrorClientProcessor", "handleIgnore");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean d(p pVar) {
        v.d("MicroMsg.ErrorClientProcessor", "handleFalseLast");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean e(p pVar) {
        v.d("MicroMsg.ErrorClientProcessor", "handleFalseCancel");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }
}
