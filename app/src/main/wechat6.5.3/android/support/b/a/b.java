package android.support.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
public final class b extends e implements Animatable {
    private a lV;
    private ArgbEvaluator lW;
    private final Callback lX;
    private Context mContext;

    private static class a extends ConstantState {
        int lZ;
        f ma;
        ArrayList<Animator> mb;
        android.support.v4.e.a<Animator, String> mc;

        public a(a aVar, Callback callback, Resources resources) {
        }

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public final int getChangingConfigurations() {
            return this.lZ;
        }
    }

    private static class b extends ConstantState {
        private final ConstantState md;

        public b(ConstantState constantState) {
            this.md = constantState;
        }

        public final Drawable newDrawable() {
            Drawable bVar = new b();
            bVar.mi = this.md.newDrawable();
            bVar.mi.setCallback(bVar.lX);
            return bVar;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable bVar = new b();
            bVar.mi = this.md.newDrawable(resources);
            bVar.mi.setCallback(bVar.lX);
            return bVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            Drawable bVar = new b();
            bVar.mi = this.md.newDrawable(resources, theme);
            bVar.mi.setCallback(bVar.lX);
            return bVar;
        }

        public final boolean canApplyTheme() {
            return this.md.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.md.getChangingConfigurations();
        }
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private b() {
        this(null, (byte) 0);
    }

    private b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b) {
        this.lW = null;
        this.lX = new Callback(this) {
            final /* synthetic */ b lY;

            {
                this.lY = r1;
            }

            public final void invalidateDrawable(Drawable drawable) {
                this.lY.invalidateSelf();
            }

            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                this.lY.scheduleSelf(runnable, j);
            }

            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                this.lY.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        this.lV = new a(null, this.lX, null);
    }

    public final Drawable mutate() {
        if (this.mi != null) {
            this.mi.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    public final ConstantState getConstantState() {
        if (this.mi != null) {
            return new b(this.mi.getConstantState());
        }
        return null;
    }

    public final int getChangingConfigurations() {
        if (this.mi != null) {
            return this.mi.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.lV.lZ;
    }

    public final void draw(Canvas canvas) {
        if (this.mi != null) {
            this.mi.draw(canvas);
            return;
        }
        this.lV.ma.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.mi != null) {
            this.mi.setBounds(rect);
        } else {
            this.lV.ma.setBounds(rect);
        }
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.mi != null) {
            return this.mi.setState(iArr);
        }
        return this.lV.ma.setState(iArr);
    }

    protected final boolean onLevelChange(int i) {
        if (this.mi != null) {
            return this.mi.setLevel(i);
        }
        return this.lV.ma.setLevel(i);
    }

    public final int getAlpha() {
        if (this.mi != null) {
            return android.support.v4.b.a.a.d(this.mi);
        }
        return this.lV.ma.getAlpha();
    }

    public final void setAlpha(int i) {
        if (this.mi != null) {
            this.mi.setAlpha(i);
        } else {
            this.lV.ma.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.mi != null) {
            this.mi.setColorFilter(colorFilter);
        } else {
            this.lV.ma.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i) {
        if (this.mi != null) {
            android.support.v4.b.a.a.a(this.mi, i);
        } else {
            this.lV.ma.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.mi != null) {
            android.support.v4.b.a.a.a(this.mi, colorStateList);
        } else {
            this.lV.ma.setTintList(colorStateList);
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.mi != null) {
            android.support.v4.b.a.a.a(this.mi, mode);
        } else {
            this.lV.ma.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.mi != null) {
            return this.mi.setVisible(z, z2);
        }
        this.lV.ma.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.mi != null) {
            return this.mi.isStateful();
        }
        return this.lV.ma.isStateful();
    }

    public final int getOpacity() {
        if (this.mi != null) {
            return this.mi.getOpacity();
        }
        return this.lV.ma.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.mi != null) {
            return this.mi.getIntrinsicWidth();
        }
        return this.lV.ma.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.mi != null) {
            return this.mi.getIntrinsicHeight();
        }
        return this.lV.ma.getIntrinsicHeight();
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.mi != null) {
            android.support.v4.b.a.a.a(this.mi, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray obtainAttributes;
                if ("animated-vector".equals(name)) {
                    int[] iArr = a.lT;
                    obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f a = f.a(resources, resourceId, theme);
                        a.mo = false;
                        a.setCallback(this.lX);
                        if (this.lV.ma != null) {
                            this.lV.ma.setCallback(null);
                        }
                        this.lV.ma = a;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, a.lU);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.mContext != null) {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(this.mContext, resourceId2);
                            loadAnimator.setTarget(this.lV.ma.mk.ni.nh.get(string));
                            if (VERSION.SDK_INT < 21) {
                                b(loadAnimator);
                            }
                            if (this.lV.mb == null) {
                                this.lV.mb = new ArrayList();
                                this.lV.mc = new android.support.v4.e.a();
                            }
                            this.lV.mb.add(loadAnimator);
                            this.lV.mc.put(loadAnimator, string);
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public final void applyTheme(Theme theme) {
        if (this.mi != null) {
            android.support.v4.b.a.a.a(this.mi, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.mi != null) {
            return android.support.v4.b.a.a.e(this.mi);
        }
        return false;
    }

    private void b(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    b((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.lW == null) {
                    this.lW = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.lW);
            }
        }
    }

    public final boolean isRunning() {
        if (this.mi != null) {
            return ((AnimatedVectorDrawable) this.mi).isRunning();
        }
        ArrayList arrayList = this.lV.mb;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean isStarted() {
        ArrayList arrayList = this.lV.mb;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        if (this.mi != null) {
            ((AnimatedVectorDrawable) this.mi).start();
        } else if (!isStarted()) {
            ArrayList arrayList = this.lV.mb;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.mi != null) {
            ((AnimatedVectorDrawable) this.mi).stop();
            return;
        }
        ArrayList arrayList = this.lV.mb;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
