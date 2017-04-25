package com.tencent.mm.plugin.scanner.b;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.e.a.js;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.network.aa;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Map;

public final class e implements com.tencent.mm.plugin.g.a.c.a, com.tencent.mm.v.e {
    public String aHM;
    public int aYX;
    private ProgressDialog ezA = null;
    private int iDk;
    private String iDl;
    a iDm = null;
    private Map<k, Integer> iDn = new HashMap();
    private Activity pP;

    public interface a {
        void f(int i, Bundle bundle);
    }

    public e() {
        onResume();
    }

    public final void a(Activity activity, String str, int i, int i2, int i3, a aVar) {
        v.i("MicroMsg.QBarStringHandler", "deal QBarString %s, source:%d, codeType: %s, codeVersion: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.pP = activity;
        this.iDk = i;
        this.iDl = str;
        this.iDm = aVar;
        if (be.kS(str)) {
            v.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
        } else if (ak.vy().BJ() == 0) {
            Toast.makeText(activity, activity.getString(2131232875), 0).show();
            if (this.iDm != null) {
                this.iDm.f(0, null);
            }
        } else {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            if (be.kS(str2)) {
                c Ls = com.tencent.mm.model.c.c.Au().Ls("100160");
                boolean z = Ls.isValid() && "1".equals(Ls.buX().get("UsePayAuthNative"));
                c Ls2 = com.tencent.mm.model.c.c.Au().Ls("100161");
                boolean z2 = Ls2.isValid() && "1".equals(Ls2.buX().get("UsePrefixMatch"));
                v.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)});
                int pb;
                if (str.startsWith("weixin://wxpay/bizpayurl") && z) {
                    v.i("MicroMsg.QBarStringHandler", "do native pay");
                    pb = pb(this.iDk);
                    int oC = oC(pb);
                    final js jsVar = new js();
                    jsVar.bkf.url = str;
                    jsVar.bkf.bkh = oC;
                    jsVar.bkf.scene = pb;
                    jsVar.bkf.context = this.pP;
                    if (oC == 13) {
                        v.d("MicroMsg.QBarStringHandler", "add source and sourceType");
                        jsVar.bkf.aHM = this.aHM;
                        jsVar.bkf.aYX = this.aYX;
                    }
                    jsVar.bpT = new Runnable(this) {
                        final /* synthetic */ e iDp;

                        public final void run() {
                            if (this.iDp.getContext() != null && jsVar.bkg != null) {
                                if (jsVar.bkg.ret == 1) {
                                    this.iDp.eW(true);
                                } else if (jsVar.bkg.ret == 2) {
                                    this.iDp.eW(false);
                                }
                            }
                        }
                    };
                    com.tencent.mm.sdk.c.a.nhr.a(jsVar, Looper.myLooper());
                    new ac(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                        final /* synthetic */ e iDp;

                        {
                            this.iDp = r1;
                        }

                        public final void run() {
                            if (this.iDp.iDm != null) {
                                this.iDp.iDm.f(3, null);
                            }
                        }
                    }, 200);
                    return;
                } else if (str.startsWith("https://wx.tenpay.com/f2f") && z2) {
                    com.tencent.mm.pluginsdk.wallet.e.a(this.pP, 1, str, oC(pb(this.iDk)), null);
                    if (this.iDm != null) {
                        this.iDm.f(3, null);
                        return;
                    }
                    return;
                } else {
                    v.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[]{str, Integer.valueOf(this.iDk), Integer.valueOf(pb(this.iDk))});
                    final l lVar = new l(str, pb, i2, i3);
                    this.iDn.put(lVar, Integer.valueOf(1));
                    ak.vy().a(lVar, 0);
                    if (this.ezA != null) {
                        this.ezA.dismiss();
                    }
                    activity.getString(2131231164);
                    this.ezA = g.a(activity, activity.getString(2131234280), true, new OnCancelListener(this) {
                        final /* synthetic */ e iDp;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(lVar);
                            if (this.iDp.iDm != null) {
                                this.iDp.iDm.f(1, null);
                            }
                        }
                    });
                    return;
                }
            }
            c(activity, str2);
        }
    }

    private static int oC(int i) {
        if (i == 30) {
            return 13;
        }
        if (i == 4 || i == 34) {
            return 12;
        }
        return 0;
    }

    public final void aLS() {
        v.i("MicroMsg.QBarStringHandler", "cancel Deal");
        this.iDl = null;
        this.pP = null;
        onPause();
    }

    public final void onResume() {
        v.i("MicroMsg.QBarStringHandler", "onResume");
        ak.vy().a(106, this);
        ak.vy().a(233, this);
        ak.vy().a(666, this);
    }

    public final void onPause() {
        v.i("MicroMsg.QBarStringHandler", "onPause");
        ak.vy().b(106, this);
        ak.vy().b(233, this);
        ak.vy().b(666, this);
    }

    private void c(Activity activity, String str) {
        v.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[]{str});
        final y yVar = new y(str, 5);
        this.iDn.put(yVar, Integer.valueOf(1));
        ak.vy().a(yVar, 0);
        activity.getString(2131231164);
        this.ezA = g.a(activity, activity.getString(2131234767), new OnCancelListener(this) {
            final /* synthetic */ e iDp;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(yVar);
                if (this.iDp.iDm != null) {
                    this.iDp.iDm.f(1, null);
                }
            }
        });
    }

    private static int pb(int i) {
        if (i == 1) {
            return 34;
        }
        if (i == 0) {
            return 4;
        }
        return 30;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            String str2 = "MicroMsg.QBarStringHandler";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(kVar == null);
            v.e(str2, str3, objArr);
            if (this.iDm != null) {
                this.iDm.f(2, null);
                return;
            }
            return;
        }
        if (!this.iDn.containsKey(kVar)) {
            if (kVar instanceof w) {
                v.e("MicroMsg.QBarStringHandler", "emotion scan scene");
            } else {
                v.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
                return;
            }
        }
        this.iDn.remove(kVar);
        if (this.ezA != null) {
            this.ezA.dismiss();
            this.ezA = null;
        }
        if (i == 4 && i2 == -4) {
            g.a(this.pP, 2131234276, 2131231164, new OnClickListener(this) {
                final /* synthetic */ e iDp;

                {
                    this.iDp = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.iDp.iDm != null) {
                        this.iDp.iDm.f(1, null);
                    }
                }
            });
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (ak.vy().BK()) {
                    i.u(this.pP, ak.vy().getNetworkServerIp(), String.valueOf(i2));
                } else if (aa.bk(this.pP)) {
                    i.dl(this.pP);
                } else {
                    Toast.makeText(this.pP, this.pP.getString(2131232874, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.pP, this.pP.getString(2131232875, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            if (this.iDm != null) {
                this.iDm.f(1, null);
            }
        } else if (i == 4 && i2 == -2004) {
            g.f(this.pP, 2131234269, 2131231164);
            if (this.iDm != null) {
                this.iDm.f(1, null);
            }
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.pP, this.pP.getString(2131232920, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            if (this.iDm != null) {
                this.iDm.f(1, null);
            }
        } else if (kVar.getType() == 106) {
            ars Jx = ((y) kVar).Jx();
            str3 = m.a(Jx.moM);
            v.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + Jx.moM);
            n.AX().g(str3, m.a(Jx.mbY));
            if (this.ezA != null && this.ezA.isShowing()) {
                v.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                this.ezA.dismiss();
            }
            if (be.ma(str3).length() > 0) {
                int i3;
                ak.yW();
                u LX = com.tencent.mm.model.c.wH().LX(str3);
                if (LX != null && com.tencent.mm.i.a.ei(LX.field_type) && LX.bvm()) {
                    BizInfo ho = com.tencent.mm.modelbiz.u.Dy().ho(str3);
                    ho.aX(false);
                    ExtInfo extInfo = ho.cBt;
                    if (extInfo.cBx != null) {
                        extInfo.cBN = extInfo.cBx.optInt("ScanQRCodeType", 0);
                    }
                    if (!((extInfo.cBN == 1 ? 1 : null) == null || ho.Cz())) {
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", str3);
                        intent.putExtra("finish_direct", true);
                        com.tencent.mm.plugin.scanner.a.drp.e(intent, this.pP);
                        obj = 1;
                    }
                }
                switch (this.iDk) {
                    case 0:
                    case 2:
                        i3 = 30;
                        break;
                    case 1:
                        i3 = 45;
                        break;
                    default:
                        i3 = 30;
                        break;
                }
                Intent intent2 = new Intent();
                com.tencent.mm.pluginsdk.ui.tools.c.a(intent2, Jx, i3);
                if (!(LX == null || com.tencent.mm.i.a.ei(LX.field_type))) {
                    intent2.putExtra("Contact_IsLBSFriend", true);
                }
                if ((Jx.mFu & 8) > 0) {
                    com.tencent.mm.plugin.report.service.g.iuh.Y(10298, str3 + "," + i3);
                }
                if (this.pP != null) {
                    com.tencent.mm.plugin.scanner.a.drp.d(intent2, this.pP);
                }
                obj = 1;
            } else {
                if (this.pP != null) {
                    Toast.makeText(this.pP, 2131234791, 0).show();
                }
                obj = null;
            }
            if (obj != null) {
                if (this.iDm != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("geta8key_fullurl", m.a(((y) kVar).Jx().moM));
                    bundle.putInt("geta8key_action_code", 4);
                    this.iDm.f(3, bundle);
                }
            } else if (this.iDm != null) {
                this.iDm.f(1, null);
            }
        } else if (kVar.getType() == 233) {
            String IT = ((l) kVar).IT();
            Bundle bundle2 = new Bundle();
            bundle2.putString("geta8key_fullurl", IT);
            bundle2.putInt("geta8key_action_code", ((l) kVar).IV());
            if (this.iDm != null) {
                this.iDm.f(4, bundle2);
            }
            v.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[]{Integer.valueOf(pb(this.iDk))});
            boolean a = com.tencent.mm.plugin.g.a.c.a(this, (l) kVar, new OnClickListener(this) {
                final /* synthetic */ e iDp;

                {
                    this.iDp = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.iDp.iDm != null) {
                        this.iDp.iDm.f(1, null);
                    }
                }
            }, this.iDl, r4, this.iDk, new Runnable(this) {
                final /* synthetic */ e iDp;

                {
                    this.iDp = r1;
                }

                public final void run() {
                    if (this.iDp.iDm != null) {
                        this.iDp.iDm.f(3, null);
                    }
                }
            });
            if (a || ((l) kVar).IV() != 4) {
                v.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[]{Boolean.valueOf(a)});
                if (!a && this.iDm != null) {
                    this.iDm.f(1, null);
                    return;
                }
                return;
            }
            c(this.pP, IT);
        } else if (kVar.getType() != 666) {
        } else {
            if (i != 0 || i2 != 0) {
                v.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
            } else if (kVar instanceof w) {
                v.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[]{((w) kVar).Jv().mdM});
                Intent intent3 = new Intent();
                intent3.putExtra("extra_id", r0);
                intent3.putExtra("preceding_scence", 11);
                intent3.putExtra("download_entrance_scene", 14);
                com.tencent.mm.ay.c.b(this.pP, "emoji", ".ui.EmojiStoreDetailUI", intent3);
                v.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
                if (this.iDm != null) {
                    this.iDm.f(3, null);
                }
            }
        }
    }

    public final Context getContext() {
        return this.pP;
    }

    public final void eW(boolean z) {
        if (z) {
            if (this.iDm != null) {
                this.iDm.f(1, null);
            }
        } else if (this.iDm != null) {
            this.iDm.f(3, null);
        }
    }
}
