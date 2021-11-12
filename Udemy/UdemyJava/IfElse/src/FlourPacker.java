public class FlourPacker {
    public final static int KILOS_PER_BIG_BAG = 5;
    public final static int KILOS_PER_SMALL_BAG = 1;

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        // input validation
        if ((bigCount < 0) || (smallCount < 0) || (goal < 0)) {
            return false;
        }

        // get total weight of bags
        int bigFlourBagWeightKg = bigCount * KILOS_PER_BIG_BAG;
        int smallFlourBagWeightKg = smallCount * KILOS_PER_SMALL_BAG;
        int totalWeightKg = bigFlourBagWeightKg + smallFlourBagWeightKg;

        // if weight is less than goal, we can already discard since it won't pack
        if (totalWeightKg < goal) {
            return false;
        }

        // else (weight is equal or higher than the goal):
        else {
            // calculate the max number of theoretically completely used big flour bags (to avoid over-capping the number of big bags)
            int usedBigFlourBags = goal / 5;

            // the following statement checks if the weight using the "right" amount of big packs at least exceeds the goal (meaning we have enough small packs to cover)
            // detailed explanation:
            // if usedBigFlourBags < bigCount, we don't need to use all big bags we have to pack, and this expression takes this into account by using 'usedBigFlourBags' instead of 'bigCount'
            // if usedBigFlourBags = bigCount, we can actually use all big bags we have to pack, and this expression takes this into account by using 'usedBigFlourBags' (could use any of them)
            // if usedBigFlourBags > bigCount, we are using less big bags that we theoretically could for sure, so the expression below doesn't fully reflect the weight reality.
            // however, for this specific third scenario, given that we know that total weight exceeds the goal, we also know for sure that we have enough small bags to fill a possible gap
            // and this expression will always return true, even though we're not actually using 'usedBigFlourBags' big bags
            return (usedBigFlourBags * KILOS_PER_BIG_BAG) + smallFlourBagWeightKg >= goal;
        }
    }

    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4)); // false
        System.out.println(canPack(1, 0, 5)); // true
        System.out.println(canPack(0, 5, 4)); // true
        System.out.println(canPack(2, 2, 11)); // true
        System.out.println(canPack(-3, 2, 12)); // false
        System.out.println(canPack(2, 0, 9)); // false
        System.out.println(canPack(0, 8, 11)); // false
    }
}
