package com.tencent.mm.plugin.emoji.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.n;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.mp;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.c.a;
import com.tencent.mm.sdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.sdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.sdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class l {

    static class AnonymousClass1 implements a {
        final /* synthetic */ MMActivity aSk;
        final /* synthetic */ String dLm;
        final /* synthetic */ String fbR;
        final /* synthetic */ String fbS;
        final /* synthetic */ String fbT;
        final /* synthetic */ String fbU;
        final /* synthetic */ String fbV;
        final /* synthetic */ int fbW;

        public AnonymousClass1(String str, String str2, String str3, String str4, String str5, String str6, int i, MMActivity mMActivity) {
            this.fbR = str;
            this.fbS = str2;
            this.fbT = str3;
            this.fbU = str4;
            this.dLm = str5;
            this.fbV = str6;
            this.fbW = i;
            this.aSk = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                String str2 = this.fbR;
                String str3 = this.fbS;
                String str4 = this.fbT;
                String str5 = this.fbU;
                String str6 = this.dLm;
                String str7 = this.fbV;
                int i2 = this.fbW;
                v.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str4;
                wXMediaMessage.description = str5;
                WXEmojiSharedObject wXEmojiSharedObject = new WXEmojiSharedObject();
                wXEmojiSharedObject.packageflag = i2;
                wXEmojiSharedObject.packageid = str3;
                wXEmojiSharedObject.thumburl = str6;
                wXEmojiSharedObject.url = str7;
                wXMediaMessage.mediaObject = wXEmojiSharedObject;
                n.GG();
                Bitmap gu = b.gu(str6);
                if (!(gu == null || gu.isRecycled())) {
                    v.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    gu.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                mp mpVar = new mp();
                mpVar.bnP.bhh = wXMediaMessage;
                mpVar.bnP.toUser = str2;
                mpVar.bnP.bnQ = 49;
                mpVar.bnP.bnR = str2;
                mpVar.bnP.bnS = "";
                com.tencent.mm.sdk.c.a.nhr.z(mpVar);
                if (!TextUtils.isEmpty(str)) {
                    mr mrVar = new mr();
                    mrVar.boa.bob = str2;
                    mrVar.boa.content = str;
                    mrVar.boa.type = m.fp(str2);
                    mrVar.boa.flags = 0;
                    com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                }
                g.iuh.h(10993, new Object[]{Integer.valueOf(0), str3});
                com.tencent.mm.ui.base.g.bf(this.aSk, this.aSk.getString(2131231155));
            }
        }
    }

    static class AnonymousClass2 implements a {
        final /* synthetic */ MMActivity aSk;
        final /* synthetic */ String dIn;
        final /* synthetic */ String fbV;
        final /* synthetic */ String fbX;
        final /* synthetic */ String fbY;
        final /* synthetic */ int fbZ;
        final /* synthetic */ String fca;
        final /* synthetic */ String fcb;

        public AnonymousClass2(String str, String str2, String str3, int i, String str4, String str5, String str6, MMActivity mMActivity) {
            this.fbX = str;
            this.fbY = str2;
            this.dIn = str3;
            this.fbZ = i;
            this.fbV = str4;
            this.fca = str5;
            this.fcb = str6;
            this.aSk = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                String str2 = this.fbX;
                String str3 = this.fbY;
                String str4 = this.dIn;
                int i2 = this.fbZ;
                String str5 = this.fbV;
                String str6 = this.fca;
                String str7 = this.fcb;
                v.d("MicroMsg.emoji.EmojiSharedMgr", "shareToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str3;
                wXMediaMessage.description = str4;
                WXDesignerSharedObject wXDesignerSharedObject = new WXDesignerSharedObject();
                wXDesignerSharedObject.designerUIN = i2;
                wXDesignerSharedObject.thumburl = str7;
                wXDesignerSharedObject.url = str5;
                wXDesignerSharedObject.designerName = str6;
                wXDesignerSharedObject.designerRediretctUrl = str7;
                wXMediaMessage.mediaObject = wXDesignerSharedObject;
                n.GG();
                Bitmap gu = b.gu(str7);
                if (!(gu == null || gu.isRecycled())) {
                    v.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    gu.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                mp mpVar = new mp();
                mpVar.bnP.bhh = wXMediaMessage;
                mpVar.bnP.toUser = str2;
                mpVar.bnP.bnQ = 49;
                mpVar.bnP.bnR = str2;
                mpVar.bnP.bnS = "";
                com.tencent.mm.sdk.c.a.nhr.z(mpVar);
                if (!TextUtils.isEmpty(str)) {
                    mr mrVar = new mr();
                    mrVar.boa.bob = str2;
                    mrVar.boa.content = str;
                    mrVar.boa.type = m.fp(str2);
                    mrVar.boa.flags = 0;
                    com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                }
                com.tencent.mm.ui.base.g.bf(this.aSk, this.aSk.getString(2131231155));
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", str);
        intent.putExtra("KContentObjDesc", str2);
        intent.putExtra("Ksnsupload_imgurl", str3);
        intent.putExtra("Ksnsupload_link", str4);
        intent.putExtra("KUploadProduct_UserData", str5);
        intent.putExtra("Ksnsupload_type", i);
        String fz = o.fz("emoje_stroe");
        o.yx().n(fz, true).l("prePublishId", "emoje_stroe");
        intent.putExtra("reportSessionId", fz);
        c.a(context, "sns", ".ui.SnsUploadUI", intent, false);
    }

    public static void bB(Context context) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
        intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
        c.a(context, ".ui.transmit.SelectConversationUI", intent, 2002);
    }

    public static void a(MMActivity mMActivity, String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6) {
        final String str7 = str;
        final int i4 = i;
        final int i5 = i2;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str4;
        final String str11 = str5;
        final int i6 = i3;
        final String str12 = str6;
        final MMActivity mMActivity2 = mMActivity;
        com.tencent.mm.pluginsdk.ui.applet.c.a(mMActivity.nDR, str2, str4, str3, "", mMActivity.getString(2131231149), new a() {
            public final void a(boolean z, String str, int i) {
                if (z) {
                    String str2 = str7;
                    int i2 = i4;
                    int i3 = i5;
                    String str3 = str8;
                    String str4 = str9;
                    String str5 = str10;
                    String str6 = str11;
                    int i4 = i6;
                    String str7 = str12;
                    v.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.title = str3;
                    wXMediaMessage.description = str4;
                    WXEmojiPageSharedObject wXEmojiPageSharedObject = new WXEmojiPageSharedObject();
                    wXEmojiPageSharedObject.type = i2;
                    wXEmojiPageSharedObject.tid = i3;
                    wXEmojiPageSharedObject.title = str3;
                    wXEmojiPageSharedObject.desc = str4;
                    wXEmojiPageSharedObject.iconUrl = str5;
                    wXEmojiPageSharedObject.secondUrl = str6;
                    wXEmojiPageSharedObject.pageType = i4;
                    wXEmojiPageSharedObject.url = str7;
                    wXMediaMessage.mediaObject = wXEmojiPageSharedObject;
                    n.GG();
                    Bitmap gu = b.gu(str5);
                    if (!(gu == null || gu.isRecycled())) {
                        v.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        gu.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                    }
                    mp mpVar = new mp();
                    mpVar.bnP.bhh = wXMediaMessage;
                    mpVar.bnP.toUser = str2;
                    mpVar.bnP.bnQ = 49;
                    mpVar.bnP.bnR = str2;
                    mpVar.bnP.bnS = "";
                    com.tencent.mm.sdk.c.a.nhr.z(mpVar);
                    if (!TextUtils.isEmpty(str)) {
                        mr mrVar = new mr();
                        mrVar.boa.bob = str2;
                        mrVar.boa.content = str;
                        mrVar.boa.type = m.fp(str2);
                        mrVar.boa.flags = 0;
                        com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                    }
                    com.tencent.mm.ui.base.g.bf(mMActivity2, mMActivity2.getString(2131231155));
                }
            }
        });
    }
}
