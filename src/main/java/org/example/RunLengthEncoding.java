package org.example;

/*
	Convert a string as given in the format below:
    Example:
    aabbb into a2b3
    aaaa into a4
    a into a1
*/

class RunLengthEncoding {
    public static void main(String[] args) {
        String input = "aabbb", result = encodeString(input);
        System.out.println("Encoded String = " + result);
    }

    protected static String encodeString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        if (!str.isEmpty())
            sb.append(str.charAt(str.length() - 1)).append(count);
        else
            sb.append("INVALID INPUT");
        return sb.toString();
    }
}
