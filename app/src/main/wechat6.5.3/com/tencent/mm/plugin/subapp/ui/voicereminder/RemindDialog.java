package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.ab.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.plugin.subapp.c.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class RemindDialog extends Activity {
    private static boolean fJm = false;
    private static List<String> khR = new ArrayList();
    private String bdo = SQLiteDatabase.KeyEmpty;
    private ac handler = new ac();
    private h iji;
    private List<String> khQ = new ArrayList();
    private e khS = new e(this) {
        final /* synthetic */ RemindDialog khT;

        {
            this.khT = r1;
        }

        public final void g(String str, long j) {
            v.d("MicroMsg.RemindDialog", "onVoiceRemind " + str);
            this.khT.khQ.add(str);
            this.khT.aZE();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        h.a aVar = new h.a(this);
        aVar.wm(2131235835);
        aVar.Oq(" ");
        aVar.wp(2131235832).a(new OnClickListener(this) {
            final /* synthetic */ RemindDialog khT;

            {
                this.khT = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                d aZu = d.aZu();
                if (aZu != null) {
                    aZu.fE(this.khT.bdo);
                }
                if (m.fa(ak.oH().qr())) {
                    this.khT.finish();
                    return;
                }
                b.drp.e(new Intent().putExtra("Chat_User", this.khT.bdo), this.khT);
                this.khT.finish();
            }
        });
        aVar.wq(2131235834).b(new OnClickListener(this) {
            final /* synthetic */ RemindDialog khT;

            {
                this.khT = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                d aZu = d.aZu();
                if (aZu != null) {
                    aZu.fE(this.khT.bdo);
                }
                this.khT.finish();
            }
        });
        aVar.a(new OnDismissListener(this) {
            final /* synthetic */ RemindDialog khT;

            {
                this.khT = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.khT.finish();
            }
        });
        this.bdo = getIntent().getStringExtra("_RemindDialog_User");
        String stringExtra = getIntent().getStringExtra("_RemindDialog_Remind");
        this.khQ.clear();
        this.khQ.add(stringExtra);
        for (String stringExtra2 : khR) {
            this.khQ.add(stringExtra2);
        }
        this.iji = aVar.RX();
        this.iji.setCanceledOnTouchOutside(false);
        this.iji.show();
        aZE();
    }

    private void aZE() {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ RemindDialog khT;

            {
                this.khT = r1;
            }

            public final void run() {
                CharSequence stringBuffer = new StringBuffer();
                for (String str : this.khT.khQ) {
                    if (be.kS(str)) {
                        stringBuffer.append("\n\n");
                    } else {
                        stringBuffer.append(str + "\n\n");
                    }
                }
                if (this.khT.iji != null) {
                    this.khT.iji.setMessage(stringBuffer);
                }
            }
        });
    }

    public void onResume() {
        fJm = true;
        d aZu = d.aZu();
        if (aZu != null) {
            aZu.a(this.khS);
        }
        super.onResume();
    }

    public void onPause() {
        fJm = false;
        d aZu = d.aZu();
        if (aZu != null) {
            aZu.b(this.khS);
        }
        super.onPause();
    }

    public static void r(Context context, String str, String str2) {
        v.d("MicroMsg.RemindDialog", "show " + fJm + " remind " + str2);
        if (fJm) {
            khR.add(str2);
            return;
        }
        khR.clear();
        fJm = true;
        if (ak.vy().foreground) {
            Intent intent = new Intent(context, RemindDialog.class);
            intent.putExtra("_RemindDialog_User", str);
            intent.putExtra("_RemindDialog_Remind", str2);
            intent.setFlags(603979776);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            return;
        }
        intent = new Intent(context, RemindDialog.class);
        intent.putExtra("_RemindDialog_User", str);
        intent.putExtra("_RemindDialog_Remind", str2);
        intent.setFlags(604012544);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
    }
}
