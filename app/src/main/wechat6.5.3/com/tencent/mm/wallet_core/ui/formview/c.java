package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tenpay.android.wechat.TenpaySecureEditText;

interface c {

    public static class a {
        public static String a(int i, TenpaySecureEditText tenpaySecureEditText) {
            if (k.xT()) {
                v.v("MicroMsg.IEncryptDelegate", "hy: is payu. encrypt with payu");
                b bVar = new b();
                tenpaySecureEditText.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(i));
                return tenpaySecureEditText.get3DesEncrptData();
            }
            v.v("MicroMsg.IEncryptDelegate", "hy: is tenpay. encrypt with tenpay");
            c cVar = new c();
            switch (i) {
                case 0:
                    return tenpaySecureEditText.getEncryptDataWithHash(false);
                case 1:
                    return tenpaySecureEditText.getEncryptDataWithHash(true);
                case 2:
                    return tenpaySecureEditText.get3DesEncrptData();
                case 3:
                    return tenpaySecureEditText.get3DesVerifyCode();
                default:
                    return tenpaySecureEditText.getText().toString() == null ? "" : tenpaySecureEditText.getText().toString();
            }
        }
    }

    public static class b {
    }

    public static class c {
    }
}
