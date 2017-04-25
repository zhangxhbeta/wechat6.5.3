package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.bv;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.h.j;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.f;
import com.tencent.mm.modelbiz.h;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public abstract class ad {
    protected final int eKg;
    protected boolean lVu;
    public boolean nQK;

    public static class a {
        public ImageView dtX;
        public TextView eTg;
        public View fIV;
        public CheckBox gfb;
        public TextView iJL;
        public ProgressBar ieT;
        public View kad;
        public ImageView oky;
        public ViewStub onA;
        public View onB;
        public View onC;
        public int onD;
        public long onE;
        public int type;

        public a(int i) {
            this(i, (byte) 0);
        }

        private a(int i, byte b) {
            this.type = i;
            this.onE = 0;
        }

        public final void cM(View view) {
            this.kad = view;
            this.eTg = (TextView) view.findViewById(2131755027);
            this.dtX = (ImageView) view.findViewById(2131755340);
            this.onB = view.findViewById(2131755025);
            this.onC = view.findViewById(2131756148);
            this.oky = (ImageView) view.findViewById(2131756230);
            this.onA = (ViewStub) view.findViewById(2131756097);
        }

        public final void jH(boolean z) {
            int i = z ? 0 : 8;
            if (!(this.gfb == null || this.gfb.getVisibility() == i)) {
                this.gfb.setVisibility(i);
            }
            if (this.fIV != null && this.fIV.getVisibility() != i) {
                this.fIV.setVisibility(i);
            }
        }
    }

    public static abstract class b extends ad {
        public b(int i) {
            super(i);
        }
    }

    public static abstract class c extends ad {
        public c(int i) {
            super(i);
        }

        protected final boolean a(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            return false;
        }

        protected final String a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar) {
            return aVar.onh.cyO;
        }
    }

    private static class d implements com.tencent.mm.modelbiz.g.a {
        private String lqX;
        cp onh;

        protected d(cp cpVar, String str) {
            this.lqX = str;
            this.onh = cpVar;
        }

        public final void d(LinkedList<bit> linkedList) {
            int i = 0;
            u.Dz().b(this);
            v.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
            if (linkedList != null && linkedList.size() > 0) {
                v.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", Integer.valueOf(linkedList.size()), this.lqX);
                if (this.onh != null) {
                    if (linkedList != null && linkedList.size() != 0) {
                        for (int i2 = 0; i2 < linkedList.size(); i2++) {
                            bit com_tencent_mm_protocal_c_bit = (bit) linkedList.get(i2);
                            if (!(com_tencent_mm_protocal_c_bit == null || be.kS(com_tencent_mm_protocal_c_bit.ndl) || !com_tencent_mm_protocal_c_bit.ndl.equals(this.lqX))) {
                                v.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
                                if (!be.kS(com_tencent_mm_protocal_c_bit.mGq)) {
                                    v.i("MicroMsg.ChattingItem", "needCallback: true");
                                    i = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (i != 0) {
                        com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                            final /* synthetic */ d onF;

                            {
                                this.onF = r1;
                            }

                            public final void run() {
                                this.onF.onh.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        }

        public final String Dq() {
            return this.lqX;
        }
    }

    public abstract View a(LayoutInflater layoutInflater, View view);

    public abstract void a(a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar, String str);

    public abstract boolean a(ContextMenu contextMenu, View view, at atVar);

    public abstract boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar);

    public abstract boolean a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar);

    public ad(int i) {
        this.eKg = i;
    }

    public final int bEx() {
        return this.eKg;
    }

    public static void q(ImageView imageView, String str) {
        if (be.kS(str)) {
            imageView.setImageResource(2130838080);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.m(imageView, str);
        }
    }

    public static void r(ImageView imageView, String str) {
        if (be.kS(str)) {
            imageView.setImageResource(2130837790);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.o(imageView, str);
        }
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar, boolean z) {
        this.lVu = z;
        String str = null;
        if (bEy()) {
            str = a(aVar2, atVar);
            a(aVar, aVar2, atVar, str);
            a(aVar, aVar2, str, atVar);
        }
        a(aVar, i, aVar2, atVar, str);
    }

    protected boolean bEy() {
        return true;
    }

    protected void a(a aVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar, String str) {
        if (str != null && aVar.iJL != null && atVar != null) {
            CharSequence charSequence = null;
            if (atVar.field_isSend == 0 && !be.kS(atVar.bNw)) {
                f hG = u.Dx().hG(atVar.bNw);
                Object obj = 1;
                if (hG == null || be.kS(hG.field_openId) || be.kS(hG.field_nickname)) {
                    v.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
                } else {
                    charSequence = hG.field_nickname;
                    obj = null;
                }
                if (obj != null || h.a(hG)) {
                    u.Dz().a(new d(aVar2.onh, atVar.bNw));
                    u.Dz().R(aVar2.onh.bdo, atVar.bNw);
                }
            } else if (a(aVar2) && aVar2.otR) {
                charSequence = aVar2.otJ ? e.a(aVar2.nDR.nEl, aVar2.er(atVar.field_bizChatUserId), aVar.iJL.getTextSize()) : e.a(aVar2.nDR.nEl, aVar2.er(str), aVar.iJL.getTextSize());
            }
            a(aVar, charSequence);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.String a(com.tencent.mm.ui.chatting.ChattingUI.a r4, com.tencent.mm.storage.at r5) {
        /*
        r3 = this;
        r0 = r4.onh;
        r1 = r0.bdo;
        r0 = r3.a(r4);
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r4.onl;
        if (r0 == 0) goto L_0x0021;
    L_0x000f:
        r0 = r5.field_content;
        r0 = com.tencent.mm.model.aw.fL(r0);
        if (r1 == 0) goto L_0x0026;
    L_0x0017:
        if (r0 == 0) goto L_0x0026;
    L_0x0019:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0026;
    L_0x001f:
        r1 = r0;
        goto L_0x000a;
    L_0x0021:
        if (r5 == 0) goto L_0x0026;
    L_0x0023:
        r0 = r5.field_bizChatUserId;
        goto L_0x001f;
    L_0x0026:
        r0 = r1;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ad.a(com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.storage.at):java.lang.String");
    }

    protected static String b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar) {
        String str = atVar.field_talker;
        if (!aVar.lKa || aVar.ogZ == null) {
            return str;
        }
        return aVar.ogZ.field_bizChatServId;
    }

    public static String a(at atVar, boolean z, boolean z2) {
        String str = null;
        if (atVar == null) {
            return null;
        }
        if (atVar.field_isSend == 1) {
            return k.xF();
        }
        if (z) {
            str = aw.fL(atVar.field_content);
        } else if (z2) {
            str = atVar.field_bizChatUserId;
        }
        if (be.kS(str)) {
            return atVar.field_talker;
        }
        return str;
    }

    protected static void a(a aVar, CharSequence charSequence) {
        if (aVar != null && aVar.iJL != null) {
            if (charSequence == null) {
                aVar.iJL.setVisibility(8);
                return;
            }
            aVar.iJL.setText(charSequence);
            aVar.iJL.setVisibility(0);
        }
    }

    protected static void a(a aVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, String str, at atVar) {
        String str2 = null;
        if (aVar.dtX != null) {
            if (!m.fn(str) || str.equals(m.crG[0])) {
                Object obj;
                dl dlVar;
                if (atVar != null && !be.kS(atVar.bNw)) {
                    if (aVar2.onl) {
                        str2 = aVar2.bEn();
                    }
                    dlVar = new dl(str, 9, str2);
                    dlVar.oxT = atVar.bNw;
                    com.tencent.mm.pluginsdk.ui.a.b.d(aVar.dtX, atVar.bNw, 2130837718);
                    obj = dlVar;
                } else if (atVar == null || !aVar2.lKa) {
                    if (aVar2.onl) {
                        str2 = aVar2.bEn();
                    }
                    dlVar = new dl(str, 1, str2);
                    q(aVar.dtX, str);
                    r0 = dlVar;
                } else {
                    dlVar = new dl(atVar.field_bizChatUserId, 1, null);
                    n.GL().a(aVar2.hW(atVar.field_bizChatUserId), aVar.dtX, aVar2.onh.eSp);
                    r0 = dlVar;
                }
                aVar.dtX.setVisibility(0);
                aVar.dtX.setTag(obj);
                ay.cN(aVar.dtX);
                aVar.dtX.setOnClickListener(aVar2.onh.oqh);
                aVar.dtX.setOnLongClickListener(aVar2.onh.oqj);
                aVar.dtX.setContentDescription(l.er(str) + aVar2.nDR.nEl.getString(2131231201));
                if (aVar.onA == null) {
                    return;
                }
                if (atVar.bNo == null || !atVar.bNo.contains("watch_msg_source_type")) {
                    aVar.onA.setVisibility(8);
                    return;
                }
                int intValue;
                try {
                    intValue = Integer.valueOf((String) bf.q(atVar.bNo, "msgsource").get(".msgsource.watch_msg_source_type")).intValue();
                } catch (Exception e) {
                    intValue = 0;
                }
                if (intValue <= 0 || intValue > 4) {
                    aVar.onA.setVisibility(8);
                    return;
                } else {
                    aVar.onA.setVisibility(0);
                    return;
                }
            }
            aVar.dtX.setVisibility(8);
        }
    }

    protected boolean a(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        return aVar.onl || aVar.lKa;
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, String str) {
        if (g.Gw(str)) {
            Object bVar = new com.tencent.mm.pluginsdk.ui.chat.l.b();
            bVar.appId = str;
            bVar.bmm = "message";
            a(aVar, view, bVar);
        }
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, at atVar, com.tencent.mm.q.a.a aVar2, String str, long j) {
        if (g.Gw(aVar2.appId)) {
            int i = aVar.nQK ? 2 : 1;
            Object aVar3 = new com.tencent.mm.pluginsdk.ui.chat.l.a();
            aVar3.appId = aVar2.appId;
            aVar3.bmm = "message";
            aVar3.aRm = str;
            aVar3.bmE = c(aVar, atVar);
            aVar3.lNV = aVar2.type;
            aVar3.scene = i;
            aVar3.lNW = aVar2.mediaTagName;
            aVar3.bmL = j;
            a(aVar, view, aVar3);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.onh.oqn);
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, ImageView imageView, String str) {
        Bitmap b = g.b(str, 2, com.tencent.mm.bd.a.getDensity(aVar.nDR.nEl));
        if (b == null || b.isRecycled()) {
            a(aVar, imageView, BitmapFactory.decodeResource(aVar.getResources(), 2130838795));
        } else {
            a(aVar, imageView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, ImageView imageView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.getResources().getDimension(com.tencent.mm.bi.a.b.peS);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        imageView.setImageDrawable(bitmapDrawable);
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, TextView textView, String str) {
        Bitmap b = g.b(str, 2, com.tencent.mm.bd.a.getDensity(aVar.nDR.nEl));
        if (b == null || b.isRecycled()) {
            a(aVar, textView, BitmapFactory.decodeResource(aVar.getResources(), 2130838795));
        } else {
            a(aVar, textView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.getResources().getDimension(com.tencent.mm.bi.a.b.peS);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected static void b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.onh.oqh);
    }

    protected static void c(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.onh.oqr);
    }

    public final boolean a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.q.a.a aVar2, at atVar) {
        if (be.kS(aVar2.cqg)) {
            return false;
        }
        a.a(com.tencent.mm.ui.chatting.a.a.EnterCompleteVideo, atVar, aVar2.cqn, aVar2.cqm);
        String str = atVar.field_imgPath;
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", aVar2.cqg);
        intent.putExtra("KThumUrl", aVar2.cql);
        intent.putExtra("KThumbPath", str);
        intent.putExtra("KSta_StremVideoAduxInfo", aVar2.cqm);
        intent.putExtra("KSta_StremVideoPublishId", aVar2.cqn);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", aVar.onl ? com.tencent.mm.ui.chatting.a.b.TalkChat.value : com.tencent.mm.ui.chatting.a.b.Chat.value);
        intent.putExtra("KSta_FromUserName", a(aVar, atVar));
        intent.putExtra("KSta_ChatName", aVar.bEn());
        intent.putExtra("KSta_MsgId", atVar.field_msgSvrId);
        intent.putExtra("KSta_SnsStatExtStr", aVar2.bnY);
        if (aVar.onl) {
            intent.putExtra("KSta_ChatroomMembercount", i.el(aVar.bEn()));
        }
        intent.putExtra("KMediaId", "fakeid_" + atVar.field_msgId);
        intent.putExtra("KMediaVideoTime", aVar2.cqh);
        intent.putExtra("StremWebUrl", aVar2.cqk);
        intent.putExtra("StreamWording", aVar2.cqj);
        intent.putExtra("KMediaTitle", aVar2.title);
        com.tencent.mm.ay.c.b(aVar.nDR.nEl, "sns", ".ui.VideoAdPlayerUI", intent);
        return true;
    }

    protected final void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, String str, String str2, String str3, int i, String str4, boolean z, long j, long j2, at atVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            v.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
            return;
        }
        if (ak.isMobile(aVar.nDR.nEl) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", z);
        intent.putExtra("geta8key_username", aVar.bEn());
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        intent.putExtra("pre_username", a(aVar, atVar));
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (atVar != null) {
            intent.putExtra("preUsername", a(aVar, atVar));
        }
        intent.putExtra("preChatName", aVar.bEn());
        intent.putExtra("preChatTYPE", com.tencent.mm.model.n.F(a(aVar, atVar), aVar.bEn()));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.ay.c.b(aVar.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected static PackageInfo av(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            com.tencent.mm.pluginsdk.model.app.f aC = g.aC(str, true);
            if (aC == null) {
                Object obj = packageInfo;
            } else {
                str2 = aC.field_packageName;
            }
        }
        if (str2 != null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (Throwable e) {
                v.a("MicroMsg.ChattingItem", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return packageInfo;
    }

    protected static void a(int i, a aVar, at atVar, String str, boolean z, cq cqVar) {
        if (atVar.field_isSend == 1) {
            int i2;
            aVar.oky.setTag(new dl(atVar, z, i, str, 5, (byte) 0));
            aVar.oky.setOnClickListener(cqVar);
            switch (atVar.field_status) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = -1;
                    break;
                case 5:
                    i2 = 2130839254;
                    break;
                default:
                    v.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
                    i2 = -1;
                    break;
            }
            if (i2 != -1) {
                aVar.oky.setImageResource(2130839254);
                aVar.oky.setVisibility(0);
                aVar.oky.setContentDescription(aa.getContext().getString(2131233896));
                if (aVar.ieT != null) {
                    aVar.ieT.setVisibility(8);
                    return;
                }
                return;
            }
            aVar.oky.setVisibility(8);
        }
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.q.a.a aVar2, String str, com.tencent.mm.pluginsdk.model.app.f fVar, long j) {
        int i = aVar.nQK ? 2 : 1;
        int i2 = (fVar == null || !p.o(aVar.nDR.nEl, fVar.field_packageName)) ? 6 : 3;
        if (aVar2.type == 2) {
            i2 = 4;
        } else if (aVar2.type == 5) {
            i2 = 1;
        }
        com.tencent.mm.sdk.c.b ljVar = new lj();
        ljVar.bmI.context = aVar.nDR.nEl;
        ljVar.bmI.scene = i;
        ljVar.bmI.bmJ = aVar2.appId;
        ljVar.bmI.packageName = fVar == null ? null : fVar.field_packageName;
        ljVar.bmI.msgType = aVar2.type;
        ljVar.bmI.bhM = str;
        ljVar.bmI.bmK = i2;
        ljVar.bmI.mediaTagName = aVar2.mediaTagName;
        ljVar.bmI.bmL = j;
        ljVar.bmI.bmM = SQLiteDatabase.KeyEmpty;
        com.tencent.mm.sdk.c.a.nhr.z(ljVar);
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.q.a.a aVar2, at atVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
        r rVar = com.tencent.mm.pluginsdk.j.a.lxN;
        if (rVar != null) {
            int i = aVar.onl ? 2 : 1;
            rVar.a(aVar.nDR.nEl, aVar2.appId, fVar == null ? null : fVar.field_packageName, c(aVar, atVar), aVar2.type, aVar2.mediaTagName, i);
        }
    }

    protected static void b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.q.a.a aVar2, at atVar) {
        r rVar = com.tencent.mm.pluginsdk.j.a.lxN;
        if (rVar != null) {
            int i = aVar.onl ? 2 : 1;
            String c = c(aVar, atVar);
            ActionBarActivity actionBarActivity = aVar.nDR.nEl;
            rVar.a(aVar2.appId, c, aVar2.type, i, aVar2.mediaTagName, atVar.field_msgSvrId);
        }
    }

    protected static boolean a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
        r rVar = com.tencent.mm.pluginsdk.j.a.lxN;
        if (g.a(aVar.nDR.nEl, fVar) || rVar == null) {
            return false;
        }
        if (!be.kS(fVar.bxu)) {
            v.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", fVar.bxu, Boolean.valueOf(p.aO(aVar.nDR.nEl, fVar.bxu)));
            if (p.aO(aVar.nDR.nEl, fVar.bxu)) {
                return true;
            }
        }
        int i = aVar.nQK ? 2 : 1;
        com.tencent.mm.sdk.c.b fqVar = new fq();
        fqVar.beY.actionCode = 2;
        fqVar.beY.scene = i;
        fqVar.beY.appId = fVar.field_appId;
        fqVar.beY.context = aVar.nDR.nEl;
        com.tencent.mm.sdk.c.a.nhr.z(fqVar);
        ActionBarActivity actionBarActivity = aVar.nDR.nEl;
        rVar.z(fVar.field_appId, i, i);
        return true;
    }

    protected static String c(com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar) {
        String bEn = aVar.bEn();
        if (m.dE(bEn)) {
            return aw.fL(atVar.field_content);
        }
        return bEn;
    }

    public static void t(com.tencent.mm.storage.a.c cVar) {
        com.tencent.mm.sdk.c.b bvVar = new bv();
        bvVar.aZp.aZq = cVar;
        bvVar.aZp.scene = 0;
        com.tencent.mm.sdk.c.a.nhr.z(bvVar);
    }

    protected static boolean bEz() {
        String value = j.sU().getValue("ShowRevokeMsgEntry");
        v.d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%s", value);
        if (be.kS(value)) {
            value = "0";
        }
        return 1 == Integer.valueOf(value).intValue();
    }

    protected static boolean OI(String str) {
        return !(m.eP(str) || m.fg(str) || m.eD(str) || m.fo(str)) || m.dE(str);
    }

    protected static boolean bEA() {
        String value = j.sU().getValue("ShowSendOK");
        if (1 == (be.kS(value) ? 0 : be.KL(value))) {
            return true;
        }
        return false;
    }

    protected static boolean a(cp cpVar, long j) {
        if (j > 0) {
            if (cpVar.oqH == -1) {
                cpVar.oqH = 0;
                Cursor cursor = cpVar.getCursor();
                int position = cursor.getPosition();
                int count = cursor.getCount();
                v.i("MicroMsg.ChattingListAdapter", "curPos %d, curCount %d", Integer.valueOf(position), Integer.valueOf(count));
                if (cursor.moveToLast()) {
                    do {
                        cpVar.oqM = null;
                        cpVar.oqM = cp.a(cpVar.oqM, cursor);
                        if (cpVar.oqM.field_isSend == 1) {
                            if ((cpVar.oqM.bNn & 4) != 4) {
                                cpVar.oqH = cpVar.oqM.field_msgId;
                            }
                        }
                    } while (cursor.moveToPrevious());
                }
                if (count < 0) {
                    if (count > 0) {
                        cursor.moveToPosition(0);
                    }
                } else if (position < count) {
                    cursor.moveToPosition(position);
                } else if (count > 0) {
                    cursor.moveToPosition(count - 1);
                }
            }
            if (cpVar.oqH == j) {
                return true;
            }
        }
        return false;
    }
}
