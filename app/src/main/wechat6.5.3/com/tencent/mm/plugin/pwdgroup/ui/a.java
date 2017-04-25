package com.tencent.mm.plugin.pwdgroup.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.sdk.platformtools.be;
import java.util.HashMap;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    private LinkedList<pt> foE = new LinkedList();
    private Animation gMf;
    private Animation hYJ;
    private Animation hYK;
    private HashMap<String, Boolean> hYL = new HashMap();
    private Context mContext;

    class a {
        TextView dID;
        ImageView dQZ;
        final /* synthetic */ a hYM;

        public a(a aVar, View view) {
            this.hYM = aVar;
            this.dQZ = (ImageView) view.findViewById(2131756921);
            this.dID = (TextView) view.findViewById(2131756922);
        }
    }

    public a(Context context) {
        this.mContext = context;
        this.gMf = AnimationUtils.loadAnimation(this.mContext, 2130968586);
        this.hYK = AnimationUtils.loadAnimation(this.mContext, 2130968586);
        this.hYJ = AnimationUtils.loadAnimation(this.mContext, 2130968587);
        this.gMf.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hYK.setInterpolator(new AccelerateInterpolator());
        this.hYJ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gMf.setDuration(300);
        this.hYK.setDuration(1000);
        this.hYJ.setDuration(1000);
    }

    public final void B(LinkedList<pt> linkedList) {
        this.foE = linkedList;
        if (this.foE != null && this.foE.size() > 0) {
            int size = this.foE.size();
            for (int i = 0; i < size; i++) {
                String a = a((pt) this.foE.get(i));
                if (!this.hYL.containsKey(a)) {
                    this.hYL.put(a, Boolean.valueOf(false));
                }
            }
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.foE == null ? 1 : this.foE.size() + 1;
    }

    public final Object getItem(int i) {
        if (this.foE != null && i < this.foE.size()) {
            return this.foE.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(2130903589, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        pt ptVar = (pt) getItem(i);
        if (ptVar != null) {
            if (be.kS(ptVar.efy)) {
                aVar.dID.setText(ptVar.gln);
            } else {
                aVar.dID.setText(ptVar.efy);
            }
            if (be.kS(ptVar.gln)) {
                com.tencent.mm.plugin.pwdgroup.b.a.m(aVar.dQZ, ptVar.mrE);
            } else {
                com.tencent.mm.plugin.pwdgroup.b.a.m(aVar.dQZ, ptVar.gln);
            }
            String a = a(ptVar);
            view.clearAnimation();
            if (this.hYL.containsKey(a) && !((Boolean) this.hYL.get(a)).booleanValue()) {
                view.startAnimation(this.gMf);
                this.hYL.put(a, Boolean.valueOf(true));
            }
        }
        if (i + 1 == getCount()) {
            aVar.dID.setText("");
            aVar.dQZ.setImageResource(2130837594);
            if (view != null) {
                this.hYK.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ a hYM;

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        view.startAnimation(this.hYM.hYJ);
                    }
                });
                this.hYJ.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ a hYM;

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        view.startAnimation(this.hYM.hYK);
                    }
                });
                view.startAnimation(this.hYK);
            }
        }
        return view;
    }

    private static String a(pt ptVar) {
        if (ptVar == null) {
            return "";
        }
        if (be.kS(ptVar.gln)) {
            return ptVar.mrE;
        }
        return ptVar.gln;
    }
}
