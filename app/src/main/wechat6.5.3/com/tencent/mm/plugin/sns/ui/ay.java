package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.bh.c;
import com.tencent.mm.e.a.jr;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.at;
import com.tencent.mm.plugin.sns.e.b.b;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.List;

public class ay implements com.tencent.mm.plugin.sns.e.at.a, b {
    private String dRA;
    protected p dwg = null;
    protected String filePath;
    protected ListView gMx;
    private String gpi;
    protected MMPullDownView hkk;
    private boolean jGc;
    private String jUP;
    private boolean jUQ;
    private int jUR;
    protected LoadingMoreView jXE;
    private int jXF = 0;
    private boolean jXG = false;
    protected boolean jXH = false;
    private boolean jXI = false;
    public int jXJ = 0;
    a jXK;
    private String jXL;
    com.tencent.mm.modelsns.a jXM = null;
    public int jbB = 0;
    protected SnsHeader jrk;
    private Activity pP;
    protected String title;

    public interface a {
        void J(int i, boolean z);

        void a(int i, List<Integer> list, List<Integer> list2);

        void aXK();

        ListView aXL();

        MMPullDownView aXM();

        boolean aXN();

        void aXO();

        void aXP();

        void aXQ();

        int getType();

        void gw(boolean z);
    }

    static /* synthetic */ void e(ay ayVar) {
        View inflate = LayoutInflater.from(ayVar.pP).inflate(2130904482, (ViewGroup) ayVar.pP.findViewById(2131759431));
        s sVar = new s(ayVar.pP);
        sVar.setGravity(48, 0, BackwardSupportUtil.b.a(ayVar.pP, 200.0f));
        sVar.dfS = 1000;
        sVar.setView(inflate);
        sVar.cancel();
        sVar.aSW.QI();
        sVar.eKW = ((int) (sVar.dfS / 70)) + 1;
        sVar.aSW.ea(70);
    }

    public ay(Activity activity) {
        this.pP = activity;
    }

    public final void onCreate() {
        this.jbB = this.pP.getWindowManager().getDefaultDisplay().getHeight();
        ad.aSB().start();
        this.gMx = this.jXK.aXL();
        this.gMx.post(new Runnable(this) {
            final /* synthetic */ ay jXN;

            {
                this.jXN = r1;
            }

            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.jXN.pP.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                ad.aSt();
                com.tencent.mm.plugin.sns.storage.p.cv(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        });
        v.i("MicroMsg.SnsActivity", "list is null ? " + (this.gMx != null));
        this.gMx.setScrollingCacheEnabled(false);
        this.jrk = new SnsHeader(this.pP);
        this.jrk.jOv = new com.tencent.mm.plugin.sns.ui.SnsHeader.a(this) {
            final /* synthetic */ ay jXN;

            {
                this.jXN = r1;
            }

            public final boolean dj(long j) {
                if (this.jXN.jGc || this.jXN.jXK.getType() == 1) {
                    this.jXN.rj(2);
                } else {
                    k kVar = new k();
                    kVar.field_snsId = j;
                    kVar.field_userName = this.jXN.dRA;
                    azr JI = d.JI();
                    JI.gln = this.jXN.dRA;
                    kVar.b(JI);
                    k At = ah.At(this.jXN.dRA);
                    v.d("MicroMsg.SnsActivity", "friend like %s", new Object[]{this.jXN.dRA});
                    if (At == null) {
                        com.tencent.mm.plugin.sns.e.ak.a.a(kVar, 1, "");
                    } else if (At.aUK()) {
                        com.tencent.mm.plugin.sns.e.ak.a.a(kVar, 1, "");
                    } else {
                        com.tencent.mm.plugin.sns.e.ak.a.a(kVar, 5, "");
                    }
                    i Bu = ad.aSG().Bu(this.jXN.dRA);
                    Bu.field_local_flag |= 2;
                    ad.aSG().c(Bu);
                    ay.e(this.jXN);
                }
                return false;
            }

            public final boolean aWR() {
                this.jXN.jXK.aXP();
                return false;
            }
        };
        this.jXE = new LoadingMoreView(this.pP);
        this.gMx.addHeaderView(this.jrk);
        this.gMx.addFooterView(this.jXE);
        this.gMx.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ay jXN;

            {
                this.jXN = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                this.jXN.jXK.aXQ();
                if (i == 0) {
                    pn pnVar = new pn();
                    pnVar.bqP.type = 5;
                    pnVar.bqP.bqQ = this.jXN.gMx.getFirstVisiblePosition();
                    pnVar.bqP.bqR = this.jXN.gMx.getLastVisiblePosition();
                    pnVar.bqP.bqS = this.jXN.gMx.getHeaderViewsCount();
                    com.tencent.mm.sdk.c.a.nhr.z(pnVar);
                    if ((this.jXN.pP instanceof SnsTimeLineUI) && ((SnsTimeLineUI) this.jXN.pP).jMU != null) {
                        ((SnsTimeLineUI) this.jXN.pP).jMU.aQU();
                    }
                }
                if (i == 2) {
                    c.byp().bX(ay.class.getName() + this.jXN.jXK.getType() + ".Listview", 4);
                    this.jXN.gw(true);
                    return;
                }
                this.jXN.gw(false);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.jXN.jXJ = (i + i2) - 1;
                if (this.jXN.gMx.getLastVisiblePosition() == this.jXN.gMx.getCount() - 1 && this.jXN.gMx.getCount() != this.jXN.jXF) {
                    v.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[]{Integer.valueOf(this.jXN.gMx.getCount())});
                    this.jXN.jXF = this.jXN.gMx.getCount();
                    this.jXN.jXK.aXK();
                }
            }
        });
        this.hkk = this.jXK.aXM();
        v.i("MicroMsg.SnsActivity", "pullDownView is null ? " + (this.hkk != null));
        this.hkk.nWT = new g(this) {
            final /* synthetic */ ay jXN;

            {
                this.jXN = r1;
            }

            public final boolean azp() {
                this.jXN.jXK.aXO();
                return true;
            }
        };
        this.hkk.jr(false);
        this.hkk.jo(false);
        this.hkk.nXf = new MMPullDownView.c(this) {
            final /* synthetic */ ay jXN;

            {
                this.jXN = r1;
            }

            public final boolean agv() {
                View childAt = this.jXN.gMx.getChildAt(this.jXN.gMx.getChildCount() - 1);
                if (childAt == null || childAt.getBottom() > this.jXN.gMx.getHeight() || this.jXN.gMx.getLastVisiblePosition() != this.jXN.gMx.getAdapter().getCount() - 1) {
                    return false;
                }
                return true;
            }
        };
        this.hkk.nXg = new MMPullDownView.d(this) {
            final /* synthetic */ ay jXN;

            {
                this.jXN = r1;
            }

            public final boolean agu() {
                View childAt = this.jXN.gMx.getChildAt(this.jXN.gMx.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.hkk.jp(false);
        this.hkk.nWU = new e(this) {
            final /* synthetic */ ay jXN;

            {
                this.jXN = r1;
            }

            public final boolean agi() {
                v.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + this.jXN.jXH);
                if (!this.jXN.jXH) {
                    this.jXN.jXK.aXK();
                }
                return true;
            }
        };
        this.hkk.nXw = true;
        MMPullDownView mMPullDownView = this.hkk;
        mMPullDownView.bgColor = Color.parseColor("#f4f4f4");
        mMPullDownView.nXy = mMPullDownView.bgColor;
        this.title = this.pP.getIntent().getStringExtra("sns_title");
        SnsHeader snsHeader = this.jrk;
        Object obj = be.kS(this.dRA) ? this.jUP : this.dRA;
        String str = this.jUP;
        CharSequence charSequence = this.gpi;
        CharSequence charSequence2 = this.jXL;
        if (obj == null || str == null) {
            v.e("MicroMsg.SnsHeader", "userName or selfName is null ");
        } else {
            snsHeader.userName = obj.trim();
            snsHeader.bYE = str.trim();
            snsHeader.bcR = str.equals(obj);
            v.d("MicroMsg.SnsHeader", "userNamelen " + obj.length() + "  " + obj);
            snsHeader.jOu.emU.setText(obj);
            if (!(snsHeader.jOu == null || snsHeader.jOu.dtz == null)) {
                com.tencent.mm.pluginsdk.ui.a.b.b(snsHeader.jOu.dtz, snsHeader.userName, true);
            }
            if (obj != null && obj.length() > 0) {
                snsHeader.jOu.emU.setText(com.tencent.mm.pluginsdk.ui.d.e.a(snsHeader.context, com.tencent.mm.plugin.sns.data.i.t(charSequence)));
                snsHeader.jOu.jDP.setText(com.tencent.mm.pluginsdk.ui.d.e.a(snsHeader.context, charSequence2, snsHeader.jOu.jDP.getTextSize()));
            }
            snsHeader.jOu.dtz.setContentDescription(snsHeader.context.getString(2131235375, new Object[]{snsHeader.jOu.emU.getText()}));
        }
        SnsHeader snsHeader2 = this.jrk;
        int type = this.jXK.getType();
        snsHeader2.type = type;
        if (type == 1 && snsHeader2.jOu.jDP != null) {
            snsHeader2.jOu.jDP.setVisibility(8);
        }
        this.jrk.aWP();
        if (VERSION.SDK_INT < 11) {
            v.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
        } else {
            new Runnable(this) {
                final /* synthetic */ ay jXN;

                {
                    this.jXN = r1;
                }

                public final void run() {
                    OnDragListener anonymousClass1 = new OnDragListener(this) {
                        final /* synthetic */ AnonymousClass5 jXO;

                        {
                            this.jXO = r1;
                        }

                        public final boolean onDrag(View view, DragEvent dragEvent) {
                            int i = 0;
                            switch (dragEvent.getAction()) {
                                case 1:
                                case 2:
                                case 4:
                                case 5:
                                    v.i("MicroMsg.SnsActivity", "ACTION: [%s]", new Object[]{Integer.valueOf(dragEvent.getAction())});
                                    return true;
                                case 3:
                                    v.i("MicroMsg.SnsActivity", "ACTION_DROP");
                                    ClipData clipData = dragEvent.getClipData();
                                    if (clipData == null) {
                                        return true;
                                    }
                                    int itemCount = clipData.getItemCount();
                                    ArrayList arrayList = new ArrayList();
                                    while (i < itemCount) {
                                        Item itemAt = clipData.getItemAt(i);
                                        if (itemAt == null) {
                                            v.e("MicroMsg.SnsActivity", "item == null");
                                        } else if (itemAt.getIntent() != null) {
                                            this.jXO.jXN.pP.startActivity(itemAt.getIntent());
                                        } else if (itemAt.getUri() != null) {
                                            m mVar = new m(this.jXO.jXN.pP, itemAt.getUri());
                                            if (mVar.fileType != 0 && mVar.filePath != null) {
                                                switch (mVar.fileType) {
                                                    case 3:
                                                        arrayList.add(mVar.filePath);
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                            v.e("MicroMsg.SnsActivity", "get file path failed");
                                        }
                                        i++;
                                    }
                                    if (arrayList.size() < 0) {
                                        v.e("MicroMsg.SnsActivity", "no image file available");
                                        return true;
                                    }
                                    Intent intent = new Intent(this.jXO.jXN.pP, SnsUploadUI.class);
                                    intent.putExtra("KSnsPostManu", true);
                                    intent.putExtra("KTouchCameraTime", be.Nh());
                                    intent.putStringArrayListExtra("sns_kemdia_path_list", arrayList);
                                    intent.setAction("android.intent.action.SEND");
                                    intent.addCategory("android.intent.category.DEFAULT");
                                    intent.addFlags(268435456);
                                    intent.putExtra("android.intent.extra.TEXT", "");
                                    intent.putExtra("Ksnsupload_empty_img", true);
                                    if (this.jXO.jXN.jGc) {
                                        intent.putExtra("Ksnsupload_source", 11);
                                    }
                                    intent.setType("image/*");
                                    this.jXO.jXN.pP.startActivity(intent);
                                    return true;
                                default:
                                    v.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
                                    return false;
                            }
                        }
                    };
                    if (this.jXN.jrk != null) {
                        this.jXN.jrk.setOnDragListener(anonymousClass1);
                    }
                }
            }.run();
        }
        ad.aSA().cbh.add(this);
        at.jiE++;
        ad.aSz().a((b) this);
    }

    public final void gw(boolean z) {
        this.jXK.gw(z);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2, int i) {
        this.jUP = str;
        this.dRA = str2;
        this.gpi = str3;
        this.jXL = str4;
        this.jUQ = z;
        this.jGc = z2;
        this.jUR = i;
    }

    public static void onResume() {
        ad.aSz().G(2, false);
        f.ux(7);
        jr jrVar = new jr();
        jrVar.bkd.bke = true;
        com.tencent.mm.sdk.c.a.nhr.a(jrVar, Looper.getMainLooper());
        v.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    }

    public static void onPause() {
        jr jrVar = new jr();
        jrVar.bkd.bke = false;
        com.tencent.mm.sdk.c.a.nhr.a(jrVar, Looper.getMainLooper());
        v.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
        r10 = this;
        r0 = "MicroMsg.SnsActivity";
        r1 = new java.lang.StringBuilder;
        r2 = "onAcvityResult requestCode:";
        r1.<init>(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = -1;
        if (r12 == r0) goto L_0x0034;
    L_0x0019:
        r0 = 5;
        if (r11 == r0) goto L_0x0022;
    L_0x001c:
        r0 = 2;
        if (r11 == r0) goto L_0x0022;
    L_0x001f:
        r0 = 4;
        if (r11 != r0) goto L_0x0033;
    L_0x0022:
        r0 = new com.tencent.mm.sdk.platformtools.ac;
        r1 = android.os.Looper.getMainLooper();
        r0.<init>(r1);
        r1 = new com.tencent.mm.plugin.sns.ui.ay$12;
        r1.<init>(r10);
        r0.post(r1);
    L_0x0033:
        return;
    L_0x0034:
        switch(r11) {
            case 2: goto L_0x0151;
            case 3: goto L_0x0037;
            case 4: goto L_0x03f6;
            case 5: goto L_0x00f4;
            case 6: goto L_0x0406;
            case 7: goto L_0x0429;
            case 8: goto L_0x0440;
            case 9: goto L_0x0462;
            case 10: goto L_0x0470;
            case 11: goto L_0x0037;
            case 12: goto L_0x04b7;
            case 13: goto L_0x04de;
            case 14: goto L_0x01aa;
            case 15: goto L_0x0033;
            case 16: goto L_0x0037;
            case 17: goto L_0x0041;
            default: goto L_0x0037;
        };
    L_0x0037:
        r0 = "MicroMsg.SnsActivity";
        r1 = "onActivityResult: not found this requestCode";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x0033;
    L_0x0041:
        r0 = "key_req_result";
        r0 = r13.getParcelableExtra(r0);
        r0 = (com.tencent.mm.pluginsdk.ui.tools.SightCaptureResult) r0;
        if (r0 == 0) goto L_0x0033;
    L_0x004c:
        r1 = r0.lTX;
        if (r1 == 0) goto L_0x0063;
    L_0x0050:
        r0 = r0.lUf;
        r10.filePath = r0;
        r0 = r10.filePath;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x0033;
    L_0x005c:
        r0 = 1;
        r10.jXI = r0;
        r10.H(r13);
        goto L_0x0033;
    L_0x0063:
        r1 = "MicroMsg.SnsActivity";
        r2 = "video path %s thumb path ";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r0.lTZ;
        r3[r4] = r5;
        r4 = 1;
        r5 = r0.lUa;
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = "KSightPath";
        r3 = r0.lTZ;
        r1.putExtra(r2, r3);
        r2 = "KSightThumbPath";
        r3 = r0.lUa;
        r1.putExtra(r2, r3);
        r2 = r0.lUc;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 != 0) goto L_0x00d2;
    L_0x0096:
        r2 = "sight_md5";
        r3 = r0.lUc;
        r1.putExtra(r2, r3);
    L_0x009e:
        r2 = "KSnsPostManu";
        r3 = 1;
        r1.putExtra(r2, r3);
        r2 = "KTouchCameraTime";
        r4 = com.tencent.mm.sdk.platformtools.be.Nh();
        r1.putExtra(r2, r4);
        r2 = "Ksnsupload_type";
        r3 = 14;
        r1.putExtra(r2, r3);
        r0 = r0.lUe;	 Catch:{ Exception -> 0x00df }
        r0 = r0.toByteArray();	 Catch:{ Exception -> 0x00df }
        if (r0 == 0) goto L_0x00c5;
    L_0x00bf:
        r2 = "KMMSightExtInfo";
        r1.putExtra(r2, r0);	 Catch:{ Exception -> 0x00df }
    L_0x00c5:
        r0 = r10.pP;
        r2 = "sns";
        r3 = ".ui.SnsUploadUI";
        com.tencent.mm.ay.c.b(r0, r2, r3, r1);
        goto L_0x0033;
    L_0x00d2:
        r2 = "sight_md5";
        r3 = r0.lTZ;
        r3 = com.tencent.mm.a.g.aX(r3);
        r1.putExtra(r2, r3);
        goto L_0x009e;
    L_0x00df:
        r0 = move-exception;
        r2 = "MicroMsg.SnsActivity";
        r3 = "put sight extinfo to snsuploadui error: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r0.getMessage();
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        goto L_0x00c5;
    L_0x00f4:
        r0 = r10.pP;
        r0 = r0.getApplicationContext();
        r1 = com.tencent.mm.plugin.sns.e.ad.xi();
        r0 = com.tencent.mm.pluginsdk.ui.tools.l.a(r0, r13, r1);
        r10.filePath = r0;
        r0 = "MicroMsg.SnsActivity";
        r1 = new java.lang.StringBuilder;
        r2 = "onActivityResult CONTEXT_TAKE_PHOTO  filePath";
        r1.<init>(r2);
        r2 = r10.filePath;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        r0 = r10.filePath;
        if (r0 == 0) goto L_0x0033;
    L_0x0120:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.vf();
        r1 = 68392; // 0x10b28 float:9.5838E-41 double:3.379E-319;
        r2 = 0;
        r0 = r0.get(r1, r2);
        r0 = (java.lang.Integer) r0;
        r1 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.a(r0, r1);
        com.tencent.mm.model.ak.yW();
        r1 = com.tencent.mm.model.c.vf();
        r2 = 68392; // 0x10b28 float:9.5838E-41 double:3.379E-319;
        r0 = r0 + 1;
        r0 = java.lang.Integer.valueOf(r0);
        r1.set(r2, r0);
        r0 = 1;
        r10.jXI = r0;
        r10.H(r13);
        goto L_0x0033;
    L_0x0151:
        if (r13 == 0) goto L_0x0033;
    L_0x0153:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.vf();
        r1 = 68393; // 0x10b29 float:9.5839E-41 double:3.37906E-319;
        r2 = 0;
        r0 = r0.get(r1, r2);
        r0 = (java.lang.Integer) r0;
        r1 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.a(r0, r1);
        com.tencent.mm.model.ak.yW();
        r1 = com.tencent.mm.model.c.vf();
        r2 = 68393; // 0x10b29 float:9.5839E-41 double:3.37906E-319;
        r0 = r0 + 1;
        r0 = java.lang.Integer.valueOf(r0);
        r1.set(r2, r0);
        r3 = new android.content.Intent;
        r3.<init>();
        r0 = "CropImageMode";
        r1 = 4;
        r3.putExtra(r0, r1);
        r0 = "CropImage_Filter";
        r1 = 1;
        r3.putExtra(r0, r1);
        r0 = "CropImage_DirectlyIntoFilter";
        r1 = 1;
        r3.putExtra(r0, r1);
        r0 = com.tencent.mm.plugin.sns.b.a.drp;
        r1 = r10.pP;
        r4 = com.tencent.mm.plugin.sns.e.ad.xi();
        r5 = 4;
        r6 = new com.tencent.mm.plugin.sns.ui.ay$13;
        r6.<init>(r10);
        r2 = r13;
        r0.a(r1, r2, r3, r4, r5, r6);
        goto L_0x0033;
    L_0x01aa:
        r0 = new com.tencent.mm.sdk.platformtools.ac;
        r1 = android.os.Looper.getMainLooper();
        r0.<init>(r1);
        r1 = new com.tencent.mm.plugin.sns.ui.ay$2;
        r1.<init>(r10);
        r0.post(r1);
        r0 = "key_select_video_list";
        r0 = r13.getStringArrayListExtra(r0);
        if (r0 == 0) goto L_0x01ca;
    L_0x01c4:
        r1 = r0.size();
        if (r1 > 0) goto L_0x01d7;
    L_0x01ca:
        r1 = "K_SEGMENTVIDEOPATH";
        r1 = r13.getStringExtra(r1);
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 != 0) goto L_0x0313;
    L_0x01d7:
        if (r0 == 0) goto L_0x0233;
    L_0x01d9:
        r1 = r0.size();
        if (r1 <= 0) goto L_0x0233;
    L_0x01df:
        r1 = 0;
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
    L_0x01e6:
        r1 = "KSEGMENTVIDEOTHUMBPATH";
        r1 = r13.getStringExtra(r1);
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r2 != 0) goto L_0x01f9;
    L_0x01f3:
        r2 = com.tencent.mm.modelsfs.FileOp.aR(r1);
        if (r2 != 0) goto L_0x028a;
    L_0x01f9:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.tencent.mm.plugin.sns.e.ad.xi();
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.g.aX(r0);
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3 = new android.media.MediaMetadataRetriever;
        r3.<init>();
        r3.setDataSource(r0);	 Catch:{ Exception -> 0x02f3 }
        r4 = 0;
        r2 = r3.getFrameAtTime(r4);	 Catch:{ Exception -> 0x02f3 }
        if (r2 != 0) goto L_0x023b;
    L_0x0222:
        r2 = "MicroMsg.SnsActivity";
        r4 = "get bitmap error";
        com.tencent.mm.sdk.platformtools.v.e(r2, r4);	 Catch:{ Exception -> 0x02f3 }
        r3.release();	 Catch:{ Exception -> 0x0230 }
        goto L_0x0033;
    L_0x0230:
        r0 = move-exception;
        goto L_0x0033;
    L_0x0233:
        r0 = "K_SEGMENTVIDEOPATH";
        r0 = r13.getStringExtra(r0);
        goto L_0x01e6;
    L_0x023b:
        r4 = "MicroMsg.SnsActivity";
        r5 = "getBitmap1 %d %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x02f3 }
        r7 = 0;
        r8 = r2.getWidth();	 Catch:{ Exception -> 0x02f3 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x02f3 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02f3 }
        r7 = 1;
        r8 = r2.getHeight();	 Catch:{ Exception -> 0x02f3 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x02f3 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02f3 }
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);	 Catch:{ Exception -> 0x02f3 }
        r4 = 80;
        r5 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x02f3 }
        r6 = 1;
        com.tencent.mm.sdk.platformtools.d.a(r2, r4, r5, r1, r6);	 Catch:{ Exception -> 0x02f3 }
        r2 = com.tencent.mm.sdk.platformtools.d.JS(r1);	 Catch:{ Exception -> 0x02f3 }
        r4 = "MicroMsg.SnsActivity";
        r5 = "getBitmap2 %d %d";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x02f3 }
        r7 = 0;
        r8 = r2.outWidth;	 Catch:{ Exception -> 0x02f3 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x02f3 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02f3 }
        r7 = 1;
        r2 = r2.outHeight;	 Catch:{ Exception -> 0x02f3 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x02f3 }
        r6[r7] = r2;	 Catch:{ Exception -> 0x02f3 }
        com.tencent.mm.sdk.platformtools.v.i(r4, r5, r6);	 Catch:{ Exception -> 0x02f3 }
        r3.release();	 Catch:{ Exception -> 0x04e7 }
    L_0x028a:
        r2 = "MicroMsg.SnsActivity";
        r3 = "video path %s thumb path %s and %s %s ";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r0;
        r5 = 1;
        r4[r5] = r1;
        r5 = 2;
        r6 = com.tencent.mm.modelsfs.FileOp.jP(r0);
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 3;
        r6 = com.tencent.mm.modelsfs.FileOp.jP(r1);
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "KSightPath";
        r2.putExtra(r3, r0);
        r3 = "KSightThumbPath";
        r2.putExtra(r3, r1);
        r1 = "sight_md5";
        r0 = com.tencent.mm.a.g.aX(r0);
        r2.putExtra(r1, r0);
        r0 = "KSnsPostManu";
        r1 = 1;
        r2.putExtra(r0, r1);
        r0 = "KTouchCameraTime";
        r4 = com.tencent.mm.sdk.platformtools.be.Nh();
        r2.putExtra(r0, r4);
        r0 = "Ksnsupload_type";
        r1 = 14;
        r2.putExtra(r0, r1);
        r0 = r10.pP;
        r1 = "sns";
        r3 = ".ui.SnsUploadUI";
        com.tencent.mm.ay.c.b(r0, r1, r3, r2);
        goto L_0x0033;
    L_0x02f3:
        r2 = move-exception;
        r4 = "MicroMsg.SnsActivity";
        r5 = "savebitmap error %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x030e }
        r7 = 0;
        r2 = r2.getMessage();	 Catch:{ all -> 0x030e }
        r6[r7] = r2;	 Catch:{ all -> 0x030e }
        com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);	 Catch:{ all -> 0x030e }
        r3.release();	 Catch:{ Exception -> 0x030b }
        goto L_0x028a;
    L_0x030b:
        r2 = move-exception;
        goto L_0x028a;
    L_0x030e:
        r0 = move-exception;
        r3.release();	 Catch:{ Exception -> 0x04ea }
    L_0x0312:
        throw r0;
    L_0x0313:
        r0 = "CropImage_OutputPath_List";
        r1 = r13.getStringArrayListExtra(r0);
        if (r1 == 0) goto L_0x0322;
    L_0x031c:
        r0 = r1.size();
        if (r0 != 0) goto L_0x032d;
    L_0x0322:
        r0 = "MicroMsg.SnsActivity";
        r1 = "no image selected";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x0033;
    L_0x032d:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = r1.iterator();
    L_0x0336:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x036f;
    L_0x033c:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        r4 = com.tencent.mm.compatible.util.Exif.fromFile(r0);
        r4 = r4.getLocation();
        if (r4 == 0) goto L_0x0336;
    L_0x034c:
        r5 = "%s\n%f\n%f";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r0;
        r0 = 1;
        r8 = r4.latitude;
        r7 = java.lang.Double.valueOf(r8);
        r6[r0] = r7;
        r0 = 2;
        r8 = r4.longitude;
        r4 = java.lang.Double.valueOf(r8);
        r6[r0] = r4;
        r0 = java.lang.String.format(r5, r6);
        r2.add(r0);
        goto L_0x0336;
    L_0x036f:
        r0 = "isTakePhoto";
        r3 = 0;
        r0 = r13.getBooleanExtra(r0, r3);
        r10.jXI = r0;
        r0 = new android.content.Intent;
        r3 = r10.pP;
        r4 = com.tencent.mm.plugin.sns.ui.SnsUploadUI.class;
        r0.<init>(r3, r4);
        r3 = "KSnsPostManu";
        r4 = 1;
        r0.putExtra(r3, r4);
        r3 = "KTouchCameraTime";
        r4 = com.tencent.mm.sdk.platformtools.be.Nh();
        r0.putExtra(r3, r4);
        r3 = r10.jXM;
        if (r3 == 0) goto L_0x03a2;
    L_0x0397:
        r3 = r10.jXM;
        r4 = "intent_key_StatisticsOplog";
        r3.b(r0, r4);
        r3 = 0;
        r10.jXM = r3;
    L_0x03a2:
        r3 = r10.jGc;
        if (r3 == 0) goto L_0x03ae;
    L_0x03a6:
        r3 = "Ksnsupload_source";
        r4 = 11;
        r0.putExtra(r3, r4);
    L_0x03ae:
        r3 = "CropImage_filterId";
        r4 = 0;
        r3 = r13.getIntExtra(r3, r4);
        r4 = "sns_kemdia_path_list";
        r0.putExtra(r4, r1);
        r1 = "KFilterId";
        r0.putExtra(r1, r3);
        r1 = r10.jXI;
        if (r1 == 0) goto L_0x03cd;
    L_0x03c6:
        r1 = "Kis_take_photo";
        r3 = 1;
        r0.putExtra(r1, r3);
    L_0x03cd:
        r1 = "sns_media_latlong_list";
        r0.putStringArrayListExtra(r1, r2);
        r1 = "MicroMsg.SnsActivity";
        r2 = "shared type %d";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "Ksnsupload_type";
        r6 = -1;
        r5 = r0.getIntExtra(r5, r6);
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.v.d(r1, r2, r3);
        r1 = r10.pP;
        r2 = 6;
        r1.startActivityForResult(r0, r2);
        goto L_0x0033;
    L_0x03f6:
        if (r13 == 0) goto L_0x0033;
    L_0x03f8:
        r0 = "CropImage_OutputPath";
        r0 = r13.getStringExtra(r0);
        r10.filePath = r0;
        r10.H(r13);
        goto L_0x0033;
    L_0x0406:
        r0 = "MicroMsg.SnsActivity";
        r1 = "onActivityResult CONTEXT_UPLOAD_MEDIA";
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        if (r13 == 0) goto L_0x0033;
    L_0x0411:
        r0 = "sns_local_id";
        r1 = -1;
        r0 = r13.getIntExtra(r0, r1);
        r1 = r10.jXK;
        r2 = 0;
        r3 = 0;
        r1.a(r0, r2, r3);
        r0 = com.tencent.mm.plugin.sns.e.ad.aSA();
        r0.aTe();
        goto L_0x0033;
    L_0x0429:
        r0 = "MicroMsg.SnsActivity";
        r1 = "onActivityResult CONTEXT_CHANGE_BG";
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        r0 = r10.jrk;
        r0.aWP();
        r0 = com.tencent.mm.plugin.sns.e.ad.aSA();
        r0.aTe();
        goto L_0x0033;
    L_0x0440:
        if (r13 == 0) goto L_0x0033;
    L_0x0442:
        r0 = "MicroMsg.SnsActivity";
        r1 = "onActivityResult CONTEXT_GALLERY_OP";
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        r0 = "sns_cmd_list";
        r0 = r13.getParcelableExtra(r0);
        r0 = (com.tencent.mm.plugin.sns.data.SnsCmdList) r0;
        if (r0 == 0) goto L_0x0033;
    L_0x0456:
        r1 = r10.jXK;
        r2 = -1;
        r3 = r0.jdK;
        r0 = r0.jdL;
        r1.a(r2, r3, r0);
        goto L_0x0033;
    L_0x0462:
        r0 = com.tencent.mm.plugin.sns.e.ad.aSA();
        r0.aTe();
        r0 = r10.gMx;
        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(r0);
        goto L_0x0033;
    L_0x0470:
        if (r13 == 0) goto L_0x0033;
    L_0x0472:
        r0 = -1;
        if (r12 != r0) goto L_0x0033;
    L_0x0475:
        r1 = r13.getData();
        r0 = r10.pP;
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0 = r0.managedQuery(r1, r2, r3, r4, r5);
        r1 = r0.moveToFirst();
        if (r1 == 0) goto L_0x0033;
    L_0x0489:
        r1 = "_id";
        r1 = r0.getColumnIndexOrThrow(r1);
        r0 = r0.getString(r1);
        r1 = new android.content.Intent;
        r2 = "android.intent.action.EDIT";
        r3 = new java.lang.StringBuilder;
        r4 = "content://com.android.contacts/contacts/";
        r3.<init>(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r0 = android.net.Uri.parse(r0);
        r1.<init>(r2, r0);
        r0 = r10.pP;
        r0.startActivity(r1);
        goto L_0x0033;
    L_0x04b7:
        r0 = "sns_gallery_op_id";
        r1 = -1;
        r0 = r13.getIntExtra(r0, r1);
        if (r0 <= 0) goto L_0x0033;
    L_0x04c1:
        r1 = "MicroMsg.SnsActivity";
        r2 = "notify cause by del item";
        com.tencent.mm.sdk.platformtools.v.d(r1, r2);
        r1 = new com.tencent.mm.plugin.sns.data.SnsCmdList;
        r1.<init>();
        r1.pQ(r0);
        r0 = r10.jXK;
        r2 = -1;
        r3 = r1.jdK;
        r1 = r1.jdL;
        r0.a(r2, r3, r1);
        goto L_0x0033;
    L_0x04de:
        r0 = com.tencent.mm.plugin.sns.e.ad.aSH();
        r0.aaf();
        goto L_0x0033;
    L_0x04e7:
        r2 = move-exception;
        goto L_0x028a;
    L_0x04ea:
        r1 = move-exception;
        goto L_0x0312;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.ay.onActivityResult(int, int, android.content.Intent):void");
    }

    private void H(Intent intent) {
        new ac(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ ay jXN;

            {
                this.jXN = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.sns.b.a.drq.oy();
            }
        });
        v.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
        v.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
        if (this.filePath != null) {
            int intExtra;
            String str = "pre_temp_sns_pic" + com.tencent.mm.a.g.m((this.filePath + System.currentTimeMillis()).getBytes());
            com.tencent.mm.plugin.sns.storage.p.Q(ad.xi(), this.filePath, str);
            this.filePath = ad.xi() + str;
            v.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
            if (intent != null) {
                intExtra = intent.getIntExtra("CropImage_filterId", 0);
            } else {
                intExtra = 0;
            }
            Intent intent2 = new Intent(this.pP, SnsUploadUI.class);
            intent2.putExtra("KSnsPostManu", true);
            intent2.putExtra("KTouchCameraTime", be.Nh());
            if (this.jXM != null) {
                this.jXM.b(intent2, "intent_key_StatisticsOplog");
                this.jXM = null;
            }
            intent2.putExtra("sns_kemdia_path", this.filePath);
            intent2.putExtra("KFilterId", intExtra);
            if (this.jXI) {
                intent2.putExtra("Kis_take_photo", true);
            }
            if (this.jGc) {
                intent2.putExtra("Ksnsupload_source", 11);
            }
            this.pP.startActivityForResult(intent2, 6);
            this.jXI = false;
        }
    }

    protected final boolean rj(final int i) {
        int i2 = 3;
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            v.d("MicroMsg.SnsActivity", "selectPhoto " + i);
            if (i == 2) {
                Intent intent = new Intent();
                intent.putExtra("username", this.jUP);
                intent.setClass(this.pP, SettingSnsBackgroundUI.class);
                this.pP.startActivityForResult(intent, 7);
                return true;
            } else if (i != 1) {
                return true;
            } else {
                ak.yW();
                int a = be.a((Integer) com.tencent.mm.model.c.vf().get(68385, null), 0);
                ak.yW();
                int a2 = be.a((Integer) com.tencent.mm.model.c.vf().get(68386, null), 0);
                if (!this.jXG && a < 3 && a2 == 0) {
                    this.jXG = true;
                    Context context = this.pP;
                    OnClickListener anonymousClass4 = new OnClickListener(this) {
                        final /* synthetic */ ay jXN;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ak.yW();
                            int a = be.a((Integer) com.tencent.mm.model.c.vf().get(68386, null), 0) + 1;
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(68386, Integer.valueOf(a));
                            this.jXN.rj(i);
                        }
                    };
                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
                    aVar.wm(2131235580);
                    aVar.Oq(context.getString(2131235581) + "\n\n" + context.getString(2131235582));
                    aVar.wp(2131235579).a(anonymousClass4);
                    aVar.a(new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            ak.yW();
                            int a = be.a((Integer) com.tencent.mm.model.c.vf().get(68385, null), 0) + 1;
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(68385, Integer.valueOf(a));
                        }
                    });
                    aVar.RX().show();
                    return true;
                } else if (this.pP.getSharedPreferences(aa.bti(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
                    l.a(this.pP, 2, null);
                    return true;
                } else {
                    a2 = j.sU().getInt("SnsCanPickVideoFromAlbum", 1);
                    v.i("MicroMsg.SnsActivity", "takeVideo %d", new Object[]{Integer.valueOf(a2)});
                    if (q.drg) {
                        a2 = 0;
                    }
                    if (a2 != 1 && a2 == 0) {
                        i2 = 1;
                    }
                    l.a(this.pP, 14, 9, 4, i2, false, null);
                    return true;
                }
            }
        }
        s.ey(this.pP);
        return false;
    }

    public final void onDestroy() {
        if (this.jrk != null) {
            SnsHeader snsHeader = this.jrk;
            if (!(snsHeader.jOz == null || snsHeader.jOz.isRecycled())) {
                snsHeader.jOz.recycle();
            }
        }
        if (ak.uz()) {
            ad.aSB().M(this.pP);
            ad.aSz().b((b) this);
        }
        if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        if (ak.uz()) {
            ad.aSA().cbh.remove(this);
            at.jiE--;
        }
        this.jXE.setVisibility(8);
        y.aVR();
        ad.aSB().start();
    }

    public final void Aa(String str) {
    }

    public final void aj(String str, boolean z) {
    }

    public final void aRc() {
        this.jrk.aWP();
    }

    protected final void go(boolean z) {
        v.d("MicroMsg.SnsActivity", "snsactivty onIsAll ");
        this.jXE.go(z);
    }

    public final void J(int i, boolean z) {
        this.jXK.J(i, z);
    }

    public final void aTh() {
        if (this.jrk != null) {
            this.jrk.aWP();
        }
    }

    public final void ai(String str, boolean z) {
        if (this.jXK.getType() == 1 && this.gMx != null && this.gMx.getAdapter() != null && (this.gMx.getAdapter() instanceof au)) {
            ((au) this.gMx.getAdapter()).notifyDataSetChanged();
        }
    }

    public final ListView aXL() {
        return this.jXK.aXL();
    }
}
