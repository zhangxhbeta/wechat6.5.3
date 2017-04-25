package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class RegByMobileVoiceVerifyUI extends MMActivity implements e {
    private String bhT;
    private TextView eux;
    private String iMg;
    private String ivg;
    private String nIB;
    private u nLj;
    private v nLk;
    private int nLl = 0;

    static /* synthetic */ int d(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        switch (regByMobileVoiceVerifyUI.nLl) {
            case 0:
                return 14;
            case 2:
                return 8;
            default:
                return 16;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bhT = getIntent().getExtras().getString("bindmcontact_mobile");
        this.nLl = getIntent().getExtras().getInt("voice_verify_type");
        if (this.nLl == 0 || this.nLl == 2 || this.nLl == 3) {
            ak.vy().a(145, (e) this);
        } else if (this.nLl == 4 || this.nLl == 1) {
            ak.vy().a(132, (e) this);
        }
        this.ivg = b.Oa();
        NI();
    }

    protected void onResume() {
        super.onResume();
        if (this.nLl == 0 || this.nLl == 2 || this.nLl == 3) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",R200_500," + ak.dR("R200_500") + ",1");
            b.mh("R200_500");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(132, (e) this);
        ak.vy().b(145, (e) this);
        if (this.nLl == 0 || this.nLl == 2 || this.nLl == 3) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R200_500," + ak.dR("R200_500") + ",2");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        b.mi(this.ivg);
        axg();
        finish();
        return true;
    }

    protected final void NI() {
        vD(2131231461);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileVoiceVerifyUI nLm;

            {
                this.nLm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nLm.axg();
                this.nLm.finish();
                return true;
            }
        });
        this.eux = (TextView) findViewById(2131755626);
        Button button = (Button) findViewById(2131755627);
        this.nIB = RegByMobileVoiceVerifySelectUI.Ol(this.bhT);
        this.eux.setText(this.nIB);
        this.iMg = com.tencent.mm.af.b.jo(this.bhT);
        findViewById(2131755625).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileVoiceVerifyUI nLm;

            {
                this.nLm = r1;
            }

            public final void onClick(View view) {
                this.nLm.startActivityForResult(new Intent(this.nLm, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", this.nLm.iMg), 10000);
            }
        });
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileVoiceVerifyUI nLm;

            {
                this.nLm = r1;
            }

            public final void onClick(View view) {
                if (this.nLm.nLl == 0 || this.nLm.nLl == 2 || this.nLm.nLl == 3) {
                    this.nLm.nLj = new u(this.nLm.bhT, RegByMobileVoiceVerifyUI.d(this.nLm), SQLiteDatabase.KeyEmpty, 1, this.nLm.iMg);
                    ak.vy().a(this.nLm.nLj, 0);
                    g.a(this.nLm, 2131231458, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 nLn;

                        {
                            this.nLn = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nLn.nLm.finish();
                        }
                    });
                } else if (this.nLm.nLl == 4 || this.nLm.nLl == 1) {
                    this.nLm.nLk = new v(this.nLm.bhT, 1, SQLiteDatabase.KeyEmpty, 1, this.nLm.iMg);
                    ak.vy().a(this.nLm.nLk, 0);
                    g.a(this.nLm, 2131231458, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 nLn;

                        {
                            this.nLn = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.nLn.nLm.finish();
                        }
                    });
                }
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10000 && intent != null) {
            this.nIB = intent.getStringExtra("voice_verify_language");
            this.iMg = intent.getStringExtra("voice_verify_code");
            this.eux.setText(this.nIB);
        }
    }

    protected final int getLayoutId() {
        return 2130903176;
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }
}
