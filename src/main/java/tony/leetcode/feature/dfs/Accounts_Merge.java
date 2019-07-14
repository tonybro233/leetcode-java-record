package tony.leetcode.feature.dfs;

import java.util.*;

// 721. 账户合并
// 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，
// 其中第一个元素accounts[i][0] 是名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
//
// 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。
// 请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。
// 一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
//
// 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。
// accounts 本身可以以任意顺序返回。
//
// 例子 1:
// Input:
// accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
// Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
// Explanation:
//   第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
//   第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
//   我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//   ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
//
// 注意：
// accounts的长度将在[1，1000]的范围内。
// accounts[i]的长度将在[1，10]的范围内。
// accounts[i][j]的长度将在[1，30]的范围内。

public class Accounts_Merge {

    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        // 对每个email构建对应的账号列表
        Map<String, List<Integer>> mailMap = new HashMap<>();
        int len = accounts.size();
        for (int i = 0;i < len;i++){
            String name = accounts.get(i).get(0);
            int size= accounts.get(i).size();
            final int ii = i;
            for (int j = 1;j < size;j++){
                mailMap.compute(accounts.get(i).get(j), (s, list) -> {
                    if (null == list){
                        list = new ArrayList<>();
                    }
                    list.add(ii);
                    return list;
                });
            }
        }

        // 利用dfs合并账户
        List<List<String>> result = new ArrayList<>();
        boolean[] mark = new boolean[len];
        for (int i = 0; i < len;i++){
            singleTime = new HashSet<>();
            dfs(i, mark, accounts, mailMap);
            if (!singleTime.isEmpty()) {
                singleTime.remove(accounts.get(i).get(0));
                List<String> list = new ArrayList<>(singleTime);
                Collections.sort(list);
                list.add(0, accounts.get(i).get(0));
                result.add(list);
            }
        }

        return result;
    }

    private Set<String> singleTime ;

    private void dfs(int idx, boolean[] mark, List<List<String>> accounts, Map<String, List<Integer>> mailMap){
        if (mark[idx]){
            return;
        }
        mark[idx] = true;
        singleTime.addAll(accounts.get(idx));
        int len = accounts.get(idx).size();
        for (int i = 1;i < len;i++){
            List<Integer> list = mailMap.get(accounts.get(idx).get(i));
            for (Integer ea : list){
                dfs(ea, mark, accounts, mailMap);
            }
        }
    }


    // 超时
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set<String>>> record = new HashMap<>();
        for (List<String> account : accounts) {
             String name = account.get(0);
            Set<String> set = new HashSet<>();
            for (int i = 1;i < account.size();i++){
                set.add(account.get(i));
            }
            record.compute(name, (s, list) -> {
                if (null == list){
                    list = new ArrayList<>();
                }
                list.add(set);
                return list;
            });
        }

        for (List<Set<String>> list : record.values()) {
            for (int i = list.size()-1;i >= 0;i--){
                for (int j = 0;j < i;j++){
                    HashSet<String> set = new HashSet<>(list.get(j));
                    set.retainAll(list.get(i));
                    if (set.size() > 0){
                        list.get(j).addAll(list.get(i));
                        list.remove(i);
                        break;
                    }
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<Set<String>>> entry : record.entrySet()) {
            for (Set<String> set : entry.getValue()) {
                List<String> list = new ArrayList<>(set);
                Collections.sort(list);
                list.add(0, entry.getKey());
                result.add(list);
            }
        }

        return result;
    }
}
