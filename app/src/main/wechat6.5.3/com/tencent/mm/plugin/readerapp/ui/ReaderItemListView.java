package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ReaderItemListView extends ListView {
    private Context context;
    private LayoutInflater gwU;
    d hkn;
    List<bc> ilY = new ArrayList();
    a ilZ;
    OnCreateContextMenuListener ima;
    private DisplayMetrics imb;
    int position = 0;
    int type = 0;

    class a extends BaseAdapter {
        final /* synthetic */ ReaderItemListView imc;

        class a {
            TextView dID;
            ImageView dQZ;
            ProgressBar elJ;
            TextView grb;
            ImageView ilK;
            View ilQ;
            final /* synthetic */ a imd;
            TextView imf;
            ProgressBar img;

            a(a aVar) {
                this.imd = aVar;
            }
        }

        a(ReaderItemListView readerItemListView) {
            this.imc = readerItemListView;
        }

        public final int getCount() {
            return this.imc.ilY.size();
        }

        public final Object getItem(int i) {
            return this.imc.ilY.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            if (((bc) this.imc.ilY.get(i)).type == 20) {
                if (i != 0) {
                    return 1;
                }
                String zK = ((bc) this.imc.ilY.get(i)).zK();
                String zL = ((bc) this.imc.ilY.get(i)).zL();
                if (be.kS(zK)) {
                    if (be.kS(zL)) {
                        return 1;
                    }
                    return 2;
                } else if (be.kS(zL)) {
                    return 3;
                } else {
                    return 0;
                }
            } else if (i == 0) {
                if (getCount() == 1) {
                    return 8;
                }
                return 6;
            } else if (i == getCount() - 1) {
                return 7;
            } else {
                return 5;
            }
        }

        public final int getViewTypeCount() {
            return 9;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            Bitmap a;
            ViewGroup viewGroup2 = null;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                switch (itemViewType) {
                    case 0:
                    case 3:
                        aVar = new a(this);
                        view = this.imc.gwU.inflate(2130904223, null);
                        aVar.dID = (TextView) view.findViewById(2131758765);
                        aVar.ilK = (ImageView) view.findViewById(2131758763);
                        aVar.elJ = (ProgressBar) view.findViewById(2131758764);
                        view.setTag(aVar);
                        break;
                    case 1:
                        aVar = new a(this);
                        view = this.imc.gwU.inflate(2130904226, null);
                        aVar.dID = (TextView) view.findViewById(2131758768);
                        view.setTag(aVar);
                        break;
                    case 2:
                        aVar = new a(this);
                        view = this.imc.gwU.inflate(2130904224, null);
                        aVar.dID = (TextView) view.findViewById(2131758765);
                        aVar.imf = (TextView) view.findViewById(2131758766);
                        view.setTag(aVar);
                        break;
                    case 4:
                        aVar = new a(this);
                        view = this.imc.gwU.inflate(2130904229, null);
                        aVar.dID = (TextView) view.findViewById(2131758765);
                        aVar.ilK = (ImageView) view.findViewById(2131758763);
                        aVar.elJ = (ProgressBar) view.findViewById(2131758764);
                        aVar.grb = (TextView) view.findViewById(2131758780);
                        aVar.dQZ = (ImageView) view.findViewById(2131758778);
                        aVar.img = (ProgressBar) view.findViewById(2131758779);
                        aVar.ilQ = view.findViewById(2131758777);
                        aVar.ilQ.setBackgroundResource(2130839020);
                        view.setTag(aVar);
                        break;
                    case 5:
                        aVar = new a(this);
                        view = this.imc.gwU.inflate(2130904230, null);
                        aVar.dID = (TextView) view.findViewById(2131758765);
                        aVar.grb = (TextView) view.findViewById(2131758780);
                        aVar.dQZ = (ImageView) view.findViewById(2131758778);
                        aVar.img = (ProgressBar) view.findViewById(2131758779);
                        aVar.ilQ = view.findViewById(2131758777);
                        aVar.ilQ.setBackgroundResource(2130839021);
                        view.setTag(aVar);
                        break;
                    case 6:
                        aVar = new a(this);
                        view = this.imc.gwU.inflate(2130904232, null);
                        aVar.dID = (TextView) view.findViewById(2131758765);
                        aVar.grb = (TextView) view.findViewById(2131758780);
                        aVar.dQZ = (ImageView) view.findViewById(2131758778);
                        aVar.img = (ProgressBar) view.findViewById(2131758779);
                        aVar.ilQ = view.findViewById(2131758777);
                        aVar.ilQ.setBackgroundResource(2130839020);
                        view.setTag(aVar);
                        break;
                    case 7:
                        aVar = new a(this);
                        view = this.imc.gwU.inflate(2130904231, null);
                        aVar.dID = (TextView) view.findViewById(2131758765);
                        aVar.grb = (TextView) view.findViewById(2131758780);
                        aVar.dQZ = (ImageView) view.findViewById(2131758778);
                        aVar.img = (ProgressBar) view.findViewById(2131758779);
                        aVar.ilQ = view.findViewById(2131758777);
                        aVar.ilQ.setBackgroundResource(2130839019);
                        view.setTag(aVar);
                        Object obj = aVar;
                        break;
                    case 8:
                        aVar = new a(this);
                        view = this.imc.gwU.inflate(2130904230, null);
                        aVar.dID = (TextView) view.findViewById(2131758765);
                        aVar.grb = (TextView) view.findViewById(2131758780);
                        aVar.dQZ = (ImageView) view.findViewById(2131758778);
                        aVar.img = (ProgressBar) view.findViewById(2131758779);
                        aVar.ilQ = view.findViewById(2131758777);
                        aVar.ilQ.setBackgroundResource(2130839022);
                        view.setTag(aVar);
                        break;
                }
                aVar = viewGroup2;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (aVar.dID != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            aVar.dID.setText(((bc) this.imc.ilY.get(i)).getTitle().trim());
            if (aVar.imf != null) {
                aVar.imf.setText(((bc) this.imc.ilY.get(i)).zL().trim());
            }
            if (aVar.grb != null) {
                aVar.grb.setText(((bc) this.imc.ilY.get(i)).zI().trim() + this.imc.getContext().getString(2131234320));
            }
            if (aVar.dQZ != null) {
                a = j.a(new r(((bc) this.imc.ilY.get(i)).zJ(), ((bc) this.imc.ilY.get(i)).type, "@S", false));
                if (a != null) {
                    aVar.dQZ.setImageBitmap(a);
                    aVar.dQZ.setVisibility(0);
                    aVar.img.setVisibility(8);
                } else {
                    aVar.img.setVisibility(0);
                    aVar.dQZ.setVisibility(8);
                }
            }
            if (aVar.ilK != null) {
                a = j.a(new r(((bc) this.imc.ilY.get(i)).zK(), ((bc) this.imc.ilY.get(i)).type, "@T", false));
                if (a != null) {
                    aVar.ilK.setImageBitmap(a);
                    aVar.ilK.setVisibility(0);
                    aVar.elJ.setVisibility(8);
                } else {
                    aVar.elJ.setVisibility(0);
                    aVar.ilK.setVisibility(8);
                }
            }
            if (!(aVar.ilQ == null || this.imc.ima == null)) {
                aVar.ilQ.setTag(Integer.valueOf(this.imc.position));
                aVar.ilQ.setOnLongClickListener(new OnLongClickListener(this) {
                    final /* synthetic */ a imd;

                    {
                        this.imd = r1;
                    }

                    public final boolean onLongClick(View view) {
                        new l(this.imd.imc.getContext()).b(view, this.imd.imc.ima, this.imd.imc.hkn);
                        return true;
                    }
                });
                aVar.ilQ.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a imd;

                    public final void onClick(View view) {
                        int i = i;
                        Intent intent = new Intent();
                        intent.putExtra("mode", 1);
                        String url = ((bc) this.imd.imc.ilY.get(i)).getUrl();
                        if (url.contains("?")) {
                            url = url + "&dt=2&cv=0x" + Integer.toHexString(com.tencent.mm.protocal.d.lWh) + "&w=" + this.imd.imc.imb.widthPixels;
                        } else {
                            url = url + "?dt=2&cv=0x" + Integer.toHexString(com.tencent.mm.protocal.d.lWh) + "&w=" + this.imd.imc.imb.widthPixels;
                        }
                        intent.putExtra("rawUrl", url);
                        intent.putExtra("webpageTitle", ((bc) this.imd.imc.ilY.get(i)).getTitle());
                        intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.imd.imc.context.getString(2131233263));
                        intent.putExtra("useJs", true);
                        intent.putExtra("vertical_scroll", true);
                        Bundle bundle = new Bundle();
                        if (((bc) this.imd.imc.ilY.get(i)).type == 20) {
                            bundle.putInt("snsWebSource", 3);
                        } else {
                            bundle.putInt("snsWebSource", 2);
                        }
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("shortUrl", ((bc) this.imd.imc.ilY.get(i)).zH());
                        intent.putExtra("type", ((bc) this.imd.imc.ilY.get(i)).type);
                        intent.putExtra("tweetid", ((bc) this.imd.imc.ilY.get(i)).zG());
                        intent.putExtra("geta8key_username", "blogapp");
                        com.tencent.mm.plugin.readerapp.a.a.drp.j(intent, this.imd.imc.context);
                    }
                });
            }
            return view;
        }
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        boolean z = false;
        this.context = context;
        this.gwU = q.em(context);
        this.type = ((Activity) context).getIntent().getIntExtra("type", 0);
        if (bc.eO(this.type) != null) {
            z = true;
        }
        Assert.assertTrue(z);
        this.imb = getResources().getDisplayMetrics();
        this.ilZ = new a(this);
        setAdapter(this.ilZ);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
