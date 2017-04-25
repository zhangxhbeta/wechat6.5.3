package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactLearmMoreUI extends MMWizardActivity {
    private String bhT;
    private List<String[]> cHz = null;
    private String cZU = null;
    private e daB = null;
    private ProgressDialog dwR = null;
    private String nKT = SQLiteDatabase.KeyEmpty;
    private int nKU = 2;
    private aa ofT;
    private Button ogk;
    private TextView ogl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cZU = getIntent().getStringExtra("regsetinfo_ticket");
        this.nKT = getIntent().getStringExtra("regsetinfo_NextStep");
        this.nKU = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        NI();
    }

    public void onDestroy() {
        if (this.daB != null) {
            ak.vy().b(431, this.daB);
            this.daB = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        b.mh("R300_100_phone");
        b.b(true, ak.uR() + "," + getClass().getName() + ",RE300_600," + ak.dR("RE300_600") + ",1");
    }

    protected void onPause() {
        super.onPause();
        b.b(false, ak.uR() + "," + getClass().getName() + ",RE300_600," + ak.dR("RE300_600") + ",2");
    }

    protected final void NI() {
        vD(2131232825);
        this.ogk = (Button) findViewById(2131757039);
        this.ogl = (TextView) findViewById(2131757038);
        this.ogk.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FindMContactLearmMoreUI ogm;

            {
                this.ogm = r1;
            }

            public final void onClick(View view) {
                ak.yW();
                c.vf().set(12322, Boolean.valueOf(true));
                l.g(true, false);
                this.ogm.bDq();
            }
        });
        this.ogl.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FindMContactLearmMoreUI ogm;

            {
                this.ogm = r1;
            }

            public final void onClick(View view) {
                ak.yW();
                c.vf().set(12322, Boolean.valueOf(false));
                l.g(false, false);
                this.ogm.aKM();
            }
        });
        ak.yW();
        c.vf().set(12323, Boolean.valueOf(true));
        ak.yW();
        this.bhT = (String) c.vf().get(6, null);
        if (this.bhT == null || this.bhT.equals(SQLiteDatabase.KeyEmpty)) {
            ak.yW();
            this.bhT = (String) c.vf().get(4097, null);
        }
    }

    private void bDq() {
        v.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), be.bur());
        if (a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            n vy = ak.vy();
            e anonymousClass3 = new e(this) {
                final /* synthetic */ FindMContactLearmMoreUI ogm;

                {
                    this.ogm = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (this.ogm.dwR != null) {
                        this.ogm.dwR.dismiss();
                        this.ogm.dwR = null;
                    }
                    if (this.ogm.daB != null) {
                        ak.vy().b(431, this.ogm.daB);
                        this.ogm.daB = null;
                    }
                    if (i == 0 && i2 == 0) {
                        int i3;
                        LinkedList Fx = ((aa) kVar).Fx();
                        ah.g(Fx);
                        int i4;
                        if (Fx == null || Fx.size() <= 0) {
                            i4 = 0;
                            i3 = 0;
                        } else {
                            Iterator it = Fx.iterator();
                            i3 = 0;
                            while (it.hasNext()) {
                                agl com_tencent_mm_protocal_c_agl = (agl) it.next();
                                if (com_tencent_mm_protocal_c_agl != null) {
                                    if (com_tencent_mm_protocal_c_agl.eeO == 1) {
                                        i4 = i3 + 1;
                                    } else {
                                        i4 = i3;
                                    }
                                    i3 = i4;
                                }
                            }
                            i4 = i3 > 0 ? 1 : 0;
                        }
                        String str2 = "MicroMsg.FindMContactLearmMoreUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(Fx == null ? 0 : Fx.size());
                        objArr[1] = Integer.valueOf(i3);
                        v.d(str2, str3, objArr);
                        if (this.ogm.nKT == null || !this.ogm.nKT.contains("1") || r0 == 0) {
                            this.ogm.aKM();
                            return;
                        }
                        b.mi("R300_300_phone");
                        Intent intent = new Intent(this.ogm, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", this.ogm.cZU);
                        intent.putExtra("regsetinfo_NextStep", this.ogm.nKT);
                        intent.putExtra("regsetinfo_NextStyle", this.ogm.nKU);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.w(this.ogm, intent);
                        return;
                    }
                    Toast.makeText(this.ogm, this.ogm.getString(2131231042, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    this.ogm.aKM();
                }
            };
            this.daB = anonymousClass3;
            vy.a(431, anonymousClass3);
            Context context = this.nDR.nEl;
            getString(2131231164);
            this.dwR = g.a(context, getString(2131236682), true, new OnCancelListener(this) {
                final /* synthetic */ FindMContactLearmMoreUI ogm;

                {
                    this.ogm = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.ogm.daB != null) {
                        ak.vy().b(431, this.ogm.daB);
                        this.ogm.daB = null;
                    }
                }
            });
            ak.vA().a(new ad.a(this) {
                final /* synthetic */ FindMContactLearmMoreUI ogm;

                {
                    this.ogm = r1;
                }

                public final boolean Ba() {
                    if (this.ogm.cHz == null || this.ogm.cHz.size() == 0) {
                        if (this.ogm.dwR != null) {
                            this.ogm.dwR.dismiss();
                            this.ogm.dwR = null;
                        }
                        this.ogm.aKM();
                    } else {
                        this.ogm.ofT = new aa(this.ogm.cZU, this.ogm.cHz);
                        ak.vy().a(this.ogm.ofT, 0);
                    }
                    return false;
                }

                public final boolean AZ() {
                    try {
                        this.ogm.cHz = com.tencent.mm.pluginsdk.a.cW(this.ogm);
                        v.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg mobileList size " + (this.ogm.cHz == null ? 0 : this.ogm.cHz.size()));
                    } catch (Throwable e) {
                        v.a("MicroMsg.FindMContactLearmMoreUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
            l.g(true, false);
            com.tencent.mm.modelfriend.a.Ew();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aKM();
        return true;
    }

    private void aKM() {
        axg();
        bAv();
    }

    protected final int getLayoutId() {
        return 2130903641;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.FindMContactLearmMoreUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bDq();
                    return;
                } else {
                    g.a((Context) this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FindMContactLearmMoreUI ogm;

                        {
                            this.ogm = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.ogm.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FindMContactLearmMoreUI ogm;

                        {
                            this.ogm = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
