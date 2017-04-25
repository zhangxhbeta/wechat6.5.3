package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

final class h {

    static class a implements Factory {
        final j wj;

        a(j jVar) {
            this.wj = jVar;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.wj.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.wj + "}";
        }
    }
}
