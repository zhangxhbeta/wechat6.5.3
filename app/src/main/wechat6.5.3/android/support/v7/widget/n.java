package android.support.v7.widget;

import android.content.Context;
import android.view.View;

final class n implements q {
    n() {
    }

    public final void a(o oVar, Context context, int i, float f, float f2, float f3) {
        oVar.setBackgroundDrawable(new ae(i, f));
        View view = (View) oVar;
        view.setClipToOutline(true);
        view.setElevation(f2);
        ae aeVar = (ae) oVar.getBackground();
        boolean eH = oVar.eH();
        boolean eI = oVar.eI();
        if (!(f3 == aeVar.aaF && aeVar.aaG == eH && aeVar.aaH == eI)) {
            aeVar.aaF = f3;
            aeVar.aaG = eH;
            aeVar.aaH = eI;
            aeVar.f(null);
            aeVar.invalidateSelf();
        }
        if (oVar.eH()) {
            float f4 = ((ae) oVar.getBackground()).aaF;
            float c = c(oVar);
            int ceil = (int) Math.ceil((double) af.b(f4, c, oVar.eI()));
            int ceil2 = (int) Math.ceil((double) af.a(f4, c, oVar.eI()));
            oVar.c(ceil, ceil2, ceil, ceil2);
            return;
        }
        oVar.c(0, 0, 0, 0);
    }

    public final void eJ() {
    }

    public final float a(o oVar) {
        return c(oVar) * 2.0f;
    }

    public final float b(o oVar) {
        return c(oVar) * 2.0f;
    }

    private static float c(o oVar) {
        return ((ae) oVar.getBackground()).aaC;
    }

    public final void a(o oVar, float f) {
        ((View) oVar).setElevation(f);
    }

    public final float d(o oVar) {
        return ((View) oVar).getElevation();
    }

    public final void a(o oVar, int i) {
        ae aeVar = (ae) oVar.getBackground();
        aeVar.ft.setColor(-1);
        aeVar.invalidateSelf();
    }
}
