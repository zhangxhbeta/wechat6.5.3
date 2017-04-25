package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.protocal.c.afp;
import com.tencent.mm.protocal.c.bcz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelEditUI extends MMPreference implements e {
    private ProgressDialog eZg;
    private boolean gKp = true;
    private String gPW;
    private String gPX;
    private String gPY;
    private w gPZ;
    private String gQa;
    private f gQb;
    private ContactListExpandPreference gQc;
    private InputClearablePreference gQd;
    private Preference gQe;
    private PreferenceTitleCategory gQf;
    private boolean gQg = true;
    private ArrayList<String> gQh = new ArrayList();
    private ArrayList<String> gQi = new ArrayList();
    private HashSet<String> gQj = new HashSet();
    private HashSet<String> gQk = new HashSet();
    private String gQl;
    private ac mHandler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ ContactLabelEditUI gQm;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 6001:
                    this.gQm.avN();
                    return;
                case 6002:
                    a.drq.ow();
                    return;
                default:
                    v.w("MicroMsg.Label.ContactLabelEditUI", "unknow message. what is:%d", new Object[]{Integer.valueOf(message.what)});
                    return;
            }
        }
    };

    static /* synthetic */ void a(ContactLabelEditUI contactLabelEditUI, String str) {
        v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealRemoveContact]");
        if (contactLabelEditUI.gQh != null && contactLabelEditUI.gQh.contains(str)) {
            contactLabelEditUI.gQh.remove(str);
        }
        if (contactLabelEditUI.gQi != null && contactLabelEditUI.gQi.contains(str)) {
            contactLabelEditUI.gQk.add(str);
        }
        if (contactLabelEditUI.gQj != null && contactLabelEditUI.gQj.contains(str)) {
            contactLabelEditUI.gQj.remove(str);
        }
        if (contactLabelEditUI.mHandler != null) {
            contactLabelEditUI.mHandler.sendEmptyMessage(6001);
        }
    }

    static /* synthetic */ void b(ContactLabelEditUI contactLabelEditUI) {
        v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveLabelChange]");
        contactLabelEditUI.vz(contactLabelEditUI.getString(2131233468));
        contactLabelEditUI.gPX = be.ah(contactLabelEditUI.gPX, "");
        contactLabelEditUI.gPX = contactLabelEditUI.gPX.trim();
        if (be.kS(contactLabelEditUI.gPX)) {
            contactLabelEditUI.avM();
            contactLabelEditUI.rI(contactLabelEditUI.getString(2131233460));
        } else if (h.PC(contactLabelEditUI.gPX) > 36) {
            contactLabelEditUI.avM();
            contactLabelEditUI.rI(String.format(contactLabelEditUI.getString(2131230808), new Object[]{Integer.valueOf(h.aw(36, ""))}));
        } else if (!(vB(contactLabelEditUI.gPX) && contactLabelEditUI.gQg) && (!vB(contactLabelEditUI.gPX) || be.kS(contactLabelEditUI.gPW) || contactLabelEditUI.gPW.equals(contactLabelEditUI.gPX))) {
            w LP = com.tencent.mm.plugin.label.e.avK().LP(contactLabelEditUI.gPY);
            if (contactLabelEditUI.gQg || LP.field_isTemporary) {
                ak.vy().a(new com.tencent.mm.plugin.label.a.a(contactLabelEditUI.gPX), 0);
                return;
            }
            ak.vy().a(new com.tencent.mm.plugin.label.a.e(Integer.valueOf(contactLabelEditUI.gPY).intValue(), contactLabelEditUI.gPX), 0);
        } else {
            contactLabelEditUI.avM();
            contactLabelEditUI.rI(contactLabelEditUI.getString(2131230805));
        }
    }

    static /* synthetic */ void d(ContactLabelEditUI contactLabelEditUI) {
        v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealAddContact]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", r.s(new int[]{r.oHJ, 1024}));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelEditUI.getString(2131233452));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 6);
        if (contactLabelEditUI.gQh != null) {
            intent.putExtra("always_select_contact", be.b(contactLabelEditUI.gQh, ","));
        }
        c.a(contactLabelEditUI, ".ui.contact.SelectContactUI", intent, 7001);
    }

    static /* synthetic */ void l(ContactLabelEditUI contactLabelEditUI) {
        if (contactLabelEditUI.gPZ.field_isTemporary) {
            contactLabelEditUI.a(contactLabelEditUI.gPZ);
            return;
        }
        w wVar = contactLabelEditUI.gPZ;
        if (wVar == null) {
            v.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteScene] can not do scene. lable is null");
            return;
        }
        contactLabelEditUI.vz(contactLabelEditUI.getString(2131233456));
        ak.vy().a(new b(wVar.field_labelID), 0);
    }

    public final int Oo() {
        return 2131099698;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gQl = k.xF();
        this.gPY = getIntent().getStringExtra("label_id");
        this.gPW = getIntent().getStringExtra("label_name");
        this.gPX = getIntent().getStringExtra("label_name");
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (!be.kS(stringExtra)) {
            List g = be.g(stringExtra.split(","));
            this.gQh = new ArrayList();
            if (g != null && g.size() > 0) {
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    stringExtra = (String) g.get(i);
                    if (!be.kS(stringExtra)) {
                        if (!m.eC(stringExtra) || this.gQh.contains(stringExtra) || stringExtra.equals(this.gQl)) {
                            v.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[]{stringExtra});
                        } else {
                            this.gQh.add(stringExtra);
                            this.gQj.add(stringExtra);
                        }
                    }
                }
            }
        }
        ak.vy().a(635, this);
        ak.vy().a(637, this);
        ak.vy().a(638, this);
        NI();
    }

    protected void onResume() {
        d.a(3, "ContactLabelEditUI" + avS(), hashCode());
        ak.vy().a(636, this);
        vA(this.gPX);
        avN();
        super.onResume();
    }

    protected void onPause() {
        d.a(4, "ContactLabelEditUI" + avS(), hashCode());
        ak.vy().b(636, this);
        super.onPause();
    }

    protected void onDestroy() {
        ak.vy().b(635, this);
        ak.vy().b(637, this);
        ak.vy().b(638, this);
        super.onDestroy();
    }

    protected final void NI() {
        if (be.kS(this.gPY)) {
            this.gQg = true;
            this.gQa = getString(2131234241);
        } else {
            this.gQg = false;
            this.gPZ = com.tencent.mm.plugin.label.e.avK().LP(this.gPY);
            this.gQa = getString(2131234240);
        }
        Fd(this.gQa);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelEditUI gQm;

            {
                this.gQm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gQm.onBackPressed();
                return true;
            }
        });
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelEditUI gQm;

            {
                this.gQm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelEditUI.b(this.gQm);
                return true;
            }
        }, com.tencent.mm.ui.k.b.nET);
        this.gQb = this.ocZ;
        this.gQc = (ContactListExpandPreference) this.gQb.Ow("contact_label_contact_list");
        this.gQc.a(this.gQb, this.gQc.dnU);
        this.gQc.hZ(true);
        this.gQc.ia(true);
        this.gQc.bpo();
        this.gQc.bpn();
        this.gQc.bpr();
        this.gQc.a(new com.tencent.mm.pluginsdk.ui.applet.f.b(this) {
            final /* synthetic */ ContactLabelEditUI gQm;

            {
                this.gQm = r1;
            }

            public final boolean jn(int i) {
                return false;
            }
        });
        this.gQc.a(new ContactListExpandPreference.a(this) {
            final /* synthetic */ ContactLabelEditUI gQm;

            {
                this.gQm = r1;
            }

            public final void jp(int i) {
                if (this.gQm.gQc.tW(i)) {
                    String tY = this.gQm.gQc.tY(i);
                    String tZ = this.gQm.gQc.tZ(i);
                    if (!be.kS(tY)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", tY);
                        intent.putExtra("Contact_RoomNickname", tZ);
                        a.drp.d(intent, this.gQm);
                    }
                }
            }

            public final void adp() {
                if (this.gQm.gQc != null) {
                    this.gQm.gQc.bpp();
                }
            }

            public final void jq(int i) {
                ContactLabelEditUI.d(this.gQm);
            }

            public final void jo(int i) {
                v.d("MicroMsg.Label.ContactLabelEditUI", "cpan[onItemDelClick] position:%d userName:%s", new Object[]{Integer.valueOf(i), this.gQm.gQc.tY(i)});
                ContactLabelEditUI.a(this.gQm, r0);
            }
        });
        this.gQd = (InputClearablePreference) this.gQb.Ow("contact_label_name");
        InputClearablePreference inputClearablePreference = this.gQd;
        inputClearablePreference.gRu = getString(2131233457);
        if (inputClearablePreference.gRz != null) {
            inputClearablePreference.gRz.setHint(inputClearablePreference.gRu);
        }
        this.gQd.dHa = getString(2131233466);
        inputClearablePreference = this.gQd;
        inputClearablePreference.gRv = getString(2131230807);
        if (inputClearablePreference.gRB != null) {
            inputClearablePreference.gRB.setText(inputClearablePreference.gRv);
        }
        this.gQd.gRw = 36;
        this.gQd.gRy = this.gQg;
        this.gQd.gRD = new InputClearablePreference.a(this) {
            final /* synthetic */ ContactLabelEditUI gQm;

            {
                this.gQm = r1;
            }

            public final void vC(String str) {
                this.gQm.gPX = str;
                this.gQm.vA(str);
                this.gQm.gQd.dT(false);
            }

            public final void dR(boolean z) {
                if (this.gQm.gQg || !this.gQm.gKp) {
                    this.gQm.iT(z);
                    return;
                }
                this.gQm.iT(false);
                this.gQm.gKp = false;
            }
        };
        this.gQd.setText(this.gPX);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(6001);
        }
        if (!this.gQg) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ ContactLabelEditUI gQm;

                {
                    this.gQm = r1;
                }

                public final void run() {
                    ArrayList LN = com.tencent.mm.plugin.label.e.avK().LN(this.gQm.gPY);
                    if (LN == null) {
                        v.w("MicroMsg.Label.ContactLabelEditUI", "result is null");
                        return;
                    }
                    if (LN != null) {
                        this.gQm.gQh = LN;
                        if (this.gQm.gQi == null) {
                            this.gQm.gQi = new ArrayList();
                        } else {
                            this.gQm.gQi.clear();
                        }
                        this.gQm.gQi.addAll(LN);
                    }
                    if (this.gQm.mHandler != null) {
                        this.gQm.mHandler.sendEmptyMessage(6001);
                    }
                }

                public final String toString() {
                    return super.toString() + "|initView";
                }
            });
        } else if (this.gQh == null || this.gQh.size() <= 0) {
            this.gQc.X(new ArrayList());
        } else {
            this.gQc.j(null, this.gQh);
        }
        if (this.gMx != null) {
            this.gMx.setOnScrollListener(new OnScrollListener(this) {
                final /* synthetic */ ContactLabelEditUI gQm;

                {
                    this.gQm = r1;
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i == 2 || i == 1) {
                        this.gQm.axg();
                    }
                }

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                }
            });
        }
        this.gQe = this.gQb.Ow("contact_label_delete");
        this.gQf = (PreferenceTitleCategory) this.gQb.Ow("contact_label_empty_category");
        if (this.gQg) {
            this.gQb.b(this.gQe);
            this.gQb.b(this.gQf);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 7001:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[]{stringExtra});
                    if (!be.kS(stringExtra)) {
                        List g = be.g(stringExtra.split(","));
                        if (g != null && g.size() > 0) {
                            int size = g.size();
                            int i3 = 0;
                            while (i3 < size) {
                                stringExtra = (String) g.get(i3);
                                if (!be.kS(stringExtra)) {
                                    if (!m.eC(stringExtra) || this.gQh.contains(stringExtra) || stringExtra.equals(this.gQl)) {
                                        v.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[]{stringExtra});
                                    } else {
                                        this.gQh.add(stringExtra);
                                        if (!(this.gQi == null || this.gQi.contains(g.get(i3)))) {
                                            this.gQj.add(stringExtra);
                                        }
                                        if (this.gQk != null && this.gQk.contains(stringExtra)) {
                                            this.gQk.remove(stringExtra);
                                        }
                                    }
                                }
                                i3++;
                            }
                        }
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(6001);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (be.kS(str)) {
            v.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
        } else {
            if (str.equals("contact_label_delete")) {
                g.b(this, getString(2131233455), "", getString(2131231020), getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ ContactLabelEditUI gQm;

                    {
                        this.gQm = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ContactLabelEditUI.l(this.gQm);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ ContactLabelEditUI gQm;

                    {
                        this.gQm = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            v.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[]{str});
        }
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    LinkedList linkedList = ((com.tencent.mm.plugin.label.a.a) kVar).avL().mbG;
                    if (linkedList == null || linkedList.size() <= 0) {
                        avP();
                        return;
                    }
                    v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[]{r0.mFs, ((afp) linkedList.get(0)).mFr});
                    this.gPY = r0.mFs;
                    avQ();
                    return;
                }
                avP();
                return;
            case 636:
                if (i == 0 && i2 == 0) {
                    a(this.gPZ);
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        return;
                    }
                    return;
                }
                v.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
                avR();
                return;
            case 637:
                if (i == 0 && i2 == 0) {
                    int intValue;
                    String str2 = this.gPY;
                    String str3 = this.gPX;
                    v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
                    try {
                        intValue = Integer.valueOf(str2).intValue();
                    } catch (Exception e) {
                        v.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[]{str2});
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        w LP = com.tencent.mm.plugin.label.e.avK().LP(str2);
                        if (LP == null) {
                            LP = new w();
                        }
                        LP.field_labelID = intValue;
                        LP.field_labelName = str3;
                        LP.field_labelPYFull = com.tencent.mm.platformtools.c.lT(str3);
                        LP.field_labelPYShort = com.tencent.mm.platformtools.c.lT(str3);
                        com.tencent.mm.plugin.label.e.avK().b(true, LP, "labelID");
                    } else {
                        avP();
                    }
                    avQ();
                    return;
                }
                avP();
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    avO();
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        return;
                    }
                    return;
                }
                avP();
                return;
            default:
                return;
        }
    }

    private void avN() {
        if (this.gQc != null) {
            this.gQc.j(null, this.gQh);
            if (this.gQh == null || this.gQh.size() <= 0) {
                this.gQc.bpp();
            }
        }
        if (this.gQd != null) {
            this.gQd.setText(this.gPX);
        }
    }

    private void vA(String str) {
        iT(!be.kS(str));
    }

    private void avO() {
        int size;
        v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
        avM();
        if (this.gQj != null) {
            size = this.gQj.size();
        } else {
            size = 0;
        }
        v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[]{Integer.valueOf(size)});
        com.tencent.mm.plugin.report.service.g.iuh.h(11220, new Object[]{k.xF(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(size)});
        if (this.gQg) {
            Intent intent = getIntent();
            intent.putExtra("k_sns_label_add_label", this.gPX);
            setResult(0, intent);
        } else {
            setResult(0);
        }
        finish();
    }

    private void avP() {
        v.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
        avM();
        rI(getString(2131230806));
    }

    private static boolean vB(String str) {
        if (be.kS(com.tencent.mm.plugin.label.e.avK().vv(str))) {
            return false;
        }
        return true;
    }

    private void avQ() {
        int i;
        Iterator it;
        String bW;
        String str = "MicroMsg.Label.ContactLabelEditUI";
        String str2 = "cpan[doUpdateContactList] addcount:%d,delcount:%d";
        Object[] objArr = new Object[2];
        if (this.gQj == null) {
            i = 0;
        } else {
            i = this.gQj.size();
        }
        objArr[0] = Integer.valueOf(i);
        if (this.gQk == null) {
            i = 0;
        } else {
            i = this.gQk.size();
        }
        objArr[1] = Integer.valueOf(i);
        v.i(str, str2, objArr);
        LinkedList linkedList = new LinkedList();
        if (this.gQj != null && this.gQj.size() > 0) {
            this.gQj.size();
            it = this.gQj.iterator();
            while (it.hasNext()) {
                String str3;
                String str4 = (String) it.next();
                ak.yW();
                u LX = com.tencent.mm.model.c.wH().LX(str4);
                str3 = LX.field_contactLabelIds;
                bW = com.tencent.mm.plugin.label.c.bW(str3, this.gPY);
                v.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[]{str3, bW});
                if (!bW.equalsIgnoreCase(str3)) {
                    bcz com_tencent_mm_protocal_c_bcz = new bcz();
                    com_tencent_mm_protocal_c_bcz.gln = LX.field_username;
                    com_tencent_mm_protocal_c_bcz.moP = bW;
                    linkedList.add(com_tencent_mm_protocal_c_bcz);
                }
            }
        }
        if (this.gQk != null && this.gQk.size() > 0) {
            this.gQk.size();
            it = this.gQk.iterator();
            while (it.hasNext()) {
                str4 = (String) it.next();
                ak.yW();
                str3 = com.tencent.mm.model.c.wH().LX(str4).field_contactLabelIds;
                bW = com.tencent.mm.plugin.label.c.bX(str3, this.gPY);
                v.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[]{str4, str3, bW});
                if (!bW.equalsIgnoreCase(str3)) {
                    com_tencent_mm_protocal_c_bcz = new bcz();
                    com_tencent_mm_protocal_c_bcz.gln = str4;
                    com_tencent_mm_protocal_c_bcz.moP = bW;
                    linkedList.add(com_tencent_mm_protocal_c_bcz);
                }
            }
        }
        if (linkedList.size() > 0) {
            ak.vy().a(new com.tencent.mm.plugin.label.a.d(linkedList), 0);
            return;
        }
        avO();
    }

    private void vz(String str) {
        getString(2131231164);
        this.eZg = g.a(this, str, true, new OnCancelListener(this) {
            final /* synthetic */ ContactLabelEditUI gQm;

            {
                this.gQm = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().cancel(635);
                ak.vy().cancel(637);
            }
        });
    }

    private void avM() {
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
    }

    private void rI(String str) {
        g.a(this, str, "", new OnClickListener(this) {
            final /* synthetic */ ContactLabelEditUI gQm;

            {
                this.gQm = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public void onBackPressed() {
        if ((be.kS(this.gPX) || this.gPX.equals(this.gPW)) && ((this.gQj == null || this.gQj.size() <= 0) && (this.gQk == null || this.gQk.size() <= 0))) {
            setResult(0);
            finish();
            return;
        }
        g.b(this, getString(2131234726), "", getString(2131231559), getString(2131231560), new OnClickListener(this) {
            final /* synthetic */ ContactLabelEditUI gQm;

            {
                this.gQm = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                ContactLabelEditUI.b(this.gQm);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ ContactLabelEditUI gQm;

            {
                this.gQm = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.gQm.setResult(0);
                this.gQm.finish();
            }
        });
    }

    private void a(w wVar) {
        if (com.tencent.mm.plugin.label.e.avK().a(true, wVar, "labelID")) {
            setResult(-1);
            finish();
            return;
        }
        v.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
        avR();
    }

    private void avR() {
        rI(getString(2131232273));
    }

    protected final String avS() {
        if (this.gQg) {
            return "_New";
        }
        return "_Edit";
    }
}
