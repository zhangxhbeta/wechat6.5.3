package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.luckymoney.c.aa;
import com.tencent.mm.plugin.luckymoney.c.af;
import com.tencent.mm.plugin.luckymoney.c.e;
import com.tencent.mm.plugin.luckymoney.c.m;
import com.tencent.mm.plugin.luckymoney.c.u;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(3)
public class LuckyMoneyBusiDetailUI extends LuckyMoneyBaseUI {
    private View PH;
    private TextView eWQ;
    private boolean ffH = false;
    private View fgW;
    private TextView gNg;
    private ListView hdV;
    private ImageView hdW;
    private TextView hdX;
    private TextView hdY;
    private View hdZ;
    private TextView hea;
    private LuckyMoneyWishFooter heb;
    private View hec;
    private ImageView hed;
    private View hee;
    private ImageView hef;
    private boolean heg = true;
    private int heh;
    private String hei;
    private String hej;
    private String hek;
    private String hel;
    private int hem = 0;
    private List<m> hen = new LinkedList();
    private Map<String, Integer> heo = new HashMap();
    private i hep;
    private String heq = "";
    private boolean her = false;
    OnScrollListener hes = new OnScrollListener(this) {
        private boolean het = false;
        private boolean heu;
        final /* synthetic */ LuckyMoneyBusiDetailUI hev;

        {
            this.hev = r2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (absListView.getCount() != 0) {
                switch (i) {
                    case 0:
                        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                            if (!this.hev.hdT.axG()) {
                                this.hev.ffH = false;
                            }
                            if (this.hev.heg && !this.hev.ffH) {
                                this.hev.ayh();
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
                        this.hev.q(this.hev.getResources().getDrawable(2130838516));
                    } else {
                        this.hev.q(null);
                    }
                    this.heu = z;
                }
            }
        }
    };
    private int vI = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hdV = (ListView) findViewById(2131757788);
        this.hep = new i(this.nDR.nEl);
        this.PH = LayoutInflater.from(this).inflate(2130903884, null);
        this.hdV.addHeaderView(this.PH);
        this.hdV.setAdapter(this.hep);
        this.PH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI hev;

            {
                this.hev = r1;
            }

            public final void onClick(View view) {
                this.hev.ayi();
            }
        });
        this.hdV.setOnScrollListener(this.hes);
        this.hdV.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI hev;

            {
                this.hev = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.hev.ayi();
            }
        });
        this.fgW = LayoutInflater.from(this).inflate(2130903883, null);
        this.hdW = (ImageView) this.PH.findViewById(2131757769);
        this.hdX = (TextView) this.PH.findViewById(2131757770);
        this.hdY = (TextView) this.PH.findViewById(2131757771);
        this.hdZ = this.PH.findViewById(2131757772);
        this.hea = (TextView) this.PH.findViewById(2131757773);
        this.hec = this.PH.findViewById(2131757774);
        this.eWQ = (TextView) this.PH.findViewById(2131757776);
        this.hed = (ImageView) this.PH.findViewById(2131757775);
        this.gNg = (TextView) this.PH.findViewById(2131757786);
        this.hee = this.PH.findViewById(2131757777);
        this.hef = (ImageView) this.PH.findViewById(2131757768);
        ImageView imageView = (ImageView) findViewById(2131757787);
        this.heb = (LuckyMoneyWishFooter) findViewById(2131757790);
        this.heb.a(new MMEditText.a(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI hev;

            {
                this.hev = r1;
            }

            public final void ayj() {
                if (this.hev.heb.getVisibility() == 0) {
                    this.hev.heb.setVisibility(8);
                } else {
                    this.hev.nDR.nEl.finish();
                }
            }
        });
        this.heb.a(new LuckyMoneyWishFooter.a(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI hev;

            {
                this.hev = r1;
            }

            public final void we(String str) {
                if (!be.kS(str) && !be.kS(this.hev.hej)) {
                    this.hev.j(new aa(this.hev.hei, str, this.hev.hej, "v1.0"));
                    this.hev.ayi();
                }
            }
        });
        this.heb.post(new Runnable(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI hev;

            {
                this.hev = r1;
            }

            public final void run() {
                j.f(this.hev);
            }
        });
        this.heb.nBa = new KeyboardLinearLayout.a(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI hev;

            {
                this.hev = r1;
            }

            public final void mC(int i) {
                if (i == -2 && this.hev.heb.hhN) {
                    this.hev.heb.hhN = false;
                }
            }
        };
        this.hep.hhs = new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI hev;

            {
                this.hev = r1;
            }

            public final void onClick(View view) {
                this.hev.heb.setVisibility(0);
            }
        };
        i iVar = this.hep;
        iVar.hhu = new a(iVar);
        this.heb.ayz();
        imageView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI hev;

            {
                this.hev = r1;
            }

            public final void onClick(View view) {
                this.hev.finish();
            }
        });
        View findViewById = findViewById(2131757789);
        if (findViewById != null) {
            Drawable background = findViewById.getBackground();
            if (background != null && (background instanceof BitmapDrawable)) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
                bitmapDrawable.mutate();
                bitmapDrawable.setTileModeX(TileMode.REPEAT);
            }
        }
        this.hei = getIntent().getStringExtra("key_sendid");
        this.hek = getIntent().getStringExtra("key_native_url");
        this.heh = getIntent().getIntExtra("key_jump_from", 2);
        this.hem = getIntent().getIntExtra("key_static_from_scene", 0);
        v.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[]{this.hei, this.hek, Integer.valueOf(this.heh)});
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
                v.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (be.kS(this.hei) && !be.kS(this.hek)) {
            try {
                this.hei = Uri.parse(this.hek).getQueryParameter("sendid");
            } catch (Exception e2) {
                v.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + e2.getLocalizedMessage());
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
                }
                return true;
            }
            g.bf(this, str);
            return true;
        } else if (!(kVar instanceof af)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                g.bf(this, getString(2131233278));
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
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
            boolean a = realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ LuckyMoneyBusiDetailUI hev;

                {
                    this.hev = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
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
        return 2130903885;
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.tencent.mm.plugin.luckymoney.c.e r13) {
        /*
        r12 = this;
        if (r13 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r13.haL;
        r1 = 1;
        if (r0 != r1) goto L_0x0348;
    L_0x0008:
        r0 = 1;
    L_0x0009:
        r12.heg = r0;
        r0 = r12.vI;
        if (r0 != 0) goto L_0x024a;
    L_0x000f:
        r0 = r13.haI;
        r12.hej = r0;
        r0 = r12.hep;
        r1 = r12.hej;
        r0.hhq = r1;
        r0 = r12.hep;
        r1 = r13.haW;
        r0.hht = r1;
        if (r13 == 0) goto L_0x00ec;
    L_0x0021:
        r0 = r12.nDR;
        r0 = r0.nEl;
        r1 = r13.haW;
        r2 = 2;
        if (r1 != r2) goto L_0x0353;
    L_0x002a:
        r1 = r12.hdW;
        r2 = 2130838527; // 0x7f0203ff float:1.7282039E38 double:1.052774113E-314;
        r1.setImageResource(r2);
        r1 = r13.resourceId;
        if (r1 == 0) goto L_0x034b;
    L_0x0036:
        r1 = "MicroMsg.LuckyMoneyDetailUI";
        r2 = new java.lang.StringBuilder;
        r3 = "busi logo load from file:";
        r2.<init>(r3);
        r3 = r13.resourceId;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r1, r2);
        r1 = new com.tencent.mm.e.a.gh;
        r1.<init>();
        r2 = r1.bfN;
        r3 = r13.resourceId;
        r2.bfP = r3;
        r2 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$3;
        r2.<init>(r12, r1, r13);
        r1.bpT = r2;
        r2 = com.tencent.mm.sdk.c.a.nhr;
        r3 = android.os.Looper.myLooper();
        r2.a(r1, r3);
    L_0x0069:
        r1 = r12.hdX;
        r2 = r13.haz;
        com.tencent.mm.plugin.luckymoney.c.n.a(r0, r1, r2);
        r1 = r12.hdY;
        r2 = r13.hay;
        com.tencent.mm.plugin.luckymoney.c.n.a(r0, r1, r2);
        r0 = r13.haN;
        r1 = 2;
        if (r0 != r1) goto L_0x0363;
    L_0x007c:
        r0 = r12.heh;
        r1 = 3;
        if (r0 == r1) goto L_0x0363;
    L_0x0081:
        r0 = r12.hea;
        r2 = r13.bst;
        r2 = (double) r2;
        r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = r2 / r4;
        r1 = com.tencent.mm.wallet_core.ui.e.m(r2);
        r0.setText(r1);
        r0 = r13.haJ;
        r1 = 1;
        if (r0 == r1) goto L_0x035c;
    L_0x0095:
        r0 = r12.hep;
        r1 = 1;
        r0.hhr = r1;
    L_0x009a:
        r0 = r12.hdZ;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x00a0:
        r0 = r13.haR;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x0390;
    L_0x00a8:
        r0 = r12.hec;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r12.eWQ;
        r1 = r13.haR;
        r0.setText(r1);
        r0 = r13.haQ;
        r1 = 1;
        if (r0 != r1) goto L_0x0375;
    L_0x00ba:
        r0 = r13.haZ;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x036c;
    L_0x00c2:
        r0 = r13.haZ;
        r1 = "weixin://wxpay";
        r0 = r0.startsWith(r1);
        if (r0 != 0) goto L_0x036c;
    L_0x00cd:
        r0 = r12.hed;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x00d3:
        r0 = r12.eWQ;
        r1 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$4;
        r1.<init>(r12, r13);
        r0.setOnClickListener(r1);
    L_0x00dd:
        r0 = r13.haM;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x03a2;
    L_0x00e5:
        r0 = r12.gNg;
        r1 = r13.haM;
        r0.setText(r1);
    L_0x00ec:
        if (r13 == 0) goto L_0x0213;
    L_0x00ee:
        r4 = r13.haS;
        if (r4 == 0) goto L_0x01e4;
    L_0x00f2:
        r0 = r4.size();
        if (r0 <= 0) goto L_0x01e4;
    L_0x00f8:
        r0 = r12.PH;
        r1 = 2131757778; // 0x7f100ad2 float:1.9146501E38 double:1.0532282834E-314;
        r5 = r0.findViewById(r1);
        r0 = r12.PH;
        r1 = 2131757781; // 0x7f100ad5 float:1.9146507E38 double:1.053228285E-314;
        r6 = r0.findViewById(r1);
        r0 = r12.PH;
        r1 = 2131757784; // 0x7f100ad8 float:1.9146514E38 double:1.0532282863E-314;
        r7 = r0.findViewById(r1);
        r0 = r12.PH;
        r1 = 2131757779; // 0x7f100ad3 float:1.9146503E38 double:1.053228284E-314;
        r0 = r0.findViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        r1 = r12.PH;
        r2 = 2131757782; // 0x7f100ad6 float:1.914651E38 double:1.0532282853E-314;
        r1 = r1.findViewById(r2);
        r1 = (android.view.ViewGroup) r1;
        r2 = r12.PH;
        r3 = 2131757785; // 0x7f100ad9 float:1.9146516E38 double:1.053228287E-314;
        r2 = r2.findViewById(r3);
        r2 = (android.view.ViewGroup) r2;
        r3 = r12.PH;
        r8 = 2131757780; // 0x7f100ad4 float:1.9146505E38 double:1.0532282844E-314;
        r8 = r3.findViewById(r8);
        r3 = r12.PH;
        r9 = 2131757783; // 0x7f100ad7 float:1.9146512E38 double:1.053228286E-314;
        r9 = r3.findViewById(r9);
        r10 = new com.tencent.mm.plugin.luckymoney.ui.g$c;
        r10.<init>();
        r3 = r12.getResources();
        r11 = 2131689839; // 0x7f0f016f float:1.9008705E38 double:1.053194717E-314;
        r3 = r3.getColor(r11);
        r10.textColor = r3;
        r3 = 1;
        r10.hgO = r3;
        r3 = r13.resourceId;
        r10.resourceId = r3;
        r3 = r12.hem;
        r10.hgP = r3;
        r3 = r4.size();
        if (r3 <= 0) goto L_0x0177;
    L_0x0169:
        r3 = 0;
        r3 = r4.get(r3);
        r3 = (com.tencent.mm.plugin.luckymoney.c.ag) r3;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r0, r3, r10);
        r0 = 0;
        r5.setVisibility(r0);
    L_0x0177:
        r0 = r4.size();
        r3 = 1;
        if (r0 <= r3) goto L_0x018c;
    L_0x017e:
        r0 = 1;
        r0 = r4.get(r0);
        r0 = (com.tencent.mm.plugin.luckymoney.c.ag) r0;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r1, r0, r10);
        r0 = 0;
        r6.setVisibility(r0);
    L_0x018c:
        r0 = r4.size();
        r1 = 2;
        if (r0 <= r1) goto L_0x01a1;
    L_0x0193:
        r0 = 2;
        r0 = r4.get(r0);
        r0 = (com.tencent.mm.plugin.luckymoney.c.ag) r0;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r2, r0, r10);
        r0 = 0;
        r7.setVisibility(r0);
    L_0x01a1:
        r0 = r5.getVisibility();
        if (r0 != 0) goto L_0x01b7;
    L_0x01a7:
        r0 = r6.getVisibility();
        if (r0 == 0) goto L_0x01b3;
    L_0x01ad:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01b7;
    L_0x01b3:
        r0 = 0;
        r8.setVisibility(r0);
    L_0x01b7:
        r0 = r6.getVisibility();
        if (r0 != 0) goto L_0x01c7;
    L_0x01bd:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01c7;
    L_0x01c3:
        r0 = 0;
        r9.setVisibility(r0);
    L_0x01c7:
        r0 = r5.getVisibility();
        if (r0 == 0) goto L_0x01d9;
    L_0x01cd:
        r0 = r6.getVisibility();
        if (r0 == 0) goto L_0x01d9;
    L_0x01d3:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01e4;
    L_0x01d9:
        r0 = r12.hee;
        r0.requestLayout();
        r0 = r12.hee;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x01e4:
        r0 = r12.fgW;
        r1 = 2131757766; // 0x7f100ac6 float:1.9146477E38 double:1.0532282774E-314;
        r0 = r0.findViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        r1 = new com.tencent.mm.plugin.luckymoney.ui.g$c;
        r1.<init>();
        r2 = r12.getResources();
        r3 = 2131689839; // 0x7f0f016f float:1.9008705E38 double:1.053194717E-314;
        r2 = r2.getColor(r3);
        r1.textColor = r2;
        r2 = r12.getResources();
        r3 = 2131493202; // 0x7f0c0152 float:1.8609877E38 double:1.0530975655E-314;
        r2 = r2.getDimensionPixelSize(r3);
        r1.textSize = r2;
        r2 = r13.haT;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r0, r2, r1);
    L_0x0213:
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r1 = 11701; // 0x2db5 float:1.6397E-41 double:5.781E-320;
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r13.haW;
        r4 = mA(r4);
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
    L_0x024a:
        if (r13 == 0) goto L_0x0313;
    L_0x024c:
        r0 = r13.hav;
        r1 = 3;
        if (r0 == r1) goto L_0x0256;
    L_0x0251:
        r0 = r13.hav;
        r1 = 2;
        if (r0 != r1) goto L_0x03aa;
    L_0x0256:
        r0 = r13.haK;
        r1 = 1;
        if (r0 != r1) goto L_0x03aa;
    L_0x025b:
        r0 = r12.heg;
        if (r0 != 0) goto L_0x03aa;
    L_0x025f:
        r0 = r13.haO;
        r1 = 1;
        if (r0 != r1) goto L_0x03aa;
    L_0x0264:
        r0 = 1;
        r1 = r0;
    L_0x0266:
        r0 = r13.haP;
        if (r0 == 0) goto L_0x03ae;
    L_0x026a:
        r0 = r13.haP;
        r0 = r0.cdf;
        r2 = 1;
        if (r0 != r2) goto L_0x03ae;
    L_0x0271:
        r0 = r13.haP;
        r0 = r0.hae;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 != 0) goto L_0x03ae;
    L_0x027b:
        r0 = 1;
        r2 = r0;
    L_0x027d:
        r0 = r12.fgW;
        r3 = 2131757764; // 0x7f100ac4 float:1.9146473E38 double:1.0532282764E-314;
        r0 = r0.findViewById(r3);
        r0 = (android.widget.TextView) r0;
        if (r1 != 0) goto L_0x028c;
    L_0x028a:
        if (r2 == 0) goto L_0x03b2;
    L_0x028c:
        r1 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$5;
        r1.<init>(r12, r13);
        r0.setOnClickListener(r1);
        if (r2 == 0) goto L_0x02a3;
    L_0x0296:
        r1 = r13.haP;
        r1 = r1.hae;
        r12.hel = r1;
        r1 = r13.haP;
        r1 = r1.haf;
        r0.setText(r1);
    L_0x02a3:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 11701; // 0x2db5 float:1.6397E-41 double:5.781E-320;
        r3 = 5;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r13.haW;
        r5 = mA(r5);
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 2;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 3;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 4;
        r5 = 2;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r1.h(r2, r3);
        r1 = 0;
        r0.setVisibility(r1);
    L_0x02de:
        r1 = r12.fgW;
        r2 = 2131757765; // 0x7f100ac5 float:1.9146475E38 double:1.053228277E-314;
        r1 = r1.findViewById(r2);
        r1 = (android.widget.TextView) r1;
        r2 = r12.heh;
        r3 = 1;
        if (r2 == r3) goto L_0x03b9;
    L_0x02ee:
        r2 = r12.heh;
        r3 = 3;
        if (r2 == r3) goto L_0x03b9;
    L_0x02f3:
        r0 = r0.getVisibility();
        if (r0 == 0) goto L_0x03b9;
    L_0x02f9:
        r0 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$6;
        r0.<init>(r12, r13);
        r1.setOnClickListener(r0);
        r0 = 0;
        r1.setVisibility(r0);
    L_0x0305:
        r0 = r12.her;
        if (r0 != 0) goto L_0x0313;
    L_0x0309:
        r0 = r12.hdV;
        r1 = r12.fgW;
        r0.addFooterView(r1);
        r0 = 1;
        r12.her = r0;
    L_0x0313:
        r2 = r13.haY;
        if (r2 == 0) goto L_0x03d3;
    L_0x0317:
        r0 = 0;
        r1 = r0;
    L_0x0319:
        r0 = r2.size();
        if (r1 >= r0) goto L_0x03c0;
    L_0x031f:
        r0 = r2.get(r1);
        r0 = (com.tencent.mm.plugin.luckymoney.c.m) r0;
        r3 = r12.heo;
        r4 = r0.haI;
        r3 = r3.containsKey(r4);
        if (r3 != 0) goto L_0x0344;
    L_0x032f:
        r3 = r12.hen;
        r4 = r2.get(r1);
        r3.add(r4);
        r3 = r12.heo;
        r0 = r0.haI;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r3.put(r0, r4);
    L_0x0344:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0319;
    L_0x0348:
        r0 = 0;
        goto L_0x0009;
    L_0x034b:
        r1 = r13.haA;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 != 0) goto L_0x0069;
    L_0x0353:
        r1 = r12.hdW;
        r2 = r13.haA;
        com.tencent.mm.plugin.luckymoney.c.n.h(r1, r2);
        goto L_0x0069;
    L_0x035c:
        r0 = r12.hep;
        r1 = 0;
        r0.hhr = r1;
        goto L_0x009a;
    L_0x0363:
        r0 = r12.hdZ;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00a0;
    L_0x036c:
        r0 = r12.hed;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00d3;
    L_0x0375:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "detail.jumpChange is false";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r0 = r12.eWQ;
        r1 = r12.getResources();
        r2 = 2131689852; // 0x7f0f017c float:1.9008731E38 double:1.0531947235E-314;
        r1 = r1.getColor(r2);
        r0.setTextColor(r1);
        goto L_0x00dd;
    L_0x0390:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "detail.changeWording is empty";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        r0 = r12.hec;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00dd;
    L_0x03a2:
        r0 = r12.gNg;
        r1 = 0;
        r0.setText(r1);
        goto L_0x00ec;
    L_0x03aa:
        r0 = 0;
        r1 = r0;
        goto L_0x0266;
    L_0x03ae:
        r0 = 0;
        r2 = r0;
        goto L_0x027d;
    L_0x03b2:
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x02de;
    L_0x03b9:
        r0 = 8;
        r1.setVisibility(r0);
        goto L_0x0305;
    L_0x03c0:
        r0 = r12.vI;
        r1 = r2.size();
        r0 = r0 + r1;
        r12.vI = r0;
        r0 = 0;
        r12.ffH = r0;
        r0 = r12.hep;
        r1 = r12.hen;
        r0.aJ(r1);
    L_0x03d3:
        r0 = r13.haV;
        r1 = r13.hba;
        r2 = r12.hef;
        r3 = 2130838526; // 0x7f0203fe float:1.7282037E38 double:1.0527741125E-314;
        r2.setImageResource(r3);
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r2 == 0) goto L_0x0449;
    L_0x03e5:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "renderAdImage: no adImage";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = r12.hef;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x03f5:
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r1 = 13051; // 0x32fb float:1.8288E-41 double:6.448E-320;
        r2 = 10;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.hem;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r13.haV;
        r2[r3] = r4;
        r3 = 3;
        r4 = r13.haS;
        r4 = com.tencent.mm.plugin.luckymoney.c.n.aI(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = "";
        r2[r3] = r4;
        r3 = 5;
        r4 = "";
        r2[r3] = r4;
        r3 = 6;
        r4 = "";
        r2[r3] = r4;
        r3 = 7;
        r4 = "";
        r2[r3] = r4;
        r3 = 8;
        r4 = r13.haz;
        r2[r3] = r4;
        r3 = 9;
        r4 = r13.resourceId;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        goto L_0x0002;
    L_0x0449:
        r2 = new android.util.DisplayMetrics;
        r2.<init>();
        r2 = com.tencent.mm.sdk.platformtools.aa.getContext();
        r2 = r2.getResources();
        r2 = r2.getDisplayMetrics();
        if (r2 == 0) goto L_0x048c;
    L_0x045c:
        r2 = r2.widthPixels;
        r3 = r12.getResources();
        r4 = 2131493483; // 0x7f0c026b float:1.8610447E38 double:1.0530977043E-314;
        r3 = r3.getDimensionPixelSize(r4);
        r3 = r3 * 2;
        r2 = r2 - r3;
        r3 = r12.getResources();
        r4 = 2131493482; // 0x7f0c026a float:1.8610445E38 double:1.053097704E-314;
        r3 = r3.getDimensionPixelSize(r4);
        r3 = r3 * 2;
        r2 = r2 - r3;
        r2 = (float) r2;
        r3 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
        r2 = r2 * r3;
        r2 = (int) r2;
        r3 = r12.hef;
        r3 = r3.getLayoutParams();
        r3.height = r2;
        r2 = r12.hef;
        r2.setLayoutParams(r3);
    L_0x048c:
        r2 = r12.hef;
        r3 = 0;
        com.tencent.mm.plugin.luckymoney.c.n.a(r2, r0, r1, r3);
        r0 = r12.hef;
        r1 = 0;
        r0.setVisibility(r1);
        goto L_0x03f5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.a(com.tencent.mm.plugin.luckymoney.c.e):void");
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
