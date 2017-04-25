package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.e.a.ct;
import com.tencent.mm.e.a.cu;
import com.tencent.mm.e.a.cv;
import com.tencent.mm.e.a.cw;
import com.tencent.mm.e.a.cz;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.du;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a implements com.tencent.mm.pluginsdk.ui.tools.r.a {
    private static String cmW = "lan";
    private static a lnp;
    public String aZU;
    public boolean hasInit = false;
    public a lno;
    public byte[] lnq = null;
    private int lnr = -1;
    public boolean lns = false;

    public static class a {
        private String aZU = "";
        private e leB = null;
        public c lnt = new c<cz>(this) {
            final /* synthetic */ a lny;

            {
                this.lny = r2;
                this.nhz = cz.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.lny.v((cz) bVar);
            }
        };
        public c lnu = new c<ct>(this) {
            final /* synthetic */ a lny;

            {
                this.lny = r2;
                this.nhz = ct.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.lny.v((ct) bVar);
            }
        };
        public c lnv = new c<cu>(this) {
            final /* synthetic */ a lny;

            {
                this.lny = r2;
                this.nhz = cu.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.lny.v((cu) bVar);
            }
        };
        public c lnw = new c<cv>(this) {
            final /* synthetic */ a lny;

            {
                this.lny = r2;
                this.nhz = cv.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.lny.v((cv) bVar);
            }
        };
        public c lnx = new c<cw>(this) {
            final /* synthetic */ a lny;

            {
                this.lny = r2;
                this.nhz = cw.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                return this.lny.v((cw) bVar);
            }
        };

        public a(e eVar, String str) {
            this.leB = eVar;
            this.aZU = str;
        }

        final boolean v(b bVar) {
            if (bVar == null) {
                return false;
            }
            if (this.leB == null) {
                v.e("MicroMsg.webview.WebViewExDeviceLanMgr", "callbacker is null");
                return false;
            }
            try {
                Bundle bundle;
                if (bVar instanceof cz) {
                    v.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                    cz czVar = (cz) bVar;
                    if (be.kS(czVar.baY.aRh)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", czVar.baY.aRh);
                    bundle.putBoolean("exdevice_is_bound", czVar.baY.aZR);
                    this.leB.g(17, bundle);
                } else if (bVar instanceof ct) {
                    v.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceConnectStateEvent");
                    ct ctVar = (ct) bVar;
                    if (be.kS(ctVar.baN.aRh) || !this.aZU.equals(ctVar.baN.aZU)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", ctVar.baN.aRh);
                    bundle.putInt("exdevice_on_state_change_state", ctVar.baN.baO);
                    bundle.putString("exdevice_device_type", a.cmW);
                    this.leB.g(1004, bundle);
                } else if (bVar instanceof cu) {
                    v.d("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceRecvDataEvent");
                    cu cuVar = (cu) bVar;
                    if (be.kS(cuVar.baP.aRh) || be.kS(cuVar.baP.aZU) || cuVar.baP.data == null) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", cuVar.baP.aRh);
                    bundle.putByteArray("exdevice_data", cuVar.baP.data);
                    bundle.putString("exdevice_brand_name", cuVar.baP.aZU);
                    bundle.putString("exdevice_device_type", a.cmW);
                    this.leB.g(16, bundle);
                } else if (bVar instanceof cv) {
                    v.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceScanResultEvent");
                    cv cvVar = (cv) bVar;
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", cvVar.baQ.aRh);
                    bundle.putByteArray("exdevice_broadcast_data", cvVar.baQ.baR);
                    bundle.putBoolean("exdevice_is_complete", cvVar.baQ.baS);
                    bundle.putBoolean("exdevice_is_lan_device", true);
                    bundle.putString("exdevice_device_type", a.cmW);
                    this.leB.g(15, bundle);
                } else if (bVar instanceof cw) {
                    v.i("MicroMsg.webview.WebViewExDeviceLanMgr", "ExDeviceLanDeviceStateChangeEvent");
                    cw cwVar = (cw) bVar;
                    bundle = new Bundle();
                    if (cwVar.baT.baU) {
                        bundle.putBoolean("exdevice_lan_state", true);
                    } else {
                        bundle.putBoolean("exdevice_lan_state", false);
                    }
                    this.leB.g(47, bundle);
                }
            } catch (Exception e) {
                v.w("MicroMsg.webview.WebViewExDeviceLanMgr", "exception in WVExDeviceEventListener callback, %s", new Object[]{e.getMessage()});
            }
            return true;
        }
    }

    private a() {
    }

    public static a bkN() {
        if (lnp == null) {
            lnp = new a();
        }
        return lnp;
    }

    public final String getName() {
        return "WebViewExDeviceLanMgr";
    }

    public final void bkO() {
        v.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[]{Boolean.valueOf(this.lns)});
        if (this.lns) {
            du duVar = new du();
            duVar.bbN.aZV = false;
            com.tencent.mm.sdk.c.a.nhr.z(duVar);
            this.lns = false;
        }
        this.hasInit = false;
        if (this.lno != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.lno.lnt);
            com.tencent.mm.sdk.c.a.nhr.f(this.lno.lnu);
            com.tencent.mm.sdk.c.a.nhr.f(this.lno.lnw);
            com.tencent.mm.sdk.c.a.nhr.f(this.lno.lnv);
            com.tencent.mm.sdk.c.a.nhr.f(this.lno.lnx);
            this.lno = null;
        }
        this.lnq = null;
        dd ddVar = new dd();
        ddVar.bbc.aZV = false;
        com.tencent.mm.sdk.c.a.nhr.z(ddVar);
    }

    public final void cP(Context context) {
    }

    public final void bkP() {
    }
}
