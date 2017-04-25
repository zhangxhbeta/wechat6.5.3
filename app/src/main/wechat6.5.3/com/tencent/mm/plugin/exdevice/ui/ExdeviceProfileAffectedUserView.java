package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView extends LinearLayout {
    String dRA;
    private TextView fCv;
    private MMHorList fCw;
    private a fCx;
    private ArrayList<String> fCy;

    private class a extends BaseAdapter {
        private Runnable fCA;
        final /* synthetic */ ExdeviceProfileAffectedUserView fCz;

        class a {
            ImageView cHH;
            final /* synthetic */ a fCB;

            a(a aVar) {
                this.fCB = aVar;
            }
        }

        private a(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView) {
            this.fCz = exdeviceProfileAffectedUserView;
            this.fCA = new Runnable(this) {
                final /* synthetic */ a fCB;

                {
                    this.fCB = r1;
                }

                public final void run() {
                    this.fCB.notifyDataSetChanged();
                }
            };
        }

        public final /* synthetic */ Object getItem(int i) {
            return hd(i);
        }

        public final int getCount() {
            return this.fCz.fCy == null ? 0 : this.fCz.fCy.size();
        }

        private String hd(int i) {
            return (String) this.fCz.fCy.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            String hd = hd(i);
            if (view == null) {
                view = LayoutInflater.from(this.fCz.getContext()).inflate(2130903565, viewGroup, false);
                a aVar2 = new a(this);
                aVar2.cHH = (ImageView) view.findViewById(2131756854);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            f.b(hd, this.fCA);
            b.p(aVar.cHH, hd);
            return view;
        }
    }

    public ExdeviceProfileAffectedUserView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(2130903559, this, true);
        this.fCv = (TextView) inflate.findViewById(2131756826);
        this.fCw = (MMHorList) inflate.findViewById(2131756827);
        this.fCw.nWl = true;
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(context, 44);
        this.fCw.nWm = true;
        this.fCw.nWn = fromDPToPix;
        this.fCw.nWl = true;
        this.fCx = new a();
        this.fCw.setAdapter(this.fCx);
        this.fCw.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ExdeviceProfileAffectedUserView fCz;

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) adapterView.getAdapter().getItem(i);
                v.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", new Object[]{str});
                if (be.kS(str)) {
                    v.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", str);
                context.startActivity(intent);
            }
        });
        this.fCv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceProfileAffectedUserView fCz;

            {
                this.fCz = r1;
            }

            public final void onClick(View view) {
                String xF = k.xF();
                if (xF != null && xF.equals(this.fCz.dRA)) {
                    this.fCz.fCw.setVisibility(this.fCz.fCw.getVisibility() == 0 ? 8 : 0);
                }
            }
        });
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceProfileAffectedUserView fCz;

            {
                this.fCz = r1;
            }

            public final void onClick(View view) {
                this.fCz.fCv.performClick();
            }
        });
        setVisibility(8);
    }

    public final void z(ArrayList<String> arrayList) {
        this.fCy = arrayList;
        if (this.fCy == null || this.fCy.size() == 0) {
            this.fCv.setText("");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fCv.setText(getResources().getString(2131232564, new Object[]{Integer.valueOf(this.fCy.size())}));
        this.fCx.notifyDataSetChanged();
    }
}
