import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {
    public static void main(String[] args) {
        // reminder: strings are immutable in Java

        String string = "I am a string. Yes, I am."; // this is a string literal - the simplest form of regular expression
        System.out.println(string);

        // replaceAll: receives a pattern to be replaced, and the replacement string
        // replaceFirst: replaces only the first occurrence of the pattern
        System.out.println(string.replaceAll("I", "You"));

        // now using character classes and boundary matches, instead of string literals
        // character class: a wildcard; a set of characters
        // boundary matches: beginning, end of string, word
        String alphanumeric = "abcDeeeF12Ghhjiiiijkl99z";

        // "." matches any character (this replaces everything to "Y")
        System.out.println(alphanumeric.replaceAll(".", "Y")); // YYYYYYYYYYYYYYYYYYYYYYYY

        // ^ is a boundary matcher that matches beginning of string
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY")); // YYYF12Ghhjiiiijkl99z
        // this shows that ^ will only match with beginning of string (final section is unchanged)
        String secondString = alphanumeric + "abcDeee";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY")); // YYYF12Ghhjiiiijkl99zabcDeee

        // $ is a boundary matcher that matches end of string
        System.out.println(alphanumeric.replaceAll("kl99z$", "THE END")); // abcDeeeF12GhhjiiiijTHE END

        // string.matches() method: returns true if pattern matches whole string, false otherwise
        System.out.println(alphanumeric.matches("^hello")); // false
        System.out.println(alphanumeric.matches("^abcDeee")); // false (even though part matches, this method only returns true if whole string matches)
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhjiiii.kl99z")); // true (entire string matches, even with a wildcard)
        System.out.println(alphanumeric.matches("^........................$")); // true (entire string matches, even with a wildcard)

        // if we want to match a set of letters, we can put it within square brackets
        // example: replaces all occurrences of 'a', 'e' and 'i' with "X"
        System.out.println("aeiou".replaceAll("[aei]", "X")); // prints "XXXou"
        System.out.println("aeiou".replaceAll("[aei]", "XY")); // prints "XYXYXYou"

        // what if I want to replace all occurrences of a character [aei], but only if they are followed by a character [fj]?
        System.out.println("aeiouaeiFaeija".replaceAll("[aei][Fj]", "X")); // aeiouaeXaeXa (X replaced both iF and ij)

        // use case of []: replace a word in a string that's either capitalized or not
        System.out.println("harry".replaceAll("[Hh]arry", "Harry")); // returns Harry

        // replace every letter except e and j: use ^ (caret) inside square bracket
        // inside square bracket the caret (^) is a character class, not a boundary matcher - it negates the pattern
        System.out.println(alphanumeric.replaceAll("[^ej]", "X")); // XXXXeeeXXXXXXjXXXXjXXXXX

        // what if we want to replace all characters a-f and 3-8? Use - for ranges
        System.out.println(alphanumeric.replaceAll("[abcdef345678]", "X")); // bad way: XXXDXXXF12Ghhjiiiijkl99z
        System.out.println(alphanumeric.replaceAll("[a-f3-8]", "X")); // good way, same result above

        // what if we want to include capital letters as well? ?i can turn off case sensitivity
        // obs: ?i only works for ascii; for unicode it needs to be ?iu
        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]", "X")); // including capital letters too
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X")); // turns off case sensitivity, same result above

        // replace all the numbers in the string: either [0-9] or \\d character class (matches any number)
        System.out.println(alphanumeric.replaceAll("[0-9]", "X")); // abcDeeeFXXGhhjiiiijklXXz
        System.out.println(alphanumeric.replaceAll("\\d", "X")); // replaces all numbers: same result above

        // replaces all non-numbers with \\D
        System.out.println(alphanumeric.replaceAll("\\D", "X")); // replaces all non-numbers

        // to match whitespace, use character class \\s
        String hasWhiteSpace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhiteSpace.replaceAll("\\s", "")); // Ihaveblanksandatab,andalsoanewline
        // I can also target specific whitespaces such as \t or \n
        System.out.println(hasWhiteSpace.replaceAll("\t", "X")); // I have blanks andXa tab, and also a newline

        // to match non-whitespace chars, use character class \\S
        System.out.println(hasWhiteSpace.replaceAll("\\S", "X")); // X XXXX XXXXXX XXX	X XXXX XXX XXXX X XXXXXXX

        // \\w matches A-Z a-z 0-9 and _
        System.out.println(alphanumeric.replaceAll("\\w", "X")); // XXXXXXXXXXXXXXXXXXXXXXXX
        // \\W has the opposite effect: anything but A-Z a-z 0-9 and _

        // \\b matches the boundaries of each word, making each word to be surrounded by the replacement string
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X")); // XIX XhaveX XblanksX XandX	XaX XtabX, XandX XalsoX XaX XnewlineX
        // use case: surround a string with tags (html, for example)

        // quantifiers specify how often an element can occur in a regular expression
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "YYY")); // same result above

        // if we don't care about how many times (matches with any quantity), use +
        System.out.println(alphanumeric.replaceAll("^abcDe+", "YYY")); // same result above

        // if we want to match if 'e' is present or not (0 or more 'e' chars), use star (*) quantifier
        System.out.println(alphanumeric.replaceAll("^abcDe*", "YYY")); // same result above
        // use case of *: validating user input, and part of the input is optional

        // specify min and max times a character can occur
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "YYY")); // same result above
        System.out.println(alphanumeric.replaceAll("^abcDe{4,6}", "YYY")); // doesn't match (different result)

        // example: replaces a sequence of 1 or more 'h', 0 or more 'i', and 1 'j'
        System.out.println(alphanumeric.replaceAll("h+i*j", "Y")); // replace hhiiij with Y

        // we can use Pattern and Matcher classes to generalize the regex search
        // example: trying to find all h2 occurrences in a html string
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String broadH2Pattern = ".*<h2>.*"; // .* means any character (.), zero or more times (*)

        Pattern pattern = Pattern.compile(broadH2Pattern); // needs to use the broad definition to match
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches()); // true because pattern matches
        System.out.println(pattern.matcher("<h3>").matches()); // false because pattern doesn't match

        // how can we find how many occurrences are there, and where they do occur?
        // using find, start and end methods in the matcher
        // matcher has internal state and can only be used once, it needs to be reset to be used again -> matcher.reset();
        String narrowH2Pattern = "<h2>";
        matcher = Pattern.compile(narrowH2Pattern).matcher(htmlText); // redefining matcher with the narrow pattern, to find occurrences

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        // another possibility is to use group methods with () in the pattern (group 0 is the entire sequence, first group is group 1, etc)
        // pattern below: <h2>, then any number of characters (.*), then </h2>
        // issue: * is a greedy quantifier, which means it grabs as much text as it can between the tags (not what we want)
        // to transform into a lazy quantifier (as soon as it finds a match, considers it an occurrence), use ? in front of *
        System.out.println("---- Getting the whole h2 tag ----");
        String groupH2Pattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(groupH2Pattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches()); // false because our pattern is narrow, doesn't match whole string
        groupMatcher.reset(); // needed to re-use matcher

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        // what if I want just the text between the tags? I can define multiple groups
        System.out.println("---- Getting just the h2 tag text ----");
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        while (h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2)); // group 2 is the text between the tags
        }


        // how to make logical operations in regex?
        // AND
        // "abc" pattern = "a" and "b" and "c"

        // OR
        // "[abc]d" pattern = ("a" or "b" or "c") and "d"
        // another form of or: "[a|b|c]d"

        // NOT
        // [^abc] pattern = match all characters except a, b or c
        // issue: it "consumes" a character, so it needs to have a character in this position to match
        // alternative that doesn't: negative lookahead (?!)
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]"; // we want t that is not followed by v, but it is followed by something else
        String tNotVRegExp = "t(?!v)"; // we want t that is not followed by v, period
        Matcher tNotVMatcher = Pattern.compile(tNotVRegExp).matcher(tvTest);
        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        // positive lookahead (?=):
        // all matches of t followed by v, but we don't want to include v in the match
        // t(?=v)

        //// SOME REAL WORLD EXAMPLES
        // validating a US phone number - ex: (800) 123-4567
        // pattern: ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        // in summary we expect start, 1 '(', 3 numbers, 1 ')', 1 space, 3 numbers, 1 '-', 4 numbers, end
        String phonePattern = "^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$";
        String phone1 = "1234567890"; // no match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // no match
        String phone4 = "(123)456-7890"; // no match

        System.out.println("phone1 = " + phone1.matches(phonePattern));
        System.out.println("phone2 = " + phone2.matches(phonePattern));
        System.out.println("phone3 = " + phone3.matches(phonePattern));
        System.out.println("phone4 = " + phone4.matches(phonePattern));

        // validating Visa credit card numbers
        // pattern: ^4[0-9]{12}([0-9]{3})?$
        // we expect start, 1 number '4', 12 numbers, then 3 optional numbers as a group, end
        String visaPattern = "^4[0-9]{12}([0-9]{3})?$";
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches(visaPattern));
        System.out.println("visa2 " + visa2.matches(visaPattern));
        System.out.println("visa3 " + visa3.matches(visaPattern));
        System.out.println("visa4 " + visa4.matches(visaPattern));




    }
}
