package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mmdb.database.SQLiteDatabase;

public class ZoneRecommandPreference extends Preference {
    private TextView dtE;
    Region oVA;
    private TextView oVB;
    private ImageView oVC;
    Region oVy;
    Region oVz;
    int status;

    public ZoneRecommandPreference(Context context) {
        this(context, null);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904035, viewGroup2);
        this.oVB = (TextView) onCreateView.findViewById(2131758269);
        this.dtE = (TextView) onCreateView.findViewById(2131758274);
        this.oVC = (ImageView) onCreateView.findViewById(2131758273);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        bJy();
    }

    final void bJy() {
        if (this.oVB != null && this.dtE != null) {
            switch (this.status) {
                case 0:
                    this.oVB.setVisibility(8);
                    this.dtE.setVisibility(0);
                    this.dtE.setText(2131234959);
                    this.oVC.setImageResource(2131165602);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                case 1:
                    this.oVB.setVisibility(0);
                    this.dtE.setVisibility(8);
                    this.oVC.setImageResource(2131165602);
                    CharSequence charSequence = SQLiteDatabase.KeyEmpty;
                    if (!(this.oVy == null || t.kS(this.oVy.getName()))) {
                        charSequence = charSequence + this.oVy.getName();
                    }
                    if (!(this.oVz == null || t.kS(this.oVz.getName()))) {
                        charSequence = charSequence + " " + this.oVz.getName();
                    }
                    if (!(this.oVA == null || t.kS(this.oVA.getName()))) {
                        charSequence = charSequence + " " + this.oVA.getName();
                    }
                    this.oVB.setText(charSequence);
                    setEnabled(true);
                    setSelectable(true);
                    return;
                case 2:
                    this.oVB.setVisibility(8);
                    this.dtE.setVisibility(0);
                    this.dtE.setText(2131234956);
                    this.oVC.setImageResource(2131165601);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                default:
                    return;
            }
        }
    }

    public final void bJz() {
        this.status = 2;
        bJy();
    }
}
