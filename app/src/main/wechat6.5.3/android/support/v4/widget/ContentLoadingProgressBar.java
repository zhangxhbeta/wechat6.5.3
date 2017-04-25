package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private boolean Ar = false;
    private boolean As = false;
    private final Runnable At = new Runnable(this) {
        final /* synthetic */ ContentLoadingProgressBar Av;

        {
            this.Av = r1;
        }

        public final void run() {
            this.Av.Ar = false;
            this.Av.mStartTime = -1;
            this.Av.setVisibility(8);
        }
    };
    private final Runnable Au = new Runnable(this) {
        final /* synthetic */ ContentLoadingProgressBar Av;

        {
            this.Av = r1;
        }

        public final void run() {
            this.Av.As = false;
            if (!this.Av.oA) {
                this.Av.mStartTime = System.currentTimeMillis();
                this.Av.setVisibility(0);
            }
        }
    };
    private long mStartTime = -1;
    private boolean oA = false;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        cp();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cp();
    }

    private void cp() {
        removeCallbacks(this.At);
        removeCallbacks(this.Au);
    }
}
