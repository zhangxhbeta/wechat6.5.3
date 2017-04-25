package com.tencent.mm.plugin.backup.backuppcui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.backup.backupmodel.b;
import com.tencent.mm.plugin.backup.backupmodel.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class BackupPcChooseUI extends MMWizardActivity implements b.a {
    private ProgressBar edA;
    private TextView edB;
    private b eds;
    private ListView edt;
    private View edu;
    private TextView edv;
    private CheckBox edw;
    private TextView edx;
    private TextView edy;
    private Button edz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            NI();
        }
    }

    protected final void NI() {
        vD(2131231271);
        this.edt = (ListView) findViewById(2131755520);
        this.eds = new b(this);
        this.edt.setAdapter(this.eds);
        this.edt.setEmptyView(findViewById(2131755521));
        this.edu = findViewById(2131755528);
        this.edv = (TextView) findViewById(2131755524);
        this.edw = (CheckBox) findViewById(2131755526);
        this.edx = (TextView) findViewById(2131755527);
        this.edy = (TextView) findViewById(2131755442);
        this.edA = (ProgressBar) findViewById(2131755522);
        this.edz = (Button) findViewById(2131755525);
        this.edB = (TextView) findViewById(2131755523);
        this.edB.setVisibility(8);
        this.edv.setVisibility(8);
        if (!u.bsU()) {
            this.edx.setTextSize(1, 14.0f);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupPcChooseUI edC;

            {
                this.edC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.edC.finish();
                return false;
            }
        });
        this.edz.setEnabled(false);
        this.edz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupPcChooseUI edC;

            {
                this.edC = r1;
            }

            public final void onClick(View view) {
                LinkedList linkedList;
                b a = this.edC.eds;
                LinkedList linkedList2 = new LinkedList();
                if (a.edo.size() <= 0) {
                    linkedList = linkedList2;
                } else {
                    linkedList = c.Tw();
                    if (linkedList != null) {
                        for (int i = 0; i < a.getCount(); i++) {
                            if (a.edo.contains(Integer.valueOf(i))) {
                                linkedList2.add(linkedList.get(i));
                            }
                        }
                    }
                    v.i("MicroMsg.BackupPcChooseAdapter", "finishSelected usernameSize:%d", Integer.valueOf(linkedList2.size()));
                    linkedList = linkedList2;
                }
                ak.yW();
                v.i("MicroMsg.BackupPcChooseUI", "summerbak startbackup choose records finish, selectedUsernames size:%d, hasMove:%s", Integer.valueOf(linkedList.size()), Boolean.valueOf(((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()));
                if (((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    g.a(this.edC, 2131231229, 0, 2131231255, 0, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 edE;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.backup.g.b.US();
                            c.u(linkedList);
                            com.tencent.mm.plugin.backup.g.b.UL();
                            com.tencent.mm.plugin.backup.backuppcmodel.a.hP(2);
                            com.tencent.mm.plugin.backup.g.b.UL();
                            com.tencent.mm.plugin.backup.backuppcmodel.a.hO(3);
                            com.tencent.mm.plugin.backup.g.b.UM().v(linkedList);
                            com.tencent.mm.plugin.backup.g.b.UM().aD((long) linkedList.size());
                            com.tencent.mm.plugin.backup.g.b.US().eav = null;
                            com.tencent.mm.plugin.report.service.g.iuh.a(400, 8, 1, false);
                            com.tencent.mm.plugin.report.service.g.iuh.h(13735, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_READABLE));
                            this.edE.edC.eds;
                            if (b.ET()) {
                                com.tencent.mm.plugin.report.service.g.iuh.h(13735, Integer.valueOf(MMGIFException.D_GIF_ERR_CLOSE_FAILED));
                            }
                            this.edE.edC.finish();
                        }
                    }, null, 2131689542);
                    return;
                }
                com.tencent.mm.plugin.backup.g.b.US();
                c.u(linkedList);
                com.tencent.mm.plugin.backup.g.b.UL();
                com.tencent.mm.plugin.backup.backuppcmodel.a.hP(2);
                com.tencent.mm.plugin.backup.g.b.UL();
                com.tencent.mm.plugin.backup.backuppcmodel.a.hO(3);
                com.tencent.mm.plugin.backup.g.b.UM().v(linkedList);
                com.tencent.mm.plugin.backup.g.b.UM().aD((long) linkedList.size());
                com.tencent.mm.plugin.backup.g.b.US().eav = null;
                com.tencent.mm.plugin.report.service.g.iuh.a(400, 8, 1, false);
                com.tencent.mm.plugin.report.service.g.iuh.h(13735, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_READABLE));
                this.edC.eds;
                if (b.ET()) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(13735, Integer.valueOf(MMGIFException.D_GIF_ERR_CLOSE_FAILED));
                }
                this.edC.finish();
            }
        });
        this.edu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BackupPcChooseUI edC;

            {
                this.edC = r1;
            }

            public final void onClick(View view) {
                int i = 0;
                if (c.Ty()) {
                    b a = this.edC.eds;
                    if (a.edo.size() == a.getCount()) {
                        a.edo.clear();
                        b.edp = false;
                    } else {
                        while (i < a.getCount()) {
                            a.edo.add(Integer.valueOf(i));
                            i++;
                        }
                        b.edp = true;
                    }
                    a.notifyDataSetChanged();
                    a.edn.a(a.edo);
                }
            }
        });
        com.tencent.mm.plugin.backup.g.b.US().eav = this;
        if (!c.Ty()) {
            this.edw.setClickable(false);
            this.edA.setVisibility(0);
        } else if (c.Tu().size() == 0) {
            this.edy.setVisibility(0);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BackupPcChooseUI edC;

            {
                this.edC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.edC.finish();
                return true;
            }
        });
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue >= c.Tw().size()) {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0) {
            this.edz.setEnabled(true);
            if (c.Ty() && hashSet.size() == this.eds.getCount()) {
                this.edw.setChecked(true);
                return;
            } else {
                this.edw.setChecked(false);
                return;
            }
        }
        this.edz.setEnabled(false);
        this.edw.setChecked(false);
    }

    protected final int getLayoutId() {
        return 2130903151;
    }

    public final void s(LinkedList<String> linkedList) {
        if (linkedList != null) {
            if (linkedList.size() == 0) {
                this.edA.setVisibility(8);
                this.edy.setVisibility(0);
                return;
            }
            this.eds.notifyDataSetChanged();
            this.edw.setClickable(true);
            this.edA.setVisibility(4);
        }
    }
}
