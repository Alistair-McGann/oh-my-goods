package alistairmcgann;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        Game game = new Game();
        CardFactory factory = new CardFactory();

        for (int i=0; i<5; ++i) {
        	System.out.println( factory.createRandom() );
        }
    }
}
