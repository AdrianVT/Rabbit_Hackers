import itumulator.executable.DisplayInformation;
import itumulator.executable.Program;
import itumulator.world.Location;
import itumulator.world.World;

import java.awt.*;
import java.util.Random;


public class Main {


    public static void main(String[] args) {
        int size = 15; // størrelsen af vores 'map' (dette er altid kvadratisk)
        int delay = 1000; // forsinkelsen mellem hver skridt af simulationen (i ms)
        int display_size = 800; // skærm opløsningen (i px)

        Program p = new Program(size, display_size, delay); // opret et nyt program
        World world = p.getWorld(); // hiv verdenen ud, som er der hvor vi skal tilføje ting!

        // how they look
        DisplayInformation di = new DisplayInformation(Color.red);
        p.setDisplayInformation(Person.class, di);


        Person person = new Person();
        Location place = new Location(0,1);
        world.setTile(place, person);

        int amount = 10;
        Random r = new Random();
        for(int i = 0; i < amount; i++) {
            int x = r.nextInt(size);
            int y = r.nextInt(size);
            Location l = new Location(x, y);
            // Så længe pladsen ikke er tom, forsøger vi med en ny tilfældig plads:
            while (!world.isTileEmpty(l)) {
                x = r.nextInt(size);
                y = r.nextInt(size);
                l = new Location(x, y);
            }
            // og herefter kan vi så anvende den:
            world.setTile(l, new Person());
        }
        p.show(); // viser selve simulationen
        p.simulate();






    }

}