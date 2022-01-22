class ATOI{
    static int genAtoi(char[] str)
    {
        int result = 0;
        int sign = 1;
        int i = 0;
        if (str[0] == '-') {
            sign = -1;
            i++;
        }
        for (; i < str.length; ++i)
            result = result * 10 + str[i] - '0';
        return sign * result;
    }
    public static void main(String[] args)
    {
        char[] str = "123".toCharArray();
        int val = genAtoi(str);
        System.out.println(val);
    }
}