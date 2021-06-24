class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String plot() {
        return "No plot here";
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

    @Override
    public String plot() {
        return "A shark eats lots of people";
    }
}

class IndependenceDay extends Movie {
    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to take over planet earth";
    }
}

class MazeRunner extends Movie {
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try and escape a maze";
    }
}

class StarWars extends Movie {
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial forces try to take over the universe";
    }
}

class Forgettable extends Movie {
    public Forgettable() {
        super("Forgettable");
    }

    // No plot method here
}

public class Main {
    public static void main(String[] args) {
        // gets a random movie and displays it
        for (int i = 0; i < 11; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie #" + i + ": " + movie.getName() + "\n" +
            "Plot: " + movie.plot() + "\n");
        }
        // movie.plot() is the core of how polymorphism works. What it does:
        // - looks at the movie object
        // - if it has a plot() method, executes it
        // - however, if it doesn't (as the Forgettable class), Java executes the method from the parent (inherited) class
    }

    // this is a great feature of polymorphism as well - randomMovie() says it will return a Movie, but it actually returns the child classes (Jaws, etc...)
    public static Movie randomMovie() {
        // random number between 1 and 5
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("random number generated was: " + randomNumber);

        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgettable();
            default:
                return null;
        }
    }
}
