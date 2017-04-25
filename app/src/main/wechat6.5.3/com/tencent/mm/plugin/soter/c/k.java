package com.tencent.mm.plugin.soter.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Base64;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.oo;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.soter.b.a;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;

public final class k {
    private static boolean kdp = false;

    public static boolean aYJ() {
        return gA(true);
    }

    public static boolean gA(boolean z) {
        if (!kdp) {
            try {
                Method method = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod("install", new Class[0]);
                method.setAccessible(true);
                method.invoke(null, new Object[0]);
                v.i("MicroMsg.SoterUtil", "hy: invoked install");
            } catch (Throwable e) {
                v.a("MicroMsg.SoterUtil", e, "", new Object[0]);
                v.e("MicroMsg.SoterUtil", "hy: no SoterProvider found");
            } catch (Throwable e2) {
                v.a("MicroMsg.SoterUtil", e2, "", new Object[0]);
                v.e("MicroMsg.SoterUtil", "hy: function not found");
            } catch (Throwable e22) {
                v.a("MicroMsg.SoterUtil", e22, "", new Object[0]);
                v.e("MicroMsg.SoterUtil", "hy: cannot access");
            } catch (Throwable e222) {
                v.a("MicroMsg.SoterUtil", e222, "", new Object[0]);
                v.e("MicroMsg.SoterUtil", "hy: InvocationTargetException");
            } finally {
                kdp = true;
            }
        }
        if (!z || p.ceG.bqg) {
            Provider[] providers = Security.getProviders();
            if (providers == null) {
                v.e("MicroMsg.SoterUtil", "hy: no provider supported");
                return false;
            }
            for (Provider name : providers) {
                if ("SoterKeyStore".equals(name.getName())) {
                    v.i("MicroMsg.SoterUtil", "hy: found soter provider");
                    return true;
                }
            }
            v.i("MicroMsg.SoterUtil", "hy: soter provider not found");
            return false;
        }
        v.i("MicroMsg.SoterUtil", "hy: dynamic config is not support soter");
        return false;
    }

    public static int aYK() {
        v.i("MicroMsg.SoterUtil", "hy: start generate ask");
        if (gA(true)) {
            try {
                KeyStore.getInstance("AndroidKeyStore").load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
                instance.initialize(a.Ci("WechatASK.addcounter.auto_signed_when_get_pubkey_attk").v("SHA-256").w("PSS").aYH());
                instance.generateKeyPair();
                v.i("MicroMsg.SoterUtil", "hy: generate successfully");
                return 0;
            } catch (Throwable e) {
                v.e("MicroMsg.SoterUtil", "hy: generateAppGlobalSecureKey " + e.toString());
                v.a("MicroMsg.SoterUtil", e, "", new Object[0]);
                return -1;
            }
        }
        v.e("MicroMsg.SoterUtil", "hy: not support soter");
        return 3;
    }

    public static boolean aYL() {
        v.i("MicroMsg.SoterUtil", "hy: start remove app global secure key");
        if (gA(true)) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                instance.deleteEntry("WechatASK");
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.SoterUtil", "hy: removeAppGlobalSecureKey " + e.toString());
            }
        } else {
            v.e("MicroMsg.SoterUtil", "hy: not support soter");
            return false;
        }
    }

    public static boolean aYM() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getCertificate("WechatASK") != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.SoterUtil", "hy: hasAppBlobalSecureKey exception: " + e.toString());
            return false;
        }
    }

    public static h aYN() {
        v.i("MicroMsg.SoterUtil", "hy: start get app global secure key pub");
        if (gA(true)) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                try {
                    Key key = instance.getKey("WechatASK", "from_soter_ui".toCharArray());
                    if (key != null) {
                        h aG = aG(key.getEncoded());
                        if (aG != null) {
                            e.do(aG.bgr, aG.uid);
                            return aG;
                        }
                        e.do("", "");
                        return aG;
                    }
                    v.e("MicroMsg.SoterUtil", "hy: key can not be retrieved");
                    return null;
                } catch (ClassCastException e) {
                    v.e("MicroMsg.SoterUtil", "hy: cast error: " + e.toString());
                    return null;
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.SoterUtil", e2, "", new Object[0]);
            }
        } else {
            v.e("MicroMsg.SoterUtil", "hy: not support soter");
            return null;
        }
    }

    public static int Ck(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.SoterUtil", "hy: auth key name is null or nil. abort.");
            return 1;
        } else if (gA(true)) {
            try {
                if (!aYM()) {
                    return 8;
                }
                KeyStore.getInstance("AndroidKeyStore").load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
                try {
                    instance.initialize(a.Ci(str + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", new Object[]{"WechatASK"})).v("SHA-256").aYI().w("PSS").aYH());
                    instance.generateKeyPair();
                    v.i("MicroMsg.SoterUtil", "hy: generate successfully");
                    return 0;
                } catch (Exception e) {
                    v.e("MicroMsg.SoterUtil", "hy: cause exception. maybe reflection exception: " + e.toString());
                    return 5;
                }
            } catch (Exception e2) {
                v.e("MicroMsg.SoterUtil", "hy: generateAppGlobalSecureKey " + e2.toString());
                return -1;
            }
        } else {
            v.e("MicroMsg.SoterUtil", "hy: not support soter");
            return 3;
        }
    }

    public static boolean ar(String str, boolean z) {
        if (be.kS(str)) {
            v.e("MicroMsg.SoterUtil", "hy: auth key name is null or nil. abort.");
            return false;
        }
        v.i("MicroMsg.SoterUtil", "hy: start remove key: " + str);
        if (gA(true)) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                instance.deleteEntry(str);
                if (z) {
                    v.i("MicroMsg.SoterUtil", "hy: auto delete ask");
                    if (aYM()) {
                        aYL();
                    }
                }
                return true;
            } catch (Throwable e) {
                v.a("MicroMsg.SoterUtil", e, "hy: removeAuthKey " + e.toString(), new Object[0]);
                return false;
            }
        }
        v.e("MicroMsg.SoterUtil", "hy: not support soter");
        return false;
    }

    public static boolean Cl(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.SoterUtil", "hy: authkey name not correct");
            return false;
        }
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load(null);
            if (instance.getCertificate(str) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.SoterUtil", "hy: hasAppBlobalSecureKey exception: " + e.toString());
            return false;
        }
    }

    public static boolean Cm(String str) {
        v.i("MicroMsg.SoterUtil", "hy: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", new Object[]{str, Boolean.valueOf(true)});
        if (be.kS(str)) {
            v.e("MicroMsg.SoterUtil", "hy: checking key valid: authkey name not correct");
            return false;
        }
        try {
            Cp(str);
            v.i("MicroMsg.SoterUtil", "hy: key valid");
            return true;
        } catch (UnrecoverableEntryException e) {
            v.e("MicroMsg.SoterUtil", "hy: key invalid.");
            ar(str, false);
            return false;
        } catch (InvalidKeyException e2) {
            v.e("MicroMsg.SoterUtil", "hy: key invalid.");
            ar(str, false);
            return false;
        } catch (Exception e3) {
            v.e("MicroMsg.SoterUtil", "hy: occurs other exceptions");
            return false;
        }
    }

    public static h Cn(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.SoterUtil", "hy: auth key name is null or nil. abort.");
            return null;
        } else if (gA(true)) {
            try {
                KeyStore instance = KeyStore.getInstance("SoterKeyStore");
                instance.load(null);
                try {
                    Key key = instance.getKey(str, "from_soter_ui".toCharArray());
                    if (key != null) {
                        h aG = aG(key.getEncoded());
                        if (aG != null) {
                            e.do(aG.bgr, aG.uid);
                        } else {
                            e.do("", "");
                        }
                        return aG;
                    }
                    v.e("MicroMsg.SoterUtil", "hy: key can not be retrieved");
                    return null;
                } catch (ClassCastException e) {
                    v.e("MicroMsg.SoterUtil", "hy: cast error: " + e.toString());
                    return null;
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.SoterUtil", e2, "", new Object[0]);
                return null;
            }
        } else {
            v.e("MicroMsg.SoterUtil", "hy: not support soterAndroidKeyStore");
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public static Signature Co(String str) {
        Signature signature = null;
        if (be.kS(str)) {
            v.e("MicroMsg.SoterUtil", "hy: auth key name is null or nil. abort.");
        } else if (gA(true)) {
            try {
                signature = Cp(str);
            } catch (UnrecoverableEntryException e) {
                v.e("MicroMsg.SoterUtil", "hy: key invalid. Advice remove the key");
            } catch (InvalidKeyException e2) {
                v.e("MicroMsg.SoterUtil", "hy: key invalid. Advice remove the key");
            } catch (Throwable e3) {
                v.e("MicroMsg.SoterUtil", "hy: exception when getSignatureResult: " + e3.toString());
                v.a("MicroMsg.SoterUtil", e3, "", new Object[0]);
            }
        } else {
            v.e("MicroMsg.SoterUtil", "hy: not support soterAndroidKeyStore");
        }
        return signature;
    }

    private static Signature Cp(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.SoterUtil", "hy: auth key name is null or nil. abort.");
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
        KeyStore instance2 = KeyStore.getInstance("SoterKeyStore");
        instance2.load(null);
        PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) instance2.getEntry(str, null);
        if (privateKeyEntry != null) {
            instance.initSign(privateKeyEntry.getPrivateKey());
            return instance;
        }
        v.e("MicroMsg.SoterUtil", "hy: entry not exists");
        return null;
    }

    public static i aE(byte[] bArr) {
        i iVar = null;
        if (be.bl(bArr)) {
            v.e("MicroMsg.SoterUtil", "origin is null or nil. abort");
        } else if (bArr.length < 4) {
            v.e("MicroMsg.SoterUtil", "hy: length not correct 1");
        } else {
            Object obj = new byte[4];
            System.arraycopy(bArr, 0, obj, 0, 4);
            int aF = aF(obj);
            v.d("Soter", "parsed raw length: " + aF);
            Object obj2 = new byte[aF];
            if (bArr.length <= aF + 4) {
                v.e("MicroMsg.SoterUtil", "hy: length not correct 2");
            } else {
                System.arraycopy(bArr, 4, obj2, 0, aF);
                iVar = i.Cj(new String(obj2));
                int length = bArr.length - (aF + 4);
                v.e("MicroMsg.SoterUtil", "hy: signature length: " + length);
                Object obj3 = new byte[length];
                System.arraycopy(bArr, aF + 4, obj3, 0, length);
                if (iVar != null) {
                    iVar.kdo = Base64.encodeToString(obj3, 2);
                }
            }
        }
        return iVar;
    }

    private static int aF(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            i2 += (bArr[i] & 255) << (i * 8);
            i++;
        }
        return i2;
    }

    private static h aG(byte[] bArr) {
        if (bArr == null) {
            v.e("Soter", "raw data is null");
            return null;
        }
        if (bArr.length < 4) {
            v.e("Soter", "raw data length smaller than RAW_LENGTH_PREFIX");
        }
        Object obj = new byte[4];
        System.arraycopy(bArr, 0, obj, 0, 4);
        int aF = aF(obj);
        v.d("Soter", "parsed raw length: " + aF);
        Object obj2 = new byte[aF];
        if (bArr.length <= aF + 4) {
            v.e("Soter", "length not correct 2");
            return null;
        }
        System.arraycopy(bArr, 4, obj2, 0, aF);
        String str = new String(obj2);
        v.d("Soter", "to convert json: " + str);
        h hVar = new h(str, "");
        int length = bArr.length - (aF + 4);
        v.e("MicroMsg.SoterUtil", "hy: signature length: " + length);
        Object obj3 = new byte[length];
        System.arraycopy(bArr, aF + 4, obj3, 0, length);
        hVar.bCj = Base64.encodeToString(obj3, 2);
        return hVar;
    }

    public static void a(int i, String str, String str2, final oo ooVar) {
        if (ooVar == null) {
            v.w("MicroMsg.SoterUtil", "hy: errCode: %d with null result", new Object[]{Integer.valueOf(i)});
            return;
        }
        ooVar.bpR.errCode = i;
        ooVar.bpR.biS = str;
        ooVar.bpR.bpU = str2;
        if (ooVar.bpQ.bpT != null) {
            ad.o(new Runnable() {
                public final void run() {
                    ooVar.bpQ.bpT.run();
                }
            });
        }
    }

    public static boolean cB(Context context) {
        return com.tencent.mm.plugin.soter.a.a.cx(context).isHardwareDetected();
    }

    public static boolean cC(Context context) {
        return gA(true) && com.tencent.mm.plugin.soter.a.a.cx(context).hasEnrolledFingerprints();
    }

    public static void aYO() {
        v.i("MicroMsg.SoterUtil", "alvinluo dynamic config support soter: %b", new Object[]{Boolean.valueOf(be.getInt(j.sU().getValue("SoterEntry"), 0) == 1)});
        if (be.getInt(j.sU().getValue("SoterEntry"), 0) == 1) {
            v.d("MicroMsg.SoterUtil", "alvinluo set all soter support flag to true");
            p.ceG.bqg = true;
            p.ceE.ceP = 1;
            p.ceE.ceQ = 1;
            v.d("MicroMsg.SoterUtil", "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[]{Boolean.valueOf(p.ceG.bqg), Integer.valueOf(p.ceE.ceP), Integer.valueOf(p.ceE.ceQ)});
        }
    }
}
