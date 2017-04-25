package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.v;

public class MMDotView extends LinearLayout {
    int caG = 9;
    public int nUK = 2130838835;
    public int nUL = 2130838830;

    @TargetApi(11)
    public MMDotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public MMDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPn);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        wt(resourceId);
    }

    public final void wt(int i) {
        v.v("MicroMsg.MMDotView", "setDotCount:%d", Integer.valueOf(i));
        if (i >= 0) {
            ImageView imageView;
            if (i > this.caG) {
                v.i("MicroMsg.MMDotView", "large than max count");
                i = this.caG;
            }
            removeAllViews();
            for (i = 
/*
Method generation error in method: com.tencent.mm.ui.base.MMDotView.wt(int):void
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r6_2 'i' int) = (r6_0 'i' int), (r6_1 'i' int) binds: {(r6_0 'i' int)=B:3:0x0018, (r6_1 'i' int)=B:4:0x001a} in method: com.tencent.mm.ui.base.MMDotView.wt(int):void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 22 more

*/

            public final void wu(int i) {
                v.v("MicroMsg.MMDotView", "setSelectedDot:target index is %d", Integer.valueOf(i));
                if (i >= getChildCount()) {
                    i = getChildCount() - 1;
                } else if (i < 0) {
                    i = 0;
                }
                v.v("MicroMsg.MMDotView", "setSelectedDot:after adjust index is %d", Integer.valueOf(i));
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    ((ImageView) getChildAt(i2)).setImageResource(this.nUK);
                }
                ImageView imageView = (ImageView) getChildAt(i);
                if (imageView != null) {
                    imageView.setImageResource(this.nUL);
                }
            }
        }
