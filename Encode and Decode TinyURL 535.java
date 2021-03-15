/*        
        Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*/
public class Codec {
    
    Map<String,String> longUrls = new HashMap<>();
    
    Map<String,String> shortUrls = new HashMap<>();
    
    private static final String URL = "http://tinyurl.com/";
    
    private static final int SIZE = 5;
    
    

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        if(longUrls.containsKey(longUrl)) {
            return longUrls.get(longUrl);
        }
        
        String temp = getShortUrl(longUrl);
        longUrls.put(longUrl,temp);
        return temp;
        
    }
    
    private String getShortUrl(String longUrl) {
        String newUrl = getRandomString();
        
        while(shortUrls.containsKey(newUrl)) {
            newUrl = getRandomString();
        }
        
        shortUrls.put(newUrl,longUrl);
        return newUrl;
        
    }
    
    private String getRandomString() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(URL);
        
        for(int i=0;i<SIZE;i++) {
            int randomNumber = rand.nextInt(62);
            if(randomNumber<10) {
                sb.append(randomNumber);
            } else {
                sb.append((char) (randomNumber-10+'a'));
            }
        }
        
        return sb.toString();
        
        
        
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
        return shortUrls.containsKey(shortUrl) ? shortUrls.get(shortUrl) : null;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));       
