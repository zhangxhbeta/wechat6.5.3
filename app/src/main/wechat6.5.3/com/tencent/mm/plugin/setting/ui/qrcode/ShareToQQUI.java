package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.account.h;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.e.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.e;

public class ShareToQQUI extends MMActivity implements e {
    private ProgressDialog dwR = null;
    private TextView iJt;
    private int iJu;
    private boolean iJv = false;
    private EditText idd;

    static /* synthetic */ void d(ShareToQQUI shareToQQUI) {
        v.e("MicroMsg.ShareToQQUI", "dealWithRefreshTokenFail");
        if (!shareToQQUI.iJv) {
            String string = shareToQQUI.nDR.nEl.getString(2131231164);
            g.a(shareToQQUI.nDR.nEl, shareToQQUI.nDR.nEl.getString(2131232616), string, new OnClickListener(shareToQQUI) {
                final /* synthetic */ ShareToQQUI iJw;

                {
                    this.iJw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(this.iJw.nDR.nEl, FacebookAuthUI.class);
                    intent.putExtra("is_force_unbind", true);
                    this.iJw.nDR.nEl.startActivityForResult(intent, 8);
                }
            }, null);
        }
    }

    protected final int getLayoutId() {
        return 2130903471;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(26, this);
        NI();
        if (k.yh()) {
            c cVar = new c("290293790992170");
            ak.yW();
            cVar.Po(be.ma((String) com.tencent.mm.model.c.vf().get(65830, null)));
            new h(cVar, new a(this) {
                final /* synthetic */ ShareToQQUI iJw;

                {
                    this.iJw = r1;
                }

                public final void k(Bundle bundle) {
                    super.k(bundle);
                }

                public final void onError(int i, String str) {
                    super.onError(i, str);
                    if (i == 3) {
                        ShareToQQUI.d(this.iJw);
                    }
                }
            }).bAT();
        }
    }

    public void onDestroy() {
        ak.vy().b(26, this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131234914);
        this.idd = (EditText) findViewById(2131755329);
        this.iJt = (TextView) findViewById(2131756526);
        this.idd.addTextChangedListener(new MMEditText.c(this.idd, this.iJt, 280));
        this.iJu = getIntent().getIntExtra("show_to", 2);
        if (this.iJu == 4) {
            this.idd.setText(2131234892);
        } else {
            this.idd.setText(2131234894);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareToQQUI iJw;

            {
                this.iJw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iJw.axg();
                this.iJw.finish();
                return true;
            }
        });
        a(0, getString(2131231154), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareToQQUI iJw;

            {
                this.iJw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.v.k zVar;
                this.iJw.iJv = true;
                if (this.iJw.iJu == 2 || this.iJw.iJu == 1) {
                    boolean z;
                    boolean z2;
                    String obj = this.iJw.idd.getText().toString();
                    if (this.iJw.iJu == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.iJw.iJu == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zVar = new z(obj, z, z2);
                } else if (this.iJw.iJu == 4) {
                    ak.yW();
                    long d = be.d((Long) com.tencent.mm.model.c.vf().get(65831, null));
                    ak.yW();
                    String ma = be.ma((String) com.tencent.mm.model.c.vf().get(65830, null));
                    if (be.ay(d) > 86400000 && ma.length() > 0) {
                        c cVar = new c("290293790992170");
                        cVar.Po(ma);
                        new h(cVar, new a(this) {
                            final /* synthetic */ AnonymousClass2 iJx;

                            {
                                this.iJx = r1;
                            }

                            public final void k(Bundle bundle) {
                                super.k(bundle);
                            }

                            public final void onError(int i, String str) {
                                super.onError(i, str);
                            }
                        }).bAT();
                    }
                    zVar = new z(this.iJw.idd.getText().toString());
                } else {
                    g.f(this.iJw.nDR.nEl, 2131235293, 2131231164);
                    return true;
                }
                ak.vy().a(zVar, 0);
                ShareToQQUI shareToQQUI = this.iJw;
                ActionBarActivity actionBarActivity = this.iJw.nDR.nEl;
                this.iJw.getString(2131231164);
                shareToQQUI.dwR = g.a(actionBarActivity, this.iJw.getString(2131233725), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass2 iJx;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(zVar);
                    }
                });
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 26) {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (i == 4 && i2 == -68) {
                if (be.kS(str)) {
                    str = "error";
                }
                g.a(this, str, getString(2131231164), new OnClickListener(this) {
                    final /* synthetic */ ShareToQQUI iJw;

                    {
                        this.iJw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(this.iJw.nDR.nEl, FacebookAuthUI.class);
                        intent.putExtra("is_force_unbind", true);
                        this.iJw.nDR.nEl.startActivity(intent);
                        this.iJw.axg();
                        this.iJw.finish();
                    }
                }, null);
            } else if (i == 0 && i2 == 0) {
                axg();
                String string = getString(2131235295);
                AnonymousClass4 anonymousClass4 = new OnDismissListener(this) {
                    final /* synthetic */ ShareToQQUI iJw;

                    {
                        this.iJw = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.iJw.finish();
                    }
                };
                g.bf(this, string);
            } else {
                this.iJv = false;
                if (!com.tencent.mm.plugin.setting.a.drq.a(this.nDR.nEl, i, i2, str)) {
                    Toast.makeText(this, getString(2131235294, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }
}
