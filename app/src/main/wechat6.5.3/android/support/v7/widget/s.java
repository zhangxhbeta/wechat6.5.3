package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public final class s {
    final b UR;
    final a US = new a();
    final List<View> UT = new ArrayList();

    static class a {
        long UU = 0;
        a UV;

        a() {
        }

        final void set(int i) {
            while (i >= 64) {
                eL();
                this = this.UV;
                i -= 64;
            }
            this.UU |= 1 << i;
        }

        private void eL() {
            if (this.UV == null) {
                this.UV = new a();
            }
        }

        final void clear(int i) {
            while (i >= 64) {
                if (this.UV != null) {
                    this = this.UV;
                    i -= 64;
                } else {
                    return;
                }
            }
            this.UU &= (1 << i) ^ -1;
        }

        final boolean get(int i) {
            while (i >= 64) {
                eL();
                this = this.UV;
                i -= 64;
            }
            return (this.UU & (1 << i)) != 0;
        }

        final void n(int i, boolean z) {
            while (true) {
                if (i >= 64) {
                    eL();
                    this = this.UV;
                    i -= 64;
                } else {
                    boolean z2 = (this.UU & Long.MIN_VALUE) != 0;
                    long j = (1 << i) - 1;
                    this.UU = (((j ^ -1) & this.UU) << 1) | (this.UU & j);
                    if (z) {
                        set(i);
                    } else {
                        clear(i);
                    }
                    if (z2 || this.UV != null) {
                        eL();
                        this = this.UV;
                        i = 0;
                        z = z2;
                    } else {
                        return;
                    }
                }
            }
        }

        final boolean aM(int i) {
            while (i >= 64) {
                eL();
                this = this.UV;
                i -= 64;
            }
            long j = 1 << i;
            boolean z = (this.UU & j) != 0;
            this.UU &= j ^ -1;
            j--;
            this.UU = Long.rotateRight((j ^ -1) & this.UU, 1) | (this.UU & j);
            if (this.UV != null) {
                if (this.UV.get(0)) {
                    set(63);
                }
                this.UV.aM(0);
            }
            return z;
        }

        final int aN(int i) {
            if (this.UV == null) {
                if (i >= 64) {
                    return Long.bitCount(this.UU);
                }
                return Long.bitCount(this.UU & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.UU & ((1 << i) - 1));
            } else {
                return this.UV.aN(i - 64) + Long.bitCount(this.UU);
            }
        }

        public final String toString() {
            return this.UV == null ? Long.toBinaryString(this.UU) : this.UV.toString() + "xx" + Long.toBinaryString(this.UU);
        }
    }

    interface b {
        android.support.v7.widget.RecyclerView.s aP(View view);

        void aQ(View view);

        void aR(View view);

        void addView(View view, int i);

        void attachViewToParent(View view, int i, LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        int indexOfChild(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    s(b bVar) {
        this.UR = bVar;
    }

    final void aM(View view) {
        this.UT.add(view);
        this.UR.aQ(view);
    }

    final boolean aN(View view) {
        if (!this.UT.remove(view)) {
            return false;
        }
        this.UR.aR(view);
        return true;
    }

    final void a(View view, int i, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.UR.getChildCount();
        } else {
            childCount = aK(i);
        }
        this.US.n(childCount, z);
        if (z) {
            aM(view);
        }
        this.UR.addView(view, childCount);
    }

    final int aK(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.UR.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int aN = i - (i2 - this.US.aN(i2));
            if (aN == 0) {
                while (this.US.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += aN;
        }
        return -1;
    }

    public final View getChildAt(int i) {
        return this.UR.getChildAt(aK(i));
    }

    final void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.UR.getChildCount();
        } else {
            childCount = aK(i);
        }
        this.US.n(childCount, z);
        if (z) {
            aM(view);
        }
        this.UR.attachViewToParent(view, childCount, layoutParams);
    }

    public final int getChildCount() {
        return this.UR.getChildCount() - this.UT.size();
    }

    public final int eK() {
        return this.UR.getChildCount();
    }

    public final View aL(int i) {
        return this.UR.getChildAt(i);
    }

    final void detachViewFromParent(int i) {
        int aK = aK(i);
        this.US.aM(aK);
        this.UR.detachViewFromParent(aK);
    }

    final int indexOfChild(View view) {
        int indexOfChild = this.UR.indexOfChild(view);
        if (indexOfChild == -1 || this.US.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.US.aN(indexOfChild);
    }

    final boolean aO(View view) {
        return this.UT.contains(view);
    }

    public final String toString() {
        return this.US.toString() + ", hidden list:" + this.UT.size();
    }
}
