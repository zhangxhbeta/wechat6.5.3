package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.wear.a.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.io.File;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.Cipher;

public final class b extends a {
    private byte[] aKD;
    private byte[] lbZ;
    private byte[] lca;

    public final byte[] uT() {
        boolean z = true;
        if (this.lca == null || this.lbZ == null || this.aKD == null) {
            boolean z2;
            v.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
            try {
                bhV();
            } catch (Throwable e) {
                v.a("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
            }
            String str = "MicroMsg.Wear.HttpAuthServer";
            String str2 = "publicKey %s privateKey %s sessionKey %s";
            Object[] objArr = new Object[3];
            if (this.lca != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Boolean.valueOf(this.lbZ != null);
            if (this.aKD == null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            v.i(str, str2, objArr);
        }
        return this.aKD;
    }

    private void bhV() {
        File file = new File(e.cnh, "wear/key");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "private.key");
        File file3 = new File(file, "public.key");
        File file4 = new File(file, "session.key");
        if (file2.exists() && file3.exists() && file4.exists()) {
            v.i("MicroMsg.Wear.HttpAuthServer", "use old keys");
            this.lca = com.tencent.mm.a.e.d(file3.getAbsolutePath(), 0, Integer.MAX_VALUE);
            this.lbZ = com.tencent.mm.a.e.d(file2.getAbsolutePath(), 0, Integer.MAX_VALUE);
            this.aKD = com.tencent.mm.a.e.d(file4.getAbsolutePath(), 0, Integer.MAX_VALUE);
        } else {
            v.i("MicroMsg.Wear.HttpAuthServer", "recreate keys");
            file2.delete();
            file3.delete();
            file4.delete();
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(1024);
            KeyPair generateKeyPair = instance.generateKeyPair();
            RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
            HashMap hashMap = new HashMap(2);
            hashMap.put("RSAPublicKey", rSAPublicKey);
            hashMap.put("RSAPrivateKey", rSAPrivateKey);
            RSAPrivateKey rSAPrivateKey2 = (RSAPrivateKey) hashMap.get("RSAPrivateKey");
            this.lca = ((RSAPublicKey) hashMap.get("RSAPublicKey")).getEncoded();
            this.lbZ = rSAPrivateKey2.getEncoded();
            this.aKD = a.bhX();
            com.tencent.mm.a.e.b(file2.getAbsolutePath(), this.lbZ, this.lbZ.length);
            com.tencent.mm.a.e.b(file3.getAbsolutePath(), this.lca, this.lca.length);
            com.tencent.mm.a.e.b(file4.getAbsolutePath(), this.aKD, this.aKD.length);
        }
        v.i("MicroMsg.Wear.HttpAuthServer", "publicKey=%s privateKey=%s sessionKey=%s", new Object[]{z.bi(this.lca), z.bi(this.lbZ), z.bi(this.aKD)});
    }

    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(10001));
        arrayList.add(Integer.valueOf(10002));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        boolean z = true;
        switch (i) {
            case 10001:
                boolean z2;
                v.i("MicroMsg.Wear.HttpAuthServer", "request public key");
                if (this.lca == null || this.lbZ == null || this.aKD == null) {
                    v.i("MicroMsg.Wear.HttpAuthServer", "try to reload all key");
                    try {
                        bhV();
                    } catch (Throwable e) {
                        v.a("MicroMsg.Wear.HttpAuthServer", e, "loadAllKey", new Object[0]);
                    }
                }
                String str = "MicroMsg.Wear.HttpAuthServer";
                String str2 = "publicKey %s privateKey %s sessionKey %s";
                Object[] objArr = new Object[3];
                if (this.lca != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                objArr[1] = Boolean.valueOf(this.lbZ != null);
                if (this.aKD == null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                v.i(str, str2, objArr);
                return this.lca;
            case 10002:
                try {
                    KeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(this.lbZ);
                    KeyFactory instance = KeyFactory.getInstance("RSA");
                    Key generatePrivate = instance.generatePrivate(pKCS8EncodedKeySpec);
                    Cipher instance2 = Cipher.getInstance(instance.getAlgorithm());
                    instance2.init(2, generatePrivate);
                    byte[] h = a.h(this.aKD, instance2.doFinal(bArr));
                    v.i("MicroMsg.Wear.HttpAuthServer", "funid %d, randomKey=%s", new Object[]{Integer.valueOf(i), z.bi(r1)});
                    return h;
                } catch (Throwable e2) {
                    v.a("MicroMsg.Wear.HttpAuthServer", e2, "sessionKey resp error", new Object[0]);
                    break;
                }
        }
        return null;
    }
}
