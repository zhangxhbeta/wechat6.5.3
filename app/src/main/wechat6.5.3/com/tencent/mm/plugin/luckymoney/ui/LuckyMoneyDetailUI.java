package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.c.aa;
import com.tencent.mm.plugin.luckymoney.c.af;
import com.tencent.mm.plugin.luckymoney.c.ag;
import com.tencent.mm.plugin.luckymoney.c.e;
import com.tencent.mm.plugin.luckymoney.c.m;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.plugin.luckymoney.c.u;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private View PH;
    private TextView eWQ;
    private long evC = 0;
    private ImageView fCH;
    private boolean ffH = false;
    private View fgW;
    private TextView gNg;
    private ListView hdV;
    private ImageView hdW;
    private TextView hdX;
    private TextView hdY;
    private View hdZ;
    private ImageView heZ;
    private TextView hea;
    private LuckyMoneyWishFooter heb;
    private View hec;
    private ImageView hed;
    private View hee;
    private boolean heg = true;
    private int heh;
    private String hei;
    private String hej;
    private String hek;
    private String hel;
    private List<m> hen = new LinkedList();
    private Map<String, Integer> heo = new HashMap();
    private i hep;
    private String heq = "";
    private boolean her = false;
    OnScrollListener hes = new OnScrollListener(this) {
        private boolean het = false;
        private boolean heu;
        final /* synthetic */ LuckyMoneyDetailUI hfi;

        {
            this.hfi = r2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (absListView.getCount() != 0) {
                switch (i) {
                    case 0:
                        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                            if (!this.hfi.hdT.axG()) {
                                this.hfi.ffH = false;
                            }
                            if (this.hfi.heg && !this.hfi.ffH) {
                                this.hfi.ayh();
                            }
                        }
                        this.het = false;
                        return;
                    case 1:
                        this.het = true;
                        return;
                    default:
                        return;
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            if (i3 != 0 && this.het) {
                if (i <= 0) {
                    int top;
                    View childAt = absListView.getChildAt(i);
                    if (childAt != null) {
                        top = 0 - childAt.getTop();
                    } else {
                        top = 0;
                    }
                    if (top <= 100) {
                        z = false;
                    }
                }
                if (this.heu != z) {
                    if (z) {
                        this.hfi.q(this.hfi.getResources().getDrawable(2130838516));
                    } else {
                        this.hfi.q(null);
                    }
                    this.heu = z;
                }
            }
        }
    };
    private ImageView hfa;
    private View hfb;
    private ImageView hfc;
    private TextView hfd;
    private View hfe;
    private RelativeLayout hff;
    private final int hfg = 750;
    private final int hfh = 240;
    private int vI = 0;

    static /* synthetic */ void k(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = luckyMoneyDetailUI.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            v.i("MicroMsg.LuckyMoneyDetailUI", "hy: screen  width: %d, scale : %f, fixedHeight: %d", new Object[]{Integer.valueOf(displayMetrics.widthPixels), Double.valueOf(((double) displayMetrics.widthPixels) / 750.0d), Integer.valueOf((int) (240.0d * (((double) displayMetrics.widthPixels) / 750.0d)))});
            luckyMoneyDetailUI.hff.setLayoutParams(new LayoutParams(luckyMoneyDetailUI.hff.getLayoutParams().width, r1));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        this.hei = getIntent().getStringExtra("key_sendid");
        this.hek = getIntent().getStringExtra("key_native_url");
        this.heh = getIntent().getIntExtra("key_jump_from", 2);
        v.i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + be.ma(this.hei) + ", nativeurl=" + be.ma(this.hek) + ", jumpFrom=" + this.heh);
        if (this.heh == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (byteArrayExtra != null) {
                    e eVar = (e) new e().az(byteArrayExtra);
                    if (eVar != null) {
                        a(eVar);
                        if (getIntent().getBooleanExtra("play_sound", false)) {
                            k.cg(this);
                        }
                    }
                }
            } catch (Exception e) {
                v.w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (be.kS(this.hei) && !be.kS(this.hek)) {
            try {
                this.hei = Uri.parse(this.hek).getQueryParameter("sendid");
            } catch (Exception e2) {
            }
        }
        if (be.kS(this.hei)) {
            v.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
        } else {
            ayh();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
            k.cg(this);
        }
    }

    protected void onResume() {
        super.onResume();
        this.evC = be.Nh();
    }

    protected void onPause() {
        super.onPause();
        d.d("LuckyMoneyDetailUI", this.evC, be.Nh());
    }

    protected final void NI() {
        vD(2131233607);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI hfi;

            {
                this.hfi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hfi.finish();
                return true;
            }
        });
        this.hdV = (ListView) findViewById(2131757838);
        this.hep = new i(this.nDR.nEl);
        this.PH = LayoutInflater.from(this).inflate(2130903888, null);
        this.hdV.addHeaderView(this.PH);
        this.hdV.setAdapter(this.hep);
        this.PH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI hfi;

            {
                this.hfi = r1;
            }

            public final void onClick(View view) {
                this.hfi.ayi();
            }
        });
        this.hdV.setOnScrollListener(this.hes);
        this.hdV.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI hfi;

            {
                this.hfi = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.hfi.ayi();
            }
        });
        this.fgW = LayoutInflater.from(this).inflate(2130903887, null);
        this.hdW = (ImageView) this.PH.findViewById(2131757813);
        this.hdX = (TextView) this.PH.findViewById(2131757815);
        this.heZ = (ImageView) this.PH.findViewById(2131757816);
        this.hdY = (TextView) this.PH.findViewById(2131757817);
        this.hdZ = this.PH.findViewById(2131757818);
        this.hea = (TextView) this.PH.findViewById(2131757819);
        this.hec = this.PH.findViewById(2131757821);
        this.eWQ = (TextView) this.PH.findViewById(2131757823);
        this.hed = (ImageView) this.PH.findViewById(2131757822);
        this.gNg = (TextView) this.PH.findViewById(2131757835);
        this.hfa = (ImageView) this.PH.findViewById(2131757812);
        this.hee = this.PH.findViewById(2131757826);
        this.hfb = this.PH.findViewById(2131757824);
        this.hfc = (ImageView) this.PH.findViewById(2131757825);
        this.hfd = (TextView) this.PH.findViewById(2131757837);
        this.hfe = findViewById(2131757836);
        this.hff = (RelativeLayout) this.PH.findViewById(2131757824);
        this.fCH = (ImageView) this.PH.findViewById(2131757825);
        this.heb = (LuckyMoneyWishFooter) findViewById(2131757839);
        this.heb.a(new a(this) {
            final /* synthetic */ LuckyMoneyDetailUI hfi;

            {
                this.hfi = r1;
            }

            public final void ayj() {
                if (this.hfi.heb.getVisibility() == 0) {
                    this.hfi.heb.setVisibility(8);
                } else {
                    this.hfi.nDR.nEl.finish();
                }
            }
        });
        this.heb.a(new LuckyMoneyWishFooter.a(this) {
            final /* synthetic */ LuckyMoneyDetailUI hfi;

            {
                this.hfi = r1;
            }

            public final void we(String str) {
                if (!be.kS(str) && !be.kS(this.hfi.hej)) {
                    this.hfi.j(new aa(this.hfi.hei, str, this.hfi.hej, "v1.0"));
                    this.hfi.ayi();
                }
            }
        });
        this.heb.post(new Runnable(this) {
            final /* synthetic */ LuckyMoneyDetailUI hfi;

            {
                this.hfi = r1;
            }

            public final void run() {
                j.f(this.hfi);
            }
        });
        this.heb.nBa = new KeyboardLinearLayout.a(this) {
            final /* synthetic */ LuckyMoneyDetailUI hfi;

            {
                this.hfi = r1;
            }

            public final void mC(int i) {
                if (i == -2 && this.hfi.heb.hhN) {
                    this.hfi.heb.hhN = false;
                }
            }
        };
        this.hep.hhs = new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI hfi;

            {
                this.hfi = r1;
            }

            public final void onClick(View view) {
                this.hfi.heb.setVisibility(0);
            }
        };
        this.heb.ayz();
        this.hfd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI hfi;

            {
                this.hfi = r1;
            }

            public final void onClick(View view) {
                this.hfi.heb.setVisibility(0);
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.heb.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.heb.setVisibility(8);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof u) {
            if (i == 0 && i2 == 0) {
                u uVar = (u) kVar;
                e eVar = uVar.hbH;
                this.heq = uVar.hbT;
                a(eVar);
                return true;
            }
            g.bf(this, str);
            return true;
        } else if (kVar instanceof aa) {
            if (i == 0 && i2 == 0) {
                g.bf(this, getString(2131233278));
                this.hep.hhr = false;
                ayi();
                aa aaVar = (aa) kVar;
                if (this.hen != null) {
                    for (int i3 = 0; i3 < this.hen.size(); i3++) {
                        m mVar = (m) this.hen.get(i3);
                        if (mVar.haI.equalsIgnoreCase(aaVar.haI)) {
                            mVar.hbw = aaVar.hay;
                            this.hep.notifyDataSetChanged();
                            break;
                        }
                    }
                    if (this.hfd.getVisibility() == 0) {
                        this.hfd.setVisibility(8);
                        this.gNg.setVisibility(0);
                        this.hfe.setVisibility(8);
                        this.hep.aJ(this.hen);
                    }
                }
                return true;
            }
            g.bf(this, str);
            return true;
        } else if (!(kVar instanceof af)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.snackbar.a.f(this, getString(2131233278));
                return true;
            }
            g.bf(this, str);
            return true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!be.kS(stringExtra)) {
                        if (this.hel != null && this.hel.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            v.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            j(new af(stringExtra.replaceAll(",", "|"), this.hei, "v1.0"));
                            break;
                        }
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void finish() {
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            boolean a = realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ LuckyMoneyDetailUI hfi;

                {
                    this.hfi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
                    super.finish();
                }
            });
            getIntent().removeExtra("key_realname_guide_helper");
            if (!a) {
                super.finish();
                return;
            }
            return;
        }
        super.finish();
    }

    protected final int getLayoutId() {
        return 2130903889;
    }

    private void ayh() {
        this.ffH = true;
        if (this.vI <= 0 || this.hen.size() <= 0 || this.hen.get(this.hen.size() - 1) == null) {
            this.heq = "";
            j(new u(this.hei, 11, this.vI, this.hek, "v1.0", this.heq));
            return;
        }
        j(new u(this.hei, this.vI, this.hek, be.getLong(((m) this.hen.get(this.hen.size() - 1)).hbi, 0), "v1.0", this.heq));
    }

    private void a(final e eVar) {
        if (eVar != null) {
            this.heg = eVar.haL == 1;
            if (this.vI == 0) {
                this.hej = eVar.haI;
                Object obj = (eVar == null || eVar.hau != 0 || eVar.haY == null || eVar.haY.size() <= 0 || !((m) eVar.haY.get(0)).haI.equals(this.hej) || eVar.haJ == 1) ? null : 1;
                if (obj != null) {
                    this.hep.hhr = false;
                    this.hfd.setVisibility(0);
                    this.hfe.setVisibility(0);
                    this.gNg.setVisibility(8);
                } else {
                    this.gNg.setVisibility(0);
                    this.hep.hhq = this.hej;
                }
                this.hep.hht = eVar.haW;
                if (eVar != null) {
                    Context context = this.nDR.nEl;
                    if (eVar.haW == 2) {
                        this.hdW.setImageResource(2130838527);
                        if (eVar.resourceId != 0) {
                            v.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + eVar.resourceId);
                            final gh ghVar = new gh();
                            ghVar.bfN.bfP = eVar.resourceId;
                            ghVar.bpT = new Runnable(this) {
                                final /* synthetic */ LuckyMoneyDetailUI hfi;

                                public final void run() {
                                    if (ghVar.bfO.bfQ) {
                                        v.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + ghVar.bfO.bfR);
                                        n.i(this.hfi.hdW, ghVar.bfO.bfR);
                                        return;
                                    }
                                    v.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                                    n.h(this.hfi.hdW, eVar.haA);
                                }
                            };
                            com.tencent.mm.sdk.c.a.nhr.a(ghVar, Looper.myLooper());
                        } else {
                            n.h(this.hdW, eVar.haA);
                        }
                    } else {
                        n.h(this.hdW, eVar.haA);
                    }
                    n.a(context, this.hdX, eVar.haz);
                    n.a(context, this.hdY, eVar.hay);
                    if (eVar.hau == 1) {
                        this.heZ.setVisibility(0);
                    } else {
                        this.heZ.setVisibility(8);
                    }
                    if (!be.kS(eVar.haU)) {
                        n.g(this.hfa, eVar.haU);
                        this.hfa.setScaleType(ScaleType.FIT_XY);
                    }
                    if (be.kS(eVar.haV)) {
                        v.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
                        this.hff.setVisibility(8);
                    } else {
                        v.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[]{eVar.haV});
                        this.hff.setVisibility(4);
                        n.e(this.fCH, eVar.haV);
                        ad.g(new Runnable(this) {
                            final /* synthetic */ LuckyMoneyDetailUI hfi;

                            {
                                this.hfi = r1;
                            }

                            public final void run() {
                                LuckyMoneyDetailUI.k(this.hfi);
                                this.hfi.hff.setVisibility(0);
                            }
                        }, 500);
                    }
                    if (eVar.haN != 2 || this.heh == 3) {
                        this.hdZ.setVisibility(8);
                    } else {
                        this.hea.setText(com.tencent.mm.wallet_core.ui.e.m(((double) eVar.bst) / 100.0d));
                        if (eVar.haJ != 1) {
                            this.hep.hhr = true;
                        } else {
                            this.hep.hhr = false;
                        }
                        this.hdZ.setVisibility(0);
                    }
                    if (be.kS(eVar.haR)) {
                        v.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                        this.hec.setVisibility(8);
                    } else {
                        this.hec.setVisibility(0);
                        this.eWQ.setText(eVar.haR);
                        if (eVar.haQ == 1) {
                            if (TextUtils.isEmpty(eVar.haZ) || eVar.haZ.startsWith("weixin://wxpay")) {
                                this.hed.setVisibility(8);
                            } else {
                                this.hed.setVisibility(0);
                            }
                            this.eWQ.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ LuckyMoneyDetailUI hfi;

                                public final void onClick(View view) {
                                    if (TextUtils.isEmpty(eVar.haZ)) {
                                        com.tencent.mm.wallet_core.ui.e.yD(12);
                                        com.tencent.mm.pluginsdk.wallet.e.L(this.hfi.nDR.nEl, 1);
                                        com.tencent.mm.plugin.report.service.g.iuh.h(13184, new Object[]{Integer.valueOf(0), ""});
                                        v.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
                                        return;
                                    }
                                    v.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + eVar.haZ);
                                    if (eVar.haZ.startsWith("weixin://wxpay")) {
                                        com.tencent.mm.wallet_core.ui.e.yD(12);
                                        com.tencent.mm.pluginsdk.wallet.e.L(this.hfi.nDR.nEl, 1);
                                        com.tencent.mm.plugin.report.service.g.iuh.h(13184, new Object[]{Integer.valueOf(0), eVar.haZ});
                                        return;
                                    }
                                    com.tencent.mm.wallet_core.ui.e.yD(7);
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", eVar.haZ);
                                    c.b(this.hfi.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.g.iuh.h(13184, new Object[]{Integer.valueOf(1), eVar.haZ});
                                }
                            });
                        } else {
                            v.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                            this.eWQ.setTextColor(getResources().getColor(2131689852));
                        }
                    }
                    if (be.kS(eVar.haM)) {
                        this.gNg.setText(null);
                    } else {
                        this.gNg.setText(eVar.haM);
                    }
                }
                if (eVar != null) {
                    ViewGroup viewGroup;
                    List list = eVar.haS;
                    if (list != null && list.size() > 0) {
                        View findViewById = this.PH.findViewById(2131757827);
                        View findViewById2 = this.PH.findViewById(2131757830);
                        View findViewById3 = this.PH.findViewById(2131757833);
                        viewGroup = (ViewGroup) this.PH.findViewById(2131757828);
                        ViewGroup viewGroup2 = (ViewGroup) this.PH.findViewById(2131757831);
                        ViewGroup viewGroup3 = (ViewGroup) this.PH.findViewById(2131757834);
                        View findViewById4 = this.PH.findViewById(2131757829);
                        View findViewById5 = this.PH.findViewById(2131757832);
                        g.c cVar = new g.c();
                        cVar.textColor = getResources().getColor(2131689842);
                        if (list.size() > 0) {
                            g.a(this, viewGroup, (ag) list.get(0), cVar);
                            findViewById.setVisibility(0);
                        }
                        if (list.size() > 1) {
                            g.a(this, viewGroup2, (ag) list.get(1), cVar);
                            findViewById2.setVisibility(0);
                        }
                        if (list.size() > 2) {
                            g.a(this, viewGroup3, (ag) list.get(2), cVar);
                            findViewById3.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                            findViewById4.setVisibility(0);
                        }
                        if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                            findViewById5.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                            this.hee.requestLayout();
                            this.hee.setVisibility(0);
                        }
                    }
                    viewGroup = (ViewGroup) this.fgW.findViewById(2131757811);
                    g.c cVar2 = new g.c();
                    cVar2.textColor = getResources().getColor(2131689842);
                    cVar2.textSize = getResources().getDimensionPixelSize(2131493202);
                    g.a(this, viewGroup, eVar.haT, cVar2);
                }
                com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(mA(eVar.haW)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
            }
            if (eVar != null) {
                Object obj2 = ((eVar.hav == 3 || eVar.hav == 2) && eVar.haK == 1 && !this.heg && eVar.haO == 1) ? 1 : null;
                Object obj3 = (eVar.haP == null || eVar.haP.cdf != 1 || be.kS(eVar.haP.hae)) ? null : 1;
                TextView textView = (TextView) this.fgW.findViewById(2131757809);
                if (obj2 == null && obj3 == null) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyDetailUI hfi;

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(LuckyMoneyDetailUI.mA(eVar.haW)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                            n.c(this.hfi, 1);
                        }
                    });
                    if (obj3 != null) {
                        this.hel = eVar.haP.hae;
                        textView.setText(eVar.haP.haf);
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(mA(eVar.haW)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                    textView.setVisibility(0);
                }
                TextView textView2 = (TextView) this.fgW.findViewById(2131757810);
                if (this.heh == 1 || this.heh == 3 || textView.getVisibility() == 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyDetailUI hfi;

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(LuckyMoneyDetailUI.mA(eVar.haW)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                            Intent intent = new Intent();
                            intent.setClass(this.hfi.nDR.nEl, LuckyMoneyMyRecordUI.class);
                            intent.putExtra("key_type", 2);
                            this.hfi.startActivity(intent);
                        }
                    });
                    textView2.setVisibility(0);
                }
                if (!this.her) {
                    this.hdV.addFooterView(this.fgW);
                    this.her = true;
                }
            }
            List list2 = eVar.haY;
            if (list2 != null) {
                for (int i = 0; i < list2.size(); i++) {
                    m mVar = (m) list2.get(i);
                    if (!this.heo.containsKey(mVar.haI)) {
                        this.hen.add(list2.get(i));
                        this.heo.put(mVar.haI, Integer.valueOf(1));
                    }
                }
                this.vI += list2.size();
                this.ffH = false;
                if (this.hfd.getVisibility() != 0) {
                    this.gNg.setVisibility(0);
                    this.hep.aJ(this.hen);
                }
            }
        }
    }

    private void ayi() {
        if (this.heb != null && this.heb.getVisibility() != 8) {
            this.heb.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.heb != null) {
            this.heb.ayA();
        }
    }

    private static int mA(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
