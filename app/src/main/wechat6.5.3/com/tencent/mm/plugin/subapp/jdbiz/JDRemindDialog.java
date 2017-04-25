package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mmdb.database.SQLiteDatabase;

public class JDRemindDialog extends MMBaseActivity {
    private h doc = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        MS();
    }

    protected void onResume() {
        super.onResume();
        w.a(true, null);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.doc != null) {
            this.doc.dismiss();
            this.doc = null;
        }
        MS();
    }

    protected void onPause() {
        super.onPause();
        w.a(false, null);
    }

    private void MS() {
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                a aVar = new a(this);
                aVar.Op(SQLiteDatabase.KeyEmpty);
                aVar.Oq(extras.getString("alertcontent"));
                aVar.Os(extras.getString("alertconfirm")).a(new OnClickListener(this) {
                    final /* synthetic */ JDRemindDialog keQ;

                    {
                        this.keQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String str = null;
                        String str2 = SQLiteDatabase.KeyEmpty;
                        if (!(this.keQ.getIntent() == null || this.keQ.getIntent().getExtras() == null)) {
                            str = this.keQ.getIntent().getExtras().getString("alertjumpurl");
                            str2 = this.keQ.getIntent().getExtras().getString("alert_activityid");
                        }
                        if (str2.equals(c.aZi().aZn().keV) && c.aZi().aZj()) {
                            c.aZi().aZm();
                            c.aZi().aZl();
                        }
                        if (!be.kS(str)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("useJs", true);
                            intent.putExtra("vertical_scroll", true);
                            c.b(this.keQ, "webview", ".ui.tools.WebViewUI", intent);
                            g.iuh.h(11179, str, c.aZi().aZn().keV, Integer.valueOf(5));
                        }
                        this.keQ.finish();
                    }
                });
                aVar.Ot(extras.getString("alert_cancel")).b(new OnClickListener(this) {
                    final /* synthetic */ JDRemindDialog keQ;

                    {
                        this.keQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.keQ.finish();
                    }
                });
                this.doc = aVar.RX();
                this.doc.setCanceledOnTouchOutside(false);
                this.doc.show();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, JDRemindDialog.class);
        intent.putExtra("alertcontent", str);
        intent.putExtra("alertconfirm", str2);
        intent.putExtra("alert_cancel", str3);
        intent.putExtra("alertjumpurl", str4);
        intent.putExtra("alert_activityid", str5);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
