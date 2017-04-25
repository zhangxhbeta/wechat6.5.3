package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends BaseAdapter {
    private Context hRA;
    private List<com.tencent.mm.plugin.product.c.a> hRB;
    private List<Boolean> hRC;
    private int hRD = 1;

    public final /* synthetic */ Object getItem(int i) {
        return ob(i);
    }

    public a(Context context) {
        this.hRA = context;
    }

    public final void aV(List<com.tencent.mm.plugin.product.c.a> list) {
        this.hRB = list;
        this.hRD = 0;
        this.hRC = new ArrayList();
        if (this.hRB != null) {
            Set hashSet = new HashSet();
            for (com.tencent.mm.plugin.product.c.a aVar : list) {
                this.hRC.add(Boolean.valueOf(false));
                hashSet.add(Integer.valueOf(aVar.efm));
            }
            this.hRD = list.size();
        }
        if (this.hRD <= 0) {
            this.hRD = 1;
        }
    }

    public final void a(Activity activity, View view, int i) {
        b bVar = (b) view.getTag();
        v.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + bVar.type);
        v.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + bVar.hRH);
        Intent intent;
        switch (bVar.type) {
            case 0:
                return;
            case 1:
                if (bVar.hRH instanceof String) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", (String) bVar.hRH);
                    intent.putExtra("showShare", false);
                    c.b(this.hRA, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, Constants.THREAD_BITSET_SIZE);
                    return;
                }
                return;
            case 2:
                if (bVar.hRH instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) bVar.hRH;
                    intent = new Intent(activity, MallGalleryUI.class);
                    intent.putExtra("keys_img_urls", arrayList);
                    activity.startActivity(intent);
                    return;
                }
                return;
            case 4:
            case 6:
                if (bVar.hRH instanceof String) {
                    String str = (String) bVar.hRH;
                    Intent intent2 = new Intent();
                    intent2.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, bVar.title);
                    intent2.putExtra("neverGetA8Key", false);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra(SlookAirButtonFrequentContactAdapter.DATA, str);
                    intent2.putExtra("QRDataFlag", false);
                    c.b(activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
                    return;
                }
                return;
            case 5:
                if (((Boolean) this.hRC.get(i)).booleanValue()) {
                    this.hRC.set(i, Boolean.valueOf(false));
                } else {
                    this.hRC.set(i, Boolean.valueOf(true));
                }
                notifyDataSetChanged();
                return;
            default:
                v.w("MicroMsg.MallCustomActionAdapter", "not support type");
                return;
        }
    }

    public final int getCount() {
        return this.hRB != null ? this.hRB.size() : 0;
    }

    private com.tencent.mm.plugin.product.c.a ob(int i) {
        return (com.tencent.mm.plugin.product.c.a) this.hRB.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return this.hRD;
    }

    public final int getItemViewType(int i) {
        return ob(i).efm;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.hRA, 2130904184, null);
            bVar = new b();
            bVar.eXB = (TextView) view.findViewById(2131755456);
            bVar.hRE = (TextView) view.findViewById(2131758608);
            bVar.hRF = (ImageView) view.findViewById(2131758609);
            bVar.hRG = (HtmlTextView) view.findViewById(2131758610);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.product.c.a ob = ob(i);
        if (ob != null) {
            bVar.eXB.setText(ob.gkB);
            bVar.hRE.setText(ob.hQO);
            bVar.type = ob.efm;
            bVar.hRH = ob.hQP;
            bVar.title = ob.gkB;
            switch (ob.efm) {
                case 0:
                    bVar.hRF.setVisibility(8);
                    break;
                case 5:
                case 6:
                    if (((Boolean) this.hRC.get(i)).booleanValue()) {
                        bVar.hRG.setVisibility(0);
                    } else {
                        bVar.hRG.setVisibility(8);
                    }
                    if (!bVar.hRG.getText().equals(ob.hQP)) {
                        bVar.hRG.setText(ob.hQP);
                        break;
                    }
                    break;
            }
        }
        return view;
    }
}
