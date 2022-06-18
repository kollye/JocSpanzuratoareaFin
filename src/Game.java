import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
public class Game {
    public static void main (String [] args){
        Movies filme = new Movies();
        File file = new File ("C:\\Users\\TUF Gaming\\IdeaProjects\\test\\src\\movies.txt");
        try{
            Scanner fileScanner = new Scanner (file);
            while (fileScanner.hasNextLine()){
                Movie film = new Movie();
                film.name = fileScanner.nextLine();
                filme.addMovie(film);
            }
            int randNr = (int) (Math.random() * 10 + 1);
            Movie Film = filme.searchMovie(randNr);
            int l = Film.name.length();
            boolean ver[];
            ver = new boolean [l+3];
            for ( int i = 0 ; i < l ; ++i )
            {
                if (Character.isLetter(Film.name.charAt(i))){
                    ver[i]=false;
                }
                else{
                    ver[i]=true;
                }
            }
            int wrong = 0;
            while ( wrong < 10 )
            {
                System.out.println("You are guessing: ");
                for ( int i = 0 ; i < l ; ++i )
                {
                    if (ver[i] == false)
                        System.out.print("_");
                    else
                        System.out.print(Film.name.charAt(i));
                }
                System.out.println("\nYou have guessed (" + wrong + ") wrong letters." + "\nGuess a letter: ");
                Scanner scan = new Scanner(System.in);
                String lit = scan.nextLine();
                boolean ok = false;
                for ( int i = 0 ; i < l ; ++i )
                {
                    if (Film.name.charAt(i) == lit.charAt(0)) {
                        ok = true;
                        ver[i] = true;
                    }
                }
                if ( ok == false )
                    ++wrong;
                ok = true;
                for ( int i = 0 ; i < l ; ++i )
                {
                    if ( ver[i] == false ){
                        ok = false;
                    }
                }
                if ( ok == true ){
                    break;
                }
            }
            boolean ok = true;
            for ( int i = 0 ; i < l ; ++i )
            {
                if ( ver[i] == false ){
                    ok = false;
                }
            }
            if ( ok == false )
            {
                System.out.println ("You lose!");
            }
            else
            {
                System.out.println ("You win!" + '\n' + "You have guessed " + Film.name + " correctly.");
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("An error occurred.");
        }
    }
}
