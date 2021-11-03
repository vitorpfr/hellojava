package optional.userprofileexamplenew;

public class User {
    String name;
    Id id;

    public User(String name, Id id) {
        this.name = name;
        this.id = id;
    }

    static class Id {
        int number;

        public Id(int number) {
            this.number = number;
        }
    }
}
