package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
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
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI extends MMActivity implements e, f, d {
    private static int fCW = 128;
    private boolean FM;
    private String dRA;
    private p fAx = null;
    private ImageView fCH;
    private View fCL;
    private String fCN;
    private String fCO;
    private String fCP;
    private ListView fDL;
    private b fDM;
    private View fDN;
    private ExdeviceRankListHeaderView fDO;
    private ExdeviceRankChampionInfoView fDP;
    private View fDQ;
    private String fDR;
    private String fDS;
    private String fDT;
    private String fDU;
    private a fDV;
    private String fDW;
    private int fDX;
    private List<e> fDY;
    private ArrayList<c> fDZ;
    private Map<String, String> fDk = new HashMap();
    private ArrayList<d> fEa;
    private boolean fEb;
    private boolean fEc;
    private boolean fEd;
    private String fEe;
    private boolean fEf;
    private b<j> fEg = new b<j>(this) {
        final /* synthetic */ ExdeviceRankInfoUI fEh;

        {
            this.fEh = r1;
        }

        public final /* synthetic */ void c(int i, int i2, String str, k kVar) {
            j jVar = (j) kVar;
            v.i("MicroMsg.exdevice.ExdeviceRankInfoUI", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (this.fEh.isFinishing() || this.fEh.FM) {
                v.i("MicroMsg.exdevice.ExdeviceRankInfoUI", "ExdeviceRankInfoUI has been destroyed.");
                return;
            }
            this.fEh.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass11 fEi;

                {
                    this.fEi = r1;
                }

                public final void run() {
                    if (this.fEi.fEh.fAx != null && this.fEi.fEh.fAx.isShowing()) {
                        this.fEi.fEh.fAx.dismiss();
                        this.fEi.fEh.fAx = null;
                        v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "dismiss tips dialog.");
                    }
                }
            });
            if (i == 0 && i2 == 0) {
                this.fEh.akt();
                this.fEh.fCO = jVar.fwh;
                this.fEh.fCP = jVar.fwi;
                this.fEh.fEd = jVar.fwA;
                this.fEh.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass11 fEi;

                    {
                        this.fEi = r1;
                    }

                    public final void run() {
                        this.fEi.fEh.aku();
                        if (!be.kS(this.fEi.fEh.fCO)) {
                            this.fEi.fEh.a(0, 2130838681, new OnMenuItemClickListener(this) {
                                final /* synthetic */ AnonymousClass3 fEj;

                                {
                                    this.fEj = r1;
                                }

                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    ExdeviceRankInfoUI.j(this.fEj.fEi.fEh);
                                    return true;
                                }
                            });
                        }
                        if (this.fEi.fEh.fDP != null) {
                            this.fEi.fEh.fDP.sA(this.fEi.fEh.fDW);
                        }
                    }
                });
            } else if (this.fEh.fDY == null || this.fEh.fDY.size() == 0) {
                this.fEh.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass11 fEi;

                    {
                        this.fEi = r1;
                    }

                    public final void run() {
                        Toast.makeText(this.fEi.fEh, 2131232558, 1).show();
                        this.fEi.fEh.finish();
                    }
                });
            }
        }
    };

    static /* synthetic */ boolean a(ExdeviceRankInfoUI exdeviceRankInfoUI, String str, String str2, String str3) {
        if (be.kS(exdeviceRankInfoUI.fCO)) {
            v.w("MicroMsg.exdevice.ExdeviceRankInfoUI", "doSendAppMsg failed, shareUrl is null or nil.");
            return false;
        }
        WXWebpageObject wXWebpageObject = new WXWebpageObject(exdeviceRankInfoUI.fCO);
        String er = l.er(str2);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = er;
        wXMediaMessage.description = exdeviceRankInfoUI.fCP;
        wXMediaMessage.setThumbImage(com.tencent.mm.u.b.a(exdeviceRankInfoUI.dRA, false, -1));
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

    static /* synthetic */ void c(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        if (exdeviceRankInfoUI.fEa == null || exdeviceRankInfoUI.fEa.size() < 20) {
            exdeviceRankInfoUI.fDQ.setVisibility(0);
        } else {
            exdeviceRankInfoUI.fDQ.setVisibility(8);
        }
    }

    static /* synthetic */ void j(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(exdeviceRankInfoUI.nDR.nEl, com.tencent.mm.ui.widget.f.pbS, false);
        fVar.jXn = new n.c(exdeviceRankInfoUI) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.a(0, this.fEh.getString(2131232560), 2131165344);
                lVar.a(1, this.fEh.getString(2131232561), 2131165334);
                lVar.a(2, this.fEh.getString(2131232559), 2131165322);
            }
        };
        fVar.jXo = new n.d(exdeviceRankInfoUI) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (i) {
                    case 0:
                        ExdeviceRankInfoUI.n(this.fEh);
                        return;
                    case 1:
                        ExdeviceRankInfoUI.m(this.fEh);
                        return;
                    case 2:
                        ExdeviceRankInfoUI.o(this.fEh);
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
    }

    static /* synthetic */ void m(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", 200);
        intent.putExtra("Ksnsupload_height", 200);
        intent.putExtra("Ksnsupload_link", exdeviceRankInfoUI.fCO);
        intent.putExtra("Ksnsupload_title", exdeviceRankInfoUI.fCP);
        intent.putExtra("Ksnsupload_imgurl", com.tencent.mm.plugin.exdevice.model.f.sb(exdeviceRankInfoUI.dRA));
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        String fz = o.fz("wx_sport");
        o.yx().n(fz, true).l("prePublishId", "wx_sport");
        intent.putExtra("reportSessionId", fz);
        com.tencent.mm.ay.c.a(exdeviceRankInfoUI, "sns", ".ui.SnsUploadUI", intent, 2, false);
    }

    static /* synthetic */ void n(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 259);
        intent.putExtra("select_is_ret", true);
        com.tencent.mm.ay.c.a(exdeviceRankInfoUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void o(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://ssl.gongyi.qq.com/yxj_health/index.html");
        com.tencent.mm.ay.c.b(exdeviceRankInfoUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    private void akt() {
        ac.ajy();
        this.fEa = com.tencent.mm.plugin.exdevice.f.b.c.si(this.fDU);
        this.fDZ = ac.ajs().ajE();
        this.fDY = this.fDM.c(this.fDZ, this.fEa);
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final void run() {
                this.fEh.fDM.fDj = this.fEh.fDY;
                this.fEh.fDM.notifyDataSetChanged();
                ExdeviceRankInfoUI.c(this.fEh);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.FM = false;
        this.dRA = com.tencent.mm.model.k.xF();
        Intent intent = getIntent();
        this.fDR = intent.getStringExtra("key_rank_info");
        this.fDS = intent.getStringExtra("key_rank_semi");
        this.fDT = intent.getStringExtra("app_username");
        this.fDU = intent.getStringExtra("rank_id");
        this.fEb = intent.getBooleanExtra("key_is_latest", false);
        this.fDW = intent.getStringExtra("key_champioin_username");
        this.fDX = intent.getIntExtra("device_type", 0);
        this.fEe = intent.getStringExtra("locate_to_username");
        this.fEc = intent.getBooleanExtra("key_only_show_latest_rank", false);
        if (be.kS(this.fDU) || "#".equals(this.fDU)) {
            if (!this.fEc) {
                d dVar;
                com.tencent.mm.plugin.exdevice.f.b.b.d ajr = ac.ajr();
                Cursor rawQuery = ajr.cie.rawQuery(String.format("select * from %s order by %s desc limit 1", new Object[]{"HardDeviceRankInfo", "rankID"}), null);
                if (rawQuery == null) {
                    v.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    dVar = null;
                } else if (rawQuery.getCount() == 0) {
                    v.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    rawQuery.close();
                    dVar = null;
                } else {
                    dVar = new d();
                    rawQuery.moveToFirst();
                    dVar.b(rawQuery);
                    rawQuery.close();
                }
                if (dVar != null) {
                    this.fDU = dVar.field_rankID;
                    this.fDT = dVar.field_appusername;
                }
            }
            this.fDW = null;
            this.fEb = true;
        }
        ac.ajy();
        this.fEa = com.tencent.mm.plugin.exdevice.f.b.c.si(this.fDU);
        if (!this.fEc) {
            if (this.fEa == null || this.fEa.size() <= 0) {
                this.fDZ = new ArrayList();
                this.fEa = com.tencent.mm.plugin.exdevice.f.a.a.a(this.fDU, this.fDT, this.fDR, this.fDS, this.fDk, this.fDZ);
                ac.ajy();
                com.tencent.mm.plugin.exdevice.f.b.c.a(this.fDU, this.fEa);
            } else {
                com.tencent.mm.plugin.exdevice.f.a.a.a(this.fDR, this.fDS, this.fDk);
            }
            this.fDZ = ac.ajs().ajE();
        }
        this.fDM = new b(this, this.fDT);
        this.fDM.fDk = this.fDk;
        this.fDY = this.fDM.c(this.fDZ, this.fEa);
        this.fDM.fDj = this.fDY;
        if (be.kS(this.fDW)) {
            akv();
        }
        this.fDV = ac.aju().sm(this.fDW);
        if (this.fDV == null && !be.kS(this.fDW)) {
            this.fDV = new a();
            this.fDV.field_username = this.fDW;
            this.fDV.field_championMotto = getIntent().getStringExtra("key_champion_info");
            this.fDV.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
            ac.ajy();
            ac.aju().a(this.fDV, true);
        }
        NI();
        if (this.fEa != null && this.fEa.size() > 0) {
            this.fDP.sA(((d) this.fEa.get(0)).field_username);
        }
        ac.ajz().a(this);
        ac.ajy().fwI = this;
        ak.vy().a(new j(this.fDU, this.fDT, this.fDW, this.fEb, this.fEg), 0);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fEh.finish();
                return false;
            }
        });
        vD(2131232593);
        iU(true);
        aku();
        dc dcVar = new dc();
        dcVar.bbb.op = 3;
        dcVar.bbb.userName = "gh_43f2581f6fd6";
        dcVar.bbb.context = this.nDR.nEl;
        com.tencent.mm.sdk.c.a.nhr.z(dcVar);
    }

    private void aku() {
        v.i("MicroMsg.exdevice.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[]{this.fEe, this.dRA});
        if (!be.kS(this.fEe)) {
            int i;
            String str = this.fEe;
            v.i("MicroMsg.exdevice.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[]{str, this.dRA});
            if (be.kS(str)) {
                i = -1;
            } else if (this.fDY == null || this.fDY.size() == 0) {
                i = -2;
            } else {
                i = 0;
                while (i < this.fDY.size()) {
                    d dVar = ((e) this.fDY.get(i)).fGm;
                    int i2 = ((e) this.fDY.get(i)).fGn;
                    if (dVar != null && str.equalsIgnoreCase(dVar.field_username) && !str.equalsIgnoreCase(this.dRA) && (i2 & 2) != 2) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                        v.i("MicroMsg.exdevice.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(displayMetrics.heightPixels)});
                        this.fDL.setSelectionFromTop(i, i2 / 4);
                        this.fDM.fDl = str;
                        this.fDM.notifyDataSetInvalidated();
                        akx();
                        break;
                    }
                    i++;
                }
                this.fDM.fDl = null;
                i = -3;
            }
            if (i >= 0) {
                return;
            }
        }
        v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "locate to username is null or nil.");
    }

    private void ako() {
        if (this.fDV == null || this.dRA == null || !this.dRA.equals(this.fDV.field_username) || !be.kS(this.fDV.field_championUrl)) {
            if (this.fCL != null) {
                this.fCL.setVisibility(8);
            }
            if (this.fDO != null) {
                this.fDO.setOnClickListener(null);
                return;
            }
            return;
        }
        if (this.fCL != null) {
            this.fCL.setVisibility(0);
        }
        if (this.fDO != null) {
            this.fDO.fEl = new OnClickListener(this) {
                final /* synthetic */ ExdeviceRankInfoUI fEh;

                {
                    this.fEh = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.plugin.exdevice.f.a.e.b(this.fEh);
                }
            };
        }
    }

    private void akv() {
        String akw = akw();
        if (!be.kS(akw)) {
            this.fDW = akw;
        }
    }

    private String akw() {
        if (this.fDY != null) {
            for (e eVar : this.fDY) {
                d dVar = eVar.fGm;
                if (dVar != null && dVar.field_ranknum == 1) {
                    return dVar.field_username;
                }
            }
        }
        return null;
    }

    protected final void NI() {
        int dimensionPixelSize;
        int size;
        boolean z;
        this.fDN = findViewById(2131756862);
        ExdeviceRankListHeaderView exdeviceRankListHeaderView = new ExdeviceRankListHeaderView(this);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            i = com.tencent.mm.plugin.exdevice.j.b.u(this, getResources().getDimensionPixelSize(2131493038));
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(2131493014);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(2131493015);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        i = ((defaultDisplay.getHeight() / 2) - i) - dimensionPixelSize;
        if (defaultDisplay.getHeight() <= 0 || i <= 0) {
            i = getResources().getDimensionPixelSize(2131493032);
        }
        exdeviceRankListHeaderView.setMinimumHeight(i);
        exdeviceRankListHeaderView.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceRankListHeaderView.setTag(Integer.valueOf(i));
        this.fDO = exdeviceRankListHeaderView;
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(2131756860);
        this.fDL = (ListView) findViewById(2131756861);
        this.fDP = (ExdeviceRankChampionInfoView) findViewById(2131756863);
        this.fCL = findViewById(2131756851);
        this.fCL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final void onClick(View view) {
                v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "ap: start change cover");
                com.tencent.mm.plugin.exdevice.f.a.e.b(this.fEh);
            }
        });
        this.fDO.fEp = false;
        ako();
        mMPullDownView.jp(false);
        mMPullDownView.jr(false);
        mMPullDownView.jq(false);
        mMPullDownView.jp(false);
        mMPullDownView.jo(false);
        mMPullDownView.nXo = true;
        mMPullDownView.nXr = new MMPullDownView.a(this) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final boolean akz() {
                boolean z;
                ExdeviceRankInfoUI exdeviceRankInfoUI = this.fEh;
                if (this.fEh.fDY == null || this.fEh.fDY.size() == 0) {
                    z = false;
                } else {
                    z = true;
                }
                exdeviceRankInfoUI.fEf = z;
                return false;
            }
        };
        mMPullDownView.nXf = new MMPullDownView.c(this) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final boolean agv() {
                View childAt = this.fEh.fDL.getChildAt(this.fEh.fDL.getChildCount() - 1);
                int count = this.fEh.fDL.getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > this.fEh.fDL.getHeight() || this.fEh.fDL.getLastVisiblePosition() != count - 1) {
                    return false;
                }
                return true;
            }
        };
        mMPullDownView.nXz = new MMPullDownView.b(this) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final void aks() {
                this.fEh.akx();
            }
        };
        mMPullDownView.nXg = new MMPullDownView.d(this) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final boolean agu() {
                int firstVisiblePosition = this.fEh.fDL.getFirstVisiblePosition();
                if (firstVisiblePosition == 0) {
                    View childAt = this.fEh.fDL.getChildAt(firstVisiblePosition);
                    if (childAt != null && childAt.getTop() >= 0) {
                        return true;
                    }
                }
                return false;
            }
        };
        this.fDL.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                this.fEh.akx();
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.fEh.akx();
            }
        });
        this.fDL.addHeaderView(this.fDO, null, false);
        View inflate = getLayoutInflater().inflate(2130903571, null);
        this.fDQ = inflate.findViewById(2131756857);
        inflate.findViewById(2131756858).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankInfoUI fEh;

            {
                this.fEh = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
                intent.putExtra("Select_block_List", "gh_43f2581f6fd6");
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("Select_Send_Card", true);
                com.tencent.mm.ay.c.a(this.fEh, ".ui.transmit.SelectConversationUI", intent, 3);
            }
        });
        this.fDQ.setVisibility(8);
        this.fDL.addFooterView(inflate);
        if (this.fDZ != null) {
            dimensionPixelSize = this.fDZ.size();
        } else {
            dimensionPixelSize = 0;
        }
        if (this.fEa != null) {
            size = this.fEa.size();
        } else {
            size = 0;
        }
        if (dimensionPixelSize + size == 0) {
            this.fDY = new ArrayList();
            this.fDM.fDj = this.fDY;
            getString(2131231164);
            this.fAx = g.a(this, getString(2131233521), true, new OnCancelListener(this) {
                final /* synthetic */ ExdeviceRankInfoUI fEh;

                {
                    this.fEh = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.fEh.fAx != null) {
                        this.fEh.fAx.dismiss();
                        this.fEh.fAx = null;
                    }
                    this.fEh.finish();
                }
            });
        }
        this.fDL.setAdapter(this.fDM);
        this.fDM.fDm = this;
        if (this.fDX == 1) {
            this.fDL.setVisibility(0);
            this.fDN.setVisibility(8);
            z = true;
        } else {
            this.fDL.setVisibility(8);
            this.fDN.setVisibility(0);
            z = false;
        }
        if (z) {
            this.fCH = (ImageView) findViewById(2131756850);
            mMPullDownView.nXo = false;
            this.fCH.setLayoutParams(new LayoutParams(com.tencent.mm.bd.a.dv(this), ((Integer) this.fDO.getTag()).intValue()));
            aky();
            cR(false);
            return;
        }
        v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "hy: cannot handle this device type");
        finish();
    }

    private void akx() {
        View childAt = this.fDL.getChildAt(0);
        int[] iArr = new int[2];
        if (childAt != null) {
            if (this.fDL.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (be.kS(this.fEe) && fCW == 128) {
                    fCW = iArr[1];
                }
                int i = iArr[1];
                if (i > 0) {
                    float f;
                    if (i >= fCW) {
                        f = 1.0f;
                    } else {
                        f = ((float) i) / ((float) fCW);
                    }
                    v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[]{Float.valueOf(f)});
                    this.fDP.setAlpha(f);
                    this.fDP.setVisibility(0);
                    this.fCL.setAlpha(f);
                    return;
                }
            }
            this.fDP.setAlpha(0.0f);
            this.fCL.setAlpha(0.0f);
            this.fDP.setVisibility(8);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onRestart() {
        super.onRestart();
        akt();
    }

    protected void onDestroy() {
        this.FM = true;
        super.onDestroy();
        ac.ajz().b(this);
        ac.ajy().fwI = null;
        ac.ajy().fwJ = null;
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130903573;
    }

    private void aky() {
        if (this.fDV == null) {
            this.fCH.setImageResource(2131689643);
            this.fCN = null;
        } else if (this.fCN == this.fDV.field_championUrl) {
        } else {
            if (this.fCN == null || !this.fCN.equals(this.fDV.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.fCH, this.fDV.field_championUrl);
                this.fCN = this.fDV.field_championUrl;
            }
        }
    }

    private void cR(boolean z) {
        if (z) {
            akv();
        }
        if (be.kS(this.fDT)) {
            this.fDP.setVisibility(8);
            return;
        }
        this.fDP.sA(this.fDW);
        this.fDP.setVisibility(0);
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        boolean z = (dVar == null || be.kS(str)) ? false : true;
        Assert.assertTrue(z);
        if ("HardDeviceRankInfo".equals(str)) {
            if (this.fDU != null && this.fDU.equals(dVar.fwr)) {
                v.i("MicroMsg.exdevice.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[]{this.fDU});
                akt();
                if (be.kS(this.fDW) || !this.fDW.equals(akw())) {
                    akv();
                    this.fDV = ac.aju().sm(this.fDW);
                    runOnUiThread(new Runnable(this) {
                        final /* synthetic */ ExdeviceRankInfoUI fEh;

                        {
                            this.fEh = r1;
                        }

                        public final void run() {
                            this.fEh.ako();
                            this.fEh.aky();
                        }
                    });
                }
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceRankInfoUI fEh;

                    {
                        this.fEh = r1;
                    }

                    public final void run() {
                        this.fEh.cR(true);
                        if (this.fEh.fEf) {
                            this.fEh.fDM.notifyDataSetChanged();
                        } else {
                            this.fEh.aku();
                        }
                    }
                });
            }
        } else if ("HardDeviceChampionInfo".equals(str) && !be.kS(this.fDW) && this.fDW.equals(dVar.username)) {
            this.fDV = ac.aju().sm(this.fDW);
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceRankInfoUI fEh;

                {
                    this.fEh = r1;
                }

                public final void run() {
                    this.fEh.ako();
                    this.fEh.aky();
                }
            });
        }
    }

    public final void sj(String str) {
        v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[]{str});
        this.fDU = str;
    }

    public final void sC(String str) {
        Intent intent = new Intent(this, ExdeviceProfileUI.class);
        intent.putExtra("username", str);
        intent.putExtra("usernickname", (String) this.fDk.get(str));
        intent.putExtra("app_username", this.fDT);
        intent.putExtra("rank_id", this.fDU);
        startActivity(intent);
    }

    public final void at(String str, int i) {
        boolean z;
        ac.ajy();
        String str2 = this.fDU;
        String str3 = this.fDT;
        com.tencent.mm.plugin.exdevice.f.b.b.d ajr = ac.ajr();
        if (be.kS(str2) || be.kS(str) || !(i == 1 || i == 0 || i == 2)) {
            z = false;
        } else {
            z = true;
        }
        Assert.assertTrue(z);
        d a = ajr.a(new com.tencent.mm.plugin.exdevice.f.b.d(str2, null, str));
        if (a == null) {
            v.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
        } else {
            a.field_selfLikeState = i;
            switch (a.field_selfLikeState) {
                case 0:
                    a.field_likecount--;
                    break;
                case 1:
                    a.field_likecount++;
                    break;
                default:
                    v.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
                    break;
            }
            ajr.a(a, true);
        }
        ak.vy().a(new com.tencent.mm.plugin.exdevice.f.a.l(str, str3, i, str2), 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.fDT) && i2 == -1) {
            switch (i) {
                case 1:
                    if (intent == null) {
                        v.e("MicroMsg.exdevice.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[]{Integer.valueOf(i)});
                        return;
                    }
                    final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        v.e("MicroMsg.exdevice.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
                        return;
                    }
                    final String aja = com.tencent.mm.plugin.exdevice.model.f.aja();
                    com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, l.er(aja), com.tencent.mm.plugin.exdevice.model.f.sb(this.dRA), this.fCP, true, getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                        final /* synthetic */ ExdeviceRankInfoUI fEh;

                        public final void a(boolean z, String str, int i) {
                            if (z) {
                                ExdeviceRankInfoUI.a(this.fEh, stringExtra, aja, str);
                                g.bf(this.fEh.nDR.nEl, this.fEh.getResources().getString(2131231155));
                            }
                        }
                    });
                    v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "Select conversation return.");
                    return;
                case 2:
                    v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "Share to timeline return.");
                    return;
                case 3:
                    if (intent != null) {
                        String stringExtra2 = intent.getStringExtra("be_send_card_name");
                        String stringExtra3 = intent.getStringExtra("received_card_name");
                        String stringExtra4 = intent.getStringExtra("custom_send_text");
                        boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Chat_User", stringExtra3);
                        intent2.putExtra("send_card_username", stringExtra2);
                        intent2.putExtra("send_card_edittext", stringExtra4);
                        intent2.putExtra("Is_Chatroom", booleanExtra);
                        com.tencent.mm.ay.c.a(this, ".ui.chatting.ChattingUI", intent2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean sD(String str) {
        if (be.kS(this.fDU) || "#".equals(this.fDU)) {
            v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
            Toast.makeText(this, getString(2131232573), 0).show();
            return true;
        } else if (!com.tencent.mm.model.k.xF().equals(str)) {
            return false;
        } else {
            v.d("MicroMsg.exdevice.ExdeviceRankInfoUI", "hy: is self. see who likes me");
            Intent intent = new Intent(this, ExdeviceLikeUI.class);
            intent.putExtra("app_username", this.fDT);
            intent.putExtra("rank_id", this.fDU);
            intent.putExtra("key_is_like_read_only", true);
            startActivity(intent);
            return true;
        }
    }
}
