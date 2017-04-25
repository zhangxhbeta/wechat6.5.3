package android.support.v4.d;

import java.util.Locale;

public final class e {
    public static final d vf = new e(null, false);
    public static final d vg = new e(null, true);
    public static final d vh = new e(b.vo, false);
    public static final d vi = new e(b.vo, true);
    public static final d vj = new e(a.vm, false);
    public static final d vk = f.vr;

    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    private static class a implements c {
        public static final a vm = new a(true);
        public static final a vn = new a(false);
        private final boolean vl;

        public final int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                switch (e.O(Character.getDirectionality(charSequence.charAt(i5)))) {
                    case 0:
                        if (!this.vl) {
                            i4 = 1;
                            break;
                        }
                        return 0;
                    case 1:
                        if (this.vl) {
                            i4 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
            }
            if (i4 == 0) {
                return 2;
            }
            if (this.vl) {
                return 1;
            }
            return 0;
        }

        private a(boolean z) {
            this.vl = z;
        }
    }

    private static class b implements c {
        public static final b vo = new b();

        public final int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + 0;
            int i4 = 2;
            for (int i5 = 0; i5 < i3 && i4 == 2; i5++) {
                i4 = e.N(Character.getDirectionality(charSequence.charAt(i5)));
            }
            return i4;
        }

        private b() {
        }
    }

    private static abstract class d implements d {
        private final c vp;

        protected abstract boolean bA();

        public d(c cVar) {
            this.vp = cVar;
        }

        public final boolean a(CharSequence charSequence, int i) {
            if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
                throw new IllegalArgumentException();
            } else if (this.vp == null) {
                return bA();
            } else {
                switch (this.vp.a(charSequence, 0, i)) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                    default:
                        return bA();
                }
            }
        }
    }

    private static class e extends d {
        private final boolean vq;

        private e(c cVar, boolean z) {
            super(cVar);
            this.vq = z;
        }

        protected final boolean bA() {
            return this.vq;
        }
    }

    private static class f extends d {
        public static final f vr = new f();

        public f() {
            super(null);
        }

        protected final boolean bA() {
            if (f.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static /* synthetic */ int N(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }

    static /* synthetic */ int O(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }
}
