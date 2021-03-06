package Lambda;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Predicate;

public class LambdaDemo {
	
	static class Collections {
	       public static <T> void removeAll(Collection<T> coll, Predicate<T> pred) {
	              Iterator<T> it = coll.iterator();
	              while (it.hasNext()) {
	                     T t = it.next();
	                     if (pred.test(t)) {
	                            it.remove();
	                     }
	              }
	       }
	}

	 public static void main(String[] args) {
         Collection<Movie> movies = new HashSet<Movie>();
         movies.add(new Movie("The Shawshank Redemption", 9.2));
         movies.add(new Movie("The Dark Knight", 8.9));
         movies.add(new Movie("Black Swan", 8.0));
        
         Collections.removeAll(movies, m -> m.getRating() < 9.0);
//         Collections.removeAll(movies, new Predicate<Movie>() {
//        	 public boolean test(Movie m) {
//        		 return m.getRating() < 9.0;
//        	 }
//         }
//        		 );
        
         System.out.println(movies);
  }
}
