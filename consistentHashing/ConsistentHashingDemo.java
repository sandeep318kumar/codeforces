import java.util.TreeMap;
import java.util.List;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.zip.CRC32;

class ConsistentHashingDemo {
    private TreeMap<Long, String> ring = new TreeMap<>();
    int vNodes;
    ConsistentHashingDemo(int vNodes, List<String> servers) {
        this.vNodes = vNodes;
        for(String s : servers) {
            addServer(s);
        }
    }

    void addServer(String server) {
        for(int i = 1;i<=vNodes;i++) {
            String name = server + "#"+ i;
            Long hash = getHash(name);
            ring.put(hash, server);
            System.out.println("Server: " + server + " added to ring at this hash: "+ hash);
        }
    }

    void removeServer(String server) {
        for(int i = 1;i<=vNodes;i++) {
            String name = server + "#" + i;
            Long hash = getHash(name);
            ring.remove(hash);
            System.out.println("Server: " + server + " removed from ring at this hash: "+ hash);
        }
    }

    String getServer(String key) {
        if(ring.isEmpty()) return null;
        Long hash = getHash(key);

        SortedMap<Long, String> tailMap = ring.tailMap(hash);
        if(tailMap.isEmpty()) 
            return ring.get(ring.firstKey());
        else 
            return ring.get(tailMap.firstKey());
    }

    Long getHash(String key) {
        CRC32 crc = new CRC32();
        crc.update(key.getBytes());

        return crc.getValue();
    }

    public static void main(String[] args) {
        List<String> servers = Arrays.asList("Server1", "Server2", "Server3", "Server4");
        ConsistentHashingDemo demo = new ConsistentHashingDemo(3, servers);


        List<String> keys = Arrays.asList("Hello", "I", "am", "here", "Bangalore", "Marathahalli", "Order 21451", "Bagmane Capital", "World Tech", "Cube", "Smart", "Massager");
        System.out.println("key mapping with all servers");
        for(String key: keys) {
            System.out.println(key + " : " + demo.getServer(key));
        }
        demo.removeServer("Server1");
        System.out.println("Key mapping after removing server1");
        for(String key: keys) {
            System.out.println(key + " : " + demo.getServer(key));
        }
    }
}