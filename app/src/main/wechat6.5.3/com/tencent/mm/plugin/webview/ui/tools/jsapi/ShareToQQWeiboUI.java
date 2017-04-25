package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class ShareToQQWeiboUI extends MMActivity implements e {
    private ProgressDialog dwR = null;
    private TextView iJt;
    private EditText idd;

    protected final int getLayoutId() {
        return 2130903470;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(26, this);
        NI();
    }

    public void onDestroy() {
        ak.vy().b(26, this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131235297);
        this.idd = (EditText) findViewById(2131755329);
        this.iJt = (TextView) findViewById(2131756526);
        String stringExtra = getIntent().getStringExtra("content");
        Object stringExtra2 = getIntent().getStringExtra("shortUrl");
        this.idd.addTextChangedListener(new c(this.idd, this.iJt, 280));
        if (stringExtra.contains(stringExtra2)) {
            this.idd.setText(stringExtra.trim());
        } else {
            this.idd.setText(stringExtra + " " + stringExtra2);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareToQQWeiboUI lro;

            {
                this.lro = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lro.axg();
                this.lro.finish();
                return true;
            }
        });
        a(0, getString(2131231154), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareToQQWeiboUI lro;

            {
                this.lro = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                final z zVar = new z(this.lro.getIntent().getIntExtra(Columns.TYPE, 0), this.lro.getIntent().getStringExtra("shortUrl"), this.lro.idd.getText().toString());
                ak.vy().a(zVar, 0);
                ShareToQQWeiboUI shareToQQWeiboUI = this.lro;
                ActionBarActivity actionBarActivity = this.lro.nDR.nEl;
                this.lro.getString(2131231164);
                shareToQQWeiboUI.dwR = g.a(actionBarActivity, this.lro.getString(2131233725), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass2 lrp;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(zVar);
                    }
                });
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 26) {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (i == 0 && i2 == 0) {
                axg();
                setResult(-1);
                finish();
                return;
            }
            setResult(1, new Intent().putExtra("err_code", i2));
            Toast.makeText(this, getString(2131235294, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
