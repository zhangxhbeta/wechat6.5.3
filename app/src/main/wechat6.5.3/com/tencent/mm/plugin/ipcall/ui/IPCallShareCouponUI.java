package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.he;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bb;
import com.tencent.mm.plugin.ipcall.a.e.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class IPCallShareCouponUI extends MMActivity implements e {
    private String can = null;
    private ProgressDialog gKB;
    private c gKs = new c<he>(this) {
        final /* synthetic */ IPCallShareCouponUI gOn;

        {
            this.gOn = r2;
            this.nhz = he.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 gOo;

                {
                    this.gOo = r1;
                }

                public final void run() {
                    ak.yW();
                    if (((Boolean) com.tencent.mm.model.c.vf().get(a.nqE, Boolean.valueOf(false))).booleanValue()) {
                        this.gOo.gOn.gOa.setVisibility(0);
                    } else {
                        this.gOo.gOn.gOa.setVisibility(8);
                    }
                    ak.yW();
                    this.gOo.gOn.gNZ.setText((String) com.tencent.mm.model.c.vf().get(a.nqD, ""));
                }
            });
            return true;
        }
    };
    private String gND = null;
    private String gNE = null;
    private String gNF = null;
    private String gNG = null;
    private String gNH = null;
    private String gNI = null;
    private String gNJ = null;
    private String gNK = null;
    private RelativeLayout gNY;
    private TextView gNZ;
    private ImageView gOa;
    private LinearLayout gOb;
    private LinearLayout gOc;
    private LinearLayout gOd;
    private LinearLayout gOe;
    private ImageView gOf;
    private TextView gOg;
    private TextView gOh;
    private ImageView gOi;
    private TextView gOj;
    private IPCallDynamicTextView gOk;
    private com.tencent.mm.plugin.ipcall.a.e.b gOl = new com.tencent.mm.plugin.ipcall.a.e.b();
    private boolean gOm = false;
    private String mTitle = null;

    static /* synthetic */ void c(IPCallShareCouponUI iPCallShareCouponUI) {
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.gOl;
        bVar.gHZ++;
        g.iuh.a(257, 2, 1, true);
        String string = aa.getContext().getString(2131233364);
        try {
            int uQ = ak.uQ();
            String encode = URLEncoder.encode(d.lWf, ProtocolPackage.ServerEncoding);
            String encode2 = URLEncoder.encode(be.buj(), ProtocolPackage.ServerEncoding);
            String encode3 = URLEncoder.encode(p.rJ(), ProtocolPackage.ServerEncoding);
            String encode4 = URLEncoder.encode(d.lWa, ProtocolPackage.ServerEncoding);
            String encode5 = URLEncoder.encode(d.lWb, ProtocolPackage.ServerEncoding);
            String encode6 = URLEncoder.encode(d.lWc, ProtocolPackage.ServerEncoding);
            String encode7 = URLEncoder.encode(ak.uR(), ProtocolPackage.ServerEncoding);
            string = string + "&version=" + d.lWh + "&lang=" + u.dJ(aa.getContext()) + ("&uin=" + uQ + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + encode7 + "&signature=" + URLEncoder.encode(bb.zw(), ProtocolPackage.ServerEncoding) + "&scene=0");
        } catch (UnsupportedEncodingException e) {
            v.e("MicroMsg.IPCallShareCouponUI", "[royle]UnsupportedEncodingException:%s", new Object[]{e.getMessage()});
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        com.tencent.mm.ay.c.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void d(IPCallShareCouponUI iPCallShareCouponUI) {
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.gOl;
        bVar.gIa++;
        g.iuh.a(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(2131233339));
        intent.putExtra("showShare", false);
        com.tencent.mm.ay.c.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void e(IPCallShareCouponUI iPCallShareCouponUI) {
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.gOl;
        bVar.gHY++;
        g.iuh.a(257, 1, 1, true);
        ak.yW();
        com.tencent.mm.model.c.vf().a(a.nqF, Boolean.valueOf(false));
        iPCallShareCouponUI.gOi.setVisibility(8);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(2131233352));
        intent.putExtra("showShare", false);
        com.tencent.mm.ay.c.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void h(IPCallShareCouponUI iPCallShareCouponUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(2131233398));
        intent.putExtra("showShare", false);
        com.tencent.mm.ay.c.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected final int NO() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == BaseReportManager.MAX_READ_COUNT) {
            com.tencent.mm.plugin.ipcall.a.f.b.auP().dK(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(257, this);
        com.tencent.mm.sdk.c.a.nhr.e(this.gKs);
        vD(2131233401);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI gOn;

            {
                this.gOn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gOn.finish();
                return true;
            }
        });
        this.nDR.bAi();
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI gOn;

            {
                this.gOn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] strArr;
                if (com.tencent.mm.plugin.ipcall.b.c.avD()) {
                    strArr = new String[]{this.gOn.getString(2131233400), this.gOn.getString(2131233335), this.gOn.getString(2131233356), this.gOn.getString(2131233338)};
                    this.gOn.gOm = true;
                } else {
                    strArr = new String[]{this.gOn.getString(2131233335), this.gOn.getString(2131233356), this.gOn.getString(2131233338)};
                    this.gOn.gOm = false;
                }
                com.tencent.mm.ui.base.g.a(this.gOn.nDR.nEl, null, strArr, null, false, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass3 gOp;

                    {
                        this.gOp = r1;
                    }

                    public final void gT(int i) {
                        if (!this.gOp.gOn.gOm) {
                            i++;
                        }
                        switch (i) {
                            case 0:
                                IPCallShareCouponUI.h(this.gOp.gOn);
                                return;
                            case 1:
                                IPCallShareCouponUI.e(this.gOp.gOn);
                                return;
                            case 2:
                                IPCallShareCouponUI.c(this.gOp.gOn);
                                return;
                            case 3:
                                IPCallShareCouponUI.d(this.gOp.gOn);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.gOk = (IPCallDynamicTextView) findViewById(2131757530);
        this.gNY = (RelativeLayout) findViewById(2131757532);
        this.gNZ = (TextView) findViewById(2131757533);
        this.gOa = (ImageView) findViewById(2131757534);
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(a.nqE, Boolean.valueOf(false))).booleanValue()) {
            this.gOa.setVisibility(0);
        }
        ak.yW();
        this.gNZ.setText((String) com.tencent.mm.model.c.vf().get(a.nqD, ""));
        this.gOj = (TextView) findViewById(2131757531);
        this.gOb = (LinearLayout) findViewById(2131757543);
        this.gOi = (ImageView) findViewById(2131757544);
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(a.nqF, Boolean.valueOf(false))).booleanValue()) {
            this.gOi.setVisibility(0);
        }
        this.gOg = (TextView) findViewById(2131757545);
        this.gOh = (TextView) findViewById(2131757546);
        this.gOc = (LinearLayout) findViewById(2131757536);
        this.gOd = (LinearLayout) findViewById(2131757538);
        this.gOe = (LinearLayout) findViewById(2131757541);
        this.gOf = (ImageView) findViewById(2131757542);
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(a.nqL, Boolean.valueOf(false))).booleanValue()) {
            this.gOf.setVisibility(0);
        }
        if (j.sU().getInt("WCOPurchaseSwitch", 0) == 1) {
            this.gNY.setVisibility(8);
        }
        if (j.sU().getInt("WCOInviteFriend", 0) == 1) {
            this.gOc.setVisibility(8);
        }
        this.gOg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI gOn;

            {
                this.gOn = r1;
            }

            public final void onClick(View view) {
                IPCallShareCouponUI.c(this.gOn);
            }
        });
        this.gOh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI gOn;

            {
                this.gOn = r1;
            }

            public final void onClick(View view) {
                IPCallShareCouponUI.d(this.gOn);
            }
        });
        this.gOb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI gOn;

            {
                this.gOn = r1;
            }

            public final void onClick(View view) {
                IPCallShareCouponUI.e(this.gOn);
            }
        });
        this.gOc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI gOn;

            {
                this.gOn = r1;
            }

            public final void onClick(View view) {
                g.iuh.h(13340, new Object[]{Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
                Intent intent = new Intent();
                intent.setClass(this.gOn.nDR.nEl, IPCallShareCouponCardUI.class);
                this.gOn.nDR.nEl.startActivity(intent);
            }
        });
        this.gOe.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI gOn;

            {
                this.gOn = r1;
            }

            public final void onClick(View view) {
                ak.yW();
                if (((Boolean) com.tencent.mm.model.c.vf().get(a.nqL, Boolean.valueOf(false))).booleanValue()) {
                    ak.yW();
                    h.C(4, -1, ((Integer) com.tencent.mm.model.c.vf().get(a.nqM, Integer.valueOf(-1))).intValue());
                }
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.nqM, Integer.valueOf(-1));
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.nqL, Boolean.valueOf(false));
                this.gOn.gOf.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(this.gOn.nDR.nEl, IPCallMsgUI.class);
                this.gOn.nDR.nEl.startActivity(intent);
            }
        });
        this.gOd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI gOn;

            {
                this.gOn = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.gOn.nDR.nEl, IPCallMyGiftCardUI.class);
                this.gOn.nDR.nEl.startActivity(intent);
            }
        });
        this.gNY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI gOn;

            {
                this.gOn = r1;
            }

            public final void onClick(View view) {
                ak.yW();
                if (((Boolean) com.tencent.mm.model.c.vf().get(a.nqE, Boolean.valueOf(false))).booleanValue()) {
                    h.C(3, -1, -1);
                }
                ak.yW();
                com.tencent.mm.model.c.vf().a(a.nqE, Boolean.valueOf(false));
                this.gOn.gOa.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(this.gOn.nDR.nEl, IPCallRechargeUI.class);
                this.gOn.startActivityForResult(intent, BaseReportManager.MAX_READ_COUNT);
            }
        });
        aau avE = com.tencent.mm.plugin.ipcall.b.c.avE();
        if (avE != null) {
            a(avE);
            acO();
        } else {
            this.gOk.setText("0");
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            getString(2131231164);
            this.gKB = com.tencent.mm.ui.base.g.a(actionBarActivity, getString(2131233361), true, new OnCancelListener(this) {
                final /* synthetic */ IPCallShareCouponUI gOn;

                {
                    this.gOn = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    try {
                        this.gOn.finish();
                    } catch (Exception e) {
                        v.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", new Object[]{e.getMessage()});
                    }
                }
            });
        }
        com.tencent.mm.plugin.ipcall.a.f.b.auP().dK(false);
        this.gOl.start();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(257, this);
        com.tencent.mm.sdk.c.a.nhr.f(this.gKs);
        this.gOl.gHX = System.currentTimeMillis();
        this.gOl.finish();
    }

    protected final int getLayoutId() {
        return 2130903821;
    }

    private void acO() {
        if (!be.kS(this.gNI)) {
            if (this.gNH == null) {
                this.gOk.bR(this.gNI, this.gNI);
            } else {
                this.gOk.bR(this.gNH, this.gNI);
            }
            this.gNH = this.gNI;
        }
        this.gOj.getText();
        this.gOj.setText(this.gNJ);
        if (be.kS(this.gNJ)) {
            this.gOj.setVisibility(8);
        } else {
            this.gOj.setVisibility(0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.ipcall.a.d.e)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            a(((com.tencent.mm.plugin.ipcall.a.d.e) kVar).gHH);
            acO();
            if (this.gKB != null && this.gKB.isShowing()) {
                this.gKB.dismiss();
            }
        } else if (this.gKB != null && this.gKB.isShowing()) {
            this.gKB.dismiss();
            com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131233359), getString(2131233354), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ IPCallShareCouponUI gOn;

                {
                    this.gOn = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.gOn.finish();
                }
            });
        }
    }

    private void a(aau com_tencent_mm_protocal_c_aau) {
        this.gND = com_tencent_mm_protocal_c_aau.mCd;
        this.can = com_tencent_mm_protocal_c_aau.gkC;
        this.gNE = com_tencent_mm_protocal_c_aau.mCe;
        this.mTitle = com_tencent_mm_protocal_c_aau.aXz;
        this.gNF = com_tencent_mm_protocal_c_aau.gIE;
        this.gNG = com_tencent_mm_protocal_c_aau.mCf;
        this.gNI = com_tencent_mm_protocal_c_aau.mCg;
        this.gNJ = com_tencent_mm_protocal_c_aau.mCh;
        this.gNK = com_tencent_mm_protocal_c_aau.mCi;
    }
}
