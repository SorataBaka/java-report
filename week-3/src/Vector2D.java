class Vector2D {
    public double x;
    public double y;
    Vector2D(double newX, double newY){
        this.x = newX;
        this.y = newY;
    }
    void print(){
        System.out.println(String.format("X=%.02f", this.x));
        System.out.println(String.format("Y=%.02f", this.y));
        return;
    }
    double magnitude(){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
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
    void subtract(Vector2D subtractionVector){
        this.x -= subtractionVector.x;
        this.y -= subtractionVector.y;
    }
    double innerProduct(Vector2D secondVector){
        return (this.x * secondVector.x) + (this.y * secondVector.y);
    }
}