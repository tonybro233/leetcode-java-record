package tony.leetcode.feature.recursive_search;

import java.util.List;

// 在LeetCode商店中， 有许多在售的物品。
// 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。

// 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
// 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
// 任意大礼包可无限次购买。

// 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
// 输出: 14

// 最多6种物品， 100种大礼包。
// 每种物品，你最多只需要购买6个。
// 你不可以购买超出待购清单的物品，即使更便宜。

public class Shopping_Offers {

    /**
     * 没想到直接用递归枚举比较
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int minsum = 0;
        for (int i = 0;i < price.size();i++){
            minsum += price.get(i) * needs.get(i);
        }

        for (List<Integer> sp : special){
            if (!check(sp,needs)){
                continue;
            }
            for (int j = 0; j < needs.size();j++){
                needs.set(j, needs.get(j) - sp.get(j));
            }

            minsum = Math.min(minsum, sp.get(sp.size()-1) + shoppingOffers(price,special,needs));

            for (int j = 0; j < needs.size();j++){
                needs.set(j, needs.get(j) + sp.get(j));
            }
        }

        return minsum;
    }

    private boolean check(List<Integer> sp, List<Integer> needs){
        for (int i = 0; i < needs.size(); i++){
            if (sp.get(i) > needs.get(i)){
                return false;
            }
        }
        return true;
    }
}
