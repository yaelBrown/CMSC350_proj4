import java.util.*;

public class Heirarchy<E> implements DFSActions<E> {
    @Override
    public void cycleDetected() { r.add("*"); }

    @Override
    public void processVertex(DirectedGraph.Vertex ele) { r.add(ele.getName()); }

    @Override
    public void descend(DirectedGraph.Vertex ele) { r.add("("); }

    @Override
    public void ascend(DirectedGraph.Vertex ele) { r.add(")"); }

    public String printHierarchy() {
        String out = "";
        int size = 0;

        while (r.size() > 0) {
            String next = r.peek();
            r.remove();

            if (next == "(") {
                if (r.peek().equals(")")) {
                    r.remove();
                    continue;
                } else if (r.peek().equals("*")) {
                    out = out.concat(r.peek() + " ");
                    r.remove();
                    r.remove();
                    continue;
                }
            }

            if (next.equals("(")) { size++; }
            else if (next.equals(")")) { size--; }

            if (next.equals("(") || next.equals(")")) continue;
            if (next != "*") out = out.concat("\n");
            for (int i = 0; i < size; i++) out = out.concat("\t");

            out = out.concat(next + " ");
        }

        return out + "\n";
    }

    Queue<String> r = new LinkedList<>();

//    public String createHeirarchy(DirectedGraph dGraph) {
//        String out;
//        Object root = null;
//        HashMap<String, Integer> temp = new HashMap<String, Integer>();
//
//        if (dGraph != null) {
//            root = dGraph.adj[0].get(0);
//
//            int anotherCnt = 1;
//            int cnt = 0;
//
//            for (ArrayList e: dGraph.adj) {
//                for (int i = 0; i < e.size(); i++) {
//                    temp.put(e.get(i).toString() + "%" + cnt, anotherCnt);
//                    cnt++;
//                }
//                anotherCnt++;
//            }
//        }
//
//        temp = sortByValue(temp);
//
//        out = root.toString() + "\n";
//
//        for (Map.Entry tEntry : temp.entrySet()) {
//            int tabCnt = (int) tEntry.getValue();
//            String tabs = "";
//            String keyStr = tEntry.getKey().toString();
//            if (keyStr.substring(0, keyStr.indexOf("%")).equals(root)) {
//                continue;
//            } else {
//                for (int i = 0; i < tabCnt; i++) {
//                    tabs = tabs.concat("    ");
//                }
//
//                out = out.concat(tabs + keyStr.substring(0, keyStr.indexOf("%")) + "\n");
//                System.out.println("out = " + out);
//            }
//        }
//
//        return out;
//    }

//    private HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
//
//        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
//
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
//            public int compare(Map.Entry<String, Integer> o1,
//                               Map.Entry<String, Integer> o2)
//            {
//                return (o1.getValue()).compareTo(o2.getValue());
//            }
//        });
//
//        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
//        for (Map.Entry<String, Integer> aa : list) {
//            temp.put(aa.getKey(), aa.getValue());
//        }
//        return temp;
//    }

}