public class Calculator {
    private Integer a, b, c;

    public Calculator(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Calculator(Integer a) {
        this.a = a;
    }

    public Calculator() {
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getMax() {
       if (a==null) {
           a = Integer.MIN_VALUE;
       }
       if (b==null) {
           b = Integer.MIN_VALUE;
       }
        if (c==null) {
           c = Integer.MIN_VALUE;
        }
        if (a > b && a > c)
            return a;
        if (b > a && b > c)
            return b;
        return c;
    }

    public Integer getMin() {
        if (a==null) {
            a = Integer.MIN_VALUE;
        }
        if (b==null) {
            b = Integer.MIN_VALUE;
        }
        if (c==null) {
            c = Integer.MIN_VALUE;
        }
        if (a < b && a < c)
            return a;
        if (b < a && b < c)
            return b;
        return c;

    }


    public Integer getSum() {
        if (a==null) {
            a = 0;
        }
        if (b==null) {
            b = 0;
        }
        if (c==null) {
            c = 0;
        }
        return a + b + c;
    }

    public Double getAvg() {
     if((a==null && b!=null &&c!=null)||(a!=null && b==null &&c!=null) ||(a!=null && b!=null &&c==null))
        return  ((double)(getSum()) / 2);

     if ((a==null && b==null && c!=null)||(a==null && b!=null && c==null)|| (a!=null && b==null && c==null)){
         return (double)getSum();
     }
        return  ((double)(getSum()) / 3);
    }

    public boolean areAllPositive() {
        if (a==null) {
            a = Integer.MIN_VALUE;
        }
        if (b==null) {
            b = Integer.MIN_VALUE;
        }
        if (c==null) {
            c = Integer.MIN_VALUE;
        }
        if (a > 0 && b > 0 && c > 0)
            return true;
        return false;
    }

    public boolean isAEven() {
        if (a==null) {
            a = Integer.MIN_VALUE;
        }
        if (a % 2 == 0)
            return true;
        return false;
    }
}
