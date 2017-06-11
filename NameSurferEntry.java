
/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.program.ConsoleProgram;
import acm.util.*;
import java.util.*;

public class NameSurferEntry extends ConsoleProgram implements NameSurferConstants {

	private String Sam = "Sam 58 69 99 131 168 236 278 380 467 408 466";

	/* Constructor: NameSurferEntry(line) */
	/**
	 * Creates a new NameSurferEntry from a data line as it appears in the data
	 * file. Each line begins with the name, which is followed by integers
	 * giving the rank of that name for each decade.
	 */
	public NameSurferEntry(String line) {
		int nameStart = line.indexOf(0);
		int nameEnd = line.indexOf(" ");
		String albumName = line.substring(nameStart, nameEnd);

		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				int entryStart = line.indexOf(" ", nameEnd + 1);
				int entryEnd = line.indexOf(" ", entryStart + 1);
				String rank = line.substring(entryStart,entryEnd);
                rankList[i]=  rank;
                println(rankList[i]);
			} else {
		    entryStart= line.indexOf(" ",entryEnd+1);
		    entryEnd = line.indexOf(" ",entryStart+1);
			String rank = line.substring(entryStart, entryEnd);

			rankList[i]=  rank;		}}
	}

	/* Method: getName() */
	/**
	 * Returns the name associated with this entry.
	 */
	public String getName() {
		// You need to turn this stub into a real implementation //
		return name;
	}

	/* Method: getRank(decade) */
	/**
	 * Returns the rank associated with an entry for a particular decade. The
	 * decade value is an integer indicating how many decades have passed since
	 * the first year in the database, which is given by the constant
	 * START_DECADE. If a name does not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
		return 0;
	}

	/* Method: toString() */
	/**
	 * Returns a string that makes it easy to see the value of a
	 * NameSurferEntry.
	 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		return "";
	
	}
	private int entryStart;
	private int entryEnd;
	private String name;
	public String[] rankList = new String[10];

}
