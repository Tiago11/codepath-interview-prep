public int lengthOfLastWord(final String A) {

        if (A == null || A.length() == 0) {
            return 0;
        }

        int lengthLastWord = 0;
        int i = A.length() - 1;

        // Consume all the spaces at the end.
        while (i >= 0 && A.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && A.charAt(i) != ' ') {
            lengthLastWord++;
            i--;
        }

        return lengthLastWord;

    }
