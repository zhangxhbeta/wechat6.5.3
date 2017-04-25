package com.tencent.mm.plugin.soter.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
public final class b {

    static class AnonymousClass1 extends AuthenticationCallback {
        final /* synthetic */ a kcG;

        AnonymousClass1(a aVar) {
            this.kcG = aVar;
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            this.kcG.onAuthenticationError(i, charSequence);
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            this.kcG.onAuthenticationHelp(i, charSequence);
        }

        public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
            c cVar;
            a aVar = this.kcG;
            CryptoObject cryptoObject = authenticationResult.getCryptoObject();
            if (cryptoObject != null) {
                if (cryptoObject.getCipher() != null) {
                    cVar = new c(cryptoObject.getCipher());
                } else if (cryptoObject.getSignature() != null) {
                    cVar = new c(cryptoObject.getSignature());
                } else if (cryptoObject.getMac() != null) {
                    cVar = new c(cryptoObject.getMac());
                }
                aVar.a(new b(cVar));
            }
            cVar = null;
            aVar.a(new b(cVar));
        }

        public final void onAuthenticationFailed() {
            this.kcG.onAuthenticationFailed();
        }
    }

    public static abstract class a {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void a(b bVar) {
        }

        public void onAuthenticationFailed() {
        }
    }

    public static final class b {
        c kcH;

        public b(c cVar) {
            this.kcH = cVar;
        }
    }

    public static class c {
        final Signature kcD;
        final Cipher kcE;
        final Mac kcF;

        public c(Signature signature) {
            this.kcD = signature;
            this.kcE = null;
            this.kcF = null;
        }

        public c(Cipher cipher) {
            this.kcE = cipher;
            this.kcD = null;
            this.kcF = null;
        }

        public c(Mac mac) {
            this.kcF = mac;
            this.kcE = null;
            this.kcD = null;
        }
    }

    static FingerprintManager cA(Context context) {
        return (FingerprintManager) context.getSystemService("fingerprint");
    }
}
