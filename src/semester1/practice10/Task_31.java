package semester1.practice10;

class Matrix2x2 {
    protected double a11, a12, a21, a22;

    public Matrix2x2(double a11, double a12, double a21, double a22) {
        this.a11 = a11;
        this.a12 = a12;
        this.a21 = a21;
        this.a22 = a22;
    }

    public double determinant() {
        return a11 * a22 - a12 * a21;
    }

    @Override
    public String toString() {
        return "[[" + a11 + ", " + a12 + "], [" + a21 + ", " + a22 + "]]";
    }
}

interface InvertibleMatrix {
    Matrix2x2 inverse();
}

interface OrthogonalMatrix {
    boolean checkOrthogonality();
}

class RotationMatrix2x2 extends Matrix2x2
        implements InvertibleMatrix, OrthogonalMatrix {

    public RotationMatrix2x2(double angle) {
        super(
                Math.cos(angle), -Math.sin(angle),
                Math.sin(angle), Math.cos(angle)
        );
    }

    @Override
    public Matrix2x2 inverse() {
        return new Matrix2x2(a11, a21, a12, a22);
    }

    @Override
    public boolean checkOrthogonality() {
        double dotProduct = a11 * a12 + a21 * a22;
        return Math.abs(dotProduct) < 0.000001
                && Math.abs(a11 * a11 + a21 * a21 - 1) < 0.000001
                && Math.abs(a12 * a12 + a22 * a22 - 1) < 0.000001;
    }
}

class SingularMatrix2x2 extends Matrix2x2 {

    public SingularMatrix2x2() {
        super(1, 2, 2, 4);
    }
}

abstract class Task_31 {

    public static void main(String[] args) {
        Matrix2x2[] matrices = {
                new RotationMatrix2x2(Math.PI / 4),
                new SingularMatrix2x2()
        };

        for (Matrix2x2 m : matrices) {
            System.out.println("Матриця: " + m);
            System.out.println("Детермінант: " + m.determinant());

            if (m instanceof InvertibleMatrix inv) {
                System.out.println("Обернена матриця: " + inv.inverse());
            } else {
                System.out.println("Матриця не має оберненої");
            }

            if (m instanceof OrthogonalMatrix orth) {
                System.out.println(
                        "Ортогональна: " + orth.checkOrthogonality()
                );
            }

            System.out.println();
        }
    }
}