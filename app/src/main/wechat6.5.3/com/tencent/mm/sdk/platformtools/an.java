package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public final class an {
    public static boolean brE;
    private PhoneStateListener gPv;
    private TelephonyManager nkr;
    List<a> nks = new LinkedList();

    public interface a {
        void dx(int i);
    }

    public final void a(a aVar) {
        this.nks.add(aVar);
    }

    public final void dU(Context context) {
        if (this.nkr == null) {
            this.nkr = (TelephonyManager) context.getSystemService("phone");
        }
        if (this.gPv == null) {
            this.gPv = new PhoneStateListener(this) {
                final /* synthetic */ an nkt;

                {
                    this.nkt = r1;
                }

                public final void onCallStateChanged(int i, String str) {
                    if (this.nkt.nks.size() > 0) {
                        for (a dx : (a[]) this.nkt.nks.toArray(new a[this.nkt.nks.size()])) {
                            dx.dx(i);
                        }
                    }
                    super.onCallStateChanged(i, str);
                    switch (i) {
                        case 0:
                            an.brE = false;
                            return;
                        case 1:
                        case 2:
                            an.brE = true;
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        this.nkr.listen(this.gPv, 32);
    }
}
