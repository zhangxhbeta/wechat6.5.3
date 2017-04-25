package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;

public final class l extends b {
    public l(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(p pVar) {
        v.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean c(p pVar) {
        v.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean d(p pVar) {
        v.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean e(p pVar) {
        v.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }
}
