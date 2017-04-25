package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.aa.a.c.f;
import com.tencent.mm.plugin.aa.a.c.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.protocal.c.r;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaylistAAUI extends BaseAAPresenterActivity {
    private Dialog dtK = null;
    private View dup;
    private g dvH = ((g) i(g.class));
    private f dvI = ((f) j(f.class));
    private LinearLayout dvJ;
    private LinearLayout dvK;
    private LinearLayout dvL;
    private TextView dvM;
    private Button dvN;
    private TextView dvO;
    private TextView dvP;
    private TextView dvQ;
    private String dvR;
    private String dvS;
    private String dvT;
    private String dvU;
    private int dvV;
    private String dvW;
    private String title;

    static /* synthetic */ void a(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.dtK != null) {
            paylistAAUI.dtK.dismiss();
        }
        paylistAAUI.dtK = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.bKO().c(paylistAAUI.dvH.dtw).e(new a<Void, Boolean>(paylistAAUI) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final /* synthetic */ Object aq(Object obj) {
                Boolean bool = (Boolean) obj;
                if (this.dvX.dtK != null) {
                    this.dvX.dtK.dismiss();
                }
                if (bool.booleanValue()) {
                    v.i("MicroMsg.PaylistAAUI", "urgeAAPay success");
                    Toast.makeText(this.dvX, 2131235734, 1).show();
                } else {
                    v.i("MicroMsg.PaylistAAUI", "urgeAAPay fail");
                    Toast.makeText(this.dvX, 2131235733, 1).show();
                }
                return phb;
            }
        }).a(new d.a(paylistAAUI) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final void aA(Object obj) {
                if (this.dvX.dtK != null) {
                    this.dvX.dtK.dismiss();
                }
                if (!(obj instanceof String) || obj.toString().equalsIgnoreCase("ok")) {
                    Toast.makeText(this.dvX, 2131235733, 1).show();
                } else {
                    Toast.makeText(this.dvX, obj.toString(), 1).show();
                }
                v.e("MicroMsg.PaylistAAUI", "urgeAAPay fail");
            }
        });
        com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(8)});
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, long j) {
        paylistAAUI.dtK = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        double d = be.getDouble(paylistAAUI.dvM.getText().toString(), 0.0d);
        com.tencent.mm.vending.g.g.br(Long.valueOf(j)).c(paylistAAUI.dvH.dtt).e(new a<Void, o>(paylistAAUI) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final /* synthetic */ Object aq(Object obj) {
                final o oVar = (o) obj;
                if (this.dvX.dtK != null) {
                    this.dvX.dtK.dismiss();
                }
                String str = "MicroMsg.PaylistAAUI";
                String str2 = "aapay return, alertItem: %s, alertItem.flag: %s";
                Object[] objArr = new Object[2];
                objArr[0] = oVar.lYN;
                objArr[1] = Integer.valueOf(oVar.lYN != null ? oVar.lYN.bkU : 0);
                v.i(str, str2, objArr);
                if (oVar.lYN == null || oVar.lYN.bkU != 1) {
                    v.d("MicroMsg.PaylistAAUI", "aapay return, reqKey: %s", new Object[]{oVar.hci});
                    PaylistAAUI.a(this.dvX, oVar);
                } else {
                    String str3 = oVar.lYN.bhe;
                    String str4 = oVar.lYN.hcm;
                    str = oVar.lYN.hcn;
                    h.a aVar = new h.a(this.dvX);
                    aVar.Oq(str3);
                    aVar.Os(str).a(new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 dvZ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            PaylistAAUI.a(this.dvZ.dvX, oVar);
                        }
                    });
                    aVar.Ot(str4);
                    aVar.RX().show();
                }
                return phb;
            }
        }).a(new d.a(paylistAAUI) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final void aA(Object obj) {
                v.i("MicroMsg.PaylistAAUI", "aapay failed: %s", new Object[]{obj});
                if (this.dvX.dtK != null) {
                    this.dvX.dtK.dismiss();
                }
                if (obj == null) {
                    Toast.makeText(this.dvX, this.dvX.getString(2131230777), 1).show();
                } else if (obj instanceof com.tencent.mm.protocal.c.a) {
                    final com.tencent.mm.protocal.c.a aVar = (com.tencent.mm.protocal.c.a) obj;
                    String str = aVar.bhe;
                    String str2 = aVar.hcm;
                    String str3 = aVar.hcn;
                    h.a aVar2 = new h.a(this.dvX);
                    aVar2.Oq(str);
                    aVar2.Os(str3).a(new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass15 dwf;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            e.l(this.dwf.dvX.nDR.nEl, aVar.kMP, false);
                        }
                    });
                    aVar2.Ot(str2);
                    aVar2.RX().show();
                } else if ((obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                    Toast.makeText(this.dvX, obj.toString(), 1).show();
                }
            }
        });
        com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(9)});
        com.tencent.mm.plugin.report.service.g.iuh.h(13723, new Object[]{Integer.valueOf(3), Integer.valueOf(ak.yW().wO().LF(paylistAAUI.dvT).size()), Integer.valueOf(paylistAAUI.dvV), Double.valueOf(d * 100.0d), paylistAAUI.title});
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, o oVar) {
        boolean z = paylistAAUI.getIntent().getIntExtra("enter_scene", 0) == 1;
        paylistAAUI.dvR = oVar.hci;
        paylistAAUI.dvS = oVar.blS;
        paylistAAUI.dvW = oVar.lYy;
        String str = paylistAAUI.dvR;
        String str2 = oVar.irw;
        String str3 = paylistAAUI.dvU;
        v.d("MicroMsg.AAUtil", "startAAPay, reqKey: %s, isFromChatting: %s", new Object[]{str, Boolean.valueOf(z)});
        PayInfo payInfo = new PayInfo();
        payInfo.fTG = str;
        payInfo.bkq = 42;
        if (z) {
            payInfo.bkh = 14;
        } else {
            payInfo.bkh = 1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        payInfo.lVD = bundle;
        com.tencent.mm.pluginsdk.wallet.e.a(paylistAAUI, false, "", payInfo, str2, new Intent(), 233);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, t tVar) {
        String str = tVar.lYR;
        String str2 = tVar.title;
        double d = ((double) tVar.lYS) / 100.0d;
        b.o((ImageView) paylistAAUI.findViewById(2131758498), str);
        TextView textView = (TextView) paylistAAUI.findViewById(2131758483);
        v.i("MicroMsg.PaylistAAUI", "tftest: cs: %s", new Object[]{paylistAAUI.getString(2131234154, new Object[]{str2, Double.valueOf(d)})});
        try {
            textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(paylistAAUI.nDR.nEl, paylistAAUI.getString(2131234154, new Object[]{str2, Double.valueOf(d)})));
        } catch (Throwable e) {
            v.a("MicroMsg.PaylistAAUI", e, "", new Object[0]);
        }
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, String str) {
        if (paylistAAUI.dtK != null) {
            paylistAAUI.dtK.dismiss();
            paylistAAUI.dtK = null;
        }
        if (be.kS(str)) {
            Toast.makeText(paylistAAUI, 2131230762, 1).show();
        } else {
            Toast.makeText(paylistAAUI, str, 1).show();
        }
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI, t tVar) {
        if (tVar.state == com.tencent.mm.plugin.aa.a.a.drH) {
            paylistAAUI.dvO.setText(2131234152);
            paylistAAUI.dvO.setTextColor(paylistAAUI.getResources().getColor(2131689960));
        } else if (tVar.state == com.tencent.mm.plugin.aa.a.a.drI) {
            paylistAAUI.dvO.setText(2131234150);
            paylistAAUI.dvO.setTextColor(paylistAAUI.getResources().getColor(2131689960));
        } else if (tVar.cqN == com.tencent.mm.plugin.aa.a.a.drL) {
            paylistAAUI.dvK.setVisibility(8);
            paylistAAUI.dvJ.setVisibility(0);
            paylistAAUI.dvO.setText(paylistAAUI.getString(2131234155));
            paylistAAUI.dvO.setTextColor(paylistAAUI.getResources().getColor(2131689916));
        } else if (tVar.cqN == com.tencent.mm.plugin.aa.a.a.drK) {
            paylistAAUI.dvK.setVisibility(8);
            paylistAAUI.dvJ.setVisibility(0);
            if (tVar.lYY == com.tencent.mm.plugin.aa.a.a.drO) {
                paylistAAUI.dvO.setText(paylistAAUI.getString(2131234151));
                paylistAAUI.dvO.setTextColor(paylistAAUI.getResources().getColor(2131689916));
            } else if (tVar.lYY == com.tencent.mm.plugin.aa.a.a.drN) {
                paylistAAUI.dvO.setText(paylistAAUI.getString(2131234157, new Object[]{Double.valueOf(((double) tVar.lYU) / 100.0d)}));
            } else if (tVar.lYY == com.tencent.mm.plugin.aa.a.a.drM) {
                paylistAAUI.dvO.setText(2131234158);
            } else {
                v.e("MicroMsg.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", new Object[]{Integer.valueOf(tVar.state), Integer.valueOf(tVar.type), Integer.valueOf(tVar.cqN)});
                paylistAAUI.dvO.setVisibility(8);
            }
        } else if (tVar.cqN == com.tencent.mm.plugin.aa.a.a.drJ) {
            for (r rVar : tVar.lYB) {
                if (rVar.lYO.equals(k.xF())) {
                    break;
                }
            }
            v.i("MicroMsg.AAUtil", "not contains self");
            r rVar2 = null;
            if (tVar.lYY == com.tencent.mm.plugin.aa.a.a.drQ || (r0 != null && r0.lYQ == com.tencent.mm.plugin.aa.a.a.drQ)) {
                CharSequence format = String.format("%.2f", new Object[]{Double.valueOf(((double) tVar.lYZ) / 100.0d)});
                CharSequence string = paylistAAUI.getString(2131234148);
                int i = tVar.state;
                final long j = tVar.lYZ;
                paylistAAUI.dvK.setVisibility(0);
                paylistAAUI.dvJ.setVisibility(8);
                paylistAAUI.dvN = (Button) paylistAAUI.dvK.findViewById(2131758490);
                if (i == com.tencent.mm.plugin.aa.a.a.drH || i == com.tencent.mm.plugin.aa.a.a.drI) {
                    paylistAAUI.dvN.setVisibility(8);
                }
                paylistAAUI.dvN.setOnClickListener(new View.OnClickListener(paylistAAUI) {
                    final /* synthetic */ PaylistAAUI dvX;

                    public final void onClick(View view) {
                        PaylistAAUI.a(this.dvX, j);
                    }
                });
                paylistAAUI.dvM = (TextView) paylistAAUI.findViewById(2131758488);
                TextView textView = (TextView) paylistAAUI.dvK.findViewById(2131758487);
                paylistAAUI.dvM.setText(format);
                textView.setText(string);
            } else if (tVar.lYY == com.tencent.mm.plugin.aa.a.a.drR || (r0 != null && r0.lYQ == com.tencent.mm.plugin.aa.a.a.drR)) {
                paylistAAUI.dvK.setVisibility(8);
                paylistAAUI.dvJ.setVisibility(0);
                paylistAAUI.dvO.setText(paylistAAUI.getString(2131234156, new Object[]{Double.valueOf(((double) tVar.lYZ) / 100.0d)}));
                paylistAAUI.dvO.setTextColor(paylistAAUI.getResources().getColor(2131689916));
            } else {
                v.e("MicroMsg.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", new Object[]{Integer.valueOf(tVar.state), Integer.valueOf(tVar.type), Integer.valueOf(tVar.cqN)});
                paylistAAUI.dvK.setVisibility(8);
                paylistAAUI.dvO.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void c(PaylistAAUI paylistAAUI, t tVar) {
        View findViewById = paylistAAUI.findViewById(2131755264);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Iterator it = tVar.lYB.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar.lYQ == com.tencent.mm.plugin.aa.a.a.drQ) {
                arrayList2.add(rVar);
            } else {
                arrayList.add(rVar);
            }
        }
        if (arrayList2.isEmpty()) {
            paylistAAUI.a(arrayList, paylistAAUI.getString(2131234145, new Object[]{Integer.valueOf(arrayList.size())}), v(tVar.cqN, tVar.lYY, tVar.state));
            paylistAAUI.dvL.setVisibility(8);
            findViewById.setVisibility(4);
            return;
        }
        paylistAAUI.a(arrayList2, paylistAAUI.getString(2131234144, new Object[]{Integer.valueOf(arrayList2.size())}), v(tVar.cqN, tVar.lYY, tVar.state));
        if (arrayList.isEmpty()) {
            paylistAAUI.dvL.setVisibility(8);
            findViewById.setVisibility(4);
            return;
        }
        String string = paylistAAUI.getString(2131234145, new Object[]{Integer.valueOf(arrayList.size())});
        int i = tVar.cqN;
        i = tVar.lYY;
        i = tVar.state;
        paylistAAUI.c(arrayList, string);
    }

    static /* synthetic */ void d(PaylistAAUI paylistAAUI, t tVar) {
        if (!be.kS(paylistAAUI.dvU) && paylistAAUI.dvU.equals(k.xF()) && tVar.state == com.tencent.mm.plugin.aa.a.a.drG && tVar.lYU < tVar.lYS) {
            paylistAAUI.a(0, 2130838681, new OnMenuItemClickListener(paylistAAUI) {
                final /* synthetic */ PaylistAAUI dvX;

                {
                    this.dvX = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.dvX, com.tencent.mm.ui.widget.f.pbS, false);
                    fVar.jXn = new c(this) {
                        final /* synthetic */ AnonymousClass13 dwb;

                        {
                            this.dwb = r1;
                        }

                        public final void a(l lVar) {
                            lVar.add(0, 2, 1, 2131230756);
                        }
                    };
                    fVar.jXo = new n.d(this) {
                        final /* synthetic */ AnonymousClass13 dwb;

                        {
                            this.dwb = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 2:
                                    com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(5)});
                                    com.tencent.mm.ui.base.g.a(this.dwb.dvX, 2131230755, -1, 2131230759, 2131231565, new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass2 dwc;

                                        {
                                            this.dwc = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            PaylistAAUI.f(this.dwc.dwb.dvX);
                                        }
                                    }, null);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    fVar.bKh();
                    return true;
                }
            });
        }
    }

    static /* synthetic */ void e(PaylistAAUI paylistAAUI, t tVar) {
        if (tVar.cqN == com.tencent.mm.plugin.aa.a.a.drK && tVar.lYR.equals(k.xF())) {
            paylistAAUI.dvQ.setVisibility(0);
        } else {
            paylistAAUI.dvQ.setVisibility(8);
        }
        if (paylistAAUI.dvQ.getVisibility() != 0) {
            v.i("MicroMsg.PaylistAAUI", "no need to show bottom tv");
        } else if (be.kS(tVar.lZe)) {
            v.i("MicroMsg.PaylistAAUI", "wording is null");
        } else {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(tVar.lZe);
            if (tVar.lZf == 1) {
                paylistAAUI.dvQ.setClickable(true);
                paylistAAUI.dvQ.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.h(paylistAAUI));
                spannableStringBuilder.setSpan(new a(new a.a(paylistAAUI) {
                    final /* synthetic */ PaylistAAUI dvX;

                    {
                        this.dvX = r1;
                    }

                    public final void ND() {
                        Intent intent = new Intent();
                        intent.putExtra("key_scene_balance_manager", 0);
                        com.tencent.mm.ay.c.b(this.dvX, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
                        com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(4)});
                    }
                }), 0, spannableStringBuilder.length(), 18);
            }
            paylistAAUI.dvQ.setText(spannableStringBuilder);
            paylistAAUI.getWindow().getDecorView().post(new Runnable(paylistAAUI) {
                final /* synthetic */ PaylistAAUI dvX;

                {
                    this.dvX = r1;
                }

                public final void run() {
                    int height = this.dvX.getWindow().getDecorView().getHeight();
                    int[] iArr = new int[2];
                    View findViewById = this.dvX.findViewById(2131758481);
                    findViewById.getLocationInWindow(iArr);
                    int height2 = iArr[1] + findViewById.getHeight();
                    int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this.dvX.nDR.nEl, 20);
                    int fromDPToPix2 = ((height - height2) - com.tencent.mm.bd.a.fromDPToPix(this.dvX.nDR.nEl, 24)) - com.tencent.mm.bd.a.fromDPToPix(this.dvX.nDR.nEl, 12);
                    if (fromDPToPix2 < fromDPToPix) {
                        fromDPToPix2 = fromDPToPix;
                    }
                    v.d("MicroMsg.PaylistAAUI", "height: %s, h1: %s, topMargin: %s", new Object[]{Integer.valueOf(height), Integer.valueOf(height2), Integer.valueOf(fromDPToPix2)});
                    LayoutParams layoutParams = (LayoutParams) this.dvX.dvQ.getLayoutParams();
                    layoutParams.topMargin = fromDPToPix2;
                    this.dvX.dvQ.setLayoutParams(layoutParams);
                }
            });
        }
    }

    static /* synthetic */ void f(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.dtK != null) {
            paylistAAUI.dtK.dismiss();
        }
        paylistAAUI.dtK = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.bKO().c(paylistAAUI.dvH.dtv).e(new a<Void, Boolean>(paylistAAUI) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final /* synthetic */ Object aq(Object obj) {
                v.i("MicroMsg.PaylistAAUI", "close pay list success: %s", new Object[]{(Boolean) obj});
                if (this.dvX.dtK != null) {
                    this.dvX.dtK.dismiss();
                }
                this.dvX.dvU = null;
                this.dvX.NZ();
                this.dvX.nDR.bAi();
                PaylistAAUI.h(this.dvX);
                return phb;
            }
        }).a(new d.a(paylistAAUI) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final void aA(Object obj) {
                v.i("MicroMsg.PaylistAAUI", "close pay list failed: %s", new Object[]{obj});
                if (this.dvX.dtK != null) {
                    this.dvX.dtK.dismiss();
                }
                if (obj instanceof String) {
                    Toast.makeText(this.dvX, obj.toString(), 1).show();
                } else {
                    Toast.makeText(this.dvX, 2131231942, 1).show();
                }
            }
        });
        com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(6)});
    }

    static /* synthetic */ void h(PaylistAAUI paylistAAUI) {
        Intent intent = new Intent();
        intent.putExtra("close_aa", true);
        intent.putExtra("item_position", paylistAAUI.getIntent().getIntExtra("item_position", 0));
        intent.putExtra("item_offset", paylistAAUI.getIntent().getIntExtra("item_offset", 0));
        paylistAAUI.setResult(-1, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dvX.finish();
                return false;
            }
        });
        vD(2131233493);
        vE(2131236646);
        this.dvT = getIntent().getStringExtra("chatroom");
        this.dvJ = (LinearLayout) findViewById(2131758484);
        this.dvK = (LinearLayout) findViewById(2131758486);
        this.dvL = (LinearLayout) findViewById(2131758495);
        this.dvO = (TextView) findViewById(2131758485);
        this.dup = findViewById(2131757667);
        this.dvP = (TextView) findViewById(2131758493);
        this.dvP.setClickable(true);
        this.dvP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.h(this));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(2131234159));
        spannableStringBuilder.setSpan(new a(new a.a(this) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final void ND() {
                com.tencent.mm.ui.base.g.a(this.dvX, 2131235732, -1, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass8 dwa;

                    {
                        this.dwa = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        PaylistAAUI.a(this.dwa.dvX);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass8 dwa;

                    {
                        this.dwa = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(7)});
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.dvP.setText(spannableStringBuilder);
        ((TextView) findViewById(2131758489)).setText(q.bLm());
        this.dvQ = (TextView) findViewById(2131758499);
        NZ();
    }

    private void NZ() {
        this.dtK = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        this.dup.setVisibility(4);
        com.tencent.mm.vending.g.g.bKO().c(this.dvH.dts).e(new a<Void, t>(this) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final /* synthetic */ Object aq(Object obj) {
                t tVar = (t) obj;
                if (tVar == null) {
                    v.e("MicroMsg.PaylistAAUI", "queryDetailRes is null!!!");
                    PaylistAAUI.a(this.dvX, null);
                } else {
                    v.i("MicroMsg.PaylistAAUI", "get queryDetailRes: %s, billNo: %s, type: %s, state: %s, is_launcher: %s, role: %s, role_state: %s, payer_list.size: %s", new Object[]{tVar, tVar.lYw, Integer.valueOf(tVar.type), Integer.valueOf(tVar.state), Integer.valueOf(tVar.lYX), Integer.valueOf(tVar.cqN), Integer.valueOf(tVar.lYY), Integer.valueOf(tVar.lYB.size())});
                    v.i("MicroMsg.PaylistAAUI", "paid_num: %s, plan_num: %s", new Object[]{Integer.valueOf(tVar.lYV), Integer.valueOf(tVar.lYT)});
                    this.dvX.dup.setVisibility(0);
                    this.dvX.dvU = tVar.lYR;
                    this.dvX.dvV = tVar.lYB.size() + 1;
                    this.dvX.title = tVar.title;
                    PaylistAAUI.a(this.dvX, tVar);
                    PaylistAAUI.b(this.dvX, tVar);
                    PaylistAAUI.c(this.dvX, tVar);
                    PaylistAAUI.d(this.dvX, tVar);
                    PaylistAAUI.e(this.dvX, tVar);
                    if (this.dvX.dtK != null) {
                        this.dvX.dtK.dismiss();
                        this.dvX.dtK = null;
                    }
                }
                return phb;
            }
        }).a(new d.a(this) {
            final /* synthetic */ PaylistAAUI dvX;

            {
                this.dvX = r1;
            }

            public final void aA(Object obj) {
                v.i("MicroMsg.PaylistAAUI", "onInterrupt: %s", new Object[]{obj});
                PaylistAAUI.a(this.dvX, obj == null ? "" : obj.toString());
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private static boolean v(int i, int i2, int i3) {
        return i == com.tencent.mm.plugin.aa.a.a.drK && i2 != com.tencent.mm.plugin.aa.a.a.drO && i3 == com.tencent.mm.plugin.aa.a.a.drG;
    }

    private void a(List<r> list, String str, boolean z) {
        ((TextView) findViewById(2131758492)).setText(str);
        this.dvP.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131758494);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z2;
            r rVar = (r) list.get(i);
            if (i >= list.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            a(linearLayout, rVar, z2);
        }
    }

    private void c(List<r> list, String str) {
        ((TextView) findViewById(2131758496)).setText(str);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131758497);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z;
            r rVar = (r) list.get(i);
            if (i >= list.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            a(linearLayout, rVar, z);
        }
    }

    private void a(LinearLayout linearLayout, r rVar, boolean z) {
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(2130904146, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(2131758478);
        TextView textView = (TextView) linearLayout2.findViewById(2131758479);
        TextView textView2 = (TextView) linearLayout2.findViewById(2131758480);
        View findViewById = linearLayout2.findViewById(2131755264);
        if (z) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        b.m(imageView, rVar.lYO);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, com.tencent.mm.model.l.D(rVar.lYO, this.dvI.pgh.getStringExtra("chatroom")), textView.getTextSize()));
        if (rVar.lYQ == com.tencent.mm.plugin.aa.a.a.drR) {
            textView2.setText(getString(2131234156, new Object[]{Double.valueOf(((double) rVar.lYE) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(2131689916));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else if (rVar.lYQ == com.tencent.mm.plugin.aa.a.a.drQ) {
            textView2.setText(getString(2131234147, new Object[]{Double.valueOf(((double) rVar.lYE) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(2131689918));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else {
            textView2.setVisibility(8);
            linearLayout.addView(linearLayout2);
        }
    }

    protected final int getLayoutId() {
        return 2130904147;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 233 && i2 == -1) {
            v.i("MicroMsg.PaylistAAUI", "pay success, payMsgId: %s", new Object[]{this.dvS});
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                v.i("MicroMsg.PaylistAAUI", "do realname guide");
                Intent intent2 = new Intent();
                intent2.putExtra("key_realname_guide_helper", realnameGuideHelper);
                com.tencent.mm.ay.c.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent2);
            }
            finish();
            com.tencent.mm.vending.g.g.a(this.dvS, this.dvU, this.dvW).c(this.dvH.dtu).e(new a<Void, Void>(this) {
                final /* synthetic */ PaylistAAUI dvX;

                {
                    this.dvX = r1;
                }

                public final /* synthetic */ Object aq(Object obj) {
                    v.i("MicroMsg.PaylistAAUI", "insert msg finish");
                    return phb;
                }
            });
            com.tencent.mm.plugin.report.service.g.iuh.a(407, 12, 1, false);
        }
    }
}
