package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.u;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.j;
import com.tencent.mm.v.e;

public class SnsTagPartlyUI extends MMActivity implements e {
    protected p dwg = null;
    private ListView eyT;
    private a jTI;
    private OnClickListener jTJ = new OnClickListener(this) {
        final /* synthetic */ SnsTagPartlyUI jTK;

        {
            this.jTK = r1;
        }

        public final void onClick(View view) {
            if (this.jTK.jTI == null) {
                v.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
                return;
            }
            Object tag = view.getTag();
            if (tag == null) {
                v.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
            } else if (tag instanceof Integer) {
                q qVar = (q) this.jTK.jTI.getItem(((Integer) tag).intValue());
                this.jTK.dwg = g.a(this.jTK, null, true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass5 jTL;

                    {
                        this.jTL = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                ak.vy().a(new u(qVar.field_tagId, qVar.field_tagName), 0);
            } else {
                v.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
            }
        }
    };

    class a extends j<q> {
        private Context context;
        final /* synthetic */ SnsTagPartlyUI jTK;
        public boolean jTM = false;

        class a {
            Button eVF;
            TextView jTN;
            TextView jTO;
            final /* synthetic */ a jTP;

            a(a aVar) {
                this.jTP = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (q) obj;
            if (obj == null) {
                obj = new q();
                v.d("MicroMsg.SnsTagPartlyUI", "new SnsInfo");
            }
            obj.b(cursor);
            return obj;
        }

        public a(SnsTagPartlyUI snsTagPartlyUI, Context context) {
            this.jTK = snsTagPartlyUI;
            super(context, new q());
            this.context = context;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.context, 2130904145, null);
                aVar.jTN = (TextView) view.findViewById(2131758476);
                aVar.jTO = (TextView) view.findViewById(2131758477);
                aVar.eVF = (Button) view.findViewById(2131756336);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (lB(i)) {
                aVar.jTN.setText(2131235611);
                aVar.jTO.setVisibility(8);
                aVar.eVF.setVisibility(8);
            } else {
                int i2;
                q qVar = (q) getItem(i);
                aVar.jTN.setText(qVar.field_tagName);
                aVar.jTO.setVisibility(0);
                aVar.jTO.setText(" (" + qVar.field_count + ") ");
                Button button = aVar.eVF;
                if (this.jTM) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                button.setVisibility(i2);
                aVar.eVF.setOnClickListener(this.jTK.jTJ);
                aVar.eVF.setTag(Integer.valueOf(i));
            }
            return view;
        }

        public final void Ol() {
            setCursor(ad.aSI().getCursor());
            notifyDataSetChanged();
        }

        protected final void Om() {
            avc();
            Ol();
        }

        protected final int asv() {
            return 1;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(292, this);
        ak.vy().a(290, this);
        NI();
    }

    public void onDestroy() {
        ak.vy().b(292, this);
        ak.vy().b(290, this);
        if (this.jTI != null) {
            this.jTI.avc();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.jTI != null) {
            this.jTI.a("", null);
        }
    }

    protected final void NI() {
        vD(2131235112);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagPartlyUI jTK;

            {
                this.jTK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jTK.finish();
                return true;
            }
        });
        this.eyT = (ListView) findViewById(2131759467);
        this.eyT.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsTagPartlyUI jTK;

            {
                this.jTK = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.jTK.jTI.getCount() - 1) {
                    Intent intent = new Intent();
                    q qVar = (q) this.jTK.jTI.getItem(i);
                    if (qVar != null) {
                        intent.putExtra("k_sns_tag_id", qVar.field_tagId);
                        intent.setClass(this.jTK, SnsTagDetailUI.class);
                        this.jTK.startActivity(intent);
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent();
                String xF = k.xF();
                intent2.putExtra("titile", this.jTK.getString(2131230878));
                intent2.putExtra("list_type", 1);
                intent2.putExtra("list_attr", r.s(new int[]{r.oHJ, 1024}));
                intent2.putExtra("block_contact", xF);
                c.a(this.jTK, ".ui.contact.SelectContactUI", intent2, 1);
            }
        });
        this.jTI = new a(this, this);
        this.eyT.addFooterView(View.inflate(this, 2130904502, null));
        this.eyT.setAdapter(this.jTI);
        a(0, getString(2131235534), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagPartlyUI jTK;

            {
                this.jTK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                a a = this.jTK.jTI;
                if (this.jTK.jTI.jTM) {
                    z = false;
                } else {
                    z = true;
                }
                a.jTM = z;
                this.jTK.aq(0, this.jTK.jTI.jTM ? this.jTK.getString(2131231065) : this.jTK.getString(2131235534));
                this.jTK.jTI.notifyDataSetChanged();
                return true;
            }
        });
        this.jTI.nDK = new com.tencent.mm.ui.j.a(this) {
            final /* synthetic */ SnsTagPartlyUI jTK;

            {
                this.jTK = r1;
            }

            public final void Oj() {
            }

            public final void Oi() {
                boolean z = true;
                SnsTagPartlyUI snsTagPartlyUI = this.jTK;
                if (this.jTK.jTI.getCount() <= 1) {
                    z = false;
                }
                snsTagPartlyUI.iT(z);
            }
        };
    }

    protected final int getLayoutId() {
        return 2130904503;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        String stringExtra2 = intent.getStringExtra("Select_room_name");
                        if (stringExtra != null) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("k_sns_tag_id", 0);
                            intent2.putExtra("k_sns_tag_name", be.ah(stringExtra2, ""));
                            intent2.putExtra("k_sns_tag_list", stringExtra);
                            intent2.setClass(this, SnsTagDetailUI.class);
                            startActivity(intent2);
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

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        if (this.jTI != null) {
            this.jTI.a("", null);
        }
    }
}
