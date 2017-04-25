package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.safedevice.a.c;
import com.tencent.mm.plugin.safedevice.ui.SafeDeviceListPreference.b;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import java.util.LinkedList;
import java.util.List;

public class MySafeDeviceListUI extends MMPreference implements com.tencent.mm.sdk.h.g.a, e {
    private ProgressDialog dwR = null;
    private f dxf;
    private ac handler = new ac(this) {
        final /* synthetic */ MySafeDeviceListUI iuQ;

        {
            this.iuQ = r1;
        }

        public final void handleMessage(Message message) {
            this.iuQ.dxf.notifyDataSetChanged();
            super.handleMessage(message);
        }
    };
    private int iuK = -2;
    private List<SafeDeviceListPreference> iuL;
    private a iuM;
    private boolean iuN = true;
    private List<c> iuO;
    private OnMenuItemClickListener iuP = new OnMenuItemClickListener(this) {
        final /* synthetic */ MySafeDeviceListUI iuQ;

        {
            this.iuQ = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            MySafeDeviceListUI.a(this.iuQ);
            return true;
        }
    };

    private class a implements com.tencent.mm.plugin.safedevice.ui.SafeDeviceListPreference.a, b {
        final /* synthetic */ MySafeDeviceListUI iuQ;

        private a(MySafeDeviceListUI mySafeDeviceListUI) {
            this.iuQ = mySafeDeviceListUI;
        }

        public final void yM(String str) {
            this.iuQ.dxf.Ox(str);
            this.iuQ.handler.sendEmptyMessage(0);
            this.iuQ.a(0, this.iuQ.getString(2131234703), this.iuQ.iuP);
            this.iuQ.iuK = this.iuQ.iuK ^ -1;
            this.iuQ.ff(this.iuQ.iuN);
        }

        public final void yN(String str) {
            v.e("MicroMsg.MySafeDeviceListUI", "delete safedevice failed" + str);
        }
    }

    static /* synthetic */ void a(MySafeDeviceListUI mySafeDeviceListUI) {
        if (mySafeDeviceListUI.iuL != null && mySafeDeviceListUI.iuL.size() > 0) {
            mySafeDeviceListUI.iuK ^= -1;
            for (SafeDeviceListPreference oU : mySafeDeviceListUI.iuL) {
                oU.oU(mySafeDeviceListUI.iuK);
            }
            mySafeDeviceListUI.dxf.notifyDataSetChanged();
        }
        if (mySafeDeviceListUI.iuK == 1) {
            mySafeDeviceListUI.a(0, mySafeDeviceListUI.getString(2131231065), mySafeDeviceListUI.iuP);
        } else {
            mySafeDeviceListUI.a(0, mySafeDeviceListUI.getString(2131234703), mySafeDeviceListUI.iuP);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(302, this);
        ak.vy().a(361, this);
        com.tencent.mm.plugin.safedevice.a.f.aKJ().c(this);
        NI();
        final q qVar = new q(k.xF());
        ak.vy().a(qVar, 0);
        getString(2131231164);
        this.dwR = g.a(this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ MySafeDeviceListUI iuQ;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(qVar);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(302, this);
        ak.vy().b(361, this);
        com.tencent.mm.plugin.safedevice.a.f.aKJ().d(this);
    }

    protected void onResume() {
        super.onResume();
        this.iuN = k.xN();
        ff(this.iuN);
    }

    public final int Oo() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (be.kS(str)) {
            v.e("MicroMsg.MySafeDeviceListUI", "null key");
            return false;
        }
        if (str.equals("safe_device_verify_check")) {
            final boolean isChecked = ((CheckBoxPreference) preference).isChecked();
            if (!isChecked) {
                g.b(this, 2131234699, 2131234698, new OnClickListener(this) {
                    final /* synthetic */ MySafeDeviceListUI iuQ;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.iuQ.iuN = isChecked;
                        this.iuQ.ff(this.iuQ.iuN);
                        com.tencent.mm.plugin.safedevice.a.e.o(false, true);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ MySafeDeviceListUI iuQ;

                    {
                        this.iuQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.iuQ.ff(this.iuQ.iuN);
                        if (this.iuQ.iuK == 1) {
                            for (SafeDeviceListPreference oU : this.iuQ.iuL) {
                                oU.oU(this.iuQ.iuK);
                            }
                            this.iuQ.handler.sendEmptyMessage(0);
                        }
                    }
                });
            } else if (!this.iuN) {
                ak.yW();
                if (((Integer) com.tencent.mm.model.c.vf().get(64, Integer.valueOf(-1))).intValue() != 1) {
                    g.b(this, 2131234723, 2131234724, new OnClickListener(this) {
                        final /* synthetic */ MySafeDeviceListUI iuQ;

                        {
                            this.iuQ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ak.yW();
                            String str = (String) com.tencent.mm.model.c.vf().get(6, null);
                            if (be.kS(str)) {
                                v.d("MicroMsg.MySafeDeviceListUI", "not bind mobile");
                                return;
                            }
                            Intent intent = new Intent(this.iuQ, SecurityAccountIntroUI.class);
                            intent.putExtra("binded_mobile", str);
                            intent.putExtra("re_open_verify", true);
                            MMWizardActivity.w(this.iuQ, intent);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ MySafeDeviceListUI iuQ;

                        {
                            this.iuQ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.iuQ.ff(this.iuQ.iuN);
                        }
                    });
                } else {
                    this.iuN = isChecked;
                    ff(this.iuN);
                    com.tencent.mm.plugin.safedevice.a.e.o(true, true);
                }
            }
        } else if (str.startsWith("mysafedevice_")) {
            SafeDeviceListPreference safeDeviceListPreference = (SafeDeviceListPreference) preference;
            if (safeDeviceListPreference != null) {
                final c cVar = safeDeviceListPreference.iuV;
                g.a(this.nDR.nEl, getString(2131234705), cVar.field_name, getString(2131234708), -1, new g.b(this) {
                    final /* synthetic */ MySafeDeviceListUI iuQ;

                    public final boolean r(CharSequence charSequence) {
                        String trim = charSequence == null ? "" : charSequence.toString().trim();
                        if (trim.equals(cVar.field_name)) {
                            return true;
                        }
                        if (trim.length() <= 0) {
                            g.bf(this.iuQ.nDR.nEl, this.iuQ.getString(2131234704));
                            return false;
                        }
                        final com.tencent.mm.plugin.safedevice.a.b bVar = new com.tencent.mm.plugin.safedevice.a.b(cVar.field_uid, trim, cVar.field_devicetype);
                        ak.vy().a(bVar, 0);
                        if (this.iuQ.dwR != null) {
                            this.iuQ.dwR.dismiss();
                        }
                        this.iuQ.dwR = g.a(this.iuQ, com.tencent.mm.bd.a.O(this.iuQ, 2131231182), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass9 iuU;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(bVar);
                            }
                        });
                        return true;
                    }
                });
            }
        }
        return true;
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MySafeDeviceListUI iuQ;

            {
                this.iuQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iuQ.finish();
                return true;
            }
        });
        this.dxf = this.ocZ;
        this.iuL = new LinkedList();
        this.iuM = new a();
        a(0, getString(2131234703), this.iuP);
        vD(2131234690);
    }

    private void ff(boolean z) {
        this.iuL.clear();
        this.iuO = com.tencent.mm.plugin.safedevice.a.f.aKJ().aKF();
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099715);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("safe_device_verify_check");
        if (checkBoxPreference != null) {
            checkBoxPreference.ocf = z;
        }
        if (this.iuO.size() == 0) {
            this.dxf.Ox("my_safe_device_list_tip");
            iU(false);
            return;
        }
        if (this.iuK == 1) {
            a(0, getString(2131234703), this.iuP);
            this.iuK ^= -1;
        }
        for (c cVar : this.iuO) {
            SafeDeviceListPreference safeDeviceListPreference = new SafeDeviceListPreference(this);
            safeDeviceListPreference.setKey("mysafedevice_" + cVar.field_uid);
            safeDeviceListPreference.setTitle(com.tencent.mm.pluginsdk.ui.d.e.a(this, cVar.field_name));
            if (!com.tencent.mm.sdk.platformtools.f.nia) {
                safeDeviceListPreference.setSummary(cVar.field_devicetype);
            }
            safeDeviceListPreference.iuX = this.iuM;
            safeDeviceListPreference.iuY = this.iuM;
            safeDeviceListPreference.iuV = cVar;
            this.dxf.a(safeDeviceListPreference, -1);
            this.iuL.add(safeDeviceListPreference);
        }
        iU(true);
    }

    public final void a(String str, i iVar) {
        v.i("MicroMsg.MySafeDeviceListUI", "notify " + str);
        this.handler.post(new Runnable(this) {
            final /* synthetic */ MySafeDeviceListUI iuQ;

            {
                this.iuQ = r1;
            }

            public final void run() {
                this.iuQ.ff(this.iuQ.iuN);
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (kVar.getType() == 302) {
            if (i == 0 && i2 == 0) {
                this.iuN = k.xN();
                ff(this.iuN);
            } else if (!com.tencent.mm.plugin.a.a.drq.a(this, i, i2, str)) {
                Toast.makeText(this, getString(2131234706, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        } else if (kVar.getType() != 361) {
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.safedevice.a.b bVar = (com.tencent.mm.plugin.safedevice.a.b) kVar;
                c cVar = new c();
                cVar.field_devicetype = bVar.aZN;
                cVar.field_name = bVar.deviceName;
                cVar.field_uid = bVar.aRh;
                cVar.field_createtime = 0;
                com.tencent.mm.plugin.safedevice.a.f.aKJ().a(cVar, new String[0]);
                g.bf(this, com.tencent.mm.bd.a.O(this, 2131234709));
            } else if (!com.tencent.mm.plugin.a.a.drq.a(this, i, i2, str)) {
            }
        }
    }
}
