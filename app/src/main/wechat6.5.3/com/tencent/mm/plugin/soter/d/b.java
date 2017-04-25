package com.tencent.mm.plugin.soter.d;

import android.os.CancellationSignal;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.a.a.d;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.pluginsdk.l.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.security.Signature;

public final class b extends a {
    private String bgo;
    String fUl;
    com.tencent.mm.pluginsdk.l.b kdu;
    private CancellationSignal kdv;
    long kdw = -1;
    long kdx = -1;

    public final void aYP() {
        g gVar = (g) this.kdr;
        this.kdu = gVar.lER;
        this.bgo = gVar.bgo;
        this.fUl = gVar.fUl;
        this.kdv = gVar.kdv;
        this.kdw = gVar.kdw;
        this.kdx = -1;
        final Signature Co = k.Co(this.bgo);
        if (Co == null) {
            v.e("MicroMsg.SoterProcessAuthenticate", "hy: signature init error. finish");
            rl(15);
            return;
        }
        a cx = a.cx(this.mContext);
        if (k.cB(this.mContext) && k.cC(this.mContext)) {
            cx.a(new d(Co), this.kdv, new com.tencent.mm.plugin.soter.a.a.b(this) {
                final /* synthetic */ b kdz;

                public final void onAuthenticationError(int i, CharSequence charSequence) {
                    v.i("MicroMsg.SoterProcessAuthenticate", "authenticate process: onAuthenticationError");
                    if (this.kdz.kdu != null) {
                        this.kdz.kdu.s(i, charSequence.toString());
                    }
                }

                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                    v.i("MicroMsg.SoterProcessAuthenticate", "authenticate process: onAuthenticationHelp helpCode: %d, helpString: %s", new Object[]{Integer.valueOf(i), charSequence.toString()});
                    if (this.kdz.kdu != null) {
                        this.kdz.kdu.t(i, charSequence.toString());
                    }
                }

                public final void aYA() {
                    v.i("MicroMsg.SoterProcessAuthenticate", "authenticate process: onAuthenticationSucceeded");
                    if (this.kdz.kdu != null) {
                        try {
                            if (be.kS(this.kdz.fUl)) {
                                v.e("MicroMsg.SoterProcessAuthenticate", "hy: challenge is null or nill");
                                return;
                            }
                            Co.update(this.kdz.fUl.getBytes());
                            this.kdz.kdu.a(this.kdz.kds.bpR.bpU, Co);
                        } catch (Throwable e) {
                            v.a("MicroMsg.SoterProcessAuthenticate", e, "hy: signature update failed", new Object[0]);
                            this.kdz.kdu.kq(a.aYQ());
                        }
                    }
                }

                public final void onAuthenticationFailed() {
                    v.i("MicroMsg.SoterProcessAuthenticate", "hy: onAuthenticationFailed");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.kdz.kdx == -1) {
                        v.i("MicroMsg.SoterProcessAuthenticate", "hy: first fail. directly continue.");
                        this.kdz.kdx = currentTimeMillis;
                    } else {
                        v.i("MicroMsg.SoterProcessAuthenticate", "hy: request interval: %d, cur interval: %d", new Object[]{Long.valueOf(this.kdz.kdw), Long.valueOf(currentTimeMillis - this.kdz.kdx)});
                        this.kdz.kdx = currentTimeMillis;
                        if (currentTimeMillis - this.kdz.kdx < this.kdz.kdw) {
                            return;
                        }
                    }
                    if (this.kdz.kdu != null) {
                        this.kdz.kdu.kq(a.aYQ());
                    }
                }
            });
            rl(0);
            return;
        }
        v.e("MicroMsg.SoterProcessAuthenticate", "hy: no hardware detected or no fingerprint registered");
        if (!cx.isHardwareDetected()) {
            rl(12);
        } else if (!cx.hasEnrolledFingerprints()) {
            rl(13);
        }
    }

    protected final boolean aYR() {
        return false;
    }
}
