package com.tencent.mm.ui.d;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ay.c;
import com.tencent.mm.bd.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsimple.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.v.n;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class m extends b {
    private boolean cRi = false;
    private TextView dtY;
    private TextView dtZ;
    private ProgressDialog dwR = null;
    public ImageView eZn;
    public View edj = null;
    private TextView khi;
    private TextView nRn;
    private TextView nRo;
    public ImageView nRp;
    public ImageView nRq;
    public ImageView nRr;
    private ProgressBar nRs;
    String nRt;
    private boolean nRu = false;
    boolean nRv = false;

    public m(Context context) {
        super(context);
        aqp();
    }

    public final int getLayoutId() {
        return 2130904120;
    }

    private void aqp() {
        if (!this.nRu && this.view != null) {
            this.edj = this.view.findViewById(2131758423);
            this.dtY = (TextView) this.view.findViewById(2131758425);
            this.dtZ = (TextView) this.view.findViewById(2131758426);
            this.khi = (TextView) this.view.findViewById(2131758427);
            this.nRn = (TextView) this.view.findViewById(2131758429);
            this.nRs = (ProgressBar) this.view.findViewById(2131758428);
            this.eZn = (ImageView) this.view.findViewById(2131758424);
            this.nRp = (ImageView) this.view.findViewById(2131758433);
            this.nRq = (ImageView) this.view.findViewById(2131758432);
            this.nRr = (ImageView) this.view.findViewById(2131758431);
            this.nRo = (TextView) this.view.findViewById(2131758430);
            this.nRp.setVisibility(8);
            this.nRu = true;
        }
    }

    public final void destroy() {
    }

    public final boolean agO() {
        boolean z;
        boolean z2 = true;
        int i = 0;
        int BJ = ak.vy().BJ();
        String networkServerIp = ak.vy().getNetworkServerIp();
        this.nRt = String.format("http://w.mail.qq.com/cgi-bin/report_mm?failuretype=1&devicetype=2&clientversion=%s&os=%s&username=%s&iport=%s&t=weixin_bulletin&f=xhtml&lang=%s", new Object[]{"0x" + Integer.toHexString(d.lWh), d.cmW, k.xF(), networkServerIp, u.bsY()});
        aqp();
        v.i("MicroMsg.NetWarnView", "update st:%d", Integer.valueOf(BJ));
        switch (BJ) {
            case 0:
                this.dtY.setText(2131234019);
                this.dtZ.setVisibility(8);
                this.nRn.setVisibility(8);
                this.nRs.setVisibility(8);
                this.eZn.setVisibility(0);
                this.edj.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ m nRw;

                    {
                        this.nRw = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, ((Context) this.nRw.lKT.get()).getString(2131234019));
                        intent.putExtra("rawUrl", ((Context) this.nRw.lKT.get()).getString(2131234018));
                        intent.putExtra("showShare", false);
                        c.b((Context) this.nRw.lKT.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
                z = true;
                break;
            case 2:
                this.dtY.setText(2131234022);
                this.dtZ.setVisibility(8);
                this.nRn.setVisibility(8);
                this.nRs.setVisibility(8);
                this.eZn.setVisibility(0);
                this.edj.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ m nRw;

                    {
                        this.nRw = r1;
                    }

                    public final void onClick(View view) {
                        c.w((Context) this.nRw.lKT.get(), "traceroute", ".ui.NetworkDiagnoseIntroUI");
                    }
                });
                z = true;
                break;
            case 3:
                this.dtY.setText(2131234017);
                this.dtZ.setVisibility(8);
                this.nRn.setVisibility(8);
                this.nRs.setVisibility(0);
                this.eZn.setVisibility(0);
                z = true;
                break;
            case 5:
                this.dtY.setText(2131234020);
                this.dtZ.setText(((Context) this.lKT.get()).getString(2131234021));
                this.dtZ.setVisibility(0);
                this.nRn.setVisibility(8);
                this.nRs.setVisibility(8);
                this.eZn.setVisibility(0);
                this.edj.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ m nRw;

                    {
                        this.nRw = r1;
                    }

                    public final void onClick(View view) {
                        if (!t.E((Context) this.nRw.lKT.get(), this.nRw.nRt)) {
                            Intent intent = new Intent();
                            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, ((Context) this.nRw.lKT.get()).getString(2131234022));
                            intent.putExtra("rawUrl", ((Context) this.nRw.lKT.get()).getString(2131234018));
                            intent.putExtra("showShare", false);
                            c.b((Context) this.nRw.lKT.get(), "webview", ".ui.tools.WebViewUI", intent);
                        }
                    }
                });
                z = true;
                break;
            default:
                z = false;
                break;
        }
        int fromDPToPix = a.fromDPToPix((Context) this.lKT.get(), 2);
        if (z) {
            this.khi.setVisibility(8);
            this.dtY.setVisibility(0);
            this.edj.setBackgroundResource(2130839340);
            LayoutParams layoutParams = this.eZn.getLayoutParams();
            layoutParams.width = a.fromDPToPix((Context) this.lKT.get(), 31);
            layoutParams.height = a.fromDPToPix((Context) this.lKT.get(), 31);
            this.eZn.setLayoutParams(layoutParams);
            this.eZn.setImageResource(2130839254);
            this.eZn.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.nRq.setVisibility(8);
            this.nRr.setVisibility(8);
            this.nRo.setVisibility(8);
        } else {
            ak.yW();
            if (com.tencent.mm.model.c.wC()) {
                ak.yW();
                if (p.gf(com.tencent.mm.model.c.wD())) {
                    n vy = ak.vy();
                    ak.yW();
                    vy.a(new p(com.tencent.mm.model.c.wD()), 0);
                }
            }
            ak.yW();
            if (!(!com.tencent.mm.model.c.wC() || t.kS(p.cYz) || p.Jb())) {
                this.edj.setBackgroundResource(2130839341);
                ((Context) this.lKT.get()).getResources().getDimensionPixelSize(2131493168);
                this.dtY.setVisibility(8);
                this.dtZ.setVisibility(8);
                this.khi.setVisibility(0);
                if (k.eF(k.xL())) {
                    if (p.Je() || !p.Jc()) {
                        this.khi.setText(p.cYz);
                    } else {
                        this.khi.setText(p.cYG);
                    }
                } else if (p.Je() || !p.Jc()) {
                    this.khi.setText(p.cYC);
                } else {
                    this.khi.setText(p.cYH);
                }
                this.nRn.setVisibility(8);
                this.nRs.setVisibility(8);
                if (p.Ja() == 1) {
                    this.eZn.setImageResource(2131165435);
                } else if (p.Ja() == 2) {
                    if (p.Jc()) {
                        this.eZn.setImageResource(2131165434);
                    } else {
                        this.eZn.setImageResource(2131165433);
                    }
                } else if (p.Ja() == 3) {
                    this.eZn.setImageResource(2131165432);
                } else {
                    this.eZn.setImageResource(2131165981);
                }
                this.eZn.setVisibility(0);
                this.nRq.setVisibility(8);
                this.nRr.setVisibility(8);
                TextView textView = this.nRo;
                if (k.eF(k.xL())) {
                    BJ = 8;
                } else {
                    BJ = 0;
                }
                textView.setVisibility(BJ);
                final Intent intent = new Intent();
                intent.putExtra("intent.key.online_version", p.Jd());
                this.edj.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ m nRw;

                    public final void onClick(View view) {
                        c.b((Context) this.nRw.lKT.get(), "webwx", ".ui.WebWXLogoutUI", intent);
                    }
                });
                z = true;
            }
        }
        if (!z) {
            this.nRp.setVisibility(8);
            if (q.dpD) {
                fromDPToPix = com.tencent.mm.sdk.platformtools.ak.getBackgroundLimitType((Context) this.lKT.get());
                if (!com.tencent.mm.sdk.platformtools.ak.isLimited(fromDPToPix) || this.nRv) {
                    this.nRp.setVisibility(8);
                    z2 = z;
                } else {
                    this.dtY.setText(((Context) this.lKT.get()).getString(2131234251));
                    this.dtZ.setText(((Context) this.lKT.get()).getString(2131234250));
                    this.dtZ.setVisibility(0);
                    this.nRn.setVisibility(8);
                    this.nRs.setVisibility(8);
                    this.eZn.setVisibility(0);
                    this.nRp.setVisibility(0);
                    this.edj.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ m nRw;

                        public final void onClick(View view) {
                            try {
                                com.tencent.mm.sdk.platformtools.ak.startSettingItent((Context) this.nRw.lKT.get(), fromDPToPix);
                            } catch (Throwable e) {
                                v.a("MicroMsg.NetWarnView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            }
                        }
                    });
                    this.nRp.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ m nRw;

                        public final void onClick(View view) {
                            MMAppMgr.a((Context) this.nRw.lKT.get(), fromDPToPix, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass6 nRx;

                                {
                                    this.nRx = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    try {
                                        this.nRx.nRw.edj.setVisibility(8);
                                        this.nRx.nRw.nRv = true;
                                        com.tencent.mm.sdk.platformtools.ak.startSettingItent((Context) this.nRx.nRw.lKT.get(), fromDPToPix);
                                    } catch (Throwable e) {
                                        v.a("MicroMsg.NetWarnView", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    }
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass6 nRx;

                                {
                                    this.nRx = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.nRx.nRw.edj.setVisibility(8);
                                    this.nRx.nRw.nRv = true;
                                }
                            });
                        }
                    });
                }
                z = z2;
            }
        }
        this.nRr.setImageResource(2131165369);
        this.nRp.setImageResource(2130837728);
        View view = this.edj;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        return z;
    }

    public final void setVisibility(int i) {
        if (this.edj != null) {
            this.edj.setVisibility(i);
        }
    }
}
