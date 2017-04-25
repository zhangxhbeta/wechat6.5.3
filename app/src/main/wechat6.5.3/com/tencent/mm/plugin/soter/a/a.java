package com.tencent.mm.plugin.soter.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.sdk.platformtools.v;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class a {
    static final e kcA;
    private Context mContext;

    public static abstract class b {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void aYA() {
        }

        public void onAuthenticationFailed() {
        }
    }

    public static final class c {
        private d kcC;

        public c(d dVar) {
            this.kcC = dVar;
        }
    }

    public static class d {
        final Signature kcD;
        final Cipher kcE;
        final Mac kcF;

        public d(Signature signature) {
            this.kcD = signature;
            this.kcE = null;
            this.kcF = null;
        }

        public d(Cipher cipher) {
            this.kcE = cipher;
            this.kcD = null;
            this.kcF = null;
        }

        public d(Mac mac) {
            this.kcF = mac;
            this.kcE = null;
            this.kcD = null;
        }
    }

    private interface e {
        void a(Context context, d dVar, int i, CancellationSignal cancellationSignal, b bVar, Handler handler);

        boolean cy(Context context);

        boolean cz(Context context);
    }

    private static class a implements e {
        static /* synthetic */ boolean a(com.tencent.mm.plugin.soter.a.b.a aVar) {
            if (c.aYB()) {
                return false;
            }
            if (c.aYF()) {
                if (c.aYG()) {
                    return false;
                }
                c.aYE();
                return false;
            } else if (c.aYG()) {
                return false;
            } else {
                aVar.onAuthenticationError(10308, "Too many failed times");
                return true;
            }
        }

        public final boolean cy(Context context) {
            boolean z = false;
            try {
                z = b.cA(context).hasEnrolledFingerprints();
            } catch (Throwable e) {
                v.a("MicroMsg.FingerprintManagerCompat", e, "hy: user not authenticated hasEnrolledFingerprints", new Object[z]);
            }
            return z;
        }

        public final boolean cz(Context context) {
            boolean z = false;
            try {
                z = b.cA(context).isHardwareDetected();
            } catch (Throwable e) {
                v.a("MicroMsg.FingerprintManagerCompat", e, "hy: user not authenticated isHardwareDetected", new Object[z]);
            }
            return z;
        }

        public final void a(Context context, d dVar, int i, CancellationSignal cancellationSignal, final b bVar, Handler handler) {
            com.tencent.mm.plugin.soter.a.b.c cVar;
            com.tencent.mm.plugin.soter.a.b.a anonymousClass1;
            FingerprintManager cA;
            CryptoObject cryptoObject = null;
            if (dVar != null) {
                try {
                    if (dVar.kcE != null) {
                        cVar = new com.tencent.mm.plugin.soter.a.b.c(dVar.kcE);
                    } else if (dVar.kcD != null) {
                        cVar = new com.tencent.mm.plugin.soter.a.b.c(dVar.kcD);
                    } else if (dVar.kcF != null) {
                        cVar = new com.tencent.mm.plugin.soter.a.b.c(dVar.kcF);
                    }
                    anonymousClass1 = new com.tencent.mm.plugin.soter.a.b.a() {
                        public final void onAuthenticationError(int i, CharSequence charSequence) {
                            while (i != 5) {
                                if (i == 7) {
                                    v.i("MicroMsg.FingerprintManagerCompat", "hy: system call too many trial. syncing with wechat");
                                    if (!(c.aYG() || c.aYF() || c.aYB())) {
                                        c.aYD();
                                    }
                                    i = 10308;
                                    charSequence = "Too many failed times";
                                } else {
                                    bVar.onAuthenticationError(i, charSequence);
                                    return;
                                }
                            }
                            v.i("MicroMsg.FingerprintManagerCompat", "hy: user cancelled fingerprint authen");
                        }

                        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                            if (!a.a(this)) {
                                bVar.onAuthenticationHelp(i, charSequence);
                            }
                        }

                        public final void a(com.tencent.mm.plugin.soter.a.b.b bVar) {
                            if (!a.a(this)) {
                                d dVar;
                                c cVar;
                                if (!c.aYB()) {
                                    c.aYE();
                                }
                                b bVar2 = bVar;
                                com.tencent.mm.plugin.soter.a.b.c cVar2 = bVar.kcH;
                                if (cVar2 != null) {
                                    if (cVar2.kcE != null) {
                                        dVar = new d(cVar2.kcE);
                                    } else if (cVar2.kcD != null) {
                                        dVar = new d(cVar2.kcD);
                                    } else if (cVar2.kcF != null) {
                                        dVar = new d(cVar2.kcF);
                                    }
                                    cVar = new c(dVar);
                                    bVar2.aYA();
                                }
                                dVar = null;
                                cVar = new c(dVar);
                                bVar2.aYA();
                            }
                        }

                        public final void onAuthenticationFailed() {
                            if (!a.a(this)) {
                                if (!c.aYB()) {
                                    c.rk(Integer.valueOf(Integer.valueOf(c.aYC()).intValue() + 1).intValue());
                                    if (!c.aYG()) {
                                        c.aYD();
                                    }
                                }
                                bVar.onAuthenticationFailed();
                            }
                        }
                    };
                    cA = b.cA(context);
                    if (cVar != null) {
                        if (cVar.kcE != null) {
                            cryptoObject = new CryptoObject(cVar.kcE);
                        } else if (cVar.kcD != null) {
                            cryptoObject = new CryptoObject(cVar.kcD);
                        } else if (cVar.kcF != null) {
                            cryptoObject = new CryptoObject(cVar.kcF);
                        }
                    }
                    cA.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.mm.plugin.soter.a.b.AnonymousClass1(anonymousClass1), null);
                } catch (Throwable e) {
                    v.a("MicroMsg.FingerprintManagerCompat", e, "hy: user not authenticated authenticate", new Object[0]);
                    return;
                }
            }
            cVar = null;
            anonymousClass1 = /* anonymous class already generated */;
            cA = b.cA(context);
            if (cVar != null) {
                if (cVar.kcE != null) {
                    cryptoObject = new CryptoObject(cVar.kcE);
                } else if (cVar.kcD != null) {
                    cryptoObject = new CryptoObject(cVar.kcD);
                } else if (cVar.kcF != null) {
                    cryptoObject = new CryptoObject(cVar.kcF);
                }
            }
            cA.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.mm.plugin.soter.a.b.AnonymousClass1(anonymousClass1), null);
        }
    }

    private static class f implements e {
        public final boolean cy(Context context) {
            return false;
        }

        public final boolean cz(Context context) {
            return false;
        }

        public final void a(Context context, d dVar, int i, CancellationSignal cancellationSignal, b bVar, Handler handler) {
        }
    }

    public static a cx(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    static {
        int i = VERSION.SDK_INT;
        if (k.gA(false)) {
            kcA = new a();
        } else {
            kcA = new f();
        }
    }

    public final boolean hasEnrolledFingerprints() {
        return kcA.cy(this.mContext);
    }

    public final boolean isHardwareDetected() {
        return kcA.cz(this.mContext);
    }

    public final void a(d dVar, CancellationSignal cancellationSignal, b bVar) {
        kcA.a(this.mContext, dVar, 0, cancellationSignal, bVar, null);
    }
}
