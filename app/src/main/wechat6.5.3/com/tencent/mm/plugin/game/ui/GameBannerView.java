package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.LinkedList;

public class GameBannerView extends LinearLayout implements e, OnClickListener {
    private float euH = 0.0f;
    private MMDotView fjs;
    private ViewPager fjt;
    int gjl = 0;
    private b gpA;
    LinkedList<a> gpB;
    ah gpC = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ GameBannerView gpE;

        {
            this.gpE = r1;
        }

        public final boolean oU() {
            if (this.gpE.fjt == null || this.gpE.gpB.size() <= 1) {
                this.gpE.gpC.QI();
                return false;
            }
            this.gpE.fjt.k(this.gpE.fjt.xB + 1, true);
            return true;
        }
    }, true);
    private float gpD = 0.0f;
    private Context mContext;

    public static class a {
        public String cxy;
        public String ghp;
        public f gpF;
        public int index;
    }

    private final class b extends t {
        final /* synthetic */ GameBannerView gpE;

        private b(GameBannerView gameBannerView) {
            this.gpE = gameBannerView;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            int size = i % this.gpE.gpB.size();
            viewGroup.removeView((View) obj);
            v.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
        }

        public final Object b(ViewGroup viewGroup, int i) {
            int size = i % this.gpE.gpB.size();
            View inflate = View.inflate(this.gpE.mContext, 2130903695, null);
            inflate.setTag(this.gpE.gpB.get(size));
            inflate.setOnClickListener(this.gpE);
            ImageView imageView = (ImageView) inflate.findViewById(2131757193);
            String str = ((a) this.gpE.gpB.get(size)).cxy;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof i)) {
                imageView.setImageDrawable(new i(str));
            } else {
                ((i) drawable).setUrl(str);
            }
            try {
                viewGroup.addView(inflate, 0);
            } catch (Exception e) {
                v.e("MicroMsg.GameBannerView", "add view failed, " + e.getMessage());
            }
            v.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
            return inflate;
        }

        public final int getCount() {
            return this.gpE.gpB.size() <= 1 ? this.gpE.gpB.size() : (this.gpE.gpB.size() * BaseReportManager.MAX_READ_COUNT) * 2;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }
    }

    public GameBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        inflate(context, 2130903694, this);
        this.gpB = new LinkedList();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.fjs = (MMDotView) findViewById(2131757192);
        this.fjt = (ViewPager) findViewById(2131757191);
        this.fjt.yk = this;
        this.gpA = new b();
    }

    public final void J(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            v.e("MicroMsg.GameBannerView", "Empty banner list");
            setVisibility(8);
            return;
        }
        v.i("MicroMsg.GameBannerView", "bannerList size", new Object[]{Integer.valueOf(linkedList.size())});
        this.gpC.QI();
        this.gpB.clear();
        this.gpB.addAll(linkedList);
        this.fjt.a(this.gpA);
        this.fjt.k(linkedList.size() * BaseReportManager.MAX_READ_COUNT, false);
        if (this.gpB.size() > 1) {
            this.gpC.ea(5000);
        }
        this.fjs.setVisibility(8);
        setVisibility(0);
    }

    public final void X(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void W(int i) {
        int size = i % this.gpB.size();
        v.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", new Object[]{Integer.valueOf(i), Integer.valueOf(size)});
        if (((a) this.gpB.get(size)).gpF != null && ak.uz()) {
            af.a(this.mContext, 11, 1101, size + 1, 1, this.gjl, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action) {
            case 0:
                this.gpD = rawX;
                this.euH = rawY;
                break;
            case 1:
            case 3:
                do(false);
                this.gpD = 0.0f;
                this.euH = 0.0f;
                break;
            case 2:
                if (Math.abs((int) (rawX - this.gpD)) > Math.abs((int) (rawY - this.euH))) {
                    do(true);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.gpC.QI();
                break;
            case 1:
            case 3:
                this.gpC.ea(5000);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void do(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            f fVar = aVar.gpF;
            if (be.kS(aVar.ghp)) {
                v.i("MicroMsg.GameBannerView", "null or nil url");
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", fVar.field_appId);
                bundle.putInt("game_report_from_scene", 5);
                af.a(this.mContext, 11, 1101, 1, c.a(this.mContext, fVar.field_appId, null, bundle), this.gjl, null);
                return;
            }
            String str = aVar.ghp;
            Intent intent = new Intent();
            c.W(this.mContext, str);
            af.a(this.mContext, 11, 1101, 1, 7, this.gjl, null);
        }
    }
}
