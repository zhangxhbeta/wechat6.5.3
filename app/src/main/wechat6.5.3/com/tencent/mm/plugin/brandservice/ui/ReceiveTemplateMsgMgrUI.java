package com.tencent.mm.plugin.brandservice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.brandservice.a.l;
import com.tencent.mm.protocal.c.ahf;
import com.tencent.mm.protocal.c.ahh;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;

public class ReceiveTemplateMsgMgrUI extends MMPreference implements e {
    private static LinkedList<ahf> ezs;
    private ProgressDialog dwR;
    protected f ezq;
    private String ezr;
    private boolean ezt = false;

    protected final int getLayoutId() {
        return 2130904243;
    }

    public final int Oo() {
        return 2131099709;
    }

    public final int YA() {
        return 2130904242;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(1031, this);
        ak.vy().a(1030, this);
        NI();
    }

    protected void onPause() {
        if (this.ezt) {
            v.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onPause option change");
            this.ezt = false;
            ak.vy().a(new l(this.ezr, ezs), 0);
        }
        super.onPause();
    }

    protected void onDestroy() {
        ak.vy().b(1031, this);
        ak.vy().b(1030, this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131232134);
        this.ezq = this.ocZ;
        this.ezr = getIntent().getStringExtra("enterprise_biz_name");
        if (be.kS(this.ezr)) {
            v.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "bizName is null");
            finish();
            return;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReceiveTemplateMsgMgrUI ezu;

            {
                this.ezu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ezu.finish();
                return true;
            }
        });
        final com.tencent.mm.plugin.brandservice.a.e eVar = new com.tencent.mm.plugin.brandservice.a.e(this.ezr);
        ak.vy().a(eVar, 0);
        getString(2131231164);
        this.dwR = g.a(this, getString(2131234351), true, new OnCancelListener(this) {
            final /* synthetic */ ReceiveTemplateMsgMgrUI ezu;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(eVar);
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        if (ezs == null) {
            v.w("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "mRecvOptions == null");
        } else {
            String str = preference.dnU;
            if (be.kS(str)) {
                v.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "key is null");
            } else {
                Iterator it = ezs.iterator();
                while (it.hasNext()) {
                    ahf com_tencent_mm_protocal_c_ahf = (ahf) it.next();
                    if (str.equals(be.ma(com_tencent_mm_protocal_c_ahf.mGT))) {
                        this.ezt = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            com_tencent_mm_protocal_c_ahf.mbK = 0;
                        } else {
                            com_tencent_mm_protocal_c_ahf.mbK = 1;
                        }
                        if (this.ezt) {
                            v.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                            ad.g(new Runnable(this) {
                                final /* synthetic */ ReceiveTemplateMsgMgrUI ezu;

                                {
                                    this.ezu = r1;
                                }

                                public final void run() {
                                    if (this.ezu.ezt) {
                                        this.ezu.ezt = false;
                                        ak.vy().a(new l(this.ezu.ezr, ReceiveTemplateMsgMgrUI.ezs), 0);
                                    }
                                }
                            }, 4000);
                        }
                    }
                }
                if (this.ezt) {
                    v.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "option change, do scene");
                    ad.g(/* anonymous class already generated */, 4000);
                }
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ahh com_tencent_mm_protocal_c_ahh = null;
        if (kVar == null) {
            v.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        v.i("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType())});
        if (kVar.getType() == 1031) {
            if (this.dwR != null && this.dwR.isShowing()) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.brandservice.a.e eVar = (com.tencent.mm.plugin.brandservice.a.e) kVar;
                if (!(eVar.cif == null || eVar.cif.czl.czs == null)) {
                    com_tencent_mm_protocal_c_ahh = (ahh) eVar.cif.czl.czs;
                }
                ezs = com_tencent_mm_protocal_c_ahh.mGU;
                LinkedList linkedList = ezs;
                this.ezq.removeAll();
                if (linkedList == null || linkedList.size() <= 0) {
                    v.e("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "recvOption is empty");
                    ce(true);
                    return;
                }
                ce(false);
                v.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBody options.size = %d", new Object[]{Integer.valueOf(linkedList.size())});
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ahf com_tencent_mm_protocal_c_ahf = (ahf) it.next();
                    CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                    checkBoxPreference.odB = false;
                    checkBoxPreference.setKey(com_tencent_mm_protocal_c_ahf.mGT);
                    checkBoxPreference.setTitle(com_tencent_mm_protocal_c_ahf.aXz);
                    checkBoxPreference.ocf = com_tencent_mm_protocal_c_ahf.mbK == 0;
                    this.ezq.a(checkBoxPreference);
                }
                this.ezq.notifyDataSetChanged();
                v.d("MicroMsg.brandservice.ReceiveTemplateMsgMgrUI", "initBodyView finish");
                return;
            }
            Toast.makeText(aa.getContext(), aa.getContext().getString(2131234348), 1).show();
            ce(true);
        } else if (kVar.getType() != 1030) {
        } else {
            if (i != 0 || i2 != 0) {
                Toast.makeText(aa.getContext(), aa.getContext().getString(2131234349), 0).show();
            }
        }
    }

    private void ce(boolean z) {
        View findViewById = findViewById(2131758814);
        View findViewById2 = findViewById(2131758813);
        if (findViewById == null) {
            return;
        }
        if (z) {
            ((TextView) findViewById).setVisibility(0);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
                return;
            }
            return;
        }
        ((TextView) findViewById).setVisibility(8);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
    }
}
