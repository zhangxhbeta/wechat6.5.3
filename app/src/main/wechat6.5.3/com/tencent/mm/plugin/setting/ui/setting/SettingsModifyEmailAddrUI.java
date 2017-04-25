package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.s.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class SettingsModifyEmailAddrUI extends MMActivity implements e {
    private ProgressDialog dwR;
    private EditText iMj;
    private String iMk;
    private String iMl;
    private TextView iMm;
    private TextView iMn;
    private String iMo = null;
    private String iMp = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        ak.vy().a(138, this);
        ak.vy().a(254, this);
        ak.vy().a(256, this);
        ak.vy().a(108, this);
        ak.vy().a(255, this);
    }

    protected final int getLayoutId() {
        return 2130904358;
    }

    public void onDestroy() {
        ak.vy().b(138, this);
        ak.vy().b(254, this);
        ak.vy().b(256, this);
        ak.vy().b(108, this);
        ak.vy().b(255, this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131235058);
        this.iMj = (EditText) findViewById(2131759086);
        this.iMm = (TextView) findViewById(2131759088);
        this.iMn = (TextView) findViewById(2131759087);
        ak.yW();
        this.iMk = (String) c.vf().get(5, null);
        this.iMj.setText(this.iMk);
        ak.yW();
        Integer num = (Integer) c.vf().get(7, null);
        boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
        Boolean valueOf = Boolean.valueOf(z);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

            {
                this.iMq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMq.axg();
                this.iMq.finish();
                return true;
            }
        });
        if (valueOf.booleanValue()) {
            this.iMm.setVisibility(0);
            this.iMm.setText(getString(2131235186));
            this.iMn.setText(getString(2131235059));
            this.iMn.setTextColor(getResources().getColor(2131689494));
            this.iMj.setEnabled(false);
            this.iMj.setFilters(new InputFilter[]{new InputFilter(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                {
                    this.iMq = r1;
                }

                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    return charSequence.length() <= 0 ? spanned.subSequence(i3, i4) : "";
                }
            }});
            this.iMm.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                {
                    this.iMq = r1;
                }

                public final void onClick(View view) {
                    ak.vy().a(new h(h.cYv), 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.iMq;
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI2 = this.iMq;
                    this.iMq.getString(2131231164);
                    settingsModifyEmailAddrUI.dwR = g.a(settingsModifyEmailAddrUI2, this.iMq.getString(2131235191), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass22 iMr;

                        {
                            this.iMr = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    this.iMq.axg();
                }
            });
            cx(this.iMj);
        } else if (be.kS(this.iMk)) {
            aNk();
        } else {
            this.iMm.setVisibility(0);
            this.iMm.setText(getString(2131234935));
            this.iMn.setText(getString(2131234933));
            this.iMn.setTextColor(getResources().getColor(2131689960));
            this.iMj.setEnabled(false);
            this.iMj.setFilters(new InputFilter[]{new InputFilter(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                {
                    this.iMq = r1;
                }

                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    return charSequence.length() <= 0 ? spanned.subSequence(i3, i4) : "";
                }
            }});
            this.iMm.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                {
                    this.iMq = r1;
                }

                public final void onClick(View view) {
                    ak.yW();
                    final ab abVar = new ab((String) c.vf().get(2, null));
                    ak.vy().a(abVar, 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.iMq;
                    ActionBarActivity actionBarActivity = this.iMq.nDR.nEl;
                    this.iMq.getString(2131231164);
                    settingsModifyEmailAddrUI.dwR = g.a(actionBarActivity, this.iMq.getString(2131235001), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass24 iMt;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(abVar);
                        }
                    });
                    this.iMq.axg();
                }
            });
            a(0, getString(2131231030), new OnMenuItemClickListener(this) {
                final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                {
                    this.iMq = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.iMq.aNk();
                    return true;
                }
            });
            cx(this.iMj);
        }
    }

    private void aNk() {
        this.iMm.setVisibility(8);
        this.iMm.setText(getString(2131235186));
        this.iMn.setText(getString(2131235059));
        this.iMn.setTextColor(getResources().getColor(2131689494));
        this.iMj.setEnabled(true);
        this.iMj.setFilters(new InputFilter[]{new InputFilter(this) {
            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

            {
                this.iMq = r1;
            }

            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return null;
            }
        }});
        CharSequence be = d.be(this);
        if (!be.kS(be)) {
            this.iMj.setText(be);
        }
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

            {
                this.iMq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMq.iMl = this.iMq.iMj.getText().toString().trim();
                if (be.Kx(this.iMq.iMl)) {
                    ak.yW();
                    Integer num = (Integer) c.vf().get(7, null);
                    boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
                    Boolean valueOf = Boolean.valueOf(z);
                    if (this.iMq.iMl.equals(this.iMq.iMk) && valueOf.booleanValue()) {
                        this.iMq.finish();
                    } else {
                        final a aVar = new a(a.cxb, this.iMq.iMl);
                        ak.vy().a(aVar, 0);
                        SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.iMq;
                        SettingsModifyEmailAddrUI settingsModifyEmailAddrUI2 = this.iMq;
                        this.iMq.getString(2131231164);
                        settingsModifyEmailAddrUI.dwR = g.a(settingsModifyEmailAddrUI2, this.iMq.getString(2131234986), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass27 iMu;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(aVar);
                            }
                        });
                        this.iMq.axg();
                    }
                } else {
                    g.f(this.iMq.nDR.nEl, 2131235776, 2131231164);
                }
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + kVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (!com.tencent.mm.plugin.setting.a.drq.a(this.nDR.nEl, i, i2, str)) {
            if (kVar.getType() == 254) {
                if (i == 0 && i2 == 0) {
                    this.iMp = ((h) kVar).IS().mnd;
                    this.iMo = ((h) kVar).IR();
                    if (be.kS(this.iMp)) {
                        ak.vy().a(new t(2), 0);
                        return;
                    }
                    ak.vy().a(new a(a.cxc, this.iMj.getText().toString().trim()), 0);
                    return;
                }
                if (this.dwR != null) {
                    this.dwR.dismiss();
                    this.dwR = null;
                }
                if (i2 == -3) {
                    v.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                    g.a(this.nDR.nEl, getString(2131235189), null, getString(2131235190), getString(2131235188), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.iMq.getString(2131235187));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.ay.c.b(this.iMq, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -82) {
                    g.a(this, 2131234951, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -83) {
                    g.a(this, 2131234948, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -84) {
                    g.a(this, 2131234949, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i2 == -85) {
                    g.a(this, 2131234944, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            } else if (kVar.getType() == 256) {
                com.tencent.mm.plugin.setting.a.drq.ow();
                if (((a) kVar).AG() == a.cxb) {
                    if (i == 0 && i2 == 0) {
                        g.a(this.nDR.nEl, 2131235000, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                            {
                                this.iMq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.iMq.finish();
                            }
                        });
                        return;
                    }
                    if (this.dwR != null) {
                        this.dwR.dismiss();
                        this.dwR = null;
                    }
                    if (i2 == -82) {
                        g.a(this, 2131234951, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                            {
                                this.iMq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.iMq.finish();
                            }
                        });
                    } else if (i2 == -83) {
                        g.a(this, 2131234948, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                            {
                                this.iMq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.iMq.finish();
                            }
                        });
                    } else if (i2 == -84) {
                        g.a(this, 2131234949, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                            {
                                this.iMq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.iMq.finish();
                            }
                        });
                    } else if (i2 == -85) {
                        g.a(this, 2131234944, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                            {
                                this.iMq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.iMq.finish();
                            }
                        });
                    } else if (i2 == -86) {
                        g.a(this, 2131234952, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                            {
                                this.iMq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.iMq.finish();
                            }
                        });
                    } else {
                        g.a(this.nDR.nEl, getString(2131234999, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(2131231164), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                            {
                                this.iMq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.iMq.finish();
                            }
                        });
                    }
                } else if (((a) kVar).AG() == a.cxc) {
                    if (this.dwR != null) {
                        this.dwR.dismiss();
                        this.dwR = null;
                    }
                    if (i == 0 && i2 == 0) {
                        ak.yW();
                        Integer valueOf = Integer.valueOf(((Integer) c.vf().get(7, null)).intValue() | 2);
                        ak.yW();
                        c.vf().set(7, valueOf);
                        if (be.kS(this.iMp)) {
                            g.a(this.nDR.nEl, 2131234945, 2131231164, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                                {
                                    this.iMq = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.iMq.finish();
                                }
                            });
                        } else {
                            g.a(this.nDR.nEl, this.iMp, "", getString(2131230747), new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                                {
                                    this.iMq = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.iMq.finish();
                                }
                            });
                        }
                    }
                }
            } else if (kVar.getType() == 138) {
            } else {
                if (kVar.getType() == 108) {
                    if (this.dwR != null) {
                        this.dwR.dismiss();
                        this.dwR = null;
                    }
                    if (i == 0 && i2 == 0) {
                        g.a(this.nDR.nEl, 2131235000, 2131231164, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                            {
                                this.iMq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.iMq.finish();
                            }
                        });
                        return;
                    }
                    g.a(this.nDR.nEl, getString(2131234999, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(2131231164), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.iMq.finish();
                        }
                    });
                } else if (kVar.getType() != 255) {
                } else {
                    if (i2 == 0) {
                        ak.vy().a(new a(a.cxc, this.iMj.getText().toString().trim()), 0);
                        return;
                    }
                    if (this.dwR != null) {
                        this.dwR.dismiss();
                        this.dwR = null;
                    }
                    g.a(this.nDR.nEl, getString(2131235189), null, getString(2131235190), getString(2131235188), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("kintent_hint", this.iMq.getString(2131235187));
                            intent.putExtra("from_unbind", true);
                            com.tencent.mm.ay.c.b(this.iMq, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent, 1);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    v.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.iMk + " newEmail: " + this.iMl);
                    ak.vy().a(new h(h.cYv), 0);
                    getString(2131231164);
                    this.dwR = g.a(this, getString(2131235044), true, new OnCancelListener(this) {
                        final /* synthetic */ SettingsModifyEmailAddrUI iMq;

                        {
                            this.iMq = r1;
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
