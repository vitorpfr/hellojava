package highlevelapi;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URIandURLs {
    public static void main(String[] args) {
        try {
            // absolute uri
            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");

            // relative uri
//            URI uri = new URI("/catalogue/phones?os=android#samsung");

            // you can add the base of a relative uri to form an absolute uri, which can then be converted to URL
            // in a real-world app, baseUri should be a constant
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI relativeUri1 = new URI("/catalogue/phones?os=android#samsung");
            URI relativeUri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI relativeUri3 = new URI("/stores/locations?zip=12345");
            URI resolvedUri1 = baseUri.resolve(relativeUri1); // same result as 'uri'
            URI resolvedUri2 = baseUri.resolve(relativeUri2);
            URI resolvedUri3 = baseUri.resolve(relativeUri3);

            // convert URI to URL, to actually use it (URI must be absolute to be converted)
            try {
                URL url1 = resolvedUri1.toURL();
                URL url2 = resolvedUri2.toURL();
                URL url3 = resolvedUri3.toURL();
                System.out.println("URL1 = " + url1);
                System.out.println("URL2 = " + url2);
                System.out.println("URL3 = " + url3);


                // if you have the absolute and the base uri, you can convert it back to the relative
                URI relativizedUri = baseUri.relativize(resolvedUri2);
                System.out.println(relativizedUri); // catalogue/tvs?manufacturer=samsung

            } catch (MalformedURLException e) {
                System.out.println("URL malformed: " + e.getMessage());
            }


            // printing all elements of an uri
            System.out.println("-------------------------");
            System.out.println("uri metadata:");
            System.out.println("Scheme = " + uri.getScheme()); // db
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart()); // //username:password@myserver.com:5000/catalogue/phones?os=android
            System.out.println("Authority = " + uri.getAuthority()); // username:password@myserver.com:5000
            System.out.println("User info = " + uri.getUserInfo()); // username:password
            System.out.println("Host = " + uri.getHost()); // myserver.com
            System.out.println("Port = " + uri.getPort()); // 5000
            System.out.println("Path = " + uri.getPath()); // catalogue/phones
            System.out.println("Query = " + uri.getQuery()); // os=android
            System.out.println("Fragment = " + uri.getFragment()); // samsung

        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        }
    }
}
