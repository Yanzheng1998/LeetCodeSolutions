class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> toDegree = new HashMap<>();
        for(String s: words){
            for(char c: s.toCharArray()){
                toDegree.put(c,0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i+1].toCharArray();
            int len = Math.min(cur.length, next.length);
            for (int j = 0; j < len; j++) {
                if (cur[j] != next[j]) {
                    if (!graph.containsKey(cur[j])) {
                        graph.put(cur[j],new LinkedList<>());
                    }
                    graph.get(cur[j]).add(next[j]);

                    toDegree.put(next[j], toDegree.get(next[j]) + 1);
                    
                    break;
                }
            }
        }
        
        int totalChar = toDegree.size();
        
        Queue<Character> startPoints = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (Map.Entry<Character, Integer> entry : toDegree.entrySet()) {
            if (entry.getValue() == 0) {
                startPoints.offer(entry.getKey());
            }
        }
        
        while (!startPoints.isEmpty()) {
            char startPoint = startPoints.poll();
            sb.append(startPoint);
            if (graph.containsKey(startPoint)) {
                for (Character endPoint : graph.get(startPoint)) {
                    toDegree.put(endPoint, toDegree.get(endPoint) - 1);
                    if (toDegree.get(endPoint) == 0) {
                        startPoints.offer(endPoint);
                    }
                }
            }
        }
        
        if (sb.length() != totalChar) {
            return "";
        }
        
        return sb.toString();
    }
}
