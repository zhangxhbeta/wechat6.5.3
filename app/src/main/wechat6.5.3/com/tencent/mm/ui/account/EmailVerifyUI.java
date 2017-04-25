package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.w;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.q;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditText;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;

public class EmailVerifyUI extends MMActivity implements e {
    private ProgressDialog dwR = null;
    private String ivg;
    private TextView nHS;
    private TextView nHT;
    private MMAutoSwitchEditTextView nHU;
    private Button nHV;
    private Button nHW;
    private String nHX;
    private String nHY;
    private String nHZ;
    private String nIa;
    private boolean nIb = false;

    static /* synthetic */ void a(EmailVerifyUI emailVerifyUI, String str) {
        if (emailVerifyUI.nIb) {
            v.i("MicroMsg.EmailVerifyUI", "is verifying, wait a minute");
            return;
        }
        emailVerifyUI.nIb = true;
        final k wVar = new w(emailVerifyUI.nHX, emailVerifyUI.nHZ, str);
        ak.vy().a(wVar, 0);
        emailVerifyUI.getString(2131231164);
        emailVerifyUI.dwR = g.a((Context) emailVerifyUI, emailVerifyUI.getString(2131234402), true, new OnCancelListener(emailVerifyUI) {
            final /* synthetic */ EmailVerifyUI nIc;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(wVar);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        this.ivg = b.Oa();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(481, (e) this);
        b.b(true, ak.uR() + "," + getClass().getName() + ",R500_200," + ak.dR("R500_200") + ",1");
        b.mh("R500_200");
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(481, (e) this);
        b.b(false, ak.uR() + "," + getClass().getName() + ",R500_200," + ak.dR("R500_200") + ",2");
    }

    protected final int getLayoutId() {
        return 2130904567;
    }

    protected final void NI() {
        vD(2131234404);
        this.nHS = (TextView) findViewById(2131759607);
        this.nHS.setText(Html.fromHtml(getString(2131234387)));
        this.nHT = (TextView) findViewById(2131759608);
        this.nHX = getIntent().getStringExtra("email_address");
        if (be.kS(this.nHX)) {
            v.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
        } else {
            this.nHT.setText(this.nHX);
        }
        this.nHZ = getIntent().getStringExtra("password");
        this.nHY = getIntent().getStringExtra("email_login_page");
        v.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", this.nHX, this.nHY);
        this.nHU = (MMAutoSwitchEditTextView) findViewById(2131759609);
        this.nHU.nUD = new a(this) {
            final /* synthetic */ EmailVerifyUI nIc;

            {
                this.nIc = r1;
            }

            public final void Og(String str) {
                this.nIc.iT(true);
                EmailVerifyUI.a(this.nIc, str);
            }
        };
        this.nHU.nUE = new MMAutoSwitchEditTextView.b(this) {
            final /* synthetic */ EmailVerifyUI nIc;

            {
                this.nIc = r1;
            }

            public final void bAM() {
                this.nIc.iT(false);
            }
        };
        this.nHW = (Button) findViewById(2131759611);
        this.nHW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmailVerifyUI nIc;

            {
                this.nIc = r1;
            }

            public final void onClick(View view) {
                b.mj(ak.uR() + "," + getClass().getName() + ",R500_250," + ak.dR("R500_250") + ",3");
                g.a(this.nIc, 2131234395, 2131234385, 2131231107, 2131231010, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 nId;

                    {
                        this.nId = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        final k wVar = new w(this.nId.nIc.nHX, this.nId.nIc.nHZ);
                        ak.vy().a(wVar, 0);
                        EmailVerifyUI emailVerifyUI = this.nId.nIc;
                        Context context = this.nId.nIc;
                        this.nId.nIc.getString(2131231164);
                        emailVerifyUI.dwR = g.a(context, this.nId.nIc.getString(2131234403), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 nIf;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(wVar);
                            }
                        });
                    }
                }, null);
            }
        });
        this.nHV = (Button) findViewById(2131759610);
        if (be.kS(this.nHY) || be.kS(this.nHX)) {
            this.nHV.setVisibility(8);
        } else {
            this.nHV.setVisibility(0);
            this.nHV.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ EmailVerifyUI nIc;

                {
                    this.nIc = r1;
                }

                public final void onClick(View view) {
                    be.E(this.nIc, this.nIc.nHY);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmailVerifyUI nIc;

            {
                this.nIc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nIc.goBack();
                return true;
            }
        });
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ EmailVerifyUI nIc;

            {
                this.nIc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmailVerifyUI emailVerifyUI = this.nIc;
                MMAutoSwitchEditTextView e = this.nIc.nHU;
                String str = SQLiteDatabase.KeyEmpty;
                Iterator it = e.nUB.iterator();
                while (it.hasNext()) {
                    String str2;
                    MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                    if (be.kS(mMAutoSwitchEditText.getText().toString().trim())) {
                        str2 = str;
                    } else {
                        str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                    }
                    str = str2;
                }
                emailVerifyUI.nIa = str;
                if (be.kS(this.nIc.nIa) || this.nIc.nIa.length() != 12) {
                    this.nIc.iT(false);
                } else {
                    EmailVerifyUI.a(this.nIc, this.nIc.nIa);
                }
                return true;
            }
        });
        iT(false);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        b.mi(this.ivg);
        finish();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        this.nIb = false;
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (kVar.getType() != 481) {
            v.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", Integer.valueOf(kVar.getType()));
            return;
        }
        int i3 = ((q.a) ((w) kVar).cAt.Bx()).lXg.meB;
        if (i != 0 || i2 != 0) {
            int i4;
            if (!com.tencent.mm.plugin.a.a.drq.a((Context) this, i, i2, str)) {
                switch (i2) {
                    case -34:
                        Toast.makeText(this, 2131234383, 0).show();
                        i4 = 1;
                        break;
                    case -33:
                        g.a((Context) this, 2131234384, 2131234385, null);
                        i4 = 1;
                        break;
                    case -32:
                        g.a((Context) this, 2131234386, 2131234385, null);
                        b.mj(ak.uR() + "," + getClass().getName() + ",R500_260," + ak.dR("R500_260") + ",3");
                        i4 = 1;
                        break;
                    default:
                        boolean z = false;
                        break;
                }
            }
            i4 = 1;
            if (i4 != 0) {
                return;
            }
            if (i3 == 2) {
                Toast.makeText(this, getString(2131234405, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (i3 == 1) {
                Toast.makeText(this, getString(2131234396, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        } else if (i3 == 2) {
            b.mi("R200_900_email");
            Intent intent = new Intent(this, RegSetInfoUI.class);
            intent.putExtra("regsetinfo_ticket", ((q.b) ((w) kVar).cAt.ze()).lXh.mpB);
            intent.putExtra("regsetinfo_user", this.nHX);
            intent.putExtra("regsetinfo_ismobile", 3);
            intent.putExtra("regsetinfo_NextStyle", ((w) kVar).Fp());
            intent.putExtra("regsetinfo_pwd", this.nHZ);
            intent.putExtra("regsetinfo_bind_email", this.nHX);
            startActivity(intent);
        } else if (i3 == 1) {
            b.mj(ak.uR() + "," + getClass().getName() + ",R22_resend_email_code_alert," + ak.dR("R22_resend_email_code_alert") + ",3");
            g.bf(this, getString(2131234397));
        } else {
            v.e("MicroMsg.EmailVerifyUI", "err opcode");
        }
    }
}
