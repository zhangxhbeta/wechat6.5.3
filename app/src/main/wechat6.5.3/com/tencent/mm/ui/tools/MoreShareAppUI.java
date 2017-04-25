package com.tencent.mm.ui.tools;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.DragSortListView.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;

public class MoreShareAppUI extends MMActivity {
    private DragSortListView fhU;
    private List<f> nHi;
    private a oTR;

    private static class a extends ArrayAdapter<f> {
        private List<f> eZk;
        private Context mContext;

        static class a {
            TextView dtY;
            View eZl;
            ImageView eZm;
            ImageView eZn;
            MMSwitchBtn nHn;

            public a(View view) {
                this.eZm = (ImageView) view.findViewById(2131758332);
                this.eZn = (ImageView) view.findViewById(2131756775);
                this.dtY = (TextView) view.findViewById(2131756774);
                this.nHn = (MMSwitchBtn) view.findViewById(2131758333);
                this.eZl = view.findViewById(2131755326);
            }
        }

        public a(Context context, List<f> list) {
            super(context, 2130904095, list);
            this.mContext = context;
            this.eZk = list;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.mContext, 2130904095, null);
                a aVar2 = new a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.dtY.setText(((f) getItem(i)).field_appName);
            view.setVisibility(0);
            return view;
        }
    }

    protected final int getLayoutId() {
        return 2130904094;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MoreShareAppUI oTS;

            {
                this.oTS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oTS.finish();
                return true;
            }
        });
        a(0, getString(2131232360), new OnMenuItemClickListener(this) {
            final /* synthetic */ MoreShareAppUI oTS;

            {
                this.oTS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        this.oTR = new a(this, this.nHi);
        this.fhU.setAdapter(this.oTR);
    }

    protected final void NI() {
        vD(2131231548);
        this.fhU = (DragSortListView) findViewById(2131755705);
        this.fhU.oZO = new g(this) {
            final /* synthetic */ MoreShareAppUI oTS;

            {
                this.oTS = r1;
            }

            public final void bz(int i, int i2) {
                f fVar = (f) this.oTS.oTR.getItem(i);
                this.oTS.oTR.eZk.remove(i);
                this.oTS.oTR.notifyDataSetChanged();
                this.oTS.oTR.insert(fVar, i2);
            }
        };
    }
}
