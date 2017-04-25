package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.plugin.emoji.e.o;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.f.a;
import com.tencent.mm.plugin.emoji.model.f.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2DesignerUI extends MMActivity implements OnScrollListener, OnItemClickListener, a, b, c, e, com.tencent.mm.v.e {
    private ListView Eq;
    private View PH;
    private int cVh;
    private long fdd;
    private String fde;
    private String fdi;
    private String feg;
    private int ffG = -1;
    private boolean ffH;
    private byte[] ffJ;
    protected final int ffN = 131074;
    private final int ffO = 131075;
    private final int ffP = 131076;
    private final String ffQ = "product_id";
    private final String ffR = "progress";
    private final String ffS = DownloadInfo.STATUS;
    private com.tencent.mm.plugin.emoji.model.e ffV;
    private f ffW;
    private com.tencent.mm.sdk.c.c ffY = new com.tencent.mm.sdk.c.c<cb>(this) {
        final /* synthetic */ EmojiStoreV2DesignerUI foh;

        {
            this.foh = r2;
            this.nhz = cb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            cb cbVar = (cb) bVar;
            EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.foh;
            String str = cbVar.aZC.aZD;
            int i = cbVar.aZC.status;
            int i2 = cbVar.aZC.progress;
            v.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), cbVar.aZC.aZE});
            if (i == 6) {
                emojiStoreV2DesignerUI.ao(str, i2);
            } else {
                v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "product status:%d", new Object[]{Integer.valueOf(i)});
                emojiStoreV2DesignerUI.an(str, i);
            }
            if (!(emojiStoreV2DesignerUI.fgg == null || emojiStoreV2DesignerUI.fgg.eZW == null)) {
                com.tencent.mm.plugin.emoji.a.a.f qY = emojiStoreV2DesignerUI.fgg.eZW.qY(str);
                if (qY != null) {
                    qY.fal = r4;
                }
            }
            return false;
        }
    };
    private g ffZ;
    com.tencent.mm.plugin.emoji.a.f fgg;
    private int fnA;
    private String fnB;
    private String fnC;
    private u fnD;
    private View fnE;
    private BannerEmojiView fnF;
    private TextView fnG;
    private TextView fnH;
    private View fnI;
    private View fnJ;
    private TextView fnK;
    private ImageView fnL;
    private TextView fnM;
    private TextView fnN;
    View fnO;
    private List<nu> fnP = new ArrayList();
    private View fnQ;
    PreViewListGridView fnR;
    private d fnS;
    View fnT;
    View fnU;
    View fnV;
    TextView fnW;
    View fnX;
    private MMPullDownView fnY;
    private xy fnZ;
    private i foa;
    private p fob;
    private ab.c.a foc = new ab.c.a(this) {
        final /* synthetic */ EmojiStoreV2DesignerUI foh;

        {
            this.foh = r1;
        }

        public final void p(String str, boolean z) {
            v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[]{str, Boolean.valueOf(z)});
            if (z) {
                EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.foh;
                ak.yW();
                emojiStoreV2DesignerUI.fnD = com.tencent.mm.model.c.wH().LX(str);
                this.foh.aib();
            }
        }
    };
    private final int fod = 10001;
    private final int foe = 10002;
    private final int fof = 10003;
    private o fog;
    private ac mHandler = new ac(this) {
        final /* synthetic */ EmojiStoreV2DesignerUI foh;

        {
            this.foh = r1;
        }

        public final void handleMessage(Message message) {
            String string;
            switch (message.what) {
                case 10001:
                    this.foh.aia();
                    return;
                case 10002:
                    this.foh.updateData();
                    return;
                case 10003:
                    this.foh.NH();
                    return;
                case 131075:
                    if (this.foh.fgg != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            this.foh.fgg.ao(string, message.getData().getInt("progress"));
                            return;
                        }
                        return;
                    }
                    return;
                case 131076:
                    if (this.foh.fgg != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            this.foh.fgg.an(string, message.getData().getInt(DownloadInfo.STATUS));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void e(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        if (emojiStoreV2DesignerUI.fnA != 0) {
            Intent intent = new Intent();
            intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, emojiStoreV2DesignerUI.fnA);
            intent.setClass(emojiStoreV2DesignerUI.nDR.nEl, EmojiStoreV2SingleProductUI.class);
            emojiStoreV2DesignerUI.startActivity(intent);
        }
    }

    static /* synthetic */ void h(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        if (emojiStoreV2DesignerUI.fnZ != null && !be.kS(emojiStoreV2DesignerUI.fnZ.mfT)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", emojiStoreV2DesignerUI.fnZ.mfT);
            com.tencent.mm.ay.c.b(emojiStoreV2DesignerUI.nDR.nEl, "profile", ".ui.ContactInfoUI", intent);
            com.tencent.mm.plugin.report.service.g.iuh.h(12067, new Object[]{Integer.valueOf(3), "", "", ""});
        }
    }

    static /* synthetic */ void i(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(emojiStoreV2DesignerUI.nDR.nEl, com.tencent.mm.ui.widget.f.pbS, false);
        fVar.jXn = new n.c(emojiStoreV2DesignerUI) {
            final /* synthetic */ EmojiStoreV2DesignerUI foh;

            {
                this.foh = r1;
            }

            public final void a(l lVar) {
                lVar.a(1001, this.foh.getString(2131236669), 2131165344);
                lVar.a(BaseReportManager.MAX_READ_COUNT, this.foh.getString(2131236668), 2131165334);
            }
        };
        fVar.jXo = new d(emojiStoreV2DesignerUI) {
            final /* synthetic */ EmojiStoreV2DesignerUI foh;

            {
                this.foh = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case BaseReportManager.MAX_READ_COUNT /*1000*/:
                        if (this.foh.fnZ != null) {
                            com.tencent.mm.plugin.emoji.d.l.a(this.foh.nDR.nEl, this.foh.fnZ.gkB + this.foh.getString(2131232374), this.foh.fnZ.gkC, this.foh.fnZ.mqz, this.foh.fnC, EmojiLogic.k(this.foh.fnA, this.foh.fdi, this.foh.fnC), 10);
                            com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(1), "", Integer.valueOf(this.foh.fnA)});
                            return;
                        }
                        return;
                    case 1001:
                        com.tencent.mm.plugin.emoji.d.l.bB(this.foh.nDR.nEl);
                        this.foh.nDR.nEl.overridePendingTransition(2130968646, 2130968623);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(2), "", Integer.valueOf(this.foh.fnA)});
                        return;
                    default:
                        return;
                }
            }
        };
        fVar.bKh();
        com.tencent.mm.plugin.report.service.g.iuh.h(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2DesignerUI.fnA)});
    }

    protected final int getLayoutId() {
        return 2130903494;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.feg = getIntent().getStringExtra("id");
        this.fnA = getIntent().getIntExtra(OpenSDKTool4Assistant.EXTRA_UIN, 0);
        this.fdi = getIntent().getStringExtra("name");
        this.fnB = getIntent().getStringExtra("headurl");
        this.fnC = getIntent().getStringExtra("rediret_url");
        this.cVh = getIntent().getIntExtra("extra_scence", 0);
        this.fdd = getIntent().getLongExtra("searchID", 0);
        this.fde = be.ah(getIntent().getStringExtra("docID"), "");
        String stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.fnA = EmojiLogic.rp(stringExtra);
            this.fdi = EmojiLogic.rq(stringExtra);
            this.fnC = EmojiLogic.rt(stringExtra);
        }
        NI();
        if (!be.kS(this.feg)) {
            vl NI = com.tencent.mm.plugin.emoji.model.g.afx().fcn.NI(this.feg);
            if (NI == null || NI.mxZ == null || NI.mxZ.mxS == 0 || be.kS(NI.mxZ.gkB)) {
                z = true;
                if (z) {
                    NH();
                } else {
                    this.foa = new i(this.feg);
                    ak.vy().a(this.foa, 0);
                    getString(2131231164);
                    this.fob = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ EmojiStoreV2DesignerUI foh;

                        {
                            this.foh = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            if (this.foh.foa != null) {
                                ak.vy().c(this.foh.foa);
                            }
                        }
                    });
                }
                ak.vy().a(239, this);
                ak.vy().a(720, this);
                com.tencent.mm.sdk.c.a.nhr.e(this.ffY);
                com.tencent.mm.plugin.report.service.g.iuh.h(12067, new Object[]{Integer.valueOf(1), "", "", ""});
                com.tencent.mm.plugin.report.service.g.iuh.h(12740, new Object[]{Integer.valueOf(2), com.tencent.mm.a.o.getString(this.fnA), "", "", Integer.valueOf(this.cVh)});
            }
            this.fnA = NI.mxZ.mxS;
            this.fdi = NI.mxZ.gkB;
            v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[]{Integer.valueOf(this.fnA), this.fdi});
        }
        z = false;
        if (z) {
            this.foa = new i(this.feg);
            ak.vy().a(this.foa, 0);
            getString(2131231164);
            this.fob = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, /* anonymous class already generated */);
        } else {
            NH();
        }
        ak.vy().a(239, this);
        ak.vy().a(720, this);
        com.tencent.mm.sdk.c.a.nhr.e(this.ffY);
        com.tencent.mm.plugin.report.service.g.iuh.h(12067, new Object[]{Integer.valueOf(1), "", "", ""});
        com.tencent.mm.plugin.report.service.g.iuh.h(12740, new Object[]{Integer.valueOf(2), com.tencent.mm.a.o.getString(this.fnA), "", "", Integer.valueOf(this.cVh)});
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(423, this);
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(423, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.fog != null) {
            ak.vy().c(this.fog);
        }
        ak.vy().b(239, this);
        ak.vy().b(720, this);
        com.tencent.mm.sdk.c.a.nhr.f(this.ffY);
    }

    protected final void NI() {
        if (!be.kS(this.fdi)) {
            Fd(this.fdi);
        }
        this.PH = q.em(this.nDR.nEl).inflate(2130903491, null);
        this.fnE = this.PH.findViewById(2131756691);
        this.fnF = (BannerEmojiView) this.fnE.findViewById(2131756697);
        this.fnG = (TextView) this.PH.findViewById(2131756692);
        this.fnH = (TextView) this.PH.findViewById(2131756693);
        this.fnI = this.PH.findViewById(2131756694);
        this.fnJ = this.PH.findViewById(2131756686);
        this.fnK = (TextView) this.PH.findViewById(2131756688);
        this.fnL = (ImageView) this.PH.findViewById(2131756687);
        this.fnM = (TextView) this.PH.findViewById(2131756689);
        this.fnN = (TextView) this.PH.findViewById(2131756696);
        this.fnO = this.PH.findViewById(2131756699);
        this.fnQ = this.PH.findViewById(2131756704);
        this.fnQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI foh;

            {
                this.foh = r1;
            }

            public final void onClick(View view) {
                EmojiStoreV2DesignerUI.e(this.foh);
            }
        });
        this.fnR = (PreViewListGridView) this.PH.findViewById(2131756702);
        this.fnS = new d(this.nDR.nEl);
        this.fnS.fqL = new a(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI foh;

            {
                this.foh = r1;
            }

            public final void jH(int i) {
                if (this.foh.fnR != null && this.foh.fnS != null) {
                    nu kk = this.foh.fnS.kk(i);
                    if (kk != null) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("extra_object", kk.toByteArray());
                            intent.setClass(this.foh.nDR.nEl, EmojiStoreV2SingleProductDialogUI.class);
                            this.foh.startActivity(intent);
                            this.foh.overridePendingTransition(2130968641, 2130968642);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        this.fnR.setAdapter(this.fnS);
        this.fnT = this.PH.findViewById(2131756700);
        this.fnU = this.PH.findViewById(2131756701);
        this.fnV = this.PH.findViewById(2131756704);
        this.fnW = (TextView) this.PH.findViewById(2131756705);
        this.fnX = this.PH.findViewById(2131756703);
        this.fnY = (MMPullDownView) findViewById(2131756685);
        this.fnY.nWU = this;
        this.fnY.nXf = this;
        this.fnY.jq(false);
        this.fnY.jp(false);
        this.Eq = (ListView) findViewById(16908298);
        this.Eq.setOnItemClickListener(this);
        this.Eq.setOnScrollListener(this);
        this.fnJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI foh;

            {
                this.foh = r1;
            }

            public final void onClick(View view) {
                EmojiStoreV2DesignerUI.h(this.foh);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI foh;

            {
                this.foh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.foh.finish();
                return false;
            }
        });
        a(0, 2131165801, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI foh;

            {
                this.foh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
                EmojiStoreV2DesignerUI.i(this.foh);
                return true;
            }
        });
    }

    private void NH() {
        Fd(this.fdi);
        this.fgg = new com.tencent.mm.plugin.emoji.a.f(this.nDR.nEl);
        this.Eq.addHeaderView(this.PH);
        this.Eq.setAdapter(this.fgg);
        this.fgg.eZX = this;
        this.fgg.eZr = com.tencent.mm.plugin.emoji.d.o.afj();
        this.fgg.eZs = false;
        this.fnG.setText(this.fdi);
        this.fnZ = com.tencent.mm.plugin.emoji.model.g.afx().fck.NM(String.valueOf(this.fnA));
        this.ffW = new f();
        this.ffW.fda = this;
        this.ffW.fcY = this.fgg;
        this.ffW.fdc = 6;
        this.ffW.fdf = this;
        this.ffW.fdi = this.fdi;
        this.ffW.fdd = this.fdd;
        this.ffW.fde = this.fde;
        if (this.fnZ != null) {
            c(o.a(this.fnZ));
            List list = this.fnZ.mfM;
            LinkedList linkedList = this.fnZ.myi;
            am(list);
        }
        updateData();
        ag(this.ffJ);
    }

    private void updateData() {
        if (this.fnZ == null) {
            v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data faild. data is null.");
            return;
        }
        aia();
        if (be.kS(this.fnZ.mfT)) {
            v.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
            this.fnI.setVisibility(8);
            this.fnJ.setVisibility(8);
        } else {
            v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[]{this.fnZ.mfT});
            ak.yW();
            this.fnD = com.tencent.mm.model.c.wH().LX(this.fnZ.mfT);
        }
        if (this.fnD == null || ((int) this.fnD.chr) == 0) {
            v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[]{this.fnZ.mfT});
            ab.a.crZ.a(this.fnZ.mfT, "", this.foc);
        }
        this.fnM.setText(2131232427);
        if (be.kS(this.fnZ.gkC)) {
            this.fnH.setVisibility(8);
        } else {
            this.fnH.setText(this.fnZ.gkC);
            this.fnH.setVisibility(0);
        }
        aib();
        if (this.ffV == null || this.ffV.fcT == null || this.ffV.fcT.isEmpty()) {
            this.fnN.setVisibility(8);
        } else {
            this.fnN.setVisibility(0);
        }
    }

    protected final void aia() {
        if (this.fnZ == null) {
            v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header faild. data is null.");
        } else if (this.fnF != null && !be.kS(this.fnZ.mzX)) {
            String str = this.fnZ.mzX;
            com.tencent.mm.bd.a.getDensity(this);
            com.tencent.mm.storage.a.c a = EmojiLogic.a("Designer", 8, str, true);
            if (a == null) {
                com.tencent.mm.ae.n.GL().a(this.fnZ.mzX, null, com.tencent.mm.plugin.emoji.d.g.b("Designer", this.fnZ.mzX, "Designer", "BANNER"), new com.tencent.mm.ae.a.c.i(this) {
                    final /* synthetic */ EmojiStoreV2DesignerUI foh;

                    {
                        this.foh = r1;
                    }

                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        if (this.foh.mHandler != null) {
                            this.foh.mHandler.sendEmptyMessage(10001);
                        }
                    }
                });
                return;
            }
            this.fnF.bN(a.dR(a.field_groupId, a.EB()), null);
        }
    }

    private void aib() {
        if (this.fnD == null || ((int) this.fnD.chr) == 0) {
            this.fnJ.setVisibility(8);
            this.fnI.setVisibility(8);
            return;
        }
        this.fnJ.setVisibility(0);
        this.fnI.setVisibility(0);
        if (be.kS(this.fnD.tT())) {
            this.fnK.setText(this.fnD.field_username);
        } else {
            this.fnK.setText(this.fnD.tT());
        }
        com.tencent.mm.pluginsdk.ui.a.b.o(this.fnL, this.fnD.field_username);
        this.fnM.setEnabled(true);
    }

    private void ag(byte[] bArr) {
        this.ffH = true;
        this.fog = new o(this.fnA, bArr);
        ak.vy().a(this.fog, 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        switch (kVar.getType()) {
            case 239:
                if (this.fob != null && this.fob.isShowing()) {
                    this.fob.dismiss();
                }
                if (i2 == 0 && i == 0) {
                    vl afL = ((i) kVar).afL();
                    if (afL != null && afL.mxZ != null) {
                        this.fnA = afL.mxZ.mxS;
                        this.fdi = afL.mxZ.gkB;
                        this.fnB = afL.mxZ.mqz;
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(10003);
                            return;
                        }
                        return;
                    }
                    return;
                }
                V(0, false);
                com.tencent.mm.ui.base.g.A(this.nDR.nEl, getString(2131232341), null);
                v.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
                return;
            case 423:
                g gVar = (g) kVar;
                if (i == 0 && i2 == 0) {
                    ao(gVar.fdU, 0);
                    return;
                }
                final String str2 = gVar.fdU;
                final String str3 = gVar.fdW;
                final String str4 = gVar.fdV;
                com.tencent.mm.ui.base.g.a(this, getString(2131232377, new Object[]{str4}), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ EmojiStoreV2DesignerUI foh;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.foh.C(str2, str3, str4);
                        this.foh.agq();
                        v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        this.foh.ao(str2, 0);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ EmojiStoreV2DesignerUI foh;

                    {
                        this.foh = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                an(gVar.fdU, -1);
                return;
            case 720:
                this.ffH = false;
                if (i2 == 0 && (i == 0 || i == 4)) {
                    o oVar = (o) kVar;
                    com.tencent.mm.plugin.emoji.model.e a = o.a(oVar.afS());
                    if (i2 == 0) {
                        this.fnZ = oVar.afS();
                        c(a);
                    } else if (i2 == 2) {
                        b(this.ffG, a);
                        this.ffG = 2;
                    } else if (i2 == 3) {
                        b(this.ffG, a);
                        this.ffG = 1;
                        v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[]{Integer.valueOf(i2)});
                    }
                    if (this.ffJ == null && this.fnZ != null) {
                        com.tencent.mm.plugin.emoji.model.g.afx().fck.a(String.valueOf(this.fnA), oVar.afS());
                        this.fnP = this.fnZ.mfM;
                        List list = this.fnP;
                        LinkedList linkedList = this.fnZ.myi;
                        am(list);
                    }
                    this.ffJ = oVar.fek;
                    return;
                }
                v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
                return;
            default:
                v.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
                return;
        }
    }

    private void am(final List<nu> list) {
        int i = 1;
        String value = j.sU().getValue("ShowDesignerEmoji");
        v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[]{value});
        if (be.kS(value) || be.KL(value) != 1) {
            i = 0;
        }
        if (list == null || list.size() <= 0 || r0 == 0) {
            this.fnO.setVisibility(8);
            return;
        }
        this.fnO.setVisibility(0);
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI foh;

            public final void run() {
                int i;
                int i2 = 8;
                EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.foh;
                if (list.size() > 3) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (emojiStoreV2DesignerUI.fnR != null) {
                    emojiStoreV2DesignerUI.fnR.setVisibility(0);
                }
                if (emojiStoreV2DesignerUI.fnU != null) {
                    emojiStoreV2DesignerUI.fnU.setVisibility(0);
                }
                if (emojiStoreV2DesignerUI.fnT != null) {
                    emojiStoreV2DesignerUI.fnT.setVisibility(0);
                }
                if (emojiStoreV2DesignerUI.fnV != null) {
                    emojiStoreV2DesignerUI.fnV.setVisibility(i != 0 ? 0 : 8);
                }
                if (emojiStoreV2DesignerUI.fnW != null) {
                    emojiStoreV2DesignerUI.fnW.setText(2131232391);
                }
                if (emojiStoreV2DesignerUI.fnX != null) {
                    View view = emojiStoreV2DesignerUI.fnX;
                    if (i != 0) {
                        i2 = 0;
                    }
                    view.setVisibility(i2);
                }
                if (emojiStoreV2DesignerUI.fnO != null) {
                    emojiStoreV2DesignerUI.fnO.setPadding(0, 0, 0, 0);
                }
            }
        });
        this.fnS.an(list);
    }

    private void c(com.tencent.mm.plugin.emoji.model.e eVar) {
        b(this.ffG, eVar);
        this.ffG = 0;
    }

    private void b(int i, com.tencent.mm.plugin.emoji.model.e eVar) {
        Object obj = 1;
        switch (i) {
            case -1:
                this.ffV = eVar;
                break;
            case 0:
                this.ffV = eVar;
                break;
            case 1:
                this.ffV = eVar;
                break;
            case 2:
                if (this.ffV == null) {
                    this.ffV = new com.tencent.mm.plugin.emoji.model.e();
                }
                this.ffV.jM(eVar.fcS);
                this.ffV.ak(eVar.fcT);
                break;
            default:
                obj = null;
                break;
        }
        if (this.ffV != null && r0 != null) {
            if (this.fgg != null) {
                this.fgg.b(this.ffV);
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(10002);
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.ffG == 0 || this.ffH) {
            v.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
            return;
        }
        ag(this.ffJ);
        v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public final boolean agi() {
        return true;
    }

    public final boolean agv() {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.fgg != null) {
            com.tencent.mm.plugin.emoji.a.a.f jG = this.fgg.jG(i - this.Eq.getHeaderViewsCount());
            if (jG != null) {
                Intent intent = new Intent();
                intent.setClass(this, EmojiStoreDetailUI.class);
                ol olVar = jG.fai;
                if (olVar == null) {
                    intent = null;
                } else {
                    intent.putExtra("extra_id", olVar.mdM);
                    intent.putExtra("extra_name", olVar.mqd);
                    intent.putExtra("extra_copyright", olVar.mqn);
                    intent.putExtra("extra_coverurl", olVar.mql);
                    intent.putExtra("extra_description", olVar.mqe);
                    intent.putExtra("extra_price", olVar.mqg);
                    intent.putExtra("extra_type", olVar.mqh);
                    intent.putExtra("extra_flag", olVar.mqi);
                    intent.putExtra("preceding_scence", 106);
                    intent.putExtra("download_entrance_scene", 6);
                    intent.putExtra("call_by", 1);
                    intent.putExtra("check_clickflag", false);
                    intent.putExtra("extra_status", jG.mStatus);
                    intent.putExtra("extra_progress", jG.rT);
                    intent.putExtra("searchID", this.fdd);
                    String stringExtra = getIntent().getStringExtra("to_talker_name");
                    if (!be.kS(stringExtra)) {
                        intent.putExtra("to_talker_name", stringExtra);
                    }
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.EmojiStoreV2DesignerUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.aex();
        objArr[1] = TextUtils.isEmpty(aVar.aez()) ? "" : aVar.aez();
        objArr[2] = Integer.valueOf(aVar.aey());
        v.i(str, str2, objArr);
        aVar.aey();
        this.ffW.a(aVar);
    }

    public final void B(String str, String str2, String str3) {
        C(str, str2, str3);
        agq();
    }

    public final void afo() {
    }

    protected final g C(String str, String str2, String str3) {
        this.ffZ = new g(str, str2, str3);
        return this.ffZ;
    }

    protected final void agq() {
        ak.vy().a(this.ffZ, 0);
    }

    final void ao(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
    }

    final void an(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt(DownloadInfo.STATUS, i);
        obtain.what = 131076;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.ffW.onActivityResult(i, i2, intent);
        if (i == 2002 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (be.kS(stringExtra) || this.fnZ == null) {
                v.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
            } else {
                v.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", ".." + stringExtra);
                String str = this.fdi;
                String str2 = this.fnZ.gkC;
                int i3 = this.fnA;
                String str3 = this.fnC;
                String str4 = this.fdi;
                String str5 = this.fnZ.mqz;
                String stringBuffer = new StringBuffer(getResources().getString(2131231022)).append(str).toString();
                com.tencent.mm.pluginsdk.ui.applet.c.c cVar = new com.tencent.mm.pluginsdk.ui.applet.c.c(this);
                cVar.ba(stringExtra).Hw(stringBuffer).tS(2131231149);
                cVar.Hx(str5).bpi();
                cVar.Hz(getString(2131231976)).a(new com.tencent.mm.plugin.emoji.d.l.AnonymousClass2(stringExtra, str4, str2, i3, str3, str, str5, this)).iji.show();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int NO() {
        return 1;
    }
}
