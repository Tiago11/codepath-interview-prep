public int isPalindrome(String A) {

        if (A == null) {
            return -1;
        }

        // Transform string to all lowercase.
        String Alow = A.toLowerCase();
        // Transform string stripping the non alphanumeric characters.
        String Amod = Alow.replaceAll("[^0-9a-zA-Z]+", "");

        // Reverse the string.
        StringBuilder sb = new StringBuilder(Amod);
        String revA = sb.reverse().toString();

        // If reversed is the same string as the modified one, it's a palindrome.
        return (Amod.equals(revA)) ? 1 : 0;
    }
