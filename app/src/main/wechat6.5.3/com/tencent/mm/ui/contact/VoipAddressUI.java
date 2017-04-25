package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI extends MMBaseSelectContactUI {
    private String bdo = SQLiteDatabase.KeyEmpty;
    private List<String> ejp;
    private boolean oIZ = false;
    private boolean oJa = false;
    private c oJb = new c<qi>(this) {
        final /* synthetic */ VoipAddressUI oJc;

        {
            this.oJc = r2;
            this.nhz = qi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            switch (((qi) bVar).brC.bdn) {
                case 7:
                    this.oJc.finish();
                    break;
                case 8:
                    this.oJc.finish();
                    break;
            }
            return false;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.nhr.e(this.oJb);
    }

    public final void gJ(int i) {
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) this.ieb.getAdapter().getItem(i);
        if (aVar != null && aVar.euW != null) {
            this.bdo = aVar.euW.field_username;
            if (this.oJa) {
                aGQ();
            } else {
                aGP();
            }
        }
    }

    private void aGP() {
        v.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this);
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
            b qiVar = new qi();
            qiVar.brC.bdn = 5;
            qiVar.brC.bdo = this.bdo;
            qiVar.brC.context = this;
            int i = this.oIZ ? 2 : 1;
            qiVar.brC.brx = 3;
            g.iuh.h(11033, Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0));
            a.nhr.z(qiVar);
            axg();
        }
    }

    private void aGQ() {
        v.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this);
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
            v.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 19, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this);
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 19, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                b qiVar = new qi();
                qiVar.brC.bdn = 5;
                qiVar.brC.bdo = this.bdo;
                qiVar.brC.context = this;
                int i = this.oIZ ? 2 : 1;
                qiVar.brC.brx = 2;
                g.iuh.h(11033, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0));
                a.nhr.z(qiVar);
                axg();
            }
        }
    }

    protected final void NH() {
        super.NH();
        String stringExtra = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
        this.oJa = getIntent().getBooleanExtra("voip_video", true);
        if (stringExtra != null) {
            this.oIZ = true;
            if (stringExtra.equals("launch_type_voip")) {
                this.oJa = true;
            } else if (stringExtra.equals("launch_type_voip_audio")) {
                this.oJa = false;
            }
        }
        this.ejp = new ArrayList();
        this.ejp.addAll(r.bHP());
        this.ejp.addAll(r.bHQ());
    }

    protected final n NL() {
        c.a aVar = new c.a();
        aVar.oER = true;
        aVar.oEQ = true;
        return new c(this, this.ejp, true, false, aVar);
    }

    protected final p NM() {
        return new p(this, this.ejp, false, this.scene);
    }

    public static void eD(Context context) {
        int i = 0;
        boolean z = 1 == be.getInt(j.sU().getValue("VOIPCallType"), 0);
        Intent intent = new Intent(context, VoipAddressUI.class);
        intent.putExtra("Add_address_titile", context.getString(2131230883));
        intent.putExtra("voip_video", z);
        context.startActivity(intent);
        g gVar = g.iuh;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(1);
        if (!z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.h(11034, objArr);
    }

    protected final boolean NJ() {
        return true;
    }

    public final int[] ayD() {
        return new int[]{131072};
    }

    public void onDestroy() {
        a.nhr.f(this.oJb);
        super.onDestroy();
    }

    protected final void ayE() {
        if (this.oIZ) {
            Intent intent = new Intent(this, LauncherUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
        }
        axg();
        finish();
    }

    protected final String NK() {
        String stringExtra = getIntent().getStringExtra("Add_address_titile");
        if (be.kS(stringExtra)) {
            return stringExtra;
        }
        return getString(2131230883);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.VoipAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    aGQ();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? 2131234160 : 2131234163;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ VoipAddressUI oJc;

                        {
                            this.oJc = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.oJc.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ VoipAddressUI oJc;

                        {
                            this.oJc = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case 82:
                if (iArr[0] == 0) {
                    aGP();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ VoipAddressUI oJc;

                        {
                            this.oJc = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oJc.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }
}
