package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.e.a.dc;
import com.tencent.mm.e.a.mp;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.g;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.protocal.c.ayh;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.widget.f;
import com.tencent.mm.v.k;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;

public class ExdeviceProfileUI extends MMActivity implements e, c {
    private static int fCW = 0;
    private boolean FM = false;
    private int cmH = 0;
    private String dFj;
    private String dRA;
    private p fAx = null;
    private String fCC;
    private a fCD;
    private ArrayList<String> fCE;
    private bjp fCF;
    private ExdeviceProfileAffectedUserView fCG;
    private ImageView fCH;
    private ListView fCI;
    private ExdeviceProfileListHeader fCJ;
    private a fCK;
    private View fCL;
    private volatile boolean fCM;
    private String fCN;
    private String fCO;
    private String fCP;
    private List<ayh> fCQ;
    private ArrayList<c> fCR;
    private List<qs> fCS;
    private b<i> fCT = new b<i>(this) {
        final /* synthetic */ ExdeviceProfileUI fDb;

        {
            this.fDb = r1;
        }

        public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
            final i iVar = (i) kVar;
            if (this.fDb.isFinishing() || this.fDb.FM) {
                this.fDb.akn();
                v.i("MicroMsg.ExdeviceProfileUI", "ExdeviceProfileUI has been destroyed.");
                return;
            }
            this.fDb.fCM = true;
            if (i == 0 && i2 == 0 && iVar != null) {
                this.fDb.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 fDd;

                    public final void run() {
                        if (this.fDd.fDb.fAx != null) {
                            this.fDd.fDb.fAx.dismiss();
                        }
                        this.fDd.fDb.fCE = iVar.fwm;
                        this.fDd.fDb.fCG.z(this.fDd.fDb.fCE);
                    }
                });
                this.fDb.fCF = iVar.fwl;
                this.fDb.fCO = iVar.fwh;
                this.fDb.fCP = iVar.fwi;
                this.fDb.fCQ = iVar.fwj;
                this.fDb.fCj = iVar.fwp;
                this.fDb.fCn = iVar.fwo;
                this.fDb.fCS = iVar.fwn;
                this.fDb.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 fDd;

                    {
                        this.fDd = r1;
                    }

                    public final void run() {
                        String xF = com.tencent.mm.model.k.xF();
                        if (!be.kS(this.fDd.fDb.fCO) && xF != null && xF.equals(this.fDd.fDb.dRA)) {
                            this.fDd.fDb.a(0, 2130838681, new OnMenuItemClickListener(this) {
                                final /* synthetic */ AnonymousClass2 fDe;

                                {
                                    this.fDe = r1;
                                }

                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    ExdeviceProfileUI.i(this.fDe.fDd.fDb);
                                    return true;
                                }
                            });
                        } else if (this.fDd.fDb.fCj) {
                            ExdeviceProfileUI.k(this.fDd.fDb);
                        }
                    }
                });
                if (!this.fDb.fCi) {
                    this.fDb.cQ(this.fDb.fCj);
                }
                this.fDb.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 fDd;

                    {
                        this.fDd = r1;
                    }

                    public final void run() {
                        ExdeviceStepChartView exdeviceStepChartView = (ExdeviceStepChartView) this.fDd.fDb.findViewById(2131756846);
                        if (be.bP(this.fDd.fDb.fCQ)) {
                            if (exdeviceStepChartView != null) {
                                exdeviceStepChartView.akB();
                            }
                        } else if (exdeviceStepChartView != null) {
                            List m = this.fDd.fDb.fCQ;
                            v.i("MicroMsg.exdevice.ExdeviceStepChartView", "aqr:refreshStep,steps.size():" + m.size());
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(exdeviceStepChartView.getResources().getString(2131232569));
                            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("d");
                            ArrayList arrayList = new ArrayList();
                            exdeviceStepChartView.fGg.clear();
                            if (m != null) {
                                int size = m.size();
                                if (size <= 7 && size > 0) {
                                    int i;
                                    Date date = new Date();
                                    Calendar instance = Calendar.getInstance();
                                    date.setTime(((long) ((ayh) m.get(0)).eWB) * 1000);
                                    instance.setTime(date);
                                    for (i = 0; i <= 6; i++) {
                                        if (i < size) {
                                            ayh com_tencent_mm_protocal_c_ayh = (ayh) m.get(i);
                                            date.setTime(((long) com_tencent_mm_protocal_c_ayh.eWB) * 1000);
                                            exdeviceStepChartView.fGg.add(simpleDateFormat2.format(date));
                                            arrayList.add(Integer.valueOf(com_tencent_mm_protocal_c_ayh.eWn));
                                        } else {
                                            instance.add(5, -1);
                                            exdeviceStepChartView.fGg.add(0, simpleDateFormat2.format(instance.getTime()));
                                            arrayList.add(0, Integer.valueOf(0));
                                        }
                                    }
                                    for (i = 0; i <= 6; i++) {
                                        exdeviceStepChartView.fFZ[i] = ((Integer) arrayList.get(i)).intValue();
                                    }
                                    exdeviceStepChartView.fGg.set(0, simpleDateFormat.format(instance.getTime()));
                                }
                                exdeviceStepChartView.invalidate();
                            }
                            this.fDd.fDb.fCK.notifyDataSetChanged();
                        }
                    }
                });
                this.fDb.akm();
                this.fDb.akn();
            }
        }
    };
    private b<h> fCU = new b<h>(this) {
        final /* synthetic */ ExdeviceProfileUI fDb;

        {
            this.fDb = r1;
        }

        public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.ExdeviceProfileUI", "on NetSceneDelFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                this.fDb.finish();
            }
        }
    };
    private b<g> fCV = new b<g>(this) {
        final /* synthetic */ ExdeviceProfileUI fDb;

        {
            this.fDb = r1;
        }

        public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.ExdeviceProfileUI", "on NetSceneAddFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                this.fDb.finish();
            }
        }
    };
    private Runnable fCX = new Runnable(this) {
        final /* synthetic */ ExdeviceProfileUI fDb;

        {
            this.fDb = r1;
        }

        public final void run() {
            BackwardSupportUtil.c.a(this.fDb.fCI);
            if (this.fDb.fCI.getCount() > 0) {
                BackwardSupportUtil.c.b(this.fDb.fCI, this.fDb.fCI.getCount() - 1);
            }
        }
    };
    private b<g> fCY = new b<g>(this) {
        final /* synthetic */ ExdeviceProfileUI fDb;

        {
            this.fDb = r1;
        }

        public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                this.fDb.akm();
                this.fDb.akn();
                this.fDb.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass15 fDh;

                    {
                        this.fDh = r1;
                    }

                    public final void run() {
                        if (this.fDh.fDb.fAx != null) {
                            this.fDh.fDb.fAx.dismiss();
                        }
                    }
                });
            }
        }
    };
    private List<String> fCZ;
    private boolean fCi;
    private boolean fCj;
    private int fCk;
    private List<ig> fCn;
    private b<com.tencent.mm.plugin.exdevice.f.a.k> fDa = new b<com.tencent.mm.plugin.exdevice.f.a.k>(this) {
        final /* synthetic */ ExdeviceProfileUI fDb;

        {
            this.fDb = r1;
        }

        public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.exdevice.f.a.k kVar2 = (com.tencent.mm.plugin.exdevice.f.a.k) kVar;
            if (i == 0 && i2 == 0) {
                this.fDb.fCZ = kVar2.fwE;
                this.fDb.fwC = kVar2.fwC;
                this.fDb.fwD = kVar2.fwD;
                this.fDb.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass17 fDi;

                    {
                        this.fDi = r1;
                    }

                    public final void run() {
                        if (this.fDi.fDb.fAx != null) {
                            this.fDi.fDb.fAx.dismiss();
                        }
                    }
                });
                ExdeviceProfileUI.A(this.fDb);
            }
        }
    };
    private List<String> fwC;
    private List<String> fwD;
    private TextPaint gl = new TextPaint(1);
    private Context mContext;

    static /* synthetic */ void A(ExdeviceProfileUI exdeviceProfileUI) {
        Intent intent = new Intent();
        String b = be.b(exdeviceProfileUI.fCZ, ",");
        intent.putExtra("wechat_sport_contact", be.b(exdeviceProfileUI.fwC, ","));
        intent.putExtra("wechat_sport_recent_like", b);
        b = be.b(exdeviceProfileUI.fwD, ",");
        intent.putExtra("titile", exdeviceProfileUI.getString(2131232492));
        intent.putExtra("list_type", 12);
        intent.putExtra("max_limit_num", 10);
        intent.putExtra("too_many_member_tip_string", exdeviceProfileUI.getString(2131232493, new Object[]{Integer.valueOf(10)}));
        intent.putExtra("list_attr", r.s(new int[]{2, 4, 1, 131072, 128, 64, 16384}));
        intent.putExtra("always_select_contact", b);
        com.tencent.mm.ay.c.a(exdeviceProfileUI, ".ui.contact.SelectContactUI", intent, 3);
    }

    static /* synthetic */ boolean a(ExdeviceProfileUI exdeviceProfileUI, String str, String str2, String str3) {
        if (be.kS(exdeviceProfileUI.fCO)) {
            v.w("MicroMsg.ExdeviceProfileUI", "doSendAppMsg failed, shareUrl is null or nil.");
            return false;
        }
        WXWebpageObject wXWebpageObject = new WXWebpageObject(exdeviceProfileUI.fCO);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        String er = l.er(str2);
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = er;
        wXMediaMessage.description = exdeviceProfileUI.fCP;
        wXMediaMessage.setThumbImage(com.tencent.mm.u.b.a(exdeviceProfileUI.dRA, false, -1));
        mp mpVar = new mp();
        mpVar.bnP.bhh = wXMediaMessage;
        mpVar.bnP.appId = null;
        mpVar.bnP.toUser = str;
        mpVar.bnP.bnQ = 2;
        if (be.kS(str2)) {
            mpVar.bnP.bnT = null;
        } else {
            mpVar.bnP.bnR = str2;
            mpVar.bnP.bnS = er;
        }
        boolean z = com.tencent.mm.sdk.c.a.nhr.z(mpVar);
        if (!be.kS(str3)) {
            mr mrVar = new mr();
            mrVar.boa.bob = str;
            mrVar.boa.content = str3;
            mrVar.boa.type = m.fp(str);
            mrVar.boa.flags = 0;
            com.tencent.mm.sdk.c.a.nhr.z(mrVar);
        }
        return z;
    }

    static /* synthetic */ void i(ExdeviceProfileUI exdeviceProfileUI) {
        f fVar = new f(exdeviceProfileUI.nDR.nEl, f.pbS, false);
        fVar.jXn = new n.c(exdeviceProfileUI) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.a(0, this.fDb.getString(2131232560), 2131165344);
                lVar.a(1, this.fDb.getString(2131232561), 2131165334);
            }
        };
        fVar.jXo = new d(exdeviceProfileUI) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (i) {
                    case 0:
                        ExdeviceProfileUI.s(this.fDb);
                        return;
                    case 1:
                        ExdeviceProfileUI.r(this.fDb);
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
    }

    static /* synthetic */ void k(ExdeviceProfileUI exdeviceProfileUI) {
        ak.yW();
        if (com.tencent.mm.model.c.wH().LT(exdeviceProfileUI.dRA)) {
            exdeviceProfileUI.a(0, 2130838681, new OnMenuItemClickListener(exdeviceProfileUI) {
                final /* synthetic */ ExdeviceProfileUI fDb;

                {
                    this.fDb = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    ExdeviceProfileUI.t(this.fDb);
                    return true;
                }
            });
        }
    }

    static /* synthetic */ void r(ExdeviceProfileUI exdeviceProfileUI) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", 200);
        intent.putExtra("Ksnsupload_height", 200);
        intent.putExtra("Ksnsupload_link", exdeviceProfileUI.fCO);
        intent.putExtra("Ksnsupload_title", exdeviceProfileUI.fCP);
        intent.putExtra("Ksnsupload_imgurl", com.tencent.mm.plugin.exdevice.model.f.sb(exdeviceProfileUI.dRA));
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        String fz = o.fz("wx_sport");
        o.yx().n(fz, true).l("prePublishId", "wx_sport");
        intent.putExtra("reportSessionId", fz);
        com.tencent.mm.ay.c.a(exdeviceProfileUI, "sns", ".ui.SnsUploadUI", intent, 2, false);
    }

    static /* synthetic */ void s(ExdeviceProfileUI exdeviceProfileUI) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 259);
        intent.putExtra("select_is_ret", true);
        com.tencent.mm.ay.c.a(exdeviceProfileUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void t(ExdeviceProfileUI exdeviceProfileUI) {
        f fVar = new f(exdeviceProfileUI.nDR.nEl, f.pbS, false);
        fVar.jXn = new n.c(exdeviceProfileUI) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.d(0, this.fDb.getString(2131232565));
            }
        };
        fVar.jXo = new d(exdeviceProfileUI) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (i) {
                    case 0:
                        ExdeviceProfileUI.u(this.fDb);
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
    }

    static /* synthetic */ void u(ExdeviceProfileUI exdeviceProfileUI) {
        v.i("MicroMsg.ExdeviceProfileUI", "ap: start to del: %s", new Object[]{exdeviceProfileUI.dRA});
        ak.vy().a(new h(exdeviceProfileUI.dRA, exdeviceProfileUI.fCU), 0);
    }

    static /* synthetic */ void x(ExdeviceProfileUI exdeviceProfileUI) {
        if (VERSION.SDK_INT >= 11) {
            View childAt = exdeviceProfileUI.fCI.getChildAt(0);
            int[] iArr = new int[2];
            if (childAt != null && exdeviceProfileUI.fCI.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (fCW == 0) {
                    fCW = iArr[1];
                }
                int i = iArr[1];
                if (i > (-fCW) / 2) {
                    exdeviceProfileUI.fCG.setAlpha(i > 0 ? ((float) (i * 2)) / (((float) fCW) * 2.0f) : ((float) i) / ((float) fCW));
                    exdeviceProfileUI.fCG.setVisibility(0);
                    return;
                }
                exdeviceProfileUI.fCG.setAlpha(0.0f);
                exdeviceProfileUI.fCG.setVisibility(8);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        CharSequence string;
        super.onCreate(bundle);
        this.mContext = this.nDR.nEl;
        Intent intent = getIntent();
        akm();
        this.dRA = intent.getStringExtra("username");
        this.fCC = intent.getStringExtra("usernickname");
        String xF = com.tencent.mm.model.k.xF();
        if (xF != null) {
            this.fCi = xF.equals(this.dRA);
        }
        this.dFj = getIntent().getStringExtra("app_username");
        this.fCj = ac.ajs().sk(this.dRA);
        v.d("MicroMsg.ExdeviceProfileUI", "is follow %s", new Object[]{Boolean.valueOf(this.fCj)});
        Assert.assertTrue(!be.kS(this.dRA));
        this.fCD = ac.aju().sm(this.dRA);
        this.fCE = getIntent().getStringArrayListExtra("key_affected_semi");
        getString(2131231164);
        this.fAx = com.tencent.mm.ui.base.g.a(this, getString(2131233521), new OnCancelListener(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.fDb.fAx != null) {
                    this.fDb.fAx.dismiss();
                    this.fDb.fAx = null;
                }
                this.fDb.finish();
            }
        });
        this.fCG = (ExdeviceProfileAffectedUserView) findViewById(2131756853);
        this.fCH = (ImageView) findViewById(2131756850);
        this.fCI = (ListView) findViewById(2131756852);
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(2131756535);
        this.fCG.z(this.fCE);
        akp();
        this.fCL = findViewById(2131756851);
        mMPullDownView.jp(false);
        mMPullDownView.jr(false);
        mMPullDownView.jq(false);
        mMPullDownView.jp(false);
        mMPullDownView.jo(false);
        mMPullDownView.nXo = true;
        mMPullDownView.nXf = new MMPullDownView.c(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final boolean agv() {
                View childAt = this.fDb.fCI.getChildAt(this.fDb.fCI.getChildCount() - 1);
                int count = this.fDb.fCI.getAdapter().getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > this.fDb.fCI.getHeight() || this.fDb.fCI.getLastVisiblePosition() < count - 1) {
                    return false;
                }
                return true;
            }
        };
        mMPullDownView.nXg = new MMPullDownView.d(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final boolean agu() {
                if (this.fDb.fCI.getFirstVisiblePosition() == 0) {
                    View childAt = this.fDb.fCI.getChildAt(this.fDb.fCI.getFirstVisiblePosition());
                    if (childAt != null && childAt.getTop() >= 0) {
                        return true;
                    }
                }
                return false;
            }
        };
        mMPullDownView.nWU = new MMPullDownView.e(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final boolean agi() {
                return true;
            }
        };
        mMPullDownView.nXz = new MMPullDownView.b(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void aks() {
                ExdeviceProfileUI.x(this.fDb);
            }
        };
        ExdeviceProfileListHeader exdeviceProfileListHeader = new ExdeviceProfileListHeader(this);
        int u = com.tencent.mm.plugin.exdevice.j.b.u(this, getResources().getDimensionPixelSize(2131493038));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(2131493014) : getResources().getDimensionPixelSize(2131493015);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131493047);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(2131493046);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        dimensionPixelSize2 = ((((defaultDisplay.getHeight() / 2) - u) - dimensionPixelSize) - (dimensionPixelSize2 / 2)) - dimensionPixelSize3;
        if (defaultDisplay.getHeight() <= 0 || dimensionPixelSize2 <= 0) {
            dimensionPixelSize2 = getResources().getDimensionPixelSize(2131493032);
        }
        exdeviceProfileListHeader.setMinimumHeight(dimensionPixelSize2);
        exdeviceProfileListHeader.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceProfileListHeader.setTag(Integer.valueOf(((defaultDisplay.getHeight() / 2) - u) - dimensionPixelSize));
        this.fCJ = exdeviceProfileListHeader;
        this.fCI.addHeaderView(this.fCJ, null, false);
        this.fCK = new a(this.nDR.nEl, this.dFj, this.fCi, this.dRA);
        this.fCK.fCh = this;
        this.fCI.setAdapter(this.fCK);
        this.fCI.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                ExdeviceProfileUI.x(this.fDb);
            }
        });
        this.fCG.dRA = this.dRA;
        this.fCL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.exdevice.f.a.e.b(this.fDb);
            }
        });
        mMPullDownView.nXo = false;
        this.fCH.setLayoutParams(new LayoutParams(com.tencent.mm.bd.a.dv(this), ((Integer) this.fCJ.getTag()).intValue()));
        ako();
        ac.ajz().a(this);
        ak.vy().a(new i(this.dRA, be.ma(this.dFj), this.fCT), 0);
        try {
            this.cmH = getResources().getDimensionPixelSize(2131493055);
            if (this.cmH <= 0) {
                this.cmH = 60;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.ExdeviceProfileUI", e, "", new Object[0]);
            if (this.cmH <= 0) {
                this.cmH = 60;
            }
        } catch (Throwable th) {
            if (this.cmH <= 0) {
                this.cmH = 60;
            }
        }
        v.d("MicroMsg.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[]{Integer.valueOf(this.cmH)});
        if (this.fCi) {
            string = getString(2131232567);
        } else {
            Object[] objArr = new Object[1];
            xF = this.dRA;
            int i = this.cmH;
            CharSequence er = l.er(xF);
            string = (!xF.equalsIgnoreCase(er) || be.kS(this.fCC)) ? com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, er) : com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, this.fCC);
            v.d("MicroMsg.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[]{Integer.valueOf(i), string, TextUtils.ellipsize(string, this.gl, (float) i, TruncateAt.END)});
            objArr[0] = er;
            string = com.tencent.mm.pluginsdk.ui.d.e.a(this, getString(2131232571, objArr));
        }
        H(string);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fDb.finish();
                return false;
            }
        });
        v.i("MicroMsg.ExdeviceProfileUI", "mUsername:" + this.dRA);
        if (com.tencent.mm.model.k.xF().equals(this.dRA)) {
            dc dcVar = new dc();
            dcVar.bbb.op = 3;
            dcVar.bbb.userName = "gh_43f2581f6fd6";
            dcVar.bbb.context = this.nDR.nEl;
            com.tencent.mm.sdk.c.a.nhr.z(dcVar);
        }
    }

    private void akm() {
        this.fCR = ac.ajs().ajE();
        if (this.fCR != null) {
            v.d("MicroMsg.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[]{Integer.valueOf(this.fCR.size()), this.fCR.toString()});
        } else {
            v.d("MicroMsg.ExdeviceProfileUI", "ap: follow is null");
        }
        if (be.bP(this.fCR)) {
            this.fCk = 0;
        } else {
            this.fCk = this.fCR.size();
        }
    }

    private void akn() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void run() {
                a n = this.fDb.fCK;
                Object p = this.fDb.fCR;
                List q = this.fDb.fCn;
                n.fCj = ac.ajs().sk(n.dRA);
                n.fCm = p;
                if (be.bP(p)) {
                    n.fCk = 0;
                } else {
                    n.fCk = p.size();
                }
                n.fCn = q;
                if (!be.bP(q)) {
                    n.fCl = q.size();
                }
                v.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[]{Boolean.valueOf(n.fCj), Integer.valueOf(n.fCk), Integer.valueOf(n.fCl), n.dRA});
                this.fDb.fCK.notifyDataSetChanged();
            }
        });
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        v.v("MicroMsg.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
        akm();
        akn();
        if (!this.fCi) {
            cQ(ac.ajs().sk(this.dRA));
        }
    }

    private void cQ(final boolean z) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            public final void run() {
                if (z) {
                    ExdeviceProfileUI.k(this.fDb);
                } else {
                    this.fDb.nDR.bAi();
                }
                this.fDb.fCK.notifyDataSetChanged();
            }
        });
    }

    protected void onDestroy() {
        this.FM = true;
        super.onDestroy();
        ac.ajz().b(this);
    }

    private void ako() {
        String xF = com.tencent.mm.model.k.xF();
        if (this.fCL != null) {
            this.fCL.setVisibility(8);
        }
        if (!be.kS(xF) && xF.equals(this.dRA)) {
            if (!(this.fCD == null || !be.kS(this.fCD.field_championUrl) || this.fCL == null)) {
                this.fCL.setVisibility(0);
            }
            if (this.fCJ != null) {
                this.fCJ.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ExdeviceProfileUI fDb;

                    {
                        this.fDb = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.exdevice.f.a.e.b(this.fDb);
                    }
                });
            }
        }
    }

    private void akp() {
        if (this.fCD == null) {
            this.fCH.setImageResource(2131689643);
            this.fCN = null;
        } else if (this.fCN == this.fCD.field_championUrl) {
        } else {
            if (this.fCN == null || !this.fCN.equals(this.fCD.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.fCH, this.fCD.field_championUrl);
                this.fCN = this.fCD.field_championUrl;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.dFj)) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        if (stringExtra == null || stringExtra.length() == 0) {
                            v.e("MicroMsg.ExdeviceProfileUI", "select conversation failed, toUser is null.");
                            return;
                        }
                        final String aja = com.tencent.mm.plugin.exdevice.model.f.aja();
                        com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, l.er(aja), com.tencent.mm.plugin.exdevice.model.f.sb(this.dRA), this.fCP, true, getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                            final /* synthetic */ ExdeviceProfileUI fDb;

                            public final void a(boolean z, String str, int i) {
                                if (z) {
                                    ExdeviceProfileUI.a(this.fDb, stringExtra, aja, str);
                                    com.tencent.mm.ui.base.g.bf(this.fDb.nDR.nEl, this.fDb.getResources().getString(2131231155));
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 2:
                    if (i2 == -1) {
                        Toast.makeText(this, 2131235295, 1).show();
                        return;
                    }
                    return;
                case 3:
                    if (i2 == -1) {
                        List g = be.g(intent.getStringExtra("Select_Contact").split(","));
                        if (g != null) {
                            if (this.fAx != null) {
                                this.fAx.show();
                            }
                            ak.vy().a(new g(g, this.fCY), 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903564;
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        if ("HardDeviceChampionInfo".equals(str) && this.dRA.equals(dVar.username)) {
            v.d("MicroMsg.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
            this.fCD = ac.aju().sm(this.dRA);
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceProfileUI fDb;

                {
                    this.fDb = r1;
                }

                public final void run() {
                    this.fDb.ako();
                    this.fDb.fCK.notifyDataSetChanged();
                    this.fDb.akp();
                }
            });
        }
    }

    public final void akq() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceProfileUI fDb;

            {
                this.fDb = r1;
            }

            public final void run() {
                if (this.fDb.fAx != null) {
                    this.fDb.fAx.show();
                }
            }
        });
        ak.vy().a(new com.tencent.mm.plugin.exdevice.f.a.k(this.fDa), 0);
    }

    public final void akr() {
        List arrayList = new ArrayList();
        arrayList.add(this.dRA);
        ak.vy().a(new g(arrayList, this.fCV), 0);
    }
}
