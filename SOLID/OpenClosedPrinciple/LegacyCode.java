package OpenClosedPrinciple;

class HashGenerator {

    public String generateHash(String value, String algorithm) {
        if (algorithm.equals("MD5")) {
            return md5(value);
        } 
        else if (algorithm.equals("SHA1")) {
            return sha1(value);
        } 
        else {
            throw new IllegalArgumentException("Unsupported algorithm");
        }

    }
    private String md5(String value) {
        return "md5hash";
    }

    private String sha1(String value) {
        return "sha1hash";
    }

}
