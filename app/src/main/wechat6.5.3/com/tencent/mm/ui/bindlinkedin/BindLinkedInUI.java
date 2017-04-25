package com.tencent.mm.ui.bindlinkedin;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ag.b;
import com.tencent.mm.ak.j;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.v.e;

public class BindLinkedInUI extends MMActivity implements e {
    private String bCv;
    private String bCw;
    private ProgressDialog eLA;
    private boolean hWA = false;
    private String name;
    private String oeC;
    private boolean oeD = false;
    private boolean oeE = false;
    private boolean oeF = false;
    private Bundle oeG;
    private boolean oeH = false;
    private boolean oeI = false;
    private TextView oeJ;
    private TextView oeK;
    private View oeL;
    private MMSwitchBtn oeM;
    private TextView oeN;
    private TextView oeO;
    private TextView oeP;
    private String oeQ;
    private String oeR;
    private String oeS;
    private String oeT;
    private int status;

    static /* synthetic */ void c(BindLinkedInUI bindLinkedInUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "http://www.linkedin.com/bind/plugin/");
        intent.putExtra("geta8key_username", k.xF());
        if (bindLinkedInUI.oeF) {
            intent.putExtra("geta8key_scene", 3);
        } else {
            intent.putExtra("geta8key_scene", 8);
        }
        c.b(bindLinkedInUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 100);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(549, this);
        ak.vy().a(550, this);
        this.oeG = getIntent().getBundleExtra("qrcode_bundle");
        this.oeE = this.oeG != null;
        if (this.oeG != null) {
            this.bCv = this.oeG.getString("i");
            this.bCw = this.oeG.getString("n");
            this.oeQ = this.oeG.getString("t");
            this.oeR = this.oeG.getString("o");
            this.oeS = this.oeG.getString("s");
            this.oeT = this.oeG.getString("r");
            if (this.bCv == null || this.bCw == null || this.oeQ == null || this.oeS == null || this.oeT == null) {
                g.a(this, getString(2131232067), null, false, new OnClickListener(this) {
                    final /* synthetic */ BindLinkedInUI oeU;

                    {
                        this.oeU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oeU.goBack();
                    }
                });
            }
        }
        this.oeF = getIntent().getBooleanExtra("oversea_entry", false);
        NH();
        if (this.oeE) {
            this.oeD = true;
        }
        NI();
        if (this.oeG != null && this.hWA && this.oeC.equals(this.bCv)) {
            this.oeH = true;
            jB(true);
        }
    }

    protected void onDestroy() {
        ak.vy().b(550, this);
        ak.vy().b(549, this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130903170;
    }

    private void NH() {
        boolean z = true;
        ak.yW();
        this.oeC = (String) com.tencent.mm.model.c.vf().get(286721, null);
        this.hWA = !be.kS(this.oeC);
        ak.yW();
        this.name = (String) com.tencent.mm.model.c.vf().get(286722, null);
        this.status = k.xJ();
        if ((this.status & 4194304) == 0) {
            z = false;
        }
        this.oeD = z;
    }

    protected final void NI() {
        if (this.oeE) {
            vD(2131232077);
        } else if (this.oeF) {
            vD(2131232080);
        } else {
            vD(2131232070);
        }
        this.oeJ = (TextView) findViewById(2131755604);
        this.oeK = (TextView) findViewById(2131755603);
        this.oeL = findViewById(2131755605);
        this.oeM = (MMSwitchBtn) findViewById(2131755606);
        this.oeN = (TextView) findViewById(2131755607);
        this.oeO = (TextView) findViewById(2131755608);
        this.oeP = (TextView) findViewById(2131755609);
        this.oeJ.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindLinkedInUI oeU;

            {
                this.oeU = r1;
            }

            public final void onClick(View view) {
                ak.yW();
                String str = (String) com.tencent.mm.model.c.vf().get(286723, null);
                if (!be.kS(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", k.xF());
                    c.b(this.oeU, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            }
        });
        this.oeN.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindLinkedInUI oeU;

            {
                this.oeU = r1;
            }

            public final void onClick(View view) {
                if (!this.oeU.oeE) {
                    BindLinkedInUI.c(this.oeU);
                } else if (this.oeU.hWA) {
                    g.a(this.oeU, this.oeU.getString(2131232066), null, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 oeV;

                        {
                            this.oeV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oeV.oeU.jB(false);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 oeV;

                        {
                            this.oeV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    this.oeU.jB(false);
                }
            }
        });
        this.oeO.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindLinkedInUI oeU;

            {
                this.oeU = r1;
            }

            public final void onClick(View view) {
                g.a(this.oeU, this.oeU.getString(2131232068), null, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass8 oeW;

                    {
                        this.oeW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        final com.tencent.mm.ag.e eVar = new com.tencent.mm.ag.e();
                        this.oeW.oeU.eLA = g.a(this.oeW.oeU, this.oeW.oeU.getString(2131233521), false, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 oeY;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(eVar);
                            }
                        });
                        ak.vy().a(eVar, 0);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass8 oeW;

                    {
                        this.oeW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.oeP.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ BindLinkedInUI oeU;

            {
                this.oeU = r1;
            }

            public final void onClick(View view) {
                this.oeU.goBack();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindLinkedInUI oeU;

            {
                this.oeU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oeU.goBack();
                return true;
            }
        });
        av();
    }

    private void goBack() {
        if (!this.oeE) {
            setResult(-1);
            finish();
        } else if (this.oeI) {
            Intent ak = a.drp.ak(this);
            ak.addFlags(603979776);
            ak.putExtra("preferred_tab", 2);
            startActivity(ak);
        } else {
            setResult(-1);
            finish();
        }
    }

    private void jB(boolean z) {
        if (this.oeG == null) {
            v.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
            return;
        }
        final b bVar = new b(this.oeM.pdq ? 1 : 2, this.bCv, this.bCw, "", this.oeQ, this.oeR, this.oeS, this.oeT);
        if (!z) {
            this.eLA = g.a(this, getString(2131233521), false, new OnCancelListener(this) {
                final /* synthetic */ BindLinkedInUI oeU;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(bVar);
                }
            });
        }
        ak.vy().a(bVar, 0);
    }

    private void OB(String str) {
        int indexOf = getString(2131232064).indexOf("%s");
        CharSequence newSpannable = Factory.getInstance().newSpannable(getString(2131232064, new Object[]{str}));
        newSpannable.setSpan(new ClickableSpan(this) {
            final /* synthetic */ BindLinkedInUI oeU;

            {
                this.oeU = r1;
            }

            public final void onClick(View view) {
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(this.oeU.getResources().getColor(2131689819));
                textPaint.setUnderlineText(false);
            }
        }, indexOf, str.length() + indexOf, 33);
        this.oeJ.setText(newSpannable);
    }

    private void b(boolean z, boolean z2, String str, boolean z3) {
        this.oeP.setVisibility(8);
        if (z) {
            this.oeK.setVisibility(8);
            this.oeJ.setVisibility(0);
            OB(str);
            this.oeL.setVisibility(0);
            this.oeN.setVisibility(8);
            if (z2) {
                this.oeO.setVisibility(0);
            }
            this.oeM.kq(z3);
            this.oeM.pdu = new MMSwitchBtn.a(this) {
                final /* synthetic */ BindLinkedInUI oeU;

                {
                    this.oeU = r1;
                }

                public final void gB(boolean z) {
                    this.oeU.I(z, true);
                }
            };
            return;
        }
        this.oeJ.setVisibility(8);
        this.oeJ.setText(getString(2131232065));
        this.oeK.setVisibility(0);
        this.oeL.setVisibility(8);
        this.oeN.setVisibility(0);
        this.oeO.setVisibility(8);
    }

    private void av() {
        boolean z = true;
        if (this.oeE && this.oeG == null) {
            v.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
        } else if (this.oeF) {
            b(this.hWA, false, this.name, this.oeD);
        } else if (this.oeE) {
            if (!(this.hWA && this.oeC.equals(this.bCv))) {
                z = false;
            }
            String str = this.bCw;
            boolean z2 = this.oeD;
            this.oeJ.setVisibility(0);
            OB(str);
            this.oeL.setVisibility(0);
            this.oeO.setVisibility(8);
            if (z) {
                this.oeK.setVisibility(8);
                this.oeN.setVisibility(8);
                this.oeP.setVisibility(8);
                this.oeM.kq(z2);
                this.oeM.pdu = new MMSwitchBtn.a(this) {
                    final /* synthetic */ BindLinkedInUI oeU;

                    {
                        this.oeU = r1;
                    }

                    public final void gB(boolean z) {
                        this.oeU.I(z, true);
                    }
                };
                return;
            }
            this.oeK.setVisibility(0);
            this.oeN.setVisibility(0);
            this.oeP.setVisibility(0);
            this.oeM.kq(z2);
            this.oeM.pdu = new MMSwitchBtn.a(this) {
                final /* synthetic */ BindLinkedInUI oeU;

                {
                    this.oeU = r1;
                }

                public final void gB(boolean z) {
                    this.oeU.I(z, false);
                }
            };
        } else {
            b(this.hWA, true, this.name, this.oeD);
        }
    }

    private void I(boolean z, boolean z2) {
        if (z) {
            this.status |= 4194304;
        } else {
            this.status &= -4194305;
        }
        int i = z ? 1 : 2;
        ak.yW();
        com.tencent.mm.model.c.vf().set(7, Integer.valueOf(this.status));
        if (z2) {
            rc rcVar = new rc();
            rcVar.muR = 33;
            rcVar.muS = i;
            ak.yW();
            com.tencent.mm.model.c.wG().b(new j.a(23, rcVar));
            a.drq.ow();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        v.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (intent != null) {
            switch (i) {
                case 100:
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    String string = bundleExtra.getString("ret");
                    String string2 = bundleExtra.getString("limid");
                    String string3 = bundleExtra.getString("liname");
                    String string4 = bundleExtra.getString("liurl");
                    String string5 = bundleExtra.getString("liswitch");
                    if (be.kS(string)) {
                        v.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
                        return;
                    }
                    int KL = be.KL(string);
                    if (KL != 0) {
                        v.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[]{Integer.valueOf(KL)});
                        g.A(this, getString(KL == 1 ? 2131232075 : 2131232074), null);
                        return;
                    } else if (be.kS(string2)) {
                        v.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
                        return;
                    } else {
                        v.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[]{string2, string3, string4, string5});
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(286722, string3);
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(286721, string2);
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(286723, string4);
                        if (!be.kS(string5)) {
                            if (be.KL(string5) != 1) {
                                z = false;
                            }
                            I(z, false);
                        }
                        NH();
                        av();
                        String string6 = getString(2131232071);
                        AnonymousClass4 anonymousClass4 = new OnDismissListener(this) {
                            final /* synthetic */ BindLinkedInUI oeU;

                            {
                                this.oeU = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                            }
                        };
                        g.bf(this, string6);
                        return;
                    }
                default:
                    v.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.eLA != null) {
            this.eLA.dismiss();
            this.eLA = null;
        }
        int i3;
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 549) {
                this.oeI = true;
                if (this.oeH) {
                    i3 = 2131232072;
                } else {
                    i3 = 2131232071;
                }
            } else if (kVar.getType() == 550) {
                i3 = 2131232082;
                ah.FU().clear();
            } else {
                return;
            }
            String string = getString(i3);
            AnonymousClass5 anonymousClass5 = new OnDismissListener(this) {
                final /* synthetic */ BindLinkedInUI oeU;

                {
                    this.oeU = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            g.bf(this, string);
            NH();
            this.oeD = this.oeM.pdq;
            av();
            return;
        }
        if (kVar.getType() == 549) {
            if (i2 == 1) {
                i3 = 2131232075;
            } else {
                i3 = 2131232074;
            }
        } else if (kVar.getType() == 550) {
            i3 = 2131232076;
        } else {
            return;
        }
        g.A(this, getString(i3), null);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }
}
