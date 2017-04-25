package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.smtt.sdk.WebView;

public class BindQQUI extends MMWizardActivity implements e {
    p dwg;
    private String iMo = null;
    private String iMp = null;
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
        ak.vy().a(254, (e) this);
        ak.vy().a((int) WebView.NORMAL_MODE_ALPHA, (e) this);
    }

    public void onDestroy() {
        ak.vy().b(254, (e) this);
        ak.vy().b((int) WebView.NORMAL_MODE_ALPHA, (e) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        NI();
    }

    protected final int getLayoutId() {
        return 2130903177;
    }

    protected final void NI() {
        ak.yW();
        long longValue = new o(be.f((Integer) c.vf().get(9, null))).longValue();
        TextView textView;
        Button button;
        if (longValue == 0) {
            vD(2131231470);
            textView = (TextView) findViewById(2131755630);
            textView.setVisibility(8);
            textView.setText(2131231468);
            ((TextView) findViewById(2131755629)).setVisibility(8);
            button = (Button) findViewById(2131755631);
            button.setVisibility(0);
            button.setText(2131231467);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BindQQUI ogE;

                {
                    this.ogE = r1;
                }

                public final void onClick(View view) {
                    MMWizardActivity.w(this.ogE, new Intent(this.ogE, VerifyQQUI.class));
                }
            });
            vH(1);
        } else {
            vD(2131231466);
            textView = (TextView) findViewById(2131755630);
            textView.setVisibility(8);
            textView.setText(2131231464);
            textView = (TextView) findViewById(2131755629);
            textView.setVisibility(0);
            textView.setText(getString(2131231465) + longValue);
            button = (Button) findViewById(2131755631);
            button.setVisibility(8);
            button.setText(2131233249);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BindQQUI ogE;

                {
                    this.ogE = r1;
                }

                public final void onClick(View view) {
                }
            });
            a(1, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ BindQQUI ogE;

                {
                    this.ogE = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    l lVar = new l(this.ogE.nDR.nEl);
                    lVar.jXn = new n.c(this) {
                        final /* synthetic */ AnonymousClass7 ogF;

                        {
                            this.ogF = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            lVar.setHeaderTitle(2131231417);
                            lVar.dg(0, 2131235186);
                        }
                    };
                    lVar.jXo = new d(this) {
                        final /* synthetic */ AnonymousClass7 ogF;

                        {
                            this.ogF = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Context context = this.ogF.ogE;
                                    ak.vy().a(new h(h.cYs), 0);
                                    context.getString(2131231164);
                                    context.dwg = g.a(context, context.getString(2131235044), true, new OnCancelListener(context) {
                                        final /* synthetic */ BindQQUI ogE;

                                        {
                                            this.ogE = r1;
                                        }

                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    lVar.aXZ();
                    return false;
                }
            });
        }
        if (this.type == 1) {
            a(0, getString(2131231078), new OnMenuItemClickListener(this) {
                final /* synthetic */ BindQQUI ogE;

                {
                    this.ogE = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.ogE.bAv();
                    return true;
                }
            });
        } else {
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BindQQUI ogE;

                {
                    this.ogE = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.ogE.axg();
                    this.ogE.finish();
                    return true;
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.BindQQUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        if (kVar.getType() == 254) {
            if (i == 0 && i2 == 0) {
                this.iMo = ((h) kVar).IR();
                if (this.iMo != null && this.iMo.length() > 0) {
                    ak.yW();
                    c.vf().set(102407, this.iMo);
                }
                if (be.kS(this.iMp)) {
                    ak.vy().a(new t(2), 0);
                    return;
                }
                Intent intent = new Intent(this, StartUnbindQQ.class);
                intent.putExtra("notice", this.iMp);
                MMWizardActivity.w(this, intent);
                return;
            }
            if (this.dwg != null) {
                this.dwg.dismiss();
                this.dwg = null;
            }
            if (i2 == -3) {
                v.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                g.a(this.nDR.nEl, getString(2131235189), null, getString(2131235190), getString(2131235188), true, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BindQQUI ogE;

                    {
                        this.ogE = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", this.ogE.getString(2131235187));
                        intent.putExtra("from_unbind", true);
                        com.tencent.mm.ay.c.b(this.ogE, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BindQQUI ogE;

                    {
                        this.ogE = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -81) {
                g.a((Context) this, 2131234950, 2131231164, null);
            } else if (i2 == -82) {
                g.a((Context) this, 2131234951, 2131231164, null);
            } else if (i2 == -83) {
                g.a((Context) this, 2131234948, 2131231164, null);
            } else if (i2 == -84) {
                g.a((Context) this, 2131234949, 2131231164, null);
            } else if (i2 == -85) {
                g.a((Context) this, 2131234947, 2131231164, null);
            } else if (i2 == -86) {
                g.a((Context) this, 2131234952, 2131231164, null);
            }
        } else if (kVar.getType() != WebView.NORMAL_MODE_ALPHA) {
        } else {
            if (i2 == 0) {
                MMWizardActivity.w(this, new Intent(this, StartUnbindQQ.class));
            } else {
                g.a(this.nDR.nEl, getString(2131235189), null, getString(2131235190), getString(2131235188), true, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BindQQUI ogE;

                    {
                        this.ogE = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", this.ogE.getString(2131235187));
                        intent.putExtra("from_unbind", true);
                        com.tencent.mm.ay.c.b(this.ogE, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ BindQQUI ogE;

                    {
                        this.ogE = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    v.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
                    ak.vy().a(new h(h.cYs), 0);
                    getString(2131231164);
                    this.dwg = g.a((Context) this, getString(2131235044), true, new OnCancelListener(this) {
                        final /* synthetic */ BindQQUI ogE;

                        {
                            this.ogE = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
