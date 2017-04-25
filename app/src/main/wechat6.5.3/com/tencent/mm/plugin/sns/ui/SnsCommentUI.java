package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.b;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ak;
import com.tencent.mm.plugin.sns.e.au;
import com.tencent.mm.plugin.sns.f.h;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.u;
import com.tencent.mm.v.e;

@a(17)
public class SnsCommentUI extends MMActivity implements e {
    private int bcS;
    private p dwg = null;
    private SnsEditText jOg;
    private int jOh = 0;
    private boolean jOi = false;
    private boolean jOj = false;
    private int jdV;

    static /* synthetic */ void a(SnsCommentUI snsCommentUI, String str) {
        k qG = ad.aSE().qG(snsCommentUI.jdV);
        if (qG != null) {
            snsCommentUI.jOi = true;
            if (qG.aUK()) {
                ak.a.a(qG, 2, str, "", snsCommentUI.bcS);
            } else {
                ak.a.a(qG.field_userName, 3, str, qG, snsCommentUI.bcS);
            }
            snsCommentUI.axg();
            snsCommentUI.getString(2131231164);
            snsCommentUI.dwg = g.a(snsCommentUI, snsCommentUI.getString(2131231151), true, new OnCancelListener(snsCommentUI) {
                final /* synthetic */ SnsCommentUI jOk;

                {
                    this.jOk = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
    }

    static /* synthetic */ void b(SnsCommentUI snsCommentUI, String str) {
        if (!snsCommentUI.isFinishing()) {
            com.tencent.mm.model.k.xF();
            au auVar = new au(2);
            auVar.AG(str);
            if (snsCommentUI.jOg.jOn > com.tencent.mm.plugin.sns.b.a.jdC) {
                auVar.qk(2);
            }
            auVar.commit();
            snsCommentUI.setResult(-1);
            snsCommentUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jdV = getIntent().getIntExtra("sns_comment_localId", 0);
        this.jOh = getIntent().getIntExtra("sns_comment_type", 0);
        this.bcS = getIntent().getIntExtra("sns_source", 0);
        com.tencent.mm.model.ak.vy().a(213, this);
        NI();
    }

    public void onPause() {
        super.onPause();
        if (this.jOg != null) {
            String trim = this.jOg.getText().toString().trim();
            com.tencent.mm.model.ak.yW();
            c.vf().set(68408, trim);
            if (be.kS(trim)) {
                com.tencent.mm.model.ak.yW();
                c.vf().set(7489, Integer.valueOf(0));
                return;
            }
            com.tencent.mm.model.ak.yW();
            c.vf().set(7489, Integer.valueOf(this.jOg.jOn));
        }
    }

    public void onResume() {
        super.onResume();
        aJs();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.model.ak.vy().b(213, this);
    }

    protected final void NI() {
        this.jOg = (SnsEditText) findViewById(2131755329);
        this.jOg.setTextSize(1, (u.ds(this.nDR.nEl) * this.jOg.getTextSize()) / com.tencent.mm.bd.a.getDensity(this.nDR.nEl));
        a(0, getString(2131231149), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsCommentUI jOk;

            {
                this.jOk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i;
                if (this.jOk.jOh == 0) {
                    b.sF();
                }
                if (this.jOk.jOh == 2) {
                    i = 200;
                } else {
                    i = b.sE();
                }
                com.tencent.mm.ui.tools.a.c yn = com.tencent.mm.ui.tools.a.c.b(this.jOk.jOg).yn(i);
                yn.oWy = true;
                yn.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                    final /* synthetic */ AnonymousClass2 jOl;

                    {
                        this.jOl = r1;
                    }

                    public final void qK(String str) {
                        String trim = this.jOl.jOk.jOg.getText().toString().trim();
                        this.jOl.jOk.jOg.setText("");
                        if (trim.length() > 0) {
                            switch (this.jOl.jOk.jOh) {
                                case 0:
                                    this.jOl.jOk.axg();
                                    SnsCommentUI.a(this.jOl.jOk, trim);
                                    return;
                                case 1:
                                    this.jOl.jOk.axg();
                                    SnsCommentUI.b(this.jOl.jOk, trim);
                                    return;
                                case 2:
                                    this.jOl.jOk.axg();
                                    long longExtra = this.jOl.jOk.getIntent().getLongExtra("sns_id", 0);
                                    long longExtra2 = this.jOl.jOk.getIntent().getLongExtra("action_st_time", 0);
                                    String ah = be.ah(this.jOl.jOk.getIntent().getStringExtra("sns_uxinfo"), "");
                                    trim = be.ah(this.jOl.jOk.getIntent().getStringExtra("sns_actionresult"), "") + "|4:1:" + trim;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    h aTp = ad.aSw().aTp();
                                    if (aTp != null && aTp.aTq()) {
                                        String str2 = aTp.jpx;
                                        String str3 = aTp.jpw;
                                        v.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + ah + " actionresult: " + trim + " " + longExtra2 + " " + currentTimeMillis);
                                        com.tencent.mm.plugin.report.service.g.iuh.h(11988, new Object[]{str2, str3, "", "", i.cE(longExtra), ah, trim, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000)});
                                        this.jOl.jOk.jOj = true;
                                        this.jOl.jOk.finish();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    }

                    public final void adq() {
                    }

                    public final void adr() {
                        g.f(this.jOl.jOk, 2131235575, 2131235576);
                    }
                });
                return false;
            }
        }, com.tencent.mm.ui.k.b.nET);
        if (this.jOh == 0) {
            vD(2131235386);
        } else if (this.jOh == 1) {
            vD(2131235583);
            com.tencent.mm.model.ak.yW();
            String ah = be.ah((String) c.vf().get(68408, ""), "");
            com.tencent.mm.model.ak.yW();
            this.jOg.jOn = be.a((Integer) c.vf().get(7489, Integer.valueOf(0)), 0);
            this.jOg.append(be.ah(ah, ""));
            if (ah == null || ah.length() <= 0) {
                iT(false);
            } else {
                iT(true);
            }
        } else if (this.jOh == 2) {
            vD(2131235358);
            iT(false);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsCommentUI jOk;

            {
                this.jOk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jOk.axg();
                this.jOk.finish();
                return true;
            }
        });
        this.jOg.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SnsCommentUI jOk;

            {
                this.jOk = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.jOk.jOg.getText().toString().trim().length() > 0) {
                    this.jOk.iT(true);
                } else {
                    this.jOk.iT(false);
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
    }

    protected final int getLayoutId() {
        return 2130904447;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        if (this.dwg != null) {
            this.dwg.dismiss();
        }
        switch (kVar.getType()) {
            case 213:
                if (this.jOi) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void finish() {
        super.finish();
        if (!this.jOj && this.jOh == 2) {
            long longExtra = getIntent().getLongExtra("sns_id", 0);
            long longExtra2 = getIntent().getLongExtra("action_st_time", 0);
            String ah = be.ah(getIntent().getStringExtra("sns_uxinfo"), "");
            String str = be.ah(getIntent().getStringExtra("sns_actionresult"), "") + "|4:0:";
            long currentTimeMillis = System.currentTimeMillis();
            h aTp = ad.aSw().aTp();
            if (aTp != null && aTp.aTq()) {
                String str2 = aTp.jpx;
                String str3 = aTp.jpw;
                v.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + longExtra + " uxinfo:" + ah + " actionresult: " + str + " " + longExtra2 + " " + currentTimeMillis);
                com.tencent.mm.plugin.report.service.g.iuh.h(11988, new Object[]{str2, str3, "", "", i.cE(longExtra), ah, str, Long.valueOf(longExtra2 / 1000), Long.valueOf(currentTimeMillis / 1000)});
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        axg();
        finish();
        return true;
    }
}
