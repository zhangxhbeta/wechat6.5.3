package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;

public class AppGrid extends GridView {
    private SharedPreferences cnm;
    Context context;
    OnItemClickListener ezi = new OnItemClickListener(this) {
        final /* synthetic */ AppGrid lLb;

        {
            this.lLb = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.lLb.lKU.a(this.lLb.lKU.ub((this.lLb.lKY * this.lLb.lKW) + i), this.lLb.lLa.ro(i));
        }
    };
    OnItemLongClickListener fOR = new OnItemLongClickListener(this) {
        final /* synthetic */ AppGrid lLb;

        {
            this.lLb = r1;
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            b c = this.lLb.lKU;
            int ub = this.lLb.lKU.ub((this.lLb.lKY * this.lLb.lKW) + i);
            this.lLb.lLa.ro(i);
            c.uc(ub);
            return true;
        }
    };
    b lKU;
    int lKV;
    int lKW = 0;
    int lKX = 0;
    int lKY;
    int lKZ;
    a lLa;

    class a extends BaseAdapter {
        final /* synthetic */ AppGrid lLb;
        List<f> lLc;
        private int lLd;
        private int lLe;
        private Map<String, f> lLf = null;

        class a {
            ImageView dQZ;
            TextView grb;
            TextView lLg;
            View lLh;
            View lLi;
            final /* synthetic */ a lLj;

            a(a aVar) {
                this.lLj = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return ro(i);
        }

        public a(AppGrid appGrid, Context context, List<f> list, Map<String, f> map) {
            this.lLb = appGrid;
            this.lLc = list;
            this.lLf = map;
            this.lLd = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 56.0f);
            this.lLe = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 53.3f);
        }

        public final int getCount() {
            if (this.lLb.lKY == this.lLb.lKX - 1) {
                return this.lLb.lKV - (this.lLb.lKY * this.lLb.lKW);
            }
            return this.lLb.lKW;
        }

        public final f ro(int i) {
            if ((i < this.lLb.lKZ && this.lLb.lKY == 0) || (this.lLb.lKY * this.lLb.lKW) + i < this.lLb.lKZ || (i - this.lLb.lKZ) + (this.lLb.lKY * this.lLb.lKW) >= this.lLc.size()) {
                return null;
            }
            v.v("MicroMsg.AppGrid", "get item db pos: %d", Integer.valueOf((i - this.lLb.lKZ) + (this.lLb.lKY * this.lLb.lKW)));
            return (f) this.lLc.get((i - this.lLb.lKZ) + (this.lLb.lKY * this.lLb.lKW));
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.lLb.context, 2130903122, null);
                aVar.dQZ = (ImageView) view.findViewById(2131755425);
                aVar.lLh = view.findViewById(2131755424);
                aVar.grb = (TextView) view.findViewById(2131755426);
                aVar.lLg = (TextView) view.findViewById(2131755427);
                aVar.lLi = view.findViewById(2131755428);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            v.v("MicroMsg.AppGrid", "pos:" + i + " page:" + this.lLb.lKY);
            aVar.grb.setVisibility(0);
            aVar.lLi.setVisibility(8);
            aVar.lLg.setVisibility(8);
            aVar.lLh.setVisibility(0);
            LayoutParams layoutParams = aVar.dQZ.getLayoutParams();
            layoutParams.width = this.lLd;
            layoutParams.height = this.lLd;
            aVar.dQZ.setLayoutParams(layoutParams);
            int a = (this.lLb.lKY * this.lLb.lKW) + i;
            int ub = this.lLb.lKU.ub(a);
            if (a < this.lLb.lKZ) {
                switch (ub) {
                    case 0:
                        aVar.dQZ.setImageResource(2131165817);
                        aVar.grb.setText(this.lLb.context.getString(2131231051));
                        break;
                    case 1:
                        if (!q.drg) {
                            aVar.dQZ.setImageResource(2131165811);
                            aVar.grb.setText(this.lLb.context.getString(2131231049));
                            break;
                        }
                        aVar.dQZ.setImageResource(2131165819);
                        aVar.grb.setText(this.lLb.context.getString(2131231056));
                        break;
                    case 2:
                        aVar.dQZ.setImageResource(2131165282);
                        aVar.grb.setText(this.lLb.context.getString(2131231059));
                        try {
                            ak.yW();
                            if (!((Boolean) c.vf().get(54, Boolean.valueOf(false))).booleanValue()) {
                                aVar.lLg.setVisibility(8);
                                break;
                            }
                            aVar.lLg.setVisibility(0);
                            break;
                        } catch (Exception e) {
                            break;
                        }
                    case 3:
                        aVar.dQZ.setImageResource(2131165816);
                        aVar.grb.setText(this.lLb.context.getString(2131231061));
                        try {
                            ak.yW();
                            if (!((Boolean) c.vf().get(81, Boolean.valueOf(true))).booleanValue()) {
                                aVar.lLg.setVisibility(8);
                                break;
                            }
                            aVar.lLg.setVisibility(0);
                            break;
                        } catch (Exception e2) {
                            break;
                        }
                    case 4:
                        aVar.dQZ.setImageResource(2131165822);
                        aVar.grb.setText(this.lLb.context.getString(2131231061));
                        try {
                            ak.yW();
                            if (!((Boolean) c.vf().get(62, Boolean.valueOf(false))).booleanValue()) {
                                aVar.lLg.setVisibility(8);
                                break;
                            }
                            aVar.lLg.setVisibility(0);
                            break;
                        } catch (Exception e3) {
                            break;
                        }
                    case 5:
                        aVar.dQZ.setImageResource(2131165823);
                        aVar.grb.setText(this.lLb.context.getString(2131231057));
                        try {
                            ak.yW();
                            if (!((Boolean) c.vf().get(67, Boolean.valueOf(false))).booleanValue()) {
                                aVar.lLg.setVisibility(8);
                                break;
                            }
                            aVar.lLg.setVisibility(0);
                            break;
                        } catch (Exception e4) {
                            break;
                        }
                    case 6:
                        aVar.dQZ.setImageResource(2131165815);
                        aVar.grb.setText(this.lLb.context.getString(2131231048));
                        try {
                            ak.yW();
                            if (!((Boolean) c.vf().get(290817, Boolean.valueOf(false))).booleanValue()) {
                                aVar.lLi.setVisibility(8);
                                break;
                            }
                            aVar.lLi.setVisibility(0);
                            break;
                        } catch (Exception e5) {
                            break;
                        }
                    case 7:
                        a(aVar, f.lAo);
                        break;
                    case 8:
                        a(aVar, f.lAm);
                        break;
                    case 9:
                        a(aVar, f.lAp);
                        break;
                    case 10:
                        aVar.dQZ.setImageResource(2131165814);
                        aVar.grb.setText(this.lLb.context.getString(2131231044));
                        break;
                    case 11:
                        aVar.dQZ.setImageResource(2131165821);
                        aVar.grb.setText(this.lLb.context.getString(2131233268));
                        try {
                            ak.yW();
                            if (!((Boolean) c.vf().get(73, Boolean.valueOf(false))).booleanValue()) {
                                aVar.lLg.setVisibility(8);
                                break;
                            }
                            aVar.lLg.setVisibility(0);
                            break;
                        } catch (Exception e6) {
                            break;
                        }
                    case 12:
                        aVar.dQZ.setImageResource(2131165813);
                        aVar.grb.setText(this.lLb.context.getString(2131231047));
                        break;
                    case 13:
                        aVar.dQZ.setImageResource(2131165279);
                        aVar.grb.setText(this.lLb.context.getString(2131232416));
                        try {
                            ak.yW();
                            boolean booleanValue = ((Boolean) c.vf().get(208899, Boolean.valueOf(false))).booleanValue();
                            ak.yW();
                            boolean booleanValue2 = ((Boolean) c.vf().get(208913, Boolean.valueOf(false))).booleanValue();
                            if (!booleanValue && !booleanValue2) {
                                aVar.lLg.setVisibility(8);
                                break;
                            }
                            aVar.lLg.setVisibility(0);
                            if (!booleanValue2) {
                                aVar.lLg.setText(2131231102);
                                break;
                            }
                            aVar.lLg.setText(2131231067);
                            break;
                        } catch (Exception e7) {
                            break;
                        }
                        break;
                    case 14:
                        aVar.dQZ.setImageResource(2131165818);
                        aVar.grb.setText(this.lLb.context.getString(2131231055));
                        try {
                            ak.yW();
                            if (!((Boolean) c.vf().get(327744, Boolean.valueOf(true))).booleanValue()) {
                                aVar.lLi.setVisibility(8);
                                break;
                            }
                            aVar.lLi.setVisibility(0);
                            break;
                        } catch (Exception e8) {
                            break;
                        }
                    case 15:
                        aVar.dQZ.setImageResource(2131165812);
                        aVar.grb.setText(this.lLb.context.getString(2131231046));
                        try {
                            aVar.lLi.setVisibility(8);
                            break;
                        } catch (Exception e9) {
                            break;
                        }
                }
            }
            layoutParams.width = this.lLe;
            layoutParams.height = this.lLe;
            aVar.dQZ.setLayoutParams(layoutParams);
            f ro = ro(i);
            if (ro != null) {
                ak.yW();
                if (c.isSDCardAvailable()) {
                    Bitmap b;
                    if (ro.field_status == 5) {
                        b = g.b(ro.field_appId, 3, com.tencent.mm.bd.a.getDensity(this.lLb.context));
                    } else if (ro.bnl()) {
                        b = g.b(ro.field_appId, 4, com.tencent.mm.bd.a.getDensity(this.lLb.context));
                    } else {
                        b = g.b(ro.field_appId, 1, com.tencent.mm.bd.a.getDensity(this.lLb.context));
                    }
                    if (b != null) {
                        aVar.dQZ.setBackgroundDrawable(new BitmapDrawable(b));
                    } else if (f.lAm.equals(ro.field_appId)) {
                        aVar.dQZ.setImageResource(2130838842);
                    } else if (f.lAo.equals(ro.field_appId)) {
                        aVar.dQZ.setImageResource(2130838840);
                    } else if (f.lAn.equals(ro.field_appId)) {
                        aVar.dQZ.setImageResource(2130838839);
                    } else if (f.lAp.equals(ro.field_appId)) {
                        aVar.dQZ.setImageResource(2131165810);
                    } else {
                        aVar.dQZ.setBackgroundResource(2130837659);
                    }
                } else {
                    aVar.dQZ.setBackgroundResource(2130839157);
                }
                aVar.grb.setText(g.a(this.lLb.context, ro, null));
                if ((ro.bnl() && ro.bnm()) || ro.bnn()) {
                    if (this.lLb.cnm == null) {
                        this.lLb.cnm = this.lLb.context.getSharedPreferences(aa.bti(), 0);
                    }
                    if (this.lLb.cnm.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + ro.field_appId, true)) {
                        aVar.lLg.setVisibility(0);
                    }
                }
            }
            f ro2 = ro(i);
            if (ro2 != null && g.k(ro2)) {
                aVar.lLg.setVisibility(0);
            }
            return view;
        }

        private void a(a aVar, String str) {
            if (this.lLf == null) {
                v.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
                return;
            }
            f fVar = (f) this.lLf.get(str);
            if (fVar == null) {
                v.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
                return;
            }
            ak.yW();
            if (c.isSDCardAvailable()) {
                Bitmap b;
                if (fVar.bnl()) {
                    b = g.b(fVar.field_appId, 4, com.tencent.mm.bd.a.getDensity(this.lLb.context));
                } else {
                    b = null;
                }
                if (b != null) {
                    aVar.dQZ.setBackgroundDrawable(new BitmapDrawable(b));
                } else if (f.lAm.equals(fVar.field_appId)) {
                    aVar.dQZ.setImageResource(2130838842);
                } else if (f.lAo.equals(fVar.field_appId)) {
                    aVar.dQZ.setImageResource(2130838840);
                } else if (f.lAn.equals(fVar.field_appId)) {
                    aVar.dQZ.setImageResource(2130838839);
                } else if (f.lAp.equals(fVar.field_appId)) {
                    aVar.dQZ.setImageResource(2131165810);
                } else {
                    aVar.dQZ.setImageResource(2130837659);
                }
            } else {
                aVar.dQZ.setImageResource(2130839157);
            }
            aVar.grb.setText(g.a(this.lLb.context, fVar, null));
            if (fVar.bnl() && fVar.bnm()) {
                if (this.lLb.cnm == null) {
                    this.lLb.cnm = this.lLb.context.getSharedPreferences(aa.bti(), 0);
                }
                if (this.lLb.cnm.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                    aVar.lLg.setVisibility(0);
                }
            }
            if (f.lAm.equals(fVar.field_appId)) {
                ak.yW();
                int intValue = ((Integer) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue > 1) {
                    ak.yW();
                    if (!be.g(((String) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, SQLiteDatabase.KeyEmpty)).split(";")).contains(String.valueOf(intValue))) {
                        aVar.lLg.setVisibility(0);
                    }
                }
            }
        }
    }

    public interface b {
        void a(int i, f fVar);

        int ub(int i);

        void uc(int i);
    }

    public AppGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AppGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public int getCount() {
        return this.lLa.getCount();
    }
}
