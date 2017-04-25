package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.e.s;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimatedExpandableListView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SnsLabelUI extends MMActivity implements e {
    public static int[] jPE = new int[]{2131235450, 2131235448, 2131235444, 2131235437};
    private AnimatedExpandableListView jPD;
    private ArrayList<String> jPF;
    private String jPG;
    private String jPH;
    an jPI;
    private int jPJ = 0;
    private boolean jPK;
    private boolean jPL = false;
    private boolean jPM = false;
    private boolean jPN = false;
    private int jPO;
    private p jPP;
    private String jPQ;
    private int jPR;
    private ArrayList<String> jPS;
    private ArrayList<String> jPT;
    private ArrayList<Long> jPU;
    private ArrayList<String[]> jPV;

    static /* synthetic */ void a(SnsLabelUI snsLabelUI, int i, ArrayList arrayList, String str, View view) {
        if (snsLabelUI.jPI == null || snsLabelUI.jPI.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(2131759382)).setImageResource(2131165403);
                return;
            }
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(2131759382)).setImageResource(2131165400);
            } else {
                ((ImageView) view.findViewById(2131759382)).setImageResource(2131165402);
            }
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i == 1) {
                ((ImageView) view.findViewById(2131759382)).setImageResource(2131165928);
            } else {
                ((ImageView) view.findViewById(2131759382)).setImageResource(2131165929);
            }
        } else {
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(2131759382)).setImageResource(2131165926);
            } else {
                ((ImageView) view.findViewById(2131759382)).setImageResource(2131165927);
            }
        }
    }

    static /* synthetic */ void f(SnsLabelUI snsLabelUI) {
        Intent intent = new Intent();
        intent.putExtra("titile", snsLabelUI.getString(2131230883));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", r.s(new int[]{r.oHJ, 1024}));
        if (snsLabelUI.jPO == 2) {
            if (snsLabelUI.jPI.jQg.size() > 0) {
                intent.putExtra("already_select_contact", be.b(snsLabelUI.jPI.jQg, ","));
            }
        } else if (snsLabelUI.jPO == 3 && snsLabelUI.jPI.jQh.size() > 0) {
            intent.putExtra("already_select_contact", be.b(snsLabelUI.jPI.jQh, ","));
        }
        c.a(snsLabelUI, ".ui.contact.SelectContactUI", intent, 4003);
    }

    protected final int getLayoutId() {
        return 2130904456;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        goBack();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131235544);
        ak.vy().a(292, this);
        ak.vy().a(635, this);
        ak.vy().a(638, this);
        ak.vy().a(290, this);
        this.jPI = new an(this);
        Intent intent = getIntent();
        if (intent == null) {
            this.jPJ = 0;
            this.jPI.style = 0;
            this.jPG = null;
            this.jPH = null;
        } else {
            this.jPJ = intent.getIntExtra("KLabel_range_index", 0);
            this.jPI.style = intent.getIntExtra("k_sns_label_ui_style", 0);
            this.jPG = intent.getStringExtra("Klabel_name_list");
            this.jPH = intent.getStringExtra("Kother_user_name_list");
            if (!TextUtils.isEmpty(intent.getStringExtra("k_sns_label_ui_title"))) {
                Fd(intent.getStringExtra("k_sns_label_ui_title"));
            }
        }
        this.jPI.jQc = this.jPJ;
        if (this.jPI.style == 1) {
            findViewById(2131759375).setBackgroundResource(2131689547);
        }
        if (this.jPJ == 2) {
            if (!TextUtils.isEmpty(this.jPG)) {
                this.jPI.jQe = (ArrayList) be.g(this.jPG.split(","));
            }
            if (!TextUtils.isEmpty(this.jPH)) {
                this.jPI.jQg = (ArrayList) be.g(this.jPH.split(","));
            }
        } else if (this.jPJ == 3) {
            if (!TextUtils.isEmpty(this.jPG)) {
                this.jPI.jQf = (ArrayList) be.g(this.jPG.split(","));
            }
            if (!TextUtils.isEmpty(this.jPH)) {
                this.jPI.jQh = (ArrayList) be.g(this.jPH.split(","));
            }
        }
        ak.yW();
        this.jPK = ((Boolean) com.tencent.mm.model.c.vf().get(335873, Boolean.valueOf(true))).booleanValue();
        if (this.jPK) {
            this.jPM = true;
            this.jPN = true;
            if (aXf() > 0) {
                this.jPL = true;
            }
            ak.vy().a(new s(), 0);
        }
        NI();
    }

    protected final void NI() {
        boolean booleanExtra = getIntent().getBooleanExtra("Ktag_rangeFilterprivate", false);
        this.jPD = (AnimatedExpandableListView) findViewById(2131759376);
        this.jPF = (ArrayList) a.bmu().avG();
        this.jPI.jQd = booleanExtra;
        this.jPI.O(this.jPF);
        LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(2131493138);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.jPD.addHeaderView(view);
        this.jPD.setAdapter(this.jPI);
        if (this.jPI.jQc == 2) {
            this.jPD.expandGroup(2);
        } else if (this.jPI.jQc == 3) {
            this.jPD.expandGroup(3);
        }
        this.jPD.setOnGroupClickListener(new OnGroupClickListener(this) {
            final /* synthetic */ SnsLabelUI jPW;

            {
                this.jPW = r1;
            }

            public final boolean onGroupClick(ExpandableListView expandableListView, View view, final int i, long j) {
                int i2 = this.jPW.jPI.jQc;
                v.i("MicroMsg.SnsLabelUI", "dz[previousGroup: %d    onGroupClick:%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                if (i <= 1) {
                    if (i2 > 1) {
                        this.jPW.jPD.wa(i2);
                    }
                    this.jPW.jPI.jQc = i;
                    return false;
                } else if (this.jPW.jPT != null && this.jPW.jPT.size() != 0 && SnsLabelUI.aXf() == 0) {
                    this.jPW.jPO = i;
                    g.a(this.jPW, this.jPW.getString(2131235459), null, this.jPW.getString(2131235458), new OnClickListener(this.jPW) {
                        final /* synthetic */ SnsLabelUI jPW;

                        {
                            this.jPW = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.jPW.jPM = true;
                            a.bmu().aD(this.jPW.jPT);
                            this.jPW.jPP = g.a(this.jPW, this.jPW.getString(2131235446), false, null);
                        }
                    });
                    v.i("MicroMsg.SnsLabelUI", "dz[previousGroup: need transform]");
                    return true;
                } else if (this.jPW.jPN) {
                    this.jPW.jPL = true;
                    this.jPW.jPO = i;
                    this.jPW.jPP = g.a(this.jPW, this.jPW.getString(2131235446), false, null);
                    v.i("MicroMsg.SnsLabelUI", "dz[previousGroup: isGettingTagInfo]");
                    return true;
                } else if (this.jPW.jPI.jQb == null || this.jPW.jPI.jQb.size() == 0) {
                    this.jPW.jPO = i;
                    SnsLabelUI.f(this.jPW);
                    v.i("MicroMsg.SnsLabelUI", "dz[previousGroup: gotoSelectContact]");
                    return true;
                } else {
                    if (i2 != i) {
                        if (i2 == 2) {
                            this.jPW.jPD.collapseGroup(2);
                            this.jPW.jPI.jQe.clear();
                            this.jPW.jPI.jQg.clear();
                        } else if (i2 == 3) {
                            this.jPW.jPD.collapseGroup(3);
                            this.jPW.jPI.jQf.clear();
                            this.jPW.jPI.jQh.clear();
                        }
                        this.jPW.jPD.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 jPY;

                            public final void run() {
                                this.jPY.jPW.jPD.vZ(i);
                            }
                        });
                    } else if (this.jPW.jPD.isGroupExpanded(i)) {
                        this.jPW.jPD.wa(i);
                    } else {
                        this.jPW.jPD.vZ(i);
                    }
                    this.jPW.jPI.jQc = i;
                    return true;
                }
            }
        });
        this.jPD.setOnChildClickListener(new OnChildClickListener(this) {
            final /* synthetic */ SnsLabelUI jPW;

            {
                this.jPW = r1;
            }

            public final boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
                if (i2 == this.jPW.jPI.getChildrenCount(i) - 1) {
                    this.jPW.jPO = i;
                    SnsLabelUI.f(this.jPW);
                } else {
                    String str = (String) this.jPW.jPI.getChild(i, i2);
                    this.jPW.jPI;
                    an.Ca(str);
                    if (i == 2) {
                        SnsLabelUI.a(this.jPW, 1, this.jPW.jPI.jQe, str, view);
                    } else if (i == 3) {
                        SnsLabelUI.a(this.jPW, 2, this.jPW.jPI.jQf, str, view);
                    }
                }
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLabelUI jPW;

            {
                this.jPW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jPW.goBack();
                return true;
            }
        });
        a(0, getString(2131235439), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLabelUI jPW;

            {
                this.jPW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsLabelUI snsLabelUI = this.jPW;
                String b = be.b(snsLabelUI.jPI.jQe, ",");
                String b2 = be.b(snsLabelUI.jPI.jQg, ",");
                String b3 = be.b(snsLabelUI.jPI.jQf, ",");
                String b4 = be.b(snsLabelUI.jPI.jQh, ",");
                if ((snsLabelUI.jPI.jQc == 2 && snsLabelUI.jPI.jQe.size() == 0 && snsLabelUI.jPI.jQg.size() == 0) || (snsLabelUI.jPI.jQc == 3 && snsLabelUI.jPI.jQf.size() == 0 && snsLabelUI.jPI.jQh.size() == 0)) {
                    g.a(snsLabelUI, snsLabelUI.getString(2131235447), "", snsLabelUI.getString(2131235458), null);
                } else if ((snsLabelUI.jPI.jQc == 2 && be.kS(b) && be.kS(b2)) || (snsLabelUI.jPI.jQc == 3 && be.kS(b3) && be.kS(b4))) {
                    g.a(snsLabelUI, snsLabelUI.getString(2131235447), "", snsLabelUI.getString(2131235458), null);
                } else {
                    snsLabelUI.aXe();
                }
                return true;
            }
        }, b.nET);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        Intent intent2;
        if (i2 == -1 && i == 4003) {
            v.i("MicroMsg.SnsLabelUI", "the Activity completed");
            stringExtra = intent.getStringExtra("Select_Contacts_To_Create_New_Label");
            if (be.kS(stringExtra)) {
                stringExtra = intent.getStringExtra("Select_Contact");
                this.jPH = new String(stringExtra);
                v.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
                if (this.jPO == 2) {
                    this.jPI.jQg.clear();
                    if (!be.kS(stringExtra)) {
                        this.jPI.jQg.addAll(be.g(stringExtra.split(",")));
                        this.jPI.jQc = this.jPO;
                    }
                } else if (this.jPO == 3) {
                    this.jPI.jQh.clear();
                    if (!be.kS(stringExtra)) {
                        this.jPI.jQh.addAll(be.g(stringExtra.split(",")));
                        this.jPI.jQc = this.jPO;
                    }
                }
                this.jPI.notifyDataSetChanged();
                this.jPD.expandGroup(this.jPO);
                return;
            }
            intent2 = new Intent();
            intent2.putExtra("Select_Contact", stringExtra);
            c.b(this.nDR.nEl, "label", ".ui.ContactLabelEditUI", intent2, 4002);
        } else if (i2 == -1 && i == 4001) {
            stringExtra = intent.getStringExtra("Select_Contact");
            v.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
            if (!be.kS(stringExtra)) {
                intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                c.b(this, "label", ".ui.ContactLabelEditUI", intent2, 4002);
            }
        } else if (i2 == 0 && i == 4002 && intent != null) {
            stringExtra = intent.getStringExtra("k_sns_label_add_label");
            this.jPQ = intent.getStringExtra("k_sns_label_add_label");
            this.jPD.postDelayed(new Runnable(this) {
                final /* synthetic */ SnsLabelUI jPW;

                public final void run() {
                    this.jPW.jPF = (ArrayList) a.bmu().avG();
                    if (this.jPW.jPF == null) {
                        this.jPW.jPF = new ArrayList();
                    }
                    int i;
                    if (be.kS(stringExtra)) {
                        i = -1;
                    } else {
                        if (!this.jPW.jPF.contains(stringExtra)) {
                            this.jPW.jPF.add(stringExtra);
                        }
                        i = this.jPW.jPF.indexOf(stringExtra);
                    }
                    this.jPW.jPI.O(this.jPW.jPF);
                    this.jPW.jPI.jQc = this.jPW.jPO;
                    if (!be.kS(stringExtra) && r0 != -1) {
                        if (this.jPW.jPO == 2) {
                            this.jPW.jPI.jQe.add(stringExtra);
                            this.jPW.jPI.jQg.clear();
                        } else if (this.jPW.jPO == 3) {
                            this.jPW.jPI.jQf.add(stringExtra);
                            this.jPW.jPI.jQh.clear();
                        }
                        this.jPW.jPI.notifyDataSetChanged();
                        this.jPW.jPD.expandGroup(this.jPW.jPO);
                    }
                }
            }, 300);
        }
    }

    private void goBack() {
        boolean z = false;
        int i = this.jPI.jQc;
        if (this.jPI.jQc != this.jPJ) {
            if ((i == 2 && (this.jPI.jQe.size() != 0 || this.jPI.jQg.size() != 0)) || (i == 3 && (this.jPI.jQf.size() != 0 || this.jPI.jQh.size() != 0))) {
                z = true;
            } else if (i == 1 || i == 0) {
                z = true;
            }
        } else if (!((i != 2 || this.jPI.jQe.size() == 0 || (be.b(this.jPI.jQe, ",").equals(this.jPG) && be.b(this.jPI.jQg, ",").equals(this.jPH))) && (i != 3 || this.jPI.jQf.size() == 0 || (be.b(this.jPI.jQf, ",").equals(this.jPG) && be.b(this.jPI.jQh, ",").equals(this.jPH))))) {
            z = true;
        }
        if (z) {
            g.a(this, true, getString(2131235443), "", getString(2131235442), getString(2131235441), new OnClickListener(this) {
                final /* synthetic */ SnsLabelUI jPW;

                {
                    this.jPW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.jPW.aXe();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SnsLabelUI jPW;

                {
                    this.jPW = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.jPW.aXd();
                }
            });
        } else {
            aXd();
        }
    }

    private void aXd() {
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.jPJ);
        if (this.jPJ == 2 || this.jPJ == 3) {
            intent.putExtra("Klabel_name_list", this.jPG);
            intent.putExtra("Kother_user_name_list", this.jPH);
        }
        setResult(-1, intent);
        finish();
    }

    final void aXe() {
        Intent intent = new Intent();
        if (this.jPI.jQc == 2) {
            this.jPG = be.b(this.jPI.jQe, ",");
            this.jPH = be.b(this.jPI.jQg, ",");
            intent.putExtra("Klabel_name_list", this.jPG);
            intent.putExtra("Kother_user_name_list", this.jPH);
        } else if (this.jPI.jQc == 3) {
            this.jPG = be.b(this.jPI.jQf, ",");
            this.jPH = be.b(this.jPI.jQh, ",");
            intent.putExtra("Klabel_name_list", this.jPG);
            intent.putExtra("Kother_user_name_list", this.jPH);
        }
        intent.putExtra("Ktag_range_index", this.jPI.jQc);
        setResult(-1, intent);
        finish();
    }

    protected void onDestroy() {
        ak.vy().b(292, this);
        ak.vy().b(635, this);
        ak.vy().b(638, this);
        ak.vy().b(290, this);
        super.onDestroy();
    }

    public void onResume() {
        if (this.jPI != null && this.jPQ == null) {
            this.jPF = (ArrayList) a.bmu().avG();
            this.jPI.O(this.jPF);
            if ((this.jPF == null || this.jPF.size() == 0) && (this.jPH == null || this.jPH.length() == 0)) {
                this.jPI.jQc = 0;
            }
            this.jPI.notifyDataSetChanged();
        }
        this.jPQ = null;
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.v.k r12) {
        /*
        r8 = this;
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = java.lang.Integer.valueOf(r9);
        r2[r3] = r4;
        r3 = 1;
        r4 = java.lang.Integer.valueOf(r10);
        r2[r3] = r4;
        r3 = 2;
        r2[r3] = r11;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = r8.jPM;
        if (r0 != 0) goto L_0x0022;
    L_0x0021:
        return;
    L_0x0022:
        r0 = r12.getType();
        switch(r0) {
            case 290: goto L_0x002a;
            case 292: goto L_0x0038;
            case 635: goto L_0x013f;
            case 638: goto L_0x0158;
            default: goto L_0x0029;
        };
    L_0x0029:
        goto L_0x0021;
    L_0x002a:
        if (r9 != 0) goto L_0x002e;
    L_0x002c:
        if (r10 == 0) goto L_0x0021;
    L_0x002e:
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at delete tag list!";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x0021;
    L_0x0038:
        if (r9 != 0) goto L_0x0132;
    L_0x003a:
        if (r10 != 0) goto L_0x0132;
    L_0x003c:
        r0 = com.tencent.mm.plugin.sns.e.ad.aSI();
        r2 = r0.getCursor();
        r0 = r2.getCount();
        r8.jPR = r0;
        r0 = r8.jPR;
        if (r0 <= 0) goto L_0x00f1;
    L_0x004e:
        r2.moveToFirst();
        r3 = new com.tencent.mm.plugin.sns.storage.q;
        r3.<init>();
        r0 = r2.getCount();
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.jPT = r1;
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.jPS = r1;
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.jPV = r1;
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.jPU = r1;
    L_0x0076:
        r0 = r2.isAfterLast();
        if (r0 != 0) goto L_0x00e3;
    L_0x007c:
        r3.b(r2);
        r0 = r3.field_memberList;
        if (r0 == 0) goto L_0x00d9;
    L_0x0083:
        r0 = r3.field_memberList;
        r0 = r0.length();
        if (r0 == 0) goto L_0x00d9;
    L_0x008b:
        r0 = r8.jPV;
        r1 = r3.field_memberList;
        r4 = ",";
        r1 = r1.split(r4);
        r0.add(r1);
        r1 = r3.field_tagName;
        r4 = r8.jPT;
        r0 = com.tencent.mm.pluginsdk.j.a.bmu();
        r0 = r0.avI();
        if (r0 != 0) goto L_0x00bf;
    L_0x00a7:
        r0 = r1;
    L_0x00a8:
        r4.add(r0);
        r0 = r8.jPS;
        r0.add(r1);
        r0 = r8.jPU;
        r4 = r3.field_tagId;
        r1 = java.lang.Long.valueOf(r4);
        r0.add(r1);
    L_0x00bb:
        r2.moveToNext();
        goto L_0x0076;
    L_0x00bf:
        r0 = r0.contains(r1);
        if (r0 != 0) goto L_0x00c7;
    L_0x00c5:
        r0 = r1;
        goto L_0x00a8;
    L_0x00c7:
        r0 = 2131235440; // 0x7f081270 float:1.8087074E38 double:1.052970214E-314;
        r0 = r8.getString(r0);
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r1;
        r0 = java.lang.String.format(r0, r5);
        goto L_0x00a8;
    L_0x00d9:
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz:snstaginfo memberlist is null.";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x00bb;
    L_0x00e3:
        r2.close();
        r0 = r8.jPS;
        r0 = r0.size();
        if (r0 != 0) goto L_0x012c;
    L_0x00ee:
        r0 = 0;
    L_0x00ef:
        if (r0 != 0) goto L_0x0114;
    L_0x00f1:
        r0 = r8.jPN;
        if (r0 == 0) goto L_0x0114;
    L_0x00f5:
        r0 = r8.jPI;
        r1 = r8.jPO;
        r0.jQc = r1;
        r0 = r8.jPD;
        r1 = r8.jPO;
        r0.vZ(r1);
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.vf();
        r1 = 335873; // 0x52001 float:4.70658E-40 double:1.659433E-318;
        r3 = 0;
        r3 = java.lang.Boolean.valueOf(r3);
        r0.set(r1, r3);
    L_0x0114:
        r2.close();
        r0 = r8.jPL;
        if (r0 == 0) goto L_0x012e;
    L_0x011b:
        r0 = 1;
        r8.jPM = r0;
        r0 = com.tencent.mm.pluginsdk.j.a.bmu();
        r1 = r8.jPT;
        r0.aD(r1);
    L_0x0127:
        r0 = 0;
        r8.jPN = r0;
        goto L_0x0021;
    L_0x012c:
        r0 = 1;
        goto L_0x00ef;
    L_0x012e:
        r0 = 0;
        r8.jPM = r0;
        goto L_0x0127;
    L_0x0132:
        r8.aXg();
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at get sns tag list!";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x0127;
    L_0x013f:
        if (r9 != 0) goto L_0x014a;
    L_0x0141:
        if (r10 != 0) goto L_0x014a;
    L_0x0143:
        r0 = r8.jPV;
        r8.by(r0);
        goto L_0x0021;
    L_0x014a:
        r8.aXg();
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at add contact label!";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x0021;
    L_0x0158:
        if (r9 != 0) goto L_0x01fc;
    L_0x015a:
        if (r10 != 0) goto L_0x01fc;
    L_0x015c:
        r0 = r8.jPS;
        r1 = r0.iterator();
        r0 = r8.jPU;
        r2 = r0.iterator();
    L_0x0168:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0192;
    L_0x016e:
        r0 = r2.next();
        r0 = (java.lang.Long) r0;
        r4 = r0.longValue();
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r6 = 0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x0168;
    L_0x0184:
        r3 = com.tencent.mm.model.ak.vy();
        r6 = new com.tencent.mm.plugin.sns.e.u;
        r6.<init>(r4, r0);
        r0 = 0;
        r3.a(r6, r0);
        goto L_0x0168;
    L_0x0192:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.vf();
        r1 = 335874; // 0x52002 float:4.7066E-40 double:1.65944E-318;
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r0.set(r1, r2);
        r0 = com.tencent.mm.pluginsdk.j.a.bmu();
        r0 = r0.avG();
        r0 = (java.util.ArrayList) r0;
        r8.jPF = r0;
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r1 = 11455; // 0x2cbf float:1.6052E-41 double:5.6595E-320;
        r2 = 4;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "";
        r2[r3] = r4;
        r3 = 1;
        r4 = "";
        r2[r3] = r4;
        r3 = 2;
        r4 = r8.jPR;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = r8.jPT;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        r0 = r8.jPD;
        r1 = new com.tencent.mm.plugin.sns.ui.SnsLabelUI$10;
        r1.<init>(r8);
        r2 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        r0.postDelayed(r1, r2);
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.vf();
        r1 = 335873; // 0x52001 float:4.70658E-40 double:1.659433E-318;
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);
        r0.set(r1, r2);
        goto L_0x0021;
    L_0x01fc:
        r8.aXg();
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at modify label list!";
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsLabelUI.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
    }

    private static int aXf() {
        ak.yW();
        return ((Integer) com.tencent.mm.model.c.vf().get(335874, Integer.valueOf(0))).intValue();
    }

    private void aXg() {
        com.tencent.mm.plugin.report.service.g.iuh.h(11455, new Object[]{"", "", Integer.valueOf(this.jPR), Integer.valueOf(0)});
        ak.yW();
        int intValue = ((Integer) com.tencent.mm.model.c.vf().get(335874, Integer.valueOf(0))).intValue() + 1;
        ak.yW();
        com.tencent.mm.model.c.vf().set(335874, Integer.valueOf(intValue));
        this.jPT = null;
        this.jPN = false;
        this.jPM = false;
        if (this.jPP != null && this.jPP.isShowing()) {
            this.jPP.dismiss();
        }
        if (this.jPL) {
            this.jPL = false;
            return;
        }
        intValue = 2131235457;
        if (aXf() > 1) {
            intValue = 2131235456;
        }
        g.a(this, intValue, 2131231107, new OnClickListener(this) {
            final /* synthetic */ SnsLabelUI jPW;

            {
                this.jPW = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void by(List<String[]> list) {
        if (this.jPT != null && this.jPT.size() != 0) {
            Iterator it = this.jPT.iterator();
            Iterator it2 = list.iterator();
            List arrayList = new ArrayList(this.jPT.size());
            List arrayList2 = new ArrayList(this.jPT.size());
            while (it.hasNext()) {
                arrayList.add(a.bmu().vv((String) it.next()));
                arrayList2.add(be.b(Arrays.asList((Object[]) it2.next()), ","));
                this.jPM = true;
            }
            a.bmu().e(arrayList, arrayList2);
        }
    }
}
