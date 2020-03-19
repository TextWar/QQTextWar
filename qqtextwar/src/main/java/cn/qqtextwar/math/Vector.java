package cn.qqtextwar.math;

public class Vector implements Computable<Vector>,ScalarProduct<Vector>,Mod,Direction{

    private int x;

    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Vector down(){
        return add(new Vector(0,-1));
    }

    public Vector up(){
        return add(new Vector(0,1));
    }

    public Vector left(){
        return add(new Vector(-1,0));
    }

    public Vector right(){
        return add(new Vector(1,0));
    }

    public Vector add(Vector vector){
        return new Vector(this.x+vector.x,this.y+vector.y);
    }

    public Vector reduce(Vector vector){
        return new Vector(this.x+vector.x,this.y+vector.y);
    }

    @Override
    public double cos(Vector vector) {
        return scalarProduct(vector)/(this.mod()*vector.mod());
    }

    @Override
    public double arcCos(Vector vector,boolean degreeMeasure) {
        double rad =  Math.acos(cos(vector));
        return degreeMeasure?((rad*180)/Math.PI):rad;
    }

    @Override
    public double scalarProduct(Vector vector) {
        return this.x*vector.x+this.y*vector.y;
    }

    @Override
    public double mod() {
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }

    public Vector ratioVector(Vector vector2,double lambda){
        return new Vector((int)((this.x + lambda * vector2.x)/(1+lambda)),(int)((this.y + lambda * vector2.y)/(1+lambda)));
    }

    //相对于一个正方向单位向量的夹角
    @Override
    public double getDirection() {
        return arcCos(new Vector(0,1),false);
    }
}