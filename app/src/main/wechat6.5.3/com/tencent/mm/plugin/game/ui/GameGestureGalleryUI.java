package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.game.c.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMGallery;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameGestureGalleryUI extends MMActivity implements OnTouchListener, com.tencent.mm.platformtools.j.a {
    private String bea;
    private a gsT;
    private MMGallery gsU;
    private MMGestureGallery gsV;
    float gsW = 0.0f;
    float gsX = 0.0f;
    boolean gsY = false;
    float gsZ = 1.0f;
    private q gta;
    private List<String> gtb = new ArrayList();
    private int gtc = -1;
    private OnItemSelectedListener gtd = new OnItemSelectedListener(this) {
        final /* synthetic */ GameGestureGalleryUI gte;

        {
            this.gte = r1;
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.gte.gtc = i;
            this.gte.Fd((this.gte.gtc + 1) + " / " + this.gte.gtb.size());
            v.d("MicroMsg.GameGestureGalleryUI", "pos:" + i);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    };

    class a extends BaseAdapter {
        final /* synthetic */ GameGestureGalleryUI gte;

        class a {
            ImageView bgv;
            ProgressBar gtf;
            final /* synthetic */ a gtg;

            a(a aVar) {
                this.gtg = aVar;
            }
        }

        public a(GameGestureGalleryUI gameGestureGalleryUI) {
            this.gte = gameGestureGalleryUI;
        }

        public final int getCount() {
            v.d("MicroMsg.GameGestureGalleryUI", "lstpicurl:" + this.gte.gtb.size());
            return this.gte.gtb.size();
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.gte, 2130903802, null);
                aVar.gtf = (ProgressBar) view.findViewById(2131757495);
                aVar.bgv = (ImageView) view.findViewById(2131755052);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            aVar.gtf.setVisibility(8);
            Bitmap a = j.a(new ah((String) this.gte.gtb.get(i)));
            if (a == null || a.isRecycled()) {
                aVar.gtf.setVisibility(0);
                if (!be.kS(this.gte.bea)) {
                    a = j.a(new ah(this.gte.bea));
                }
                if (a == null || a.isRecycled()) {
                    aVar.bgv.setVisibility(8);
                    return view;
                }
                aVar.bgv.setImageBitmap(a);
                aVar.bgv.setVisibility(0);
                return view;
            } else if (f.aZy()) {
                aVar.bgv.setVisibility(8);
                view = new MultiTouchImageView(this.gte, a.getWidth(), a.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(a);
                return view;
            } else {
                aVar.bgv.setImageBitmap(a);
                aVar.bgv.setVisibility(0);
                aVar.bgv.setScaleType(ScaleType.MATRIX);
                return view;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gta = new q(false);
        j.a(this);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
        this.gta.yy();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return 2130904235;
    }

    protected final void NI() {
        this.bea = getIntent().getStringExtra("thumbUrl");
        String ma = be.ma(getIntent().getStringExtra("nowUrl"));
        this.nDR.bAj();
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            this.gtb = new ArrayList();
            this.gtb.add(ma);
        } else {
            this.gtb = Arrays.asList(stringArrayExtra);
        }
        for (int i = 0; i < this.gtb.size(); i++) {
            if (ma.equals(this.gtb.get(i))) {
                this.gtc = i;
                break;
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameGestureGalleryUI gte;

            {
                this.gte = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gte.finish();
                return true;
            }
        });
        this.gsT = new a(this);
        if (f.aZy()) {
            this.gsV = (MMGestureGallery) findViewById(2131755843);
            this.gsV.setVisibility(0);
            this.gsV.setVerticalFadingEdgeEnabled(false);
            this.gsV.setHorizontalFadingEdgeEnabled(false);
            this.gsV.setAdapter(this.gsT);
            this.gsV.setSelection(this.gtc);
            this.gsV.setOnItemSelectedListener(this.gtd);
            return;
        }
        this.gsU = (MMGallery) findViewById(2131758782);
        this.gsU.setVisibility(0);
        this.gsU.setAdapter(this.gsT);
        this.gsU.setSelection(this.gtc);
        this.gsU.setOnItemSelectedListener(this.gtd);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        v.d("MicroMsg.GameGestureGalleryUI", "Main onTouch event.getAction():" + motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 2:
                if (this.gsY) {
                    this.gsX = f.u(motionEvent);
                    if (this.gsX >= 5.0f) {
                        float f = this.gsX - this.gsW;
                        if (f != 0.0f) {
                            if (Math.abs(f) <= 5.0f) {
                                return true;
                            }
                            float f2 = f / 854.0f;
                            Animation scaleAnimation = new ScaleAnimation(this.gsZ, this.gsZ + f2, this.gsZ, this.gsZ + f2, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(100);
                            scaleAnimation.setFillAfter(true);
                            scaleAnimation.setFillEnabled(true);
                            this.gsZ += f2;
                            this.gsU.getSelectedView().setLayoutParams(new LayoutParams((int) (480.0f * this.gsZ), (int) (this.gsZ * 854.0f)));
                            this.gsW = this.gsX;
                            return true;
                        }
                    }
                }
                break;
            case 5:
                this.gsW = f.u(motionEvent);
                if (this.gsW > 5.0f) {
                    this.gsY = true;
                    break;
                }
                break;
            case 6:
                this.gsY = false;
                break;
        }
        return false;
    }

    public final void k(String str, Bitmap bitmap) {
        if (this.gtb != null && this.gtb.size() != 0) {
            if ((((String) this.gtb.get(0)).hashCode()).equals(str) && this.gsT != null) {
                this.gsT.notifyDataSetChanged();
            }
        }
    }
}
