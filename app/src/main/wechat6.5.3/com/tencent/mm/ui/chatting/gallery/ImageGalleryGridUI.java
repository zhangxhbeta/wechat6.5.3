package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.jo;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.AppAttachDownloadUI;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.dq;
import com.tencent.mm.ui.chatting.em;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.chatting.y;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@a(19)
public class ImageGalleryGridUI extends MMActivity implements OnMenuItemClickListener, OnClickListener, OnPreDrawListener, OnItemClickListener, dq, b {
    private boolean aUP = true;
    private String bdo;
    public long ezh;
    private TextView gfj;
    protected ac handler;
    private Animation iVP;
    public boolean lKa;
    private boolean lVu = false;
    public int oAC;
    private GridView oAD;
    c oAE;
    private WeakReference<a> oAF;
    private Boolean oAG;
    private Boolean oAH;
    private TextView oAI;
    private Runnable oAJ = new Runnable(this) {
        final /* synthetic */ ImageGalleryGridUI oAU;

        {
            this.oAU = r1;
        }

        public final void run() {
            if (this.oAU.oAD != null && this.oAU.oAD.getVisibility() != 4) {
                this.oAU.oAD.setVisibility(4);
            }
        }
    };
    private Runnable oAK = new Runnable(this) {
        final /* synthetic */ ImageGalleryGridUI oAU;

        {
            this.oAU = r1;
        }

        public final void run() {
            if (this.oAU.oAD != null && this.oAU.oAD.getVisibility() != 0) {
                this.oAU.oAD.setVisibility(0);
            }
        }
    };
    private boolean oAL = false;
    Runnable oAM = new Runnable(this) {
        final /* synthetic */ ImageGalleryGridUI oAU;

        {
            this.oAU = r1;
        }

        @TargetApi(12)
        public final void run() {
            if (this.oAU.oAN != null) {
                this.oAU.oAN.setVisibility(8);
                this.oAU.oAN = null;
            }
        }
    };
    public View oAN = null;
    private View oAO;
    private int oAP = -1;
    private View oAQ;
    private View oAR;
    private View oAS;
    private View oAT;
    private long oqS = 0;
    private c ouC = new c<fp>(this) {
        final /* synthetic */ ImageGalleryGridUI oAU;

        {
            this.oAU = r2;
            this.nhz = fp.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            fp fpVar = (fp) bVar;
            ImageGalleryGridUI.a(this.oAU, fpVar.beU.beX, fpVar);
            return false;
        }
    };

    static /* synthetic */ void a(ImageGalleryGridUI imageGalleryGridUI, int i, fp fpVar) {
        if (imageGalleryGridUI.oAD != null) {
            int firstVisiblePosition = imageGalleryGridUI.oAD.getFirstVisiblePosition();
            int lastVisiblePosition = imageGalleryGridUI.oAD.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = imageGalleryGridUI.oAD.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    fpVar.beV.aXV = iArr[0];
                    fpVar.beV.aXW = iArr[1];
                    fpVar.beV.aXX = childAt.getWidth();
                    fpVar.beV.aXY = childAt.getHeight();
                }
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903792;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oAL = true;
        this.handler = new ac();
        xE(0);
        com.tencent.mm.sdk.c.a.nhr.e(this.ouC);
    }

    protected final boolean bzR() {
        return true;
    }

    protected void onDestroy() {
        this.handler.removeCallbacks(this.oAK);
        this.handler = null;
        n.GL().ba(0);
        com.tencent.mm.sdk.c.a.nhr.f(this.ouC);
        super.onDestroy();
    }

    protected void onResume() {
        g bGE = a.oBx;
        if (this != null) {
            bGE.oBw.remove(this);
            bGE.oBw.add(this);
        }
        this.aUP = false;
        if (this.oAL) {
            if (a.oBx.oBv) {
                bGz();
            } else {
                bGB();
            }
        }
        this.handler.postDelayed(this.oAK, 300);
        super.onResume();
        if (this.oAE != null) {
            this.oAE.oAr = true;
            c cVar = this.oAE;
            if (cVar.oAr) {
                cVar.notifyDataSetChanged();
            }
            if (a.oBx.oBv) {
                Fd(getString(2131233046, new Object[]{Integer.valueOf(a.oBx.ozS.size())}));
            }
        }
        this.oAL = false;
        bGA();
    }

    protected void onPause() {
        g bGE = a.oBx;
        if (this != null) {
            bGE.oBw.remove(this);
        }
        this.aUP = true;
        super.onPause();
    }

    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
        xE(1);
    }

    public void onBackPressed() {
        if (a.oBx.oBv) {
            bGB();
        } else if (this.oAG.booleanValue()) {
            super.onBackPressed();
        } else {
            if (this.oAC >= 0) {
                E(null, this.oAC);
            }
            finish();
        }
    }

    @TargetApi(11)
    private void xE(int i) {
        Intent intent = getIntent();
        this.oAG = Boolean.valueOf(intent.getIntExtra("kintent_intent_source", 0) == 1);
        this.bdo = intent.getStringExtra("kintent_talker");
        this.oAC = intent.getIntExtra("kintent_image_index", 0);
        this.lKa = intent.getBooleanExtra("key_is_biz_chat", false);
        this.ezh = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.oAH = Boolean.valueOf(true);
        Fd(getString(2131230888));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ImageGalleryGridUI oAU;

            {
                this.oAU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oAU.onBackPressed();
                return true;
            }
        });
        this.oAO = findViewById(2131757466);
        View findViewById = findViewById(2131757468);
        this.oAQ = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(2131757467);
        this.oAR = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(2131757469);
        this.oAS = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(2131756336);
        this.oAT = findViewById;
        findViewById.setOnClickListener(this);
        this.gfj = (TextView) findViewById(2131757464);
        this.oAI = (TextView) findViewById(2131757465);
        if (i == 0) {
            this.oAD = (GridView) findViewById(2131757463);
            this.oAD.setOnItemClickListener(this);
            this.oAD.setNumColumns(3);
            at atVar = new at();
            if (this.lKa) {
                atVar.A(this.ezh);
            }
            this.oAE = new c(this, atVar, this.bdo);
            if (this.oAE.getCount() == 0) {
                this.oAI.setVisibility(0);
                return;
            }
            this.oAI.setVisibility(8);
            this.oAD.setAdapter(this.oAE);
            bGy();
        } else if (this.oAE != null) {
            this.oAE.notifyDataSetChanged();
            bGy();
        }
        this.oAD.setOnScrollListener(new OnScrollListener(this) {
            private Runnable gfH = new Runnable(this) {
                final /* synthetic */ AnonymousClass6 oAW;

                {
                    this.oAW = r1;
                }

                public final void run() {
                    this.oAW.oAU.gfj.startAnimation(AnimationUtils.loadAnimation(this.oAW.oAU.nDR.nEl, 2130968623));
                    this.oAW.oAU.gfj.setVisibility(8);
                }
            };
            final /* synthetic */ ImageGalleryGridUI oAU;

            {
                this.oAU = r2;
            }

            private void dk(boolean z) {
                if (z) {
                    this.oAU.gfj.removeCallbacks(this.gfH);
                    if (this.oAU.gfj.getVisibility() != 0) {
                        this.oAU.gfj.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.oAU.nDR.nEl, 2130968622);
                        this.oAU.gfj.setVisibility(0);
                        this.oAU.gfj.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                this.oAU.gfj.removeCallbacks(this.gfH);
                this.oAU.gfj.postDelayed(this.gfH, 256);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    dk(true);
                } else if (i == 0) {
                    dk(false);
                }
                n.GL().ba(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                CharSequence charSequence;
                Context context = this.oAU;
                at atVar = (at) context.oAE.getItem(i);
                if (atVar == null) {
                    charSequence = null;
                } else {
                    charSequence = com.tencent.mm.ui.tools.gridviewheaders.a.bJA().a(new Date(atVar.field_createTime), context);
                }
                this.oAU.gfj.setText(charSequence);
            }
        });
    }

    private void bGy() {
        int firstVisiblePosition = this.oAD.getFirstVisiblePosition();
        int lastVisiblePosition = this.oAD.getLastVisiblePosition();
        int i = this.oAC;
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            this.oAD.setSelection(i);
        }
    }

    public void finish() {
        super.finish();
        a.oBx.detach();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.tencent.mm.q.a.a B;
        at atVar = (at) this.oAE.getItem(i);
        String str = atVar.field_content;
        if (str != null) {
            B = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null && B.type == 6) {
            aU(atVar);
        } else if (B != null && B.type == 3) {
            str = p.s(B.url, "message");
            r3 = p.s(B.coa, "message");
            PackageInfo av = av(this.nDR.nEl, B.appId);
            r4 = av == null ? null : av.versionName;
            r1 = av == null ? 0 : av.versionCode;
            String str2 = B.appId;
            r6 = atVar.field_msgId;
            long j2 = atVar.field_msgSvrId;
            if ((str == null || str.length() == 0) && (r3 == null || r3.length() == 0)) {
                v.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
                return;
            }
            if (ak.isMobile(this.nDR.nEl) ? r3 != null && r3.length() > 0 : str == null || str.length() <= 0) {
                str = r3;
            }
            Intent intent = new Intent();
            intent.putExtra("msg_id", r6);
            intent.putExtra("rawUrl", str);
            intent.putExtra("version_name", r4);
            intent.putExtra("version_code", r1);
            intent.putExtra("usePlugin", true);
            intent.putExtra("geta8key_username", this.bdo);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
            intent.putExtra("KAppId", str2);
            r1 = aT(atVar);
            intent.putExtra("pre_username", r1);
            intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
            if (atVar != null) {
                intent.putExtra("preUsername", r1);
            }
            intent.putExtra("preChatName", this.bdo);
            intent.putExtra("preChatTYPE", com.tencent.mm.model.n.F(r1, this.bdo));
            intent.putExtra("preMsgIndex", 0);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
        } else if (B == null || B.type != 5) {
            Intent intent2;
            if (B != null && B.type == 19) {
                intent2 = new Intent();
                intent2.putExtra("message_id", atVar.field_msgId);
                intent2.putExtra("record_xml", B.coC);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "record", ".ui.RecordMsgDetailUI", intent2);
            } else if (B != null && B.type == 24) {
                com.tencent.mm.sdk.c.b joVar = new jo();
                joVar.bjY.context = this.nDR.nEl;
                joVar.bjY.bao = atVar.field_msgId;
                joVar.bjY.bjZ = B.coC;
                com.tencent.mm.sdk.c.a.nhr.z(joVar);
            } else if (B != null && B.type == 7) {
                f aC = g.aC(B.appId, false);
                if (aC != null && aC.bnk()) {
                    Object obj;
                    r1 = this.bdo;
                    if (m.dE(r1)) {
                        r1 = aw.fL(atVar.field_content);
                    }
                    r6 = atVar.field_msgSvrId;
                    int i2 = (aC == null || !p.o(this.nDR.nEl, aC.field_packageName)) ? 6 : 3;
                    if (B.type == 2) {
                        i2 = 4;
                    } else if (B.type == 5) {
                        i2 = 1;
                    }
                    com.tencent.mm.sdk.c.b ljVar = new lj();
                    ljVar.bmI.context = this.nDR.nEl;
                    ljVar.bmI.scene = 1;
                    ljVar.bmI.bmJ = B.appId;
                    ljVar.bmI.packageName = aC == null ? null : aC.field_packageName;
                    ljVar.bmI.msgType = B.type;
                    ljVar.bmI.bhM = r1;
                    ljVar.bmI.bmK = i2;
                    ljVar.bmI.mediaTagName = B.mediaTagName;
                    ljVar.bmI.bmL = r6;
                    ljVar.bmI.bmM = SQLiteDatabase.KeyEmpty;
                    com.tencent.mm.sdk.c.a.nhr.z(ljVar);
                    r rVar = j.a.lxN;
                    if (g.a(this.nDR.nEl, aC) || rVar == null) {
                        obj = null;
                    } else {
                        if (!be.kS(aC.bxu)) {
                            v.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", aC.bxu, Boolean.valueOf(p.aO(this.nDR.nEl, aC.bxu)));
                            if (p.aO(this.nDR.nEl, aC.bxu)) {
                                obj = 1;
                            }
                        }
                        com.tencent.mm.sdk.c.b fqVar = new fq();
                        fqVar.beY.actionCode = 2;
                        fqVar.beY.scene = 1;
                        fqVar.beY.appId = aC.field_appId;
                        fqVar.beY.context = this.nDR.nEl;
                        com.tencent.mm.sdk.c.a.nhr.z(fqVar);
                        Intent intent3 = new Intent();
                        rVar.z(aC.field_appId, 1, 1);
                        obj = 1;
                    }
                    if (obj != null) {
                        return;
                    }
                    if (B.aXa == null || B.aXa.length() == 0) {
                        r1 = atVar.field_content;
                        if (atVar.field_isSend == 0) {
                            i2 = atVar.field_isSend;
                            if (!this.lKa && m.dE(this.bdo) && r1 != null && i2 == 0) {
                                r1 = aw.fM(r1);
                            }
                        }
                        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(r1);
                        f aC2 = g.aC(dV.appId, true);
                        if (aC2 == null || !p.o(this.nDR.nEl, aC2.field_packageName)) {
                            r0 = p.t(this.nDR.nEl, dV.appId, "message");
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", r0);
                            com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent2);
                        } else if (aC2.field_status == 3) {
                            v.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + aC2.field_packageName);
                        } else if (!p.b(this.nDR.nEl, aC2)) {
                            v.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", aC2.field_appName);
                            Toast.makeText(this.nDR.nEl, getString(2131233088, new Object[]{g.a(this.nDR.nEl, aC2, null)}), 1).show();
                        } else if (!a(atVar, aC2)) {
                            WXMediaMessage.b wXAppExtendObject = new WXAppExtendObject();
                            wXAppExtendObject.extInfo = dV.extInfo;
                            if (dV.aXa != null && dV.aXa.length() > 0) {
                                com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(dV.aXa);
                                wXAppExtendObject.filePath = Gu == null ? null : Gu.field_fileFullPath;
                            }
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.sdkVer = 587333634;
                            wXMediaMessage.mediaObject = wXAppExtendObject;
                            wXMediaMessage.title = dV.title;
                            wXMediaMessage.description = dV.description;
                            wXMediaMessage.messageAction = dV.messageAction;
                            wXMediaMessage.messageExt = dV.messageExt;
                            wXMediaMessage.thumbData = e.c(n.GH().iW(atVar.field_imgPath), 0, -1);
                            new em(this).a(aC2.field_packageName, wXMediaMessage, aC2.field_openId);
                        }
                    } else if (this.lVu) {
                        intent2 = new Intent(this.nDR.nEl, AppAttachDownloadUI.class);
                        intent2.putExtra("app_msg_id", atVar.field_msgId);
                        startActivityForResult(intent2, 210);
                    } else {
                        s.ey(this.nDR.nEl);
                    }
                }
            } else if (atVar.bwn() || atVar.bwj() || atVar.bwo() || atVar.bwr()) {
                if (B == null || be.kS(B.cqg)) {
                    r0 = null;
                } else {
                    r1 = atVar.field_imgPath;
                    r4 = new Intent();
                    r4.putExtra("IsAd", false);
                    r4.putExtra("KStremVideoUrl", B.cqg);
                    r4.putExtra("KThumUrl", B.cql);
                    r4.putExtra("KThumbPath", r1);
                    r4.putExtra("KMediaId", "fakeid_" + atVar.field_msgId);
                    r4.putExtra("KMediaVideoTime", B.cqh);
                    r4.putExtra("StremWebUrl", B.cqk);
                    r4.putExtra("StreamWording", B.cqj);
                    r4.putExtra("KMediaTitle", B.title);
                    str = atVar.field_talker;
                    boolean endsWith = str.endsWith("@chatroom");
                    r1 = endsWith ? aw.fL(atVar.field_content) : str;
                    r4.putExtra("KSta_StremVideoAduxInfo", B.cqm);
                    r4.putExtra("KSta_StremVideoPublishId", B.cqn);
                    r4.putExtra("KSta_SourceType", 1);
                    r4.putExtra("KSta_Scene", endsWith ? com.tencent.mm.ui.chatting.a.b.TalkChat.value : com.tencent.mm.ui.chatting.a.b.Chat.value);
                    r4.putExtra("KSta_FromUserName", r1);
                    r4.putExtra("KSta_ChatName", str);
                    r4.putExtra("KSta_MsgId", atVar.field_msgSvrId);
                    r4.putExtra("KSta_SnsStatExtStr", B.bnY);
                    if (endsWith) {
                        r4.putExtra("KSta_ChatroomMembercount", i.el(str));
                    }
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "sns", ".ui.VideoAdPlayerUI", r4);
                    r0 = 1;
                }
                if (r0 == null) {
                    E(view, i);
                }
            } else if (B != null && B.type == 15) {
                r0 = B.coF;
                if (TextUtils.isEmpty(r0)) {
                    r0 = j.a.bmr().rn(B.url);
                }
                if (TextUtils.isEmpty(r0)) {
                    Intent intent4 = new Intent();
                    intent4.putExtra("geta8key_username", k.xF());
                    intent4.putExtra("rawUrl", B.url);
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent4);
                    return;
                }
                v.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                intent2 = new Intent();
                intent2.putExtra("extra_id", r0);
                intent2.putExtra("preceding_scence", 123);
                intent2.putExtra("download_entrance_scene", 23);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                com.tencent.mm.plugin.report.service.g.iuh.h(10993, Integer.valueOf(2), r0);
            } else if (B != null && B.type == 26) {
                r1 = B.tid;
                str = B.cqe;
                r3 = B.desc;
                r4 = B.iconUrl;
                r6 = B.secondUrl;
                r7 = B.pageType;
                if (r1 != 0) {
                    Intent intent5 = new Intent();
                    intent5.putExtra("geta8key_username", aT(atVar));
                    intent5.putExtra("rawUrl", B.bNm);
                    intent5.putExtra("topic_id", r1);
                    intent5.putExtra("topic_name", str);
                    intent5.putExtra("topic_desc", r3);
                    intent5.putExtra("topic_icon_url", r4);
                    intent5.putExtra("topic_ad_url", r6);
                    intent5.putExtra("extra_scence", 23);
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "emoji", ".ui.EmojiStoreTopicUI", intent5);
                    return;
                }
                v.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            } else if (B == null || B.type != 27) {
                v.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", atVar.field_talker, Long.valueOf(atVar.field_msgId), Integer.valueOf(atVar.field_type), atVar.field_content);
                if (B.url != null && !B.url.equals(SQLiteDatabase.KeyEmpty) && B.url != null && !B.url.equals(SQLiteDatabase.KeyEmpty)) {
                    r1 = p.s(B.url, m.dE(this.bdo) ? "groupmessage" : "singlemessage");
                    str = B.url;
                    r3 = av(this.nDR.nEl, B.appId);
                    r4 = new Intent();
                    r4.putExtra("rawUrl", r1);
                    r4.putExtra("webpageTitle", B.title);
                    if (B.appId != null && ("wx751a1acca5688ba3".equals(B.appId) || "wxfbc915ff7c30e335".equals(B.appId) || "wx482a4001c37e2b74".equals(B.appId))) {
                        r1 = new Bundle();
                        r1.putString("jsapi_args_appid", B.appId);
                        r4.putExtra("jsapiargs", r1);
                    }
                    if (be.kS(str)) {
                        r4.putExtra("shortUrl", B.url);
                    } else {
                        r4.putExtra("shortUrl", str);
                    }
                    r4.putExtra("version_name", r3 == null ? null : r3.versionName);
                    r4.putExtra("version_code", r3 == null ? 0 : r3.versionCode);
                    if (!be.kS(B.bnR)) {
                        r4.putExtra("srcUsername", B.bnR);
                        r4.putExtra("srcDisplayname", B.bnS);
                    }
                    r4.putExtra("msg_id", atVar.field_msgId);
                    r4.putExtra("KPublisherId", "msg_" + Long.toString(atVar.field_msgSvrId));
                    r4.putExtra("KAppId", B.appId);
                    r4.putExtra("geta8key_username", k.xF());
                    r4.putExtra("pre_username", aT(atVar));
                    r4.putExtra("prePublishId", "msg_" + Long.toString(atVar.field_msgSvrId));
                    r0 = aT(atVar);
                    r1 = k.xF();
                    r4.putExtra("preUsername", r0);
                    r4.putExtra("preChatName", r1);
                    r4.putExtra("preChatTYPE", com.tencent.mm.model.n.F(r0, r1));
                    r4.putExtra("preMsgIndex", 0);
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", r4);
                }
            } else {
                r1 = B.tid;
                str = B.cqe;
                r3 = B.desc;
                r4 = B.iconUrl;
                r6 = B.secondUrl;
                r7 = B.pageType;
                if (r1 != 0) {
                    Intent intent6 = new Intent();
                    intent6.putExtra("geta8key_username", aT(atVar));
                    intent6.putExtra("rawUrl", B.bNm);
                    intent6.putExtra("set_id", r1);
                    intent6.putExtra("set_title", str);
                    intent6.putExtra("set_iconURL", r4);
                    intent6.putExtra("set_desc", r3);
                    intent6.putExtra("headurl", r6);
                    intent6.putExtra("pageType", r7);
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent6);
                    return;
                }
                v.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            }
        } else if (B.url != null && !B.url.equals(SQLiteDatabase.KeyEmpty)) {
            r1 = p.s(B.url, this.bdo.endsWith("@chatroom") ? "groupmessage" : "singlemessage");
            str = B.url;
            r3 = av(this.nDR.nEl, B.appId);
            r4 = new Intent();
            r4.putExtra("rawUrl", r1);
            r4.putExtra("webpageTitle", B.title);
            if (B.appId != null && ("wx751a1acca5688ba3".equals(B.appId) || "wxfbc915ff7c30e335".equals(B.appId) || "wx482a4001c37e2b74".equals(B.appId))) {
                r1 = new Bundle();
                r1.putString("jsapi_args_appid", B.appId);
                r4.putExtra("jsapiargs", r1);
            }
            if (be.kS(str)) {
                r4.putExtra("shortUrl", B.url);
            } else {
                r4.putExtra("shortUrl", str);
            }
            r4.putExtra("version_name", r3 == null ? null : r3.versionName);
            r4.putExtra("version_code", r3 == null ? 0 : r3.versionCode);
            if (!be.kS(B.bnR)) {
                r4.putExtra("srcUsername", B.bnR);
                r4.putExtra("srcDisplayname", B.bnS);
            }
            r4.putExtra("msg_id", atVar.field_msgId);
            r4.putExtra("KPublisherId", "msg_" + Long.toString(atVar.field_msgSvrId));
            r4.putExtra("KAppId", B.appId);
            r4.putExtra("geta8key_username", this.bdo);
            r1 = aT(atVar);
            r4.putExtra("pre_username", r1);
            r4.putExtra("prePublishId", "msg_" + Long.toString(atVar.field_msgSvrId));
            r4.putExtra("preUsername", r1);
            r4.putExtra("preChatName", this.bdo);
            r4.putExtra("preChatTYPE", com.tencent.mm.model.n.F(r1, this.bdo));
            r4.putExtra("preMsgIndex", 0);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", r4);
        }
    }

    private boolean a(at atVar, f fVar) {
        if (!atVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        v.d("MicroMsg.GalleryGridUI", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName("com.tencent.mobileqq", al(this.nDR.nEl, "com.tencent.mobileqq"));
        intent.putExtra("platformId", "wechat");
        com.tencent.mm.model.ak.yW();
        Object obj = com.tencent.mm.model.c.vf().get(9, null);
        if (obj == null || !(obj instanceof Integer)) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        if (i != 0) {
            try {
                byte[] bytes = String.valueOf(i).getBytes("utf-8");
                byte[] bytes2 = "asdfghjkl;'".getBytes("utf-8");
                int length = bytes2.length;
                i = 0;
                int i2 = 0;
                while (i < length) {
                    byte b = bytes2[i];
                    if (i2 >= bytes.length) {
                        break;
                    }
                    int i3 = i2 + 1;
                    bytes[i2] = (byte) (b ^ bytes[i2]);
                    i++;
                    i2 = i3;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (Throwable e) {
                v.a("MicroMsg.GalleryGridUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        try {
            startActivity(intent);
        } catch (Exception e2) {
        }
        return true;
    }

    private static String al(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.GalleryGridUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String aT(com.tencent.mm.storage.at r4) {
        /*
        r3 = this;
        r1 = r3.bdo;
        r0 = r3.bdo;
        r2 = "@chatroom";
        r0 = r0.endsWith(r2);
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        if (r0 == 0) goto L_0x0022;
    L_0x0010:
        r0 = r4.field_content;
        r0 = com.tencent.mm.model.aw.fL(r0);
        if (r1 == 0) goto L_0x0022;
    L_0x0018:
        if (r0 == 0) goto L_0x0022;
    L_0x001a:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0022;
    L_0x0020:
        r1 = r0;
        goto L_0x000d;
    L_0x0022:
        r0 = r1;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.aT(com.tencent.mm.storage.at):java.lang.String");
    }

    private static PackageInfo av(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f aC = g.aC(str, true);
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
                v.a("MicroMsg.GalleryGridUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return packageInfo;
    }

    private void aU(at atVar) {
        long j = this.oqS + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.oqS = currentTimeMillis;
        if (j < currentTimeMillis) {
            com.tencent.mm.model.ak.yW();
            this.lVu = com.tencent.mm.model.c.isSDCardAvailable();
        }
        if (this.lVu) {
            Intent intent = new Intent(this.nDR.nEl, AppAttachDownloadUI.class);
            intent.putExtra("app_msg_id", atVar.field_msgId);
            startActivity(intent);
            return;
        }
        s.ey(this.nDR.nEl);
    }

    private void E(View view, int i) {
        if (this.oAE != null) {
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_biz_chat_id", this.ezh);
            intent.putExtra("key_is_biz_chat", this.lKa);
            intent.putExtra("intent.key.with.footer", true);
            at atVar = (at) this.oAE.getItem(i);
            if (atVar != null) {
                int width;
                int height;
                int i2 = getResources().getConfiguration().orientation;
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.putExtra("img_gallery_msg_id", atVar.field_msgId).putExtra("img_gallery_msg_svr_id", atVar.field_msgSvrId).putExtra("img_gallery_talker", atVar.field_talker).putExtra("img_gallery_chatroom_name", atVar.field_talker).putExtra("img_gallery_orientation", i2);
                if (view != null) {
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
                } else {
                    intent.putExtra("img_gallery_back_from_grid", true);
                }
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        }
    }

    public boolean onPreDraw() {
        a aVar = (a) this.oAF.get();
        if (aVar != null) {
            ViewTreeObserver viewTreeObserver = aVar.iQA.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                int measuredWidth = aVar.iQA.getMeasuredWidth();
                int measuredHeight = aVar.iQA.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = (LayoutParams) aVar.oAz.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.oAz.setLayoutParams(layoutParams);
                    final View view = aVar.oAz;
                    final TimeInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    if (VERSION.SDK_INT >= 12) {
                        this.oAN = view;
                        this.handler.postDelayed(new Runnable(this) {
                            final /* synthetic */ ImageGalleryGridUI oAU;

                            public final void run() {
                                if (VERSION.SDK_INT >= 16) {
                                    view.animate().setDuration(500).alpha(0.0f).withEndAction(this.oAU.oAM).withLayer().setInterpolator(decelerateInterpolator);
                                } else if (this.oAU.handler != null) {
                                    view.animate().setDuration(500).alpha(0.0f).setInterpolator(decelerateInterpolator);
                                    this.oAU.handler.postDelayed(this.oAU.oAM, 500);
                                }
                            }
                        }, 700);
                    }
                }
            }
        }
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getTitle().equals(getString(2131233023))) {
            a.oBx.clear();
            bGz();
        } else {
            bGB();
        }
        return false;
    }

    private void bGz() {
        Fd(getString(2131233046, new Object[]{Integer.valueOf(a.oBx.ozS.size())}));
        a.oBx.oBv = true;
        if (this.oAE != null) {
            if (this.iVP == null) {
                this.iVP = AnimationUtils.loadAnimation(this, 2130968646);
            }
            c cVar = this.oAE;
            cVar.cWm = false;
            cVar.notifyDataSetChanged();
            this.oAO.setVisibility(0);
            this.oAO.startAnimation(this.iVP);
            this.oAQ.setEnabled(false);
            this.oAR.setEnabled(false);
            this.oAS.setEnabled(false);
            this.oAT.setEnabled(false);
            this.oAP = this.oAD.getPaddingBottom();
            this.oAD.setPadding(this.oAD.getPaddingLeft(), this.oAD.getPaddingTop(), this.oAD.getPaddingRight(), com.tencent.mm.bd.a.N(this.nDR.nEl, 2131493198));
            com.tencent.mm.plugin.report.service.g.iuh.h(11627, Integer.valueOf(2));
            vH(0);
            a(0, getString(2131233022), (OnMenuItemClickListener) this);
        }
    }

    private void bGA() {
        boolean z = !a.oBx.ozS.isEmpty() && a.oBx.oBv;
        if (z) {
            this.oAQ.setEnabled(true);
            this.oAR.setEnabled(true);
            this.oAS.setEnabled(true);
            this.oAT.setEnabled(true);
            return;
        }
        this.oAQ.setEnabled(false);
        this.oAR.setEnabled(false);
        this.oAS.setEnabled(false);
        this.oAT.setEnabled(false);
    }

    public final void bGB() {
        a.oBx.oBv = false;
        Fd(getString(2131230888));
        if (this.oAE != null) {
            this.oAE.notifyDataSetChanged();
            if (this.oAP >= 0) {
                this.oAD.setPadding(this.oAD.getPaddingLeft(), this.oAD.getPaddingTop(), this.oAD.getPaddingRight(), this.oAP);
            }
            this.oAO.setVisibility(8);
            vH(0);
            a(0, getString(2131233023), (OnMenuItemClickListener) this);
        }
    }

    public void onClick(View view) {
        if (!a.oBx.ozS.isEmpty()) {
            boolean endsWith = this.bdo.toLowerCase().endsWith("@chatroom");
            final List<at> list = a.oBx.ozS;
            if (list != null && !list.isEmpty()) {
                at atVar;
                if (view.getId() == 2131756336) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11627, Integer.valueOf(5));
                    final Set treeSet = new TreeSet();
                    for (at atVar2 : list) {
                        treeSet.add(Long.valueOf(atVar2.field_msgId));
                    }
                    com.tencent.mm.ui.base.g.b((Context) this, getString(2131231970), SQLiteDatabase.KeyEmpty, getString(2131232281), getString(2131231010), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ImageGalleryGridUI oAU;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            v.i("MicroMsg.GalleryGridUI", "delete message");
                            w.a(this.oAU, treeSet, this.oAU);
                            this.oAU.bGB();
                        }
                    }, null);
                } else if (view.getId() == 2131757468) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(219, 18, 1, true);
                    final bp bpVar = new bp();
                    if (com.tencent.mm.pluginsdk.model.e.a(this.nDR.nEl, bpVar, this.bdo, list, false)) {
                        a(bpVar);
                        cu(list);
                    } else if (list.size() > 1) {
                        com.tencent.mm.ui.base.g.a(this.nDR.nEl, 2131232663, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ ImageGalleryGridUI oAU;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (bpVar.aZd.type == 14 && bpVar.aZd.aZf.mtR.size() == 0) {
                                    this.oAU.bGB();
                                    return;
                                }
                                this.oAU.a(bpVar);
                                ImageGalleryGridUI.cu(list);
                            }
                        }, null);
                    } else {
                        com.tencent.mm.ui.base.g.f(this.nDR.nEl, bpVar.aZd.aZk, 0);
                    }
                } else if (view.getId() == 2131757467) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(219, 19, 1, true);
                    y.a(this, list, endsWith, this.bdo, this);
                    bGB();
                } else {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11627, Integer.valueOf(3));
                    final List cz = cz(list);
                    if (cz.size() != list.size()) {
                        com.tencent.mm.ui.base.g.a(this.nDR.nEl, 2131233044, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ ImageGalleryGridUI oAU;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.c(this.oAU.nDR.nEl, cz);
                                this.oAU.bGB();
                            }
                        }, null);
                        return;
                    }
                    atVar2 = (at) cz.get(0);
                    if (list.size() == 1 && atVar2 != null && atVar2.bvY()) {
                        String str = atVar2.field_content;
                        com.tencent.mm.q.a.a aVar = null;
                        if (str != null) {
                            aVar = com.tencent.mm.q.a.a.B(str, atVar2.field_reserved);
                        }
                        if (aVar != null && aVar.type == 6) {
                            aU(atVar2);
                            return;
                        }
                        return;
                    }
                    b.c((Context) this, (List) list);
                    bGB();
                }
            }
        }
    }

    private static void cu(List<at> list) {
        for (at a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, d.Samll, a, 0);
        }
    }

    private static List<at> cz(List<at> list) {
        List<at> arrayList = new ArrayList();
        for (at atVar : list) {
            if (!(b.aJ(atVar) || b.aK(atVar))) {
                arrayList.add(atVar);
            }
        }
        return arrayList;
    }

    private void a(bp bpVar) {
        bpVar.aZd.aXH = this;
        bpVar.aZd.aZl = 45;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
        if (bpVar.aZe.ret == 0) {
            bGB();
            if (14 != bpVar.aZd.type) {
                v.d("MicroMsg.GalleryGridUI", "not record type, do not report");
            } else if (bpVar.aZd.aZg == null) {
                v.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.h(11142, Integer.valueOf(bpVar.aZd.aZg.muc), Integer.valueOf(bpVar.aZd.aZg.mud), Integer.valueOf(bpVar.aZd.aZg.mue), Integer.valueOf(bpVar.aZd.aZg.muf), Integer.valueOf(bpVar.aZd.aZg.mug), Integer.valueOf(bpVar.aZd.aZg.muh), Integer.valueOf(bpVar.aZd.aZg.mui), Integer.valueOf(bpVar.aZd.aZg.muj), Integer.valueOf(bpVar.aZd.aZg.muk), Integer.valueOf(bpVar.aZd.aZg.mul), Integer.valueOf(bpVar.aZd.aZg.mum), Integer.valueOf(bpVar.aZd.aZg.mun), Integer.valueOf(bpVar.aZd.aZg.muo), Integer.valueOf(bpVar.aZd.aZg.mup), Integer.valueOf(bpVar.aZd.aZg.muq));
            }
        }
    }

    public final void bGC() {
        if (this.oAE != null && this.aUP) {
            this.oAE.oAr = true;
        }
        Fd(getString(2131233046, new Object[]{Integer.valueOf(a.oBx.ozS.size())}));
        bGA();
    }

    public final void clear() {
        if (this.oAE != null && this.aUP) {
            this.oAE.oAr = true;
        }
        bGA();
    }

    public final void bEM() {
    }

    public final boolean bEN() {
        return true;
    }

    public final void xd(int i) {
        if (i == dq.a.oyc) {
            this.oAE.Ol();
            this.oAE.notifyDataSetChanged();
        }
        bGB();
    }
}
