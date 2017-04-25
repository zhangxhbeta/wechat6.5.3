package com.tencent.mm.plugin.accountsync.a;

import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class c implements ag {
    private static int dgH = 0;
    public static int dwl = a.dwp;
    private static ah dwn = null;
    private a dwk = null;
    private com.tencent.mm.plugin.accountsync.model.a dwm;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] dwo = new int[a.Oc().length];

        static {
            try {
                dwo[a.dwq - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                dwo[a.dwp - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                dwo[a.dwr - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] Oc() {
            return (int[]) dws.clone();
        }

        static {
            dwp = 1;
            dwq = 2;
            dwr = 3;
            dws = new int[]{dwp, dwq, dwr};
        }
    }

    static /* synthetic */ int ou() {
        int i = dgH;
        dgH = i + 1;
        return i;
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.dwm.dwx);
        this.dwm = null;
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        this.dwm = new com.tencent.mm.plugin.accountsync.model.a();
    }

    public final void aH(boolean z) {
    }

    public static void gN(int i) {
        dwl = i;
        switch (AnonymousClass2.dwo[i - 1]) {
            case 1:
                dgH = 0;
                if (dwn == null) {
                    dwn = new ah(new com.tencent.mm.sdk.platformtools.ah.a() {
                        public final boolean oU() {
                            c.ou();
                            if (c.dgH == 1 || c.dgH == 16 || c.dgH % 96 == 0) {
                                ak.oH().qt();
                            }
                            return true;
                        }
                    }, true);
                }
                v.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
                dwn.ea(900000);
                return;
            case 2:
            case 3:
                if (dwn != null) {
                    dwn.QI();
                }
                v.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
                dwl = a.dwp;
                ak.oH().qu();
                dgH = 0;
                dwn = null;
                return;
            default:
                return;
        }
    }
}
