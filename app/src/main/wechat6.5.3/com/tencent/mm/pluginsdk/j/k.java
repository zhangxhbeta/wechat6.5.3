package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.v;

public final class k extends b {
    public k(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.ErrorTextStripleProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(p pVar) {
        v.d("MicroMsg.ErrorTextStripleProcessor", "handleOpenUrl");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean c(p pVar) {
        v.d("MicroMsg.ErrorTextStripleProcessor", "handleIgnore");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean d(p pVar) {
        v.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseLast");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }

    public final boolean e(p pVar) {
        v.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseCancel");
        Toast.makeText(this.aXH, pVar.content, 0).show();
        return true;
    }
}
