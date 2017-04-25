package b.a.d;

public final class d implements Comparable<d> {
    final String apU;
    final String value;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        int compareTo = this.apU.compareTo(dVar.apU);
        return compareTo != 0 ? compareTo : this.value.compareTo(dVar.value);
    }

    public d(String str, String str2) {
        this.apU = str;
        this.value = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (dVar.apU.equals(this.apU) && dVar.value.equals(this.value)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.apU.hashCode() + this.value.hashCode();
    }
}
