package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a extends BaseAdapter {
    String dnU = "";
    OnClickListener fQr;
    String hGf = "";
    boolean hGh = false;
    ArrayList<aft> hGi = new ArrayList();
    HashSet<String> hGj = new HashSet();
    ArrayList<LatLongData> hGk = null;
    private Map<LatLongData, are> hGl;
    private Map<LatLongData, Integer> hGm;
    Map<String, LatLongData> hGn;
    LatLongData hGo;
    boolean hGp = true;
    int hGq = 0;
    Context mContext;

    public a(Context context, OnClickListener onClickListener, String str, boolean z) {
        this.mContext = context;
        this.fQr = onClickListener;
        this.dnU = str;
        this.hGh = z;
        this.hGk = new ArrayList();
        this.hGl = new HashMap();
        this.hGm = new HashMap();
        this.hGn = new HashMap();
    }

    public final void aDI() {
        this.hGi.clear();
        this.hGj.clear();
        this.hGm.clear();
        this.hGl.clear();
        this.hGn.clear();
        this.hGq = 0;
        notifyDataSetChanged();
    }

    public final void a(aft com_tencent_mm_protocal_c_aft, int i) {
        if (!this.hGj.contains(com_tencent_mm_protocal_c_aft.hHb) && i <= this.hGi.size()) {
            this.hGi.add(i, com_tencent_mm_protocal_c_aft);
            this.hGj.add(com_tencent_mm_protocal_c_aft.hHb);
            this.hGn.put(com_tencent_mm_protocal_c_aft.hHb, this.hGo);
        }
    }

    public final void a(LatLongData latLongData, List<aft> list) {
        v.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[]{this.dnU, Integer.valueOf(list.size())});
        for (aft com_tencent_mm_protocal_c_aft : list) {
            if (!this.hGj.contains(com_tencent_mm_protocal_c_aft.hHb)) {
                this.hGi.add(com_tencent_mm_protocal_c_aft);
                this.hGj.add(com_tencent_mm_protocal_c_aft.hHb);
                this.hGn.put(com_tencent_mm_protocal_c_aft.hHb, latLongData);
            }
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.hGi.size();
    }

    public Object getItem(int i) {
        if (i < 0 || i >= this.hGi.size()) {
            return new aft();
        }
        return this.hGi.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public static String aR(List<arf> list) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            arf com_tencent_mm_protocal_c_arf = (arf) list.get(i);
            if (!(com_tencent_mm_protocal_c_arf == null || com_tencent_mm_protocal_c_arf.mQy == null || com_tencent_mm_protocal_c_arf.mQy.equals("") || com_tencent_mm_protocal_c_arf.mQy.toLowerCase().equals("null"))) {
                stringBuffer.append(com_tencent_mm_protocal_c_arf.mQy);
                if (i < list.size() - 1) {
                    stringBuffer.append("·");
                }
            }
        }
        return stringBuffer.toString();
    }

    public final void I(ArrayList<LatLongData> arrayList) {
        if (arrayList != null) {
            this.hGk = arrayList;
        }
    }

    public final are a(LatLongData latLongData) {
        if (this.hGl.containsKey(latLongData)) {
            return (are) this.hGl.get(latLongData);
        }
        return null;
    }

    public final int b(LatLongData latLongData) {
        if (this.hGm.containsKey(latLongData)) {
            return ((Integer) this.hGm.get(latLongData)).intValue();
        }
        return 1;
    }

    public final boolean aDJ() {
        Iterator it = this.hGk.iterator();
        while (it.hasNext()) {
            if (b((LatLongData) it.next()) > 0) {
                return true;
            }
        }
        if (this.hGp) {
            return b(this.hGo) > 0;
        } else {
            return false;
        }
    }

    public final void a(LatLongData latLongData, int i, are com_tencent_mm_protocal_c_are) {
        int i2 = 0;
        String str = "MicroMsg.BaseLifeAdapter";
        String str2 = "set flag & buf, lat:%f long:%f flag:%d len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Float.valueOf(latLongData.bhs);
        objArr[1] = Float.valueOf(latLongData.cNt);
        objArr[2] = Integer.valueOf(i);
        if (com_tencent_mm_protocal_c_are != null) {
            i2 = com_tencent_mm_protocal_c_are.mQu;
        }
        objArr[3] = Integer.valueOf(i2);
        v.d(str, str2, objArr);
        if (this.hGk.contains(latLongData) || (this.hGo != null && this.hGo.equals(latLongData))) {
            this.hGm.put(latLongData, Integer.valueOf(i));
            this.hGl.put(latLongData, com_tencent_mm_protocal_c_are);
        }
    }

    public final LatLongData xg(String str) {
        if (this.hGn.containsKey(str)) {
            return (LatLongData) this.hGn.get(str);
        }
        return null;
    }

    public final int xh(String str) {
        Iterator it = this.hGi.iterator();
        int i = -1;
        while (it.hasNext()) {
            i++;
            if (((aft) it.next()).hHb.equals(str)) {
                break;
            }
        }
        return i;
    }
}
