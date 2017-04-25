package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
    public WifiManager aNW;
    public Condition aPJ;
    public Activity aXH;
    public long cAo;
    public boolean connected = false;
    public boolean fWB = false;
    public String fWC;
    public Lock fWu;
    public BroadcastReceiver fWx;
    public String ssid;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] fWF = new int[SupplicantState.values().length];

        static {
            try {
                fWF[SupplicantState.ASSOCIATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fWF[SupplicantState.ASSOCIATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                fWF[SupplicantState.AUTHENTICATING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                fWF[SupplicantState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                fWF[SupplicantState.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                fWF[SupplicantState.DORMANT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                fWF[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                fWF[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                fWF[SupplicantState.INACTIVE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                fWF[SupplicantState.INTERFACE_DISABLED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                fWF[SupplicantState.INVALID.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                fWF[SupplicantState.SCANNING.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                fWF[SupplicantState.UNINITIALIZED.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    public interface a {
        void kR(int i);

        void onSuccess();
    }

    class AnonymousClass1 implements a {
        final /* synthetic */ a fWD;
        final /* synthetic */ c fWE;

        public AnonymousClass1(c cVar, a aVar) {
            this.fWE = cVar;
            this.fWD = aVar;
        }

        public final void onSuccess() {
            v.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", new Object[]{m.s(this.fWE.aXH.getIntent()), Integer.valueOf(m.t(this.fWE.aXH.getIntent()))});
            this.fWD.onSuccess();
        }

        public final void kR(int i) {
            v.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", new Object[]{m.s(this.fWE.aXH.getIntent()), Integer.valueOf(m.t(this.fWE.aXH.getIntent())), Integer.valueOf(i)});
            this.fWD.kR(i);
        }
    }

    public c(String str, Activity activity, String str2) {
        this.aXH = activity;
        this.cAo = 30000;
        this.ssid = str;
        this.fWC = str2;
        this.fWu = new ReentrantLock();
        this.aPJ = this.fWu.newCondition();
        this.aNW = (WifiManager) aa.getContext().getSystemService("wifi");
    }

    public final void aom() {
        try {
            this.aXH.unregisterReceiver(this.fWx);
        } catch (IllegalArgumentException e) {
        }
    }
}
