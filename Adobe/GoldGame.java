class GoldGame
{
    public static int findMaxCoins(int[] coin, int i, int j)
    {
        if (i == j) {
            return coin[i];
        }
        if (i + 1 == j) {
            return Integer.max(coin[i], coin[j]);
        }
        int start = coin[i] + Integer.min(findMaxCoins(coin, i + 2, j),findMaxCoins(coin, i + 1, j - 1));
        int end = coin[j] + Integer.min(findMaxCoins(coin, i + 1, j - 1),findMaxCoins(coin, i, j - 2));
        return Integer.max(start, end);
    }
    public static void main(String[] args)
    {
        int[] coin = { 4, 6, 2, 3 };
        System.out.print("The maximum coins collected by player is "+ findMaxCoins(coin, 0, coin.length - 1));
    }
}