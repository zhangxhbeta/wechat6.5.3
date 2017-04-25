package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.modelmsg.WXFileObject;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMusicObject;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.modelmsg.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class FavOpenApiEntry extends MMActivity {
    private String aHM;
    private ah aSW = new ah(new ah.a(this) {
        final /* synthetic */ FavOpenApiEntry fNQ;

        {
            this.fNQ = r1;
        }

        public final boolean oU() {
            if (this.fNQ.getWindow() != null && this.fNQ.getWindow().getDecorView() != null && this.fNQ.getWindow().getDecorView().getWindowToken() != null) {
                FavOpenApiEntry.a(this.fNQ, this.fNQ.fNN.nhM);
                return false;
            } else if (this.fNQ.fNP >= 10) {
                return false;
            } else {
                FavOpenApiEntry.b(this.fNQ);
                return true;
            }
        }
    }, true);
    private String appId;
    private Intent ens;
    private Bundle fNM;
    private c.a fNN;
    private String fNO;
    private int fNP = 0;

    static /* synthetic */ void a(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        boolean z = true;
        boolean z2 = false;
        if (wXMediaMessage == null) {
            v.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = wXMediaMessage.getType();
        h b;
        switch (type) {
            case 1:
                if (!be.kS(((WXTextObject) wXMediaMessage.mediaObject).text)) {
                    favOpenApiEntry.appId.equals("wx4310bbd51be7d979");
                    if (com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, wXMediaMessage.description, false, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage)) != null) {
                        z2 = true;
                        break;
                    }
                }
                v.e("MicroMsg.FavOpenApiEntry", "dealText null!");
                break;
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || e.aR(wXImageObject.imagePath)) {
                    if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                        wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                        b = (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) ? com.tencent.mm.pluginsdk.ui.applet.c.b(favOpenApiEntry.nDR, wXImageObject.imagePath, false, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage)) : com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, wXImageObject.imageData, false, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage));
                    } else {
                        b = com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, wXMediaMessage.thumbData, false, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage));
                    }
                    if (b != null) {
                        z2 = true;
                        break;
                    } else {
                        v.e("MicroMsg.FavOpenApiEntry", "showImgDialog fail, invalid argument");
                        break;
                    }
                }
                break;
            case 3:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, 2131165232, wXMediaMessage.title, false, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage)) : com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, wXMediaMessage.title, false, 2, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 4:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, 2131165244, wXMediaMessage.title, false, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage)) : com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, wXMediaMessage.title, false, 1, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 5:
                if (com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, wXMediaMessage.title, wXMediaMessage.description, false, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage)) == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 6:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, 2131165230, wXMediaMessage.title, false, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage)) : com.tencent.mm.pluginsdk.ui.applet.c.a(favOpenApiEntry.nDR, wXMediaMessage.title, false, 0, favOpenApiEntry.fNO, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 7:
            case 8:
                break;
            default:
                v.e("MicroMsg.FavOpenApiEntry", "unknown type = " + type);
                break;
        }
        if (!z2) {
            v.e("MicroMsg.FavOpenApiEntry", "deal fail, result is false finish()");
            favOpenApiEntry.finish();
        }
    }

    static /* synthetic */ int b(FavOpenApiEntry favOpenApiEntry) {
        int i = favOpenApiEntry.fNP + 1;
        favOpenApiEntry.fNP = i;
        return i;
    }

    static /* synthetic */ void b(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage == null) {
            v.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = wXMediaMessage.getType();
        i iVar;
        pw pwVar;
        switch (type) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (!be.kS(wXTextObject.text)) {
                    iVar = new i();
                    iVar.field_type = 1;
                    a(wXMediaMessage, iVar);
                    iVar.field_favProto.Jm(wXTextObject.text);
                    favOpenApiEntry.w(iVar);
                    com.tencent.mm.plugin.favorite.c.a.u(iVar);
                    break;
                }
                v.e("MicroMsg.FavOpenApiEntry", "addText null!");
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || e.aR(wXImageObject.imagePath)) {
                    iVar = new i();
                    iVar.field_type = 2;
                    a(wXMediaMessage, iVar);
                    favOpenApiEntry.w(iVar);
                    iVar.field_favProto.mtR.add(a(wXMediaMessage, wXImageObject.imagePath, wXImageObject.imageData, iVar.field_type));
                    com.tencent.mm.plugin.favorite.c.a.u(iVar);
                    break;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) wXMediaMessage.mediaObject;
                if (!be.kS(wXMusicObject.musicDataUrl) || !be.kS(wXMusicObject.musicUrl) || !be.kS(wXMusicObject.musicLowBandUrl)) {
                    iVar = new i();
                    iVar.field_type = 7;
                    a(wXMediaMessage, iVar);
                    pwVar = new pw();
                    pwVar.IC(wXMusicObject.musicUrl);
                    pwVar.IE(wXMusicObject.musicLowBandUrl);
                    pwVar.ID(wXMusicObject.musicDataUrl);
                    pwVar.Iw(wXMediaMessage.title);
                    pwVar.Ix(wXMediaMessage.description);
                    a(wXMediaMessage, pwVar, iVar.field_type);
                    pwVar.io(true);
                    pwVar.uG(iVar.field_type);
                    iVar.field_favProto.mtR.add(pwVar);
                    favOpenApiEntry.w(iVar);
                    com.tencent.mm.plugin.favorite.c.a.u(iVar);
                    break;
                }
                v.e("MicroMsg.FavOpenApiEntry", "addMusic, both url null");
                break;
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) wXMediaMessage.mediaObject;
                if (!be.kS(wXVideoObject.videoLowBandUrl) || !be.kS(wXVideoObject.videoUrl)) {
                    iVar = new i();
                    iVar.field_type = 4;
                    a(wXMediaMessage, iVar);
                    pwVar = new pw();
                    pwVar.IC(wXVideoObject.videoUrl);
                    pwVar.IE(wXVideoObject.videoLowBandUrl);
                    pwVar.Iw(wXMediaMessage.title);
                    pwVar.Ix(wXMediaMessage.description);
                    a(wXMediaMessage, pwVar, iVar.field_type);
                    pwVar.io(true);
                    pwVar.uG(iVar.field_type);
                    iVar.field_favProto.mtR.add(pwVar);
                    favOpenApiEntry.w(iVar);
                    com.tencent.mm.plugin.favorite.c.a.u(iVar);
                    break;
                }
                v.e("MicroMsg.FavOpenApiEntry", "addVideo, both url null");
                break;
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                if (!be.kS(wXWebpageObject.webpageUrl)) {
                    iVar = new i();
                    iVar.field_sessionId = favOpenApiEntry.getIntent().getStringExtra("reportSessionId");
                    iVar.field_type = 5;
                    a(wXMediaMessage, iVar);
                    favOpenApiEntry.w(iVar);
                    iVar.field_favProto.mtP.Ju(wXWebpageObject.webpageUrl);
                    if (wXMediaMessage.thumbData != null) {
                        pw pwVar2 = new pw();
                        pwVar2.Iw(wXMediaMessage.title);
                        pwVar2.Ix(wXMediaMessage.description);
                        a(wXMediaMessage, pwVar2, iVar.field_type);
                        pwVar2.io(true);
                        pwVar2.uG(iVar.field_type);
                        iVar.field_favProto.mtR.add(pwVar2);
                    }
                    com.tencent.mm.plugin.favorite.c.a.u(iVar);
                    break;
                }
                v.e("MicroMsg.FavOpenApiEntry", "addUrl null!");
                break;
            case 6:
                WXFileObject wXFileObject = (WXFileObject) wXMediaMessage.mediaObject;
                if (wXFileObject.fileData == null && !e.aR(wXFileObject.filePath)) {
                    v.e("MicroMsg.FavOpenApiEntry", "addFile data null");
                    break;
                }
                iVar = new i();
                iVar.field_type = 8;
                a(wXMediaMessage, iVar);
                favOpenApiEntry.w(iVar);
                iVar.field_favProto.mtR.add(a(wXMediaMessage, wXFileObject.filePath, wXFileObject.fileData, iVar.field_type));
                com.tencent.mm.plugin.favorite.c.a.u(iVar);
                break;
                break;
            default:
                v.e("MicroMsg.FavOpenApiEntry", "unsupport type = " + type);
                break;
        }
        favOpenApiEntry.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ens == null) {
            this.ens = getIntent();
        }
        this.fNM = this.ens.getExtras();
        this.appId = this.fNM.getString("SendAppMessageWrapper_AppId");
        if (this.appId == null) {
            this.appId = Uri.parse(this.fNM.getString("_mmessage_content")).getQueryParameter("appid");
        }
        this.fNN = new c.a(this.fNM);
        if (this.fNN.scene != 2) {
            v.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
            finish();
            return;
        }
        this.fNO = getString(2131232638);
        this.aHM = getString(2131231980, new Object[]{com.tencent.mm.plugin.favorite.c.getAppName(this, this.appId)});
        this.aSW.ea(100);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.ens = intent;
    }

    protected void onResume() {
        super.onResume();
    }

    private static void a(WXMediaMessage wXMediaMessage, i iVar) {
        iVar.field_sourceType = 4;
        iVar.field_favProto.Jl(wXMediaMessage.title);
        iVar.field_favProto.Jm(wXMediaMessage.description);
    }

    private void w(i iVar) {
        qg qgVar = new qg();
        qgVar.Jt(this.appId);
        qgVar.uN(4);
        qgVar.Jn(k.xF());
        qgVar.Jo(k.xF());
        iVar.field_fromUser = qgVar.bhM;
        iVar.field_toUser = qgVar.toUser;
        iVar.field_favProto.a(qgVar);
    }

    private static pw a(WXMediaMessage wXMediaMessage, String str, byte[] bArr, int i) {
        pw pwVar = new pw();
        pwVar.Iw(wXMediaMessage.title);
        pwVar.Ix(wXMediaMessage.description);
        pwVar.uG(i);
        if (str != null) {
            pwVar.IK(str);
            pwVar.IG(e.aS(str));
        } else {
            String m = g.m(bArr);
            if (bArr.length >= 256) {
                pwVar.II(m);
            } else {
                Object obj = new byte[256];
                System.arraycopy(bArr, 0, obj, 0, 256);
                pwVar.II(g.m(obj));
            }
            pwVar.IH(m);
            pwVar.dQ((long) bArr.length);
            pwVar.IJ(com.tencent.mm.plugin.favorite.b.v.aw(pwVar.toString(), i));
            e.e(com.tencent.mm.plugin.favorite.b.v.f(pwVar), bArr);
        }
        a(wXMediaMessage, pwVar, i);
        return pwVar;
    }

    private static void a(WXMediaMessage wXMediaMessage, pw pwVar, int i) {
        if (wXMediaMessage.thumbData != null) {
            String m = g.m(wXMediaMessage.thumbData);
            pwVar.IM(m);
            if (wXMediaMessage.thumbData.length >= 256) {
                pwVar.IN(m);
            } else {
                Object obj = new byte[256];
                System.arraycopy(wXMediaMessage.thumbData, 0, obj, 0, 256);
                pwVar.IN(g.m(obj));
            }
            if (be.kS(pwVar.luu)) {
                pwVar.IJ(com.tencent.mm.plugin.favorite.b.v.aw(pwVar.toString(), i));
            }
            pwVar.dR((long) wXMediaMessage.thumbData.length);
            e.e(com.tencent.mm.plugin.favorite.b.v.g(pwVar), wXMediaMessage.thumbData);
            return;
        }
        pwVar.ip(true);
    }

    private com.tencent.mm.pluginsdk.ui.applet.c.a a(final WXMediaMessage wXMediaMessage) {
        return new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
            final /* synthetic */ FavOpenApiEntry fNQ;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    FavOpenApiEntry.b(this.fNQ, wXMediaMessage);
                    ReportUtil.a(this.fNQ, ReportUtil.a(this.fNQ.getIntent().getExtras(), 0));
                    return;
                }
                this.fNQ.finish();
                ReportUtil.a(this.fNQ, ReportUtil.a(this.fNQ.getIntent().getExtras(), -2));
            }
        };
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
