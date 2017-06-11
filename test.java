import acm.program.*;
public class test extends ConsoleProgram {

	
	private NameSurferEntry entry;
	
	public void run(){
		
		entry = new NameSurferEntry(Sam);
		println(entry.getName());
		println(entry.getRank(1));
		println(entry.toString());
	}
	
	private String Sam = "Sam 58 69 99 131 168 236 278 380 467 408 466";

}
