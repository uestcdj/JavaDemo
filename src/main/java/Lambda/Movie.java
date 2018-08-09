package Lambda;

public class Movie {
    private String name;
    private double rating;
 
    public Movie(String n, double r) {
        this.name = n;
        this.rating = r;
    }
 
    public double getRating() { return rating; }
    public String getName() { return name; }
   
    @Override
    public String toString() { return "{" + name + ", " + rating + "}"; }
}