class Vector2D {
    public double x;
    public double y;
    Vector2D(){
        this.x = 0;
        this.y = 0;
    }
    Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    void print(){
        System.out.println(String.format("X=%.02f", this.x));
        System.out.println(String.format("Y=%.02f", this.y));
        return;
    }
    double calcDistance(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
    static double calcDistance(Vector2D a, Vector2D b){
        this.x
        return Math.sqrt(Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y -  b.y), 2));
    }
    void flipHorizontal(){
        this.y = -1 * this.y;
    }
    void flipVertical(){
        this.x = -1 * this.x;
    }
    void add(Vector2D additionVector){
        this.x += additionVector.x;
        this.y += additionVector.y;
    }
    Vector2D add(Vector2D a, Vector2D b){
        Vector2D newVector = new Vector2D(a.x, a.y);
        newVector.add(b);
        return newVector;
    }
    void subtract(Vector2D subtractionVector){
        this.x -= subtractionVector.x;
        this.y -= subtractionVector.y;
    }
    static Vector2D subtract(Vector2D a, Vector2D b){
        Vector2D newVector = new Vector2D(a.x, a.y);
        newVector.subtract(b);
        return newVector;
    }
    double innerProduct(Vector2D secondVector){
        return (this.x * secondVector.x) + (this.y * secondVector.y);
    }
}