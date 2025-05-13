//Software should be open for extension but closed for modification

package OpenClosedPrinciple;

interface HashStrategy {
    String hash(String value);
}

class MD5Hash implements HashStrategy {
    public String hash(String value) {
        return "md5hash"; 
    }
}

class SHA1Hash implements HashStrategy {
    public String hash(String value) {
        return "sha1hash";
    }
}

class HashGenerator {
    private final HashStrategy strategy;
    public HashGenerator(HashStrategy strategy) {
        this.strategy = strategy;
    }
    public String generateHash(String value) {
        return strategy.hash(value);
    }
}