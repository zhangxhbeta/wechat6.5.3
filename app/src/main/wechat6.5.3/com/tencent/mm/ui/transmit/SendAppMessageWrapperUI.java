package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.b;
import com.tencent.mm.sdk.modelmsg.WXMusicObject;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXVideoObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

@a(3)
public class SendAppMessageWrapperUI extends MMActivity {
    private String aHM = null;
    private ah aSW = new ah(new ah.a(this) {
        final /* synthetic */ SendAppMessageWrapperUI oXQ;

        {
            this.oXQ = r1;
        }

        public final boolean oU() {
            if (this.oXQ.getWindow() != null && this.oXQ.getWindow().getDecorView() != null && this.oXQ.getWindow().getDecorView().getWindowToken() != null) {
                SendAppMessageWrapperUI.c(this.oXQ);
                return false;
            } else if (this.oXQ.fNP >= 10) {
                return false;
            } else {
                SendAppMessageWrapperUI.b(this.oXQ);
                return true;
            }
        }
    }, true);
    private int fNP = 0;
    private f oXO = null;
    private boolean oXP = false;
    private WXMediaMessage oso = null;
    private int scene = 0;
    private String toUser = null;

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, WXMediaMessage wXMediaMessage, String str, int i) {
        v.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc msg[%s], text[%s], parsterLen[%d], scene[%d]", wXMediaMessage, str, Integer.valueOf(i), Integer.valueOf(sendAppMessageWrapperUI.scene));
        if (sendAppMessageWrapperUI.scene == 0) {
            String str2;
            String fz;
            String str3;
            bl.zQ().b(38, Integer.valueOf(1));
            if (wXMediaMessage.getType() != 8) {
                str2 = null;
            } else if (wXMediaMessage.thumbData == null) {
                v.e("MicroMsg.SendAppMessageWrapperUI", "summerbig code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                return;
            } else {
                str2 = j.a.bmr().a((Context) sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.oXO.field_appId);
                if (str2 == null) {
                    v.v("MicroMsg.SendAppMessageWrapperUI", "summerbig sendEmoji Fail cause emojiconmd5 is null");
                    return;
                }
                c rg = j.a.bmr().rg(str2);
                if (rg == null) {
                    v.i("MicroMsg.SendAppMessageWrapperUI", "emoji is null.");
                    return;
                }
                if (rg.field_size > be.getInt(com.tencent.mm.h.j.sU().getValue("InputLimitSendThirdPartyAppMsgEmotionBufSize"), 524288)) {
                    v.i("MicroMsg.SendAppMessageWrapperUI", "third party shared emoji can't bigger 512 KB");
                }
                g.iuh.h(13461, sendAppMessageWrapperUI.oXO.field_appId, sendAppMessageWrapperUI.oXO.field_appName, Integer.valueOf(rg.field_size));
            }
            if (wXMediaMessage.getType() == 5 || wXMediaMessage.getType() == 2) {
                v.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), appId : %s", sendAppMessageWrapperUI.oXO.field_appId);
                fz = o.fz("app_" + sendAppMessageWrapperUI.oXO.field_appId);
                o.yx().n(fz, true).l("prePublishId", "app_" + sendAppMessageWrapperUI.oXO.field_appId);
            } else {
                fz = null;
            }
            List<String> g = be.g(sendAppMessageWrapperUI.toUser.split(","));
            for (String str4 : g) {
                l.a(wXMediaMessage, sendAppMessageWrapperUI.oXO.field_appId, sendAppMessageWrapperUI.oXO.field_appName, str4, 2, str2, fz);
            }
            if (sendAppMessageWrapperUI.oXO.field_appId.equals("wx4310bbd51be7d979")) {
                str3 = null;
            } else {
                str3 = sendAppMessageWrapperUI.getString(2131231974, new Object[]{sendAppMessageWrapperUI.oXO.field_appName});
            }
            if (str3 == null) {
                str3 = sendAppMessageWrapperUI.getString(2131231973);
            }
            String str42 = sendAppMessageWrapperUI.getString(2131231981);
            com.tencent.mm.pluginsdk.ui.applet.c.a anonymousClass3 = new com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI) {
                final /* synthetic */ SendAppMessageWrapperUI oXQ;

                {
                    this.oXQ = r1;
                }

                public final void a(boolean z, String str, int i) {
                    this.oXQ.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
                    this.oXQ.finish();
                }
            };
            com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, sendAppMessageWrapperUI.getString(2131231978), str3, str42, new com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI) {
                final /* synthetic */ SendAppMessageWrapperUI oXQ;

                {
                    this.oXQ = r1;
                }

                public final void a(boolean z, String str, int i) {
                    this.oXQ.setResult(-1);
                    this.oXQ.finish();
                    ReportUtil.a(this.oXQ, ReportUtil.a(this.oXQ.getIntent().getExtras(), 0));
                }
            }, anonymousClass3);
            if (str == null || str.length() == 0) {
                v.i("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc, text is empty");
                return;
            }
            v.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dktext , send msg here:" + str);
            for (String iVar : g) {
                ak.vy().a(new i(iVar, str, m.fp(sendAppMessageWrapperUI.toUser)), 0);
            }
            return;
        }
        if (j.ak.lyd != null) {
            j.ak.lyd.a(wXMediaMessage, str, sendAppMessageWrapperUI.oXO.field_appId, sendAppMessageWrapperUI.oXO.field_appName, i);
            j.ak.lyd.aTe();
        }
        ReportUtil.a((Context) sendAppMessageWrapperUI, ReportUtil.a(sendAppMessageWrapperUI.getIntent().getExtras(), 0));
        sendAppMessageWrapperUI.finish();
    }

    static /* synthetic */ int b(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        int i = sendAppMessageWrapperUI.fNP + 1;
        sendAppMessageWrapperUI.fNP = i;
        return i;
    }

    static /* synthetic */ void c(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        boolean z = false;
        boolean z2 = true;
        if (sendAppMessageWrapperUI.oso == null) {
            v.e("MicroMsg.SendAppMessageWrapperUI", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = sendAppMessageWrapperUI.oso.getType();
        WXMediaMessage wXMediaMessage;
        h b;
        WXMediaMessage wXMediaMessage2;
        switch (type) {
            case 1:
                wXMediaMessage = sendAppMessageWrapperUI.oso;
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (wXTextObject.text != null && wXTextObject.text.length() != 0) {
                    sendAppMessageWrapperUI.oXO.field_appId.equals("wx4310bbd51be7d979");
                    if (com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, wXMediaMessage.description, true, sendAppMessageWrapperUI.a(wXMediaMessage)) != null) {
                        break;
                    }
                }
                v.e("MicroMsg.SendAppMessageWrapperUI", "dealText fail, text is empty");
                z2 = false;
                break;
            case 2:
                wXMediaMessage = sendAppMessageWrapperUI.oso;
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                    b = (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) ? com.tencent.mm.pluginsdk.ui.applet.c.b(sendAppMessageWrapperUI.nDR, wXImageObject.imagePath, true, sendAppMessageWrapperUI.a(wXMediaMessage)) : com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, wXImageObject.imageData, true, sendAppMessageWrapperUI.a(wXMediaMessage));
                } else {
                    b = com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, wXMediaMessage.thumbData, true, sendAppMessageWrapperUI.a(wXMediaMessage));
                }
                if (b == null) {
                    v.e("MicroMsg.SendAppMessageWrapperUI", "showDialogItem3 fail, invalid argument");
                } else {
                    z = true;
                }
                z2 = z;
                break;
            case 3:
                wXMediaMessage2 = sendAppMessageWrapperUI.oso;
                b = (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) ? com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, 2131165232, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) : com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, wXMediaMessage2.title, true, 2, sendAppMessageWrapperUI.a(wXMediaMessage2));
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 4:
                wXMediaMessage2 = sendAppMessageWrapperUI.oso;
                b = (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) ? com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, 2131165244, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) : com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, wXMediaMessage2.title, true, 1, sendAppMessageWrapperUI.a(wXMediaMessage2));
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 5:
                WXMediaMessage wXMediaMessage3 = sendAppMessageWrapperUI.oso;
                if (com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, wXMediaMessage3.title, wXMediaMessage3.description, true, sendAppMessageWrapperUI.nDR.nEl.getResources().getString(2131231979), sendAppMessageWrapperUI.a(wXMediaMessage3)) == null) {
                    z2 = false;
                    break;
                }
                break;
            case 6:
                wXMediaMessage2 = sendAppMessageWrapperUI.oso;
                b = (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) ? com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, 2131165230, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) : com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.a(wXMediaMessage2));
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 7:
                wXMediaMessage2 = sendAppMessageWrapperUI.oso;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    Bitmap b2 = com.tencent.mm.pluginsdk.model.app.g.b(sendAppMessageWrapperUI.oXO.field_appId, 1, com.tencent.mm.bd.a.getDensity(sendAppMessageWrapperUI));
                    if (b2 == null || b2.isRecycled()) {
                        b = com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, 2131165247, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2));
                    } else {
                        k kVar = sendAppMessageWrapperUI.nDR;
                        CharSequence charSequence = wXMediaMessage2.title;
                        CharSequence charSequence2 = wXMediaMessage2.description;
                        CharSequence charSequence3 = sendAppMessageWrapperUI.aHM;
                        com.tencent.mm.pluginsdk.ui.applet.c.a a = sendAppMessageWrapperUI.a(wXMediaMessage2);
                        View J = com.tencent.mm.pluginsdk.ui.applet.c.J(kVar.nEl, 2130903399);
                        h.a aVar = new h.a(kVar.nEl);
                        aVar.jk(false);
                        aVar.jl(false);
                        com.tencent.mm.pluginsdk.ui.applet.c.k(J, true);
                        com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, aVar, a, J, kVar.nEl.getResources().getString(2131231979));
                        TextView textView = (TextView) J.findViewById(2131756412);
                        textView.setText(e.a(kVar.nEl, charSequence, textView.getTextSize()));
                        textView = (TextView) J.findViewById(2131756407);
                        textView.setText(e.a(kVar.nEl, charSequence2, textView.getTextSize()));
                        textView = (TextView) J.findViewById(2131756408);
                        if (charSequence3 == null || charSequence3.length() == 0) {
                            textView.setVisibility(8);
                        } else {
                            textView.setText(charSequence3);
                            textView.setVisibility(0);
                        }
                        ImageView imageView = (ImageView) J.findViewById(2131756406);
                        if (imageView != null) {
                            if (b2 == null || b2.isRecycled()) {
                                v.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
                                imageView.setVisibility(8);
                            } else {
                                imageView.setVisibility(0);
                                imageView.setImageBitmap(b2);
                                com.tencent.mm.pluginsdk.ui.applet.c.a(aVar, b2);
                            }
                        }
                        aVar.cC(J);
                        b = aVar.RX();
                        b.show();
                    }
                } else {
                    b = com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 8:
                wXMediaMessage2 = sendAppMessageWrapperUI.oso;
                String a2 = j.a.bmr().a((Context) sendAppMessageWrapperUI, wXMediaMessage2, sendAppMessageWrapperUI.oXO.field_appId);
                String string = sendAppMessageWrapperUI.nDR.nEl.getIntent().getExtras().getString("Select_Conv_User", null);
                if (be.kS(a2)) {
                    if (com.tencent.mm.pluginsdk.ui.applet.c.a(sendAppMessageWrapperUI.nDR, 2131165247, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) == null) {
                        z2 = false;
                        break;
                    }
                }
                com.tencent.mm.pluginsdk.ui.applet.c.c cVar = new com.tencent.mm.pluginsdk.ui.applet.c.c(sendAppMessageWrapperUI.nDR.nEl);
                cVar.ba(string).Hy(a2).d(Boolean.valueOf(true)).tS(2131231149).a(sendAppMessageWrapperUI.a(wXMediaMessage2)).iji.show();
                if (cVar.iji == null) {
                    z2 = false;
                    break;
                }
                break;
            default:
                v.e("MicroMsg.SendAppMessageWrapperUI", "unknown type = " + type);
                z2 = false;
                break;
        }
        if (!z2) {
            v.e("MicroMsg.SendAppMessageWrapperUI", "deal fail, result is false");
            sendAppMessageWrapperUI.finish();
        }
    }

    static /* synthetic */ void d(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        if (sendAppMessageWrapperUI.scene == 0) {
            Intent intent = new Intent();
            intent.putExtra("Select_Report_Args", ReportUtil.a(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
            sendAppMessageWrapperUI.setResult(0, intent);
        } else {
            ReportUtil.a((Context) sendAppMessageWrapperUI, ReportUtil.a(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
        }
        sendAppMessageWrapperUI.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cU().cV().hide();
        SharedPreferences sharedPreferences = getSharedPreferences(aa.bti(), 0);
        if (!sharedPreferences.getBoolean("settings_landscape_mode", false)) {
            v.d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
            this.oXP = true;
            setRequestedOrientation(-1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", true).commit();
        }
        Bundle extras = getIntent().getExtras();
        com.tencent.mm.sdk.modelmsg.c.a aVar = new com.tencent.mm.sdk.modelmsg.c.a(extras);
        this.toUser = extras.getString("Select_Conv_User");
        this.scene = extras.getInt("SendAppMessageWrapper_Scene", 0);
        String string = extras.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            string = Uri.parse(extras.getString("_mmessage_content")).getQueryParameter("appid");
        }
        this.oXO = new f();
        this.oXO.field_appId = string;
        am.bnB().b(this.oXO, new String[0]);
        if (this.oXO.field_appName == null) {
            string = getString(2131231982);
        } else {
            string = com.tencent.mm.pluginsdk.model.app.g.a(this.nDR.nEl, this.oXO, null);
        }
        this.aHM = getString(2131231980, new Object[]{string});
        this.oso = aVar.nhM;
        v.v("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s", this.oso.messageAction, this.oso.messageExt);
        if (this.scene == 1) {
            int i;
            Intent intent;
            WXMediaMessage wXMediaMessage = this.oso;
            String str = this.oXO.field_appId;
            String str2 = this.oXO.field_appName;
            v.d("MicroMsg.ShareSnsImpl", "appmsg.description " + wXMediaMessage.description);
            v.d("MicroMsg.ShareSnsImpl", "appmsg.title " + wXMediaMessage.title);
            b bVar = wXMediaMessage.mediaObject;
            switch (bVar.type()) {
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                case 6:
                    i = 3;
                    break;
                case 7:
                    i = 3;
                    break;
                default:
                    i = -1;
                    break;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("KThrid_app", true);
            v.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i + " " + bVar.type());
            intent2.putExtra("Ksnsupload_appid", str);
            intent2.putExtra("Ksnsupload_appname", str2);
            intent2.putExtra("KSnsAction", true);
            intent2.putExtra("need_result", true);
            Bundle bundle2 = new Bundle();
            com.tencent.mm.sdk.modelmsg.c.a aVar2 = new com.tencent.mm.sdk.modelmsg.c.a();
            aVar2.nhM = wXMediaMessage;
            aVar2.t(bundle2);
            intent2.putExtra("Ksnsupload_timeline", bundle2);
            if (i != -1) {
                switch (bVar.type()) {
                    case 1:
                        intent2.putExtra("Kdescription", ((WXTextObject) bVar).text);
                        intent2.putExtra("Ksnsupload_type", 8);
                        intent = intent2;
                        break;
                    case 2:
                        WXImageObject wXImageObject = (WXImageObject) bVar;
                        intent2.putExtra("KBlockAdd", true);
                        intent2.putExtra("Ksnsupload_type", 0);
                        intent2.putExtra("sns_kemdia_path", wXImageObject.imagePath);
                        intent = intent2;
                        break;
                    case 3:
                        WXMusicObject wXMusicObject = (WXMusicObject) bVar;
                        String ah = be.ah(!be.kS(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, SQLiteDatabase.KeyEmpty);
                        be.ah(!be.kS(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, SQLiteDatabase.KeyEmpty);
                        be.ah(!be.kS(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, SQLiteDatabase.KeyEmpty);
                        intent2.putExtra("Ksnsupload_link", ah);
                        intent2.putExtra("Ksnsupload_title", SQLiteDatabase.KeyEmpty);
                        intent2.putExtra("Ksnsupload_type", 2);
                        intent2.putExtra("ksnsis_music", true);
                        intent = intent2;
                        break;
                    case 4:
                        WXVideoObject wXVideoObject = (WXVideoObject) bVar;
                        intent2.putExtra("Ksnsupload_link", be.ah(!be.kS(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, SQLiteDatabase.KeyEmpty));
                        intent2.putExtra("Ksnsupload_title", SQLiteDatabase.KeyEmpty);
                        intent2.putExtra("Ksnsupload_type", 1);
                        intent2.putExtra("ksnsis_video", true);
                        intent = intent2;
                        break;
                    case 5:
                        intent2.putExtra("Ksnsupload_link", ((WXWebpageObject) bVar).webpageUrl);
                        intent2.putExtra("Ksnsupload_title", be.ah(wXMediaMessage.title, SQLiteDatabase.KeyEmpty));
                        intent2.putExtra("Ksnsupload_imgbuf", wXMediaMessage.thumbData);
                        intent2.putExtra("Ksnsupload_type", 1);
                        intent = intent2;
                        break;
                    case 6:
                        v.e("MicroMsg.ShareSnsImpl", "file is not support!");
                        intent = null;
                        break;
                    case 7:
                        intent = null;
                        break;
                    default:
                        v.e("MicroMsg.ShareSnsImpl", "none type not support!");
                        intent = null;
                        break;
                }
            }
            v.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
            intent = null;
            if (intent == null) {
                finish();
                return;
            }
            if (this.oso.getType() == 5 || this.oso.getType() == 2) {
                v.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", this.oXO.field_appId);
                String fz = o.fz("app_" + this.oXO.field_appId);
                o.b n = o.yx().n(fz, true);
                n.l("prePublishId", "app_" + this.oXO.field_appId);
                if (this.oso.mediaObject instanceof WXWebpageObject) {
                    n.l(SlookSmartClipMetaTag.TAG_TYPE_URL, ((WXWebpageObject) this.oso.mediaObject).webpageUrl);
                }
                string = fz;
            } else {
                string = null;
            }
            intent.putExtra("reportSessionId", string);
            com.tencent.mm.ay.c.b(this, "sns", ".ui.SnsUploadUI", intent, 1);
            return;
        }
        this.aSW.ea(100);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + i + " resultCode " + i2);
        if (i == 1 && intent != null) {
            if (i2 == -1) {
                ReportUtil.a((Context) this, ReportUtil.a(getIntent().getExtras(), 0));
            } else {
                ReportUtil.a((Context) this, ReportUtil.a(getIntent().getExtras(), -2));
            }
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oXP) {
            v.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
            SharedPreferences sharedPreferences = getSharedPreferences(aa.bti(), 0);
            setRequestedOrientation(1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        axg();
        return super.onTouchEvent(motionEvent);
    }

    private com.tencent.mm.pluginsdk.ui.applet.c.a a(final WXMediaMessage wXMediaMessage) {
        return new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
            final /* synthetic */ SendAppMessageWrapperUI oXQ;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    SendAppMessageWrapperUI.a(this.oXQ, wXMediaMessage, str, i);
                } else {
                    SendAppMessageWrapperUI.d(this.oXQ);
                }
            }
        };
    }

    protected final void NI() {
    }

    protected final int getLayoutId() {
        return -1;
    }
}
