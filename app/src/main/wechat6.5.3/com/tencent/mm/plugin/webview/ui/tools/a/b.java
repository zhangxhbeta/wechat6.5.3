package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.e.a.cy;
import com.tencent.mm.e.a.cz;
import com.tencent.mm.e.a.da;
import com.tencent.mm.e.a.db;
import com.tencent.mm.e.a.de;
import com.tencent.mm.e.a.dk;
import com.tencent.mm.e.a.jk;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b implements com.tencent.mm.pluginsdk.ui.tools.r.a {
    private static final byte[] fuG = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static b lnA;
    public String aZU;
    public boolean hasInit = false;
    public int lnB = -1;
    public boolean lnC = false;
    public byte[] lnq = null;
    public boolean lns = false;
    public a lnz;

    public static class a {
        private String aZU = "";
        public c iSE = new c<cy>(this) {
            final /* synthetic */ a lnG;

            {
                this.lnG = r2;
                this.nhz = cy.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                return this.lnG.v((cy) bVar);
            }
        };
        private e leB = null;
        public c lnD = new c<db>(this) {
            final /* synthetic */ a lnG;

            {
                this.lnG = r2;
                this.nhz = db.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                return this.lnG.v((db) bVar);
            }
        };
        public c lnE = new c<da>(this) {
            final /* synthetic */ a lnG;

            {
                this.lnG = r2;
                this.nhz = da.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                return this.lnG.v((da) bVar);
            }
        };
        public c lnF = new c<jk>(this) {
            final /* synthetic */ a lnG;

            {
                this.lnG = r2;
                this.nhz = jk.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                return this.lnG.v((jk) bVar);
            }
        };
        public c lnt = new c<cz>(this) {
            final /* synthetic */ a lnG;

            {
                this.lnG = r2;
                this.nhz = cz.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                return this.lnG.v((cz) bVar);
            }
        };

        public a(e eVar, String str) {
            this.leB = eVar;
            this.aZU = str;
        }

        final boolean v(com.tencent.mm.sdk.c.b bVar) {
            if (bVar == null) {
                return false;
            }
            if (this.leB == null) {
                v.e("MicroMsg.webview.WebViewExDeviceMgr", "callbacker is null");
                return false;
            }
            try {
                Bundle bundle;
                if (bVar instanceof db) {
                    v.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnScanDeviceResultEvent");
                    db dbVar = (db) bVar;
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", dbVar.bba.aRh);
                    bundle.putByteArray("exdevice_broadcast_data", dbVar.bba.baR);
                    bundle.putBoolean("exdevice_is_complete", dbVar.bba.baS);
                    this.leB.g(15, bundle);
                } else if (bVar instanceof da) {
                    v.i("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnRecvDataFromDeviceEvent");
                    da daVar = (da) bVar;
                    if (be.kS(daVar.baZ.aRh) || be.kS(daVar.baZ.aZU) || daVar.baZ.data == null) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", daVar.baZ.aRh);
                    bundle.putByteArray("exdevice_data", daVar.baZ.data);
                    bundle.putString("exdevice_brand_name", daVar.baZ.aZU);
                    this.leB.g(16, bundle);
                } else if (bVar instanceof cz) {
                    v.d("MicroMsg.webview.WebViewExDeviceMgr", "ExDeviceOnDeviceBindStateChangeEvent");
                    cz czVar = (cz) bVar;
                    if (be.kS(czVar.baY.aRh)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", czVar.baY.aRh);
                    bundle.putBoolean("exdevice_is_bound", czVar.baY.aZR);
                    this.leB.g(17, bundle);
                } else if (bVar instanceof jk) {
                    jk jkVar = (jk) bVar;
                    if (jkVar.bjP.op != 2) {
                        return true;
                    }
                    if (be.kS(jkVar.bjP.bhG) || !this.aZU.equals(jkVar.bjP.bhG)) {
                        return true;
                    }
                    bundle = new Bundle();
                    bundle.putString("exdevice_device_id", jkVar.bjP.aRh);
                    bundle.putInt("exdevice_on_state_change_state", jkVar.bjP.baO);
                    this.leB.g(1004, bundle);
                } else if (bVar instanceof cy) {
                    cy cyVar = (cy) bVar;
                    bundle = new Bundle();
                    if (cyVar.baW.baX == 12) {
                        bundle.putBoolean("exdevice_bt_state", true);
                    } else {
                        bundle.putBoolean("exdevice_bt_state", false);
                    }
                    this.leB.g(18, bundle);
                }
            } catch (Exception e) {
                v.w("MicroMsg.webview.WebViewExDeviceMgr", "exception in WVExDeviceEventListener callback, %s", new Object[]{e.getMessage()});
            }
            return true;
        }
    }

    private b() {
    }

    public static b bkQ() {
        if (lnA == null) {
            lnA = new b();
        }
        return lnA;
    }

    public final String getName() {
        return "WebViewExDeviceMgr";
    }

    public final void bkO() {
        v.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[]{Boolean.valueOf(this.lns)});
        if (this.lns) {
            de deVar = new de();
            deVar.bbd.aZV = false;
            deVar.bbd.aZU = this.aZU;
            com.tencent.mm.sdk.c.a.nhr.z(deVar);
            if (!deVar.bbe.aZW) {
                v.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
            }
            this.lns = false;
        }
        this.hasInit = false;
        if (this.lnz != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.lnz.lnD);
            com.tencent.mm.sdk.c.a.nhr.f(this.lnz.lnE);
            com.tencent.mm.sdk.c.a.nhr.f(this.lnz.lnF);
            com.tencent.mm.sdk.c.a.nhr.f(this.lnz.lnt);
            com.tencent.mm.sdk.c.a.nhr.f(this.lnz.iSE);
            this.lnz = null;
        }
        this.lnq = null;
        dk dkVar = new dk();
        dkVar.bbu.aRh = "";
        dkVar.bbu.direction = 0;
        dkVar.bbu.bbw = true;
        com.tencent.mm.sdk.c.a.nhr.z(dkVar);
        v.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[]{Boolean.valueOf(dkVar.bbv.aZW)});
    }

    public static boolean aR(byte[] bArr) {
        if (bArr != null && bArr.length >= 9 && bArr[bArr.length - 7] == (byte) 1 && bArr[bArr.length - 8] == (byte) 1 && bArr[bArr.length - 9] == (byte) -2) {
            return true;
        }
        return false;
    }

    public final void cP(Context context) {
    }

    public final void bkP() {
    }
}
