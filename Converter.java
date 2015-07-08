import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Converter{
	public static void main(String [] args) throws IOException{
		ArrayList<ArrayList<String>> elements = new ArrayList<ArrayList<String>>();
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
		String line = in.readLine();
		int curr = -1;
		while(line!=null){
			elements.add(new ArrayList<String>());
			curr++;
			String temp = "";
			for(int i = 0; i < line.length(); i++){
				if(line.charAt(i) != ' ')
					temp += line.charAt(i);
				else{
					elements.get(curr).add(temp);
					temp = "";
				}
			}
			line = in.readLine();
		}
		in.close();
		
		curr = 0;
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1])));
		out.write("<table>");
		out.newLine();
		for(ArrayList<String> a:elements){
			out.write("	<tr>");
			out.newLine();
			for(String td:a){
				out.write((curr == 0? "		<th>" : "		<td>")+td+(curr == 0? "</th>" : "</td>"));
				out.newLine();
			}
			out.write("	</tr>");
			out.newLine();
			curr++;
		}
		out.write("</table>");
		out.close();
	}
}