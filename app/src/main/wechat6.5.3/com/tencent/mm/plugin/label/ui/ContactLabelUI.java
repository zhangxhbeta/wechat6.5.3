package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.label.a.d;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bcz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI extends ContactLabelBaseUI implements e {
    private String bZy;
    private MMTagPanelScrollView gQT;
    private MMLabelPanel gQU;
    private TextView gQV;
    private View gQW;
    private View gQX;
    private TextView gQY;
    private MMLabelPanel gQZ;
    private boolean gQt = true;
    private ListView gRa;
    private ScrollView gRb;
    private b gRc;
    private String gRd;
    private ArrayList<String> gRe;
    private HashSet<String> gRf = new HashSet();
    private HashSet<String> gRg = new HashSet();
    private ArrayList<String> gRh = new ArrayList();
    private int gRi = a.gRn;
    private boolean gRj = false;
    private ArrayList<String> gRk;

    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] gRm = new int[a.avX().length];

        static {
            try {
                gRm[a.gRn - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gRm[a.gRo - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gRm[a.gRp - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                gRm[a.gRq - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private enum a {
        ;

        public static int[] avX() {
            return (int[]) gRr.clone();
        }

        static {
            gRn = 1;
            gRo = 2;
            gRp = 3;
            gRq = 4;
            gRr = new int[]{gRn, gRo, gRp, gRq};
        }
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI) {
        v.i("MicroMsg.Label.ContactLabelUI", "cpan[save]");
        if (contactLabelUI.gQU == null) {
            v.w("MicroMsg.Label.ContactLabelUI", "save fail. input view is null.");
            return;
        }
        contactLabelUI.vz(contactLabelUI.getString(2131233468));
        String bCw;
        if (contactLabelUI.gRj) {
            v.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]");
            if (contactLabelUI.gQU != null) {
                bCw = contactLabelUI.gQU.bCw();
                if (!be.kS(bCw)) {
                    contactLabelUI.gQU.aM(bCw, true);
                    contactLabelUI.gQU.bCx();
                    contactLabelUI.X(bCw, contactLabelUI.gRj);
                }
            }
            if (contactLabelUI.gRg != null && contactLabelUI.gRg.size() > 0) {
                v.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger] save local");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(contactLabelUI.gRg);
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    List arrayList2 = new ArrayList();
                    for (int i = 0; i < size; i++) {
                        w wVar = new w();
                        bCw = (String) arrayList.get(i);
                        wVar.field_isTemporary = true;
                        wVar.field_labelName = bCw;
                        wVar.field_labelPYFull = c.lT(bCw);
                        wVar.field_labelPYShort = c.lU(bCw);
                        wVar.field_labelID = -((int) System.nanoTime());
                        v.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]field_labelID:%s field_labelName:%s", new Object[]{Integer.valueOf(wVar.field_labelID), wVar.field_labelName});
                        arrayList2.add(wVar);
                    }
                    com.tencent.mm.plugin.label.e.avK().bU(arrayList2);
                }
            }
            v.i("MicroMsg.Label.ContactLabelUI", "cpan[saveStranger]");
            ak.yW();
            ba Nw = com.tencent.mm.model.c.wI().Nw(contactLabelUI.bZy);
            if (contactLabelUI.gQU != null) {
                String aC = com.tencent.mm.pluginsdk.j.a.bmu().aC(contactLabelUI.gQU.bCB());
                if (be.kS(aC)) {
                    Nw.field_contactLabels = "";
                    ak.yW();
                    com.tencent.mm.model.c.wI().c(Nw);
                } else {
                    Nw.field_contactLabels = aC;
                    if (be.kS(Nw.field_encryptUsername)) {
                        Nw.field_encryptUsername = contactLabelUI.bZy;
                    }
                    ak.yW();
                    com.tencent.mm.model.c.wI().c(Nw);
                }
            }
            contactLabelUI.avV();
            return;
        }
        v.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabel]");
        if (contactLabelUI.gQU != null) {
            bCw = contactLabelUI.gQU.bCw();
            if (!be.kS(bCw)) {
                bCw = bCw.trim();
                contactLabelUI.gQU.aM(bCw, true);
                contactLabelUI.gQU.bCx();
                contactLabelUI.X(bCw, contactLabelUI.gRj);
            }
        }
        if (contactLabelUI.gRg == null || contactLabelUI.gRg.size() <= 0) {
            v.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doSaveContact");
            contactLabelUI.avU();
            return;
        }
        v.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doScene");
        List arrayList3 = new ArrayList();
        arrayList3.addAll(contactLabelUI.gRg);
        ak.vy().a(new com.tencent.mm.plugin.label.a.a(arrayList3), 0);
        if (contactLabelUI.gRh == null || contactLabelUI.gRg.isEmpty()) {
            g.iuh.h(11347, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
            return;
        }
        g.iuh.h(11347, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, String str) {
        if (contactLabelUI.gRe != null && contactLabelUI.gRe.contains(str)) {
            contactLabelUI.gRf.add(str);
        }
        if (contactLabelUI.gRg != null && contactLabelUI.gRg.contains(str)) {
            contactLabelUI.gRg.remove(str);
        }
        if (contactLabelUI.avW()) {
            contactLabelUI.iT(true);
        }
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            ad.g(new Runnable(contactLabelUI) {
                final /* synthetic */ ContactLabelUI gRl;

                {
                    this.gRl = r1;
                }

                public final void run() {
                    this.gRl.gQU.bCz();
                    this.gRl.aJs();
                }
            }, 50);
        } else {
            ad.g(new Runnable(contactLabelUI) {
                final /* synthetic */ ContactLabelUI gRl;

                {
                    this.gRl = r1;
                }

                public final void run() {
                    this.gRl.gQU.bCA();
                    this.gRl.axg();
                }
            }, 50);
        }
    }

    static /* synthetic */ void b(ContactLabelUI contactLabelUI, String str) {
        if (be.kS(str)) {
            contactLabelUI.mo(a.gRn);
            return;
        }
        contactLabelUI.mo(a.gRo);
        if (contactLabelUI.gQU != null) {
            b bVar = contactLabelUI.gRc;
            List bCB = contactLabelUI.gQU.bCB();
            if (bVar.gQR != null) {
                bVar.gQR.clear();
            }
            if (bVar.gQS != null) {
                bVar.gQS.clear();
            }
            bVar.gQQ = be.ah(str, "");
            bVar.gQR = com.tencent.mm.plugin.label.e.avK().k(str, bCB);
            bVar.notifyDataSetChanged();
        }
    }

    protected final int getLayoutId() {
        return 2130903422;
    }

    protected final void NI() {
        Fd(getString(2131230809));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelUI gRl;

            {
                this.gRl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gRl.onBackPressed();
                return false;
            }
        });
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelUI gRl;

            {
                this.gRl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelUI.a(this.gRl);
                return false;
            }
        }, b.nET);
        this.gQT = (MMTagPanelScrollView) findViewById(2131756503);
        this.gQT.nYI = 3;
        this.gQU = (MMLabelPanel) findViewById(2131756504);
        this.gQV = (TextView) findViewById(2131756505);
        this.gQW = findViewById(2131756507);
        this.gQX = findViewById(2131756509);
        this.gQX.setBackgroundDrawable(null);
        this.gQY = (TextView) this.gQX.findViewById(16908310);
        this.gQY.setText(2131233465);
        this.gQZ = (MMLabelPanel) findViewById(2131756510);
        this.gRa = (ListView) findViewById(2131756511);
        this.gRb = (ScrollView) findViewById(2131756506);
        if (this.gRb != null) {
            this.gRb.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ ContactLabelUI gRl;

                {
                    this.gRl = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 2) {
                        this.gRl.axg();
                    }
                    return false;
                }
            });
        }
        this.gQU.nYi = true;
        this.gQU.ju(true);
        this.gQU.bCv();
        this.gQU.nYp = new com.tencent.mm.ui.base.MMTagPanel.a(this) {
            final /* synthetic */ ContactLabelUI gRl;

            {
                this.gRl = r1;
            }

            public final void rS(String str) {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[]{str});
                this.gRl.gQU.removeTag(str);
                if (this.gRl.gQZ != null) {
                    this.gRl.gQZ.aN(str, false);
                }
                ContactLabelUI.a(this.gRl, str);
            }

            public final void rT(String str) {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[]{str});
            }

            public final void rU(String str) {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[]{str});
                if (this.gRl.gQZ != null) {
                    this.gRl.gQZ.aN(str, false);
                }
                ContactLabelUI.a(this.gRl, str);
            }

            public final void aii() {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
            }

            public final void rV(String str) {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[]{str});
                ContactLabelUI.b(this.gRl, str);
            }

            public final void rW(String str) {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[]{str});
                if (be.kS(str)) {
                    v.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
                    return;
                }
                this.gRl.gQU.aM(str, true);
                if (this.gRl.gQZ != null) {
                    this.gRl.gQZ.aN(str, true);
                }
                this.gRl.X(str, this.gRl.gRj);
            }

            public final void f(boolean z, int i) {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[]{String.valueOf(z), Integer.valueOf(i)});
                if (z) {
                    this.gRl.iT(false);
                    this.gRl.gQV.setVisibility(0);
                    this.gRl.gQV.setText(2131233466);
                    this.gRl.gQV.setText(String.format(this.gRl.getString(2131233466), new Object[]{Integer.valueOf(h.aw(36, "")), Integer.valueOf(i)}));
                    return;
                }
                this.gRl.iT(true);
                this.gRl.gQV.setVisibility(8);
            }
        };
        this.gQZ.ju(false);
        this.gQZ.nYp = new com.tencent.mm.ui.base.MMTagPanel.a(this) {
            final /* synthetic */ ContactLabelUI gRl;

            {
                this.gRl = r1;
            }

            public final void rS(String str) {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[]{str});
                if (this.gRl.gQU != null) {
                    this.gRl.gQU.removeTag(str);
                }
                ContactLabelUI.a(this.gRl, str);
            }

            public final void rT(String str) {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[]{str});
                if (this.gRl.gQU != null) {
                    this.gRl.gQU.aM(str, true);
                }
                this.gRl.X(str, this.gRl.gRj);
            }

            public final void rU(String str) {
            }

            public final void f(boolean z, int i) {
            }

            public final void aii() {
            }

            public final void rV(String str) {
            }

            public final void rW(String str) {
            }
        };
        this.gRa.setAdapter(this.gRc);
        this.gRa.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ContactLabelUI gRl;

            {
                this.gRl = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.gRl.gRc != null) {
                    String hd = this.gRl.gRc.hd(i);
                    if (!be.kS(hd) && this.gRl.gQU != null) {
                        this.gRl.gQU.bCx();
                        this.gRl.gQU.aM(hd, true);
                        this.gRl.gQZ.aN(hd, true);
                    }
                }
            }
        });
        iT(false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gRd = getIntent().getStringExtra("label_id_list");
        this.gRe = getIntent().getStringArrayListExtra("label_str_list");
        this.bZy = getIntent().getStringExtra("label_username");
        this.gRj = getIntent().getBooleanExtra("is_stranger", false);
        this.gRc = new b(this);
        NI();
        if (!(be.kS(this.gRd) || this.gRe == null || this.gRe.size() <= 0)) {
            this.gQU.a(this.gRe, this.gRe);
        }
        if (this.gRj) {
            this.gRk = getIntent().getStringArrayListExtra("label_str_list");
            this.gQU.a(this.gRk, this.gRk);
        }
    }

    protected void onResume() {
        ak.vy().a(635, this);
        ak.vy().a(638, this);
        ad.o(new Runnable(this) {
            final /* synthetic */ ContactLabelUI gRl;

            {
                this.gRl = r1;
            }

            public final void run() {
                Collection collection = null;
                this.gRl.gRf.clear();
                this.gRl.gRg.clear();
                if (this.gRl.gQU != null) {
                    u LX;
                    String str;
                    if (this.gRl.gRj) {
                        String str2;
                        ak.yW();
                        ba Nw = com.tencent.mm.model.c.wI().Nw(this.gRl.bZy);
                        if (Nw != null) {
                            str2 = Nw.field_contactLabels;
                        }
                        if (be.kS(str2)) {
                            ak.yW();
                            LX = com.tencent.mm.model.c.wH().LX(this.gRl.bZy);
                            String str3 = LX.field_encryptUsername;
                            if (!be.kS(str3)) {
                                ak.yW();
                                ba Nw2 = com.tencent.mm.model.c.wI().Nw(str3);
                                if (Nw2 != null) {
                                    str2 = Nw2.field_contactLabels;
                                }
                            }
                            if (be.kS(str2)) {
                                str = LX.field_username;
                                ak.yW();
                                Nw = com.tencent.mm.model.c.wI().Nw(str);
                                if (Nw != null) {
                                    str2 = Nw.field_contactLabels;
                                }
                            }
                        }
                        collection = (ArrayList) com.tencent.mm.pluginsdk.j.a.bmu().vw(str2);
                    } else {
                        ak.yW();
                        LX = com.tencent.mm.model.c.wH().LX(this.gRl.bZy);
                        if (LX != null) {
                            str = LX.field_contactLabelIds;
                            if (!be.kS(str)) {
                                ArrayList arrayList = (ArrayList) com.tencent.mm.pluginsdk.j.a.bmu().vx(str);
                            }
                        }
                    }
                    this.gRl.gQU.a(collection, collection);
                    ContactLabelUI.a(this.gRl, (ArrayList) collection);
                }
                if (this.gRl.gQZ != null) {
                    this.gRl.gRh = com.tencent.mm.plugin.label.e.avK().bvt();
                    if (this.gRl.gRh != null && this.gRl.gRh.size() > 0) {
                        this.gRl.gQZ.a(collection, this.gRl.gRh);
                        if (this.gRl.gQt) {
                            g.iuh.h(11346, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
                            this.gRl.gQt = false;
                        }
                    } else if (this.gRl.gQt) {
                        g.iuh.h(11346, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
                        this.gRl.gQt = false;
                    }
                }
                this.gRl.mo(a.gRn);
            }
        });
        super.onResume();
    }

    protected void onPause() {
        ak.vy().b(635, this);
        ak.vy().b(638, this);
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    avU();
                    return;
                } else {
                    avP();
                    return;
                }
            case 638:
                if (i == 0 && i2 == 0) {
                    v.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
                    avV();
                    return;
                }
                avP();
                return;
            default:
                v.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
                return;
        }
    }

    public void onBackPressed() {
        if (avW()) {
            com.tencent.mm.ui.base.g.b(this, getString(2131234726), "", getString(2131231559), getString(2131231560), new OnClickListener(this) {
                final /* synthetic */ ContactLabelUI gRl;

                {
                    this.gRl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContactLabelUI.a(this.gRl);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ ContactLabelUI gRl;

                {
                    this.gRl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.gRl.finish();
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    private void mo(int i) {
        this.gRi = i;
        switch (AnonymousClass4.gRm[this.gRi - 1]) {
            case 1:
                this.gRa.setVisibility(8);
                if (this.gRh == null || this.gRh.size() <= 0) {
                    this.gRb.setVisibility(8);
                    this.gQW.setVisibility(8);
                } else {
                    this.gQW.setVisibility(0);
                    this.gRb.setVisibility(0);
                }
                this.gQV.setVisibility(8);
                return;
            case 2:
                this.gRb.setVisibility(8);
                this.gRa.setVisibility(0);
                this.gQW.setVisibility(8);
                this.gQV.setVisibility(8);
                return;
            case 3:
                this.gRa.setVisibility(8);
                this.gRb.setVisibility(8);
                this.gQW.setVisibility(8);
                this.gQV.setVisibility(0);
                this.gQV.setText(2131233466);
                return;
            case 4:
                this.gRa.setVisibility(8);
                this.gRb.setVisibility(8);
                this.gQW.setVisibility(8);
                this.gQV.setVisibility(0);
                this.gQV.setText(2131233466);
                return;
            default:
                return;
        }
    }

    private void X(String str, boolean z) {
        if (be.kS(str)) {
            v.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
            return;
        }
        String trim = str.trim();
        if (be.kS(trim)) {
            v.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
            return;
        }
        w LO = com.tencent.mm.plugin.label.e.avK().LO(trim);
        if (z) {
            if (this.gRh == null || !this.gRh.contains(trim) || LO == null) {
                this.gRg.add(trim);
            }
        } else if (this.gRh == null || !this.gRh.contains(trim) || (LO != null && LO.field_isTemporary)) {
            this.gRg.add(trim);
        }
        if (this.gRf != null && this.gRf.contains(trim)) {
            this.gRf.remove(trim);
        }
        if (avW()) {
            iT(true);
        }
    }

    private void avU() {
        v.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
        if (this.gQU != null) {
            int size;
            int size2;
            int size3;
            v.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
            String str = "";
            ArrayList bCB = this.gQU.bCB();
            if (bCB.size() > 0) {
                str = com.tencent.mm.plugin.label.c.aE(com.tencent.mm.plugin.label.e.avK().Y(bCB));
            }
            LinkedList linkedList = new LinkedList();
            bcz com_tencent_mm_protocal_c_bcz = new bcz();
            com_tencent_mm_protocal_c_bcz.moP = str;
            com_tencent_mm_protocal_c_bcz.gln = this.bZy;
            linkedList.add(com_tencent_mm_protocal_c_bcz);
            ak.vy().a(new d(linkedList), 0);
            if (this.gRg != null) {
                size = this.gRg.size();
            } else {
                size = 0;
            }
            if (this.gRe != null) {
                size2 = this.gRe.size();
            } else {
                size2 = 0;
            }
            if (this.gRf != null) {
                size3 = this.gRf.size();
            } else {
                size3 = 0;
            }
            size2 = ((size3 + this.gQU.bCB().size()) - size2) - size;
            if (size > 0 || size2 > 0) {
                v.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[]{Integer.valueOf(size), Integer.valueOf(size2)});
                g.iuh.h(11220, new Object[]{com.tencent.mm.model.k.xF(), Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(0)});
            }
        }
    }

    private void avV() {
        avM();
        this.gRg.clear();
        this.gRf.clear();
        finish();
    }

    private void avP() {
        avM();
        rI(getString(2131230806));
    }

    private boolean avW() {
        if (this.gQU != null) {
            if (this.gRe == null || this.gRe.size() <= 0) {
                this.gQU.bCB();
                if (this.gQU.bCB().size() > 0) {
                    return true;
                }
            }
            this.gQU.bCB();
            List bCB = this.gQU.bCB();
            Collections.sort(this.gRe);
            Collections.sort(bCB);
            if (this.gRe.equals(bCB)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void finish() {
        if (this.gQU != null) {
            this.gQU.bCA();
        }
        Intent intent = new Intent();
        if (avW()) {
            intent.putExtra("hasLableChange", true);
        } else {
            intent.putExtra("hasLableChange", false);
        }
        setResult(-1, intent);
        super.finish();
    }
}
