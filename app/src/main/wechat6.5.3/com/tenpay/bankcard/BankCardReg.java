package com.tenpay.bankcard;

import com.tencent.bankcardrecog.BankCardInfo;
import com.tencent.bankcardrecog.BankCardRecog;
import com.tenpay.android.jni.Encrypt;

public class BankCardReg {
    private static final String TAG = "MyTag";

    public static int recognizeBankCardInit(int i, int i2, boolean z) {
        return BankCardRecog.recognizeBankCardInit(i, i2, z);
    }

    public static int recognizeBankCardProcess(byte[] bArr, BankCardInfo bankCardInfo, boolean[] zArr) {
        return BankCardRecog.recognizeBankCardProcess(bArr, bankCardInfo, zArr);
    }

    public static String getBankCardSegmentNumber(String str, int i, int[] iArr) {
        LogUtil.d(TAG, "getBankCardSegmentNumber");
        LogUtil.d(TAG, "cardNum=" + str);
        Encrypt encrypt = new Encrypt();
        String desedeDecode = encrypt.desedeDecode(str, encrypt.getRandomKey());
        LogUtil.d(TAG, "cardNum=" + desedeDecode);
        desedeDecode = BankCardRecog.getBankCardSegmentNumber(desedeDecode, i, iArr);
        LogUtil.d(TAG, desedeDecode);
        return encrypt.desedeEncode(desedeDecode, encrypt.getRandomKey());
    }

    public static int recognizeBankCardRelease() {
        return BankCardRecog.recognizeBankCardRelease();
    }

    public static int recognizeBankCardGetVersion() {
        return BankCardRecog.recognizeBankCardGetVersion();
    }
}
