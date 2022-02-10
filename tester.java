import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class tester
{
public static void main(String[] args) throws FileNotFoundException {
//Reading file line by line
File file = new File("/Users/teamshift/Documents/theRaven.txt");
Scanner scan = new Scanner(file);

Map<String,Integer> map = new HashMap<String, Integer>();
while (scan.hasNextLine())
{
String val = scan.nextLine(); // reading line by line
if(map.containsKey(val) == false) 
map.put(val,1);
else {
int count = (int)(map.get(val)); // finding the current frequency of the word
map.remove(val); 
map.put(val,count+1); 
}
Set<Map.Entry<String, Integer>> set = map.entrySet(); // retrieving the map contents
List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set); // make an array list
Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>() 
{
public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) 
{
return (b.getValue()).compareTo( a.getValue() ); 
}
} );
// printing the list
for(Map.Entry<String, Integer> i:sortedList){
System.out.println(i.getKey()+" -> "+i.getValue());
}
}
}