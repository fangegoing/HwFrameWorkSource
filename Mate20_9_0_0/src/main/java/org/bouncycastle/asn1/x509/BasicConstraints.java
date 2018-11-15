package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class BasicConstraints extends ASN1Object {
    ASN1Boolean cA;
    ASN1Integer pathLenConstraint;

    public BasicConstraints(int i) {
        this.cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        this.cA = ASN1Boolean.getInstance(true);
        this.pathLenConstraint = new ASN1Integer((long) i);
    }

    private BasicConstraints(ASN1Sequence aSN1Sequence) {
        this.cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        if (aSN1Sequence.size() == 0) {
            this.cA = null;
            this.pathLenConstraint = null;
            return;
        }
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Boolean) {
            this.cA = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.cA = null;
            this.pathLenConstraint = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        }
        if (aSN1Sequence.size() <= 1) {
            return;
        }
        if (this.cA != null) {
            this.pathLenConstraint = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("wrong sequence in constructor");
    }

    public BasicConstraints(boolean z) {
        this.cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        if (z) {
            this.cA = ASN1Boolean.getInstance(true);
        } else {
            this.cA = null;
        }
        this.pathLenConstraint = null;
    }

    public static BasicConstraints fromExtensions(Extensions extensions) {
        return getInstance(extensions.getExtensionParsedValue(Extension.basicConstraints));
    }

    public static BasicConstraints getInstance(Object obj) {
        return obj instanceof BasicConstraints ? (BasicConstraints) obj : obj instanceof X509Extension ? getInstance(X509Extension.convertValueToObject((X509Extension) obj)) : obj != null ? new BasicConstraints(ASN1Sequence.getInstance(obj)) : null;
    }

    public static BasicConstraints getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getPathLenConstraint() {
        return this.pathLenConstraint != null ? this.pathLenConstraint.getValue() : null;
    }

    public boolean isCA() {
        return this.cA != null && this.cA.isTrue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.cA != null) {
            aSN1EncodableVector.add(this.cA);
        }
        if (this.pathLenConstraint != null) {
            aSN1EncodableVector.add(this.pathLenConstraint);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder stringBuilder;
        if (this.pathLenConstraint != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("BasicConstraints: isCa(");
            stringBuilder.append(isCA());
            stringBuilder.append("), pathLenConstraint = ");
            stringBuilder.append(this.pathLenConstraint.getValue());
        } else if (this.cA == null) {
            return "BasicConstraints: isCa(false)";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("BasicConstraints: isCa(");
            stringBuilder.append(isCA());
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }
}