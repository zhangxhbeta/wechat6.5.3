package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog extends MMBaseActivity {
    private List<String> cwd = new LinkedList();
    private GridView jRF = null;
    private a jRG = null;

    class a extends BaseAdapter {
        private Context context;
        private List<String> cwd;
        private int jDn = 0;
        final /* synthetic */ SnsSelectContactDialog jRH;
        private int type;

        public a(SnsSelectContactDialog snsSelectContactDialog, Context context, int i) {
            this.jRH = snsSelectContactDialog;
            this.cwd = i;
            this.context = context;
            this.type = 0;
            refresh();
        }

        public final void refresh() {
            if (this.cwd == null) {
                this.jDn = 0;
            } else {
                this.jDn = this.cwd.size();
            }
            this.jDn++;
            notifyDataSetChanged();
        }

        public final int getCount() {
            return this.jDn;
        }

        public final Object getItem(int i) {
            return this.cwd.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                View inflate;
                b bVar2 = new b();
                if (this.type == 0) {
                    inflate = View.inflate(this.context, 2130904515, null);
                } else {
                    inflate = View.inflate(this.context, 2130904435, null);
                }
                bVar2.fhG = (ImageView) inflate.findViewById(2131755052);
                bVar2.jRI = (ImageView) inflate.findViewById(2131759275);
                inflate.setTag(bVar2);
                view = inflate;
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            view.setVisibility(0);
            if (i == this.jDn - 1) {
                bVar.fhG.setBackgroundDrawable(null);
                bVar.fhG.setImageResource(2130839206);
                bVar.jRI.setVisibility(8);
                if (this.cwd.size() >= s.nof) {
                    view.setVisibility(8);
                }
            } else {
                bVar.fhG.setBackgroundDrawable(null);
                bVar.jRI.setVisibility(0);
                if (this.type == 0) {
                    com.tencent.mm.pluginsdk.ui.a.b.m(bVar.fhG, (String) this.cwd.get(i));
                } else {
                    bVar.fhG.setImageBitmap(d.b((String) this.cwd.get(i), ad.aSK(), ad.aSK(), true));
                }
            }
            bVar.fhG.setScaleType(ScaleType.CENTER_CROP);
            return view;
        }
    }

    static class b {
        ImageView fhG;
        ImageView jRI;

        b() {
        }
    }

    static /* synthetic */ void b(SnsSelectContactDialog snsSelectContactDialog) {
        Intent intent = new Intent();
        String str = be.b(snsSelectContactDialog.cwd, ",") + ", " + k.xF();
        intent.putExtra("Contact_Compose", true);
        intent.putExtra("Add_get_from_sns", snsSelectContactDialog.aXm());
        intent.putExtra("List_Type", 1);
        intent.putExtra("Add_address_titile", snsSelectContactDialog.getString(2131230883));
        intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
        intent.putExtra("Block_list", str);
        intent.putExtra("sns_address_count", snsSelectContactDialog.cwd.size());
        com.tencent.mm.plugin.sns.b.a.drp.a(intent, snsSelectContactDialog, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130904440);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (stringExtra == null || stringExtra.equals("")) {
            this.cwd.clear();
        } else {
            this.cwd = be.g(stringExtra.split(","));
        }
        this.jRF = (GridView) findViewById(2131759290);
        this.jRG = new a(this, this, this.cwd);
        this.jRF.setAdapter(this.jRG);
        this.jRF.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsSelectContactDialog jRH;

            {
                this.jRH = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == this.jRH.jRG.getCount() - 1) {
                    SnsSelectContactDialog.b(this.jRH);
                } else {
                    this.jRH.cwd.remove(i);
                }
                this.jRH.jRG.refresh();
            }
        });
        this.jRF.setSelection(this.jRG.getCount() - 1);
        ((ImageButton) findViewById(2131759291)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSelectContactDialog jRH;

            {
                this.jRH = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", be.b(this.jRH.cwd, ","));
                this.jRH.setResult(-1, intent);
                this.jRH.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", be.b(this.cwd, ","));
            setResult(-1, intent);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean Cd(String str) {
        for (Object equals : m.crG) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (m.dE(str) || m.eD(str)) {
            return false;
        }
        if (this.cwd == null || !this.cwd.contains(str)) {
            return true;
        }
        return false;
    }

    private String aXm() {
        ak.yW();
        ac wK = c.wK();
        String str = m.crA;
        List linkedList = new LinkedList();
        for (Object add : m.crG) {
            linkedList.add(add);
        }
        linkedList.add("weixin");
        linkedList.add("officialaccounts");
        linkedList.add("helper_entry");
        linkedList.add("filehelper");
        Cursor b = wK.b(str, linkedList, "*");
        if (b.getCount() == 0) {
            b.close();
            return "";
        }
        List linkedList2 = new LinkedList();
        b.moveToFirst();
        do {
            ab abVar = new ab();
            abVar.b(b);
            if (Cd(abVar.field_username)) {
                linkedList2.add(abVar.field_username);
                if (linkedList2.size() >= 10) {
                    break;
                }
            }
        } while (b.moveToNext());
        b.close();
        return be.b(linkedList2, ";");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        List<String> g = be.g(intent.getStringExtra("Select_Contact").split(","));
                        if (g != null) {
                            if (this.cwd == null) {
                                this.cwd = new LinkedList();
                            }
                            for (String str : g) {
                                if (!this.cwd.contains(str)) {
                                    this.cwd.add(str);
                                }
                            }
                            v.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.cwd.size());
                            if (this.jRG != null) {
                                v.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
                                this.jRG.refresh();
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Select_Contact", be.b(this.cwd, ","));
                            setResult(-1, intent2);
                            finish();
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
}
