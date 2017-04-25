package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.d.l;
import com.tencent.mm.plugin.webview.d.m;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.d.o;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.protocal.c.adq;
import com.tencent.mm.protocal.c.adr;
import com.tencent.mm.protocal.c.adw;
import com.tencent.mm.protocal.c.adx;
import com.tencent.mm.protocal.c.adz;
import com.tencent.mm.protocal.c.aea;
import com.tencent.mm.protocal.c.aeo;
import com.tencent.mm.protocal.c.bdg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e implements com.tencent.mm.v.e {
    Context context;
    final int ldX;
    final HashMap<String, adp> loj = new HashMap();
    final HashMap<String, String> lok = new HashMap();

    public interface a {

        public enum a {
            RET_OK(0),
            RET_FAIL(-1),
            RET_REJECT(-2),
            RET_ACCESS_DENIED(-3);
            
            private int aJW;

            private a(int i) {
                this.aJW = i;
            }

            public final int getCode() {
                return this.aJW;
            }
        }

        void a(a aVar, String str, LinkedList<bdg> linkedList, int i, int i2);
    }

    public interface b {
        int bie();
    }

    public static abstract class c implements a {
        public boolean lot = true;

        public boolean blc() {
            return this.lot;
        }

        public final void hE(boolean z) {
            this.lot = z;
        }
    }

    public final String Fu(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        String str3 = (String) this.lok.get(str);
        if (be.kS(str3)) {
            int indexOf = str.indexOf("#");
            if (indexOf >= 0) {
                str2 = str.substring(0, indexOf);
            }
            v.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[]{str3, str, str2});
            if (!be.kS(str2)) {
                str3 = (String) this.lok.get(str2);
            }
        }
        return str3;
    }

    public e(int i) {
        this.ldX = i;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(kVar instanceof b)) {
            v.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
        } else if (((b) kVar).bie() != this.ldX) {
            v.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[]{Integer.valueOf(this.ldX), Integer.valueOf(((b) kVar).bie())});
        } else {
            int type = kVar.getType();
            if (type == 1093) {
                ak.vy().b(1093, this);
                m mVar = (m) kVar;
                if (mVar == null) {
                    v.e("MicroMsg.webview.JSVerifyHelper", "");
                } else if (mVar.ldV == null) {
                    v.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
                } else {
                    int i3 = 0;
                    if (!(mVar.bif() == null || mVar.bif().mEx == null)) {
                        i3 = mVar.bif().mEx.bcd;
                    }
                    if (i == 0 && i2 == 0) {
                        adx bif = mVar.bif();
                        adw com_tencent_mm_protocal_c_adw = mVar.cif == null ? null : (adw) mVar.cif.czk.czs;
                        if (bif == null || be.kS(mVar.ldY) || com_tencent_mm_protocal_c_adw == null || be.kS(com_tencent_mm_protocal_c_adw.bmJ)) {
                            String str2 = "MicroMsg.webview.JSVerifyHelper";
                            String str3 = "something null %b, %b, %b";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(bif == null);
                            objArr[1] = Boolean.valueOf(be.kS(mVar.ldY));
                            objArr[2] = Boolean.valueOf(com_tencent_mm_protocal_c_adw == null);
                            v.e(str2, str3, objArr);
                            mVar.ldV.a(a.RET_FAIL, null, null, i2, i3);
                        } else if (bif.mEx == null) {
                            v.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
                            mVar.ldV.a(a.RET_FAIL, null, null, i2, i3);
                        } else if (bif.mEx.bcd != 0) {
                            v.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[]{Integer.valueOf(bif.mEx.bcd), bif.mEx.bce});
                            mVar.ldV.a(a.RET_FAIL, bif.mEx.bce, null, i2, i3);
                        } else {
                            this.lok.put(com_tencent_mm_protocal_c_adw.url, com_tencent_mm_protocal_c_adw.bmJ);
                            mVar.ldV.a(a.RET_OK, null, bif.mEF, i2, i3);
                        }
                    } else if (i == 4) {
                        mVar.ldV.a(a.RET_FAIL, i2 + "_" + str, null, i2, i3);
                    } else {
                        mVar.ldV.a(a.RET_FAIL, null, null, i2, i3);
                    }
                }
            } else if (type == 1095) {
                ak.vy().b(1095, this);
                a(i, i2, str, (l) kVar);
            } else if (type == 1094) {
                ak.vy().b(1094, this);
                n nVar = (n) kVar;
                if (nVar == null) {
                    v.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
                    return;
                }
                int i4;
                g.iuh.a(157, 24, 1, false);
                if (nVar.big() == null || nVar.big().mEx == null) {
                    i4 = 0;
                } else {
                    i4 = nVar.big().mEx.bcd;
                }
                if (i == 0 && i2 == 0) {
                    adz big = nVar.big();
                    if (big == null || big.mEx == null) {
                        v.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
                        nVar.ldV.a(a.RET_FAIL, null, null, i2, i4);
                        return;
                    } else if (big.mEx.bcd != 0) {
                        v.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[]{Integer.valueOf(big.mEx.bcd), big.mEx.bce});
                        nVar.ldV.a(a.RET_FAIL, big.mEx.bce, null, i2, i4);
                        return;
                    } else {
                        bdg com_tencent_mm_protocal_c_bdg = big.mEG;
                        if (com_tencent_mm_protocal_c_bdg == null) {
                            v.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
                            nVar.ldV.a(a.RET_FAIL, "verifyFail", null, i2, i4);
                            return;
                        } else if (com_tencent_mm_protocal_c_bdg.mZi != 1) {
                            v.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdg.mZi)});
                            nVar.ldV.a(a.RET_FAIL, "verifyFail", null, i2, i4);
                            return;
                        } else {
                            nVar.ldV.a(a.RET_OK, null, null, i2, i4);
                            return;
                        }
                    }
                }
                v.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                g.iuh.a(157, 25, 1, false);
                if (i == 4) {
                    nVar.ldV.a(a.RET_FAIL, i2 + "_" + str, null, i2, i4);
                } else {
                    nVar.ldV.a(a.RET_FAIL, null, null, i2, i4);
                }
            } else if (type == 1096) {
                ak.vy().b(1096, this);
                o oVar = (o) kVar;
                aea com_tencent_mm_protocal_c_aea = oVar.cif == null ? null : (aea) oVar.cif.czk.czs;
                if (com_tencent_mm_protocal_c_aea == null) {
                    v.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
                } else if (i != 0 || i2 != 0) {
                    v.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), com_tencent_mm_protocal_c_aea.mEp});
                } else if (com.tencent.mm.protocal.c.Is(be.ma(com_tencent_mm_protocal_c_aea.mEp)) == null) {
                    v.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    adp com_tencent_mm_protocal_c_adp = ((o) kVar).ldZ;
                    com_tencent_mm_protocal_c_adp.mEq = 1;
                    this.loj.put(com_tencent_mm_protocal_c_aea.mEp + com_tencent_mm_protocal_c_aea.url, com_tencent_mm_protocal_c_adp);
                }
            }
        }
    }

    private void a(int i, final int i2, String str, final l lVar) {
        if (lVar == null) {
            v.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
            return;
        }
        int i3 = 0;
        if (!(lVar.bid() == null || lVar.bid().mEx == null)) {
            i3 = lVar.bid().mEx.bcd;
        }
        if (i != 0 || i2 != 0) {
            v.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i == 4) {
                lVar.ldV.a(a.RET_FAIL, str, null, i2, i3);
            } else {
                lVar.ldV.a(a.RET_FAIL, null, null, i2, i3);
            }
        } else if (be.kS(lVar.ldW)) {
            v.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
            lVar.ldV.a(a.RET_FAIL, null, null, i2, i3);
        } else {
            adr bid = lVar.bid();
            if (bid == null || bid.mEx == null) {
                v.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
                lVar.ldV.a(a.RET_FAIL, null, null, i2, i3);
            } else if (bid.mEx.bcd != 0) {
                v.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[]{Integer.valueOf(bid.mEx.bcd), bid.mEx.bce});
                lVar.ldV.a(a.RET_FAIL, bid.mEx.bce, null, i2, i3);
            } else {
                v.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[]{Integer.valueOf(lVar.bic() == null ? 0 : lVar.bic().mEv)});
                if ((lVar.bic() == null ? 0 : lVar.bic().mEv) == 1) {
                    if (bid.mEA == null) {
                        v.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
                        lVar.ldV.a(a.RET_FAIL, null, null, i2, i3);
                        return;
                    }
                    Iterator it = bid.mEA.iterator();
                    while (it.hasNext()) {
                        aeo com_tencent_mm_protocal_c_aeo = (aeo) it.next();
                        if (com_tencent_mm_protocal_c_aeo.mEU == null) {
                            v.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
                        } else {
                            Iterator it2 = com_tencent_mm_protocal_c_aeo.mEU.iterator();
                            while (it2.hasNext()) {
                                String str2 = (String) it2.next();
                                if (!be.kS(str2)) {
                                    adp com_tencent_mm_protocal_c_adp = new adp();
                                    com_tencent_mm_protocal_c_adp.mEp = str2;
                                    com_tencent_mm_protocal_c_adp.mEq = com_tencent_mm_protocal_c_aeo.mES;
                                    com_tencent_mm_protocal_c_adp.mEr = com_tencent_mm_protocal_c_aeo.mET;
                                    this.loj.put(com_tencent_mm_protocal_c_adp.mEp + lVar.url, com_tencent_mm_protocal_c_adp);
                                }
                            }
                        }
                    }
                } else if (bid.mEy == null) {
                    v.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
                    lVar.ldV.a(a.RET_FAIL, "nullAuthInfo", null, i2, i3);
                    return;
                } else {
                    Iterator it3 = bid.mEy.iterator();
                    while (it3.hasNext()) {
                        adp com_tencent_mm_protocal_c_adp2 = (adp) it3.next();
                        if (!be.kS(com_tencent_mm_protocal_c_adp2.mEp)) {
                            this.loj.put(com_tencent_mm_protocal_c_adp2.mEp + lVar.url, com_tencent_mm_protocal_c_adp2);
                        }
                    }
                }
                final adp com_tencent_mm_protocal_c_adp3 = (adp) this.loj.get(lVar.ldW + lVar.url);
                if (com_tencent_mm_protocal_c_adp3 == null) {
                    v.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[]{lVar.ldW, lVar.url});
                    lVar.ldV.a(a.RET_FAIL, null, null, i2, i3);
                } else if (com_tencent_mm_protocal_c_adp3.mEq == 1) {
                    lVar.ldV.a(a.RET_OK, null, null, i2, i3);
                } else if (this.context == null) {
                    v.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
                    a(lVar, i2, com_tencent_mm_protocal_c_adp3);
                } else {
                    WebViewStubTempUI.a(this.context, be.ma(com_tencent_mm_protocal_c_adp3.mEr), "", this.context.getString(2131233449), this.context.getString(2131233448), new OnClickListener(this) {
                        final /* synthetic */ e lon;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            v.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
                            this.lon.a(lVar, i2, com_tencent_mm_protocal_c_adp3);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ e lon;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            v.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
                            lVar.ldV.a(a.RET_REJECT, "cancel", null, i2, lVar.bid().mEx.bcd);
                        }
                    });
                }
            }
        }
    }

    final void a(l lVar, int i, adp com_tencent_mm_protocal_c_adp) {
        adq bic = lVar.bic();
        adr bid = lVar.bid();
        if (bic == null) {
            v.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
            lVar.ldV.a(a.RET_FAIL, null, null, i, lVar.bid().mEx.bcd);
        } else if (bid == null) {
            v.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
            lVar.ldV.a(a.RET_FAIL, null, null, i, lVar.bid().mEx.bcd);
        } else {
            ak.vy().a(1096, this);
            LinkedList linkedList = bid.mEA;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    aeo com_tencent_mm_protocal_c_aeo = (aeo) it.next();
                    if (com_tencent_mm_protocal_c_aeo != null) {
                        v.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[]{com_tencent_mm_protocal_c_aeo.mEU, com_tencent_mm_protocal_c_aeo.mEw, com_tencent_mm_protocal_c_aeo.mET, Integer.valueOf(com_tencent_mm_protocal_c_aeo.mES), bic.mEp});
                        com_tencent_mm_protocal_c_aeo.mES = 1;
                    }
                }
                it = linkedList.iterator();
                while (it.hasNext()) {
                    if (((aeo) it.next()) != null) {
                        v.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[]{((aeo) it.next()).mEU, ((aeo) it.next()).mEw, ((aeo) it.next()).mET, Integer.valueOf(((aeo) it.next()).mES), bic.mEp});
                    }
                }
            }
            ak.vy().a(new o(com_tencent_mm_protocal_c_adp, bic.url, bic.gkz, bic.mEp, bic.fZV, bic.mEs, bic.bCj, bic.mEt, bic.mEu, bic.mEv, linkedList, this.ldX), 0);
            lVar.ldV.a(a.RET_OK, null, null, i, lVar.bid().mEx.bcd);
        }
    }
}
