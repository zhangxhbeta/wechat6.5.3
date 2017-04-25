package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class el implements dh {
    static h<dh, Bundle> ozC = new h<dh, Bundle>() {
        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((dh) obj).U((Bundle) obj2);
        }
    };
    a onG;
    final Set<String> ozB = new HashSet();

    protected el(a aVar) {
        this.onG = aVar;
    }

    public static void V(Bundle bundle) {
        ozC.bg(bundle);
        ozC.Ls();
    }

    public final void U(Bundle bundle) {
        int i = 1;
        boolean z = false;
        if (this.onG.bFD()) {
            v.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
            return;
        }
        String string;
        int type;
        String queryParameter = Uri.parse(bundle.getString("_mmessage_content")).getQueryParameter("appid");
        b bVar = new b(bundle);
        WXMediaMessage wXMediaMessage = bVar.nhM;
        if (this.ozB.size() == 0) {
            Context context = this.onG.nDR.nEl;
            Collection hashSet = new HashSet();
            string = context.getSharedPreferences(aa.btn(), 0).getString("transactions_array_key", null);
            if (string != null && string.length() > 0) {
                for (Object add : string.split(";")) {
                    hashSet.add(add);
                }
            }
            this.ozB.addAll(hashSet);
        }
        if (this.ozB.contains(bVar.lBj)) {
            this.ozB.remove(bVar.lBj);
            b(this.onG.nDR.nEl, this.ozB);
            c fVar = new f();
            fVar.field_appId = queryParameter;
            v.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = " + queryParameter);
            if (am.bnB().b(fVar, new String[0])) {
                type = wXMediaMessage.getType();
                k kVar;
                boolean z2;
                com.tencent.mm.ui.base.h b;
                byte[] bArr;
                String str;
                switch (type) {
                    case 1:
                        kVar = this.onG.nDR;
                        queryParameter = wXMediaMessage.description;
                        r(fVar);
                        if (com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, queryParameter, false, a(wXMediaMessage, fVar)) != null) {
                            z = true;
                        }
                        z2 = z;
                        break;
                    case 2:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                            k kVar2;
                            if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                                kVar2 = this.onG.nDR;
                                string = wXImageObject.imagePath;
                                r(fVar);
                                b = com.tencent.mm.pluginsdk.ui.applet.c.b(kVar2, string, false, a(wXMediaMessage, fVar));
                            } else {
                                kVar2 = this.onG.nDR;
                                byte[] bArr2 = wXImageObject.imageData;
                                r(fVar);
                                b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar2, bArr2, false, a(wXMediaMessage, fVar));
                            }
                        } else {
                            kVar = this.onG.nDR;
                            bArr = wXMediaMessage.thumbData;
                            r(fVar);
                            b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, bArr, false, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            v.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
                        } else {
                            z = true;
                        }
                        z2 = z;
                        break;
                    case 3:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            kVar = this.onG.nDR;
                            str = wXMediaMessage.title;
                            r(fVar);
                            b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, 2131165232, str, false, a(wXMediaMessage, fVar));
                        } else {
                            kVar = this.onG.nDR;
                            queryParameter = wXMediaMessage.title;
                            r(fVar);
                            b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, queryParameter, false, 2, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 4:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            kVar = this.onG.nDR;
                            str = wXMediaMessage.title;
                            r(fVar);
                            b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, 2131165244, str, false, a(wXMediaMessage, fVar));
                        } else {
                            kVar = this.onG.nDR;
                            queryParameter = wXMediaMessage.title;
                            r(fVar);
                            b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, queryParameter, false, 1, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 5:
                        kVar = this.onG.nDR;
                        queryParameter = wXMediaMessage.title;
                        str = wXMediaMessage.description;
                        r(fVar);
                        if (com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, queryParameter, str, false, SQLiteDatabase.KeyEmpty, a(wXMediaMessage, fVar)) == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 7:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            kVar = this.onG.nDR;
                            queryParameter = wXMediaMessage.title;
                            r(fVar);
                            b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, 2131165247, queryParameter, false, a(wXMediaMessage, fVar));
                        } else {
                            kVar = this.onG.nDR;
                            queryParameter = wXMediaMessage.title;
                            r(fVar);
                            b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, queryParameter, false, 0, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 8:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            kVar = this.onG.nDR;
                            queryParameter = wXMediaMessage.title;
                            r(fVar);
                            b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, 2131165247, queryParameter, false, a(wXMediaMessage, fVar));
                        } else {
                            kVar = this.onG.nDR;
                            bArr = wXMediaMessage.thumbData;
                            r(fVar);
                            b = com.tencent.mm.pluginsdk.ui.applet.c.a(kVar, bArr, false, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    default:
                        v.e("MicroMsg.WXAppMessageReceiver", "unknown type = " + type);
                        i = 0;
                        break;
                }
                if (i == 0) {
                    v.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
                    return;
                }
                return;
            }
            v.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = " + queryParameter);
            return;
        }
        v.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + bVar.lBj);
    }

    public final boolean dY(String str, String str2) {
        v.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + str + ", openId = " + str2);
        com.tencent.mm.sdk.modelmsg.a.a aVar = new com.tencent.mm.sdk.modelmsg.a.a();
        aVar.username = this.onG.bEn();
        aVar.lBj = g.m((t.Ni()).getBytes());
        aVar.bfm = str2;
        SharedPreferences NV = this.onG.NV(aa.bti());
        ActionBarActivity actionBarActivity = this.onG.nDR.nEl;
        aVar.cUi = u.d(NV);
        ak.yW();
        aVar.cJg = (String) com.tencent.mm.model.c.vf().get(274436, null);
        Bundle bundle = new Bundle();
        aVar.t(bundle);
        p.R(bundle);
        p.S(bundle);
        com.tencent.mm.sdk.a.a.a aVar2 = new com.tencent.mm.sdk.a.a.a();
        aVar2.nhj = str;
        aVar2.nhl = bundle;
        boolean a = com.tencent.mm.sdk.a.a.a(this.onG.nDR.nEl, aVar2);
        this.ozB.add(aVar.lBj);
        b(this.onG.nDR.nEl, this.ozB);
        return a;
    }

    private String r(f fVar) {
        return this.onG.getString(2131231980, com.tencent.mm.pluginsdk.model.app.g.a(this.onG.nDR.nEl, fVar, null));
    }

    private com.tencent.mm.pluginsdk.ui.applet.c.a a(final WXMediaMessage wXMediaMessage, final f fVar) {
        return new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
            final /* synthetic */ el ozE;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    String str2 = null;
                    if (wXMediaMessage.getType() == 8) {
                        if (wXMediaMessage.thumbData == null) {
                            v.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                            return;
                        }
                        str2 = j.a.bmr().a(this.ozE.onG.nDR.nEl, wXMediaMessage, fVar.field_appId);
                        if (str2 == null) {
                            v.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
                            return;
                        }
                    }
                    bl.zQ().b(27, Integer.valueOf(1));
                    v.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", wXMediaMessage.messageAction, wXMediaMessage.messageExt);
                    l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, this.ozE.onG.bEn(), 1, str2);
                }
            }
        };
    }

    @TargetApi(9)
    static void b(Context context, Set<String> set) {
        String str = null;
        if (set != null && set.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str2 : set) {
                stringBuilder.append(str2);
                stringBuilder.append(";");
            }
            str2 = stringBuilder.toString();
        }
        Editor edit = context.getSharedPreferences(aa.btn(), 0).edit();
        edit.putString("transactions_array_key", str2);
        if (VERSION.SDK_INT > 8) {
            edit.apply();
        } else {
            edit.commit();
        }
    }
}
