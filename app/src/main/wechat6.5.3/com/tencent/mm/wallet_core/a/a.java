package com.tencent.mm.wallet_core.a;

import android.util.Base64;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

public final class a extends PayuSecureEncrypt {
    public a(int i) {
        this.mEncrptType = i;
    }

    public final String desedeEncode(String str, String str2) {
        return ea(str, str2);
    }

    public final String desedeVerifyCode(String str, String str2) {
        return ea(str, str2);
    }

    public final String encryptPasswd(boolean z, String str, String str2) {
        return ea(str, str2);
    }

    private String ea(String str, String str2) {
        if (!(this.mEncrptType == 40 || this.mEncrptType == -20)) {
            str = str.replaceAll(" ", "");
        }
        switch (this.mEncrptType) {
            case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
            case EncrptType.HASHED_PASSWORD /*-10*/:
            case EncrptType.VERIFY_CODE /*60*/:
                return d(true, str, str2);
            case 20:
            case 30:
            case 40:
            case 50:
                return d(false, str, str2);
            default:
                return str;
        }
    }

    private String d(boolean z, String str, String str2) {
        int i = this.mEncrptType;
        String str3 = PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT;
        if (-20 == this.mEncrptType) {
            i = 40;
        } else if (-10 == this.mEncrptType) {
            i = 20;
        }
        if (this.mEncrptType == -10 || this.mEncrptType == -20 || this.mEncrptType == 60) {
            str3 = PayuSecureEncrypt.ENCRYPT_VERSION_HASH;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        stringBuilder.append("|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        if (z) {
            stringBuilder.append(z.Kg(str));
        } else {
            stringBuilder.append(str);
        }
        String str4 = null;
        try {
            byte[] bytes = stringBuilder.toString().getBytes();
            PByteArray pByteArray = new PByteArray();
            if (!MMProtocalJni.rsaPublicEncrypt(bytes, pByteArray, getRsaEKey().getBytes("UTF-8"), getRsaNKey().getBytes("UTF-8"))) {
                v.e("MicroMsg.WxPayuSecureEncrypt", "MMProtocalJni encrypt failed!");
            }
            str4 = "01" + Base64.encodeToString(pByteArray.value, 2);
        } catch (Throwable e) {
            v.a("MicroMsg.WxPayuSecureEncrypt", e, "", new Object[0]);
        }
        return str4;
    }
}
