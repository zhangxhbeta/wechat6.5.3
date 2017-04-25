package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class BindGoogleContactIntroUI extends MMActivity implements e {
    private int dRm;
    private ProgressDialog eZg;
    private boolean hVG = false;
    private ImageView odL;
    private TextView odM;
    private Button odN;
    private Button odO;
    private boolean odP = false;
    private String odQ;
    private a odR;
    private OnClickListener odS = new OnClickListener(this) {
        final /* synthetic */ BindGoogleContactIntroUI odU;

        {
            this.odU = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.odU, BindGoogleContactUI.class);
            intent.putExtra("enter_scene", this.odU.dRm);
            this.odU.startActivity(intent);
        }
    };
    private OnClickListener odT = new OnClickListener(this) {
        final /* synthetic */ BindGoogleContactIntroUI odU;

        {
            this.odU = r1;
        }

        public final void onClick(View view) {
            g.a(this.odU.nDR.nEl, true, this.odU.getString(2131235705), SQLiteDatabase.KeyEmpty, this.odU.getString(2131235704), this.odU.getString(2131231010), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ AnonymousClass2 odV;

                {
                    this.odV = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BindGoogleContactIntroUI.b(this.odV.odU);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ AnonymousClass2 odV;

                {
                    this.odV = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    };

    static /* synthetic */ void b(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        bindGoogleContactIntroUI.odR = new a(a.a.cKD, bindGoogleContactIntroUI.odQ, a.cKw);
        ak.vy().a(bindGoogleContactIntroUI.odR, 0);
        bindGoogleContactIntroUI.getString(2131231164);
        bindGoogleContactIntroUI.eZg = g.a((Context) bindGoogleContactIntroUI, bindGoogleContactIntroUI.getString(2131231182), true, new OnCancelListener(bindGoogleContactIntroUI) {
            final /* synthetic */ BindGoogleContactIntroUI odU;

            {
                this.odU = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(this.odU.odR);
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903169;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131231383);
        this.dRm = getIntent().getIntExtra("enter_scene", 0);
        this.hVG = n.aP(this);
        if (this.hVG) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
        }
    }

    protected void onResume() {
        super.onResume();
        ak.yW();
        this.odQ = (String) c.vf().get(208903, null);
        if (TextUtils.isEmpty(this.odQ)) {
            this.odP = false;
        } else {
            this.odP = true;
        }
        NI();
        if (this.odP) {
            this.odO.setVisibility(0);
            this.odN.setVisibility(8);
            this.odM.setVisibility(0);
            this.odM.setText(getString(2131231381, new Object[]{this.odQ}));
            this.odO.setOnClickListener(this.odT);
        } else {
            bDg();
        }
        ak.vy().a(487, (e) this);
    }

    protected void onStop() {
        super.onStop();
        ak.vy().b(487, (e) this);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindGoogleContactIntroUI odU;

            {
                this.odU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.odU.finish();
                return true;
            }
        });
        this.odL = (ImageView) findViewById(2131755598);
        this.odM = (TextView) findViewById(2131755599);
        this.odN = (Button) findViewById(2131755600);
        this.odO = (Button) findViewById(2131755601);
    }

    private void bDg() {
        this.odO.setVisibility(8);
        this.odN.setVisibility(0);
        this.odL.setVisibility(0);
        this.odM.setVisibility(0);
        this.odM.setText(2131231382);
        this.odN.setText(2131231380);
        this.odN.setOnClickListener(this.odS);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            if (i == 2005) {
                this.hVG = intent.getBooleanExtra("gpservices", false);
            }
        } else if (i == 2005) {
            this.hVG = intent.getBooleanExtra("gpservices", false);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactIntroUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = SQLiteDatabase.KeyEmpty;
        }
        objArr[2] = str;
        v.i(str2, str3, objArr);
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
        if (i == 0 && i2 == 0) {
            ak.yW();
            c.vf().set(208903, SQLiteDatabase.KeyEmpty);
            ak.yW();
            c.vf().set(208901, SQLiteDatabase.KeyEmpty);
            ak.yW();
            c.vf().set(208902, SQLiteDatabase.KeyEmpty);
            ak.yW();
            c.vf().set(208905, Boolean.valueOf(true));
            ak.yW();
            c.vf().iB(true);
            bDg();
            g.bf(this, getString(2131235706));
            return;
        }
        v.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
        Toast.makeText(this, 2131233155, 0).show();
    }
}
