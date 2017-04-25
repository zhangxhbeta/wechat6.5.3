package com.google.android.gms.tagmanager;

final class ah extends Number implements Comparable<ah> {
    private double aDo;
    private long aDp = 0;
    boolean aDq = true;

    private ah(long j) {
    }

    private int a(ah ahVar) {
        return (this.aDq && ahVar.aDq) ? new Long(this.aDp).compareTo(Long.valueOf(ahVar.aDp)) : Double.compare(doubleValue(), ahVar.doubleValue());
    }

    public static ah ml() {
        return new ah(0);
    }

    public final byte byteValue() {
        return (byte) ((int) longValue());
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return a((ah) obj);
    }

    public final double doubleValue() {
        return this.aDq ? (double) this.aDp : this.aDo;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ah) && a((ah) obj) == 0;
    }

    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public final int intValue() {
        return (int) longValue();
    }

    public final long longValue() {
        return this.aDq ? this.aDp : (long) this.aDo;
    }

    public final short shortValue() {
        return (short) ((int) longValue());
    }

    public final String toString() {
        return this.aDq ? Long.toString(this.aDp) : Double.toString(this.aDo);
    }
}
