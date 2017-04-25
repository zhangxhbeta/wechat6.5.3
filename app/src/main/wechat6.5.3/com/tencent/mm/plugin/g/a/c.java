package com.tencent.mm.plugin.g.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.e.a.jg;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.scanner.a.o;
import com.tencent.mm.plugin.scanner.b.q;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.VcardContactUI;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import java.util.ArrayList;

public final class c {

    public interface a {
        void eW(boolean z);

        Context getContext();
    }

    public static boolean a(final a aVar, l lVar, OnClickListener onClickListener, String str, int i, int i2, Runnable runnable) {
        if (aVar == null || aVar.getContext() == null) {
            v.e("MicroMsg.scanner.GetA8KeyRedirect", "handleGetA8KeyRedirect, null redirectContext");
            return false;
        }
        int IV = lVar.IV();
        v.i("MicroMsg.scanner.GetA8KeyRedirect", "actionCode : " + IV);
        v.i("MicroMsg.scanner.GetA8KeyRedirect", "source=" + i);
        final Intent intent = new Intent();
        intent.putExtra("geta8key_scene", i);
        intent.putExtra("KPublisherId", "qrcode");
        intent.putExtra("prePublishId", "qrcode");
        f.ux(oC(i));
        String IT;
        String string;
        switch (IV) {
            case 1:
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-text: " + lVar.pO());
                intent.putExtra("data", lVar.pO());
                intent.putExtra("showShare", false);
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                intent.putExtra("pay_channel", oC(i));
                com.tencent.mm.plugin.scanner.a.drp.j(intent, aVar.getContext());
                new ac(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 2:
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview: " + lVar.IT());
                Context context = aVar.getContext();
                Context context2 = aVar.getContext();
                Object[] objArr = new Object[1];
                if (be.kS(str)) {
                    str = lVar.IT();
                }
                objArr[0] = str;
                final l lVar2 = lVar;
                final int i3 = i2;
                final int i4 = i;
                final a aVar2 = aVar;
                g.a(context, context2.getString(2131234268, objArr), aVar.getContext().getString(2131231164), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        intent.putExtra("title", lVar2.getTitle());
                        intent.putExtra("rawUrl", lVar2.IT());
                        if (i3 == 2) {
                            intent.putExtra("stastic_scene", 13);
                        } else if (i3 == 1) {
                            intent.putExtra("stastic_scene", 14);
                        } else {
                            intent.putExtra("stastic_scene", 11);
                        }
                        intent.putExtra("pay_channel", c.oC(i4));
                        com.tencent.mm.plugin.scanner.a.drp.j(intent, aVar2.getContext());
                    }
                }, onClickListener);
                return true;
            case 3:
                IT = lVar.IT();
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app: " + IT);
                if (IT == null || IT.length() == 0) {
                    v.e("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-app, fullUrl is null");
                    return false;
                }
                string = aVar.getContext().getString(2131234267);
                if (IT.startsWith("http")) {
                    string = aVar.getContext().getString(2131234268, new Object[]{IT});
                }
                Uri parse = Uri.parse(IT);
                if (parse != null) {
                    final Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                    intent2.addFlags(268435456);
                    if (be.m(aVar.getContext(), intent2)) {
                        g.a(aVar.getContext(), string, aVar.getContext().getString(2131231164), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                aVar.getContext().startActivity(intent2);
                            }
                        }, onClickListener);
                        return true;
                    }
                }
                return false;
            case 4:
                return false;
            case 6:
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-special_webview: " + lVar.IT());
                intent.putExtra("rawUrl", lVar.IT());
                intent.putExtra("pay_channel", oC(i));
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("isWebwx", false);
                com.tencent.mm.plugin.scanner.a.drp.j(intent, aVar.getContext());
                return true;
            case 7:
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-webview_no_notice: " + lVar.IT());
                intent.putExtra("title", lVar.getTitle());
                intent.putExtra("rawUrl", lVar.IT());
                if (i2 == 2) {
                    intent.putExtra("stastic_scene", 13);
                } else if (i2 == 1) {
                    intent.putExtra("stastic_scene", 14);
                } else {
                    intent.putExtra("stastic_scene", 11);
                }
                v.i("MicroMsg.scanner.GetA8KeyRedirect", "start webview with channel : " + oC(i));
                intent.putExtra("pay_channel", oC(i));
                com.tencent.mm.plugin.scanner.a.drp.j(intent, aVar.getContext());
                new ac(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 8:
                string = lVar.pO();
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "get vcard from server: " + string);
                if (!be.kS(string)) {
                    try {
                        new o().yP(string);
                        aVar.getContext().startActivity(new Intent(aVar.getContext(), VcardContactUI.class));
                        aVar.eW(false);
                        return true;
                    } catch (Throwable e) {
                        v.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e.getMessage() + " " + string);
                        v.a("MicroMsg.scanner.GetA8KeyRedirect", e, "", new Object[0]);
                    } catch (Throwable e2) {
                        v.e("MicroMsg.scanner.GetA8KeyRedirect", "parser vcardxml err: " + e2.getMessage() + " " + string);
                        v.a("MicroMsg.scanner.GetA8KeyRedirect", e2, "", new Object[0]);
                    }
                }
                g.a(aVar.getContext(), aVar.getContext().getString(2131234276), aVar.getContext().getString(2131231164), false, onClickListener);
                return true;
            case 9:
                Bundle bundle = new Bundle();
                bundle.putInt("key_scene", 5);
                return com.tencent.mm.plugin.scanner.a.drp.b(aVar.getContext(), lVar.IT(), bundle);
            case 10:
            case 11:
                a(aVar, IV, lVar.IT(), oC(i));
                new ac(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 12:
            case am.CTRL_INDEX /*15*/:
                a(aVar, IV, lVar.IT(), oC(i));
                return true;
            case an.CTRL_INDEX /*14*/:
                IT = lVar.IT();
                if (IT != null) {
                    IT = IT.replace("wxpd://", "");
                }
                intent = new Intent();
                intent.putExtra("key_product_id", IT);
                intent.putExtra("key_product_scene", 7);
                com.tencent.mm.ay.c.b(aVar.getContext(), "product", ".ui.MallProductUI", intent);
                return true;
            case 16:
                aa.getContext().startService(be.v(aa.getContext(), new Intent("com.tencent.mm.plugin.backup.bakpcmodel.BakchatPcUsbService")).putExtra("url", lVar.IT()).putExtra("isFromWifi", true));
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "GET_CONNECT_INFO start end");
                return true;
            case 17:
                final Intent intent3 = new Intent();
                intent3.putExtra("free_wifi_url", lVar.IT());
                string = "free_wifi_mid";
                rv rvVar = (rv) lVar.cif.czl.czs;
                if (rvVar == null || rvVar.lZj == null) {
                    v.e("MicroMsg.NetSceneGetA8Key", "get mid failed");
                    IT = null;
                } else {
                    IT = rvVar.lZj;
                }
                intent3.putExtra(string, IT);
                string = "free_wifi_ssid";
                rvVar = (rv) lVar.cif.czl.czs;
                if (rvVar == null || rvVar.SSID == null) {
                    v.e("MicroMsg.NetSceneGetA8Key", "get ssid failed");
                    IT = null;
                } else {
                    IT = rvVar.SSID;
                }
                intent3.putExtra(string, IT);
                intent3.putExtra("free_wifi_source", 1);
                intent3.putExtra("free_wifi_ap_key", lVar.IT());
                ak.yW();
                if (com.tencent.mm.model.c.vf().get(303104, null) != null) {
                    g.a(aVar.getContext(), 2131232951, 2131231164, 2131232968, 2131231010, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.ay.c.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                            aVar.eW(false);
                        }
                    }, onClickListener);
                } else {
                    com.tencent.mm.ay.c.b(aVar.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent3);
                    aVar.eW(false);
                }
                return true;
            case 18:
                com.tencent.mm.plugin.scanner.b.q.a zc = q.zc(lVar.IT());
                if (zc == null) {
                    v.e("MicroMsg.scanner.GetA8KeyRedirect", "item == null");
                } else if (q.iT(zc.eBL)) {
                    intent = new Intent();
                    intent.putExtra("key_card_id", zc.eBK);
                    intent.putExtra("key_card_ext", zc.bom);
                    intent.putExtra("key_from_scene", 0);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    com.tencent.mm.ay.c.b(aVar.getContext(), "card", ".ui.CardDetailUI", intent);
                    v.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_CARD start end");
                } else {
                    q.an(aVar.getContext(), aVar.getContext().getString(2131231661));
                }
                return false;
            case 20:
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-emoticon full url: " + lVar.IT());
                ak.vy().a(new w(lVar.IT()), 0);
                return true;
            case 21:
                Intent intent4 = new Intent();
                intent4.setClass(aVar.getContext(), ProductUI.class);
                intent4.putExtra("key_ProductUI_getProductInfoScene", 5);
                intent4.putExtra("key_Qrcode_Url", lVar.IT());
                aVar.getContext().startActivity(intent4);
                return true;
            case bf.CTRL_INDEX /*22*/:
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "ftf pay url:" + lVar.IT());
                e.a(aVar.getContext(), 1, lVar.IT(), oC(i), null);
                new ac(Looper.getMainLooper()).postDelayed(runnable, 200);
                return true;
            case 23:
                IT = lVar.IT();
                v.i("MicroMsg.scanner.GetA8KeyRedirect", "summerbak start MoveService");
                aa.getContext().startService(be.v(aa.getContext(), new Intent("com.tencent.mm.plugin.backup.movemodel.MoveService")).putExtra("url", IT));
                return true;
            case 24:
                mn mnVar = new mn();
                mnVar.bnL.bnM = str;
                com.tencent.mm.sdk.c.a.nhr.z(mnVar);
                return true;
            case 25:
                IT = lVar.IT();
                ArrayList zd = q.zd(IT);
                if (zd == null || zd.size() == 0) {
                    v.e("MicroMsg.scanner.GetA8KeyRedirect", "list == null || list.size() == 0");
                } else if (q.M(zd)) {
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 0);
                    intent.putExtra("src_username", "");
                    intent.putExtra("js_url", "");
                    intent.putExtra("key_in_card_list", IT);
                    if (i2 == 2) {
                        intent.putExtra("key_stastic_scene", 13);
                    } else if (i2 == 1) {
                        intent.putExtra("key_stastic_scene", 14);
                    } else {
                        intent.putExtra("key_stastic_scene", 11);
                    }
                    com.tencent.mm.ay.c.b(aVar.getContext(), "card", ".ui.CardAddEntranceUI", intent);
                    v.d("MicroMsg.scanner.GetA8KeyRedirect", "MMSCAN_QRCODE_MULTIPLE_CARD start end");
                } else {
                    q.an(aVar.getContext(), aVar.getContext().getString(2131231661));
                }
                return false;
            case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                IT = lVar.IT();
                v.i("MicroMsg.scanner.GetA8KeyRedirect", "fullURL: " + IT);
                v.i("MicroMsg.scanner.GetA8KeyRedirect", "processAppBrandFullURL, fullURL: " + IT);
                jg jgVar = new jg();
                jgVar.bjL.url = IT;
                if (i2 == 2) {
                    jgVar.bjL.scene = 1012;
                } else if (i2 == 1) {
                    jgVar.bjL.scene = 1013;
                } else {
                    jgVar.bjL.scene = 1011;
                }
                com.tencent.mm.sdk.c.a.nhr.z(jgVar);
                aVar.eW(false);
                return true;
            default:
                v.d("MicroMsg.scanner.GetA8KeyRedirect", "getA8key-not_catch: action code = " + lVar.IV());
                return false;
        }
    }

    private static void a(final a aVar, int i, String str, int i2) {
        v.d("MicroMsg.scanner.GetA8KeyRedirect", "actionCode = %s, url = %s", new Object[]{Integer.valueOf(i), str});
        final fz fzVar = new fz();
        fzVar.bfx.actionCode = i;
        fzVar.bfx.bfz = str;
        fzVar.bfx.context = aVar.getContext();
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", i2);
        fzVar.bfx.bfA = bundle;
        fzVar.bpT = new Runnable() {
            public final void run() {
                if (aVar != null && fzVar != null && fzVar.bfy != null) {
                    if (fzVar.bfy.ret == 1) {
                        aVar.eW(true);
                    } else if (fzVar.bfy.ret == 2) {
                        aVar.eW(false);
                    }
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.a(fzVar, Looper.myLooper());
    }

    protected static int oC(int i) {
        if (i == 30) {
            return 13;
        }
        if (i == 4 || i == 34) {
            return 12;
        }
        return 0;
    }
}
