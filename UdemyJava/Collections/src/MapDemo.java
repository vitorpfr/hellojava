import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        // create map
        Map<String, String> languages =  new HashMap<>();

        // add data
        languages.put("Java", "a compiled high-level object-orientated, platform-independent language");
        languages.put("Python", "an interpreted, high-level, object-orientated programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic languagge");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "parentheses");

        // retrieve data by key
        System.out.println(languages.get("Java"));

        // keys are unique; for a same key, old value gets rewritten without an error
        languages.put("Java", "something else");
        System.out.println(languages.get("Java"));

        // .put returns the previous value that was there (null if the key didn't exist before
        System.out.println(languages.put("a", "b"));
        System.out.println(languages.put("a", "ddd"));

        // .containsKey can be used to see if a map contains a key (containsValue works similarly)
        if (languages.containsKey("Java")) {
            System.out.println("Java is already there");
        } else {
            languages.put("Java", "other");
        }
        System.out.println(languages.get("Java"));

        System.out.println("-----------------------------");

        // look at the keys of a map: use .keySet()
        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
        // no order guaranteed in the keys

        System.out.println("-----------------------------");

        // remove a specific key from a map
        // first way: .remove (returns the previous value of the key)
        System.out.println(languages.get("Lisp"));
        System.out.println(languages.remove("Lisp")); // key removed
        System.out.println(languages.get("Lisp"));

        System.out.println("-----------------------------");

        // .remove can also receive two args (key, value) and only removes key if value is equal to value passed
        System.out.println(languages.get("a"));
        System.out.println(languages.remove("a", "bcde")); // not removed, returns false
        System.out.println(languages.get("a"));
        System.out.println(languages.remove("a", "ddd")); // removed, returns true
        System.out.println(languages.get("a"));

        System.out.println("-----------------------------");

        // if trying to remove a non existing key, remove returns null
        System.out.println(languages.remove("aaaaaaaaaaaaaaa"));

        // .replace is similar to .put, but doesn't do anything if key doesn't exist
        languages.put("a", "1");
        languages.replace("a", "2345");
        System.out.println(languages.get("a"));
        languages.replace("b", "this will not be added because the key b doesn't exists");
        System.out.println(languages.get("b"));

        System.out.println("-----------------------------");

        // .replace can also work with three values: key, oldValue and newValue
        // it is like a datomic compareAndSet: only sets key to newValue if it is oldValue currently
        System.out.println(languages.get("a")); // 2345
        System.out.println(languages.replace("a", "555", "666")); // false, because oldValue is wrong
        System.out.println(languages.replace("a", "2345", "5678")); // true, because oldValue is right
        System.out.println(languages.get("a")); // 5678

        // any Object can be stored as key and value, however, best practice is to use String or Integer as key (immutable)

    }
}
