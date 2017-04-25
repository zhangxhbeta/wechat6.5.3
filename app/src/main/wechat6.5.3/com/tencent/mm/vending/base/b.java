package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.f;

public abstract class b<_Struct, _Change> extends Vending<_Struct, Integer, _Change> {
    public int mCount = 0;
    public int pgv = 5;
    private a pgw = new a();

    private static final class a {
        public int aaL;
        public int aaM;
        boolean cit;

        private a() {
            this.aaL = -1;
            this.aaM = -1;
            this.cit = false;
        }

        final void set(int i, int i2) {
            this.aaL = i;
            this.aaM = i2;
        }
    }

    public abstract int bKx();

    public abstract _Struct rh(int i);

    protected /* synthetic */ boolean invalidIndex(Object obj) {
        return ((Integer) obj).intValue() < 0;
    }

    protected /* synthetic */ void requestIndexImpl(i iVar, Object obj) {
        Integer num = (Integer) obj;
        int i = this.mCount;
        if (i > 0) {
            dA(Math.min(i - 1, num.intValue()), Math.min(i - 1, num.intValue() + this.pgv));
            dA(Math.max(Math.min(0, num.intValue()), num.intValue()), Math.max(Math.min(0, num.intValue()), num.intValue() - this.pgv));
        }
    }

    protected /* synthetic */ Object resolveAsynchronous(Object obj) {
        return rh(((Integer) obj).intValue());
    }

    public final <T> T get(int i) {
        if (this.mCount != 0) {
            return super.get(Integer.valueOf(i));
        }
        com.tencent.mm.vending.f.a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
        return null;
    }

    public final void yx(int i) {
        if (this.mCount == 0) {
            com.tencent.mm.vending.f.a.e("Vending.ForwardVending", "the count is 0, why call null?", new Object[0]);
        } else {
            super.request(Integer.valueOf(i));
        }
    }

    protected void synchronizing(int i, Object obj) {
        this.mCount = bKx();
        com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "the count %s", new Object[]{Integer.valueOf(this.mCount)});
    }

    private void dA(int i, int i2) {
        int i3;
        int[] iArr;
        int i4 = i >= i2 ? 1 : 0;
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        synchronized (this.pgw) {
            a aVar = this.pgw;
            if (aVar.cit) {
                int i5 = aVar.aaL;
                i3 = aVar.aaM;
                if (i5 > max || i3 < min) {
                    if (i5 > max + 1 || i3 < min - 1) {
                        aVar.set(min, max);
                    }
                    iArr = new int[]{min, max};
                } else if (min < i5) {
                    if (max > i3) {
                        aVar.set(min, max);
                        iArr = new int[]{min, i5 - 1, i3 + 1, max};
                    } else {
                        aVar.set(min, i3);
                        iArr = new int[]{min, i5 - 1};
                    }
                } else if (max > i3) {
                    aVar.set(i5, max);
                    iArr = new int[]{i3 + 1, max};
                } else {
                    iArr = null;
                }
            } else {
                aVar.set(min, max);
                aVar.cit = true;
                iArr = new int[]{min, max};
            }
        }
        if (iArr != null) {
            min = i4 != 0 ? iArr.length - 2 : 0;
            while (true) {
                if (i4 != 0) {
                    if (min < 0) {
                        return;
                    }
                } else if (min >= iArr.length) {
                    return;
                }
                int i6 = iArr[min];
                i3 = iArr[min + 1];
                int abs = Math.abs(i6 - i3);
                for (max = 0; max <= abs; max++) {
                    int i7;
                    if (i4 != 0) {
                        i7 = i3 - max;
                    } else {
                        i7 = i6 + max;
                    }
                    f loader = getLoader();
                    Integer valueOf = Integer.valueOf(i7);
                    if (!loader.pgC.get()) {
                        synchronized (loader.pgD) {
                            com.tencent.mm.vending.base.Vending.f.b bVar = (com.tencent.mm.vending.base.Vending.f.b) loader.pgA.get(valueOf);
                            if (bVar == null || bVar == com.tencent.mm.vending.base.Vending.f.b.NIL) {
                                loader.pgA.put(valueOf, com.tencent.mm.vending.base.Vending.f.b.PENDING);
                                loader.mVendingHandler.sendMessage(loader.mVendingHandler.obtainMessage(0, valueOf));
                            }
                        }
                    }
                }
                if (i4 != 0) {
                    min -= 2;
                } else {
                    min += 2;
                }
            }
        }
    }

    protected void loaderClear() {
        synchronized (this.pgw) {
            a aVar = this.pgw;
            aVar.aaL = -1;
            aVar.aaM = -1;
            aVar.cit = false;
        }
    }
}
