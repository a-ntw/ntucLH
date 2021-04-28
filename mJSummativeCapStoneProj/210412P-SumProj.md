## Array

#### `int partListSum2 = partList.stream().reduce(0, Integer::sum);`
``` java
	@Test
	public void testArray() {

		String[] jarray = new String[3];
		System.out.println("jarray " + jarray.getClass() ); // jarray class [Ljava.lang.String;

		List<String> arrayList = new ArrayList();
		System.out.println("arrayList " + arrayList.getClass() ); // arrayList class java.util.ArrayList
		
        Set setA = new HashSet();
        Set setB = new LinkedHashSet();
        Set setC = new TreeSet();
        
        Set<String> setList = new HashSet<>();
		System.out.println("setList " + setList.getClass() ); // setList class java.util.HashSet
		
		Map<Integer, Integer> map = new HashMap<>();
		System.out.println("map " + map.getClass() );	// map class java.util.HashMap
		  map.put(1, 12);
		  map.put(2, 24);
		  map.put(3, 10);
	  	  int sum = map.values().stream().mapToInt(i->i).sum();
		System.out.println("mapSum: " + sum );			// mapSum: 46
		int sum2 = map.values().stream().reduce(0, Integer::sum);
		System.out.println("mapSum2: " + sum2 ); 		// mapSum2: 46
		
		// Convert Java Set to List
		Set<String> setD = new HashSet<>();
		setD.add("123");
		setD.add("456");
		List<String> list = new ArrayList<>();
		list.addAll(setD);
		System.out.println("list " + list.getClass() ); // list class java.util.ArrayList
		
        
		// from  m9JavaSe2
		List<Integer> partList = new ArrayList<>(3);
        partList.add(1111);
        partList.add(2222);
        partList.add(3333);
        partList.add(4444);
        System.out.println("First Part: " + partList.get(0));	// First Part: 1111
        partList.add(0, 5555);
        System.out.println("First Part: " + partList.get(0));	// First Part: 5555
        int partListSum = partList.stream().mapToInt(i->i).sum();
        System.out.println("partListSum: " + partListSum);		// partListSum: 16665
        // ******* will use this::
        int partListSum2 = partList.stream().reduce(0, Integer::sum);
        System.out.println("partListSum2: " + partListSum2);	// partListSum2: 16665
        
        
        Set <String> set = new TreeSet<> ();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("three"); // not added
        for (String item: set) {
            System.out.println("Item: " + item);
        }
```
---
### ArrayList and print
#### dash.java
``` java
	List<ResPVeh> rlist = new ArrayList<>();
	rlist.add(new ResPVeh(33,333));
	rlist.add(new ResPVeh(66,999));
	rlist.add(new ResPVeh(22,222));

	for (ResPVeh item : rlist) {
		System.out.println("Item: " + item);
	}

	Stream.of(rlist).forEach(s -> System.out.println("::: " + s));
```
#### ResPVeh.java
``` java
public class ResPVeh {
	private int vehId;
	private int reserves;
	public ResPVeh(int i, int j) {
		this.vehId = i;
		this.reserves = j;
	}
	...
```
---
