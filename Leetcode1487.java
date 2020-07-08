// Make file names unique
// done using Hashmaps

class Solution 
{
    public String[] getFolderNames(String[] names) 
    {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < names.length; i++)
        {
            if(hm.containsKey(names[i]))
                names[i] = updateCacheAndGetValue(names[i], hm);
            else
                hm.put(names[i], 1);
        }
        return names;
    }
    public String updateCacheAndGetValue(String str, HashMap<String, Integer> hm)
    {
        int i = hm.get(str);
        String str1 = str + "(" + Integer.toString(i) + ")";
        while(hm.containsKey(str1))
        {
            str1 = str + "(" + Integer.toString(++i) + ")";
        }
        hm.put(str, i+1);
        hm.put(str1, 1);
        return str1;
    }
}
