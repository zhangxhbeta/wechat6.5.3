package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.k.b;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AASelectContactUI extends MMBaseSelectContactUI {
    private String biB;
    private HashSet<String> duc;
    private HashSet<String> dud;
    private long due;
    private int duf;
    private CheckBox dug;
    private View duh;
    private String title;

    static /* synthetic */ void a(AASelectContactUI aASelectContactUI, List list) {
        if (aASelectContactUI.dud != null) {
            aASelectContactUI.dud.clear();
        } else {
            aASelectContactUI.dud = new HashSet();
        }
        aASelectContactUI.dud.addAll(list);
        aASelectContactUI.dug.setChecked(true);
        aASelectContactUI.bHH().notifyDataSetChanged();
    }

    protected final void NH() {
        super.NH();
        this.title = getIntent().getStringExtra("titile");
        this.due = getIntent().getLongExtra("max_select_num", 20);
        this.duf = getIntent().getIntExtra("select_type", 1);
        this.biB = getIntent().getStringExtra("chatroomName");
        vE(2131236646);
        if (!m.dE(this.biB)) {
            finish();
        }
        this.dud = new HashSet();
        this.duc = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!be.kS(stringExtra)) {
            this.duc.addAll(Arrays.asList(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!be.kS(stringExtra)) {
            this.dud.addAll(be.g(stringExtra.split(",")));
            NN();
        }
        this.dug = (CheckBox) findViewById(2131755217);
        this.duh = findViewById(2131755216);
        this.duh.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AASelectContactUI dui;

            {
                this.dui = r1;
            }

            public final void onClick(View view) {
                if (this.dui.dug.isChecked()) {
                    if (this.dui.dud != null) {
                        this.dui.dud.clear();
                    } else {
                        this.dui.dud = new HashSet();
                    }
                    this.dui.dug.setChecked(false);
                    this.dui.bHH().notifyDataSetChanged();
                } else {
                    final List mc = h.mc(this.dui.biB);
                    if (((long) mc.size()) > this.dui.due) {
                        g.a(this.dui.nDR.nEl, this.dui.getString(2131230782, new Object[]{Long.valueOf(this.dui.due)}), "", new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 duk;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AASelectContactUI.a(this.duk.dui, mc);
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 duk;

                            {
                                this.duk = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        AASelectContactUI.a(this.dui, mc);
                    }
                }
                com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(6)});
            }
        });
        if (this.dud.size() == h.mc(this.biB).size()) {
            this.dug.setChecked(true);
        } else {
            this.dug.setChecked(false);
        }
        this.dug.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ AASelectContactUI dui;

            {
                this.dui = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.dui.NN();
            }
        });
    }

    protected final void NI() {
        super.NI();
        a(1, getString(2131231107), new OnMenuItemClickListener(this) {
            final /* synthetic */ AASelectContactUI dui;

            {
                this.dui = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (((long) this.dui.dud.size()) > this.dui.due) {
                    g.A(this.dui.nDR.nEl, this.dui.getString(2131233482, new Object[]{Long.valueOf(this.dui.due)}), "");
                    com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(8)});
                    com.tencent.mm.plugin.report.service.g.iuh.h(13722, new Object[]{Integer.valueOf(3)});
                } else if (this.dui.dud.size() <= 0) {
                    g.A(this.dui.nDR.nEl, this.dui.getString(2131230785, new Object[]{Integer.valueOf(1)}), "");
                    com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(9)});
                } else {
                    List linkedList = new LinkedList();
                    linkedList.addAll(this.dui.dud);
                    this.dui.setResult(-1, this.dui.getIntent().putExtra("Select_Contact", be.b(linkedList, ",")));
                    this.dui.finish();
                    this.dui.axg();
                    com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(8)});
                }
                return true;
            }
        }, b.nET);
        NN();
        this.hkH.lHi = this;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AASelectContactUI dui;

            {
                this.dui = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.dui.dud == null || this.dui.dud.size() <= 0 || ((long) this.dui.dud.size()) > this.dui.due || (this.dui.dud.size() == 1 && this.dui.dud.contains(k.xF()))) {
                    this.dui.finish();
                } else {
                    g.a(this.dui, this.dui.getString(2131230780), null, this.dui.getString(2131230784), this.dui.getString(2131230783), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 dul;

                        {
                            this.dul = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (((long) this.dul.dui.dud.size()) > this.dul.dui.due) {
                                g.A(this.dul.dui.nDR.nEl, this.dul.dui.getString(2131233482, new Object[]{Long.valueOf(this.dul.dui.due)}), "");
                                com.tencent.mm.plugin.report.service.g.iuh.h(13722, new Object[]{Integer.valueOf(3)});
                                return;
                            }
                            List linkedList = new LinkedList();
                            linkedList.addAll(this.dul.dui.dud);
                            this.dul.dui.setResult(-1, this.dul.dui.getIntent().putExtra("Select_Contact", be.b(linkedList, ",")));
                            this.dul.dui.finish();
                            com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(11)});
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass4 dul;

                        {
                            this.dul = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.dul.dui.finish();
                            com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(10)});
                        }
                    });
                }
                com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(7)});
                return true;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!be.kS(stringExtra)) {
            this.duc.addAll(be.g(stringExtra.split(",")));
        }
    }

    protected final boolean NJ() {
        return false;
    }

    protected final String NK() {
        return this.title;
    }

    protected final n NL() {
        return new d(this, this.biB);
    }

    protected final p NM() {
        return new e(this, this.biB);
    }

    public final void gJ(int i) {
        com.tencent.mm.ui.contact.m bHH = bHH();
        a xS = bHH.xS(i - this.ieb.getHeaderViewsCount());
        if (xS != null && xS.euW != null) {
            v.i("MicroMsg.AASelectContactUI", "ClickUser=%s", new Object[]{xS.euW.field_username});
            String str = xS.euW.field_username;
            if (str.equals(k.xF())) {
                com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(4)});
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(5)});
            }
            bHM();
            if (this.dud.contains(str)) {
                this.dud.remove(str);
            } else {
                this.dud.add(str);
            }
            if (this.dud.size() == h.mc(this.biB).size()) {
                this.dug.setChecked(true);
            } else {
                this.dug.setChecked(false);
            }
            bHH.notifyDataSetChanged();
            NN();
        }
    }

    public final boolean a(a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.dud.contains(aVar.euW.field_username);
    }

    public final boolean b(a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.duc.contains(aVar.euW.field_username);
    }

    private void NN() {
        if (this.dud.size() > 0) {
            aq(1, getString(2131230760, new Object[]{Integer.valueOf(this.dud.size())}));
        } else {
            aq(1, getString(2131231107));
        }
        if (this.dud.size() == 1 && this.dud.contains(k.xF())) {
            U(1, false);
        } else {
            U(1, true);
        }
    }

    protected final int NO() {
        return 1;
    }

    public final void mf(String str) {
        this.dud.remove(str);
        bHH().notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return 2130903045;
    }
}
