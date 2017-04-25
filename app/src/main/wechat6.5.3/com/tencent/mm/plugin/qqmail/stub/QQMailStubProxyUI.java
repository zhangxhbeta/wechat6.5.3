package com.tencent.mm.plugin.qqmail.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;

@a(7)
public class QQMailStubProxyUI extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.d("MicroMsg.QQMail.QQMailStubProxyUI", "onCreate");
        final c cVar = new c(this);
        cVar.a(new c.a(this) {
            final /* synthetic */ QQMailStubProxyUI ico;

            public final void aHJ() {
                v.d("MicroMsg.QQMail.QQMailStubProxyUI", "onAfterVerify");
                cVar.release();
                this.ico.setResult(-1);
                this.ico.finish();
            }

            public final void aHK() {
                v.e("MicroMsg.QQMail.QQMailStubProxyUI", "onVerifyFail, finish self");
                cVar.release();
                this.ico.setResult(0);
                this.ico.finish();
            }
        });
    }
}
