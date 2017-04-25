package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreviewImageView extends LinearLayout {
    private final Context context;
    private List<String> gKQ = new ArrayList();
    private TableLayout jIL;
    private final Map<Integer, View> jIM = new HashMap();
    private final Map<Integer, TableRow> jIN = new HashMap();
    private final int jIO = 4;
    HashMap<String, Bitmap> jIP = new HashMap();
    a jIQ;
    boolean jIR = true;
    boolean jIS = false;

    static abstract class a {
        OnClickListener jIT = new OnClickListener(this) {
            final /* synthetic */ a jIU;

            {
                this.jIU = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    this.jIU.qR(((Integer) view.getTag()).intValue());
                }
            }
        };

        public abstract void qR(int i);
    }

    class b extends h<String, Integer, Boolean> {
        private ImageView bgv;
        private Bitmap cxY;
        final /* synthetic */ PreviewImageView jIV;
        private String path;

        public final /* synthetic */ Object aRX() {
            if (this.jIV.jIS) {
                return Boolean.valueOf(false);
            }
            this.cxY = d.b(this.path, ad.aSK(), ad.aSK(), true);
            v.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", new Object[]{this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree())});
            this.cxY = d.b(this.cxY, (float) r0);
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            if (!this.jIV.jIS && i.i(this.cxY)) {
                this.jIV.jIP.put(this.path, this.cxY);
                if (this.bgv.getTag() != null && (this.bgv.getTag() instanceof String) && this.bgv.getTag().equals(this.path)) {
                    this.bgv.setImageBitmap(this.cxY);
                }
            }
        }

        public b(PreviewImageView previewImageView, ImageView imageView, String str) {
            this.jIV = previewImageView;
            this.bgv = imageView;
            this.path = str;
        }

        public final ac aRW() {
            return ad.aSp();
        }
    }

    public PreviewImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PreviewImageView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        this.jIL = (TableLayout) LayoutInflater.from(this.context).inflate(2130904488, this, true).findViewById(2131755329);
    }

    public final void bw(List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        if (list != null) {
            this.gKQ = list;
            int i = 0;
            this.jIL.removeAllViews();
            int size = list.size() + 1;
            int i2 = 0;
            while (i < size) {
                View view;
                int i3;
                View view2 = (TableRow) this.jIN.get(Integer.valueOf(i2));
                if (view2 == null) {
                    view2 = new TableRow(this.context);
                    this.jIN.put(Integer.valueOf(i2), view2);
                    view = view2;
                } else {
                    view = view2;
                }
                view.removeAllViews();
                for (int i4 = 0; i4 < 4 && i < size; i4++) {
                    if (i >= 9) {
                        i3 = i + 1;
                        break;
                    }
                    String str;
                    view2 = (View) this.jIM.get(Integer.valueOf(i));
                    if (view2 == null) {
                        view2 = View.inflate(this.context, 2130904489, null);
                        this.jIM.put(Integer.valueOf(i), view2);
                    }
                    View view3 = view2;
                    if (i == size - 1) {
                        str = "";
                    } else {
                        str = (String) list.get(i);
                    }
                    ImageView imageView = (ImageView) view3.findViewById(2131757494);
                    if (i != size - 1) {
                        imageView.setBackgroundDrawable(null);
                        imageView.setTag(str);
                        imageView.setContentDescription(getContext().getString(2131235432));
                        Bitmap bitmap = (Bitmap) this.jIP.get(str);
                        if (i.i(bitmap)) {
                            imageView.setImageBitmap(bitmap);
                        } else {
                            v.d("MicroMsg.PreviewImageView", "bm is null");
                            new b(this, imageView, str).l("");
                        }
                    } else if (this.jIR) {
                        imageView.setBackgroundResource(2130839206);
                        imageView.setContentDescription(getContext().getString(2131235371));
                        imageView.setImageDrawable(null);
                    } else {
                        i++;
                    }
                    if (this.jIQ != null) {
                        if (i == size - 1) {
                            view3.setTag(Integer.valueOf(-1));
                            view3.setOnClickListener(this.jIQ.jIT);
                            view3.setClickable(true);
                        } else {
                            view3.setTag(Integer.valueOf(i));
                            view3.setOnClickListener(this.jIQ.jIT);
                            view3.setClickable(true);
                        }
                    }
                    view3.setLayoutParams(new LayoutParams(-2, -2));
                    view.addView(view3);
                    i++;
                }
                i3 = i;
                if (view.getChildCount() > 0) {
                    this.jIL.addView(view);
                }
                v.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - currentTimeMillis));
                i2++;
                i = i3;
            }
        }
    }
}
